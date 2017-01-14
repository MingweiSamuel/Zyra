package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.game.Game;
import com.mingweisamuel.zyra.game.RecentGames;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.test.Api.api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.GameEndpoints}.
 */
public class ApiGameTest {

    @Test
    public void getRecent() throws ExecutionException {
        checkGetRecent(api.games.getRecent(Region.NA, 51405));
    }
    @Test
    public void getRecentAsync() throws ExecutionException, InterruptedException {
        api.games.getRecentAsync(Region.NA, 51405).thenAccept(this::checkGetRecent).get();
    }
    private void checkGetRecent(RecentGames result) {
        assertEquals(51405, result.summonerId);
        assertEquals(10, result.games.size());
        for (Game game : result.games)
            assertTrue("" + game.createDate, game.createDate >= 1483861238808L);
    }
}
