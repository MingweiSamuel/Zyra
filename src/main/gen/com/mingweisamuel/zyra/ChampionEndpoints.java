package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.champion.Champion;
import com.mingweisamuel.zyra.champion.ChampionList;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.Boolean;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

/**
 * champion-v3
 * This class is automatically generated and should not be modified directly.
 */
public final class ChampionEndpoints extends Endpoints {
  ChampionEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Link to Portal</a><br>
   * @param region Region to execute against.@param freeToPlay (optional) Optional filter param to retrieve only free to play champions.
   */
  public ChampionList getChampions(final Region region, final Boolean freeToPlay) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/platform/v3/champions");
    Type type = ChampionList.class;
    return riotApi.getBasic(url, region, type, RiotApi.makeParams("freeToPlay", freeToPlay)));}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Link to Portal</a><br>
   * @param region Region to execute against. */
  public ChampionList getChampions(final Region region) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    return this.getChampions(region, null);}

  /**
   * <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampionsById">Link to Portal</a><br>
   * @param region Region to execute against.@param id (required) Champion ID
   */
  public Champion getChampionsById(final Region region, final int id) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/platform/v3/champions/%1$s", id);
    Type type = Champion.class;
    return riotApi.getBasic(url, region, type);}
}
