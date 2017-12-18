package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.league.LeagueList;
import com.mingweisamuel.zyra.league.LeaguePosition;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * league-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class LeagueEndpoints extends Endpoints {
  LeagueEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get the challenger league for given queue.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getChallengerLeague">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param queue (required) null
   */
  public LeagueList getChallengerLeague(final Region region, final String queue) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/challengerleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasic("league-v3.getChallengerLeague", url, region, type, Collections.emptyList());
  }

  /**
   * Get the challenger league for given queue.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getChallengerLeague">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param queue (required) null
   */
  public CompletableFuture<LeagueList> getChallengerLeagueAsync(final Region region,
      final String queue) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/challengerleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasicAsync("league-v3.getChallengerLeague", url, region, type, Collections.emptyList());
  }

  /**
   * Get leagues in all queues for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguesForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) null
   */
  public List<LeagueList> getAllLeaguesForSummoner(final Region region, final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/leagues/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<LeagueList>>() {
    }.getType();
    return riotApi.getBasic("league-v3.getAllLeaguesForSummoner", url, region, type, Collections.emptyList());
  }

  /**
   * Get leagues in all queues for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguesForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) null
   */
  public CompletableFuture<List<LeagueList>> getAllLeaguesForSummonerAsync(final Region region,
      final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/leagues/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<LeagueList>>() {
    }.getType();
    return riotApi.getBasicAsync("league-v3.getAllLeaguesForSummoner", url, region, type, Collections.emptyList());
  }

  /**
   * Get league with given ID, including inactive entries.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getLeagueById">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param leagueId (required) The UUID of the league.
   */
  public LeagueList getLeagueById(final Region region, final String leagueId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/leagues/%1$s", leagueId);
    Type type = LeagueList.class;
    return riotApi.getBasic("league-v3.getLeagueById", url, region, type, Collections.emptyList());
  }

  /**
   * Get league with given ID, including inactive entries.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getLeagueById">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param leagueId (required) The UUID of the league.
   */
  public CompletableFuture<LeagueList> getLeagueByIdAsync(final Region region,
      final String leagueId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/leagues/%1$s", leagueId);
    Type type = LeagueList.class;
    return riotApi.getBasicAsync("league-v3.getLeagueById", url, region, type, Collections.emptyList());
  }

  /**
   * Get the master league for given queue.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getMasterLeague">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param queue (required) null
   */
  public LeagueList getMasterLeague(final Region region, final String queue) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/masterleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasic("league-v3.getMasterLeague", url, region, type, Collections.emptyList());
  }

  /**
   * Get the master league for given queue.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getMasterLeague">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param queue (required) null
   */
  public CompletableFuture<LeagueList> getMasterLeagueAsync(final Region region,
      final String queue) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/masterleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasicAsync("league-v3.getMasterLeague", url, region, type, Collections.emptyList());
  }

  /**
   * Get league positions in all queues for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguePositionsForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) null
   */
  public List<LeaguePosition> getAllLeaguePositionsForSummoner(final Region region,
      final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/positions/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<LeaguePosition>>() {
    }.getType();
    return riotApi.getBasic("league-v3.getAllLeaguePositionsForSummoner", url, region, type, Collections.emptyList());
  }

  /**
   * Get league positions in all queues for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguePositionsForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) null
   */
  public CompletableFuture<List<LeaguePosition>> getAllLeaguePositionsForSummonerAsync(final Region region,
      final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/positions/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<LeaguePosition>>() {
    }.getType();
    return riotApi.getBasicAsync("league-v3.getAllLeaguePositionsForSummoner", url, region, type, Collections.emptyList());
  }
}
