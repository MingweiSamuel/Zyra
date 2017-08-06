package com.mingweisamuel.zyra.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.mingweisamuel.zyra.ResponseListener;
import com.mingweisamuel.zyra.enums.Region;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Param;
import org.asynchttpclient.Response;
import org.eclipse.milo.opcua.stack.core.util.AsyncSemaphore;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * For sending rate-limited requests to the Riot API.
 */
public class RateLimitedRequester extends Requester {

    /** A scheduler used to wait for async delays. */
    public static final Lazy<ScheduledExecutorService> executor = new Lazy<>(
        () -> new ScheduledThreadPoolExecutor(2, new ThreadFactoryBuilder().setDaemon(true).build()));

    /** Default retries. */
    public static final int RETRIES_DEFAULT = 3;

    /** The default number of concurrent requests allowed. */
    public static final int CONCURRENT_REQUESTS_DEFAULT_MAX = 1000;

    /** Root url for Riot API requests. */
    private static final String RIOT_ROOT_URL = "%s.api.riotgames.com";

    /** Number of times to retry when the request fails, but can still be retried (429, 50*, etc.). */
    private final int retries;
    /** Number of concurrent instance being run. */
    private final int concurrentInstances;

    /** Lock on number of concurrent requests (global across regions). */
    private final AsyncSemaphore concurrentRequestSemaphore;

    /** Listens to HTTP responses. Can be null. */
    private final ResponseListener responseListener;
    /** Supplied rate limits. Can (should) be null. */
    private final Map<Long, Integer> rateLimits;

    /** Stores the RateLimiter for each Region. */
    private final ConcurrentMap<Region, RegionalRateLimiter> rateLimiters = new ConcurrentHashMap<>();

    /**
     * @param apiKey
     * @param client
     * @param retries
     * @param concurrentRequestsMax
     * @param responseListener Can be null.
     * @param rateLimits Can (should) be null.
     */
    public RateLimitedRequester(String apiKey, AsyncHttpClient client, int retries,
            int concurrentRequestsMax, int concurrentInstances, ResponseListener responseListener,
            Map<Long, Integer> rateLimits) {

        super(apiKey, client);
        this.retries = retries;
        this.concurrentRequestSemaphore = new AsyncSemaphore(concurrentRequestsMax);
        this.concurrentInstances = concurrentInstances;
        this.responseListener = responseListener;
        this.rateLimits = rateLimits;
    }

    public CompletableFuture<Response> getRequestNonRateLimitedAsync(final String methodId,
            final String relativeUrl, final Region region, final List<Param> params) {

        return concurrentRequestSemaphore.acquire().thenCompose(p -> {
            CompletableFuture<Response> result = getRateLimiter(region).getMethodRateLimited(methodId,
                () -> getRequestAsync(String.format(RIOT_ROOT_URL, region.getSubdomain()), relativeUrl, params));
            result.handle((r, e) -> {
                p.release();
                return (Void) null;
            });
            return result;
        });
    }

    public CompletableFuture<Response> getRequestRateLimitedAsync(final String methodId,
            final String relativeUrl, final Region region, final List<Param> params) {

        return concurrentRequestSemaphore.acquire().thenCompose(p -> {
            CompletableFuture<Response> result = getRateLimiter(region).getRateLimited(methodId,
                () -> getRequestAsync(String.format(RIOT_ROOT_URL, region.getSubdomain()), relativeUrl, params));
            result.handle((r, e) -> {
               p.release();
               return (Void) null;
            });
            return result;
        });
    }

    /**
     * Gets a rate limiter from a region, creating it if needed.
     * @param region Region of rate limiter to get.
     * @return The rate limiter.
     */
    private RegionalRateLimiter getRateLimiter(Region region) {
        return rateLimiters.computeIfAbsent(region, r -> rateLimits == null ?
            new RegionalRateLimiter(retries, concurrentInstances, responseListener) :
            new RegionalRateLimiter(retries, concurrentInstances, responseListener, rateLimits));
    }
}
