package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.entity.SummonerEntity;
import com.mingweisamuel.zyra.enums.Region;
import org.junit.Test;

/**
 * Tests for {@link SummonerEntity#getRecentMatchEntities()} and related methods.
 */
public class EntitySummonerMatchRecentTest extends EntityTest {

    @Test
    public void getRecent() {
        SummonerEntity sneaky = eApi.getSummoner(Region.NA, 51405);

        ApiMatchListTest.checkGetRecent(sneaky.getRecentMatchlist());
    }
}
