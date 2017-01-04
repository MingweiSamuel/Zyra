package com.mingweisamuel.zyra.test;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.test.model.Summoner;
import com.mingweisamuel.zyra.test.util.RiotResponseException;
import com.mingweisamuel.zyra.test.util.Singleton;
import org.asynchttpclient.Response;

import java.lang.reflect.Type;
import java.util.Arrays;
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

    //region Summoner
    /**
     * @see #getSummoners(Region, Iterable)
     */
    public Map<Long, Summoner> getSummoners(Region region, Long... summonerIds) throws RiotResponseException {
        return getSummoners(region, Arrays.asList(summonerIds));
    }

    /**
     * Get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to Summoner.
     * @throws RiotResponseException
     */
    public Map<Long, Summoner> getSummoners(Region region, Iterable<Long> summonerIds) throws RiotResponseException {
        Map<Long, Summoner> result = new HashMap<>();
        for (Iterable<Long> summonerIdGroup : Iterables.partition(summonerIds, GROUP_SUMMONER)) {
            Response response = requester.get().getRequestRateLimited(
                    String.format(URL_SUMMONER, region) + joiner.join(summonerIdGroup), region);
            Map<Long, Summoner> groupResult = gson.fromJson(response.getResponseBody(), TYPE_SUMMONER_MAP_LONG);
            result.putAll(groupResult);
        }
        return result;
    }

    @SuppressWarnings("checkstyle:javadoctype")
    /**
     * @see #getSummonersAsync(Region, Iterable)
     */
    public CompletableFuture<Map<Long, Summoner>> getSummonersAsync(Region region, Long... summonerIds) {
        return getSummonersAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to Summoner.
     */
    public CompletableFuture<Map<Long, Summoner>> getSummonersAsync(Region region, Iterable<Long> summonerIds) {
        Iterable<List<Long>> groups = Iterables.partition(summonerIds, GROUP_SUMMONER);

        Map<Long, Summoner> result = new ConcurrentHashMap<>();
        final RiotRequester requester = this.requester.get();
        CompletableFuture[] groupTasks = StreamSupport.stream(groups.spliterator(), false).map(group ->
                requester.getRequestRateLimitedAsync(String.format(URL_SUMMONER, region) + joiner.join(group), region)
                        .<Map<Long, Summoner>>thenApply(r ->
                                {
                                    try {
                                        return gson.fromJson(r.getResponseBody(), TYPE_SUMMONER_MAP_LONG);
                                    }
                                    catch(JsonSyntaxException e) {
                                        throw new RiotResponseException("JSON parse failed", e, r);
                                    }
                                })
                        .thenAccept(result::putAll))
                .toArray(CompletableFuture[]::new);
        return CompletableFuture.allOf(groupTasks).thenApply(v -> result);
    }

    //endregion
}
