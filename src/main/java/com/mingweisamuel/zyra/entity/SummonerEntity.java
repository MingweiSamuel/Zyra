package com.mingweisamuel.zyra.entity;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.mingweisamuel.zyra.enums.Region;

import java.util.concurrent.ExecutionException;

/**
 * A high-level representation of a Summoner. TODO
 */
public class SummonerEntity {

    private static final Cache<SummonerKey, SummonerEntity> instances = CacheBuilder.newBuilder().weakValues().build();

    public static SummonerEntity fromId(Region region, long summonerId) {
        SummonerKey key = new SummonerKey(region, summonerId);
        try {
            return instances.get(key, () -> new SummonerEntity(key));
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static SummonerEntity getByName(Region region, String name) {
        return null; //TODO
    }

    private final SummonerKey key;

    private SummonerEntity(SummonerKey key) {
        this.key = key;
    }
}
