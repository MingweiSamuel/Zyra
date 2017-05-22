package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.MatchReference;
import com.mingweisamuel.zyra.match.Matchlist;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.MatchEndpoints}.
 */
public class ApiGameTest extends ApiTest {

    @Test
    public void getRecent() {
        checkGetRecent(api.matches.getRecentMatchlist(Region.NA, 78247)); // C9 Sneaky's Account ID
    }
    @Test
    public void getRecentAsync() throws ExecutionException, InterruptedException {
        api.matches.getRecentMatchlistAsync(Region.NA, 78247).thenAccept(this::checkGetRecent).get();
    }
    private void checkGetRecent(Matchlist result) {
        assertEquals(20, result.matches.size());
        for (MatchReference game : result.matches)
            assertTrue("" + game.timestamp, game.timestamp >= 1483861238808L);
    }
}
