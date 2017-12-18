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

    public static final long MILLIS_PER_WEEK = 1000 * 3600 * 24 * 7;

    public static final long queryTime = 1484292409447L;
    @Test
    public void getQuery() {
        checkGetQuery(api.matches.getMatchlist(Region.NA, 78247, Collections.singletonList(420),
            queryTime - MILLIS_PER_WEEK, queryTime, Collections.singletonList(ChampionId.KALISTA)));
    }
    @Test
    public void getQueryAsync() {
        api.matches.getMatchlistAsync(Region.NA, 78247, Collections.singletonList(420),
            queryTime - MILLIS_PER_WEEK, queryTime, Collections.singletonList(ChampionId.KALISTA))
            .thenAccept(ApiMatchListTest::checkGetQuery).join();
    }
    public static void checkGetQuery(Matchlist matchlist) {
        assertNotNull(matchlist);
        assertEquals(1, matchlist.totalGames);
        assertEquals(0, matchlist.startIndex);
        assertEquals(1, matchlist.endIndex);
        assertNotNull(matchlist.matches);

        long[] expected = { 2398184332L };
        assertEquals(expected.length, matchlist.matches.size());
        for (int i = 0; i < expected.length; i++) {
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
        //assertEquals(matchlist.totalGames, matchlist.matches.size());

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
