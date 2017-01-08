package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.League;
import com.mingweisamuel.zyra.enums.Region;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Riot API League Endpoint (v2.5).
 *
 * Provides access to league (rank) information on a per-summoner basis as well as listings of the challenger and
 * master tier leagues.
 *
 * @see RiotApi#leagues
 */
public class LeagueEndpoint {

    /** Relative URL for the league endpoint. */
    private static final String URL_BASE = "api/lol/%s/v2.5/";
    /** URL suffix for the challenger league endpoint. */
    private static final String URL_SUFFIX_CHALLENGER = "challenger";
    /** URL suffix for the master league endpoint. */
    private static final String URL_SUFFIX_MASTER = "master";
    /** URL suffix for summoner to league entry. */
    private static final String URL_SUFFIX_ENTRY = "/entry";
    /** Max group size for league (rank) requests (10). */
    private static final int GROUP_SIZE = 10;
    /** Type for league listing (get challenger and master). */
    private static final Type TYPE_SINGLE = League.class;
    /** Type for mapping from summoner ID to league listing. */
    private static final Type TYPE_MANY = new TypeToken<Map<Long, List<League>>>() {}.getType();

    /** RiotApi reference. */
    private final RiotApi api;

    /**
     * Creates a LeagueEndpoint instance.
     * @param api RiotApi reference.
     */
    LeagueEndpoint(RiotApi api) {
        this.api = api;
    }

    //region get
    /**
     * Get leagues mapped by summoner ID for a given list of summoner IDs.
     *
     * Returns all leagues for specified summoners and summoners' teams. Entries for each requested participant (i.e.,
     * each summoner and related teams) will be included in the returned leagues data, whether or not the participant
     * is inactive. However, no entries for other inactive summoners or teams in the leagues will be included.
     *
     * This differs from {@link #getEntries(Region, Long...)} by (TODO).
     *
     * @see #getEntries(Region, Long...)
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs to query.
     * @return Map from summoner ID (Long) to List of League.
     */
    public Map<Long, List<League>> get(Region region, Long... summonerIds) {
        return get(region, Arrays.asList(summonerIds));
    }

    /**
     * Get leagues mapped by summoner ID for a given list of summoner IDs.
     *
     * Returns all leagues for specified summoners and summoners' teams. Entries for each requested participant (i.e.,
     * each summoner and related teams) will be included in the returned leagues data, whether or not the participant
     * is inactive. However, no entries for other inactive summoners or teams in the leagues will be included.
     *
     * This differs from {@link #getEntries(Region, Iterable)} by (TODO).
     *
     * @see #getEntries(Region, Iterable)
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs to query.
     * @return Map from summoner ID (Long) to List of League.
     */
    public Map<Long, List<League>> get(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMap(region, summonerIds, GROUP_SIZE, (g) -> urlPrefix + g, TYPE_MANY);
    }

