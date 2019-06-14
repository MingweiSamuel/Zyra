package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.summonerV4.Summoner;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.SummonerV4Endpoints}.
 */
public class ApisummonersV4Test extends ApiTest {

    @Test
    public void getBySummonerId() {
        checkSummoner(api.summonersV4.getBySummonerId(Region.NA, SUMMONER_ID_C9SNEAKY));
    }
    @Test
    public void getBySummonerIdAsync() throws ExecutionException, InterruptedException {
        api.summonersV4.getBySummonerIdAsync(Region.NA, SUMMONER_ID_C9SNEAKY).thenAccept(this::checkSummoner).get();
    }
    @Test
    public void getBySummonerName() {
        checkSummoner(api.summonersV4.getBySummonerName(Region.NA, "c 9 SnEAKY"));
    }
    @Test
    public void getBySummonerNameAsync() throws ExecutionException, InterruptedException {
        api.summonersV4.getBySummonerNameAsync(Region.NA, "c 9 SnEAKY").thenAccept(this::checkSummoner).get();
    }
    @Test
    public void getByAccountId() {
        checkSummoner(api.summonersV4.getByAccountId(Region.NA, ACCOUNT_ID_C9SNEAKY));
    }
    @Test
    public void getByAccountIdAsync() throws ExecutionException, InterruptedException {
        api.summonersV4.getByAccountIdAsync(Region.NA, ACCOUNT_ID_C9SNEAKY).thenAccept(this::checkSummoner).get();
    }
    private void checkSummoner(Summoner summoner) {
        assertEquals("c9sneaky", RiotApi.standardizeName(summoner.name));
        assertEquals(SUMMONER_ID_C9SNEAKY, summoner.id);
        assertEquals(ACCOUNT_ID_C9SNEAKY, summoner.accountId);
        assertTrue(summoner.summonerLevel >= 45);
        assertTrue(summoner.profileIconId + " must be positive.", summoner.profileIconId > 0);
        assertTrue(summoner.revisionDate + " invalid.", summoner.revisionDate >= 1495004089000L);
    }
}
