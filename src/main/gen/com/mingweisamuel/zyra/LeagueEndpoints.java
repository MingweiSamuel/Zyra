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
import java.util.concurrent.ExecutionException;

/**
 * league-v3
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class LeagueEndpoints extends Endpoints {
  LeagueEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getChallengerLeague">Link to Portal</a><br>
   * @param region Region to execute against.@param queue (required) 
   */
  public LeagueList getChallengerLeague(final Region region, final String queue) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/challengerleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getChallengerLeague">Link to Portal</a><br>
   * @param region Region to execute against.@param queue (required) 
   */
  public CompletableFuture<LeagueList> getChallengerLeagueAsync(final Region region,
      final String queue) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/challengerleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguesForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.@param summonerId (required) 
   */
  public List<LeagueList> getAllLeaguesForSummoner(final Region region, final long summonerId)
      throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/leagues/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<LeagueList>>() {
    }.getType();
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguesForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.@param summonerId (required) 
   */
  public CompletableFuture<List<LeagueList>> getAllLeaguesForSummonerAsync(final Region region,
      final long summonerId) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/leagues/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<LeagueList>>() {
    }.getType();
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getMasterLeague">Link to Portal</a><br>
   * @param region Region to execute against.@param queue (required) 
   */
  public LeagueList getMasterLeague(final Region region, final String queue) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/masterleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getMasterLeague">Link to Portal</a><br>
   * @param region Region to execute against.@param queue (required) 
   */
  public CompletableFuture<LeagueList> getMasterLeagueAsync(final Region region, final String queue)
      throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/masterleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguePositionsForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.@param summonerId (required) 
   */
  public List<LeaguePosition> getAllLeaguePositionsForSummoner(final Region region,
      final long summonerId) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/positions/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<LeaguePosition>>() {
    }.getType();
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguePositionsForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.@param summonerId (required) 
   */
  public CompletableFuture<List<LeaguePosition>> getAllLeaguePositionsForSummonerAsync(final Region region,
      final long summonerId) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v3/positions/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<LeaguePosition>>() {
    }.getType();
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }
}
