package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.championMastery.ChampionMastery;
import com.mingweisamuel.zyra.entity.SummonerEntity;
import com.mingweisamuel.zyra.enums.Queue;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.enums.Tier;
import com.mingweisamuel.zyra.league.LeaguePosition;
import com.mingweisamuel.zyra.spectator.CurrentGameInfo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link com.mingweisamuel.zyra.entity.SummonerEntity}.
 */
public class EntitySummonerTest extends EntityTest {

    @Test
    public void testById() {
        SummonerEntity summoner = eApi.getSummoner(Region.NA, 51405);
        validate(summoner);
    }
    @Test
    public void testByIdAndAccountId() {
        SummonerEntity summoner = eApi.getSummoner(Region.NA, 51405, 78247);
        validate(summoner);
    }
    @Test
    public void testByAccountId() {
        SummonerEntity summoner = eApi.getSummonerByAccountId(Region.NA, 78247);
        validate(summoner);
    }
    @Test
    public void testByName() {
        SummonerEntity summoner = eApi.getSummonerByName(Region.NA, "c 9s NE  aky");
        validate(summoner);
    }
    public static void validate(SummonerEntity summoner) {
        // basic
        assertEquals("c9sneaky", summoner.getStandardizedName());
        assertEquals(51405, summoner.getSummonerId());
        assertEquals(78247, summoner.getAccountId());

        // summonerInfo
        assertTrue(summoner.getSummonerInfo().summonerLevel >= 45);
        assertTrue(summoner.getSummonerInfo().profileIconId + " must be positive.",
            summoner.getSummonerInfo().profileIconId > 0);
        assertTrue(summoner.getSummonerInfo().revisionDate + " invalid.",
            summoner.getSummonerInfo().revisionDate >= 1495004089000L);

        // championMasteries
        List<ChampionMastery> masteries = summoner.getChampionMasteries();
        for (ChampionMastery mastery : masteries) {
            assertEquals(51405, mastery.playerId);
            assertTrue(mastery.championId + "", mastery.championId > 0);
            assertTrue(mastery.championLevel + "", mastery.championLevel >= 1);
            assertTrue(mastery.championPoints+ "", mastery.championPoints > 0);
        }

        // currentGameInfo
        CurrentGameInfo cgi = summoner.getCurrentGameInfo(); // just check no errors

        // leaguePositions
        boolean found = false;
        List<LeaguePosition> leagues = summoner.getLeaguePositions();
        for (LeaguePosition league : leagues) {
            if (Queue.RANKED_SOLO_5x5.equals(league.queueType)) {
                // Sneaky better be at least Diamond
                assertTrue(league.tier,
                    Tier.DIAMOND.equals(league.tier) ||
                        Tier.MASTER.equals(league.tier) ||
                        Tier.CHALLENGER.equals(league.tier));
                found = true;
                break;
            }
        }
        assertTrue("Failed to find queue.", found);
    }
}
