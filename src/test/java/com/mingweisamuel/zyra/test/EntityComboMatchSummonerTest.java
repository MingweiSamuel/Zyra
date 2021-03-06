package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.entity.MatchEntity;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.matchV4.MatchParticipantFrame;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Tests for {@link MatchEntity}.
 */
public class EntityComboMatchSummonerTest extends EntityTest {

    @Test
    @Ignore // TODO
    public void getCombo() {
        MatchEntity match = eApi.getMatch(Region.NA, 2357244372L);

        ApiMatchV4Test.checkGet(match.getInfo());
        assertNotNull(match.getParticipants());
        boolean sneakyFound = false;
//        boolean otherFound = false;
        for (MatchEntity.ParticipantEntity participant : match.getParticipants()) {
            assertNotNull(participant);
            assertNotNull(participant.getSummonerEntity());
            if (SUMMONER_ID_C9SNEAKY.equals(participant.getSummonerEntity().getSummonerIdEnc())) {
                sneakyFound = true;
                assertFalse("Expected loser", participant.getTeam().isWinner());
                EntitySummonerTest.validate(participant.getSummonerEntity());
                assertNotNull(participant.getTimeline());
                assertEquals(29, participant.getTimeline().size());

                long timestamp = 0;
                int xp = 0;
                int level = 1;

                for (Map.Entry<Long, MatchParticipantFrame> entry : participant.getTimeline().entrySet()) {

                    assertTrue("Expected frame's timestamp >= prev timestamp: " + entry.getKey() + " >= " + timestamp,
                        entry.getKey() >= timestamp);
                    timestamp = entry.getKey();

                    MatchParticipantFrame frame = entry.getValue();
                    assertNotNull(frame);
                    //assertNotNull(frame.position);
                    assertEquals(participant.getParticipantId(), frame.participantId);

                    assertTrue("Expected frame.xp >= xp: " + frame.xp + " >= " + xp, frame.xp >= xp);
                    xp = frame.xp;

                    assertTrue("Expected frame.level >= level: " + frame.level + " >= " + level, frame.level >= level);
                    level = frame.level;
                }
            }
//            else if (446965 == participant.getSummonerEntity().getSummonerIdEnc()) {
//                otherFound = true;
//                assertFalse("Expected loser", participant.getTeam().isWinner());
//            }
        }
        assertTrue("C9 Sneaky not found", sneakyFound);
        //assertTrue("Other random guy not found", otherFound);
    }

//    @Test
//    public void testComboMatchInstanceCaching() {
//        SummonerEntity summoner = eApi.getSummoner(Region.NA, SUMMONER_ID_C9SNEAKY);
//
//        CompletableFuture<MatchEntity> f1 = summoner.getRecentMatchlistAsync().thenApply(ml -> {
//            assertNotNull(ml.matches);
//            assertTrue(ml.matches.size() + "", ml.matches.size() > 0);
//            return eApi.getMatch(Region.NA, ml.matches.get(0).gameId);
//        });
//        List<MatchEntity> matchEntities = summoner.getRecentMatchEntities();
//        assertNotSame("Adding forAccountId should reset cache.", matchEntities.get(0), f1);
//
//        CompletableFuture<MatchEntity> f2 = summoner.getRecentMatchlistAsync().thenApply(ml -> {
//            assertNotNull(ml.matches);
//            assertTrue(ml.matches.size() + "", ml.matches.size() > 0);
//            return eApi.getMatch(Region.NA, ml.matches.get(0).gameId);
//        });
//        assertSame("Removing forAccountId should not reset cache.", matchEntities.get(0), f2.join());
//    }
}
