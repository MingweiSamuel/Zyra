package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.summoner.Summoner;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.SummonerEndpoints}.
 */
public class ApiSummonerTest extends ApiTest {

    @Test
    public void getBySummonerId() {
        checkSummoner(api.summoners.getBySummonerId(Region.NA, 51405));
    }
    @Test
    public void getBySummonerIdAsync() throws ExecutionException, InterruptedException {
        api.summoners.getBySummonerIdAsync(Region.NA, 51405).thenAccept(this::checkSummoner).get();
    }
    @Test
    public void getBySummonerName() {
        checkSummoner(api.summoners.getBySummonerName(Region.NA, "c 9 SnEAKY"));
    }
    @Test
    public void getBySummonerNameAsync() throws ExecutionException, InterruptedException {
        api.summoners.getBySummonerNameAsync(Region.NA, "c 9 SnEAKY").thenAccept(this::checkSummoner).get();
    }
    @Test
    public void getByAccountId() {
        checkSummoner(api.summoners.getByAccountId(Region.NA, 78247));
    }
    @Test
    public void getByAccountIdAsync() throws ExecutionException, InterruptedException {
        api.summoners.getByAccountIdAsync(Region.NA, 78247).thenAccept(this::checkSummoner).get();
    }
    private void checkSummoner(Summoner summoner) {
        assertEquals("c9sneaky", RiotApi.standardizeName(summoner.name));
        assertEquals(51405, summoner.id);
        assertEquals(78247, summoner.accountId);
        assertTrue(summoner.summonerLevel >= 45);
        assertTrue(summoner.profileIconId + " must be positive.", summoner.profileIconId > 0);
        assertTrue(summoner.revisionDate + " invalid.", summoner.revisionDate >= 1495004089000L);
    }
}
