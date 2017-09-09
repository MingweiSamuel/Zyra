package com.mingweisamuel.zyra;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.mingweisamuel.zyra.util.TemporalBucketFactory;
import com.mingweisamuel.zyra.util.TokenTemporalBucket;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;

/**
 * Immutable configuration object.
 */
public class RiotApiConfig {

    public static final int DEFAULT_RETRIES = 3;
    public static final int DEFAULT_MAX_CONCURRENT_REQUESTS = 1000;
    public static final float DEFAULT_CONCURRENT_INSTANCE_FACTOR = 1.0f;
    public static final float DEFAULT_OVERHEAD_FACTOR = 0.95f;
    public static AsyncHttpClientConfig getDefaultAsyncHttpClientConfig() {
        return new DefaultAsyncHttpClientConfig.Builder().setThreadFactory(
            new ThreadFactoryBuilder().setDaemon(true).build()).build();
    }
    public static TemporalBucketFactory getDefaultTemporalBucketFactory() {
        return (timespan, totalLimit, concurrentInstanceFactor, overheadFactor) ->
            new TokenTemporalBucket(timespan, totalLimit, 20, 0.5f, concurrentInstanceFactor * overheadFactor);
    }

    /** Riot Games API key. */
    public final String apiKey;

    /** Number of times to retry each request. */
    public final int retries;
    /** Maximum number of concurrent requests allowed. */
    public final int maxConcurrentRequests;
    /** Multiplier for using concurrent instances. For example, use 0.25 for 4 concurrent instances
     * equally spread. */
    public final float concurrentInstanceFactor;
    /** Overhead factor to prevent 429s due to noise. */
    public final float overheadFactor;
    /** Response listener or null. Default is null. */
    public final ResponseListener responseListener;
    /** AsyncHttpClientConfig to use to send requests. */
    public final AsyncHttpClientConfig asyncHttpClientConfig;
    /** Factory for creating temporal buckets. */
    public final TemporalBucketFactory temporalBucketFactory;

    private RiotApiConfig(String apiKey, int retries, int maxConcurrentRequests, float concurrentInstanceFactor,
            float overheadFactor, ResponseListener responseListener, AsyncHttpClientConfig asyncHttpClientConfig,
            TemporalBucketFactory temporalBucketFactory) {
        this.apiKey = apiKey;
        this.retries = retries;
        this.maxConcurrentRequests = maxConcurrentRequests;
        this.concurrentInstanceFactor = concurrentInstanceFactor;
        this.overheadFactor = overheadFactor;
        this.responseListener = responseListener;
        this.asyncHttpClientConfig = asyncHttpClientConfig;
        this.temporalBucketFactory = temporalBucketFactory;
    }

    public static Builder builder(String apiKey) {
        return new Builder(apiKey);
    }

    public static class Builder {

        private final String apiKey;

        private int retries = DEFAULT_RETRIES;
        private int maxConcurrentRequests = DEFAULT_MAX_CONCURRENT_REQUESTS;
        private float concurrentInstanceFactor = DEFAULT_CONCURRENT_INSTANCE_FACTOR;
        private float overheadFactor = DEFAULT_OVERHEAD_FACTOR;
        private ResponseListener responseListener = null;
        private AsyncHttpClientConfig asyncHttpClientConfig = null;
        private TemporalBucketFactory temporalBucketFactory = null;

        private Builder(String apiKey) {
            this.apiKey = apiKey;
        }

        public RiotApiConfig build() {
            return new RiotApiConfig(
                apiKey, retries, maxConcurrentRequests, concurrentInstanceFactor, overheadFactor, responseListener,
                asyncHttpClientConfig != null ? asyncHttpClientConfig : getDefaultAsyncHttpClientConfig(),
                temporalBucketFactory != null ? temporalBucketFactory : getDefaultTemporalBucketFactory());
        }

        //region generated
        public String getApiKey() {
            return apiKey;
        }

        public int getRetries() {
            return retries;
        }

        public Builder setRetries(int retries) {
            this.retries = retries;
            return this;
        }

        public int getMaxConcurrentRequests() {
            return maxConcurrentRequests;
        }

        public Builder setMaxConcurrentRequests(int maxConcurrentRequests) {
            this.maxConcurrentRequests = maxConcurrentRequests;
            return this;
        }

        public float getConcurrentInstanceFactor() {
            return concurrentInstanceFactor;
        }

        public Builder setConcurrentInstanceFactor(float concurrentInstanceFactor) {
            this.concurrentInstanceFactor = concurrentInstanceFactor;
            return this;
        }

        public float getOverheadFactor() {
            return overheadFactor;
        }

        public Builder setOverheadFactor(float overheadFactor) {
            this.overheadFactor = overheadFactor;
            return this;
        }

        public ResponseListener getResponseListener() {
            return responseListener;
        }

        public Builder setResponseListener(ResponseListener responseListener) {
            this.responseListener = responseListener;
            return this;
        }

        public AsyncHttpClientConfig getAsyncHttpClientConfig() {
            return asyncHttpClientConfig;
        }

        public Builder setAsyncHttpClientConfig(AsyncHttpClientConfig asyncHttpClientConfig) {
            this.asyncHttpClientConfig = asyncHttpClientConfig;
            return this;
        }

        public TemporalBucketFactory getTemporalBucketFactory() {
            return temporalBucketFactory;
        }

        public Builder setTemporalBucketFactory(TemporalBucketFactory temporalBucketFactory) {
            this.temporalBucketFactory = temporalBucketFactory;
            return this;
        }
        //endregion
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RiotApiConfig that = (RiotApiConfig) o;

        if (retries != that.retries) return false;
        if (maxConcurrentRequests != that.maxConcurrentRequests) return false;
        if (Float.compare(that.concurrentInstanceFactor, concurrentInstanceFactor) != 0) return false;
        if (Float.compare(that.overheadFactor, overheadFactor) != 0) return false;
        if (apiKey != null ? !apiKey.equals(that.apiKey) : that.apiKey != null) return false;
        if (responseListener != null ? !responseListener.equals(that.responseListener) : that.responseListener != null)
            return false;
        if (!asyncHttpClientConfig.equals(that.asyncHttpClientConfig)) return false;
        return temporalBucketFactory.equals(that.temporalBucketFactory);
    }

    @Override
    public int hashCode() {
        int result = apiKey != null ? apiKey.hashCode() : 0;
        result = 31 * result + retries;
        result = 31 * result + maxConcurrentRequests;
        result = 31 * result + (concurrentInstanceFactor != +0.0f ? Float.floatToIntBits(concurrentInstanceFactor) : 0);
        result = 31 * result + (overheadFactor != +0.0f ? Float.floatToIntBits(overheadFactor) : 0);
        result = 31 * result + (responseListener != null ? responseListener.hashCode() : 0);
        result = 31 * result + asyncHttpClientConfig.hashCode();
        result = 31 * result + temporalBucketFactory.hashCode();
        return result;
    }
}
