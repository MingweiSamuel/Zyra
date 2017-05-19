package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.entity.MatchEntity;
import com.mingweisamuel.zyra.enums.Region;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link com.mingweisamuel.zyra.entity.MatchEntity}.
 */
public class EntityMatchTest extends EntityTest {

    @Test
    public void test() {
        MatchEntity match = eApi.getMatch(Region.NA, 2398184332L);
        assertEquals(2398184332L, match.getMatchId());
        ApiMatchTest.checkGet(match.getInfo());
        ApiMatchTest.checkGetTimeline(match.getTimeline());
    }
}
