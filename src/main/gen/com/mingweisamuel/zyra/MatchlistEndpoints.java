package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.matchlist.MatchList;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version matchlist-v2.2 */
public class MatchlistEndpoints {
  private static final Type GET__TYPE = MatchList.class;

  private static final String GET__URL = "/api/lol/%1s/v2.2/matchlist/by-summoner/%2s";

  private final RiotApi riotApi;

  public MatchlistEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
   * @param seasons Riot API description: list of seasons to use for fetching games.
   * @param beginTime Riot API description: The begin time to use for fetching games specified as epoch milliseconds.
   * @param endTime Riot API description: The end time to use for fetching games specified as epoch milliseconds.
   * @param beginIndex Riot API description: The begin index to use for fetching games.
   * @param endIndex Riot API description: The end index to use for fetching games. */
  public MatchList get(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues,
      final Collection<String> seasons, final Long beginTime, final Long endTime,
      final Integer beginIndex, final Integer endIndex) throws ExecutionException {
    return riotApi.getBasic(String.format(GET__URL, region, summonerId, beginTime, endTime, beginIndex, endIndex), region, GET__TYPE,
    RiotApi.makeParams("championIds", championIds, "rankedQueues", rankedQueues, "seasons", seasons, "beginTime", beginTime, "endTime", endTime, "beginIndex", beginIndex, "endIndex", endIndex));}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
   * @param seasons Riot API description: list of seasons to use for fetching games.
   * @param beginTime Riot API description: The begin time to use for fetching games specified as epoch milliseconds.
   * @param endTime Riot API description: The end time to use for fetching games specified as epoch milliseconds.
   * @param beginIndex Riot API description: The begin index to use for fetching games.
   * @param endIndex Riot API description: The end index to use for fetching games. */
  public CompletableFuture<MatchList> getAsync(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues,
      final Collection<String> seasons, final Long beginTime, final Long endTime,
      final Integer beginIndex, final Integer endIndex) {
    return riotApi.getBasicAsync(String.format(GET__URL, region, summonerId, beginTime, endTime, beginIndex, endIndex), region, GET__TYPE,
    RiotApi.makeParams("championIds", championIds, "rankedQueues", rankedQueues, "seasons", seasons, "beginTime", beginTime, "endTime", endTime, "beginIndex", beginIndex, "endIndex", endIndex));}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
   * @param seasons Riot API description: list of seasons to use for fetching games.
   * @param beginTime Riot API description: The begin time to use for fetching games specified as epoch milliseconds.
   * @param endTime Riot API description: The end time to use for fetching games specified as epoch milliseconds.
   * @param beginIndex Riot API description: The begin index to use for fetching games. */
  public MatchList get(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues,
      final Collection<String> seasons, final Long beginTime, final Long endTime,
      final Integer beginIndex) throws ExecutionException {
    return get(region, summonerId, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
   * @param seasons Riot API description: list of seasons to use for fetching games.
   * @param beginTime Riot API description: The begin time to use for fetching games specified as epoch milliseconds.
   * @param endTime Riot API description: The end time to use for fetching games specified as epoch milliseconds.
   * @param beginIndex Riot API description: The begin index to use for fetching games. */
  public CompletableFuture<MatchList> getAsync(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues,
      final Collection<String> seasons, final Long beginTime, final Long endTime,
      final Integer beginIndex) {
    return getAsync(region, summonerId, championIds, rankedQueues, seasons, beginTime, endTime, beginIndex, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
   * @param seasons Riot API description: list of seasons to use for fetching games.
   * @param beginTime Riot API description: The begin time to use for fetching games specified as epoch milliseconds.
   * @param endTime Riot API description: The end time to use for fetching games specified as epoch milliseconds. */
  public MatchList get(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues,
      final Collection<String> seasons, final Long beginTime, final Long endTime) throws
      ExecutionException {
    return get(region, summonerId, championIds, rankedQueues, seasons, beginTime, endTime, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
   * @param seasons Riot API description: list of seasons to use for fetching games.
   * @param beginTime Riot API description: The begin time to use for fetching games specified as epoch milliseconds.
   * @param endTime Riot API description: The end time to use for fetching games specified as epoch milliseconds. */
  public CompletableFuture<MatchList> getAsync(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues,
      final Collection<String> seasons, final Long beginTime, final Long endTime) {
    return getAsync(region, summonerId, championIds, rankedQueues, seasons, beginTime, endTime, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
   * @param seasons Riot API description: list of seasons to use for fetching games.
   * @param beginTime Riot API description: The begin time to use for fetching games specified as epoch milliseconds. */
  public MatchList get(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues,
      final Collection<String> seasons, final Long beginTime) throws ExecutionException {
    return get(region, summonerId, championIds, rankedQueues, seasons, beginTime, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
   * @param seasons Riot API description: list of seasons to use for fetching games.
   * @param beginTime Riot API description: The begin time to use for fetching games specified as epoch milliseconds. */
  public CompletableFuture<MatchList> getAsync(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues,
      final Collection<String> seasons, final Long beginTime) {
    return getAsync(region, summonerId, championIds, rankedQueues, seasons, beginTime, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
   * @param seasons Riot API description: list of seasons to use for fetching games. */
  public MatchList get(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues,
      final Collection<String> seasons) throws ExecutionException {
    return get(region, summonerId, championIds, rankedQueues, seasons, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored.
   * @param seasons Riot API description: list of seasons to use for fetching games. */
  public CompletableFuture<MatchList> getAsync(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues,
      final Collection<String> seasons) {
    return getAsync(region, summonerId, championIds, rankedQueues, seasons, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored. */
  public MatchList get(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues) throws
      ExecutionException {
    return get(region, summonerId, championIds, rankedQueues, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games.
   * @param rankedQueues Riot API description: list of ranked queue types to use for fetching games. Non-ranked queue types will be ignored. */
  public CompletableFuture<MatchList> getAsync(final Region region, final long summonerId,
      final Collection<String> championIds, final Collection<String> rankedQueues) {
    return getAsync(region, summonerId, championIds, rankedQueues, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games. */
  public MatchList get(final Region region, final long summonerId,
      final Collection<String> championIds) throws ExecutionException {
    return get(region, summonerId, championIds, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner.
   * @param championIds Riot API description: list of champion IDs to use for fetching games. */
  public CompletableFuture<MatchList> getAsync(final Region region, final long summonerId,
      final Collection<String> championIds) {
    return getAsync(region, summonerId, championIds, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner. */
  public MatchList get(final Region region, final long summonerId) throws ExecutionException {
    return get(region, summonerId, null);}

  /**
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested summoner, otherwise, no matches may be returned. If either of the beginTime or endTime parameters is set, they must both be set, although there is no maximum limit on their range. If the beginTime parameter is specified on its own, endTime is assumed to be the current time. If the endTime parameter is specified on its own, beginTime is assumed to be the start of the summoner's match history.
   *
   * @param summonerId Riot API description: The ID of the summoner. */
  public CompletableFuture<MatchList> getAsync(final Region region, final long summonerId) {
    return getAsync(region, summonerId, null);}
}
