package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStatus.ShardStatus;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * lol-status-v3
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class LolStatusEndpoints extends Endpoints {
  LolStatusEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-status-v3/GET_getShardData">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public ShardStatus getShardData(final Region region) throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/status/v3/shard-data";
    Type type = ShardStatus.class;
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-status-v3/GET_getShardData">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<ShardStatus> getShardDataAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/status/v3/shard-data";
    Type type = ShardStatus.class;
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }
}
