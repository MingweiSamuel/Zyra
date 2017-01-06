package com.mingweisamuel.zyra;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.util.RateLimitedRequester;
import com.mingweisamuel.zyra.util.Singleton;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Param;
import org.asynchttpclient.Response;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.function.UnaryOperator;
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

    /** Summoner API. */
    public final SummonerEndpoint summoners = new SummonerEndpoint(this);

    /** ChampionMastery API. */
    public final ChampionMasteryEndpoint championMasteries = new ChampionMasteryEndpoint(this);

    /** League API. */
    public final LeagueEndpoint leagues = new LeagueEndpoint(this);

    /** Stats API. */
    public final StatsEndpoint stats = new StatsEndpoint(this);

    public RiotApi(String apiKey) {
        requester = new Singleton<>(() -> new RateLimitedRequester(apiKey));
    }

    public RiotApi(String apiKey, int requestsPer10Seconds, int requestPer10Minutes) {
        requester = new Singleton<>(() -> new RateLimitedRequester(apiKey, requestsPer10Seconds, requestPer10Minutes));
    }

    private RiotApi(String apiKey, Map<Long, Integer> rateLimits, AsyncHttpClient client, int retries,
            int maxConcurrentRequests) {
        requester = new Singleton<>(
                () -> new RateLimitedRequester(apiKey, rateLimits, client, retries, maxConcurrentRequests));
    }



    //region util
    /**
     * Helper for general single-unit requests.
     *
     * @param region Region to send requests to.
     * @param url URL to send the request to.
     * @param type TypeToken.getType() for gson.
     * @param <T> Type to be returned.
     * @return Result.
     */
    <T> T getBasic(Region region, String url, Type type, Param... params) {
        Response response = requester.get().getRequestRateLimited(url, region, params);
        if (response.getStatusCode() == 204 || response.getStatusCode() == 404)
            return null;
        return gson.fromJson(response.getResponseBody(), type);
    }

    /**
     * Async helper for general single-unit requests.
     *
     * @param region Region to send requests to.
     * @param url URL to send the request to.
     * @param type TypeToken.getType() for gson.
     * @param <T> Type to be returned.
     * @return Async result.
     */
    <T> CompletableFuture<T> getBasicAsync(Region region, String url, Type type, Param... params) {
        return requester.get().getRequestRateLimitedAsync(url, region, params)
                .thenApply(r -> r.getStatusCode() == 204 || r.getStatusCode() == 404 ? null :
                        gson.fromJson(r.getResponseBody(), type));
    }

    /**
     * Helper for map-based requests.
     *
     * @param region Region to send request to.
     * @param input Iterable of the input type.
     * @param groupSize Max size per group.
     * @param urlFunction Function that takes a String of comma-separated input group and returns a url.
     * @param type TypeToken.getType() for gson.
     * @param <I> Input type
     * @param <K> Result key type
     * @param <V> Result value type
     * @return Result
     */
    <I, K, V> Map<K, V> getMap(
            Region region, Iterable<I> input, int groupSize, UnaryOperator<String> urlFunction, Type type) {
        Map<K, V> result = new HashMap<>();
        for (Iterable<I> group : Iterables.partition(input, groupSize)) {
            Response response = requester.get().getRequestRateLimited(urlFunction.apply(joiner.join(group)), region);
            if (response.getStatusCode() == 204 || response.getStatusCode() == 404)
                continue;
            result.putAll(gson.fromJson(response.getResponseBody(), type));
        }
        return result;
    }

    /**
     * Async helper for map-based requests.
     *
     * @param region Region to send request to.
     * @param input Iterable of the input type.
     * @param groupSize Max size per group.
     * @param urlFunction Function that takes a String of comma-separated input group and returns a url.
     * @param type TypeToken.getType() for gson.
     * @param <I> Input type.
     * @param <K> Result key type.
     * @param <V> Result value type.
     * @return Async result.
     */
    <I, K, V> CompletableFuture<Map<K, V>> getMapAsync(
            Region region, Iterable<I> input, int groupSize, UnaryOperator<String> urlFunction, Type type) {
        Iterable<List<I>> groups = Iterables.partition(input, groupSize);
        Map<K, V> result = new ConcurrentHashMap<>();
        final RateLimitedRequester requester = this.requester.get();
        CompletableFuture[] groupTasks = StreamSupport.stream(groups.spliterator(), false).map(group ->
                requester.getRequestRateLimitedAsync(urlFunction.apply(joiner.join(group)), region)
                    .<Map<K, V>>thenApply(r -> r.getStatusCode() == 204 || r.getStatusCode() == 404 ?
                            Collections.emptyMap() : gson.fromJson(r.getResponseBody(), type))
                    .thenAccept(result::putAll))
                .toArray(CompletableFuture[]::new);
        return CompletableFuture.allOf(groupTasks).thenApply(v -> result);
    }
    //endregion

    //region util-static
    /**
     * Applies a function multiple times, mapping the input of the function to the result of calling the function on
     * that input.
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
     * Asynchronously applies a function multiple times, mapping the input of the function to the result of calling the
     * function on that input.
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
    //endregion
}
