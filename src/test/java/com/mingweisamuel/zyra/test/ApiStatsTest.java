package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.ChampionId;
import com.mingweisamuel.zyra.enums.Queue;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.enums.Season;
import com.mingweisamuel.zyra.stats.ChampionStats;
import com.mingweisamuel.zyra.stats.PlayerStatsSummary;
import com.mingweisamuel.zyra.stats.PlayerStatsSummaryList;
import com.mingweisamuel.zyra.stats.RankedStats;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.test.Api.api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.StatsEndpoints}.
 */
public class ApiStatsTest {

    @Test
    public void getRanked() throws ExecutionException {
        checkGetRanked(api.stats.getRanked(Region.NA, 51405, Season.SEASON2016));
    }
    @Test
    public void getRankedAsync() throws ExecutionException, InterruptedException {
        api.stats.getRankedAsync(Region.NA, 51405, Season.SEASON2016).thenAccept(this::checkGetRanked).get();
    }
    private void checkGetRanked(RankedStats result) {
        assertEquals(51405, result.summonerId);
        for  (ChampionStats champ : result.champions) {
            switch (champ.id) {
            case ChampionId.ALL:
                assertEquals(7828, champ.stats.totalChampionKills);
                assertEquals(5834, champ.stats.totalDeathsPerSession);
                assertEquals(618, champ.stats.totalSessionsWon);
                assertEquals(535, champ.stats.totalSessionsLost);
                break;
            case ChampionId.DRAVEN:
                assertEquals(125, champ.stats.totalChampionKills);
                assertEquals(94, champ.stats.totalDeathsPerSession);
                assertEquals(10, champ.stats.totalSessionsWon);
                assertEquals(7, champ.stats.totalSessionsLost);
                break;
            }
        }
    }

    @Test
    public void getSummary() throws ExecutionException {
        checkGetSummary(api.stats.getSummary(Region.NA, 51405, Season.SEASON2016));
    }
    @Test
    public void getSummaryAsync() throws ExecutionException, InterruptedException {
        api.stats.getSummaryAsync(Region.NA, 51405, Season.SEASON2016).thenAccept(this::checkGetSummary).get();
    }
    private void checkGetSummary(PlayerStatsSummaryList result) {
        assertEquals(51405, result.summonerId);
        for (PlayerStatsSummary summary : result.playerStatSummaries) {
            if (Queue.SummaryType.RankedSolo5x5.equals(summary.playerStatSummaryType)) {
                assertEquals(606, summary.wins);
                assertEquals(527, summary.losses);
                assertEquals(7670, summary.aggregatedStats.totalChampionKills);
                return;
            }
        }
        fail("Failed to find " + Queue.SummaryType.RankedSolo5x5);
    }
}
