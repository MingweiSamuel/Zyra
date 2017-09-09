package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.util.TokenTemporalBucket;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TokenTemporalBucketTest {

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
        public long getRealDelay(long delay) {
            return (long) Math.floor(delay / speed);
        }
        public void sleep(long delay) throws InterruptedException {
            Thread.sleep(getRealDelay(delay));
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

    @Ignore("Performance-dependant")
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

        final FastTimeSupplier timeSupplier = new FastTimeSupplier(3);
        final TokenTemporalBucket bucket = new TokenTemporalBucket(timespan, limit, factor, spread, 1f, timeSupplier);

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

        validate(times, timespan, limit, true, true);
    }

    private void testMaxSimulated(long timespan, int limit, int factor, float spread) throws InterruptedException {

        final DebuggingTimeSupplier timeSupplier = new DebuggingTimeSupplier();
        final TokenTemporalBucket bucket = new TokenTemporalBucket(timespan, limit, factor, spread, 1f, timeSupplier);

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

        validate(times, timespan, limit, true, false);
    }

    /**
     * Test that multiple TemporalTokenBuckets can work together without locking.
     */
    @Ignore("Performance-dependant")
    @Test(timeout = 20_000)
    public void testMultipleMaxFast() throws InterruptedException {

        final FastTimeSupplier timeSupplier = new FastTimeSupplier(3);

        final TokenTemporalBucket bucket0 = new TokenTemporalBucket(1000, 100, 20, 0.5f, 1f, timeSupplier);
        final TokenTemporalBucket bucket1 = new TokenTemporalBucket( 800, 300, 20, 0.5f, 1f, timeSupplier);
        final TokenTemporalBucket bucket2 = new TokenTemporalBucket( 600, 100, 20, 0.5f, 1f, timeSupplier);
        final TokenTemporalBucket[] buckets = { bucket0, bucket1, bucket2 };

        final ConcurrentLinkedQueue<Long> times0 = new ConcurrentLinkedQueue<>();
        final ConcurrentLinkedQueue<Long> times1 = new ConcurrentLinkedQueue<>();
        final ConcurrentLinkedQueue<Long> times2 = new ConcurrentLinkedQueue<>();
        @SuppressWarnings("unchecked")
        final ConcurrentLinkedQueue<Long>[] times = new ConcurrentLinkedQueue[] {times0, times1, times2};

        final int[] counts = { 0, 0, 0 };
        final int[] maxes = { 3000, 6000, 1200 };

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);

        class Caller implements Callable<Void> {
            private final int i, i1, i2;
            private Caller(int i, int i1, int i2) {
                this.i = i;
                this.i1 = i1;
                this.i2 = i2;
            }
            @Override
            public synchronized Void call() throws Exception {
                long delay = 0;
                while (counts[i] < maxes[i] &&
                    (delay = TokenTemporalBucket.getAllTokensOrDelay(buckets[i1], buckets[i2])) < 0) {

                    long time = timeSupplier.get();
                    times[i1].add(time);
                    times[i2].add(time);
                    counts[i]++;
                }
                if (counts[i] > maxes[i])
                    throw new IllegalStateException();
                if (counts[i] < maxes[i])
                    executor.schedule(this, timeSupplier.getRealDelay(delay), TimeUnit.MILLISECONDS);
                return null;
            }
        }

        executor.submit(new Caller(0, 0, 1));
        executor.submit(new Caller(1, 1, 2));
        executor.submit(new Caller(2, 2, 0));

        wait:
        while (true) {
            Thread.sleep(500);
            for (int i = 0; i < counts.length; i++) {
                //System.out.println(counts[i] + " : " + maxes[i]);
                if (counts[i] < maxes[i])
                    continue wait;
            }
            break;
        }

        executor.shutdown();
        executor.awaitTermination(50, TimeUnit.MILLISECONDS);

        assertEquals(times0.size(), counts[2] + counts[0]);
        assertEquals(times1.size(), counts[0] + counts[1]);
        assertEquals(times2.size(), counts[1] + counts[2]);

        validate(new ArrayList<>(times0), 1000, 100, false, true);
        validate(new ArrayList<>(times1),  800, 300, false, true);
        validate(new ArrayList<>(times2),  600, 100, false, true);
    }

    public static void validate(List<Long> times, long timespan, int limit, boolean checkMin, boolean showText) {
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
        assertTrue("Avg " + avg + " over high limit " + highLimit + ".", avg <= highLimit);
        if (checkMin) {
            assertTrue("Max " + max + " less than 95% (" + (limit * 95 / 100) + ").", max >= limit * 95 / 100);
            assertTrue("Avg " + avg + " less than 90% (" + (limit * 90 / 100) + ").", avg >= limit * 90 / 100);
        }
    }
}
