package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.leagueV4.LeagueEntry;
import com.mingweisamuel.zyra.leagueV4.LeagueList;
import com.mingweisamuel.zyra.leagueV4.LeaguePosition;
import java.lang.Integer;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * league-v4 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class LeagueV4Endpoints extends Endpoints {
  LeagueV4Endpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get the challenger league for given queue.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getChallengerLeague">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param queue (required) null
   */
  public LeagueList getChallengerLeague(final Region region, final String queue) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/challengerleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasic("league-v4.getChallengerLeague", url, region, type, Collections.emptyList());
  }

  /**
   * Get the challenger league for given queue.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getChallengerLeague">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param queue (required) null
   */
  public CompletableFuture<LeagueList> getChallengerLeagueAsync(final Region region,
      final String queue) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/challengerleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasicAsync("league-v4.getChallengerLeague", url, region, type, Collections.emptyList());
  }

  /**
   * Get league entries in all queues for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getLeagueEntriesForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) null
   */
  public List<LeagueEntry> getLeagueEntriesForSummoner(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/entries/by-summoner/%1$s", encryptedSummonerId);
    Type type = new TypeToken<List<LeagueEntry>>() {
    }.getType();
    return riotApi.getBasic("league-v4.getLeagueEntriesForSummoner", url, region, type, Collections.emptyList());
  }

  /**
   * Get league entries in all queues for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getLeagueEntriesForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) null
   */
  public CompletableFuture<List<LeagueEntry>> getLeagueEntriesForSummonerAsync(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/entries/by-summoner/%1$s", encryptedSummonerId);
    Type type = new TypeToken<List<LeagueEntry>>() {
    }.getType();
    return riotApi.getBasicAsync("league-v4.getLeagueEntriesForSummoner", url, region, type, Collections.emptyList());
  }

  /**
   * Get the grandmaster league of a specific queue.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getGrandmasterLeague">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param queue (required) null
   */
  public LeagueList getGrandmasterLeague(final Region region, final String queue) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/grandmasterleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasic("league-v4.getGrandmasterLeague", url, region, type, Collections.emptyList());
  }

  /**
   * Get the grandmaster league of a specific queue.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getGrandmasterLeague">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param queue (required) null
   */
  public CompletableFuture<LeagueList> getGrandmasterLeagueAsync(final Region region,
      final String queue) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/grandmasterleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasicAsync("league-v4.getGrandmasterLeague", url, region, type, Collections.emptyList());
  }

  /**
   * Get the master league for given queue.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getMasterLeague">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param queue (required) null
   */
  public LeagueList getMasterLeague(final Region region, final String queue) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/masterleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasic("league-v4.getMasterLeague", url, region, type, Collections.emptyList());
  }

  /**
   * Get the master league for given queue.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getMasterLeague">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param queue (required) null
   */
  public CompletableFuture<LeagueList> getMasterLeagueAsync(final Region region,
      final String queue) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/masterleagues/by-queue/%1$s", queue);
    Type type = LeagueList.class;
    return riotApi.getBasicAsync("league-v4.getMasterLeague", url, region, type, Collections.emptyList());
  }

  /**
   * (Deprecated) Get the queues that have positional ranks enabled.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getQueuesWithPositionRanks">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public List<String> getQueuesWithPositionRanks(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/league/v4/positional-rank-queues";
    Type type = new TypeToken<List<String>>() {
    }.getType();
    return riotApi.getBasic("league-v4.getQueuesWithPositionRanks", url, region, type, Collections.emptyList());
  }

  /**
   * (Deprecated) Get the queues that have positional ranks enabled.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getQueuesWithPositionRanks">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<List<String>> getQueuesWithPositionRanksAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/league/v4/positional-rank-queues";
    Type type = new TypeToken<List<String>>() {
    }.getType();
    return riotApi.getBasicAsync("league-v4.getQueuesWithPositionRanks", url, region, type, Collections.emptyList());
  }

  /**
   * (Deprecated) Get league positions in all queues for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getAllLeaguePositionsForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) null
   */
  public List<LeaguePosition> getAllLeaguePositionsForSummoner(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/positions/by-summoner/%1$s", encryptedSummonerId);
    Type type = new TypeToken<List<LeaguePosition>>() {
    }.getType();
    return riotApi.getBasic("league-v4.getAllLeaguePositionsForSummoner", url, region, type, Collections.emptyList());
  }

  /**
   * (Deprecated) Get league positions in all queues for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getAllLeaguePositionsForSummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) null
   */
  public CompletableFuture<List<LeaguePosition>> getAllLeaguePositionsForSummonerAsync(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/positions/by-summoner/%1$s", encryptedSummonerId);
    Type type = new TypeToken<List<LeaguePosition>>() {
    }.getType();
    return riotApi.getBasicAsync("league-v4.getAllLeaguePositionsForSummoner", url, region, type, Collections.emptyList());
  }

  /**
   * (Deprecated) Get all the positional league entries.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getPositionalLeagueEntries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param positionalQueue (required) Note that the queue value must be a valid positional queue.
   * @param tier (required) null
   * @param division (required) null
   * @param position (required) null
   * @param page (required) Starts with page 0.
   */
  public List<LeaguePosition> getPositionalLeagueEntries(final Region region,
      final String positionalQueue, final String tier, final String division, final String position,
      final int page) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/positions/%1$s/%2$s/{division}/{position}/{page}", positionalQueue, tier, division, position, page);
    Type type = new TypeToken<List<LeaguePosition>>() {
    }.getType();
    return riotApi.getBasic("league-v4.getPositionalLeagueEntries", url, region, type, Collections.emptyList());
  }

  /**
   * (Deprecated) Get all the positional league entries.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getPositionalLeagueEntries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param positionalQueue (required) Note that the queue value must be a valid positional queue.
   * @param tier (required) null
   * @param division (required) null
   * @param position (required) null
   * @param page (required) Starts with page 0.
   */
  public CompletableFuture<List<LeaguePosition>> getPositionalLeagueEntriesAsync(final Region region,
      final String positionalQueue, final String tier, final String division, final String position,
      final int page) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/positions/%1$s/%2$s/{division}/{position}/{page}", positionalQueue, tier, division, position, page);
    Type type = new TypeToken<List<LeaguePosition>>() {
    }.getType();
    return riotApi.getBasicAsync("league-v4.getPositionalLeagueEntries", url, region, type, Collections.emptyList());
  }

  /**
   * Get league with given ID, including inactive entries.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getLeagueById">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param leagueId (required) The UUID of the league.
   */
  public LeagueList getLeagueById(final Region region, final String leagueId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/leagues/%1$s", leagueId);
    Type type = LeagueList.class;
    return riotApi.getBasic("league-v4.getLeagueById", url, region, type, Collections.emptyList());
  }

  /**
   * Get league with given ID, including inactive entries.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getLeagueById">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param leagueId (required) The UUID of the league.
   */
  public CompletableFuture<LeagueList> getLeagueByIdAsync(final Region region,
      final String leagueId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/leagues/%1$s", leagueId);
    Type type = LeagueList.class;
    return riotApi.getBasicAsync("league-v4.getLeagueById", url, region, type, Collections.emptyList());
  }

  /**
   * Get all the league entries.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getLeagueEntries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param division (required) null
   * @param tier (required) null
   * @param queue (required) Note that the queue value must be a valid ranked queue.
   */
  public List<LeagueEntry> getLeagueEntries(final Region region, final String division,
      final String tier, final String queue) {
    // This method is automatically generated and should not be modified directly.
    return this.getLeagueEntries(region, division, tier, queue, null);
  }

  /**
   * Get all the league entries.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getLeagueEntries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param division (required) null
   * @param tier (required) null
   * @param queue (required) Note that the queue value must be a valid ranked queue.
   */
  public CompletableFuture<List<LeagueEntry>> getLeagueEntriesAsync(final Region region,
      final String division, final String tier, final String queue) {
    // This method is automatically generated and should not be modified directly.
    return this.getLeagueEntriesAsync(region, division, tier, queue, null);
  }

  /**
   * Get all the league entries.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getLeagueEntries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param division (required) null
   * @param tier (required) null
   * @param queue (required) Note that the queue value must be a valid ranked queue.
   * @param page (optional) Starts with page 1.
   */
  public List<LeagueEntry> getLeagueEntries(final Region region, final String division,
      final String tier, final String queue, final Integer page) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/entries/%1$s/%2$s/{division}", division, tier, queue);
    Type type = new TypeToken<List<LeagueEntry>>() {
    }.getType();
    return riotApi.getBasic("league-v4.getLeagueEntries", url, region, type, riotApi.makeParams("page", page));
  }

  /**
   * Get all the league entries.
   *
   * <a href="https://developer.riotgames.com/api-methods/#league-v4/GET_getLeagueEntries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param division (required) null
   * @param tier (required) null
   * @param queue (required) Note that the queue value must be a valid ranked queue.
   * @param page (optional) Starts with page 1.
   */
  public CompletableFuture<List<LeagueEntry>> getLeagueEntriesAsync(final Region region,
      final String division, final String tier, final String queue, final Integer page) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/league/v4/entries/%1$s/%2$s/{division}", division, tier, queue);
    Type type = new TypeToken<List<LeagueEntry>>() {
    }.getType();
    return riotApi.getBasicAsync("league-v4.getLeagueEntries", url, region, type, riotApi.makeParams("page", page));
  }
}
