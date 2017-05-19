package com.mingweisamuel.zyra.entity;

import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.enums.Region;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * API for interacting with entities. Also acts as a builder for entity classes.
 */
public class EntityApi {

    final RiotApi riotApi;

    public EntityApi(RiotApi riotApi) {
        this.riotApi = riotApi;
    }

    public SummonerEntity getSummoner(Region region, long summonerId) {
        return SummonerEntity.create(this, region, summonerId);
    }
    public SummonerEntity getSummoner(Region region, long summonerId, long accountId) {
        return SummonerEntity.create(this, region, summonerId, accountId);
    }
    public SummonerEntity getSummonerByAccountId(Region region, long accountId) {
        return SummonerEntity.createFromAccountId(this, region, accountId);
    }
    public SummonerEntity getSummonerByName(Region region, String name) {
        return SummonerEntity.createFromName(this, region, name);
    }

    public static <T> T complete(CompletableFuture<? extends T> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
