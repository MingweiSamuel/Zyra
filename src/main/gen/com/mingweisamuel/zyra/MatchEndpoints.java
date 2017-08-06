package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.Match;
import com.mingweisamuel.zyra.match.MatchTimeline;
import com.mingweisamuel.zyra.match.Matchlist;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * match-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class MatchEndpoints extends Endpoints {
  MatchEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get match by match ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   * @param forAccountId (optional) If provided, used to identify the participant to be unobfuscated.
   * @param forPlatformId (optional) If provided, used to identify the participant to be unobfuscated.
   */
  public Match getMatch(final Region region, final long matchId, final Long forAccountId,
      final String forPlatformId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/matches/%1$s", matchId);
    Type type = Match.class;
    return riotApi.getBasic("match-v3_GET_getMatch_content", url, region, type, riotApi.makeParams("forAccountId", forAccountId, "forPlatformId", forPlatformId));
  }

  /**
   * Get match by match ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   * @param forAccountId (optional) If provided, used to identify the participant to be unobfuscated.
   * @param forPlatformId (optional) If provided, used to identify the participant to be unobfuscated.
   */
  public CompletableFuture<Match> getMatchAsync(final Region region, final long matchId,
      final Long forAccountId, final String forPlatformId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/matches/%1$s", matchId);
    Type type = Match.class;
    return riotApi.getBasicAsync("match-v3_GET_getMatch_content", url, region, type, riotApi.makeParams("forAccountId", forAccountId, "forPlatformId", forPlatformId));
  }

  /**
   * Get match by match ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   * @param forAccountId (optional) If provided, used to identify the participant to be unobfuscated.
   */
  public Match getMatch(final Region region, final long matchId, final Long forAccountId) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatch(region, matchId, forAccountId, null);
  }

  /**
   * Get match by match ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   * @param forAccountId (optional) If provided, used to identify the participant to be unobfuscated.
   */
  public CompletableFuture<Match> getMatchAsync(final Region region, final long matchId,
      final Long forAccountId) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchAsync(region, matchId, forAccountId, null);
  }

  /**
   * Get match by match ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   */
  public Match getMatch(final Region region, final long matchId) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatch(region, matchId, null, null);
  }

  /**
   * Get match by match ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   */
  public CompletableFuture<Match> getMatchAsync(final Region region, final long matchId) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchAsync(region, matchId, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   * @param season (optional) Set of season IDs for which to filtering matchlist.
   * @param beginIndex (optional) The begin index to use for filtering matchlist.
   * @param endIndex (optional) The end index to use for filtering matchlist.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Long endTime,
      final List<Integer> champion, final List<Integer> season, final Integer beginIndex,
      final Integer endIndex) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/matchlists/by-account/%1$s", accountId);
    Type type = Matchlist.class;
    return riotApi.getBasic("match-v3_GET_getMatchlist_content", url, region, type, riotApi.makeParams("queue", queue, "beginTime", beginTime, "endTime", endTime, "champion", champion, "season", season, "beginIndex", beginIndex, "endIndex", endIndex));
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   * @param season (optional) Set of season IDs for which to filtering matchlist.
   * @param beginIndex (optional) The begin index to use for filtering matchlist.
   * @param endIndex (optional) The end index to use for filtering matchlist.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Long endTime,
      final List<Integer> champion, final List<Integer> season, final Integer beginIndex,
      final Integer endIndex) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/matchlists/by-account/%1$s", accountId);
    Type type = Matchlist.class;
    return riotApi.getBasicAsync("match-v3_GET_getMatchlist_content", url, region, type, riotApi.makeParams("queue", queue, "beginTime", beginTime, "endTime", endTime, "champion", champion, "season", season, "beginIndex", beginIndex, "endIndex", endIndex));
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   * @param season (optional) Set of season IDs for which to filtering matchlist.
   * @param beginIndex (optional) The begin index to use for filtering matchlist.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Long endTime,
      final List<Integer> champion, final List<Integer> season, final Integer beginIndex) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, beginTime, endTime, champion, season, beginIndex, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   * @param season (optional) Set of season IDs for which to filtering matchlist.
   * @param beginIndex (optional) The begin index to use for filtering matchlist.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Long endTime,
      final List<Integer> champion, final List<Integer> season, final Integer beginIndex) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, accountId, queue, beginTime, endTime, champion, season, beginIndex, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   * @param season (optional) Set of season IDs for which to filtering matchlist.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Long endTime,
      final List<Integer> champion, final List<Integer> season) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, beginTime, endTime, champion, season, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   * @param season (optional) Set of season IDs for which to filtering matchlist.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Long endTime,
      final List<Integer> champion, final List<Integer> season) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, accountId, queue, beginTime, endTime, champion, season, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Long endTime,
      final List<Integer> champion) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, beginTime, endTime, champion, null, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Long endTime,
      final List<Integer> champion) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, accountId, queue, beginTime, endTime, champion, null, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Long endTime) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, beginTime, endTime, null, null, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Long endTime) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, accountId, queue, beginTime, endTime, null, null, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, beginTime, null, null, null, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, accountId, queue, beginTime, null, null, null, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, null, null, null, null, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region, final long accountId,
      final List<Integer> queue) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, accountId, queue, null, null, null, null, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   */
  public Matchlist getMatchlist(final Region region, final long accountId) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, null, null, null, null, null, null, null);
  }

  /**
   * Get matchlist for ranked games played on given account ID and platform ID and filtered using given filter parameters, if any.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region, final long accountId) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, accountId, null, null, null, null, null, null, null);
  }

  /**
   * Get matchlist for last 20 matches played on given account ID and platform ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getRecentMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   */
  public Matchlist getRecentMatchlist(final Region region, final long accountId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/matchlists/by-account/%1$s/recent", accountId);
    Type type = Matchlist.class;
    return riotApi.getBasic("match-v3_GET_getRecentMatchlist_content", url, region, type, Collections.emptyList());
  }

  /**
   * Get matchlist for last 20 matches played on given account ID and platform ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getRecentMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param accountId (required) The account ID.
   */
  public CompletableFuture<Matchlist> getRecentMatchlistAsync(final Region region,
      final long accountId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/matchlists/by-account/%1$s/recent", accountId);
    Type type = Matchlist.class;
    return riotApi.getBasicAsync("match-v3_GET_getRecentMatchlist_content", url, region, type, Collections.emptyList());
  }

  /**
   * Get match timeline by match ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all matches have timeline data.
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   */
  public MatchTimeline getMatchTimeline(final Region region, final long matchId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/timelines/by-match/%1$s", matchId);
    Type type = MatchTimeline.class;
    return riotApi.getBasic("match-v3_GET_getMatchTimeline_content", url, region, type, Collections.emptyList());
  }

  /**
   * Get match timeline by match ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all matches have timeline data.
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   */
  public CompletableFuture<MatchTimeline> getMatchTimelineAsync(final Region region,
      final long matchId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/timelines/by-match/%1$s", matchId);
    Type type = MatchTimeline.class;
    return riotApi.getBasicAsync("match-v3_GET_getMatchTimeline_content", url, region, type, Collections.emptyList());
  }
}
