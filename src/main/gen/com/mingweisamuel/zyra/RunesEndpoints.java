package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.runes.RunePages;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * runes-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class RunesEndpoints extends Endpoints {
  RunesEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get rune pages for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#runes-v3/GET_getRunePagesBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID
   */
  public RunePages getRunePagesBySummonerId(final Region region, final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/platform/v3/runes/by-summoner/%1$s", summonerId);
    Type type = RunePages.class;
    return riotApi.getBasic("runes-v3_GET_getRunePagesBySummonerId_content", url, region, type, Collections.emptyList());
  }

  /**
   * Get rune pages for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#runes-v3/GET_getRunePagesBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param summonerId (required) Summoner ID
   */
  public CompletableFuture<RunePages> getRunePagesBySummonerIdAsync(final Region region,
      final long summonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/platform/v3/runes/by-summoner/%1$s", summonerId);
    Type type = RunePages.class;
    return riotApi.getBasicAsync("runes-v3_GET_getRunePagesBySummonerId_content", url, region, type, Collections.emptyList());
  }
}
