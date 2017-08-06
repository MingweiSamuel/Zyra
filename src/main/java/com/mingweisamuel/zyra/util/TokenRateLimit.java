package com.mingweisamuel.zyra.util;

import org.asynchttpclient.Response;

/**
 * Represents a App or Method rate limit (collection of buckets).
 * Automatically initializes buckets based off of first request response.
 */
public class TokenRateLimit implements RateLimit {

    /** Header specifying which RateLimitType caused a 429. */
    public static final String HEADER_X_RATE_LIMIT_TYPE = "X-Rate-Limit-Type";
    /** Header specifying retry after time in seconds after a 429. */
    public static final String HEADER_RETRY_AFTER = "Retry-After";

    /** Thread must synchronize on this lock to change bucketsUpdated and buckets. */
    private final Object bucketsLock = new Object();
    /** True after a response has been parsed for the real buckets and buckets has been updated. */
    private volatile boolean bucketsUpdated = false;
    /**
     * By default we allow 1 request per second which is actually 1 requests per two seconds due to the
     * temporal factor of 1. Once a response is successful, we update the buckets to match.
     */
    private volatile TemporalBucket[] buckets = { new TokenTemporalBucket(1000, 1, 1, 0) };

    /** Timestamp to retry after receiving a 429/Retry-After header. */
    private volatile long retryAfterTimestamp = 0;

    /** Type of rate limit, to know what headers to check. */
    private final RateLimitType rateLimitType;
    /** Number of concurrent instances, to divide the rate limits by. */
    private final int concurrentInstances;

    public TokenRateLimit(RateLimitType type, int concurrentInstances, TemporalBucket[] buckets) {
        this(type, concurrentInstances);
        this.buckets = buckets;
        this.bucketsUpdated = true;
    }

    public TokenRateLimit(RateLimitType type, int concurrentInstances) {
        this.rateLimitType = type;
        this.concurrentInstances = concurrentInstances;
    }

    @Override
    public long retryAfterDelay() {
        long now = System.currentTimeMillis();
        // Although we check retryAfterTimestamp twice, the timestamp only increases so the
        // retryAfterTimestamp - now value will still be valid.
        return now > retryAfterTimestamp ? -1 : retryAfterTimestamp - now;
    }

    @Override
    public TemporalBucket[] getBuckets() {
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
            if (rateLimitType.typeName.equals(typeNameHeader)) {
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
        if (bucketsUpdated)
            return;
        synchronized (bucketsLock) {
            if (bucketsUpdated)
                return;
            // Limits: "20000:10,1200000:600"
            // Counts: "7:10,58:600"
            String limitHeader = response.getHeader(rateLimitType.limitHeader);
            String countHeader = response.getHeader(rateLimitType.countHeader);
            if (limitHeader == null || countHeader == null)
                return;
            String[] limits = limitHeader.split(",");
            String[] counts = countHeader.split(",");
            if (limits.length != counts.length)
                throw new RiotResponseException(
                    "Headers did not match: " + limitHeader + " and " + countHeader, response);

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
                    throw new RiotResponseException(
                        "Headers did not match: " + limitHeader + " and " + countHeader, response);

                buckets[i] = new TokenTemporalBucket(limitSpan, limitValue / concurrentInstances, 20, 0.5f);
                buckets[i].getTokens(countValue / (concurrentInstances + 1)); // Account for previous requests.
            }
            this.buckets = buckets;
            bucketsUpdated = true;
        }
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
