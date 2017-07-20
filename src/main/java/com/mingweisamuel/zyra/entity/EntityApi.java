package com.mingweisamuel.zyra.entity;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.Player;
import com.mingweisamuel.zyra.summoner.Summoner;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

//TODO configurable caches
//TODO better caching for summoners
/**
 * API for interacting with entities. Also acts as a builder and cache for entity instances.<br><br>
 *
 * MatchEntities are always cached by their match ID and duplicate instances will not be created unless the
 * previous instance has left the cache.<br><br>
 *
 * SummonerEntities are unambitiously cached by summoner ID or account ID, or both depending on what is supplied. Any
 * summoners with matching IDs will not be duplicated unless the previous instance has left the cache.
 * Summoners created using the {@link #getSummonerByName} method are not put into any cache. This may change in the
 * future.
 */
public class EntityApi implements Closeable {

    /** RiotApi instance. */
    final RiotApi riotApi;

    /** Cache for summoner entities by summonerId. */
    private final Cache<EntityKey, SummonerEntity> summonerIdEntityCache =
        CacheBuilder.newBuilder().softValues().build();
    /** Cache for summoner entities by accountId. */
    private final Cache<EntityKey, SummonerEntity> summonerAccountIdEntityCache =
        CacheBuilder.newBuilder().softValues().build();

    /** Cache for match entities. */
    private final Cache<EntityKey, MatchEntity> matchEntityCache = CacheBuilder.newBuilder().softValues().build();

    public EntityApi(RiotApi riotApi) {
        this.riotApi = riotApi;
    }

    /** @return The RiotApi this EntityApi uses. */
    public RiotApi getApi() {
        return riotApi;
    }

    @Override
    public void close() throws IOException {
        riotApi.close();
    }

    //region summoner
    /**
     * Gets a summoner entity by region and summoner ID. Will return a cached instance with matching summoner ID if
     * found.
     *
     * @param region Summoner's region.
     * @param summonerId Summoner's ID.
     * @return A SummonerEntity instance.
     */
    public SummonerEntity getSummoner(Region region, long summonerId) {
        try {
            return summonerIdEntityCache.get(new EntityKey(region, summonerId),
                () -> SummonerEntity.create(this, region, summonerId));
        } catch (ExecutionException e) {
            throw new RuntimeException("Failed to create summoner.", e);
        }
    }

    /**
     * Gets a summoner entity by region, summoner ID, and account ID. Will return a cached instance with matching
     * summoner ID or account ID if found.<br><br>
     *
     * Summoner ID and account ID should belong to the same summoner to prevent undefined behavior. Use
     * {@link #getSummoner(Region, long)} or {@link #getSummonerByAccountId(Region, long)} for whichever field is known.
     *
     * @param region Summoner's region.
     * @param summonerId Summoner's ID.
     * @param accountId Summoner's account ID.
     * @return A SummonerEntity instance.
     */
    public SummonerEntity getSummoner(Region region, long summonerId, long accountId) {
        try {
            return summonerIdEntityCache.get(new EntityKey(region, summonerId),
                () -> summonerAccountIdEntityCache.get(new EntityKey(region, accountId),
                    () -> SummonerEntity.create(this, region, summonerId, accountId)));
        } catch (ExecutionException e) {
            throw new RuntimeException("Failed to create summoner.", e);
        }
    }

    /**
     * Gets a summoner entity by region, summoner ID, and a supplied summoner name (which will be normalized). Will
     * return a cached instance with matching summoner ID or account ID if found.<br><br>
     *
     * Summoner ID and account ID should belong to the same summoner to prevent undefined behavior. Use
     * {@link #getSummoner(Region, long)} or {@link #getSummonerByAccountId(Region, long)} for whichever field is known.
     *
     * @param region Summoner's region.
     * @param summonerId Summoner's ID.
     * @param accountId Summoner's account ID.
     * @param name Summoner's name. Will be normalized, so capitalization and whitespace do not matter.
     * @return A SummonerEntity instance.
     */
    public SummonerEntity getSummoner(Region region, long summonerId, long accountId, String name) {
        if (name == null)
            throw new NullPointerException("NAME should not be null. Instead, do not supply a fourth argument.");
        try {
            return summonerIdEntityCache.get(new EntityKey(region, summonerId),
                () -> summonerAccountIdEntityCache.get(new EntityKey(region, accountId),
                    () -> SummonerEntity.create(this, region, summonerId, accountId, name)));
        } catch (ExecutionException e) {
            throw new RuntimeException("Failed to create summoner.", e);
        }
    }

