package com.mingweisamuel.zyra.util;

import com.mingweisamuel.zyra.ResponseListener;
import com.mingweisamuel.zyra.enums.Region;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Param;
import org.asynchttpclient.Response;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * For sending rate-limited requests to the Riot API.
 */
public class RateLimitedRequester extends Requester {

    /** Default retries. */
    public static final int RETRIES_DEFAULT = 3;

    /** Root url for Riot API requests. */
    private static final String RIOT_ROOT_URL = "%s.api.riotgames.com";

    /** Retry-After header name. */
    private static final String HEADER_RETRY_AFTER = "Retry-After";

    /** Responses representing success in the Riot API. Must be in ascending order. */
    private static final int[] STATUS_SUCCESS = {200, 204, 404, 422};

    /** Ten seconds in milliseconds. */
    public static final long TEN_SECONDS = 10_000;
    /** Ten minutes in milliseconds. */
    public static final long TEN_MINUTES = 600_000;

    /** Number of times to retry when the request fails, but can still be retried (429, 50*, etc.). */
    private final int retries;

    /** Number of concurrent requests per region. */
    private final int concurrentRequestsMax;

    /** Listens to HTTP responses. Can be null. */
    private final Optional<ResponseListener> responseListener;

    /** Stores the rate limits to respect. Key is time in milliseconds, value is max requests per that time. */
    private final ConcurrentMap<Long, Integer> rateLimits = new ConcurrentHashMap<>();
    /** Stores the RateLimiter for each Region. */
    private final ConcurrentMap<Region, RateLimiter> rateLimiters = new ConcurrentHashMap<>();

    public RateLimitedRequester(String apiKey, Map<Long, Integer> rateLimits, AsyncHttpClient client, int retries,
            int concurrentRequestsMax, ResponseListener responseListener) {
        super(apiKey, client);
        this.rateLimits.putAll(rateLimits);
        this.retries = retries;
        this.concurrentRequestsMax = concurrentRequestsMax;
        this.responseListener = Optional.ofNullable(responseListener);
    }

    public CompletableFuture<Response> getRequestNonRateLimitedAsync(
            String relativeUrl, Region region, List<Param> params) {
        return getRequestAsync(String.format(RIOT_ROOT_URL, region.getSubdomain()), relativeUrl, params)
                .toCompletableFuture()
                .thenApply(r -> {
                    if (Arrays.binarySearch(STATUS_SUCCESS, r.getStatusCode()) >= 0) {
                        responseListener.ifPresent(l -> l.onResponse(true, r));
                        return r;
                    }
                    responseListener.ifPresent(l -> l.onResponse(false, r));
                    throw new RiotResponseException(
                            String.format("Non rate limited request failed, no retries (%d). %s",
                                r.getStatusCode(), r.getUri()), r);
                });
    }

    public CompletableFuture<Response> getRequestRateLimitedAsync(
            String relativeUrl, Region region, List<Param> params) {
        return getRequestRateLimitedAsyncInternal(relativeUrl, region, 0, params);
    }
    private CompletableFuture<Response> getRequestRateLimitedAsyncInternal(
            final String relativeUrl, final Region region, final int retryCount, final List<Param> params) {
        final RateLimiter limiter = getRateLimiter(region);
        return limiter.acquireAsync()
                .thenCompose(v -> getRequestAsync(String.format(RIOT_ROOT_URL, region.getSubdomain()),
                    relativeUrl, params))
                .whenComplete((r, e) -> limiter.release()) // release limiter regardless of success or failure.
                .thenCompose(r -> {
                    // if response was successful, return response
                    if (Arrays.binarySearch(STATUS_SUCCESS, r.getStatusCode()) >= 0) {
                        responseListener.ifPresent(l -> l.onResponse(true, r));
                        return CompletableFuture.completedFuture(r);
                    }
                    responseListener.ifPresent(l -> l.onResponse(false, r));
                    // if response has Retry-After header, set rateLimiter's retry after.
                    String retryAfter = r.getHeader(HEADER_RETRY_AFTER);
                    //System.out.println(System.currentTimeMillis() + " - RetryAfter: " + retryAfter + ", " +
                    //        r.getHeader("X-Rate-Limit-Count"));
                    if (retryAfter != null)
                        limiter.setRetryAfter(Long.parseLong(retryAfter) * 1000 + 50);
                    // if the status code is not 429 and not a 5**, or if we are out of retries, throw an exception.
                    if (r.getStatusCode() != 429 && r.getStatusCode() != 400 && r.getStatusCode() < 500
                            || retryCount >= retries) {
                        throw new RiotResponseException(String.format("Async request failed after %d retries (%d).",
                                retryCount, r.getStatusCode()), r);
                    }
                    // otherwise retry request.
                    return getRequestRateLimitedAsyncInternal(relativeUrl, region, retryCount + 1, params);
                });
    }

    /**
     * Gets a rate limiter from a region, creating it if needed.
     * @param region Region of rate limiter to get.
     * @return The rate limiter.
     */
    private RateLimiter getRateLimiter(Region region) {
        return rateLimiters.compute(region, (k, v) -> v == null ? new RateLimiter(rateLimits, concurrentRequestsMax) : v);
    }
}
