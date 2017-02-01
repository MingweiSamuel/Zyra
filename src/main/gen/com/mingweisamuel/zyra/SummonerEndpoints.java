package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.summoner.MasteryPages;
import com.mingweisamuel.zyra.summoner.RunePages;
import java.lang.Long;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version summoner-v1.4 */
public class SummonerEndpoints {
  private static final Type GET_MASTERIES__TYPE = new TypeToken<Map<Long, MasteryPages>>() {
  }.getType();

  private static final int GET_MASTERIES__GROUP = 40;

  private static final String GET_MASTERIES__URL = "/api/lol/%1$s/v1.4/summoner/@/masteries";

  private static final Type GET_RUNES__TYPE = new TypeToken<Map<Long, RunePages>>() {
  }.getType();

  private static final int GET_RUNES__GROUP = 40;

  private static final String GET_RUNES__URL = "/api/lol/%1$s/v1.4/summoner/@/runes";

  private final RiotApi riotApi;

  public SummonerEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * @param region Region to query.
   * @param input Riot API description: list of summoner IDs associated with masteries to retrieve. */
  public Map<Long, MasteryPages> getMasteries(final Region region, final Collection<Long> input)
      throws ExecutionException {
    return riotApi.getMap(String.format(GET_MASTERIES__URL, region), region, input, GET_MASTERIES__GROUP, GET_MASTERIES__TYPE);}

  /**
   * @param region Region to query.
   * @param input Riot API description: list of summoner IDs associated with masteries to retrieve. */
  public CompletableFuture<Map<Long, MasteryPages>> getMasteriesAsync(final Region region,
      final Collection<Long> input) {
    return riotApi.getMapAsync(String.format(GET_MASTERIES__URL, region), region, input, GET_MASTERIES__GROUP, GET_MASTERIES__TYPE);}

  /**
   * @param region Region to query.
   * @param input Riot API description: list of summoner IDs associated with runes to retrieve. */
  public Map<Long, RunePages> getRunes(final Region region, final Collection<Long> input) throws
      ExecutionException {
    return riotApi.getMap(String.format(GET_RUNES__URL, region), region, input, GET_RUNES__GROUP, GET_RUNES__TYPE);}

  /**
   * @param region Region to query.
   * @param input Riot API description: list of summoner IDs associated with runes to retrieve. */
  public CompletableFuture<Map<Long, RunePages>> getRunesAsync(final Region region,
      final Collection<Long> input) {
    return riotApi.getMapAsync(String.format(GET_RUNES__URL, region), region, input, GET_RUNES__GROUP, GET_RUNES__TYPE);}
}
