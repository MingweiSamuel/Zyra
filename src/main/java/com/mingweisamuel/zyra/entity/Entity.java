package com.mingweisamuel.zyra.entity;

import com.mingweisamuel.zyra.enums.Region;

/**
 * An superclass of high level "Entity" abstractions of Summoners and Matches. Should be thread-safe.
 */
public abstract class Entity {

    protected final EntityApi entityApi;
    protected final Region region;

    Entity(EntityApi entityApi, Region region) {
        this.entityApi = entityApi;
        this.region = region;
    }
}
