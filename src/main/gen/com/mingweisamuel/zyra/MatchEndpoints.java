package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.MatchDetail;
import java.lang.Boolean;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class MatchEndpoints {
  private static final Type GET__TYPE = MatchDetail.class;

  private static final String GET__URL = "/api/lol/%1s/v2.2/match/%2s";

  private final RiotApi riotApi;

  public MatchEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * Not all matches have timeline data. If timeline data is requested, but doesn't exist, then the response won't include it.
   *
   * @param matchId Riot API description: The ID of the match.
   * @param includeTimeline Riot API description: Flag indicating whether or not to include match timeline data */
  public MatchDetail get(final Region region, final long matchId, final Boolean includeTimeline)
      throws ExecutionException {
    return riotApi.getBasic(String.format(GET__URL, region, matchId, includeTimeline), region, GET__TYPE,
    riotApi.makeParams("includeTimeline", includeTimeline));}

  /**
   * Not all matches have timeline data. If timeline data is requested, but doesn't exist, then the response won't include it.
   *
   * @param matchId Riot API description: The ID of the match.
   * @param includeTimeline Riot API description: Flag indicating whether or not to include match timeline data */
  public CompletableFuture<MatchDetail> getAsync(final Region region, final long matchId,
      final Boolean includeTimeline) {
    return riotApi.getBasicAsync(String.format(GET__URL, region, matchId, includeTimeline), region, GET__TYPE,
    riotApi.makeParams("includeTimeline", includeTimeline));}

  /**
   * Not all matches have timeline data. If timeline data is requested, but doesn't exist, then the response won't include it.
   *
   * @param matchId Riot API description: The ID of the match. */
  public MatchDetail get(final Region region, final long matchId) throws ExecutionException {
    return get(region, matchId, null);}

  /**
   * Not all matches have timeline data. If timeline data is requested, but doesn't exist, then the response won't include it.
   *
   * @param matchId Riot API description: The ID of the match. */
  public CompletableFuture<MatchDetail> getAsync(final Region region, final long matchId) {
    return getAsync(region, matchId, null);}
}
