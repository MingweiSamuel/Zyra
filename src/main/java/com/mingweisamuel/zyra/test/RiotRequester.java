package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.test.util.RiotResponseException;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * For sending rate-limited requests to the Riot API.
 */
class RiotRequester extends Requester {

    /** Number of times to retry when 429 is returned. */
    private static final int RETRIES_429 = 3;

    /** Root url for Riot API requests. */
    private static final String RIOT_ROOT_URL = "%s.api.pvp.net/";

    /** Retry-After header name. */
    private static final String HEADER_RETRY_AFTER = "Retry-After";

    /** Ten seconds in milliseconds. */
    private static final long TEN_SECONDS = 10_000;
    /** Ten minutes in milliseconds. */
    private static final long TEN_MINUTES = 600_000;
    /** Default rate limit per ten seconds (10). */
    private static final int TEN_SECONDS_DEFAULT_LIMIT = 10;
    /** Default rate limit per ten minutes (500). */
    private static final int TEN_MINUTES_DEFAULT_LIMIT = 500;

    /** Stores the rate limits to respect. Key is time in milliseconds, value is max requests per that time. */
    private final ConcurrentMap<Long, Integer> rateLimits = new ConcurrentHashMap<>();
    /** Stores the RateLimiter for each Region. */
    private final ConcurrentMap<Region, RateLimiter> rateLimiters = new ConcurrentHashMap<>();

    /** Creates a RiotRequester with APIKEY and the default client and default rate limits. */
    RiotRequester(String apiKey) {
        super(apiKey);
        rateLimits.put(TEN_SECONDS + 1000, TEN_SECONDS_DEFAULT_LIMIT - 1);
        rateLimits.put(TEN_MINUTES + 1000, TEN_MINUTES_DEFAULT_LIMIT - 1);
    }

    RiotRequester(String apiKey, int rateLimitPer10Seconds, int rateLimitPer10Minutes) {
        super(apiKey);
        rateLimits.put(TEN_SECONDS, rateLimitPer10Seconds);
        rateLimits.put(TEN_MINUTES, rateLimitPer10Minutes);
    }

    RiotRequester(String apiKey, Map<Long, Integer> rateLimits) {
        super(apiKey);
        rateLimits.putAll(rateLimits);
    }

    RiotRequester(String apiKey, Map<Long, Integer> rateLimits, AsyncHttpClient client) {
        super(apiKey, client);
        rateLimits.putAll(rateLimits);
    }

    public Response getRequestRateLimited(String relativeUrl, Region region) throws RiotResponseException {
        final RateLimiter limiter = getRateLimiter(region);
        try {
            limiter.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Response result = null;
        int i = 0;
        try {
            for (; i < RETRIES_429; i++) {
                result = super.getRequest(String.format(RIOT_ROOT_URL, region), relativeUrl);
                if (result.getStatusCode() == 200)
                    return result;
                String retryAfter = result.getHeader(HEADER_RETRY_AFTER);
                if (retryAfter != null)
                    limiter.setRetryAfter(Long.parseLong(retryAfter));
                if (result.getStatusCode() != 429)
                    break;
            }
        }
        finally {
            limiter.release();
        }
        //noinspection ConstantConditions
        throw new RiotResponseException(String.format("Request failed after %d retries (%d).",
                i, result == null ? -1 : result.getStatusCode()), result);
    }

    public CompletableFuture<Response> getRequestRateLimitedAsync(String relativeUrl, Region region) {
        return getRequestRateLimitedAsyncInternal(relativeUrl, region, 0);
    }
    private CompletableFuture<Response> getRequestRateLimitedAsyncInternal(
            final String relativeUrl, final Region region, final int retries) {
        final RateLimiter limiter = getRateLimiter(region);
        return limiter.acquireAsync()
                .thenCompose(v -> super.getRequestAsync(String.format(RIOT_ROOT_URL, region), relativeUrl))
                .whenComplete((r, e) -> limiter.release()) // release limiter regardless of success or failure.
                .thenCompose(r -> {
                    // if response was successful, return response
                    if (r.getStatusCode() == 200) {
                        return CompletableFuture.completedFuture(r);
                    }
                    // if response has Retry-After header, set rateLimiter's retry after.
                    String retryAfter = r.getHeader(HEADER_RETRY_AFTER);
                    if (retryAfter != null) {
                        System.out.println(System.currentTimeMillis() / 1000 + " retry after hit: " + retryAfter + " " +
                                r.getHeader("X-Rate-Limit-Count"));
                        limiter.setRetryAfter(Long.parseLong(retryAfter));
                    }
                    // if the status code is not 429, or if we are out of retries, throw an exception.
                    if (r.getStatusCode() != 429 || retries >= RETRIES_429) {
                        throw new RiotResponseException(String.format("Async request failed after %d retries (%d).",
                                retries, r.getStatusCode()), r);
                    }
                    // otherwise retry request.
                    return getRequestRateLimitedAsyncInternal(relativeUrl, region, retries + 1);
                });
    }

    private RateLimiter getRateLimiter(Region region) {
        return rateLimiters.compute(region, (k, v) -> v == null ? new RateLimiter(rateLimits) : v);
    }
}
