package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.dto.PlayerStatsSummaryList;
import com.mingweisamuel.zyra.dto.RankedStats;
import com.mingweisamuel.zyra.enums.Region;
import org.asynchttpclient.Param;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Riot API Stats Endpoint (v1.3).
 *
 * Provides access to summoner overall and per-champion summary statistics for either ranked or all queues. In addition
 * to the single-champion queries which provide one-to-one correspondence to the Riot API, this class also contains
 * methods suffixed with "batch" to query a large number of summoners at once.
 *
 * @see RiotApi#stats
 */
public class StatsEndpoint {

    /** Relative URL for the stats endpoint. */
    private static final String URL_BASE = "api/lol/%s/v1.3/stats/by-summoner/";
    /** URL suffix for ranked summary stats. */
    private static final String URL_SUFFIX_RANKED = "/ranked";
    /** URL suffix for overal summary stats. */
    private static final String URL_SUFFIX_SUMMARY = "/summary";
    /** Type for ranked stats. */
    private static final Type TYPE_RANKED = RankedStats.class;
    /** Param name for season. */
    private static final String PARAM_SEASON = "season";

    /** RiotApi reference. */
    private final RiotApi api;

    /**
     * Creates a StatsEndpoint.
     * @param api RiotApi reference.
     */
    StatsEndpoint(RiotApi api) {
        this.api = api;
    }

    //region ranked
    /**
     * Get ranked stats by summoner ID.
     *
     * Includes ranked stats for Twisted Treeline and Summoner's Rift.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerId Summoner ID to query.
     * @return RankedStats instance. Null if summoner not found.
     */
    public RankedStats getRanked(Region region, String season, long summonerId) {
        return api.getBasic(region, String.format(URL_BASE, region) + summonerId + URL_SUFFIX_RANKED, TYPE_RANKED,
                new Param(PARAM_SEASON, season));
    }

    /**
     * Asynchronously get ranked stats by summoner ID.
     *
     * Includes ranked stats for Twisted Treeline and Summoner's Rift.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerId Summoner ID to query.
     * @return CompletableFuture of RankedStats instance. Null if summoner not found.
     */
    public CompletableFuture<RankedStats> getRankedAsync(Region region, String season, long summonerId) {
        return api.getBasicAsync(region, String.format(URL_BASE, region) + summonerId + URL_SUFFIX_RANKED, TYPE_RANKED,
                new Param(PARAM_SEASON, season));
    }
    //endregion

    //region ranked-batch
    /**
     * Gets ranked stats for summoners by batch of summoner IDs.
     *
     * Includes ranked stats for Twisted Treeline and Summoner's Rift.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerIds Summoner IDs to query.
     * @return Map from summoner ID (Long) to RankedStats. Value null if summoner not found.
     */
    public Map<Long, RankedStats> getRankedBatch(Region region, String season, Long... summonerIds) {
        return getRankedBatch(region, season, Arrays.asList(summonerIds));
    }

    /**
     * Gets ranked stats for summoners by batch of summoner IDs.
     *
     * Includes ranked stats for Twisted Treeline and Summoner's Rift.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerIds Summoner IDs to query.
     * @return Map from summoner ID (Long) to RankedStats. Value null if summoner not found.
     */
    public Map<Long, RankedStats> getRankedBatch(Region region, String season, Iterable<Long> summonerIds) {
        return RiotApi.makeBatch(s -> getRanked(region, season, s), summonerIds);
    }

