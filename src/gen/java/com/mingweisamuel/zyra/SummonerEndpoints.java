package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.MasteryPages;
import com.mingweisamuel.zyra.dto.RunePages;
import com.mingweisamuel.zyra.dto.Summoner;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.Iterable;
import java.lang.Long;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version summoner-v1.4 */
public class SummonerEndpoints {
  private static final Type GET_BY_NAME__TYPE = new TypeToken<Map<String, Summoner>>() {
  }.getType();

  private static final int GET_BY_NAME__GROUP = 40;

  private static final String GET_BY_NAME__URL = "/api/lol/%1s/v1.4/summoner/by-name/@";

  private static final Type GET__TYPE = new TypeToken<Map<String, Summoner>>() {
  }.getType();

  private static final int GET__GROUP = 40;

  private static final String GET__URL = "/api/lol/%1s/v1.4/summoner/@";

  private static final Type GET_MASTERIES__TYPE = new TypeToken<Map<String, MasteryPages>>() {
  }.getType();

  private static final int GET_MASTERIES__GROUP = 40;

  private static final String GET_MASTERIES__URL = "/api/lol/%1s/v1.4/summoner/@/masteries";

  private static final Type GET_NAMES__TYPE = new TypeToken<Map<String, String>>() {
  }.getType();

  private static final int GET_NAMES__GROUP = 40;

  private static final String GET_NAMES__URL = "/api/lol/%1s/v1.4/summoner/@/name";

  private static final Type GET_RUNES__TYPE = new TypeToken<Map<String, RunePages>>() {
  }.getType();

  private static final int GET_RUNES__GROUP = 40;

  private static final String GET_RUNES__URL = "/api/lol/%1s/v1.4/summoner/@/runes";

  private final RiotApi riotApi;

  public SummonerEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  public Map<String, Summoner> getByName(final Region region, final Iterable<String> input) throws
      ExecutionException {
    return riotApi.getMap2(String.format(GET_BY_NAME__URL, region), region, input, GET_BY_NAME__GROUP, GET_BY_NAME__TYPE);}

  public Map<String, Summoner> get(final Region region, final Iterable<Long> input) throws
      ExecutionException {
    return riotApi.getMap2(String.format(GET__URL, region), region, input, GET__GROUP, GET__TYPE);}

  public Map<String, MasteryPages> getMasteries(final Region region, final Iterable<Long> input)
      throws ExecutionException {
    return riotApi.getMap2(String.format(GET_MASTERIES__URL, region), region, input, GET_MASTERIES__GROUP, GET_MASTERIES__TYPE);}

  public Map<String, String> getNames(final Region region, final Iterable<Long> input) throws
      ExecutionException {
    return riotApi.getMap2(String.format(GET_NAMES__URL, region), region, input, GET_NAMES__GROUP, GET_NAMES__TYPE);}

  public Map<String, RunePages> getRunes(final Region region, final Iterable<Long> input) throws
      ExecutionException {
    return riotApi.getMap2(String.format(GET_RUNES__URL, region), region, input, GET_RUNES__GROUP, GET_RUNES__TYPE);}
}
