package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.summoner.MasteryPages;
import com.mingweisamuel.zyra.summoner.RunePages;
import com.mingweisamuel.zyra.summoner.Summoner;
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
  private static final Type GET_BY_NAME__TYPE = new TypeToken<Map<String, Summoner>>() {
  }.getType();

  private static final int GET_BY_NAME__GROUP = 40;

  private static final String GET_BY_NAME__URL = "/api/lol/%1s/v1.4/summoner/by-name/@";

  private static final Type GET__TYPE = new TypeToken<Map<Long, Summoner>>() {
  }.getType();

  private static final int GET__GROUP = 40;

  private static final String GET__URL = "/api/lol/%1s/v1.4/summoner/@";

  private static final Type GET_MASTERIES__TYPE = new TypeToken<Map<Long, MasteryPages>>() {
  }.getType();

  private static final int GET_MASTERIES__GROUP = 40;

  private static final String GET_MASTERIES__URL = "/api/lol/%1s/v1.4/summoner/@/masteries";

  private static final Type GET_NAMES__TYPE = new TypeToken<Map<Long, String>>() {
  }.getType();

  private static final int GET_NAMES__GROUP = 40;

  private static final String GET_NAMES__URL = "/api/lol/%1s/v1.4/summoner/@/name";

  private static final Type GET_RUNES__TYPE = new TypeToken<Map<Long, RunePages>>() {
  }.getType();

  private static final int GET_RUNES__GROUP = 40;

  private static final String GET_RUNES__URL = "/api/lol/%1s/v1.4/summoner/@/runes";

  private final RiotApi riotApi;

  public SummonerEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * The response object contains the summoner objects mapped by the standardized summoner name, which is the summoner name in all lower case and with spaces removed. Use this version of the name when checking if the returned object contains the data for a given summoner. This API will also accept standardized summoner names as valid parameters, although they are not required.
   *
   * @param input Riot API description: list of summoner names or standardized summoner names associated with summoners to retrieve. */
  public Map<String, Summoner> getByName(final Region region, final Collection<String> input) throws
      ExecutionException {
    return riotApi.getMap(String.format(GET_BY_NAME__URL, region), region, input, GET_BY_NAME__GROUP, GET_BY_NAME__TYPE);}

  /**
   * The response object contains the summoner objects mapped by the standardized summoner name, which is the summoner name in all lower case and with spaces removed. Use this version of the name when checking if the returned object contains the data for a given summoner. This API will also accept standardized summoner names as valid parameters, although they are not required.
   *
   * @param input Riot API description: list of summoner names or standardized summoner names associated with summoners to retrieve. */
  public CompletableFuture<Map<String, Summoner>> getByNameAsync(final Region region,
      final Collection<String> input) {
    return riotApi.getMapAsync(String.format(GET_BY_NAME__URL, region), region, input, GET_BY_NAME__GROUP, GET_BY_NAME__TYPE);}

  /**
   * @param input Riot API description: list of summoner IDs associated with summoners to retrieve. */
  public Map<Long, Summoner> get(final Region region, final Collection<Long> input) throws
      ExecutionException {
    return riotApi.getMap(String.format(GET__URL, region), region, input, GET__GROUP, GET__TYPE);}

  /**
   * @param input Riot API description: list of summoner IDs associated with summoners to retrieve. */
  public CompletableFuture<Map<Long, Summoner>> getAsync(final Region region,
      final Collection<Long> input) {
    return riotApi.getMapAsync(String.format(GET__URL, region), region, input, GET__GROUP, GET__TYPE);}

  /**
   * @param input Riot API description: list of summoner IDs associated with masteries to retrieve. */
  public Map<Long, MasteryPages> getMasteries(final Region region, final Collection<Long> input)
      throws ExecutionException {
    return riotApi.getMap(String.format(GET_MASTERIES__URL, region), region, input, GET_MASTERIES__GROUP, GET_MASTERIES__TYPE);}

  /**
   * @param input Riot API description: list of summoner IDs associated with masteries to retrieve. */
  public CompletableFuture<Map<Long, MasteryPages>> getMasteriesAsync(final Region region,
      final Collection<Long> input) {
    return riotApi.getMapAsync(String.format(GET_MASTERIES__URL, region), region, input, GET_MASTERIES__GROUP, GET_MASTERIES__TYPE);}

  /**
   * @param input Riot API description: list of summoner IDs associated with summoner names to retrieve. */
  public Map<Long, String> getNames(final Region region, final Collection<Long> input) throws
      ExecutionException {
    return riotApi.getMap(String.format(GET_NAMES__URL, region), region, input, GET_NAMES__GROUP, GET_NAMES__TYPE);}

  /**
   * @param input Riot API description: list of summoner IDs associated with summoner names to retrieve. */
  public CompletableFuture<Map<Long, String>> getNamesAsync(final Region region,
      final Collection<Long> input) {
    return riotApi.getMapAsync(String.format(GET_NAMES__URL, region), region, input, GET_NAMES__GROUP, GET_NAMES__TYPE);}

  /**
   * @param input Riot API description: list of summoner IDs associated with runes to retrieve. */
  public Map<Long, RunePages> getRunes(final Region region, final Collection<Long> input) throws
      ExecutionException {
    return riotApi.getMap(String.format(GET_RUNES__URL, region), region, input, GET_RUNES__GROUP, GET_RUNES__TYPE);}

  /**
   * @param input Riot API description: list of summoner IDs associated with runes to retrieve. */
  public CompletableFuture<Map<Long, RunePages>> getRunesAsync(final Region region,
      final Collection<Long> input) {
    return riotApi.getMapAsync(String.format(GET_RUNES__URL, region), region, input, GET_RUNES__GROUP, GET_RUNES__TYPE);}
}