    /**
     * Asynchronously gets ranked stats for summoners by batch of summoner IDs.
     *
     * Includes ranked stats for Twisted Treeline and Summoner's Rift.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerIds Summoner IDs to query.
     * @return CompletableFuture of Map from summoner ID (Long) to RankedStats. Value null if summoner not found.
     */
    public CompletableFuture<Map<Long, RankedStats>> getRankedBatchAsync(
            Region region, String season, Long... summonerIds) {
        return getRankedBatchAsync(region, season, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously gets ranked stats for summoners by batch of summoner IDs.
     *
     * Includes ranked stats for Twisted Treeline and Summoner's Rift.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerIds Summoner IDs to query.
     * @return CompletableFuture of Map from summoner ID (Long) to RankedStats. Value null if summoner not found.
     */
    public CompletableFuture<Map<Long, RankedStats>> getRankedBatchAsync(
            Region region, String season, Iterable<Long> summonerIds) {
        return RiotApi.makeBatchAsync(s -> getRankedAsync(region, season, s), summonerIds);
    }
    //endregion

    //region summary
    /**
     * Get player stats summaries by summoner ID.
     *
     * One summary is returned per queue type.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerId Summoner ID to query.
     * @return PlayerStatsSummaryList instance. Null if summoner not found.
     */
    public PlayerStatsSummaryList getSummary(Region region, String season, long summonerId) {
        return api.getBasic(region, String.format(URL_BASE, region) + summonerId + URL_SUFFIX_SUMMARY, TYPE_RANKED);
    }

    /**
     * Asynchronously get player stats summaries by summoner ID.
     *
     * One summary is returned per queue type.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerId Summoner ID to query.
     * @return CompletableFuture of PlayerStatsSummaryList instance. Null if summoner not found.
     */
    public CompletableFuture<PlayerStatsSummaryList> getSummaryAsync(Region region, String season, long summonerId) {
        return api.getBasicAsync(region, String.format(URL_BASE, region) + summonerId + URL_SUFFIX_SUMMARY, TYPE_RANKED);
    }
    //endregion

    //region summary-batch
    /**
     * Get batch of player stats summaries by summoner IDs.
     *
     * One summary is returned per queue type.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerIds Summoner IDs to query.
     * @return Map from summoner ID (Long) to PlayerStatsSummaryList instance. Value null if summoner not found.
     */
    public Map<Long, PlayerStatsSummaryList> getSummaryBatch(Region region, String season, Long... summonerIds) {
        return RiotApi.makeBatch(s -> getSummary(region, season, s), Arrays.asList(summonerIds));
    }

    /**
     * Get batch of player stats summaries by summoner IDs.
     *
     * One summary is returned per queue type.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerIds Summoner IDs to query.
     * @return Map from summoner ID (Long) to PlayerStatsSummaryList instance. Value null if summoner not found.
     */
    public Map<Long, PlayerStatsSummaryList> getSummaryBatch(Region region, String season, Iterable<Long> summonerIds) {
        return RiotApi.makeBatch(s -> getSummary(region, season, s), summonerIds);
    }

    /**
     * Asynchronously get batch of player stats summaries by summoner IDs.
     *
     * One summary is returned per queue type.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerIds Summoner IDs to query.
     * @return CompletableFuture of Map from summoner ID (Long) to PlayerStatsSummaryList instance. Value null if
     * summoner not found.
     */
    public CompletableFuture<Map<Long, PlayerStatsSummaryList>> getSummaryBatchAsync(
            Region region, String season, Long... summonerIds) {
        return getSummaryBatchAsync(region, season, Arrays.asList(summonerIds));
    }

    /**
     * Asynchronously get batch of player stats summaries by summoner IDs.
     *
     * One summary is returned per queue type.
     *
     * @param region Region to query.
     * @param season {@link com.mingweisamuel.zyra.enums.Season}.
     * @param summonerIds Summoner IDs to query.
     * @return CompletableFuture of Map from summoner ID (Long) to PlayerStatsSummaryList instance. Value null if
     * summoner not found.
     */
    public CompletableFuture<Map<Long, PlayerStatsSummaryList>> getSummaryBatchAsync(
            Region region, String season, Iterable<Long> summonerIds) {
        return RiotApi.makeBatchAsync(s -> getSummaryAsync(region, season, s), summonerIds);
    }
    //endregion
}
