package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.league.League;
import java.lang.Long;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version league-v2.5 */
public class LeagueEndpoints {
  private static final Type GET__TYPE = new TypeToken<Map<Long, List<League>>>() {
  }.getType();

  private static final int GET__GROUP = 10;

  private static final String GET__URL = "/api/lol/%1$s/v2.5/league/by-summoner/@";

  private static final Type GET_ENTRIES__TYPE = new TypeToken<Map<Long, List<League>>>() {
  }.getType();

  private static final int GET_ENTRIES__GROUP = 10;

  private static final String GET_ENTRIES__URL = "/api/lol/%1$s/v2.5/league/by-summoner/@/entry";

  private static final Type GET_CHALLENGERS__TYPE = League.class;

  private static final String GET_CHALLENGERS__URL = "/api/lol/%1$s/v2.5/league/challenger";

  private static final Type GET_MASTERS__TYPE = League.class;

  private static final String GET_MASTERS__URL = "/api/lol/%1$s/v2.5/league/master";

  private final RiotApi riotApi;

  public LeagueEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * Returns all leagues for specified summoners and summoners' teams. Entries for each requested participant (i.e., each summoner and related teams) will be included in the returned leagues data, whether or not the participant is inactive. However, no entries for other inactive summoners or teams in the leagues will be included.
   *
   * @param region Region to query.
   * @param input Riot API description: list of summoner IDs. */
  public Map<Long, List<League>> get(final Region region, final Collection<Long> input) throws
      ExecutionException {
    return riotApi.getMap(String.format(GET__URL, region), region, input, GET__GROUP, GET__TYPE);}

  /**
   * Returns all leagues for specified summoners and summoners' teams. Entries for each requested participant (i.e., each summoner and related teams) will be included in the returned leagues data, whether or not the participant is inactive. However, no entries for other inactive summoners or teams in the leagues will be included.
   *
   * @param region Region to query.
   * @param input Riot API description: list of summoner IDs. */
  public CompletableFuture<Map<Long, List<League>>> getAsync(final Region region,
      final Collection<Long> input) {
    return riotApi.getMapAsync(String.format(GET__URL, region), region, input, GET__GROUP, GET__TYPE);}

  /**
   * Returns all league entries for specified summoners and summoners' teams.
   *
   * @param region Region to query.
   * @param input Riot API description: list of summoner IDs. */
  public Map<Long, List<League>> getEntries(final Region region, final Collection<Long> input)
      throws ExecutionException {
    return riotApi.getMap(String.format(GET_ENTRIES__URL, region), region, input, GET_ENTRIES__GROUP, GET_ENTRIES__TYPE);}

  /**
   * Returns all league entries for specified summoners and summoners' teams.
   *
   * @param region Region to query.
   * @param input Riot API description: list of summoner IDs. */
  public CompletableFuture<Map<Long, List<League>>> getEntriesAsync(final Region region,
      final Collection<Long> input) {
    return riotApi.getMapAsync(String.format(GET_ENTRIES__URL, region), region, input, GET_ENTRIES__GROUP, GET_ENTRIES__TYPE);}

  /**
   * @param region Region to query.
   * @param type Riot API description: Game queue type. */
  public League getChallengers(final Region region, final String type) throws ExecutionException {
    return riotApi.getBasic(String.format(GET_CHALLENGERS__URL, region), region, GET_CHALLENGERS__TYPE,
        riotApi.makeParams("type", type));}

  /**
   * @param region Region to query.
   * @param type Riot API description: Game queue type. */
  public CompletableFuture<League> getChallengersAsync(final Region region, final String type) {
    return riotApi.getBasicAsync(String.format(GET_CHALLENGERS__URL, region), region, GET_CHALLENGERS__TYPE,
        riotApi.makeParams("type", type));}

  /**
   * @param region Region to query.
   * @param type Riot API description: Game queue type. */
  public League getMasters(final Region region, final String type) throws ExecutionException {
    return riotApi.getBasic(String.format(GET_MASTERS__URL, region), region, GET_MASTERS__TYPE,
        riotApi.makeParams("type", type));}

  /**
   * @param region Region to query.
   * @param type Riot API description: Game queue type. */
  public CompletableFuture<League> getMastersAsync(final Region region, final String type) {
    return riotApi.getBasicAsync(String.format(GET_MASTERS__URL, region), region, GET_MASTERS__TYPE,
        riotApi.makeParams("type", type));}
}
