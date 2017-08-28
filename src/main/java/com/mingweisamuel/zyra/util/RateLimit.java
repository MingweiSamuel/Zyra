package com.mingweisamuel.zyra.util;

import org.asynchttpclient.Response;

import java.util.List;

public interface RateLimit {

    /**
     * Get delay needed to respect retry-after headers.
     * @return Milliseconds to delay or -1 if none needed. Zero may be returned and more delay less than one
     * millisecond is required.
     */
    long retryAfterDelay();

    /**
     * Get the rate limit's buckets.
     * @return Current buckets.
     */
    List<TemporalBucket> getBuckets();

    /**
     * Callback for when a response returns.
     * @param response Response that applies to this RateLimit.
     */
    void onResponse(Response response);

    /**
     * Ensures that all provided rateLimits can be obeyed, or returns an estimated delay in milliseconds to wait.
     * @param rateLimits Rate limits to obey.
     * @return -1 if success, or a non-negative time to delay in milliseconds.
     */
    static long getOrDelay(RateLimit... rateLimits) {
        long retryAfterDelay = -1;
        for (RateLimit rateLimit : rateLimits) {
            long currentRetryDelay = rateLimit.retryAfterDelay();
            if (currentRetryDelay > retryAfterDelay)
                retryAfterDelay = currentRetryDelay;
        }
        // This may not actually be the minimum time needed to delay, if other rateLimits are at their limit
        // due to reasons besides the retry-after, however we ignore that case for simplicity. If this happens,
        // the request will try again and be delayed again.
        if (retryAfterDelay >= 0)
            return retryAfterDelay;

        // Join all buckets into an array and use TemporalBucket.getAllTokensOrDelay().
        int i = 0;
        for (RateLimit rateLimit : rateLimits)
            i += rateLimit.getBuckets().size();

        TemporalBucket[] allBuckets = new TemporalBucket[i];
        i = 0;
        for (RateLimit rateLimit : rateLimits) {
            for (TemporalBucket bucket : rateLimit.getBuckets())
                allBuckets[i++] = bucket;
        }
        return TemporalBucket.getAllTokensOrDelay(allBuckets);
    }
}
