package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.championMasteryV4.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.enums.ChampionId.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.ChampionMasteryV4Endpoints}.
 */
public class ApiChampionMasteryV4Test extends ApiTest {

    @Test
    public void getChampion() {
        ChampionMastery result = api.championMasteriesV4.getChampionMastery(Region.NA, SUMMONER_ID_LUGNUTSK, ZYRA);
        assertEquals(7, result.championLevel);
        assertTrue(result.championPoints > 244_000);
    }

    @Test
    public void getChampionAsync() throws ExecutionException, InterruptedException {
        api.championMasteriesV4.getChampionMasteryAsync(Region.NA, SUMMONER_ID_LUGNUTSK, ZYRA)
            .thenAccept(result -> {
                assertEquals(7, result.championLevel);
                assertTrue(result.championPoints > 244_000);
            }).get();
    }

    @Test
    public void getChampions() {
        Set<Integer> topChamps = new HashSet<>(Arrays.asList(ZYRA, SORAKA, MORGANA, SONA, JANNA, EKKO, NAMI, TARIC,
                POPPY, BRAND));
        List<ChampionMastery> champData = api.championMasteriesV4.getAllChampionMasteries(Region.NA, SUMMONER_ID_LUGNUTSK);
        int topChampCount = topChamps.size();
        for (int i = 0; i < topChampCount; i++)
            assertTrue("Unexpected top champ: " + champData.get(i).championId,
                topChamps.remove(champData.get(i).championId));
        assertTrue("Champions not found: " + topChamps.toString(), topChamps.isEmpty());
    }

    @Test
    public void getChampionsAsync() throws ExecutionException, InterruptedException {
        Set<Integer> topChamps = new HashSet<>(Arrays.asList(ZYRA, SORAKA, MORGANA, SONA, JANNA, EKKO, NAMI, TARIC,
                POPPY, BRAND));
        api.championMasteriesV4.getAllChampionMasteriesAsync(Region.NA, SUMMONER_ID_LUGNUTSK).thenAccept(champData -> {
            int topChampCount = topChamps.size();
            for (int i = 0; i < topChampCount; i++)
                assertTrue("Unexpected top champ: " + champData.get(i).championId,
                        topChamps.remove(champData.get(i).championId));
            assertTrue("Champions not found: " + topChamps.toString(), topChamps.isEmpty());
        }).get();
    }

    @Test
    public void getScore() {
        // http://www.lolking.net/summoner/euw/20401158/0#champ-mastery
        int score = api.championMasteriesV4.getChampionMasteryScore(Region.EUW, SUMMONER_ID_MA5STERY);
        assertTrue("" + score, 952 <= score && score < 1000);
    }

    @Test
    public void getScoreAsync() throws ExecutionException, InterruptedException {
        api.championMasteriesV4.getChampionMasteryScoreAsync(Region.EUW, SUMMONER_ID_MA5STERY)
                .thenAccept(score -> assertTrue("" + score, 952 <= score && score < 1000)).get();
    }
}
