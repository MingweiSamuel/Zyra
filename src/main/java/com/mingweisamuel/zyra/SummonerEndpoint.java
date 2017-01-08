package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.MasteryPages;
import com.mingweisamuel.zyra.dto.RunePages;
import com.mingweisamuel.zyra.dto.Summoner;
import com.mingweisamuel.zyra.enums.Region;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Riot API Summoner Endpoint (v1.4).
 *
 * Provides access to basic summoner info (id, name, level, profile icon, etc) as well as access to mastery and rune
 * pages.
 *
 * @see RiotApi#summoners
 */
public class SummonerEndpoint {

    /** Relative URL for the summoner endpoint. */
    private static final String URL_BASE = "api/lol/%s/v1.4/summoner/";
    /** URL prefix for summoner by-name endpoint. */
    private static final String URL_PREFIX_BY_NAME = "by-name/";
    /** URL suffix for summoner masteries. */
    private static final String URL_SUFFIX_MASTERIES = "/masteries";
    /** URL suffix for summoner name. */
    private static final String URL_SUFFIX_NAME = "/name";
    /** URL suffix for summoner runes. */
    private static final String URL_SUFFIX_RUNES = "/runes";
    /** Max group size for summoner requests (40). */
    private static final int GROUP_SIZE = 40;
    /** Type for mapping from summoner ID to Summoner. */
    private static Type TYPE_ID = new TypeToken<Map<Long, Summoner>>() {}.getType();
    /** Type for mapping from normalized summoner name to Summoner. */
    private static Type TYPE_NAME = new TypeToken<Map<String, Summoner>>() {}.getType();
    /** Type for mapping from summoner ID to MasteryPages. */
    private static Type TYPE_MASTERIES = new TypeToken<Map<Long, MasteryPages>>() {}.getType();
    /** Type for mapping from summoner ID to RunePages. */
    private static Type TYPE_RUNES = new TypeToken<Map<Long, RunePages>>() {}.getType();

    /** RiotApi reference. */
    private final RiotApi api;

    /**
     * Creates a SummonerEndpoint.
     * @param api RiotApi reference.
     */
    SummonerEndpoint(RiotApi api) {
        this.api = api;
    }

    /**
     * Standardizes the supplied summoner name by removing whitespace and decapitalizing all letters.
     * @param name Summoner name.
     * @return Standardized summoner name.
     */
    public static String standardizeName(String name) {
        return name.replaceAll("\\s", "").toLowerCase();
    }

    //region by-id
    /**
     * Get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to Summoner.
     */
    public Map<Long, Summoner> get(Region region, Long... summonerIds)  {
        return get(region, Arrays.asList(summonerIds));
    }

    /**
     * Get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to Summoner.
     */
    public Map<Long, Summoner> get(Region region, Iterable<Long> summonerIds)  {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMap(region, summonerIds, GROUP_SIZE, (g) -> urlPrefix + g, TYPE_ID);
    }

