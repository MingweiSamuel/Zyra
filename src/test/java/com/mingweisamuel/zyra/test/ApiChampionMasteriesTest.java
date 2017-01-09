package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.dto.ChampionMastery;
import com.mingweisamuel.zyra.enums.ChampionId;
import com.mingweisamuel.zyra.enums.Region;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.RiotApi}.
 */
public class ApiChampionMasteriesTest {

    private static final RiotApi riotApi = RiotApi.build(System.getenv("API_KEY")).build();

    @Test
    public void getSummonerChampionMastery() throws ExecutionException {
        ChampionMastery result = riotApi.championMasteries.getChampion(Region.NA, 69009277L, ChampionId.ZYRA);
        assertEquals(7, result.championLevel);
        assertTrue(result.championPoints > 244_000);
    }

    @Test
    public void getSummonerChampionMasteryAsync() throws ExecutionException, InterruptedException {
        riotApi.championMasteries.getChampionAsync(Region.NA, 69009277L, ChampionId.ZYRA)
                .thenAccept(result -> {
                    assertEquals(7, result.championLevel);
                    assertTrue(result.championPoints > 244_000);
                }).get();
    }
}
