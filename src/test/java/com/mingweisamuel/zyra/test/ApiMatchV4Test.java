package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.enums.TeamId;
import com.mingweisamuel.zyra.matchV4.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.enums.ChampionId.*;
import static org.junit.Assert.*;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.MatchV4Endpoints}.
 */
public class ApiMatchV4Test extends ApiTest {

    @Test
    public void get() {
        checkGet(api.matchesV4.getMatch(Region.NA, 2357244372L));
    }
    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.matchesV4.getMatchAsync(Region.NA, 2357244372L).thenAccept(ApiMatchV4Test::checkGet).get();
    }
    public static void checkGet(Match match) {
        // http://matchhistory.na.leagueoflegends.com/en/#match-details/NA1/2398184332/51405?tab=overview
        assertEquals(2357244372L, match.gameId);
        assertEquals(11, match.mapId);
        assertEquals(1636, match.gameDuration);
        boolean c9sneaky = false;
        for (ParticipantIdentity identity : match.participantIdentities)
            if (SUMMONER_ID_C9SNEAKY.equals(identity.player.summonerId))
                c9sneaky = true;
        assertTrue("C9 Sneaky not found", c9sneaky);
        assertEquals(2, match.teams.size());
        int[] bans = {0, SYNDRA, RENGAR, LEBLANC, IVERN, RYZE, AMUMU};
        for (TeamStats team : match.teams) {
            if (team.teamId == TeamId.BLUE) {
                assertEquals(team.win, "Win", team.win);
                assertTrue("" + team.firstBlood, team.firstBlood);
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
        checkGetTimeline(api.matchesV4.getMatchTimeline(Region.NA, 2357244372L));
    }
    @Test
    public void getTimelineAsync() {
        api.matchesV4.getMatchTimelineAsync(Region.NA, 2357244372L).thenAccept(ApiMatchV4Test::checkGetTimeline).join();
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
            for (Map.Entry<String, MatchParticipantFrame> participantFrameEntry : frame.participantFrames.entrySet()) {
                assertNotNull(participantFrameEntry);
                assertEquals(Long.parseLong(participantFrameEntry.getKey()), participantFrameEntry.getValue().participantId);

                // Check gold increasing.
                Integer prevGold = participantGold.get(Integer.parseInt(participantFrameEntry.getKey()));
                int currGold = participantFrameEntry.getValue().totalGold;
                participantGold.put(Integer.parseInt(participantFrameEntry.getKey()), currGold);

                assertNotEquals(0, currGold);
                if (prevGold != null)
                    assertTrue(currGold + " > " + prevGold, currGold > prevGold);
            }
        }
    }
}
