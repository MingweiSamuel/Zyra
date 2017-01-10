package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.Shard;
import com.mingweisamuel.zyra.dto.ShardStatus;
import com.mingweisamuel.zyra.enums.Region;

import java.lang.String;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Endpoint for getting League Status. Does not require an API key and is not rate-limited.
 *
 * Calls to these endpoints do not follow max concurrent request limits. May also not follow the same retry policy.
 *
 * @version lol-status-v1.0
 */
public class LolStatusEndpoints {

    private static final Type GET_ALL__TYPE = new TypeToken<List<Shard>>() {}.getType();

    private static final String GET_ALL__URL = "status.leagueoflegends.com/shards";

    private static final Type GET__TYPE = ShardStatus.class;

    private static final String GET__URL = "status.leagueoflegends.com/shards/%1s";

    private final RiotApi riotApi;

    public LolStatusEndpoints(final RiotApi riotApi) {
        this.riotApi = riotApi;
    }

    public List<Shard> getAll() throws ExecutionException {
        return riotApi.getNonApi(GET_ALL__URL, GET_ALL__TYPE);
    }

    public CompletableFuture<List<Shard>> getAllAsync() {
        return riotApi.getNonApiAsync(GET_ALL__URL, GET_ALL__TYPE);
    }

    public ShardStatus get(final Region region) throws ExecutionException {
        return riotApi.getNonApi(String.format(GET__URL, region), GET__TYPE);
    }

    public CompletableFuture<ShardStatus> getAsync(final Region region) {
        return riotApi.getNonApiAsync(String.format(GET__URL, region), GET__TYPE);
    }
}