    /**
     * Asynchronously get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to Summoner.
     */
    public CompletableFuture<Map<Long, Summoner>> getAsync(Region region, Long... summonerIds) {
        return getAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get summoner objects mapped by summoner ID for a given iterable of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to Summoner.
     */
    public CompletableFuture<Map<Long, Summoner>> getAsync(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMapAsync(region, summonerIds, GROUP_SIZE, (g) -> urlPrefix + g, TYPE_ID);
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
     * @see #standardizeName(String)
     *
     * @param region Region to query.
     * @param summonerNames Summoner names (whitespace and case independent).
     * @return Map from normalized summoner name to Summoner.
     */
    public Map<String, Summoner> getByName(Region region, String... summonerNames) {
        return getByName(region, Arrays.asList(summonerNames));
    }

    /**
     * Get summoner objects mapped by standardized summoner name for a given list of summoner names.
     *
     * The response object contains the summoner objects mapped by the standardized summoner name, which is the
     * summoner name in all lower case and with spaces removed. Use this version of the name when checking if the
     * returned object contains the data for a given summoner. This API will also accept standardized summoner names
     * as valid parameters, although they are not required.
     *
     * @see #standardizeName(String)
     *
     * @param region Region to query.
     * @param summonerNames Summoner names (whitespace and case independent).
     * @return Map from normalized summoner name to Summoner.
     */
    public Map<String, Summoner> getByName(Region region, Iterable<String> summonerNames) {
        String urlPrefix = String.format(URL_BASE, region) + URL_PREFIX_BY_NAME;
        return api.getMap(region, summonerNames, GROUP_SIZE, (g) -> urlPrefix + g, TYPE_NAME);
    }

    /**
     * Asynchronously get summoner objects mapped by standardized summoner name for a given list of summoner names.
     *
     * The response object contains the summoner objects mapped by the standardized summoner name, which is the
     * summoner name in all lower case and with spaces removed. Use this version of the name when checking if the
     * returned object contains the data for a given summoner. This API will also accept standardized summoner names
     * as valid parameters, although they are not required.
     *
     * @see #standardizeName(String)
     *
     * @param region Region to query.
     * @param summonerNames Summoner names (whitespace and case independent).
     * @return CompletableFuture of map from normalized summoner name to Summoner.
     */
    public CompletableFuture<Map<String, Summoner>> getByNameAsync(Region region, String... summonerNames) {
        return getByNameAsync(region, Arrays.asList(summonerNames));
    }

    /**
     * Asynchronously get summoner objects mapped by standardized summoner name for a given list of summoner names.
     *
     * The response object contains the summoner objects mapped by the standardized summoner name, which is the
     * summoner name in all lower case and with spaces removed. Use this version of the name when checking if the
     * returned object contains the data for a given summoner. This API will also accept standardized summoner names
     * as valid parameters, although they are not required.
     *
     * @see #standardizeName(String)
     *
     * @param region Region to query.
     * @param summonerNames Summoner names (whitespace and case independent).
     * @return CompletableFuture of map from normalized summoner name to Summoner.
     */
    public CompletableFuture<Map<String, Summoner>> getByNameAsync(
            Region region, Iterable<String> summonerNames) {
        String urlPrefix = String.format(URL_BASE, region) + URL_PREFIX_BY_NAME;
        return api.getMapAsync(region, summonerNames, GROUP_SIZE, (g) -> urlPrefix + g, TYPE_NAME);
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
    public Map<Long, MasteryPages> getMasteries(Region region, Long... summonerIds)  {
        return getMasteries(region, Arrays.asList(summonerIds));
    }

    /**
     * Get mastery pages mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to MasteryPages.
     */
    public Map<Long, MasteryPages> getMasteries(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMap(region, summonerIds, GROUP_SIZE,
                (g) -> urlPrefix + g + URL_SUFFIX_MASTERIES, TYPE_MASTERIES);
    }

    /**
     * Asynchronously get mastery pages mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to MasteryPages.
     */
    public CompletableFuture<Map<Long, MasteryPages>> getMasteriesAsync(Region region, Long... summonerIds) {
        return getMasteriesAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get mastery pages mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to MasteryPages.
     */
    public CompletableFuture<Map<Long, MasteryPages>> getMasteriesAsync(
            Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMapAsync(region, summonerIds, GROUP_SIZE,
                (g) -> urlPrefix + g + URL_SUFFIX_MASTERIES, TYPE_MASTERIES);
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
    public Map<Long, MasteryPages> getName(Region region, Long... summonerIds)  {
        return getMasteries(region, Arrays.asList(summonerIds));
    }

    /**
     * Get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to name (String).
     */
    public Map<Long, MasteryPages> getName(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMap(region, summonerIds, GROUP_SIZE,
                (g) -> urlPrefix + g + URL_SUFFIX_NAME, TYPE_MASTERIES);
    }

    /**
     * Asynchronously get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to name (String).
     */
    public CompletableFuture<Map<Long, MasteryPages>> getNameAsync(Region region, Long... summonerIds) {
        return getMasteriesAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to name (String).
     */
    public CompletableFuture<Map<Long, MasteryPages>> getNameAsync(
            Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMapAsync(region, summonerIds, GROUP_SIZE,
                (g) -> urlPrefix + g + URL_SUFFIX_NAME, TYPE_MASTERIES);
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
    public Map<Long, RunePages> getRunes(Region region, Long... summonerIds)  {
        return getRunes(region, Arrays.asList(summonerIds));
    }

    /**
     * Get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to name (String).
     */
    public Map<Long, RunePages> getRunes(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMap(region, summonerIds, GROUP_SIZE,
                (g) -> urlPrefix + g + URL_SUFFIX_RUNES, TYPE_RUNES);
    }

    /**
     * Asynchronously get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to name (String).
     */
    public CompletableFuture<Map<Long, RunePages>> getRunesAsync(Region region, Long... summonerIds) {
        return getRunesAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get summoner names mapped by summoner ID for a given list of summoner IDs.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to name (String).
     */
    public CompletableFuture<Map<Long, RunePages>> getRunesAsync(
            Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMapAsync(region, summonerIds, GROUP_SIZE,
                (g) -> urlPrefix + g + URL_SUFFIX_RUNES, TYPE_RUNES);
    }
    //endregion
}