    /**
     * Asynchronously get leagues mapped by summoner ID for a given list of summoner IDs.
     *
     * Returns all leagues for specified summoners and summoners' teams. Entries for each requested participant (i.e.,
     * each summoner and related teams) will be included in the returned leagues data, whether or not the participant
     * is inactive. However, no entries for other inactive summoners or teams in the leagues will be included.
     *
     * This differs from {@link #getEntriesAsync(Region, Long...)} by (TODO).
     *
     * @see #getEntriesAsync(Region, Long...)
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs to query.
     * @return CompletableFuture of Map from summoner ID (Long) to List of League.
     */
    public CompletableFuture<Map<Long, List<League>>> getAsync(Region region, Long... summonerIds) {
        return getAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get leagues mapped by summoner ID for a given list of summoner IDs.
     *
     * Returns all leagues for specified summoners and summoners' teams. Entries for each requested participant (i.e.,
     * each summoner and related teams) will be included in the returned leagues data, whether or not the participant
     * is inactive. However, no entries for other inactive summoners or teams in the leagues will be included.
     *
     * This differs from {@link #getEntriesAsync(Region, Iterable)} by (TODO).
     *
     * @see #getEntriesAsync(Region, Iterable)
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs to query.
     * @return CompletableFuture of Map from summoner ID (Long) to List of League.
     */
    public CompletableFuture<Map<Long, List<League>>> getAsync(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMapAsync(region, summonerIds, GROUP_SIZE, (g) -> urlPrefix + g, TYPE_MANY);
    }
    //endregion

    //region get-entry
    /**
     * Get league entries mapped by summoner ID for a given list of summoner IDs.
     *
     * Returns all league entries for specified summoners and summoners' teams.
     *
     * This differs from {@link #get(Region, Long...)} by (TODO).
     *
     * @see #get(Region, Long...)
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs to query.
     * @return Map from summoner ID (Long) to List of League.
     */
    public Map<Long, List<League>> getEntries(Region region, Long... summonerIds) {
        return getEntries(region, Arrays.asList(summonerIds));
    }

    /**
     * Get league entries mapped by summoner ID for a given list of summoner IDs.
     *
     * Returns all league entries for specified summoners and summoners' teams.
     *
     * This differs from {@link #get(Region, Iterable)} by (TODO).
     *
     * @see #get(Region, Iterable)
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs to query.
     * @return Map from summoner ID (Long) to List of League.
     */
    public Map<Long, List<League>> getEntries(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMap(region, summonerIds, GROUP_SIZE, (g) -> urlPrefix + g + URL_SUFFIX_ENTRY, TYPE_MANY);
    }

    /**
     * Asynchronously get league entries mapped by summoner ID for a given list of summoner IDs.
     *
     * Returns all league entries for specified summoners and summoners' teams.
     *
     * This differs from {@link #getAsync(Region, Long...)} by (TODO).
     *
     * @see #get(Region, Long...)
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs to query.
     * @return CompletableFuture of Map from summoner ID (Long) to List of League.
     */
    public CompletableFuture<Map<Long, List<League>>> getEntriesAsync(Region region, Long... summonerIds) {
        return getEntriesAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get league entries mapped by summoner ID for a given list of summoner IDs.
     *
     * Returns all league entries for specified summoners and summoners' teams.
     *
     * This differs from {@link #getAsync(Region, Iterable)} by (TODO).
     *
     * @see #get(Region, Iterable)
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs to query.
     * @return CompletableFuture of Map from summoner ID (Long) to List of League.
     */
    public CompletableFuture<Map<Long, List<League>>> getEntriesAsync(Region region, Iterable<Long> summonerIds) {
        String urlPrefix = String.format(URL_BASE, region);
        return api.getMapAsync(region, summonerIds, GROUP_SIZE, (g) -> urlPrefix + g + URL_SUFFIX_ENTRY, TYPE_MANY);
    }
    //endregion

    //region challenger
    /**
     * Get challenger tier leagues.
     *
     * @param region Region to query.
     * @return League.
     */
    public League getChallengerTier(Region region) {
        return api.getBasic(region, String.format(URL_BASE, region) + URL_SUFFIX_CHALLENGER, TYPE_SINGLE);
    }

    /**
     * Asynchronously get challenger tier leagues.
     *
     * @param region Region to query.
     * @return CompletableFuture of League.
     */
    public CompletableFuture<League> getChallengerTierAsync(Region region) {
        return api.getBasicAsync(region, String.format(URL_BASE, region) + URL_SUFFIX_CHALLENGER, TYPE_SINGLE);
    }
    //endregion

    //region master
    /**
     * Get master tier leagues.
     *
     * @param region Region to query.
     * @return League.
     */
    public League getMasterTier(Region region) {
        return api.getBasic(region, String.format(URL_BASE, region) + URL_SUFFIX_MASTER, TYPE_SINGLE);
    }

    /**
     * Asynchronously get master tier leagues.
     *
     * @param region Region to query.
     * @return CompletableFuture of League.
     */
    public CompletableFuture<League> getMasterTierAsync(Region region) {
        return api.getBasicAsync(region, String.format(URL_BASE, region) + URL_SUFFIX_MASTER, TYPE_SINGLE);
    }
    //endregion
}
