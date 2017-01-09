package com.mingweisamuel.zyra;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.util.RateLimitedRequester;
import com.mingweisamuel.zyra.util.RateLimiter;
import com.mingweisamuel.zyra.util.Singleton;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Param;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.StreamSupport;

/**
 * Riot API.
 */ //TODO
public class RiotApi {

    /** Joins stuff with commas. */
    private final Joiner joiner = Joiner.on(',');

    /** Json parser. */
    private final Gson gson = new Gson();
    /** Web requester. */
    private final Singleton<RateLimitedRequester> requester;


    public final ChampionEndpoints champions = new ChampionEndpoints(this);
    public final ChampionMasteryEndpoints championMasteries = new ChampionMasteryEndpoints(this);
    public final CurrentGameEndpoints currentGame = new CurrentGameEndpoints(this);
    public final FeaturedGamesEndpoints featuredGames = new FeaturedGamesEndpoints(this);
    public final GameEndpoints games = new GameEndpoints(this);
    public final LeagueEndpoints leagues = new LeagueEndpoints(this);
    public final LolStaticDataEndpoints staticData = new LolStaticDataEndpoints(this);
    public final LolStatusEndpoints status = new LolStatusEndpoints(this);
    public final MatchEndpoints matches = new MatchEndpoints(this);
    public final MatchlistEndpoints matchlist = new MatchlistEndpoints(this);
    public final StatsEndpoints stats = new StatsEndpoints(this);
    public final SummonerEndpoints summoners = new SummonerEndpoints(this);


    /**
     * Creates a RiotApi.Builder with default development rate limits (10 requests per 10 seconds, 500 requests
     * per 10 minutes).
     *
     * @param apiKey Development API key.
     * @return Builder instance. Call {@link Builder#build()} to get RiotApi instance.
     */
    public static Builder build(String apiKey) {
        return new Builder(apiKey);
    }

    /**
     * Creates a RiotApi.Builder with default production rate limits (3_000 requests per 10 seconds, 180_000 requests
     * per 10 minutes).
     *
     * @param apiKey Production API key.
     * @return Builder instance. Call {@link Builder#build()} to get RiotApi instance.
     */
    public static Builder buildProduction(String apiKey) {
        return new Builder(apiKey).setRateLimitsDefaultProduction()
                .setConcurrentRequestsMax(RateLimiter.CONCURRENT_REQUESTS_PRODUCTION_MAX);
    }

    /** Riot API builder for obtaining instances of the Riot API. */
    public static class Builder {

        /** Riot Games API key. */
        private final String apiKey;

        /** API rate limits. Key is time span in milliseconds, value is max number of requests allowed during that
         * timespan. */
        private Map<Long, Integer> rateLimits = new HashMap<>();
        {
            rateLimits.put(RateLimitedRequester.TEN_SECONDS, 10);
            rateLimits.put(RateLimitedRequester.TEN_MINUTES, 500);
        }

        /** The number of times to retry a request. */
        private int retries = RateLimitedRequester.RETRIES_DEFAULT;

        /** The number of concurrent requests allowed (per-region). */
        private int concurrentRequestsMax = RateLimiter.CONCURRENT_REQUESTS_DEFAULT_MAX;

        /** AsyncHttpClient to use. Null for default client. */
        private AsyncHttpClient client = null;

        /**
         * Creates a builder for a RiotApi instance with the specified API key.
         *
         * The rate limits default to the standard development api key rate limits. 10 requests every 10 seconds, 500
         * requests every ten minutes.
         *
         * @param apiKey Riot Games API Key. Go <a href="https://developer.riotgames.com/">here</a> to obtain a key.
         */
        private Builder(String apiKey) {
            this.apiKey = apiKey;
        }

        /**
         * Builds the RiotApi instance.
         * @return RiotApi instance.
         */
        public RiotApi build() {
            return new RiotApi(apiKey, rateLimits, client == null ? new DefaultAsyncHttpClient() : client, retries,
                    concurrentRequestsMax);
        }

        /**
         * Set arbitrary rate limits.
         * @param rateLimits Map from long representing time span in milliseconds to int max requests per that time
         *                   span.
         * @return This, for chaining.
         */
        public Builder setRateLimits(Map<Long, Integer> rateLimits) {
            this.rateLimits = rateLimits;
            return this;
        }

        /**
         * Sets max requests per 10 seconds and 10 minutes rate limits.
         * @param rateLimitPer10Seconds Requests per 10 seconds.
         * @param rateLimitPer10Minutes Requests per 10 minutes.
         * @return This, for chaining.
         */
        public Builder setRateLimits(int rateLimitPer10Seconds, int rateLimitPer10Minutes) {
            rateLimits = new HashMap<>();
            rateLimits.put(RateLimitedRequester.TEN_SECONDS, rateLimitPer10Seconds);
            rateLimits.put(RateLimitedRequester.TEN_MINUTES, rateLimitPer10Minutes);
            return this;
        }

        /**
         * Set the rate limits to the default limits for a production API key. 3,000 requests per 10 seconds, 180,000
         * requests per 10 minutes.
         * @return This, for chaining.
         */
        public Builder setRateLimitsDefaultProduction() {
            rateLimits = new HashMap<>();
            rateLimits.put(RateLimitedRequester.TEN_SECONDS, 3_000);
            rateLimits.put(RateLimitedRequester.TEN_MINUTES, 180_000);
            return this;
        }

