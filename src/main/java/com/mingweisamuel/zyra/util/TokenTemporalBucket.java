package com.mingweisamuel.zyra.util;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * {@inheritDoc}
 *
 * <p>A circular buffer keeps track of tokens. The value of each buffer index represents the number of requests
 * sent during that time period and as time passes, old indices are zeroed and the current index advances. The
 * entire length of the buffer minus one represents a entire timespan (each index represents a fraction of the
 * total timespan). The extra index prevents violations due to bucket misalignment. A rolling total is kept of
 * the buffer's contents.
 *
 * <p>When trying to obtain a token, we first check the rolling total is less than the limit. If so, we obtain
 * a token by incrementing the rolling total and incrementing the buffer's current index.</p>
 *
 * <p>The length of the buffer is one more than the temporal factor supplied to the constructor. The temporal
 * factor represents the multiplicative increase in temporal resolution provided with more buffer indices.</p>
 *
 * <p>Additionally, a non-zero spreading factor can be provided to prevent a single index from supplying all of
 * a timespan's tokens. A spreading factor of 0.0 means no spreading, a factor of 0.5 means each index can
 * supply up to half of the tokens, and a factor of 1.0 means tokens will be evenly supplied by all indices
 * (provided there is enough demand).</p>
 *
 * <p>Checking the availability of tokens is done using the {@link #getDelay()} method. Tokens are obtained
 * using the {@link #getToken()} method. Both these methods are synchronized on the bucket instance. Because
 * the state of the bucket may change if there are multiple threads, it is best to call these methods in a
 * synchronized block, as shown below.</p>
 *
 * <pre>
 * {@code
 *      TokenTemporalBucket bucket = ...;
 *      while (true) {
 *          long delay;
 *          synchronized (bucket) {
 *              delay = bucket.getDelay();
 *              if (delay == -1) {
 *                  bucket.getToken();
 *                  break;
 *              }
 *          }
 *          // Waiting is done outside of the synchronized block.
 *          Thread.sleep(delay);
 *      }
 *      // Token is obtained.
 *      ...
 * }
 * </pre>
 */
public class TokenTemporalBucket extends TemporalBucket {

    /** A time supplier. A simulated supplier can be used for debugging purposes. */
    private final Supplier<Long> timeSupplier;

    /** The timespan of this bucket. */
    private final long timespan;
    /** The raw number of tokens per timespan, used for the {@link #getTotalLimit()}. */
    private final int totalLimit;

    /** The maximum number of tokens that can be supplied per timespan. */
    private final int adjustedTotalLimit;
    /** The maximum number of tokens a single index can supply per timespan. */
    private final int indexLimit;
    /** The timespan represented by a single index. */
    private final long indexTimespan;

    /** Circular buffer storing the number of tokens supplied by each index, corresponding to a section of the
     * total time span. */
    private final int[] buffer;
    /** The rolling total of tokens supplied. */
    private volatile int total = 0;
    /** The millisecond timestamp corresponding to the most recent update of the buffer. */
    private volatile long time = -1;

    /**
     * Creates a instance using System::currentTimeMillis as the time supplier.
     * @param timespan The time per bucket in milliseconds.
     * @param totalLimit The maximum number of tokens provided per timespan.
     * @param temporalFactor Temporal multiplier corresponding to token time tracking.
     * @param spreadFactor Factor corresponding to token supply spread (from multiple indices).
     * @param totalLimitFactor Factor to multiply adjustedTotalLimit by to decrease the chance of hitting the
     *     rate limit.
     */
    public TokenTemporalBucket(long timespan, int totalLimit, int temporalFactor, float spreadFactor,
        float totalLimitFactor) {

        this(timespan, totalLimit, temporalFactor, spreadFactor, totalLimitFactor, System::currentTimeMillis);
    }

    /**
     * Creates a instance with a custom time supplier.
     * @param timespan The time per bucket in milliseconds.
     * @param totalLimit The maximum number of tokens provided per timespan.
     * @param temporalFactor Temporal multiplier corresponding to token time tracking.
     * @param spreadFactor Factor corresponding to token supply spread (from multiple indices).
     * @param totalLimitFactor Factor to multiply adjustedTotalLimit by to decrease the chance of hitting the
     *     rate limit.
     * @param timeSupplier Supplies non-descending millisecond time, useful for debugging.
     */
    public TokenTemporalBucket(long timespan, int totalLimit, int temporalFactor, float spreadFactor,
        float totalLimitFactor, Supplier<Long> timeSupplier) {

        this.timeSupplier = timeSupplier;

        this.timespan = timespan;
        this.totalLimit = totalLimit;

        this.adjustedTotalLimit = (int) (totalLimit * totalLimitFactor);
        this.indexLimit = (int) (totalLimit * totalLimitFactor / spreadFactor / temporalFactor);
        this.indexTimespan = (long) Math.ceil(timespan / (double) temporalFactor);

        this.buffer = new int[temporalFactor + 1];
    }

    @Override
    public synchronized long getDelay() {
        int index = update();
        if (total < adjustedTotalLimit) {
            if (buffer[index] >= indexLimit)
                return getTimeToBucket(1);
            return -1;
        }

        // check how soon into the future old buckets will be zeroed, making requests available.
        int i = 1;
        for (; i < buffer.length; i++) {
            if (buffer[(index + i) % buffer.length] > 0)
                break;
        }
        return getTimeToBucket(i);
    }

    @Override
    public synchronized boolean getTokens(int n) {
        int index = update();
        buffer[index] += n;
        total += n;
        return total <= adjustedTotalLimit && buffer[index] <= indexLimit;
    }

    @Override
    public long getTimespan() {
        return timespan;
    }

    @Override
    public int getTotalLimit() {
        return totalLimit;
    }

    /**
     * Updates the circular buffer and {@link #time} to match the passage of time.
     * @return The current index.
     */
    private synchronized int update() {
        // The first time this is called, we initialize the time.
        if (time < 0) {
            time = timeSupplier.get();
            return getIndex(time);
        }
        int index = getIndex(time);
        int length = getLength(time, (time = timeSupplier.get()));

        if (length < 0)
            throw new IllegalStateException("Length should be non-negative: " + length);
        if (length == 0)
            return index;
        if (length >= buffer.length) {
            Arrays.fill(buffer, 0);
            total = 0;
            return index;
        }
        for (int i = 0; i < length; i++) {
            index++;
            index %= buffer.length;
            total -= buffer[index];
            buffer[index] = 0;
        }
        if (getIndex(time) != index)
            throw new IllegalStateException("Get index time: " + getIndex(time) + ", index: " + index);
        return index;
    }


    /**
     * @param n Number of buckets in the future to look (n=1 -> next bucket).
     * @return Time until the next nth bucket in milliseconds.
     */
    private long getTimeToBucket(int n) {
        return n * indexTimespan - (time % indexTimespan);
    }
    /**
     * Gets the circular buffer index corresponding to a particular timestamp.
     * @param timestamp Millisecond timestamp.
     * @return Buffer index.
     */
    private int getIndex(long timestamp) {
        return (int) ((timestamp / indexTimespan) % buffer.length);
    }
    /**
     * Gets the index distance between two timestamps. Because the buffer is circular, the distance between
     * indices may be greater than the length of the buffer.
     * @param startTimestamp Start millisecond timestamp.
     * @param endTimestamp End millisecond timestamp.
     * @return The index distance. May be greater than the length of the buffer.
     */
    private int getLength(long startTimestamp, long endTimestamp) {
        return (int) (endTimestamp / indexTimespan - startTimestamp / indexTimespan);
    }

    /** Returns the default hashCode() which is the memory address. Enforce address-based sorting. */
    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        return this == obj;
    }
}
