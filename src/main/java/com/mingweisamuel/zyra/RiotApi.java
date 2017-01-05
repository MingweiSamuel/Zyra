package com.mingweisamuel.zyra;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.ChampionMastery;
import com.mingweisamuel.zyra.dto.MasteryPages;
import com.mingweisamuel.zyra.dto.RunePages;
import com.mingweisamuel.zyra.dto.Summoner;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.util.RateLimitedRequester;
import com.mingweisamuel.zyra.util.Singleton;
import org.asynchttpclient.Response;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
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

    public RiotApi(String apiKey) {
        requester = new Singleton<>(() -> new RateLimitedRequester(apiKey));
    }

    public RiotApi(String apiKey, int requestsPer10Seconds, int requestPer10Minutes) {
        requester = new Singleton<>(() -> new RateLimitedRequester(apiKey, requestsPer10Seconds, requestPer10Minutes));
    }

    //region championmastery
    /** Relative URL for the summoner endpoint. */
    private static final String URL_CHAMPIONMASTERY = "/championmastery/location/%s/player/";
    /** URL suffix for single champion mastery. */
    private static final String URL_CHAMPIONMASTERY_SINGLE = "/champion/";
    /** URL suffix for all champion masteries. */
    private static final String URL_CHAMPIONMASTERY_ALL = "/champions";
    /** Type for single ChampionMastery. */
    private static Type TYPE_CHAMPIONMASTERY_SINGLE = ChampionMastery.class;
    /** Type for list of ChampionMastery. */
    private static Type TYPE_CHAMPIONMASTERY_LIST = new TypeToken<List<ChampionMastery>>() {}.getType();

    //region all
    /**
     * Get all champion mastery entries sorted by number of champion points descending.
     *
     * @param region Region to query.
     * @param summonerId Summoner ID.
     * @param championId ChampionId ID. Use {@link com.mingweisamuel.zyra.enums.ChampionId}. See also
     *          <a href="http://ddragon.leagueoflegends.com/tool/">League Data Dragon tool.</a>
     * @return ChampionMastery. Null if summoner not found.
     */
    public ChampionMastery getSummonerChampionMastery(Region region, long summonerId, long championId)  {
        return getBasic(region, String.format(URL_CHAMPIONMASTERY, region.platform) +
                summonerId + URL_CHAMPIONMASTERY_SINGLE + championId, TYPE_CHAMPIONMASTERY_SINGLE);
    }

    /**
     * Asynchronously get all champion mastery entries sorted by number of champion points descending.
     *
     * @param region Region to query.
     * @param summonerId Summoner ID.
     * @param championId ChampionId ID. Use {@link com.mingweisamuel.zyra.enums.ChampionId}. See also
     *          <a href="http://ddragon.leagueoflegends.com/tool/">League Data Dragon tool.</a>
     * @return CompletableFuture of ChampionMastery. Null if summoner not found.
     */
    public CompletableFuture<ChampionMastery> getSummonerChampionMasteryAsync(
            Region region, long summonerId, long championId) {
        return getBasicAsync(region, String.format(URL_CHAMPIONMASTERY, region.platform) +
                summonerId + URL_CHAMPIONMASTERY_SINGLE + championId, TYPE_CHAMPIONMASTERY_SINGLE);
    }

    /**
     * Get all champion mastery entries sorted by number of champion points descending.
     *
     * @param region Region to query.
     * @param summonerId Summoner ID.
     * @return List of ChampionMasterys. Null if summoner not found.
     */
    public List<ChampionMastery> getSummonerChampionMasteries(Region region, long summonerId)  {
        return getBasic(region, String.format(URL_CHAMPIONMASTERY, region.platform) +
                summonerId + URL_CHAMPIONMASTERY_ALL, TYPE_CHAMPIONMASTERY_LIST);
    }

    /**
     * Asynchronously get all champion mastery entries sorted by number of champion points descending.
     *
     * @param region Region to query.
     * @param summonerId Summoner ID.
     * @return CompletableFuture of list of ChampionMasterys. Null if summoner not found.
     */
    public CompletableFuture<List<ChampionMastery>> getSummonerChampionMasteriesAsync(Region region, long summonerId) {
        return getBasicAsync(region, String.format(URL_CHAMPIONMASTERY, region.platform) +
                summonerId + URL_CHAMPIONMASTERY_ALL, TYPE_CHAMPIONMASTERY_LIST);
    }
    //endregion
    //endregion

    //region summoner
    /** Relative URL for the summoner endpoint. */
    private static final String URL_SUMMONER = "api/lol/%s/v1.4/summoner/";
    /** URL prefix for summoner by-name endpoint. */
    private static final String URL_SUMMONER_BY_NAME = "by-name/";
    /** URL suffix for summoner masteries. */
    private static final String URL_SUMMONER_MASTERIES = "/masteries";
    /** URL suffix for summoner name. */
    private static final String URL_SUMMONER_NAME = "/name";
    /** URL suffix for summoner runes. */
    private static final String URL_SUMMONER_RUNES = "/runes";
    /** Max group size for summoner requests (40). */
    private static final int GROUP_SUMMONER = 40;
    /** Type for mapping from summoner ID to Summoner. */
    private static Type TYPE_SUMMONERS_ID = new TypeToken<Map<Long, Summoner>>() {}.getType();
    /** Type for mapping from normalized summoner name to Summoner. */
    private static Type TYPE_SUMMONERS_NAME = new TypeToken<Map<String, Summoner>>() {}.getType();
    /** Type for mapping from summoner ID to MasteryPages. */
    private static Type TYPE_SUMMONERS_MASTERIES = new TypeToken<Map<Long, MasteryPages>>() {}.getType();
    /** Type for mapping from summoner ID to RunePages. */
    private static Type TYPE_SUMMONERS_RUNES = new TypeToken<Map<Long, RunePages>>() {}.getType();

    //region by-id
    /**
     * Get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to Summoner.
     */
    public Map<Long, Summoner> getSummoners(Region region, Long... summonerIds)  {
        return getSummoners(region, Arrays.asList(summonerIds));
    }

    /**
     * Get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to Summoner.
     */
    public Map<Long, Summoner> getSummoners(Region region, Iterable<Long> summonerIds)  {
        String urlPrefix = String.format(URL_SUMMONER, region);
        return getMap(region, summonerIds, GROUP_SUMMONER, (g) -> urlPrefix + g, TYPE_SUMMONERS_ID);
    }

    /**
     * Asynchronously get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to Summoner.
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
        String urlPrefix = String.format(URL_SUMMONER, region);
        return getMapAsync(region, summonerIds, GROUP_SUMMONER, (g) -> urlPrefix + g, TYPE_SUMMONERS_ID);
    }
    //endregion

    //region by-name
    /**
     * Get summoner objects mapped by standardized summoner name for a given list of summoner names.
     *
     * The response object contains the summoner objects mapped by the standardized summoner name, which is the
     * summoner name in all lower case and with spaces removed. Use this version of the name when checking if the
     * returned object contains the data for a given summoner. This API will also accept standardized summoner names
     * as valid parameters, although they are not required.
     *
     * @param region Region to query.
     * @param summonerNames Summoner names (whitespace and case independent).
     * @return Map from normalized summoner name to Summoner.
     */
    public Map<String, Summoner> getSummonersByName(Region region, String... summonerNames) {
        return getSummonersByName(region, Arrays.asList(summonerNames));
    }

    /**
     * Get summoner objects mapped by standardized summoner name for a given list of summoner names.
     *
     * The response object contains the summoner objects mapped by the standardized summoner name, which is the
     * summoner name in all lower case and with spaces removed. Use this version of the name when checking if the
     * returned object contains the data for a given summoner. This API will also accept standardized summoner names
     * as valid parameters, although they are not required.
     *
     * @param region Region to query.
     * @param summonerNames Summoner names (whitespace and case independent).
     * @return Map from normalized summoner name to Summoner.
     */
    public Map<String, Summoner> getSummonersByName(Region region, Iterable<String> summonerNames) {
        String urlPrefix = String.format(URL_SUMMONER, region) + URL_SUMMONER_BY_NAME;
        return getMap(region, summonerNames, GROUP_SUMMONER, (g) -> urlPrefix + g, TYPE_SUMMONERS_NAME);
    }

    /**
     * Asynchronously get summoner objects mapped by standardized summoner name for a given list of summoner names.
     *
     * The response object contains the summoner objects mapped by the standardized summoner name, which is the
     * summoner name in all lower case and with spaces removed. Use this version of the name when checking if the
     * returned object contains the data for a given summoner. This API will also accept standardized summoner names
     * as valid parameters, although they are not required.
     *
     * @param region Region to query.
     * @param summonerNames Summoner names (whitespace and case independent).
     * @return CompletableFuture of map from normalized summoner name to Summoner.
     * @
     */
    public CompletableFuture<Map<String, Summoner>> getSummonersByNameAsync(Region region, String... summonerNames) {
        return getSummonersByNameAsync(region, Arrays.asList(summonerNames));
    }

    /**
     * Asynchronously get summoner objects mapped by standardized summoner name for a given list of summoner names.
     *
     * The response object contains the summoner objects mapped by the standardized summoner name, which is the
     * summoner name in all lower case and with spaces removed. Use this version of the name when checking if the
     * returned object contains the data for a given summoner. This API will also accept standardized summoner names
     * as valid parameters, although they are not required.
     *
     * @param region Region to query.
     * @param summonerNames Summoner names (whitespace and case independent).
     * @return CompletableFuture of map from normalized summoner name to Summoner.
     * @
     */
    public CompletableFuture<Map<String, Summoner>> getSummonersByNameAsync(
            Region region, Iterable<String> summonerNames) {
        String urlPrefix = String.format(URL_SUMMONER, region) + URL_SUMMONER_BY_NAME;
        return getMapAsync(region, summonerNames, GROUP_SUMMONER, (g) -> urlPrefix + g, TYPE_SUMMONERS_NAME);
    }
    //endregion

    //region masteries
    /**
     * Get mastery pages mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to MasteryPages.
     */
    public Map<Long, MasteryPages> getSummonersMasteries(Region region, Long... summonerIds)  {
        return getSummonersMasteries(region, Arrays.asList(summonerIds));
    }

    /**
     * Get mastery pages mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to MasteryPages.
     */
    public Map<Long, MasteryPages> getSummonersMasteries(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_SUMMONER, region);
        return getMap(region, summonerIds, GROUP_SUMMONER,
                (g) -> urlPrefix + g + URL_SUMMONER_MASTERIES, TYPE_SUMMONERS_MASTERIES);
    }

    /**
     * Asynchronously get mastery pages mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to MasteryPages.
     */
    public CompletableFuture<Map<Long, MasteryPages>> getSummonersMasteriesAsync(Region region, Long... summonerIds) {
        return getSummonersMasteriesAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get mastery pages mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to MasteryPages.
     */
    public CompletableFuture<Map<Long, MasteryPages>> getSummonersMasteriesAsync(
            Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_SUMMONER, region);
        return getMapAsync(region, summonerIds, GROUP_SUMMONER,
                (g) -> urlPrefix + g + URL_SUMMONER_MASTERIES, TYPE_SUMMONERS_MASTERIES);
    }
    //endregion

    //region name
    /**
     * Get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to name (String).
     */
    public Map<Long, MasteryPages> getSummonersName(Region region, Long... summonerIds)  {
        return getSummonersMasteries(region, Arrays.asList(summonerIds));
    }

    /**
     * Get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to name (String).
     */
    public Map<Long, MasteryPages> getSummonersName(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_SUMMONER, region);
        return getMap(region, summonerIds, GROUP_SUMMONER,
                (g) -> urlPrefix + g + URL_SUMMONER_NAME, TYPE_SUMMONERS_MASTERIES);
    }

    /**
     * Asynchronously get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to name (String).
     */
    public CompletableFuture<Map<Long, MasteryPages>> getSummonersNameAsync(Region region, Long... summonerIds) {
        return getSummonersMasteriesAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to name (String).
     */
    public CompletableFuture<Map<Long, MasteryPages>> getSummonersNameAsync(
            Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_SUMMONER, region);
        return getMapAsync(region, summonerIds, GROUP_SUMMONER,
                (g) -> urlPrefix + g + URL_SUMMONER_NAME, TYPE_SUMMONERS_MASTERIES);
    }
    //endregion

    //region runes
    /**
     * Get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to name (String).
     */
    public Map<Long, RunePages> getSummonersRunes(Region region, Long... summonerIds)  {
        return getSummonersRunes(region, Arrays.asList(summonerIds));
    }

    /**
     * Get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to name (String).
     */
    public Map<Long, RunePages> getSummonersRunes(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_SUMMONER, region);
        return getMap(region, summonerIds, GROUP_SUMMONER,
                (g) -> urlPrefix + g + URL_SUMMONER_RUNES, TYPE_SUMMONERS_RUNES);
    }

    /**
     * Asynchronously get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to name (String).
     */
    public CompletableFuture<Map<Long, RunePages>> getSummonersRunesAsync(Region region, Long... summonerIds) {
        return getSummonersRunesAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to name (String).
     */
    public CompletableFuture<Map<Long, RunePages>> getSummonersRunesAsync(
            Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_SUMMONER, region);
        return getMapAsync(region, summonerIds, GROUP_SUMMONER,
                (g) -> urlPrefix + g + URL_SUMMONER_RUNES, TYPE_SUMMONERS_RUNES);
    }
    //endregion
    //endregion

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
    private <I, K, V> Map<K, V> getMap(
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
    private <I, K, V> CompletableFuture<Map<K, V>> getMapAsync(
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

    /**
     * Helper for general single-unit requests.
     *
     * @param region Region to send requests to.
     * @param url URL to send the request to.
     * @param type TypeToken.getType() for gson.
     * @param <T> Type to be returned.
     * @return Result.
     */
    private <T> T getBasic(Region region, String url, Type type) {
        Response response = requester.get().getRequestRateLimited(url, region);
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
    private <T> CompletableFuture<T> getBasicAsync(Region region, String url, Type type) {
        return requester.get().getRequestRateLimitedAsync(url, region)
                .thenApply(r -> r.getStatusCode() == 204 || r.getStatusCode() == 404 ? null :
                        gson.fromJson(r.getResponseBody(), type));
    }
}
