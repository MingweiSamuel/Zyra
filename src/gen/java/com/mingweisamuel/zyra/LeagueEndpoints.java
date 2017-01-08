package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.League;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.Iterable;
import java.lang.Long;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version league-v2.5 */
public class LeagueEndpoints {
  private static final Type GET_BY_SUMMONER__TYPE = new TypeToken<Map<String, List<League>>>() {
  }.getType();

  private static final int GET_BY_SUMMONER__GROUP = 10;

  private static final String GET_BY_SUMMONER__URL = "/api/lol/%1s/v2.5/league/by-summoner/@";

  private static final Type GET_ENTRIES__TYPE = new TypeToken<Map<String, List<League>>>() {
  }.getType();

  private static final int GET_ENTRIES__GROUP = 10;

  private static final String GET_ENTRIES__URL = "/api/lol/%1s/v2.5/league/by-summoner/@/entry";

  private static final Type GET_CHALLENGERS__TYPE = League.class;

  private static final String GET_CHALLENGERS__URL = "/api/lol/%1s/v2.5/league/challenger";

  private static final Type GET_MASTERS__TYPE = League.class;

  private static final String GET_MASTERS__URL = "/api/lol/%1s/v2.5/league/master";

  private final RiotApi riotApi;

  public LeagueEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  public Map<String, List<League>> getBySummoner(final Region region, final Iterable<Long> input)
      throws ExecutionException {
    return riotApi.getMap2(String.format(GET_BY_SUMMONER__URL, region), region, input, GET_BY_SUMMONER__GROUP, GET_BY_SUMMONER__TYPE);}

  public Map<String, List<League>> getEntries(final Region region, final Iterable<Long> input)
      throws ExecutionException {
    return riotApi.getMap2(String.format(GET_ENTRIES__URL, region), region, input, GET_ENTRIES__GROUP, GET_ENTRIES__TYPE);}

  public League getChallengers(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_CHALLENGERS__URL, region), region, input, null, GET_CHALLENGERS__TYPE);}

  public League getMasters(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_MASTERS__URL, region), region, input, null, GET_MASTERS__TYPE);}
}
