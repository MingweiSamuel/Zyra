package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Queue;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.enums.Tier;
import com.mingweisamuel.zyra.leagueV4.LeagueItem;
import com.mingweisamuel.zyra.leagueV4.LeaguePosition;
import com.mingweisamuel.zyra.leagueV4.LeagueList;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LeagueV4Endpoints}.
 */
public class ApiLeagueV4Test extends ApiTest {

    @Test
    public void getLeaguePositions() {
        checkGetLeaguePositions(api.leaguesV4.getAllLeaguePositionsForSummoner(Region.NA, SUMMONER_ID_C9SNEAKY));
    }
    @Test
    public void getLeaguePositionsAsync() throws  ExecutionException, InterruptedException {
        api.leaguesV4.getAllLeaguePositionsForSummonerAsync(Region.NA, SUMMONER_ID_C9SNEAKY)
                .thenAccept(this::checkGetLeaguePositions).get();
    }
    private void checkGetLeaguePositions(List<LeaguePosition> result) {
        for (LeaguePosition league : result) {
            if (Queue.RANKED_SOLO_5x5.equals(league.queueType)) {
                // Sneaky better be at least Diamond
                assertTrue(league.tier, Tier.DIAMOND.equals(league.tier) ||
                    Tier.MASTER.equals(league.tier) ||
                    Tier.CHALLENGER.equals(league.tier));
                return;
            }
        }
        fail("Failed to find queue " + Queue.RANKED_SOLO_5x5);
    }

    @Test
    @Ignore("preseason")
    public void getTop() {
        checkGetTop(api.leaguesV4.getChallengerLeague(Region.NA, Queue.RANKED_SOLO_5x5),
                api.leaguesV4.getMasterLeague(Region.NA, Queue.RANKED_SOLO_5x5));
    }
    @Test
    @Ignore("preseason")
    public void getTopAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<LeagueList> challenger =
            api.leaguesV4.getChallengerLeagueAsync(Region.NA, Queue.RANKED_SOLO_5x5);
        CompletableFuture<LeagueList> master = api.leaguesV4.getMasterLeagueAsync(Region.NA, Queue.RANKED_SOLO_5x5);
        challenger.thenAcceptBoth(master, this::checkGetTop).get();
    }
    private void checkGetTop(LeagueList challenger, LeagueList master) {
        assertEquals(Tier.CHALLENGER, challenger.tier);
        assertEquals("Dr. Mundo's Scouts", challenger.name); // lol
        assertEquals(200, challenger.entries.size());
        double challengerLp = 0;
        for (LeagueItem entry : challenger.entries) {
            assertTrue(entry.leaguePoints > 0);
            challengerLp += entry.leaguePoints / 200.0;
        }
        assertEquals(Tier.MASTER, master.tier);
        assertEquals("Renekton's Shadows", master.name);
        double masterLp = 0;
        for (LeagueItem entry : master.entries) {
            assertNotNull(entry);
            masterLp += entry.leaguePoints / (double) master.entries.size();
        }
        assertTrue("Expected avg master LP to be less than avg challenger LP: " + masterLp + " < " + challengerLp,
            masterLp < challengerLp);
    }
}