    /**
     * Gets a summoner entity by a {@link Summoner} instance. Will return a cached instance with matching summoner ID or
     * account ID if found.
     *
     * @param region Summoner's Region.
     * @param summoner Summoner instance.
     * @return SummonerEntity instance.
     */
    public SummonerEntity getSummoner(Region region, Summoner summoner) {
        try {
            return summonerIdEntityCache.get(new EntityKey(region, summoner.id),
                () -> summonerAccountIdEntityCache.get(new EntityKey(region, summoner.accountId),
                    () -> SummonerEntity.create(this, region, summoner)));
        } catch (ExecutionException e) {
            throw new RuntimeException("Failed to create summoner.", e);
        }
    }

    /**
     * Gets a summoner by region and account ID. Will return a cached instance with matching account ID if found.
     *
     * @param region Summoner's region.
     * @param accountId Summoner's account ID.
     * @return A SummonerEntity instance.
     */
    public SummonerEntity getSummonerByAccountId(Region region, long accountId) {
        try {
            return summonerAccountIdEntityCache.get(new EntityKey(region, accountId),
                () -> SummonerEntity.createFromAccountId(this, region, accountId));
        } catch (ExecutionException e) {
            throw new RuntimeException("Failed to create summoner.", e);
        }
    }

    /**
     * Gets a summoner by region and a supplied summoner name (which will be normalized). Always returns a new
     * instance (never caches).
     *
     * @param region Summoner's region.
     * @param name Summoner's name.
     * @return A SummonerEntity instance.
     */
    public SummonerEntity getSummonerByName(Region region, String name) {
        if (name == null)
            throw new NullPointerException("NAME should not be null.");
        return SummonerEntity.createFromName(this, region, name);
    }

    /**
     * Gets a summoner entity by a {@link Player} instance. Will return a cached instance with matching summoner ID or
     * account ID if found.
     *
     * @param player Player instance from the particular summoner's game.
     * @return SummonerEntity instance.
     */
    public SummonerEntity getSummonerFromPlayer(Player player) {
        Region region = Region.parse(player.currentPlatformId);
        return getSummoner(region, player.summonerId, player.accountId, player.summonerName);
    }
    //endregion

    //region match
    /**
     * Gets a match entity by region and match ID. Will return a matching cached instance if found.
     *
     * @param region Match's region.
     * @param matchId Match's ID.
     * @param forAccountId Account ID for non-public (unranked) match participant identification.
     * @return MatchEntity instance.
     */
    public MatchEntity getMatch(Region region, long matchId, long forAccountId) {
        // TODO method not super thread-reliable.
        EntityKey entityKey = new EntityKey(region, matchId);
        MatchEntity entity = matchEntityCache.getIfPresent(entityKey);
        if (entity != null && Objects.equals(forAccountId, entity.getForAccountId()))
            return entity;
        entity = MatchEntity.create(this, region, matchId, forAccountId);
        matchEntityCache.put(entityKey, entity);
        return entity;
    }

    /**
     * Gets a match entity by region and match ID. Will return a matching cached instance if found.
     *
     * @param region Match's region.
     * @param matchId Match's ID.
     * @return MatchEntity instance.
     */
    public MatchEntity getMatch(Region region, long matchId) {
        try {
            return matchEntityCache.get(new EntityKey(region, matchId),
                    () -> MatchEntity.create(this, region, matchId, null));
        } catch (ExecutionException e) {
            throw new RuntimeException("Failed to create match.", e);
        }
    }
    //endregion

    //region entity key
    /**
     * Tuple of Region and long id to be used as cache keys.
     */
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
    //endregion
}
