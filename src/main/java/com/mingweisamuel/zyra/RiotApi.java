package com.mingweisamuel.zyra;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.model.Summoner;
import com.mingweisamuel.zyra.util.RiotRequestException;
import com.mingweisamuel.zyra.util.Singleton;
import org.asynchttpclient.Response;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.StreamSupport;

/**
 * Created by Mingw on 2017-01-01.
 */
public class RiotApi {

    /** Relative URL for the summoner endpoint. */
    private static final String URL_SUMMONER = "api/lol/%s/v1.4/summoner/";
    /** URL extension for summoner by-name endpoint. */
    private static final String URL_SUMMONER_BY_NAME = "by-name/";
    /** Max group size for summoner requests (40). */
    private static final int GROUP_SUMMONER = 40;
    /** Type for mapping from summoner ID to Summoner. */
    private static Type TYPE_SUMMONER_MAP_LONG = new TypeToken<Map<Long, Summoner>>() {}.getType();
    /** Type for normalized summoner name to Summoner. */
    private static Type TYPE_SUMMONER_MAP_STRING = new TypeToken<Map<String, Summoner>>() {}.getType();


    /** Joins stuff with commas. */
    private final Joiner joiner = Joiner.on(',');

    /** Json parser. */
    private final Gson gson = new Gson();
    /** Web requester. */
    private final Singleton<RiotRequester> requester;

    public RiotApi(String apiKey) {
        requester = new Singleton<>(() -> new RiotRequester(apiKey));
    }

    public RiotApi(String apiKey, int requestsPer10Seconds, int requestPer10Minutes) {
        requester = new Singleton<>(() -> new RiotRequester(apiKey, requestsPer10Seconds, requestPer10Minutes));
    }

//    private Object getApi(Region region, String url, Type type) throws RiotRequestException {
//        Response response = requester.get().getRequestRateLimited(url, region);
//        return gson.fromJson(response.getResponseBody(), type);
//    }
//
//    private Object getApiAsync(Region region, String url, Type type) {
//        CompletableFuture<Response> requestTask = requester.get()
//                .getRequestRateLimitedAsync(url, region);
//        return requestTask.thenApply(Response::getResponseBody).thenApply(j -> gson.fromJson(j, type));
//    }

    /**
     * Get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to Summoner.
     * @throws RiotRequestException
     */
    public Map<Long, Summoner> getSummoners(Region region, long... summonerIds) {
        return getSummoners(region, summonerIds);
    }

    /**
     * Get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to Summoner.
     * @throws RiotRequestException
     */
    public Map<Long, Summoner> getSummoners(Region region, Iterable<Long> summonerIds)
            throws RiotRequestException {
        Map<Long, Summoner> result = new HashMap<>();
        for (Iterable<Long> summonerIdGroup : Iterables.partition(summonerIds, GROUP_SUMMONER)) {
            Response response = requester.get().getRequestRateLimited(
                    String.format(URL_SUMMONER, region) + joiner.join(summonerIdGroup), region);
            Map<Long, Summoner> groupResult = gson.fromJson(response.getResponseBody(), TYPE_SUMMONER_MAP_LONG);
            result.putAll(groupResult);
        }
        return result;
    }

    /**
     * Asynchronously get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to Summoner.
     * @throws RiotRequestException
     */
    public CompletableFuture<Map<Long, Summoner>> getSummonersAsync(Region region, Iterable<Long> summonerIds) {
        Iterable<List<Long>> groups = Iterables.partition(summonerIds, GROUP_SUMMONER);

        Map<Long, Summoner> result = new ConcurrentHashMap<>();
        final RiotRequester requester = this.requester.get();
        CompletableFuture[] groupTasks = StreamSupport.stream(groups.spliterator(), false).map(group ->
                requester.getRequestRateLimitedAsync(String.format(URL_SUMMONER, region) + joiner.join(group), region)
                        .thenApply(Response::getResponseBody)
                        .<Map<Long, Summoner>>thenApply(j -> gson.fromJson(j, TYPE_SUMMONER_MAP_LONG))
                        .thenAccept(result::putAll))
                .toArray(CompletableFuture[]::new);
        return CompletableFuture.allOf(groupTasks).thenApply(v -> result);
    }
}
