package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.summoner.Summoner;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * summoner-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class SummonerEndpoints extends Endpoints {
  SummonerEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get a summoner by account ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getByAccountId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param accountId (required) null
   */
  public Summoner getByAccountId(final Region region, final long accountId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/by-account/%1$s", accountId);
    Type type = Summoner.class;
    return riotApi.getBasic("summoner-v3.getByAccountId", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by account ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getByAccountId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param accountId (required) null
   */
  public CompletableFuture<Summoner> getByAccountIdAsync(final Region region,
      final long accountId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/by-account/%1$s", accountId);
    Type type = Summoner.class;
    return riotApi.getBasicAsync("summoner-v3.getByAccountId", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by summoner name.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerName">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerName (required) Summoner Name
   */
  public Summoner getBySummonerName(final Region region, final String summonerName) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/by-name/%1$s", summonerName);
    Type type = Summoner.class;
    return riotApi.getBasic("summoner-v3.getBySummonerName", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by summoner name.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerName">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerName (required) Summoner Name
   */
  public CompletableFuture<Summoner> getBySummonerNameAsync(final Region region,
      final String summonerName) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/by-name/%1$s", summonerName);
    Type type = Summoner.class;
    return riotApi.getBasicAsync("summoner-v3.getBySummonerName", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID
   */
  public Summoner getBySummonerId(final Region region, final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/%1$s", summonerId);
    Type type = Summoner.class;
    return riotApi.getBasic("summoner-v3.getBySummonerId", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID
   */
  public CompletableFuture<Summoner> getBySummonerIdAsync(final Region region,
      final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v3/summoners/%1$s", summonerId);
    Type type = Summoner.class;
    return riotApi.getBasicAsync("summoner-v3.getBySummonerId", url, region, type, Collections.emptyList());
  }
}
