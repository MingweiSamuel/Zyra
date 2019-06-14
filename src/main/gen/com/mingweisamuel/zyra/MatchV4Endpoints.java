package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.matchV4.Match;
import com.mingweisamuel.zyra.matchV4.MatchTimeline;
import com.mingweisamuel.zyra.matchV4.Matchlist;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * match-v4 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class MatchV4Endpoints extends Endpoints {
  MatchV4Endpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get match IDs by tournament code.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchIdsByTournamentCode">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param tournamentCode (required) The tournament code.
   */
  public List<Long> getMatchIdsByTournamentCode(final Region region, final String tournamentCode) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v4/matches/by-tournament-code/%1$s/ids", tournamentCode);
    Type type = new TypeToken<List<Long>>() {
    }.getType();
    return riotApi.getBasic("match-v4.getMatchIdsByTournamentCode", url, region, type, Collections.emptyList());
  }

  /**
   * Get match IDs by tournament code.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchIdsByTournamentCode">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param tournamentCode (required) The tournament code.
   */
  public CompletableFuture<List<Long>> getMatchIdsByTournamentCodeAsync(final Region region,
      final String tournamentCode) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v4/matches/by-tournament-code/%1$s/ids", tournamentCode);
    Type type = new TypeToken<List<Long>>() {
    }.getType();
    return riotApi.getBasicAsync("match-v4.getMatchIdsByTournamentCode", url, region, type, Collections.emptyList());
  }

  /**
   * Get match by match ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatch">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   */
  public Match getMatch(final Region region, final long matchId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v4/matches/%1$s", matchId);
    Type type = Match.class;
    return riotApi.getBasic("match-v4.getMatch", url, region, type, Collections.emptyList());
  }

  /**
   * Get match by match ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatch">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   */
  public CompletableFuture<Match> getMatchAsync(final Region region, final long matchId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v4/matches/%1$s", matchId);
    Type type = Match.class;
    return riotApi.getBasicAsync("match-v4.getMatch", url, region, type, Collections.emptyList());
  }

  /**
   * Get match by match ID and tournament code.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchByTournamentCode">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param tournamentCode (required) The tournament code.
   * @param matchId (required) The match ID.
   */
  public Match getMatchByTournamentCode(final Region region, final String tournamentCode,
      final long matchId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v4/matches/%1$s/by-tournament-code/%2$s", tournamentCode, matchId);
    Type type = Match.class;
    return riotApi.getBasic("match-v4.getMatchByTournamentCode", url, region, type, Collections.emptyList());
  }

  /**
   * Get match by match ID and tournament code.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchByTournamentCode">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param tournamentCode (required) The tournament code.
   * @param matchId (required) The match ID.
   */
  public CompletableFuture<Match> getMatchByTournamentCodeAsync(final Region region,
      final String tournamentCode, final long matchId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v4/matches/%1$s/by-tournament-code/%2$s", tournamentCode, matchId);
    Type type = Match.class;
    return riotApi.getBasicAsync("match-v4.getMatchByTournamentCode", url, region, type, Collections.emptyList());
  }

  /**
   * Get match timeline by match ID.
   * ## Implementation Notes
   * Not all matches have timeline data.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchTimeline">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   */
  public MatchTimeline getMatchTimeline(final Region region, final long matchId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v4/timelines/by-match/%1$s", matchId);
    Type type = MatchTimeline.class;
    return riotApi.getBasic("match-v4.getMatchTimeline", url, region, type, Collections.emptyList());
  }

  /**
   * Get match timeline by match ID.
   * ## Implementation Notes
   * Not all matches have timeline data.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchTimeline">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param matchId (required) The match ID.
   */
  public CompletableFuture<MatchTimeline> getMatchTimelineAsync(final Region region,
      final long matchId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v4/timelines/by-match/%1$s", matchId);
    Type type = MatchTimeline.class;
    return riotApi.getBasicAsync("match-v4.getMatchTimeline", url, region, type, Collections.emptyList());
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   */
  public Matchlist getMatchlist(final Region region, final String encryptedAccountId) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, encryptedAccountId, null, null, null, null, null, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region,
      final String encryptedAccountId) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, encryptedAccountId, null, null, null, null, null, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   */
  public Matchlist getMatchlist(final Region region, final String encryptedAccountId,
      final List<Integer> champion) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, encryptedAccountId, champion, null, null, null, null, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region,
      final String encryptedAccountId, final List<Integer> champion) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, encryptedAccountId, champion, null, null, null, null, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   */
  public Matchlist getMatchlist(final Region region, final String encryptedAccountId,
      final List<Integer> champion, final List<Integer> queue) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, encryptedAccountId, champion, queue, null, null, null, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region,
      final String encryptedAccountId, final List<Integer> champion, final List<Integer> queue) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, encryptedAccountId, champion, queue, null, null, null, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   * @param season (optional) Set of season IDs for filtering the matchlist.
   */
  public Matchlist getMatchlist(final Region region, final String encryptedAccountId,
      final List<Integer> champion, final List<Integer> queue, final List<Integer> season) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, encryptedAccountId, champion, queue, season, null, null, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   * @param season (optional) Set of season IDs for filtering the matchlist.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region,
      final String encryptedAccountId, final List<Integer> champion, final List<Integer> queue,
      final List<Integer> season) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, encryptedAccountId, champion, queue, season, null, null, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   * @param season (optional) Set of season IDs for filtering the matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   */
  public Matchlist getMatchlist(final Region region, final String encryptedAccountId,
      final List<Integer> champion, final List<Integer> queue, final List<Integer> season,
      final Long beginTime) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, encryptedAccountId, champion, queue, season, beginTime, null, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   * @param season (optional) Set of season IDs for filtering the matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region,
      final String encryptedAccountId, final List<Integer> champion, final List<Integer> queue,
      final List<Integer> season, final Long beginTime) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, encryptedAccountId, champion, queue, season, beginTime, null, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   * @param season (optional) Set of season IDs for filtering the matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   */
  public Matchlist getMatchlist(final Region region, final String encryptedAccountId,
      final List<Integer> champion, final List<Integer> queue, final List<Integer> season,
      final Long beginTime, final Long endTime) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, encryptedAccountId, champion, queue, season, beginTime, endTime, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   * @param season (optional) Set of season IDs for filtering the matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region,
      final String encryptedAccountId, final List<Integer> champion, final List<Integer> queue,
      final List<Integer> season, final Long beginTime, final Long endTime) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, encryptedAccountId, champion, queue, season, beginTime, endTime, null, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   * @param season (optional) Set of season IDs for filtering the matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   * @param beginIndex (optional) The begin index to use for filtering matchlist.  If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   */
  public Matchlist getMatchlist(final Region region, final String encryptedAccountId,
      final List<Integer> champion, final List<Integer> queue, final List<Integer> season,
      final Long beginTime, final Long endTime, final Integer beginIndex) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlist(region, encryptedAccountId, champion, queue, season, beginTime, endTime, beginIndex, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   * @param season (optional) Set of season IDs for filtering the matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   * @param beginIndex (optional) The begin index to use for filtering matchlist.  If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region,
      final String encryptedAccountId, final List<Integer> champion, final List<Integer> queue,
      final List<Integer> season, final Long beginTime, final Long endTime,
      final Integer beginIndex) {
    // This method is automatically generated and should not be modified directly.
    return this.getMatchlistAsync(region, encryptedAccountId, champion, queue, season, beginTime, endTime, beginIndex, null);
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   * @param season (optional) Set of season IDs for filtering the matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   * @param beginIndex (optional) The begin index to use for filtering matchlist.  If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   * @param endIndex (optional) The end index to use for filtering matchlist. If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   */
  public Matchlist getMatchlist(final Region region, final String encryptedAccountId,
      final List<Integer> champion, final List<Integer> queue, final List<Integer> season,
      final Long beginTime, final Long endTime, final Integer beginIndex, final Integer endIndex) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v4/matchlists/by-account/%1$s", encryptedAccountId);
    Type type = Matchlist.class;
    return riotApi.getBasic("match-v4.getMatchlist", url, region, type, riotApi.makeParams("champion", champion, "queue", queue, "season", season, "beginTime", beginTime, "endTime", endTime, "beginIndex", beginIndex, "endIndex", endIndex));
  }

  /**
   * Get matchlist for games played on given account ID and platform ID and filtered using given filter parameters, if any.
   * ## Implementation Notes
   * A number of optional parameters are provided for filtering. It is up to the caller to ensure that the combination of filter parameters provided is valid for the requested account, otherwise, no matches may be returned.
   *
   * If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   *
   * If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   *
   * <a href="https://developer.riotgames.com/api-methods/#match-v4/GET_getMatchlist">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) The account ID.
   * @param champion (optional) Set of champion IDs for filtering the matchlist.
   * @param queue (optional) Set of queue IDs for filtering the matchlist.
   * @param season (optional) Set of season IDs for filtering the matchlist.
   * @param beginTime (optional) The begin time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   * @param endTime (optional) The end time to use for filtering matchlist specified as epoch milliseconds. If beginTime is specified, but not endTime, then endTime defaults to the the current unix timestamp in milliseconds (the maximum time range limitation is not observed in this specific case). If endTime is specified, but not beginTime, then beginTime defaults to the start of the account's match history returning a 400 due to the maximum time range limitation. If both are specified, then endTime should be greater than beginTime. The maximum time range allowed is one week, otherwise a 400 error code is returned.
   * @param beginIndex (optional) The begin index to use for filtering matchlist.  If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   * @param endIndex (optional) The end index to use for filtering matchlist. If beginIndex is specified, but not endIndex, then endIndex defaults to beginIndex+100. If endIndex is specified, but not beginIndex, then beginIndex defaults to 0. If both are specified, then endIndex must be greater than beginIndex. The maximum range allowed is 100, otherwise a 400 error code is returned.
   */
  public CompletableFuture<Matchlist> getMatchlistAsync(final Region region,
      final String encryptedAccountId, final List<Integer> champion, final List<Integer> queue,
      final List<Integer> season, final Long beginTime, final Long endTime,
      final Integer beginIndex, final Integer endIndex) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/match/v4/matchlists/by-account/%1$s", encryptedAccountId);
    Type type = Matchlist.class;
    return riotApi.getBasicAsync("match-v4.getMatchlist", url, region, type, riotApi.makeParams("champion", champion, "queue", queue, "season", season, "beginTime", beginTime, "endTime", endTime, "beginIndex", beginIndex, "endIndex", endIndex));
  }
}
