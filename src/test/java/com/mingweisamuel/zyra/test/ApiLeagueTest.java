package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Queue;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.enums.Tier;
import com.mingweisamuel.zyra.game.Game;
import com.mingweisamuel.zyra.game.RecentGames;
import com.mingweisamuel.zyra.league.League;
import com.mingweisamuel.zyra.league.LeagueEntry;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.test.Api.api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LeagueEndpoints}.
 */
public class ApiLeagueTest {

    @Test
    public void getTop() throws ExecutionException {
        checkGetTop(api.leagues.getChallengers(Region.NA, Queue.RANKED_SOLO_5x5),
                api.leagues.getMasters(Region.NA, Queue.RANKED_SOLO_5x5));
    }
    @Test
    public void getTopAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<League> challenger = api.leagues.getChallengersAsync(Region.NA, Queue.RANKED_SOLO_5x5);
        CompletableFuture<League> master = api.leagues.getMastersAsync(Region.NA, Queue.RANKED_SOLO_5x5);
        challenger.thenAcceptBoth(master, this::checkGetTop).get();
    }
    private void checkGetTop(League challenger, League master) {
        assertEquals(Tier.CHALLENGER, challenger.tier);
        assertEquals("Dr. Mundo's Scouts", challenger.name); // lol
        assertEquals(200, challenger.entries.size());
        double challengerLp = 0;
        for (LeagueEntry entry : challenger.entries) {
            assertTrue(entry.leaguePoints > 0);
            challengerLp += entry.leaguePoints / 200.0;
        }
        assertEquals(Tier.MASTER, master.tier);
        assertEquals("Renekton's Shadows", master.name);
        for (LeagueEntry entry : master.entries)
            assertTrue(entry.leaguePoints < challengerLp);
    }

}
