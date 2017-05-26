package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.entity.EntityApi;

/**
 * Base class for entity test classes.
 */
public abstract class EntityTest extends ApiTest {
    protected static final EntityApi eApi = new EntityApi(api);
}
