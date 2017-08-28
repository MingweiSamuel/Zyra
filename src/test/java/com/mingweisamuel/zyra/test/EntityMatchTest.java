package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.entity.MatchEntity;
import com.mingweisamuel.zyra.enums.Region;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Tests for {@link com.mingweisamuel.zyra.entity.MatchEntity}.
 */
public class EntityMatchTest extends EntityTest {

    @Test
    public void getMatchBasic() {
        testBasicValidate(eApi.getMatch(Region.NA, 2357244372L));
    }
    public static void testBasicValidate(MatchEntity match) {
        assertEquals(2357244372L, match.getMatchId());
        ApiMatchTest.checkGet(match.getInfo());
        ApiMatchTest.checkGetTimeline(match.getTimeline());
    }

    public static void testBasicValidate2(MatchEntity match) {
        assertEquals(2398184332L, match.getMatchId());
//        ApiMatchTest.checkGet2(match.getInfo());
//        ApiMatchTest.checkGetTimeline2(match.getTimeline());
    }

    @Test
    public void simpleMatchInstanceCaching() {
        MatchEntity m1 = eApi.getMatch(Region.NA, 2357244372L);
        MatchEntity m2 = eApi.getMatch(Region.NA, 2357244372L);
        assertSame(m1, m2);
    }
}
