package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * third-party-code-v4 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class ThirdPartyCodeV4Endpoints extends Endpoints {
  ThirdPartyCodeV4Endpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get third party code for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#third-party-code-v4/GET_getThirdPartyCodeBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) null
   */
  public String getThirdPartyCodeBySummonerId(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/platform/v4/third-party-code/by-summoner/%1$s", encryptedSummonerId);
    Type type = String.class;
    return riotApi.getBasic("third-party-code-v4.getThirdPartyCodeBySummonerId", url, region, type, Collections.emptyList());
  }

  /**
   * Get third party code for a given summoner ID.
   *
   * <a href="https://developer.riotgames.com/api-methods/#third-party-code-v4/GET_getThirdPartyCodeBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param encryptedSummonerId (required) null
   */
  public CompletableFuture<String> getThirdPartyCodeBySummonerIdAsync(final Region region,
      final String encryptedSummonerId) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/platform/v4/third-party-code/by-summoner/%1$s", encryptedSummonerId);
    Type type = String.class;
    return riotApi.getBasicAsync("third-party-code-v4.getThirdPartyCodeBySummonerId", url, region, type, Collections.emptyList());
  }
}
