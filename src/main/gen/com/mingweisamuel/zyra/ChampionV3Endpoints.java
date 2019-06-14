package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.championV3.ChampionInfo;
import com.mingweisamuel.zyra.enums.Region;
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
public final class ChampionV3Endpoints extends Endpoints {
  ChampionV3Endpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Returns champion rotations, including free-to-play and low-level free-to-play rotations (REST)
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampionInfo">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public ChampionInfo getChampionInfo(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/platform/v3/champion-rotations";
    Type type = ChampionInfo.class;
    return riotApi.getBasic("champion-v3.getChampionInfo", url, region, type, Collections.emptyList());
  }

  /**
   * Returns champion rotations, including free-to-play and low-level free-to-play rotations (REST)
   *
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampionInfo">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<ChampionInfo> getChampionInfoAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/platform/v3/champion-rotations";
    Type type = ChampionInfo.class;
    return riotApi.getBasicAsync("champion-v3.getChampionInfo", url, region, type, Collections.emptyList());
  }
}
