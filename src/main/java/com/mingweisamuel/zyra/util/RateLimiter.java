package com.mingweisamuel.zyra.util;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Rate limiter.
 */
public class RateLimiter {
    /** A scheduler used to wait for async delays. */
    private static final Lazy<ScheduledExecutorService> executor = new Lazy<>(
            () -> new ScheduledThreadPoolExecutor(2, new ThreadFactoryBuilder().setDaemon(true).build()));

    /** Provides current date (Allows for fast debugging). */
    private final DateTimeProvider dateTimeProvider;

    /** Lock to prevent multiple threads from entering the block. */
    private final Object lock = new Object();

    /** Readonly map of timespan to max requests. */
    private final ConcurrentMap<Long, Integer> rateLimits;
    /** Map of timespan to when the timespan started. */
    private final ConcurrentMap<Long, Long> initialRequests = new ConcurrentHashMap<>();
    /** Map of timespan to the number of requests since the initial request. */
    private final ConcurrentMap<Long, Integer> requestCounts = new ConcurrentHashMap<>();

    /** Retry after delay. */
    private volatile long retryAfterTimestamp = 0;

    /** Number of milliseconds to retry after if the concurrent request limit is reached. */
    public static final int CONCURRENT_REQUESTS_RETRY_INTERVAL = 20;
    /** The default number of concurrent requests allowed. */
    public static final int CONCURRENT_REQUESTS_DEFAULT_MAX = 2;
    /** Default concurrent requests for production keys. */
    public static final int CONCURRENT_REQUESTS_PRODUCTION_MAX = 25;
    /** The semaphore for limiting the number of concurrent requests. */
    private final Semaphore concurrentRequestSemaphore;

    /**
     * Creates a RateLimiter with the specified rate limits. DateTimeProvider defaults to System::currentTimeMillis.
     * @param rateLimits A map where the keys represent time spans in milliseconds and the values represent the maximum
     *                   number of requests allowed to pass through during the time span.
     */
    public RateLimiter(ConcurrentMap<Long, Integer> rateLimits) {
        this(rateLimits, CONCURRENT_REQUESTS_DEFAULT_MAX);
    }

    /**
     * Creates a RateLimiter with the specified rate limits. DateTimeProvider defaults to System::currentTimeMillis.
     * @param rateLimits A map where the keys represent time spans in milliseconds and the values represent the maximum
     *                   number of requests allowed to pass through during the time span.
     * @param maxConcurrentRequests The maximum number of concurrent requests allowed.
     */
    public RateLimiter(ConcurrentMap<Long, Integer> rateLimits, int maxConcurrentRequests) {
        this(rateLimits, maxConcurrentRequests, System::currentTimeMillis);
    }

    /** Creates a RateLimiter with the specified rate limits and dateTimeProvider.
     * @param rateLimits A map where the keys represent time spans in milliseconds and the values represent the maximum
     *                   number of requests allowed to pass through during the time span.
     * @param concurrentRequestsMax The maximum number of concurrent requests allowed.
     * @param dateTimeProvider A dateTimeProvider to provide the current time. Useful for debugging/unit testing.
     */
    public RateLimiter(ConcurrentMap<Long, Integer> rateLimits, int concurrentRequestsMax, DateTimeProvider dateTimeProvider) {
        this.rateLimits = rateLimits;
        this.concurrentRequestSemaphore = new Semaphore(concurrentRequestsMax);
        this.dateTimeProvider = dateTimeProvider;
    }

    /**
     * @return A CompletableFuture that will complete when the request can continue.
     */
    public CompletableFuture<Void> acquireAsync() {
        CompletableFuture<Void> result = new CompletableFuture<>();
        acquireAsyncInternal1(result);
        return result;
    }

    /**
     * Passes RESULT to acquireAsyncInternal2 when a lock has been acquired.
     * @param result
     */
    private void acquireAsyncInternal1(CompletableFuture<Void> result) {
        if (concurrentRequestSemaphore.tryAcquire()) {
            acquireAsyncInternal2(result);
            return;
        }
        executor.get().schedule(() -> acquireAsyncInternal1(result),
                CONCURRENT_REQUESTS_RETRY_INTERVAL, TimeUnit.MILLISECONDS);
    }

    /**
     * Completes RESULT when the request can continue.
     * @param result
     */
    private void acquireAsyncInternal2(CompletableFuture<Void> result) {
        long delay;
        // get lock so getDelay() and updateDelay() will be sequential.
        // do not put any blocking or asynchronous operations inside of synchronized (lock)
        synchronized (lock) {
            delay = getDelay();
            if (delay <= 0) {
                updateDelay();
                result.complete(null);
                return;
            }
        }
        executor.get().schedule(() -> acquireAsyncInternal2(result), delay, TimeUnit.MILLISECONDS);
    }

    /**
     * Blocks until no rate limits will be violated.
     * @throws InterruptedException If the thread was interrupted.
     */
    public void acquire() throws InterruptedException {
        long delay;
        concurrentRequestSemaphore.acquire();
        while ((delay = getDelay()) > 0) {
            Thread.sleep(delay);
        }
        updateDelay();
    }


    /**
     * Releases a lock obtained by acquire() or acquireAsync().
     */
    public void release() {
        concurrentRequestSemaphore.release();
    }

    /**
     * Sets the RateLimiter to block for the specified delay.
     * @param delay Amount of time to block for.
     */
    public void setRetryAfter(long delay) {
        synchronized (lock) {
            retryAfterTimestamp = dateTimeProvider.now() + delay;
        }
    }

    /**
     * @return The minimum delay in milliseconds needed to respect rate limits.
     */
    private long getDelay() {
        synchronized (lock) {
            long now = dateTimeProvider.now();
            long delay = 0;

            // update delay to match retryAfterTimestamp if applicable.
            long retryDelay = retryAfterTimestamp - now;
            if (retryDelay > delay)
                delay = retryDelay;

            for (Map.Entry<Long, Integer> requestCountPair : requestCounts.entrySet()) {
                // for each timespan rule.
                long timespan = requestCountPair.getKey();
                int requestCount = requestCountPair.getValue();
                int limit = rateLimits.get(timespan);

                // if requestCount is at the limit, update the delay to match.
                if (requestCount >= limit) {
                    // initialRequest should exist if requestCount exists.
                    long initialRequest = initialRequests.get(timespan);
                    long newDelay = initialRequest + timespan - now;
                    if (newDelay <= 0) {
                        initialRequests.put(timespan, now);
                        requestCounts.put(timespan, 0);
                    }
                    else if (newDelay > delay)
                        delay = newDelay;
                }
            }

            return delay;
        }
    }

    /**
     * Updates the rate limit counters after getDelay() has been waited.
     */
    private void updateDelay() {
        synchronized (lock) {
            long now = dateTimeProvider.now();

            // Operations on the ConcurrentHashMaps don't need to be atomic because only one thread can access the maps at
            // a time because of the Semaphore lock.
            for (Map.Entry<Long, Integer> rateLimit : rateLimits.entrySet()) {
                long timespan = rateLimit.getKey();

                Long initialRequest = initialRequests.get(timespan);
                Integer requestCount = requestCounts.get(timespan);

                if (requestCount == null || initialRequest == null || initialRequest < now - timespan) {
                    initialRequests.put(timespan, now);
                    requestCount = 0;
                }

                requestCounts.put(timespan, requestCount + 1);
            }
        }
    }

    /**
     * Interface for getting the time. Useful to implement for debugging/unit testing.
     */
    @FunctionalInterface
    interface DateTimeProvider {
        /**
         * @return The current time in milliseconds.
         */
        long now();
    }
}
