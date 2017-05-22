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
 * champion-mastery-v3
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class ChampionMasteryEndpoints extends Endpoints {
  ChampionMasteryEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getAllChampionMasteries">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID associated with the player
   */
  public List<ChampionMastery> getAllChampionMasteries(final Region region, final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v3/champion-masteries/by-summoner/%1$s", summonerId);
    Type type = new TypeToken<List<ChampionMastery>>() {
    }.getType();
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
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
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }

  /**
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
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
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
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMasteryScore">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID associated with the player
   */
  public Integer getChampionMasteryScore(final Region region, final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v3/scores/by-summoner/%1$s", summonerId);
    Type type = Integer.class;
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getChampionMasteryScore">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID associated with the player
   */
  public CompletableFuture<Integer> getChampionMasteryScoreAsync(final Region region,
      final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/champion-mastery/v3/scores/by-summoner/%1$s", summonerId);
    Type type = Integer.class;
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }
}
