package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.ChampionId;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.MatchReference;
import com.mingweisamuel.zyra.match.Matchlist;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.MatchEndpoints}.
 */
public class ApiMatchListTest extends ApiTest {

    @Test
    public void getQuery() {
        checkGetQuery(api.matches.getMatchlist(Region.NA, 78247, Collections.singletonList(420), null, 1484292409447L,
            Collections.singletonList(ChampionId.KALISTA), Collections.singletonList(8)));
    }
    @Test
    public void getQueryAsync() {
        api.matches.getMatchlistAsync(Region.NA, 78247, Collections.singletonList(420), null, 1484292409447L,
            Collections.singletonList(ChampionId.KALISTA), Collections.singletonList(8))
            .thenAccept(ApiMatchListTest::checkGetQuery).join();
    }
    public static void checkGetQuery(Matchlist matchlist) {
        assertNotNull(matchlist);
        assertEquals(3, matchlist.totalGames);
        assertEquals(0, matchlist.startIndex);
        assertEquals(3, matchlist.endIndex);
        assertNotNull(matchlist.matches);
        assertEquals(3, matchlist.matches.size());

        long[] expected = {2398184332L, 2357244372L, 2354486602L};
        for (int i = 0; i < 3; i++) {
            assertNotNull(matchlist.matches.get(i));
            assertEquals(expected[i], matchlist.matches.get(i).gameId);
        }
    }

    @Test
    public void getRecent() {
        checkGetRecent(api.matches.getRecentMatchlist(Region.NA, 78247));
    }
    @Test
    public void getRecentAsync() {
        api.matches.getRecentMatchlistAsync(Region.NA, 78247).thenAccept(ApiMatchListTest::checkGetRecent).join();
    }
    public static void checkGetRecent(Matchlist matchlist) {
        assertNotNull(matchlist);
        assertNotNull(matchlist.matches);
        assertEquals(matchlist.totalGames, matchlist.matches.size());

        long after = 1494737245688L;
        long timestamp = Long.MAX_VALUE;
        for (MatchReference match : matchlist.matches) {
            assertNotNull(match);
            assertTrue(match.timestamp >= after);
            // check descending
            assertTrue(match.timestamp < timestamp);
            timestamp = match.timestamp;
        }
    }
}
