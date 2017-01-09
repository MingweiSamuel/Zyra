package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.dto.FeaturedGames;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link RiotDtoGenerator}.
 *
 * @version featured-games-v1.0 */
public class FeaturedGamesEndpoints {
  private static final Type GET__TYPE = FeaturedGames.class;

  private static final String GET__URL = "/observer-mode/rest/featured";

  private final RiotApi riotApi;

  public FeaturedGamesEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  public FeaturedGames get(final Region region) throws ExecutionException {
    return riotApi.getBasic2(String.format(GET__URL, region), region, GET__TYPE);}

  public CompletableFuture<FeaturedGames> getAsync(final Region region) {
    return riotApi.getBasicAsync2(String.format(GET__URL, region), region, GET__TYPE);}
}
