package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.util.RateLimiter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

/**
 * Created by Mingw on 2017-01-01.
 */
public class RateLimiterTest {

    public static final ConcurrentMap<Long, Integer> limits = new ConcurrentHashMap();
    static {
        limits.put(2_000L, 5);
        limits.put(4_000L, 8);
    }
    public static RateLimiter rateLimiter;
    public static volatile long startTime;

    @Before
    public void before() {
        rateLimiter = new RateLimiter(limits);
        startTime = System.currentTimeMillis();
    }

    @Test(timeout=1_000)
    public void test1() throws InterruptedException {
        rateLimiter.acquire();
        assertDelayed(0, 0);
    }

    @Test(timeout=5_000)
    public void test10() throws InterruptedException {
        int i = 0;
        for (; i < 5; i++) {
            rateLimiter.acquire();
            assertDelayed(0, i);
        }
        for (; i < 8; i++) {
            rateLimiter.acquire();
            assertDelayed(2_000, i);
        }
        for (; i < 10; i++) {
            rateLimiter.acquire();
            assertDelayed(4_000, i);
        }
    }

    @Test(timeout=5_000)
    public void test10async() throws ExecutionException, InterruptedException {
        int[] delays = new int[5];

        CompletableFuture[] tasks = IntStream.range(0, 10)
                .mapToObj(i -> rateLimiter.acquireAsync().thenAccept(v -> delays[(int) getDelay() / 1000]++))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(tasks).get();

        Assert.assertArrayEquals(Arrays.toString(delays), new int[]{5, 0, 3, 0, 2}, delays);
    }

    public static long getDelay() {
        return System.currentTimeMillis() - startTime;
    }

    public static void assertDelayed(long expected, int i) {
        Assert.assertEquals(i + " failed.", expected * 1.001, getDelay(), 50);
    }
}
