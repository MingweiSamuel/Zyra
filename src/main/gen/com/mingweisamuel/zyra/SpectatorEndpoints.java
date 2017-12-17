package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.spectator.CurrentGameInfo;
import com.mingweisamuel.zyra.spectator.FeaturedGames;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * spectator-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class SpectatorEndpoints extends Endpoints {
  SpectatorEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get current game information for the given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) The ID of the summoner.
   */
  public CurrentGameInfo getCurrentGameInfoBySummoner(final Region region, final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/spectator/v3/active-games/by-summoner/%1$s", summonerId);
    Type type = CurrentGameInfo.class;
    return riotApi.getBasic("spectator-v3.getCurrentGameInfoBySummoner", url, region, type, Collections.emptyList());
  }

  /**
   * Get current game information for the given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) The ID of the summoner.
   */
  public CompletableFuture<CurrentGameInfo> getCurrentGameInfoBySummonerAsync(final Region region,
      final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/spectator/v3/active-games/by-summoner/%1$s", summonerId);
    Type type = CurrentGameInfo.class;
    return riotApi.getBasicAsync("spectator-v3.getCurrentGameInfoBySummoner", url, region, type, Collections.emptyList());
  }

  /**
   * Get list of featured games.
   *
   * <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getFeaturedGames">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public FeaturedGames getFeaturedGames(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/spectator/v3/featured-games";
    Type type = FeaturedGames.class;
    return riotApi.getBasic("spectator-v3.getFeaturedGames", url, region, type, Collections.emptyList());
  }

  /**
   * Get list of featured games.
   *
   * <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getFeaturedGames">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<FeaturedGames> getFeaturedGamesAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/spectator/v3/featured-games";
    Type type = FeaturedGames.class;
    return riotApi.getBasicAsync("spectator-v3.getFeaturedGames", url, region, type, Collections.emptyList());
  }
}
