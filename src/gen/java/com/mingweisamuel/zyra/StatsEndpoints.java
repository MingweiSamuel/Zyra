package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.dto.PlayerStatsSummaryList;
import com.mingweisamuel.zyra.dto.RankedStats;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version stats-v1.3 */
public class StatsEndpoints {
  private static final Type GET_RANKED__TYPE = RankedStats.class;

  private static final String GET_RANKED__URL = "/api/lol/%1s/v1.3/stats/by-summoner/%2s/ranked";

  private static final Type GET_SUMMARY__TYPE = PlayerStatsSummaryList.class;

  private static final String GET_SUMMARY__URL = "/api/lol/%1s/v1.3/stats/by-summoner/%2s/summary";

  private final RiotApi riotApi;

  public StatsEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  public RankedStats getRanked(final Region region, final long summonerId) throws
      ExecutionException {
    return riotApi.getMap2(String.format(GET_RANKED__URL, region), region, input, null, GET_RANKED__TYPE);}

  public PlayerStatsSummaryList getSummary(final Region region, final long summonerId) throws
      ExecutionException {
    return riotApi.getMap2(String.format(GET_SUMMARY__URL, region), region, input, null, GET_SUMMARY__TYPE);}
}
