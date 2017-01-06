package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Riot API Champion Mastery Endpoint (unversioned).
 *
 * This class provides access to summoner champion mastery information. In addition to the single-champion queries
 * which provide one-to-one correspondence to the Riot API, this class also contains "batch" methods to query a large
 * number of summoners at once.
 *
 * @see RiotApi#championMasteries
 */
public class ChampionMasteryEndpoint {
    /** Relative URL for the summoner endpoint. */
    private static final String URL_BASE = "/championmastery/location/%s/player/";
    /** URL suffix for single champion mastery. */
    private static final String URL_SUFFIX_SINGLE = "/champion/";
    /** URL suffix for all champion masteries. */
    private static final String URL_SUFFIX_ALL = "/champions";
    /** Type for single ChampionMastery. */
    private static Type TYPE_SINGLE = ChampionMastery.class;
    /** Type for list of ChampionMastery. */
    private static Type TYPE_LIST = new TypeToken<List<ChampionMastery>>() {}.getType();

    /** RiotApi reference. */
    private final RiotApi api;

    /**
     * Creates a ChampionMasteryEndpoint.
     * @param api
     */
    ChampionMasteryEndpoint(RiotApi api) {
        this.api = api;
    }

    //region champion
    /**
     * Get a champion mastery by player id and champion id.
     *
     * @param region Region to query.
     * @param championId ChampionId ID. Use {@link com.mingweisamuel.zyra.enums.ChampionId}. See also
     *          <a href="http://ddragon.leagueoflegends.com/tool/">League Data Dragon tool.</a>
     * @param summonerId Summoner ID.
     * @return ChampionMastery. Null if summoner not found.
     */
    public ChampionMastery getChampion(Region region, long championId, long summonerId)  {
        return api.getBasic(region, String.format(URL_BASE, region.platform) +
                summonerId + URL_SUFFIX_SINGLE + championId, TYPE_SINGLE);
    }

    /**
     * Asynchronously get a champion mastery by player id and champion id.
     *
     * @param region Region to query.
     * @param championId ChampionId ID. Use {@link com.mingweisamuel.zyra.enums.ChampionId}. See also
     *          <a href="http://ddragon.leagueoflegends.com/tool/">League Data Dragon tool.</a>
     * @param summonerId Summoner ID.
     * @return CompletableFuture of ChampionMastery. Null if summoner not found.
     */
    public CompletableFuture<ChampionMastery> getChampionAsync(
            Region region, long championId, long summonerId) {
        return api.getBasicAsync(region, String.format(URL_BASE, region.platform) +
                summonerId + URL_SUFFIX_SINGLE + championId, TYPE_SINGLE);
    }
    //endregion

    //region champion-batch
    /**
     * Get champion mastery per summoner by champion id and list of summoner IDs.
     *
     * @param region Region to query.
     * @param championId ChampionId ID. Use {@link com.mingweisamuel.zyra.enums.ChampionId}. See also
     *          <a href="http://ddragon.leagueoflegends.com/tool/">League Data Dragon tool.</a>
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to ChampionMastery. Value null if summoner not found.
     */
    public Map<Long, ChampionMastery> getChampionBatch(Region region, long championId, Long... summonerIds) {
        return getChampionBatch(region, championId, Arrays.asList(summonerIds));
    }

    /**
     * Get champion mastery per summoner by champion id and list of summoner IDs.
     *
     * @param region Region to query.
     * @param championId ChampionId ID. Use {@link com.mingweisamuel.zyra.enums.ChampionId}. See also
     *          <a href="http://ddragon.leagueoflegends.com/tool/">League Data Dragon tool.</a>
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to ChampionMastery. Value null if summoner not found.
     */
    public Map<Long, ChampionMastery> getChampionBatch(Region region, long championId, Iterable<Long> summonerIds) {
        return RiotApi.makeBatch(s -> getChampion(region, championId, s), summonerIds);
    }

