package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.dto.CurrentGameInfo;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CurrentGameEndpoints {
  private static final Type GET__TYPE = CurrentGameInfo.class;

  private static final String GET__URL = "/observer-mode/rest/consumer/getSpectatorGameInfo/%1s/%2s";

  private final RiotApi riotApi;

  public CurrentGameEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * @param summonerId Riot API description: The ID of the summoner. */
  public CurrentGameInfo get(final Region region, final long summonerId) throws ExecutionException {
    return riotApi.getBasic2(String.format(GET__URL, region, summonerId), region, GET__TYPE);}

  /**
   * @param summonerId Riot API description: The ID of the summoner. */
  public CompletableFuture<CurrentGameInfo> getAsync(final Region region, final long summonerId) {
    return riotApi.getBasicAsync2(String.format(GET__URL, region, summonerId), region, GET__TYPE);}
}
