package com.mingweisamuel.zyra.entity;

import com.mingweisamuel.zyra.enums.Region;

/**
 * An superclass of high level "Entity" abstractions of Summoners and Matches. Should be thread-safe.
 */
public abstract class Entity {

    /** EntityApi instance from which this Entity was created. */
    protected final EntityApi entityApi;
    /** This Entity's region. */
    protected final Region region;

    /** Creates an entity associated with the given entityApi and region. */
    Entity(EntityApi entityApi, Region region) {
        this.entityApi = entityApi;
        this.region = region;
    }

    /**
     * This entity's region.
     * @return The region this entity is associated with.
     */
    public Region getRegion() {
        return region;
    }
}
