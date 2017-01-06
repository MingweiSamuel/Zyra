package com.mingweisamuel.zyra.util;

import com.mingweisamuel.zyra.enums.Region;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Param;
import org.asynchttpclient.Response;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * For sending rate-limited requests to the Riot API.
 */
public class RateLimitedRequester extends Requester {

    /** Default retries. */
    private static final int RETRIES_DEFAULT = 3;

    /** Root url for Riot API requests. */
    private static final String RIOT_ROOT_URL = "%s.api.pvp.net/";

    /** Retry-After header name. */
    private static final String HEADER_RETRY_AFTER = "Retry-After";

    /** Responses representing success in the Riot API. Must be in ascending order. */
        private static final int[] STATUS_SUCCESS = {200, 204, 404};

    /** Ten seconds in milliseconds. */
    private static final long TEN_SECONDS = 10_000;
    /** Ten minutes in milliseconds. */
    private static final long TEN_MINUTES = 600_000;
    /** Default rate limit per ten seconds (10). */
    private static final int TEN_SECONDS_DEFAULT_LIMIT = 10;
    /** Default rate limit per ten minutes (500). */
    private static final int TEN_MINUTES_DEFAULT_LIMIT = 500;

    /** Number of times to retry when the request fails, but can still be retried (429, 50*, etc.). */
    private final int retries;

    /** Number of concurrent requests per region. */
    private final int concurrentRequestsMax;

    /** Stores the rate limits to respect. Key is time in milliseconds, value is max requests per that time. */
    private final ConcurrentMap<Long, Integer> rateLimits = new ConcurrentHashMap<>();
    /** Stores the RateLimiter for each Region. */
    private final ConcurrentMap<Region, RateLimiter> rateLimiters = new ConcurrentHashMap<>();

    /** Creates a RateLimitedRequester with APIKEY and the default client and default rate limits. */
    public RateLimitedRequester(String apiKey) {
        super(apiKey);
        rateLimits.put(TEN_SECONDS, TEN_SECONDS_DEFAULT_LIMIT);
        rateLimits.put(TEN_MINUTES, TEN_MINUTES_DEFAULT_LIMIT);
        this.concurrentRequestsMax = RateLimiter.CONCURRENT_REQUESTS_DEFAULT_MAX;
        this.retries = RETRIES_DEFAULT;
    }

    public RateLimitedRequester(String apiKey, int rateLimitPer10Seconds, int rateLimitPer10Minutes) {
        super(apiKey);
        rateLimits.put(TEN_SECONDS, rateLimitPer10Seconds);
        rateLimits.put(TEN_MINUTES, rateLimitPer10Minutes);
        this.concurrentRequestsMax = RateLimiter.CONCURRENT_REQUESTS_DEFAULT_MAX;
        this.retries = RETRIES_DEFAULT;
    }

    public RateLimitedRequester(String apiKey, Map<Long, Integer> rateLimits) {
        super(apiKey);
        rateLimits.putAll(rateLimits);
        this.concurrentRequestsMax = RateLimiter.CONCURRENT_REQUESTS_DEFAULT_MAX;
        this.retries = RETRIES_DEFAULT;
    }

    public RateLimitedRequester(String apiKey, Map<Long, Integer> rateLimits, AsyncHttpClient client, int retries,
            int concurrentRequestsMax) {
        super(apiKey, client);
        rateLimits.putAll(rateLimits);
        this.retries = retries;
        this.concurrentRequestsMax = concurrentRequestsMax;
    }

    public Response getRequestRateLimited(String relativeUrl, Region region, Param... params)
            throws RiotResponseException {
        final RateLimiter limiter = getRateLimiter(region);
        try {
            limiter.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Response result = null;
        int i = 0;
        try {
            for (; i < retries; i++) {
                result = super.getRequest(String.format(RIOT_ROOT_URL, region), relativeUrl, params);
                // if response was successful, return response
                if (Arrays.binarySearch(STATUS_SUCCESS, result.getStatusCode()) >= 0)
                    return result;
                // if response has Retry-After header, set rateLimiter's retry after.
                String retryAfter = result.getHeader(HEADER_RETRY_AFTER);
                System.out.println("RetryAfter: " + retryAfter + ", " + result.getHeader("X-Rate-Limit-Count"));
                if (retryAfter != null)
                    limiter.setRetryAfter(Long.parseLong(retryAfter) * 1000 + 50);
                // if the status code is not 429 and not a 5**, or if we are out of retries, throw an exception.
                if (result.getStatusCode() != 429 && result.getStatusCode() < 500)
                    break;
                // otherwise retry request.
            }
        }
        finally {
            limiter.release();
        }
        //noinspection ConstantConditions
        throw new RiotResponseException(String.format("Request failed after %d retries (%d).",
                i, result == null ? -1 : result.getStatusCode()), result);
    }

    public CompletableFuture<Response> getRequestRateLimitedAsync(String relativeUrl, Region region, Param... params) {
        return getRequestRateLimitedAsyncInternal(relativeUrl, region, 0, params);
    }
    private CompletableFuture<Response> getRequestRateLimitedAsyncInternal(
            final String relativeUrl, final Region region, final int retryCount, final Param... params) {
        final RateLimiter limiter = getRateLimiter(region);
        return limiter.acquireAsync()
                .thenCompose(v -> super.getRequestAsync(String.format(RIOT_ROOT_URL, region), relativeUrl, params))
                .whenComplete((r, e) -> limiter.release()) // release limiter regardless of success or failure.
                .thenCompose(r -> {
                    // if response was successful, return response
                    if (Arrays.binarySearch(STATUS_SUCCESS, r.getStatusCode()) >= 0)
                        return CompletableFuture.completedFuture(r);
                    // if response has Retry-After header, set rateLimiter's retry after.
                    String retryAfter = r.getHeader(HEADER_RETRY_AFTER);
                    System.out.println(System.currentTimeMillis() + " - RetryAfter: " + retryAfter + ", " + r.getHeader
                            ("X-Rate-Limit-Count"));
                    if (retryAfter != null)
                        limiter.setRetryAfter(Long.parseLong(retryAfter) * 1000 + 50);
                    // if the status code is not 429 and not a 5**, or if we are out of retries, throw an exception.
                    if (r.getStatusCode() != 429 && r.getStatusCode() < 500 || retryCount >= retries) {
                        throw new RiotResponseException(String.format("Async request failed after %d retries (%d).",
                                retryCount, r.getStatusCode()), r);
                    }
                    // otherwise retry request.
                    return getRequestRateLimitedAsyncInternal(relativeUrl, region, retryCount + 1);
                });
    }

    /**
     * Gets a rate limiter from a region, creating it if needed.
     * @param region Region of rate limiter to get.
     * @return The rate limiter.
     */
    private RateLimiter getRateLimiter(Region region) {
        return rateLimiters.compute(region, (k, v) -> v == null ? new RateLimiter(rateLimits) : v);
    }
}
