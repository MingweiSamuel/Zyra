package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStatus.ShardStatus;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * lol-status-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class LolStatusEndpoints extends Endpoints {
  LolStatusEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Get League of Legends status for the given shard.
   * ## Rate Limit Notes
   * Requests to this API are not counted against the application Rate Limits.
   *
   * <a href="https://developer.riotgames.com/api-methods/#lol-status-v3/GET_getShardData">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public ShardStatus getShardData(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/status/v3/shard-data";
    Type type = ShardStatus.class;
    return riotApi.getBasicNonRateLimited("lol-status-v3.getShardData", url, region, type, Collections.emptyList());
  }

  /**
   * Get League of Legends status for the given shard.
   * ## Rate Limit Notes
   * Requests to this API are not counted against the application Rate Limits.
   *
   * <a href="https://developer.riotgames.com/api-methods/#lol-status-v3/GET_getShardData">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<ShardStatus> getShardDataAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/status/v3/shard-data";
    Type type = ShardStatus.class;
    return riotApi.getBasicNonRateLimitedAsync("lol-status-v3.getShardData", url, region, type, Collections.emptyList());
  }
}
