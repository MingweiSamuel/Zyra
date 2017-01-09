package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.dto.RecentGames;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version game-v1.3 */
public class GameEndpoints {
  private static final Type GET_RECENT__TYPE = RecentGames.class;

  private static final String GET_RECENT__URL = "/api/lol/%1s/v1.3/game/by-summoner/%2s/recent";

  private final RiotApi riotApi;

  public GameEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * @param summonerId Riot API description: ID of the summoner for which to retrieve recent games. */
  public RecentGames getRecent(final Region region, final long summonerId) throws
      ExecutionException {
    return riotApi.getBasic(String.format(GET_RECENT__URL, region, summonerId), region, GET_RECENT__TYPE);}

  /**
   * @param summonerId Riot API description: ID of the summoner for which to retrieve recent games. */
  public CompletableFuture<RecentGames> getRecentAsync(final Region region, final long summonerId) {
    return riotApi.getBasicAsync(String.format(GET_RECENT__URL, region, summonerId), region, GET_RECENT__TYPE);}
}
