package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.dto.MatchDetail;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version match-v2.2 */
public class MatchEndpoints {
  private static final Type GET__TYPE = MatchDetail.class;

  private static final String GET__URL = "/api/lol/%1s/v2.2/match/%2s";

  private final RiotApi riotApi;

  public MatchEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  public MatchDetail get(final Region region, final long matchId) throws ExecutionException {
    return riotApi.getMap2(String.format(GET__URL, region), region, input, null, GET__TYPE);}
}
