package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.championMastery.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.Integer;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * champion-mastery-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class ChampionMasteryEndpoints extends Endpoints {
  ChampionMasteryEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get a champion mastery by player ID and champion ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMastery">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param championId (required) Champion ID to retrieve Champion Mastery for
   * @param summonerId (required) Summoner ID associated with the player
   */
  public ChampionMastery getChampionMastery(final Region region, final long championId,
      final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v3/champion-masteries/by-summoner/%1$s/by-champion/%2$s", championId, summonerId);
    Type type = ChampionMastery.class;
    return riotApi.getBasic("champion-mastery-v3.getChampionMastery", url, region, type, Collections.emptyList());
  }

  /**
   * Get a champion mastery by player ID and champion ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMastery">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param championId (required) Champion ID to retrieve Champion Mastery for
   * @param summonerId (required) Summoner ID associated with the player
   */
  public CompletableFuture<ChampionMastery> getChampionMasteryAsync(final Region region,
      final long championId, final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v3/champion-masteries/by-summoner/%1$s/by-champion/%2$s", championId, summonerId);
    Type type = ChampionMastery.class;
    return riotApi.getBasicAsync("champion-mastery-v3.getChampionMastery", url, region, type, Collections.emptyList());
  }

  /**
   * Get a player's total champion mastery score, which is the sum of individual champion mastery levels.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMasteryScore">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID associated with the player
   */
  public Integer getChampionMasteryScore(final Region region, final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v3/scores/by-summoner/%1$s", summonerId);
    Type type = Integer.class;
    return riotApi.getBasic("champion-mastery-v3.getChampionMasteryScore", url, region, type, Collections.emptyList());
  }

  /**
   * Get a player's total champion mastery score, which is the sum of individual champion mastery levels.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMasteryScore">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID associated with the player
   */
  public CompletableFuture<Integer> getChampionMasteryScoreAsync(final Region region,
      final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v3/scores/by-summoner/%1$s", summonerId);
    Type type = Integer.class;
    return riotApi.getBasicAsync("champion-mastery-v3.getChampionMasteryScore", url, region, type, Collections.emptyList());
  }

  /**
   * Get all champion mastery entries sorted by number of champion points descending,
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getAllChampionMasteries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID associated with the player
   */
  public List<ChampionMastery> getAllChampionMasteries(final Region region, final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v3/champion-masteries/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<ChampionMastery>>() {
    }.getType();
    return riotApi.getBasic("champion-mastery-v3.getAllChampionMasteries", url, region, type, Collections.emptyList());
  }

  /**
   * Get all champion mastery entries sorted by number of champion points descending,
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getAllChampionMasteries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID associated with the player
   */
  public CompletableFuture<List<ChampionMastery>> getAllChampionMasteriesAsync(final Region region,
      final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v3/champion-masteries/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<ChampionMastery>>() {
    }.getType();
    return riotApi.getBasicAsync("champion-mastery-v3.getAllChampionMasteries", url, region, type, Collections.emptyList());
  }
}
