package com.mingweisamuel.zyra.util;

import com.mingweisamuel.zyra.RiotApiConfig;
import org.asynchttpclient.Response;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Represents rate limits for a particular region.
 */
public class RegionalRateLimiter {

    /** Configuration information. */
    private final RiotApiConfig config;

    /** Represents the app rate limit. */
    private final TokenRateLimit applicationRateLimit;
    /** Represents method rate limits. */
    private final ConcurrentMap<String, TokenRateLimit> methodRateLimits = new ConcurrentHashMap<>();

    public RegionalRateLimiter(RiotApiConfig config) {
        this.config = config;
        this.applicationRateLimit = new TokenRateLimit(TokenRateLimit.RateLimitType.APPLICATION, config);
    }

    public CompletableFuture<Response> getMethodRateLimited(final String methodId,
        final Supplier<CompletableFuture<Response>> supplier) {

        final TokenRateLimit methodRateLimit = getMethodRateLimit(methodId);

        RateLimitRetrierRunnable runnable = new RateLimitRetrierRunnable(supplier, methodRateLimit);
        runnable.run();
        return runnable.completion;
    }

    public CompletableFuture<Response> getRateLimited(final String methodId,
        final Supplier<CompletableFuture<Response>> supplier) {

        final TokenRateLimit methodRateLimit = getMethodRateLimit(methodId);

        RateLimitRetrierRunnable runnable = new RateLimitRetrierRunnable(supplier, applicationRateLimit, methodRateLimit);
        runnable.run();
        return runnable.completion;
    }

    private TokenRateLimit getMethodRateLimit(String methodId) {
        return methodRateLimits.computeIfAbsent(methodId, id -> new TokenRateLimit(
            TokenRateLimit.RateLimitType.METHOD, config));
    }

    /**
     * HTTP status codes that are considered a "success" in the sense that we did not violate limits
     * and the Riot API did its job without failing. The 20x will be deserialized, wile the 404 and 422
     * will return null.
     *
     * HTTP status codes that are retry-able: 400 (sometimes returned, ?), 429 (with valid retry headers), and
     * all 5xx responses.
     *
     * Other responses will throw a {@link RiotResponseException}.
     */
    private static final int[] RESPONSE_STATUS_SUCCESS = { 200, 204, 404, 422 };

    /**
     * A runnable to wait for rate limits before sending requests and getting responses.
     */
    private class RateLimitRetrierRunnable implements Runnable {

        /** Supplies response asynchronously. */
        private final Supplier<CompletableFuture<Response>> supplier;
        /** Rate limits to obey. */
        private final RateLimit[] rateLimits;

        /** The number of retries. (The first try is 0 retries). */
        private volatile int retries = 0;

        /** Future the response is passed to. */
        final CompletableFuture<Response> completion = new CompletableFuture<>();

        RateLimitRetrierRunnable(Supplier<CompletableFuture<Response>> supplier, RateLimit... rateLimits) {
            this.supplier = supplier;
            this.rateLimits = rateLimits;
        }

        @Override
        public void run() {
            long delay;
            if ((delay = RateLimit.getOrDelay(rateLimits)) < 0) { // Success.
                supplier.get()
                    .thenAccept(r -> {
                        int status = r.getStatusCode();
                        boolean success = 0 <= Arrays.binarySearch(RESPONSE_STATUS_SUCCESS, status);
                        if (config.responseListener != null)
                            config.responseListener.onResponse(success, r);

                        for (RateLimit rateLimit : rateLimits)
                            // If there is a 429 with invalid headers, the rate limiter will throw a RiotResponseException.
                            rateLimit.onResponse(r);

                        if (success) { // Success.
                            completion.complete(r);
                            return;
                        }
                        if (retries >= config.retries ||
                                // Ignore if status can be retried. 400 is iffy.
                                (/*status != 400 &&*/ status != 429 && status < 500)) {

                            throw new RiotResponseException(String.format("Request failed after %d retries (%d).",
                                retries, r.getStatusCode()), r);
                        }
                        // Retry.
                        retries++; // Should be fine to not be synchronized, only one thread in this section.
                        RateLimitedRequester.executor.get().schedule(this, delay, TimeUnit.MILLISECONDS);
                    }).exceptionally(e -> {
                        completion.completeExceptionally(e);
                        return null;
                    });
                return;
            }
            RateLimitedRequester.executor.get().schedule(this, delay, TimeUnit.MILLISECONDS);
        }
    }
}
