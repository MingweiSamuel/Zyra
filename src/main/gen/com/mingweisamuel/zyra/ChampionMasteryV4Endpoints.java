package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.championMasteryV4.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.Integer;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * champion-mastery-v4 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class ChampionMasteryV4Endpoints extends Endpoints {
  ChampionMasteryV4Endpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get a player's total champion mastery score, which is the sum of individual champion mastery levels.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v4/GET_getChampionMasteryScore">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) Summoner ID associated with the player
   */
  public Integer getChampionMasteryScore(final Region region, final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v4/scores/by-summoner/%1$s", encryptedSummonerId);
    Type type = Integer.class;
    return riotApi.getBasic("champion-mastery-v4.getChampionMasteryScore", url, region, type, Collections.emptyList());
  }

  /**
   * Get a player's total champion mastery score, which is the sum of individual champion mastery levels.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v4/GET_getChampionMasteryScore">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) Summoner ID associated with the player
   */
  public CompletableFuture<Integer> getChampionMasteryScoreAsync(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v4/scores/by-summoner/%1$s", encryptedSummonerId);
    Type type = Integer.class;
    return riotApi.getBasicAsync("champion-mastery-v4.getChampionMasteryScore", url, region, type, Collections.emptyList());
  }

  /**
   * Get a champion mastery by player ID and champion ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v4/GET_getChampionMastery">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) Summoner ID associated with the player
   * @param championId (required) Champion ID to retrieve Champion Mastery for
   */
  public ChampionMastery getChampionMastery(final Region region, final String encryptedSummonerId,
      final long championId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v4/champion-masteries/by-summoner/%1$s/by-champion/%2$s", encryptedSummonerId, championId);
    Type type = ChampionMastery.class;
    return riotApi.getBasic("champion-mastery-v4.getChampionMastery", url, region, type, Collections.emptyList());
  }

  /**
   * Get a champion mastery by player ID and champion ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v4/GET_getChampionMastery">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) Summoner ID associated with the player
   * @param championId (required) Champion ID to retrieve Champion Mastery for
   */
  public CompletableFuture<ChampionMastery> getChampionMasteryAsync(final Region region,
      final String encryptedSummonerId, final long championId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v4/champion-masteries/by-summoner/%1$s/by-champion/%2$s", encryptedSummonerId, championId);
    Type type = ChampionMastery.class;
    return riotApi.getBasicAsync("champion-mastery-v4.getChampionMastery", url, region, type, Collections.emptyList());
  }

  /**
   * Get all champion mastery entries sorted by number of champion points descending,
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v4/GET_getAllChampionMasteries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) Summoner ID associated with the player
   */
  public List<ChampionMastery> getAllChampionMasteries(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v4/champion-masteries/by-summoner/%1$s", encryptedSummonerId);
    Type type = new TypeToken<List<ChampionMastery>>() {
    }.getType();
    return riotApi.getBasic("champion-mastery-v4.getAllChampionMasteries", url, region, type, Collections.emptyList());
  }

  /**
   * Get all champion mastery entries sorted by number of champion points descending,
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v4/GET_getAllChampionMasteries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) Summoner ID associated with the player
   */
  public CompletableFuture<List<ChampionMastery>> getAllChampionMasteriesAsync(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v4/champion-masteries/by-summoner/%1$s", encryptedSummonerId);
    Type type = new TypeToken<List<ChampionMastery>>() {
    }.getType();
    return riotApi.getBasicAsync("champion-mastery-v4.getAllChampionMasteries", url, region, type, Collections.emptyList());
  }
}
