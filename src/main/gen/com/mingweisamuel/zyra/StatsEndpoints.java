package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.stats.PlayerStatsSummaryList;
import com.mingweisamuel.zyra.stats.RankedStats;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version stats-v1.3 */
public class StatsEndpoints {
  private static final Type GET_RANKED__TYPE = RankedStats.class;

  private static final String GET_RANKED__URL = "/api/lol/%1$s/v1.3/stats/by-summoner/%2$s/ranked";

  private static final Type GET_SUMMARY__TYPE = PlayerStatsSummaryList.class;

  private static final String GET_SUMMARY__URL = "/api/lol/%1$s/v1.3/stats/by-summoner/%2$s/summary";

  private final RiotApi riotApi;

  public StatsEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * Includes ranked stats for Twisted Treeline and Summoner's Rift.
   *
   * @param region Region to query.
   * @param summonerId Riot API description: ID of the summoner for which to retrieve ranked stats.
   * @param season Riot API description: If specified, stats for the given season are returned. Otherwise, stats for the current season are returned. */
  public RankedStats getRanked(final Region region, final long summonerId, final String season)
      throws ExecutionException {
    return riotApi.getBasic(String.format(GET_RANKED__URL, region, summonerId), region, GET_RANKED__TYPE,
        riotApi.makeParams("season", season));}

  /**
   * Includes ranked stats for Twisted Treeline and Summoner's Rift.
   *
   * @param region Region to query.
   * @param summonerId Riot API description: ID of the summoner for which to retrieve ranked stats.
   * @param season Riot API description: If specified, stats for the given season are returned. Otherwise, stats for the current season are returned. */
  public CompletableFuture<RankedStats> getRankedAsync(final Region region, final long summonerId,
      final String season) {
    return riotApi.getBasicAsync(String.format(GET_RANKED__URL, region, summonerId), region, GET_RANKED__TYPE,
        riotApi.makeParams("season", season));}

  /**
   * Includes ranked stats for Twisted Treeline and Summoner's Rift.
   *
   * @param region Region to query.
   * @param summonerId Riot API description: ID of the summoner for which to retrieve ranked stats. */
  public RankedStats getRanked(final Region region, final long summonerId) throws
      ExecutionException {
    return getRanked(region, summonerId, null);}

  /**
   * Includes ranked stats for Twisted Treeline and Summoner's Rift.
   *
   * @param region Region to query.
   * @param summonerId Riot API description: ID of the summoner for which to retrieve ranked stats. */
  public CompletableFuture<RankedStats> getRankedAsync(final Region region, final long summonerId) {
    return getRankedAsync(region, summonerId, null);}

  /**
   * One summary is returned per queue type.
   *
   * @param region Region to query.
   * @param summonerId Riot API description: ID of the summoner for which to retrieve player stats.
   * @param season Riot API description: If specified, stats for the given season are returned. Otherwise, stats for the current season are returned. */
  public PlayerStatsSummaryList getSummary(final Region region, final long summonerId,
      final String season) throws ExecutionException {
    return riotApi.getBasic(String.format(GET_SUMMARY__URL, region, summonerId), region, GET_SUMMARY__TYPE,
        riotApi.makeParams("season", season));}

  /**
   * One summary is returned per queue type.
   *
   * @param region Region to query.
   * @param summonerId Riot API description: ID of the summoner for which to retrieve player stats.
   * @param season Riot API description: If specified, stats for the given season are returned. Otherwise, stats for the current season are returned. */
  public CompletableFuture<PlayerStatsSummaryList> getSummaryAsync(final Region region,
      final long summonerId, final String season) {
    return riotApi.getBasicAsync(String.format(GET_SUMMARY__URL, region, summonerId), region, GET_SUMMARY__TYPE,
        riotApi.makeParams("season", season));}

  /**
   * One summary is returned per queue type.
   *
   * @param region Region to query.
   * @param summonerId Riot API description: ID of the summoner for which to retrieve player stats. */
  public PlayerStatsSummaryList getSummary(final Region region, final long summonerId) throws
      ExecutionException {
    return getSummary(region, summonerId, null);}

  /**
   * One summary is returned per queue type.
   *
   * @param region Region to query.
   * @param summonerId Riot API description: ID of the summoner for which to retrieve player stats. */
  public CompletableFuture<PlayerStatsSummaryList> getSummaryAsync(final Region region,
      final long summonerId) {
    return getSummaryAsync(region, summonerId, null);}
}
