package com.mingweisamuel.zyra.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.mingweisamuel.zyra.ResponseListener;
import com.mingweisamuel.zyra.RiotApiConfig;
import com.mingweisamuel.zyra.enums.Region;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Param;
import org.asynchttpclient.Response;
import org.eclipse.milo.opcua.stack.core.util.AsyncSemaphore;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * For sending rate-limited requests to the Riot API.
 */
public class RateLimitedRequester extends Requester {

    /** A scheduler used to wait for async delays. */
    public static final Lazy<ScheduledExecutorService> executor = new Lazy<>(
        () -> new ScheduledThreadPoolExecutor(2, new ThreadFactoryBuilder().setDaemon(true).build()));

    /** Root url for Riot API requests. */
    private static final String RIOT_ROOT_URL = "%s.api.riotgames.com";

    /** Configuration information. */
    private final RiotApiConfig config;

    /** Lock on number of concurrent requests (global across regions). */
    private final AsyncSemaphore concurrentRequestSemaphore;
    /** Stores the RateLimiter for each Region. */
    private final ConcurrentMap<Region, RegionalRateLimiter> rateLimiters = new ConcurrentHashMap<>();

    public RateLimitedRequester(RiotApiConfig config) {
        super(config.apiKey, new DefaultAsyncHttpClient(config.asyncHttpClientConfig));
        this.config = config;
        this.concurrentRequestSemaphore = new AsyncSemaphore(config.maxConcurrentRequests);
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
        return rateLimiters.computeIfAbsent(region, r ->
            new RegionalRateLimiter(config));
    }
}
