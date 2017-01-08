package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.Shard;
import com.mingweisamuel.zyra.dto.ShardStatus;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version lol-status-v1.0 */
public class LolStatusEndpoints {
  private static final Type GET_ALL__TYPE = new TypeToken<List<Shard>>() {
  }.getType();

  private static final String GET_ALL__URL = "/shards";

  private static final Type GET__TYPE = ShardStatus.class;

  private static final String GET__URL = "/shards/%1s";

  private final RiotApi riotApi;

  public LolStatusEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  public List<Shard> getAll(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_ALL__URL, region), region, input, null, GET_ALL__TYPE);}

  public ShardStatus get(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET__URL, region), region, input, null, GET__TYPE);}
}
