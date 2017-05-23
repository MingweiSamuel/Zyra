package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.ChampionId;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.Matchlist;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.enums.ChampionId.DRAVEN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.MatchEndpoints}.
 * TODO recent matchlist
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
}
