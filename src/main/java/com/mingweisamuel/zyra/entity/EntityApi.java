package com.mingweisamuel.zyra.entity;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.Player;
import com.mingweisamuel.zyra.summoner.Summoner;

import java.util.concurrent.ExecutionException;

/**
 * API for interacting with entities. Also acts as a builder and cache for entity instances.
 * TODO caching
 */
public class EntityApi {

    /** RiotApi instance. */
    final RiotApi riotApi;

    /** Cache for match entities. */
    private final Cache<Long, MatchEntity> matchEntityCache = CacheBuilder.newBuilder().softValues().build();

    public EntityApi(RiotApi riotApi) {
        this.riotApi = riotApi;
    }

    public SummonerEntity getSummoner(Region region, long summonerId) {
        return SummonerEntity.create(this, region, summonerId);
    }
    public SummonerEntity getSummoner(Region region, long summonerId, long accountId) {
        return SummonerEntity.create(this, region, summonerId, accountId);
    }
    public SummonerEntity getSummoner(Region region, long summonerId, long accountId, String name) {
        return SummonerEntity.create(this, region, summonerId, accountId);
    }
    public SummonerEntity getSummoner(Region region, Summoner summoner) {
        return SummonerEntity.create(this, region, summoner);
    }

    public SummonerEntity getSummonerByAccountId(Region region, long accountId) {
        return SummonerEntity.createFromAccountId(this, region, accountId);
    }
    public SummonerEntity getSummonerByName(Region region, String name) {
        return SummonerEntity.createFromName(this, region, name);
    }

    public SummonerEntity getSummonerFromPlayer(Player player) {
        return SummonerEntity.createFromPlayer(this, player);
    }

    public MatchEntity getMatch(Region region, long matchId) {
        try {
            return matchEntityCache.get(matchId, () -> MatchEntity.create(this, region, matchId));
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
