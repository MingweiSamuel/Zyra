package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.Match;
import com.mingweisamuel.zyra.match.MatchTimeline;
import com.mingweisamuel.zyra.match.Matchlist;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * match-v3
 * This class is automatically generated and should not be modified directly.
 */
public final class MatchEndpoints extends Endpoints {
  MatchEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Link to Portal</a><br>
   * @param region Region to execute against.@param matchId (required) The match ID.
   */
  public Match getMatch(final Region region, final long matchId) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/matches/%1$s", matchId);
    Type type = Match.class;
    return riotApi.getBasic(url, region, type);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.@param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endIndex (optional) The end index to use for filtering matchlist.
   * @param season (optional) Set of season IDs for which to filtering matchlist.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   * @param beginIndex (optional) The begin index to use for filtering matchlist.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Integer endIndex,
      final List<Integer> season, final List<Integer> champion, final Integer beginIndex,
      final Long endTime) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/matchlists/by-account/%1$s", accountId);
    Type type = Matchlist.class;
    return riotApi.getBasic(url, region, type, RiotApi.makeParams("queue", queue, "beginTime", beginTime, "endIndex", endIndex, "season", season, "champion", champion, "beginIndex", beginIndex, "endTime", endTime)));}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.@param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endIndex (optional) The end index to use for filtering matchlist.
   * @param season (optional) Set of season IDs for which to filtering matchlist.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   * @param beginIndex (optional) The begin index to use for filtering matchlist.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Integer endIndex,
      final List<Integer> season, final List<Integer> champion, final Integer beginIndex) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, beginTime, endIndex, season, champion, beginIndex, null);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.@param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endIndex (optional) The end index to use for filtering matchlist.
   * @param season (optional) Set of season IDs for which to filtering matchlist.
   * @param champion (optional) Set of champion IDs for which to filtering matchlist.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Integer endIndex,
      final List<Integer> season, final List<Integer> champion) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, beginTime, endIndex, season, champion, null, null);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.@param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endIndex (optional) The end index to use for filtering matchlist.
   * @param season (optional) Set of season IDs for which to filtering matchlist.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Integer endIndex,
      final List<Integer> season) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, beginTime, endIndex, season, null, null, null);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.@param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   * @param endIndex (optional) The end index to use for filtering matchlist.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime, final Integer endIndex) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, beginTime, endIndex, null, null, null, null);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.@param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue, final Long beginTime) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, beginTime, null, null, null, null, null);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.@param accountId (required) The account ID.
   * @param queue (optional) Set of queue IDs for which to filtering matchlist.
   */
  public Matchlist getMatchlist(final Region region, final long accountId,
      final List<Integer> queue) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, queue, null, null, null, null, null, null);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Link to Portal</a><br>
   * Implementation Notes:<br>
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned. Note that if either beginIndex or endIndex are specified, then both must be specified and endIndex must be greater than beginIndex. If endTime is specified, but not beginTime, then beginTime is effectively the start of the account's match history. If beginTime is specified, but not endTime, then endTime is effectively the current time. Note that endTime should be greater than beginTime if both are specified, although there is no maximum limit on their range.
   * @param region Region to execute against.@param accountId (required) The account ID.
   */
  public Matchlist getMatchlist(final Region region, final long accountId) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, accountId, null, null, null, null, null, null, null);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getRecentMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.@param accountId (required) The account ID.
   */
  public Matchlist getRecentMatchlist(final Region region, final long accountId) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/matchlists/by-account/%1$s/recent", accountId);
    Type type = Matchlist.class;
    return riotApi.getBasic(url, region, type);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all matches have timeline data.
   * @param region Region to execute against.@param matchId (required) The match ID.
   */
  public MatchTimeline getMatchTimeline(final Region region, final long matchId) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v3/timelines/by-match/%1$s", matchId);
    Type type = MatchTimeline.class;
    return riotApi.getBasic(url, region, type);}
}
