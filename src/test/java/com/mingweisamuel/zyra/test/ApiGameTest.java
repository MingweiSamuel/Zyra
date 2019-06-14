package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.matchV4.MatchReference;
import com.mingweisamuel.zyra.matchV4.Matchlist;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.MatchV4Endpoints}.
 */
@Ignore("recent matchlist removed") // TODO
public class ApiGameTest extends ApiTest {

    @Test
    public void getRecent() {
        checkGetRecent(api.matchesV4.getMatchlist(Region.NA, SUMMONER_ID_C9SNEAKY)); // C9 Sneaky's Account ID
    }
    @Test
    public void getRecentAsync() throws ExecutionException, InterruptedException {
        api.matchesV4.getMatchlistAsync(Region.NA, SUMMONER_ID_C9SNEAKY).thenAccept(this::checkGetRecent).get();
    }
    private void checkGetRecent(Matchlist result) {
        assertEquals(20, result.matches.size());
        for (MatchReference game : result.matches)
            assertTrue("" + game.timestamp, game.timestamp >= 1483861238808L);
    }
}
