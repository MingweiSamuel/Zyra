package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.entity.MatchEntity;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.MatchParticipantFrame;
import com.mingweisamuel.zyra.match.ParticipantTimeline;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests for {@link MatchEntity}.
 */
public class EntityComboMatchSummonerTest extends EntityTest {

    @Test
    public void test() {
        MatchEntity match = eApi.getMatch(Region.NA, 2398184332L);

        ApiMatchTest.checkGet(match.getInfo());

        assertNotNull(match.getParticipants());
        boolean sneakyFound = false;
        boolean otherFound = false;
        for (MatchEntity.ParticipantEntity participant : match.getParticipants()) {
            assertNotNull(participant.getSummonerEntity());
            if (51405 == participant.getSummonerEntity().getSummonerId()) {
                sneakyFound = true;
                assertFalse("Expected loser", participant.isWinner());
                EntitySummonerTest.validate(participant.getSummonerEntity());
                assertNotNull(participant.getTimeline());
                assertEquals(27, participant.getTimeline().size());

                long timestamp = 0;
                int xp = 0;
                int level = 1;

                for (Map.Entry<Long, MatchParticipantFrame> entry : participant.getTimeline().entrySet()) {

                    assertTrue("Expected frame's timestamp >= prev timestamp: " + entry.getKey() + " > " + timestamp,
                        entry.getKey() >= timestamp);
                    timestamp = entry.getKey();

                    MatchParticipantFrame frame = entry.getValue();
                    assertEquals(participant.getParticipantId(), frame.participantId);
                    assertNotNull(frame);
                    assertNotNull(frame.position);

                    assertTrue("Expected frame.xp >= xp: " + frame.xp + " >= " + xp, frame.xp >= xp);
                    xp = frame.xp;

                    assertTrue("Expected frame.level >= level: " + frame.level + " >= " + level, frame.level >= level);
                    level = frame.level;
                }
            }
            else if (21390175 == participant.getSummonerEntity().getSummonerId()) {
                otherFound = true;
                assertTrue("Expected winner", participant.isWinner());
            }
        }
        assertTrue("C9 Sneaky not found", sneakyFound);
        assertTrue("Other random guy not found", otherFound);
    }
}
