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
    private final Cache<EntityKey, MatchEntity> matchEntityCache = CacheBuilder.newBuilder().softValues().build();

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
            EntityKey key = new EntityKey(region, matchId);
            return matchEntityCache.get(key, () -> MatchEntity.create(this, region, matchId));
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static class EntityKey {

        public final Region region;
        public final long id;

        public EntityKey(Region region, long id) {
            if (region == null)
                throw new NullPointerException("Region cannot be null");
            this.region = region;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            EntityKey entityKey = (EntityKey) o;

            return id == entityKey.id && region == entityKey.region;
        }

        @Override
        public int hashCode() {
            int result = (int) (id ^ (id >>> 32));
            result = 31 * result + region.hashCode();
            return result;
        }
    }
}
