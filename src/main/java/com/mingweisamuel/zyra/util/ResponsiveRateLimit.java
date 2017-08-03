package com.mingweisamuel.zyra.util;

import org.asynchttpclient.Response;

/**
 * Represents a App or Method rate limit (collection of buckets).
 * Automatically initializes buckets based off of first request response.
 */
public class ResponsiveRateLimit {

    /** Header specifying which RateLimitType caused a 429. */
    public static final String HEADER_X_RATE_LIMIT_TYPE = "X-Rate-Limit-Type";

    private final Object bucketsLock = new Object();
    private volatile boolean bucketsUpdated = false;
    /**
     * By default we allow 1 request per second which is actually 1 requests per two seconds due to the
     * temporal factor of 1. Once a response is successful, we update the buckets to match.
     */
    private volatile TemporalTokenBucket[] buckets = { new TemporalTokenBucket(1000, 1, 1, 0) };

    private final RateLimitType rateLimitType;

    public ResponsiveRateLimit(RateLimitType type) {
        this.rateLimitType = type;
    }

    public TemporalTokenBucket[] getBuckets() {
        return buckets;
    }

    public Response onResponse(Response response) {
        if (bucketsUpdated)
            return response;
        synchronized (bucketsLock) {
            if (bucketsUpdated)
                return response;
            // Limits: "20000:10,1200000:600"
            // Counts: "7:10,58:600"
            String limitHeader = response.getHeader(rateLimitType.limitHeader);
            String countHeader = response.getHeader(rateLimitType.countHeader);
            if (limitHeader == null || countHeader == null)
                return response;
            String[] limits = limitHeader.split(",");
            String[] counts = countHeader.split(",");
            if (limits.length != counts.length)
                throw new IllegalStateException("Headers did not match: " + limitHeader + " and " + countHeader);

            TemporalTokenBucket[] buckets = new TemporalTokenBucket[counts.length];
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
                    throw new IllegalStateException("Headers did not match: " + limitHeader + " and " + countHeader);

                buckets[i] = new TemporalTokenBucket(limitSpan, limitValue, Math.max(limitValue, 20), 0.5f);
                for (int j = 0; j < countValue; j++)
                    buckets[i].getToken(); // Account for existing tokens.
            }
            this.buckets = buckets;
            bucketsUpdated = true;

            //System.out.println("Rate limit detected: " + limitHeader + " : " + countHeader);
        }
        return response;
    }


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
