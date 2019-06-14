package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.spectatorV4.CurrentGameInfo;
import com.mingweisamuel.zyra.spectatorV4.FeaturedGames;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * spectator-v4 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class SpectatorV4Endpoints extends Endpoints {
  SpectatorV4Endpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get current game information for the given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#spectator-v4/GET_getCurrentGameInfoBySummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) The ID of the summoner.
   */
  public CurrentGameInfo getCurrentGameInfoBySummoner(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/spectator/v4/active-games/by-summoner/%1$s", encryptedSummonerId);
    Type type = CurrentGameInfo.class;
    return riotApi.getBasic("spectator-v4.getCurrentGameInfoBySummoner", url, region, type, Collections.emptyList());
  }

  /**
   * Get current game information for the given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#spectator-v4/GET_getCurrentGameInfoBySummoner">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) The ID of the summoner.
   */
  public CompletableFuture<CurrentGameInfo> getCurrentGameInfoBySummonerAsync(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/spectator/v4/active-games/by-summoner/%1$s", encryptedSummonerId);
    Type type = CurrentGameInfo.class;
    return riotApi.getBasicAsync("spectator-v4.getCurrentGameInfoBySummoner", url, region, type, Collections.emptyList());
  }

  /**
   * Get list of featured games.
   *
   * <a href="https://developer.riotgames.com/api-methods/#spectator-v4/GET_getFeaturedGames">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public FeaturedGames getFeaturedGames(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/spectator/v4/featured-games";
    Type type = FeaturedGames.class;
    return riotApi.getBasic("spectator-v4.getFeaturedGames", url, region, type, Collections.emptyList());
  }

  /**
   * Get list of featured games.
   *
   * <a href="https://developer.riotgames.com/api-methods/#spectator-v4/GET_getFeaturedGames">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<FeaturedGames> getFeaturedGamesAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/spectator/v4/featured-games";
    Type type = FeaturedGames.class;
    return riotApi.getBasicAsync("spectator-v4.getFeaturedGames", url, region, type, Collections.emptyList());
  }
}
