package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.ChampionId;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.matchV4.Matchlist;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.MatchV4Endpoints}.
 */
@Ignore("date out of range now") // TODO
public class ApiMatchListV4Test extends ApiTest {

    public static final long MILLIS_PER_WEEK = 1000 * 3600 * 24 * 7;

    public static final long queryTime = 1484292409447L;
    @Test
    public void getQuery() {
        checkGetQuery(api.matchesV4.getMatchlist(Region.NA, SUMMONER_ID_C9SNEAKY, Collections.singletonList(ChampionId.KALISTA),
            Collections.singletonList(420), null, queryTime, queryTime - MILLIS_PER_WEEK));
    }
    @Test
    public void getQueryAsync() {
        api.matchesV4.getMatchlistAsync(Region.NA, SUMMONER_ID_C9SNEAKY, Collections.singletonList(ChampionId.KALISTA),
            Collections.singletonList(420), null, queryTime, queryTime - MILLIS_PER_WEEK)
            .thenAccept(ApiMatchListV4Test::checkGetQuery).join();
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
}
