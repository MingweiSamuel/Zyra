package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Queue;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.enums.Tier;
import com.mingweisamuel.zyra.league.League;
import com.mingweisamuel.zyra.league.LeagueEntry;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LeagueEndpoints}.
 */
public class ApiLeagueTest extends ApiTest {

    @Test
    public void get() throws  ExecutionException {
        checkGet(api.leagues.get(Region.NA, Collections.singleton(51405L)));
    }
    @Test
    public void getAsync() throws  ExecutionException, InterruptedException {
        api.leagues.getAsync(Region.NA, Collections.singleton(51405L)).thenAccept(this::checkGet).get();
    }
    private void checkGet(Map<Long, List<League>> result) {
        // C9 Sneaky
        List<League> leagueList = result.values().iterator().next();
        for (League league : leagueList) {
            if (Queue.RANKED_SOLO_5x5.equals(league.queue)) {
                // Sneaky better be at least Diamond
                assertTrue(league.tier,
                    Tier.DIAMOND.equals(league.tier) ||
                    Tier.MASTER.equals(league.tier) ||
                    Tier.CHALLENGER.equals(league.tier));
                assertTrue(league.entries.size() > 1);
                for (LeagueEntry entry : league.entries) {
                    if ("51405".equals(entry.playerOrTeamId)) {
                        assertTrue(entry.playerOrTeamName, entry.playerOrTeamName.contains("Sneaky"));
                        return;
                    }
                }
                fail("Failed to find Sneaky in league.");
            }
        }
        fail("Failed to find queue " + Queue.RANKED_SOLO_5x5);
    }

    @Test
    public void getEntries() throws  ExecutionException {
        checkGetEntries(api.leagues.getEntries(Region.NA, Collections.singleton(51405L)));
    }
    @Test
    public void getEntriesAsync() throws  ExecutionException, InterruptedException {
        api.leagues.getEntriesAsync(Region.NA, Collections.singleton(51405L)).thenAccept(this::checkGetEntries).get();
    }
    private void checkGetEntries(Map<Long, List<League>> result) {
        List<League> leagueList = result.values().iterator().next();
        for (League league : leagueList) {
            if (Queue.RANKED_SOLO_5x5.equals(league.queue)) {
                // Sneaky better be at least Diamond
                assertTrue(league.tier, Tier.DIAMOND.equals(league.tier) ||
                    Tier.MASTER.equals(league.tier) ||
                    Tier.CHALLENGER.equals
                    (league.tier));
                assertTrue(league.entries.size() == 1);
                LeagueEntry entry = league.entries.get(0);
                assertTrue("51405".equals(entry.playerOrTeamId));
                assertTrue(entry.playerOrTeamName, entry.playerOrTeamName.contains("Sneaky"));
                return;
            }
        }
        fail("Failed to find queue " + Queue.RANKED_SOLO_5x5);
    }

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
