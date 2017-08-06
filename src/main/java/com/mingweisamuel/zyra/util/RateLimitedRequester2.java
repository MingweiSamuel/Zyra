package com.mingweisamuel.zyra.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.mingweisamuel.zyra.ResponseListener;
import com.mingweisamuel.zyra.enums.Region;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Param;
import org.asynchttpclient.Response;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * For sending rate-limited requests to the Riot API.
 */
public class RateLimitedRequester2 extends Requester {

    /** A scheduler used to wait for async delays. */
    public static final Lazy<ScheduledExecutorService> executor = new Lazy<>(
        () -> new ScheduledThreadPoolExecutor(2, new ThreadFactoryBuilder().setDaemon(true).build()));

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

    /** Lock on number of concurrent requests (global across regions). */
    private final Semaphore concurrentRequestSemaphore;

    /** Listens to HTTP responses. Can be null. */
    private final ResponseListener responseListener;

    /** Stores the RateLimiter for each Region. */
    private final ConcurrentMap<Region, RegionalRateLimiter> rateLimiters = new ConcurrentHashMap<>();

    public RateLimitedRequester2(String apiKey, AsyncHttpClient client, int retries,
                                 int concurrentRequestsMax, ResponseListener responseListener) {
        super(apiKey, client);
        this.retries = retries;
        this.concurrentRequestSemaphore = new Semaphore(concurrentRequestsMax);
        this.responseListener = responseListener;
    }

    public CompletableFuture<Response> getRequestNonRateLimitedAsync(
        final String relativeUrl, final Region region, final List<Param> params) {

        return getRateLimiter(region).getMethodRateLimited(relativeUrl,
            () -> getRequestAsync(String.format(RIOT_ROOT_URL, region.getSubdomain()), relativeUrl, params));
    }

    public CompletableFuture<Response> getRequestRateLimitedAsync(
        final String relativeUrl, final Region region, final List<Param> params) {

        return getRateLimiter(region).getRateLimited(relativeUrl,
            () -> getRequestAsync(String.format(RIOT_ROOT_URL, region.getSubdomain()), relativeUrl, params));
    }

    /**
     * Gets a rate limiter from a region, creating it if needed.
     * @param region Region of rate limiter to get.
     * @return The rate limiter.
     */
    private RegionalRateLimiter getRateLimiter(Region region) {
        return rateLimiters.computeIfAbsent(region, r -> new RegionalRateLimiter(retries, responseListener));
    }
}
