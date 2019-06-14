package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.summonerV4.Summoner;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * summoner-v4 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class SummonerV4Endpoints extends Endpoints {
  SummonerV4Endpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get a summoner by account ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v4/GET_getByAccountId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) null
   */
  public Summoner getByAccountId(final Region region, final String encryptedAccountId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v4/summoners/by-account/%1$s", encryptedAccountId);
    Type type = Summoner.class;
    return riotApi.getBasic("summoner-v4.getByAccountId", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by account ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v4/GET_getByAccountId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedAccountId (required) null
   */
  public CompletableFuture<Summoner> getByAccountIdAsync(final Region region,
      final String encryptedAccountId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v4/summoners/by-account/%1$s", encryptedAccountId);
    Type type = Summoner.class;
    return riotApi.getBasicAsync("summoner-v4.getByAccountId", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by summoner name.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v4/GET_getBySummonerName">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerName (required) Summoner Name
   */
  public Summoner getBySummonerName(final Region region, final String summonerName) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v4/summoners/by-name/%1$s", summonerName);
    Type type = Summoner.class;
    return riotApi.getBasic("summoner-v4.getBySummonerName", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by summoner name.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v4/GET_getBySummonerName">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerName (required) Summoner Name
   */
  public CompletableFuture<Summoner> getBySummonerNameAsync(final Region region,
      final String summonerName) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v4/summoners/by-name/%1$s", summonerName);
    Type type = Summoner.class;
    return riotApi.getBasicAsync("summoner-v4.getBySummonerName", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by PUUID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v4/GET_getByPUUID">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedPUUID (required) Summoner ID
   */
  public Summoner getByPUUID(final Region region, final String encryptedPUUID) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v4/summoners/by-puuid/%1$s", encryptedPUUID);
    Type type = Summoner.class;
    return riotApi.getBasic("summoner-v4.getByPUUID", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by PUUID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v4/GET_getByPUUID">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedPUUID (required) Summoner ID
   */
  public CompletableFuture<Summoner> getByPUUIDAsync(final Region region,
      final String encryptedPUUID) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v4/summoners/by-puuid/%1$s", encryptedPUUID);
    Type type = Summoner.class;
    return riotApi.getBasicAsync("summoner-v4.getByPUUID", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v4/GET_getBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) Summoner ID
   */
  public Summoner getBySummonerId(final Region region, final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v4/summoners/%1$s", encryptedSummonerId);
    Type type = Summoner.class;
    return riotApi.getBasic("summoner-v4.getBySummonerId", url, region, type, Collections.emptyList());
  }

  /**
   * Get a summoner by summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#summoner-v4/GET_getBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) Summoner ID
   */
  public CompletableFuture<Summoner> getBySummonerIdAsync(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/summoner/v4/summoners/%1$s", encryptedSummonerId);
    Type type = Summoner.class;
    return riotApi.getBasicAsync("summoner-v4.getBySummonerId", url, region, type, Collections.emptyList());
  }
}