    /**
     * Asynchronously get champion mastery per summoner by champion id and list of summoner IDs.
     *
     * @param region Region to query.
     * @param championId ChampionId ID. Use {@link com.mingweisamuel.zyra.enums.ChampionId}. See also
     *          <a href="http://ddragon.leagueoflegends.com/tool/">League Data Dragon tool.</a>
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to ChampionMastery. Value null if summoner not found.
     */
    public CompletableFuture<Map<Long, ChampionMastery>> getChampionBatchAsync(
            Region region, long championId, Long... summonerIds) {
        return getChampionBatchAsync(region, championId, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get champion mastery per summoner by champion id and list of summoner IDs.
     *
     * @param region Region to query.
     * @param championId ChampionId ID. Use {@link com.mingweisamuel.zyra.enums.ChampionId}. See also
     *          <a href="http://ddragon.leagueoflegends.com/tool/">League Data Dragon tool.</a>
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to ChampionMastery. Value null if summoner not found.
     */
    public CompletableFuture<Map<Long, ChampionMastery>> getChampionBatchAsync(
            Region region, long championId, Iterable<Long> summonerIds) {
        return RiotApi.makeBatchAsync(s -> getChampionAsync(region, championId, s), summonerIds);
    }
    //endregion

    //region all
    /**
     * Get all champion mastery entries sorted by number of champion points descending for a single summoner.
     *
     * @param region Region to query.
     * @param summonerId Summoner ID.
     * @return List of ChampionMasterys. Null if summoner not found.
     */
    public List<ChampionMastery> getAll(Region region, long summonerId)  {
        return api.getBasic(region, String.format(URL_BASE, region.platform) +
                summonerId + URL_SUFFIX_ALL, TYPE_LIST);
    }

    /**
     * Asynchronously get all champion mastery entries sorted by number of champion points descending for a single
     * summoner.
     *
     * @param region Region to query.
     * @param summonerId Summoner ID.
     * @return CompletableFuture of List of ChampionMasterys. Null if summoner not found.
     */
    public CompletableFuture<List<ChampionMastery>> getAllAsync(Region region, long summonerId) {
        return api.getBasicAsync(region, String.format(URL_BASE, region.platform) +
                summonerId + URL_SUFFIX_ALL, TYPE_LIST);
    }
    //endregion

    //region all-batch
    /**
     * Get all champion mastery entries sorted by number of champion points descending for a batch of multiple
     * summoners.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to List of ChampionMasterys. Value is null if summoner not found.
     */
    public Map<Long, List<ChampionMastery>> getAllBatch(Region region, Long... summonerIds) {
        return getAllBatch(region, Arrays.asList(summonerIds));
    }

    /**
     * Get all champion mastery entries sorted by number of champion points descending for a batch of multiple
     * summoners.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return Map from summoner ID (Long) to List of ChampionMasterys. Value is null if summoner not found.
     */
    public Map<Long, List<ChampionMastery>> getAllBatch(Region region, Iterable<Long> summonerIds) {
        return RiotApi.makeBatch(s -> getAll(region, s), summonerIds);
    }

    /**
     * Asynchronously get all champion mastery entries sorted by number of champion points descending for a batch of
     * multiple summoners.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to List of ChampionMasterys. Value is null if summoner
     * not found.
     */
    public CompletableFuture<Map<Long, List<ChampionMastery>>> getAllBatchAsync(
            Region region, Long... summonerIds) {
        return getAllBatchAsync(region, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get all champion mastery entries sorted by number of champion points descending for a batch of
     * multiple summoners.
     *
     * @param region Region to query.
     * @param summonerIds Summoner IDs.
     * @return CompletableFuture of Map from summoner ID (Long) to List of ChampionMasterys. Value is null if summoner
     * not found.
     */
    public CompletableFuture<Map<Long, List<ChampionMastery>>> getAllBatchAsync(
            Region region, Iterable<Long> summonerIds) {
        return RiotApi.makeBatchAsync(s -> getAllAsync(region, s), summonerIds);
    }
    //endregion
}
