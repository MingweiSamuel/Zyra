package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.dto.Champion;
import com.mingweisamuel.zyra.dto.ChampionList;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version champion-v1.2 */
public class ChampionEndpoints {
  private static final Type GET_ALL__TYPE = ChampionList.class;

  private static final String GET_ALL__URL = "/api/lol/%1s/v1.2/champion";

  private static final Type GET__TYPE = Champion.class;

  private static final String GET__URL = "/api/lol/%1s/v1.2/champion/%2s";

  private final RiotApi riotApi;

  public ChampionEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  public ChampionList getAll(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_ALL__URL, region), region, input, null, GET_ALL__TYPE);}

  public Champion get(final Region region, final int id) throws ExecutionException {
    return riotApi.getMap2(String.format(GET__URL, region), region, input, null, GET__TYPE);}
}
