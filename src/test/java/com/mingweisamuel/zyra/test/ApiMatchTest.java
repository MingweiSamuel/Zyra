package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.enums.TeamId;
import com.mingweisamuel.zyra.match.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.enums.ChampionId.*;
import static org.junit.Assert.*;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.MatchEndpoints}.
 */
public class ApiMatchTest extends ApiTest {

    @Test
    public void get() {
        checkGet(api.matches.getMatch(Region.NA, 2357244372L));
    }
    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.matches.getMatchAsync(Region.NA, 2357244372L).thenAccept(ApiMatchTest::checkGet).get();
    }
    public static void checkGet(Match match) {
        // http://matchhistory.na.leagueoflegends.com/en/#match-details/NA1/2398184332/51405?tab=overview
        assertEquals(2357244372L, match.gameId);
        assertEquals(11, match.mapId);
        assertEquals(1636, match.gameDuration);
        boolean c9sneaky = false;
        for (ParticipantIdentity identity : match.participantIdentities)
            if (identity.player.summonerId == 51405)
                c9sneaky = true;
        assertTrue("C9 Sneaky not found", c9sneaky);
        assertEquals(2, match.teams.size());
        int[] bans = {0, SYNDRA, RENGAR, LEBLANC, IVERN, RYZE, AMUMU};
        for (TeamStats team : match.teams) {
            if (team.teamId == TeamId.BLUE) {
                assertEquals(team.win, "Win", team.win);
                assertTrue("" + team.firstBaron, team.firstBlood);
            }
            else {
                assertEquals(team.win, "Fail", team.win);
                assertFalse("" + team.firstBlood, team.firstBlood);
            }
            assertEquals(3, team.bans.size());
            for (TeamBans ban : team.bans)
                assertEquals(bans[ban.pickTurn], ban.championId);
        }
    }

    @Test
    public void getTimeline() {
        checkGetTimeline(api.matches.getMatchTimeline(Region.NA, 2357244372L));
    }
    @Test
    public void getTimelineAsync() {
        api.matches.getMatchTimelineAsync(Region.NA, 2357244372L).thenAccept(ApiMatchTest::checkGetTimeline).join();
    }
    public static void checkGetTimeline(MatchTimeline timeline) {
        assertEquals(60_000, timeline.frameInterval);
        assertNotNull(timeline.frames);
        assertEquals(29, timeline.frames.size());
        long time = 0;
        for (MatchFrame frame : timeline.frames) {
            // frames don't exactly match, they are a bit delayed.
            assertTrue("actual " + frame.timestamp + " < expected " + time, frame.timestamp >= time);
            // but not delayed by more than a second.
            assertTrue("actual " + frame.timestamp + " > expected " + (time + 1000), frame.timestamp <= time + 1000);
            time = frame.timestamp + 60_000;

            Map<Integer, Integer> participantGold = new HashMap<>();
            for (Map.Entry<Integer, MatchParticipantFrame> participantFrameEntry : frame.participantFrames.entrySet()) {
                assertNotNull(participantFrameEntry);
                assertEquals((long) participantFrameEntry.getKey(), participantFrameEntry.getValue().participantId);

                // Check gold increasing.
                Integer prevGold = participantGold.get(participantFrameEntry.getKey());
                int currGold = participantFrameEntry.getValue().totalGold;
                participantGold.put(participantFrameEntry.getKey(), currGold);

                assertNotEquals(0, currGold);
                if (prevGold != null)
                    assertTrue(currGold + " > " + prevGold, currGold > prevGold);
            }
        }
    }
}
