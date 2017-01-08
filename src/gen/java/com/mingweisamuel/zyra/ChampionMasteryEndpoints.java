package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.Integer;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version championmastery */
public class ChampionMasteryEndpoints {
  private static final Type GET_CHAMPION__TYPE = ChampionMastery.class;

  private static final String GET_CHAMPION__URL = "/championmastery/location/%1s/player/%2s/champion/%3s";

  private static final Type GET_CHAMPIONS__TYPE = new TypeToken<List<ChampionMastery>>() {
  }.getType();

  private static final String GET_CHAMPIONS__URL = "/championmastery/location/%1s/player/%2s/champions";

  private static final Type GET_SCORE__TYPE = Integer.class;

  private static final String GET_SCORE__URL = "/championmastery/location/%1s/player/%2s/score";

  private static final Type GET_TOP_CHAMPIONS__TYPE = new TypeToken<List<ChampionMastery>>() {
  }.getType();

  private static final String GET_TOP_CHAMPIONS__URL = "/championmastery/location/%1s/player/%2s/topchampions";

  private final RiotApi riotApi;

  public ChampionMasteryEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  public ChampionMastery getChampion(final Region region, final long playerId,
      final long championId) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_CHAMPION__URL, region), region, input, null, GET_CHAMPION__TYPE);}

  public List<ChampionMastery> getChampions(final Region region, final long playerId) throws
      ExecutionException {
    return riotApi.getMap2(String.format(GET_CHAMPIONS__URL, region), region, input, null, GET_CHAMPIONS__TYPE);}

  public Integer getScore(final Region region, final long playerId) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_SCORE__URL, region), region, input, null, GET_SCORE__TYPE);}

  public List<ChampionMastery> getTopChampions(final Region region, final long playerId) throws
      ExecutionException {
    return riotApi.getMap2(String.format(GET_TOP_CHAMPIONS__URL, region), region, input, null, GET_TOP_CHAMPIONS__TYPE);}
}
