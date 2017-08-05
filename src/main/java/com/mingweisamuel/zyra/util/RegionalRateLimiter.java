package com.mingweisamuel.zyra.util;

import com.google.common.collect.ObjectArrays;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Param;
import org.asynchttpclient.Response;

import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * Represents rate limits for a particular region.
 */
public class RegionalRateLimiter {

    /** Represents the app rate limit. */
    private final ResponsiveRateLimit applicationRateLimit = new ResponsiveRateLimit(
        ResponsiveRateLimit.RateLimitType.APPLICATION);
    /** Represents method rate limits. */
    private final ConcurrentMap<String, ResponsiveRateLimit> methodRateLimits = new ConcurrentHashMap<>();

    /** A scheduler used to wait for async delays. */
    private static final Lazy<ScheduledExecutorService> executor = new Lazy<>(
        () -> new ScheduledThreadPoolExecutor(2, new ThreadFactoryBuilder().setDaemon(true).build()));

    //TODO RETRIES
    public CompletableFuture<Response> getNonAppRateLimited(final String methodId,
        final Supplier<CompletableFuture<Response>> supplier) {

        final CompletableFuture<Response> result = new CompletableFuture<>();

        Runnable waiter = new Runnable() {
            @Override
            public void run() {
                final ResponsiveRateLimit methodRateLimit = getMethodRateLimit(methodId);
                TemporalTokenBucket[] allBuckets = methodRateLimit.getBuckets();

                long delay;
                if ((delay = TemporalTokenBucket.getAllTokensOrDelay(allBuckets)) < 0) { // Success.
                    supplier.get().thenApply(methodRateLimit::onResponse)
                        .thenApply(result::complete).exceptionally(result::completeExceptionally);
                    return;
                }
                executor.get().schedule(this, delay, TimeUnit.MILLISECONDS);
            }
        };
        waiter.run();

        return result;
    }

    public CompletableFuture<Response> getAppRateLimited(final String methodId,
        final Supplier<CompletableFuture<Response>> supplier) {

        final CompletableFuture<Response> result = new CompletableFuture<>();

        Runnable waiter = new Runnable() {
            @Override
            public void run() {
                TemporalTokenBucket[] appBuckets = applicationRateLimit.getBuckets();
                final ResponsiveRateLimit methodRateLimit = getMethodRateLimit(methodId);
                TemporalTokenBucket[] methodBuckets = methodRateLimit.getBuckets();

                TemporalTokenBucket[] allBuckets = ObjectArrays.concat(
                    appBuckets, methodBuckets, TemporalTokenBucket.class);

                long delay;
                if ((delay = TemporalTokenBucket.getAllTokensOrDelay(allBuckets)) < 0) { // Success.
                    supplier.get().thenApply(applicationRateLimit::onResponse)
                        .thenApply(methodRateLimit::onResponse)
                        .thenApply(result::complete).exceptionally(result::completeExceptionally);
                    return;
                }
                executor.get().schedule(this, delay, TimeUnit.MILLISECONDS);
            }
        };
        waiter.run();

        return result;
    }

    private ResponsiveRateLimit getMethodRateLimit(String methodId) {
        return methodRateLimits.computeIfAbsent(methodId, id -> new ResponsiveRateLimit(
            ResponsiveRateLimit.RateLimitType.METHOD));
    }
}
