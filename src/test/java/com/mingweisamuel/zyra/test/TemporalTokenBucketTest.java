package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.util.TemporalTokenBucket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TemporalTokenBucketTest {

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

    @Test(timeout = 60_000)
    public void maxFast() throws InterruptedException {
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

        final FastTimeSupplier timeSupplier = new FastTimeSupplier(5);
        final TemporalTokenBucket bucket = new TemporalTokenBucket(timespan, limit, factor, spread, timeSupplier);

        int count = (int) (15_000 * limit / timespan);
        List<Long> times = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            long delay;
            while ((delay = bucket.getDelay()) >= 0) {
                timeSupplier.sleep(delay);
            }
            assertTrue("Failed to properly get token, loop " + i, bucket.getToken());
            times.add(timeSupplier.get());
        }

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
        long highLimit = (elapsed / timespan + 1) * limit;
        // the first and last buckets may be grouped towards each other

        int j = 0;
        int max = 0;
        long start = 0;
        for (int i = 0; i < times.size(); i++) {
            long next = times.get(i);
            assertTrue(start <= next);
            start = next;
            long end = start + timespan;
            for (; j < times.size(); j++) {
                if (end <= times.get(j))
                    break;
            }
            if (j - i > max)
                max = j - i;
        }
        if (showText)
            System.out.println("Max: " + max + ", Avg: " + avg + ", Limit: " + limit);
        assertTrue("Max " + max + " over limit " + limit + ".", max <= limit);
        assertTrue("Max " + max + " less than 95% (" + (limit * 95 / 100) + ").", max >= limit * 95 / 100);
        assertTrue("Avg " + avg + " over high limit " + highLimit + ".", avg <= highLimit);
        assertTrue("Avg " + avg + " less than 90% (" + (limit * 90 / 100) + ").", avg >= limit * 90 / 100);
    }
}
