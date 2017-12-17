package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.champion.Champion;
import com.mingweisamuel.zyra.champion.ChampionList;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.Boolean;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * champion-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class ChampionEndpoints extends Endpoints {
  ChampionEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Retrieve all champions.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public ChampionList getChampions(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampions(region, null);
  }

  /**
   * Retrieve all champions.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<ChampionList> getChampionsAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionsAsync(region, null);
  }

  /**
   * Retrieve all champions.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param freeToPlay (optional) Optional filter param to retrieve only free to play champions.
   */
  public ChampionList getChampions(final Region region, final Boolean freeToPlay) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/platform/v3/champions";
    Type type = ChampionList.class;
    return riotApi.getBasic("champion-v3.getChampions", url, region, type, riotApi.makeParams("freeToPlay", freeToPlay));
  }

  /**
   * Retrieve all champions.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param freeToPlay (optional) Optional filter param to retrieve only free to play champions.
   */
  public CompletableFuture<ChampionList> getChampionsAsync(final Region region,
      final Boolean freeToPlay) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/platform/v3/champions";
    Type type = ChampionList.class;
    return riotApi.getBasicAsync("champion-v3.getChampions", url, region, type, riotApi.makeParams("freeToPlay", freeToPlay));
  }

  /**
   * Retrieve champion by ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampionsById">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param id (required) Champion ID
   */
  public Champion getChampionsById(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/platform/v3/champions/%1$s", id);
    Type type = Champion.class;
    return riotApi.getBasic("champion-v3.getChampionsById", url, region, type, Collections.emptyList());
  }

  /**
   * Retrieve champion by ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampionsById">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param id (required) Champion ID
   */
  public CompletableFuture<Champion> getChampionsByIdAsync(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/platform/v3/champions/%1$s", id);
    Type type = Champion.class;
    return riotApi.getBasicAsync("champion-v3.getChampionsById", url, region, type, Collections.emptyList());
  }
}
