package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.summoner.Summoner;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * summoner-v3
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class SummonerEndpoints extends Endpoints {
  SummonerEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getByAccountId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param accountId (required) 
   */
  public Summoner getByAccountId(final Region region, final long accountId) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/by-account/%1$s", accountId);
    Type type = Summoner.class;
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getByAccountId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param accountId (required) 
   */
  public CompletableFuture<Summoner> getByAccountIdAsync(final Region region, final long accountId)
      throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/by-account/%1$s", accountId);
    Type type = Summoner.class;
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerName">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerName (required) Summoner Name
   */
  public Summoner getBySummonerName(final Region region, final String summonerName) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/by-name/%1$s", summonerName);
    Type type = Summoner.class;
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerName">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerName (required) Summoner Name
   */
  public CompletableFuture<Summoner> getBySummonerNameAsync(final Region region,
      final String summonerName) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/by-name/%1$s", summonerName);
    Type type = Summoner.class;
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID
   */
  public Summoner getBySummonerId(final Region region, final long summonerId) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/%1$s", summonerId);
    Type type = Summoner.class;
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID
   */
  public CompletableFuture<Summoner> getBySummonerIdAsync(final Region region,
      final long summonerId) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/%1$s", summonerId);
    Type type = Summoner.class;
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }
}