        /**
         * Set times to retry failed requests.
         * @param retries
         * @return This, for chaining.
         */
        public Builder setRetries(int retries) {
            this.retries = retries;
            return this;
        }

        /**
         * Set the maximum number of concurrent requests allowed per region.
         * @param concurrentRequestsMax
         * @return This, for chaining.
         */
        public Builder setConcurrentRequestsMax(int concurrentRequestsMax) {
            this.concurrentRequestsMax = concurrentRequestsMax;
            return this;
        }

        /**
         * Sets the AsyncHttpClient to use.
         * @param client
         * @return
         */
        public Builder setClient(AsyncHttpClient client) {
            this.client = client;
            return this;
        }
    }

    /**
     * Creates a RiotApi instance.
     *
     * @param apiKey Riot Games API key.
     * @param rateLimits
     * @param client AsyncHttpClient
     * @param retries
     * @param maxConcurrentRequests
     */
    private RiotApi(String apiKey, Map<Long, Integer> rateLimits, AsyncHttpClient client, int retries,
            int maxConcurrentRequests) {
        requester = new Singleton<>(
                () -> new RateLimitedRequester(apiKey, rateLimits, client, retries, maxConcurrentRequests));
    }

    //region util
    <T> T getBasic(String url, Region region, Type type, Param... params) throws ExecutionException {
        try {
            return this.<T>getBasicAsync(url, region, type, params).get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException();
        }
    }

    <T> CompletableFuture<T> getBasicAsync(String url, Region region, Type type, Param... params) {
        return requester.get().getRequestRateLimitedAsync(url, region, params)
                .thenApply(r -> r.getStatusCode() == 204 || r.getStatusCode() == 404 ? null :
                        gson.fromJson(r.getResponseBody(), type));
    }

    <I, K, V> Map<K, V> getMap(
            String url, Region region, Iterable<I> input, int groupSize, Type type)
            throws ExecutionException {
        try {
            return this.<I, K, V>getMapAsync(url, region, input, groupSize, type).get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException();
        }
    }

    <I, K, V> CompletableFuture<Map<K, V>> getMapAsync(
            String url, Region region, Iterable<I> input, int groupSize, Type type) {
        Iterable<List<I>> groups = Iterables.partition(input, groupSize);
        Map<K, V> result = new ConcurrentHashMap<>();
        final RateLimitedRequester requester = this.requester.get();
        CompletableFuture[] groupTasks = StreamSupport.stream(groups.spliterator(), false).map(group ->
                requester.getRequestRateLimitedAsync(url.replace("@", joiner.join(group)), region)
                        .<Map<K, V>>thenApply(r -> r.getStatusCode() == 204 || r.getStatusCode() == 404 ?
                                Collections.emptyMap() : gson.fromJson(r.getResponseBody(), type))
                        .thenAccept(result::putAll))
                .toArray(CompletableFuture[]::new);
        return CompletableFuture.allOf(groupTasks).thenApply(v -> result);
    }
    //endregion

    //region util-static
    /**
     * Applies an API function multiple times, mapping the input of the function to the result of calling the
     * function on that input.
     *
     * @param func Function to apply.
     * @param inputs Inputs to send to the function.
     * @param <I> Input type.
     * @param <T> Result type.
     * @return Map of input values to result values.
     */
    static <I, T> Map<I, T> makeBatch(Function<I, T> func, Iterable<I> inputs) {
        Map<I, T> result = new HashMap<>();
        for (I input : inputs)
            result.put(input, func.apply(input));
        return result;
    }

    /**
     * Asynchronously applies an API function multiple times, mapping the input of the function to the result of calling
     * the function on that input.
     *
     * @param func Function to apply.
     * @param inputs Inputs to send to the function.
     * @param <I> Input type.
     * @param <T> Result type.
     * @return CompletableFuture of Map of input values to result values.
     */
    static <I, T> CompletableFuture<Map<I, T>> makeBatchAsync(
            Function<I, CompletableFuture<T>> func, Iterable<I> inputs) {
        final ConcurrentMap<I, T> result = new ConcurrentHashMap<>();
        CompletableFuture[] tasks = StreamSupport.stream(inputs.spliterator(), false)
                .map(i -> func.apply(i).thenAccept(t -> result.put(i, t)))
                .toArray(CompletableFuture[]::new);
        return CompletableFuture.allOf(tasks).thenApply(v -> result);
    }

    /**
     * Creates params from each pair of elements. Must be an even number of elements. Key values must be non-null.
     * @param paired
     * @return
     */
    static Param[] makeParams(Object... paired) {

        int nulls = 0;
        for (Object obj : paired)
            if (obj == null)
                nulls++;

        Param[] result = new Param[paired.length / 2 - nulls];
        int j = 0;
        for (int i = 0; i < paired.length; i += 2) {
            if (paired[i + 1] == null)
                continue;
            result[j++] = new Param(paired[i].toString(), paired[i + 1].toString());
        }
        return result;
    }
    //endregion
}
