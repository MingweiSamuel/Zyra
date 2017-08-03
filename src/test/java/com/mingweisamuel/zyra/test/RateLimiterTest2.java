package com.mingweisamuel.zyra.test;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mingweisamuel.zyra.util.RateLimiter;
import com.mingweisamuel.zyra.util.TemporalTokenBucket;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class RateLimiterTest2 {

    private class FastTimeSupplier implements Supplier<Long> {
        private final double speed;
        private final long start;
        FastTimeSupplier(double speed) {
            this.speed = speed;
            this.start = System.currentTimeMillis();
        }
        @Override
        public Long get() {
            return Math.round((System.currentTimeMillis() - start) * speed);
        }
        public void sleep(long time) throws InterruptedException {
            Thread.sleep((long) Math.floor(time / speed));
        }
    }

    private class DebuggingTimeSupplier implements Supplier<Long> {
        long time = 0;
        void addTime(long n) {
            time += n;
        }
        @Override
        public Long get() {
            return time;
        }
    }

    @Test
    public void maxFast() throws InterruptedException {
        //testMaxFast(10_000, 20, 25, 1.0f);

        testMaxFast(1000, 1500, 20, 0.5f);
        testMaxFast(1000, 2000, 25, 1.0f);
        testMaxFast(10_000, 50_000, 20, 0.25f);
        testMaxFast(10_000, 12_000, 30, 0.25f);

    }

    @Test
    public void maxSimulated() throws InterruptedException {
        int count = 0;
        for (int timespan = 240; timespan <= 15_728_640; timespan *= 8) {
            for (int limit = Math.max(480, timespan); limit <= 15_360; limit *= 4) {
                for (int factor = Math.max(12, timespan / limit); factor <= 48; factor *= 2) {
                    for (float spread = 0; spread <= 1; spread += 0.125) {
                        count++;
                        try {
                            testMaxSimulated(timespan, limit, factor, spread);
                        }
                        catch (AssertionError e) {
                            System.err.println("Timespan: " + timespan + ", Limit: " + limit +
                                ", Factor: " + factor + ", Spread: " + spread);
                            throw e;
                        }
                    }
                }
            }
        }
        System.out.println(count + " simulations run.");
    }

    private void testMaxFast(long timespan, int limit, int factor, float spread) throws InterruptedException {

        final Supplier<Long> timeSupplier = new Supplier<Long>() {
            private final long start = System.currentTimeMillis();
            @Override
            public Long get() {
                return System.currentTimeMillis() - start;
            }
        };

        ConcurrentMap<Long, Integer> limits = new ConcurrentHashMap<>();
        limits.put(timespan / 10, limit / 10);
        final RateLimiter bucket = new RateLimiter(limits);

        int count = (int) (15_000 * limit / timespan);
        List<Long> times = new ArrayList<>(count);

        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++) {
//            futures.add(bucket.acquireAsync().thenAccept(v -> times.add(timeSupplier.get())).handle((v, e) -> {
//                times.add(timeSupplier.get());
//                bucket.release();
//                return null;
//            }));
            bucket.acquire();
            times.add(timeSupplier.get());
            bucket.release();
            //System.out.println(timeSupplier.get());
            //bucket.release();
        }

        System.out.println("debug count " + bucket.count);
        System.out.println("delays " + bucket.delays);


        validate(times, timeSupplier, timespan, limit, true);
    }

    private void testMaxSimulated(long timespan, int limit, int factor, float spread) throws InterruptedException {

        final DebuggingTimeSupplier timeSupplier = new DebuggingTimeSupplier();
        final TemporalTokenBucket bucket = new TemporalTokenBucket(timespan, limit, factor, spread, timeSupplier);

        int count = (int) (30_000 * limit / timespan);
        List<Long> times = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            long delay = bucket.getDelay();
            assertNotEquals("Delay should not be 0.", 0, delay);
            if (delay > 0) {
                timeSupplier.addTime(delay);
            }
            assertTrue("Failed to properly get token, loop " + i, bucket.getToken());
            times.add(timeSupplier.get());
        }

        validate(times, timeSupplier, timespan, limit, false);
    }

    private void validate(List<Long> times, Supplier<Long> timeSupplier, long timespan, int limit, boolean showText) {
        long elapsed = times.get(times.size() - 1) - times.get(0);
        long avg = timespan * times.size() / elapsed;
        long highLimit = elapsed * limit / timespan + limit;
        // the first and last buckets may be grouped towards each other

        int j = 0;
        int loc = 0;
        int max = 0;
        for (int i = 0; i < times.size(); i++) {
            long start = times.get(i);
            long end = start + timespan;
            System.out.println(i + " . " + j + "   " + max);
            for (; j < times.size() && times.get(j) < end; j++) {
                //System.out.println(times.get(j) - start);
//                if (times.get(j) > end)
//                    break;
            }
            if (j - i > max) {
                System.out.println();
                max = j - i;
                loc = i;
            }
        }
        if (showText)
            System.out.println("Timespan: " + timespan + ", Max: " + max + ", Avg: " + avg + ", Limit: " + limit + ", loc: " + loc);
        try {
            assertTrue("Max " + max + " over limit " + limit + ".", max <= limit);
            assertTrue("Max " + max + " less than 95% (" + (limit * 95 / 100) + ").", max >= limit * 95 / 100);
            assertTrue("Avg " + avg + " over high limit " + highLimit + ".", avg <= highLimit);
            assertTrue("Avg " + avg + " less than 90% (" + (limit * 90 / 100) + ").", avg >= limit * 90 / 100);
        }
        catch(AssertionError e) {
            System.out.println(times.subList(loc, loc + max));
            throw e;
        }
    }
}
