package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.champion.Champion;
import com.mingweisamuel.zyra.champion.ChampionList;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.Boolean;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version champion-v1.2 */
public class ChampionEndpoints {
  private static final Type GET_ALL__TYPE = ChampionList.class;

  private static final String GET_ALL__URL = "/api/lol/%1$s/v1.2/champion";

  private static final Type GET__TYPE = Champion.class;

  private static final String GET__URL = "/api/lol/%1$s/v1.2/champion/%2$s";

  private final RiotApi riotApi;

  public ChampionEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * @param freeToPlay Riot API description: Optional filter param to retrieve only free to play champions. */
  public ChampionList getAll(final Region region, final Boolean freeToPlay) throws
      ExecutionException {
    return riotApi.getBasic(String.format(GET_ALL__URL, region, freeToPlay), region, GET_ALL__TYPE,
        riotApi.makeParams("freeToPlay", freeToPlay));}

  /**
   * @param freeToPlay Riot API description: Optional filter param to retrieve only free to play champions. */
  public CompletableFuture<ChampionList> getAllAsync(final Region region,
      final Boolean freeToPlay) {
    return riotApi.getBasicAsync(String.format(GET_ALL__URL, region, freeToPlay), region, GET_ALL__TYPE,
        riotApi.makeParams("freeToPlay", freeToPlay));}

  public ChampionList getAll(final Region region) throws ExecutionException {
    return getAll(region, null);}

  public CompletableFuture<ChampionList> getAllAsync(final Region region) {
    return getAllAsync(region, null);}

  /**
   * @param id Riot API description: ID of the champion to retrieve. */
  public Champion get(final Region region, final int id) throws ExecutionException {
    return riotApi.getBasic(String.format(GET__URL, region, id), region, GET__TYPE);}

  /**
   * @param id Riot API description: ID of the champion to retrieve. */
  public CompletableFuture<Champion> getAsync(final Region region, final int id) {
    return riotApi.getBasicAsync(String.format(GET__URL, region, id), region, GET__TYPE);}
}
