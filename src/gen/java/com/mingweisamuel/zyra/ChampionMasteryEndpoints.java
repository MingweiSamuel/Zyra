package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.Integer;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link RiotDtoGenerator}.
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

  /**
   * @param playerId Riot API description: Summoner ID associated with the player
   * @param championId Riot API description: Champion ID to retrieve Champion Mastery for */
  public ChampionMastery getChampion(final Region region, final long playerId,
      final long championId) throws ExecutionException {
    return riotApi.getBasic(String.format(GET_CHAMPION__URL, region, playerId, championId), region, GET_CHAMPION__TYPE);}

  /**
   * @param playerId Riot API description: Summoner ID associated with the player
   * @param championId Riot API description: Champion ID to retrieve Champion Mastery for */
  public CompletableFuture<ChampionMastery> getChampionAsync(final Region region,
      final long playerId, final long championId) {
    return riotApi.getBasicAsync(String.format(GET_CHAMPION__URL, region, playerId, championId), region, GET_CHAMPION__TYPE);}

  /**
   * @param playerId Riot API description: Summoner ID associated with the player */
  public List<ChampionMastery> getChampions(final Region region, final long playerId) throws
      ExecutionException {
    return riotApi.getBasic(String.format(GET_CHAMPIONS__URL, region, playerId), region, GET_CHAMPIONS__TYPE);}

  /**
   * @param playerId Riot API description: Summoner ID associated with the player */
  public CompletableFuture<List<ChampionMastery>> getChampionsAsync(final Region region,
      final long playerId) {
    return riotApi.getBasicAsync(String.format(GET_CHAMPIONS__URL, region, playerId), region, GET_CHAMPIONS__TYPE);}

  /**
   * @param playerId Riot API description: Summoner ID associated with the player */
  public Integer getScore(final Region region, final long playerId) throws ExecutionException {
    return riotApi.getBasic(String.format(GET_SCORE__URL, region, playerId), region, GET_SCORE__TYPE);}

  /**
   * @param playerId Riot API description: Summoner ID associated with the player */
  public CompletableFuture<Integer> getScoreAsync(final Region region, final long playerId) {
    return riotApi.getBasicAsync(String.format(GET_SCORE__URL, region, playerId), region, GET_SCORE__TYPE);}

  /**
   * @param playerId Riot API description: Summoner ID associated with the player
   * @param count Riot API description: Number of entries to retrieve, defaults to 3 */
  public List<ChampionMastery> getTopChampions(final Region region, final long playerId,
      final Integer count) throws ExecutionException {
    return riotApi.getBasic(String.format(GET_TOP_CHAMPIONS__URL, region, playerId, count), region, GET_TOP_CHAMPIONS__TYPE,
    RiotApi.makeParams("count", count));}

  /**
   * @param playerId Riot API description: Summoner ID associated with the player
   * @param count Riot API description: Number of entries to retrieve, defaults to 3 */
  public CompletableFuture<List<ChampionMastery>> getTopChampionsAsync(final Region region,
      final long playerId, final Integer count) {
    return riotApi.getBasicAsync(String.format(GET_TOP_CHAMPIONS__URL, region, playerId, count), region, GET_TOP_CHAMPIONS__TYPE,
    RiotApi.makeParams("count", count));}

  /**
   * @param playerId Riot API description: Summoner ID associated with the player */
  public List<ChampionMastery> getTopChampions(final Region region, final long playerId) throws
      ExecutionException {
    return getTopChampions(region, playerId, null);}

  /**
   * @param playerId Riot API description: Summoner ID associated with the player */
  public CompletableFuture<List<ChampionMastery>> getTopChampionsAsync(final Region region,
      final long playerId) {
    return getTopChampionsAsync(region, playerId, null);}
}
