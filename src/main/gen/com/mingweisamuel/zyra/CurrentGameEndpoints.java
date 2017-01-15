package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.currentGame.CurrentGameInfo;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version current-game-v1.0 */
public class CurrentGameEndpoints {
  private static final Type GET__TYPE = CurrentGameInfo.class;

  private static final String GET__URL = "/observer-mode/rest/consumer/getSpectatorGameInfo/%1$s/%2$s";

  private final RiotApi riotApi;

  public CurrentGameEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * @param region Region to query.
   * @param summonerId Riot API description: The ID of the summoner. */
  public CurrentGameInfo get(final Region region, final long summonerId) throws ExecutionException {
    return riotApi.getBasic(String.format(GET__URL, region.platform, summonerId), region, GET__TYPE);}

  /**
   * @param region Region to query.
   * @param summonerId Riot API description: The ID of the summoner. */
  public CompletableFuture<CurrentGameInfo> getAsync(final Region region, final long summonerId) {
    return riotApi.getBasicAsync(String.format(GET__URL, region.platform, summonerId), region, GET__TYPE);}
}
