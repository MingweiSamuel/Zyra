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
    public void testBasic() {
        testBasicValidate(eApi.getMatch(Region.NA, 2398184332L));
    }
    public static void testBasicValidate(MatchEntity match) {
        assertEquals(2398184332L, match.getMatchId());
        ApiMatchTest.checkGet(match.getInfo());
        ApiMatchTest.checkGetTimeline(match.getTimeline());
    }

    @Test
    public void testSimpleMatchInstanceCaching() {
        MatchEntity m1 = eApi.getMatch(Region.NA, 2398184332L);
        MatchEntity m2 = eApi.getMatch(Region.NA, 2398184332L);
        assertSame(m1, m2);
    }
}
