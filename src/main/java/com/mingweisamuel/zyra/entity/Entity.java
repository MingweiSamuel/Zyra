package com.mingweisamuel.zyra.entity;

import com.mingweisamuel.zyra.enums.Region;

/**
 * An superclass of high level "Entity" abstractions of Summoners and Matches.
 */
public abstract class Entity {

    protected final EntityApi entityApi;
    protected final Region region;

    /** {@code true} if getting data for the summoner has failed in some way. */
    protected volatile boolean invalid = false;
    /** Exception that caused the entity to become invalid. */
    protected volatile Throwable exception = null;

    Entity(EntityApi entityApi, Region region) {
        this.entityApi = entityApi;
        this.region = region;
    }
}
