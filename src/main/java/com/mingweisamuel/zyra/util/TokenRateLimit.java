package com.mingweisamuel.zyra.util;

import com.google.common.collect.ImmutableList;
import com.mingweisamuel.zyra.RiotApiConfig;
import org.asynchttpclient.Response;

import java.util.List;

/**
 * Represents a App or Method rate limit (collection of buckets).
 * Automatically initializes buckets based off of first request response.
 */
public class TokenRateLimit implements RateLimit {

    /** Header specifying which RateLimitType caused a 429. */
    public static final String HEADER_X_RATE_LIMIT_TYPE = "X-Rate-Limit-Type";
    /** Header specifying retry after time in seconds after a 429. */
    public static final String HEADER_RETRY_AFTER = "Retry-After";

    /** Configuration Information. */
    private final RiotApiConfig config;

    /** Thread must synchronize on this lock to change bucketsUpdated and buckets. */
    private final Object bucketsLock = new Object();
    /** True if buckets should not be automatically updated based on response headers. */
    private volatile boolean disableAutoBuckets = false;
    /**
     * By default we allow 1 request per second which is actually 1 requests per two seconds due to the
     * temporal factor of 1. Once a response is successful, we update the buckets to match.
     */
    private volatile ImmutableList<TemporalBucket> buckets = ImmutableList.of(new TokenTemporalBucket(1000, 1, 1, 0, 1));

    /** Timestamp to retry after receiving a 429/Retry-After header. */
    private volatile long retryAfterTimestamp = 0;

    /** Type of rate limit, to know what headers to check. */
    private final RateLimitType rateLimitType;

    public TokenRateLimit(RateLimitType type, RiotApiConfig config) {
        this.rateLimitType = type;
        this.config = config;
    }

    @Override
    public long retryAfterDelay() {
        long now = System.currentTimeMillis();
        // Although we check retryAfterTimestamp twice, the timestamp only increases so the
        // retryAfterTimestamp - now value will still be valid.
        return now > retryAfterTimestamp ? -1 : retryAfterTimestamp - now;
    }

    @Override
    public List<TemporalBucket> getBuckets() {
        return buckets;
    }

    @Override
    public void onResponse(Response response) {
        if (429 == response.getStatusCode()) {
            // Determine if this RateLimit triggered the 429, and set retryAfter accordingly.
            String typeNameHeader = response.getHeader(HEADER_X_RATE_LIMIT_TYPE);
            if (typeNameHeader == null)
                throw new IllegalStateException("429 response did not include " + HEADER_X_RATE_LIMIT_TYPE +
                    ", indicating a failure of the Riot API edge.");
            if (rateLimitType.typeName.equalsIgnoreCase(typeNameHeader)) {
                String retryAfterHeader = response.getHeader(HEADER_RETRY_AFTER);
                if (retryAfterHeader == null)
                    throw new IllegalStateException("429 response triggered by " + rateLimitType.typeName +
                        " missing " + HEADER_RETRY_AFTER + " header, indicating a failure of the Riot API edge.");
                // Because the precision of the retryAfter header is only in seconds, we multiply by 1000
                // and add an additional half-second in case of rounding (for example, the API sometimes returns
                // retry-after 0 seconds).
                retryAfterTimestamp = System.currentTimeMillis() + Long.parseLong(retryAfterHeader) * 1000 + 500;
            }
        }
        if (disableAutoBuckets)
            return;

        String limitHeader = response.getHeader(rateLimitType.limitHeader);
        String countHeader = response.getHeader(rateLimitType.countHeader);
        if (!checkBucketsRequireUpdating(limitHeader, countHeader))
            return;
        synchronized (bucketsLock) {
            if (!checkBucketsRequireUpdating(limitHeader, countHeader))
                return;

            try {
                this.buckets = ImmutableList.copyOf(getBucketsFromHeaders(limitHeader, countHeader));
            }
            catch(IllegalStateException e) {
                throw new RiotResponseException(e, response);
            }
        }
    }

    /**
     * Check if the buckets need updating based on a response and the current buckets.
     * @param limitHeader
     * @param countHeader
     * @return True if needs update, false otherwise.
     */
    private boolean checkBucketsRequireUpdating(String limitHeader, String countHeader) {
        if (limitHeader == null || countHeader == null)
            return false;

        String[] limitStrings = new String[buckets.size()];
        for (int i = 0; i < buckets.size(); i++)
            limitStrings[i] = buckets.get(i).toLimitString();
        String currentLimit = String.join(",", limitStrings);

        // Needs update if headers do not match.
        return !limitHeader.equals(currentLimit);
    }

    /**
     * Returns
     * @param limitHeader
     * @param countHeader
     * @return
     * @throws IllegalArgumentException If headers do not match.
     */
    private TemporalBucket[] getBucketsFromHeaders(String limitHeader, String countHeader) {
        // Limits: "20000:10,1200000:600"
        // Counts: "7:10,58:600"
        String[] limits = limitHeader.split(",");
        String[] counts = countHeader.split(",");
        if (limits.length != counts.length)
            throw new IllegalStateException(
                "Headers did not match: " + limitHeader + " and " + countHeader);

        TemporalBucket[] buckets = new TemporalBucket[counts.length];
        for (int i = 0; i < buckets.length; i++) {
            String limit = limits[i];
            String count = counts[i];
            int limitColon = limit.indexOf(':');
            int countColon = count.indexOf(':');
            int limitValue = Integer.parseInt(limit.substring(0, limitColon));
            long limitSpan = Integer.parseInt(limit.substring(limitColon + 1)) * 1000;
            int countValue = Integer.parseInt(count.substring(0, countColon));
            long countSpan = Integer.parseInt(count.substring(countColon + 1)) * 1000;
            if (limitSpan != countSpan)
                throw new IllegalStateException(
                    "Headers did not match: " + limitHeader + " and " + countHeader);

            buckets[i] = config.temporalBucketFactory.get(limitSpan, limitValue,
                config.concurrentInstanceFactor, config.overheadFactor);
            if (!limit.equals(buckets[i].toLimitString()))
                throw new IllegalStateException(String.format("Temporal bucket factory returned temporal bucket not" +
                    " matching rate limits, expected \"%s\", got \"%s\".", limit, buckets[i].toLimitString()));
            // Account for existing requests.
            buckets[i].getTokens((int) Math.ceil(countValue * config.concurrentInstanceFactor));
        }
        return buckets;
    }

    /** Type of rate limit to know what headers to check. */
    public enum RateLimitType {
        APPLICATION("application", "X-App-Rate-Limit", "X-App-Rate-Limit-Count"),
        METHOD("method", "X-Method-Rate-Limit", "X-Method-Rate-Limit-Count");

        public final String typeName, limitHeader, countHeader;
        RateLimitType(String typeName, String limitHeader, String countHeader) {
            this.typeName = typeName;
            this.limitHeader = limitHeader;
            this.countHeader = countHeader;
        }
    }
}
