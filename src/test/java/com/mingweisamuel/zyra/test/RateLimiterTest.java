package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.util.RateLimiter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

/**
 * Basic RateLimiter tests
 */
public class RateLimiterTest {

    private static final ConcurrentMap<Long, Integer> limits = new ConcurrentHashMap<>();
    static {
        limits.put(2_000L, 5);
        limits.put(4_000L, 8);
    }

    @Test(timeout=1_000)
    public void test1() throws InterruptedException {
        final RateLimiter rateLimiter = new RateLimiter(limits);
        final long startTime = System.currentTimeMillis();

        rateLimiter.acquire();
        assertDelayed(startTime, 0, 0);
        rateLimiter.release();
    }

    @Test(timeout=5_000)
    public void test10() throws InterruptedException {
        final RateLimiter rateLimiter = new RateLimiter(limits);
        final long startTime = System.currentTimeMillis();

        int i = 0;
        for (; i < 5; i++) {
            rateLimiter.acquire();
            assertDelayed(startTime, 0, i);
            rateLimiter.release();
        }
        for (; i < 8; i++) {
            rateLimiter.acquire();
            assertDelayed(startTime, 2_000, i);
            rateLimiter.release();
        }
        for (; i < 10; i++) {
            rateLimiter.acquire();
            assertDelayed(startTime, 4_000, i);
            rateLimiter.release();
        }
    }

    @Test(timeout=5_000)
    public void test10async() throws ExecutionException, InterruptedException {
        final RateLimiter rateLimiter = new RateLimiter(limits);
        final long startTime = System.currentTimeMillis();

        int[] delays = new int[5];

        CompletableFuture[] tasks = IntStream.range(0, 10)
                .mapToObj(i -> rateLimiter.acquireAsync().whenComplete((v, t) -> rateLimiter.release())
                        .thenAccept(v -> delays[(int) getDelay(startTime) / 1000]++))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(tasks).get();

        Assert.assertArrayEquals(Arrays.toString(delays), new int[]{5, 0, 3, 0, 2}, delays);
    }

    public static long getDelay(long startTime) {
        return System.currentTimeMillis() - startTime;
    }

    public static void assertDelayed(long startTime, long expected, int i) {
        Assert.assertEquals(i + " failed.", expected * 1.001, getDelay(startTime), 50);
    }
}
