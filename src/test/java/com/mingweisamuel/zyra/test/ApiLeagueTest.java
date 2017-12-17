package com.mingweisamuel.zyra.test;

import com.google.gson.Gson;
import com.mingweisamuel.zyra.enums.Queue;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.enums.Tier;
import com.mingweisamuel.zyra.league.LeaguePosition;
import com.mingweisamuel.zyra.league.LeagueList;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LeagueEndpoints}.
 */
public class ApiLeagueTest extends ApiTest {

    @Test
    public void get() throws  ExecutionException {
        checkGet(api.leagues.getAllLeaguesForSummoner(Region.NA, 51405)); // C9 Sneaky's Summoner ID
    }
    @Test
    public void getAsync() throws  ExecutionException, InterruptedException {
        api.leagues.getAllLeaguesForSummonerAsync(Region.NA, 51405).thenAccept(this::checkGet).get();
    }
    private void checkGet(List<LeagueList> result) {
        // C9 Sneaky
        for (LeagueList league : result) {
            if (Queue.RANKED_SOLO_5x5.equals(league.queue)) {
                // Sneaky better be at least Diamond
                assertTrue(league.tier,
                    Tier.DIAMOND.equals(league.tier) ||
                    Tier.MASTER.equals(league.tier) ||
                    Tier.CHALLENGER.equals(league.tier));
                assertTrue(league.entries.size() > 1);
                for (LeaguePosition entry : league.entries) {
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
    public void getEntries() {
        checkGetEntries(api.leagues.getAllLeaguesForSummoner(Region.NA, 51405));
    }
    @Test
    public void getEntriesAsync() throws  ExecutionException, InterruptedException {
        api.leagues.getAllLeaguesForSummonerAsync(Region.NA, 51405).thenAccept(this::checkGetEntries).get();
    }
    private void checkGetEntries(List<LeagueList> result) {
        for (LeagueList league : result) {
            if (Queue.RANKED_SOLO_5x5.equals(league.queue)) {
                // Sneaky better be at least Diamond
                assertTrue(league.tier, Tier.DIAMOND.equals(league.tier) ||
                    Tier.MASTER.equals(league.tier) ||
                    Tier.CHALLENGER.equals(league.tier));

                System.out.println(new Gson().toJson(league));

                for (LeaguePosition entry : league.entries) {
                    if (entry.playerOrTeamId.equals("51405")) {
                        assertTrue("51405".equals(entry.playerOrTeamId));
                        assertTrue(entry.playerOrTeamName, entry.playerOrTeamName.contains("Sneaky"));
                        return;
                    }
                }
                fail("Failed to find sneaky");
                return;
            }
        }
        fail("Failed to find queue " + Queue.RANKED_SOLO_5x5);
    }

    @Test
    public void getTop() {
        checkGetTop(api.leagues.getChallengerLeague(Region.NA, Queue.RANKED_SOLO_5x5),
                api.leagues.getMasterLeague(Region.NA, Queue.RANKED_SOLO_5x5));
    }
    @Test
    public void getTopAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<LeagueList> challenger =
            api.leagues.getChallengerLeagueAsync(Region.NA, Queue.RANKED_SOLO_5x5);
        CompletableFuture<LeagueList> master = api.leagues.getMasterLeagueAsync(Region.NA, Queue.RANKED_SOLO_5x5);
        challenger.thenAcceptBoth(master, this::checkGetTop).get();
    }
    private void checkGetTop(LeagueList challenger, LeagueList master) {
        assertEquals(Tier.CHALLENGER, challenger.tier);
        assertEquals("Dr. Mundo's Scouts", challenger.name); // lol
        assertEquals(200, challenger.entries.size());
        double challengerLp = 0;
        for (LeaguePosition entry : challenger.entries) {
            assertTrue(entry.leaguePoints > 0);
            challengerLp += entry.leaguePoints / 200.0;
        }
        assertEquals(Tier.MASTER, master.tier);
        assertEquals("Renekton's Shadows", master.name);
        double masterLp = 0;
        for (LeaguePosition entry : master.entries) {
            assertNotNull(entry);
            masterLp += entry.leaguePoints / (double) master.entries.size();
        }
        assertTrue("Expected avg master LP to be less than avg challenger LP: " + masterLp + " < " + challengerLp,
            masterLp < challengerLp);
    }
}
