package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.entity.SummonerEntity;
import com.mingweisamuel.zyra.enums.ChampionId;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.match.Matchlist;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link SummonerEntity#getMatchQueryEntities()} and related query param methods.
 */
public class EntitySummonerMatchQueryTest extends EntityTest {

    @Test
    public void getQuery1() {
        SummonerEntity sneaky = eApi.getSummoner(Region.NA, 51405);

        // set query params. query is always dirty before any requests.
        assertTrue(sneaky.isMatchQueryDirty());
        assertTrue(sneaky.setMatchQueryChampions(Collections.singletonList(ChampionId.KALISTA)));
        assertTrue(sneaky.setMatchQueryTimeRange(123L, 456L));
        assertTrue(sneaky.setMatchQueryTimeRange(
            ApiMatchListTest.queryTime - ApiMatchListTest.MILLIS_PER_WEEK, ApiMatchListTest.queryTime));
        assertTrue(sneaky.setMatchQueryQueues(Collections.singletonList(420)));
        assertTrue(sneaky.setMatchQuerySeasons(Collections.singletonList(9)));
        assertTrue(sneaky.isMatchQueryDirty());

        // future -> not dirty, but not yet completed
        CompletableFuture<Matchlist> matchlistFuture = sneaky.getMatchQueryAsync();
        assertFalse(sneaky.isMatchQueryDirty());
        assertFalse(sneaky.loadedMatchQuery());

        // wait for completion
        Matchlist matchlist = sneaky.getMatchQuery();
        // check
        ApiMatchListTest.checkGetQuery(matchlist);
        assertFalse(sneaky.isMatchQueryDirty());
        assertTrue(sneaky.loadedMatchQuery());

        // same params no dirty
        assertFalse(sneaky.setMatchQueryTimeRange(
            ApiMatchListTest.queryTime - ApiMatchListTest.MILLIS_PER_WEEK, ApiMatchListTest.queryTime));
        assertFalse(sneaky.isMatchQueryDirty());

        // test match
        EntityMatchTest.testBasicValidate2(sneaky.getMatchQueryEntities().get(0));

        // change params -> dirt
        assertTrue(sneaky.setMatchQueryChampions(Collections.singletonList(ChampionId.ZYRA)));
        assertTrue(sneaky.isMatchQueryDirty());
    }
}
