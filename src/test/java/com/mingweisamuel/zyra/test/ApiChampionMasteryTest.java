package com.mingweisamuel.zyra.test;

import com.google.common.base.Joiner;
import com.mingweisamuel.zyra.championMastery.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import static com.mingweisamuel.zyra.enums.ChampionId.ASHE;
import static com.mingweisamuel.zyra.enums.ChampionId.EKKO;
import static com.mingweisamuel.zyra.enums.ChampionId.JANNA;
import static com.mingweisamuel.zyra.enums.ChampionId.MORGANA;
import static com.mingweisamuel.zyra.enums.ChampionId.NAMI;
import static com.mingweisamuel.zyra.enums.ChampionId.POPPY;
import static com.mingweisamuel.zyra.enums.ChampionId.SONA;
import static com.mingweisamuel.zyra.enums.ChampionId.SORAKA;
import static com.mingweisamuel.zyra.enums.ChampionId.TARIC;
import static com.mingweisamuel.zyra.enums.ChampionId.ZYRA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.ChampionMasteryEndpoints}.
 */
public class ApiChampionMasteryTest extends ApiTest {

    @Test
    public void getChampion() throws ExecutionException {
        ChampionMastery result = api.championMasteries.getChampionMastery(Region.NA, 69009277L, ZYRA);
        assertEquals(7, result.championLevel);
        assertTrue(result.championPoints > 244_000);
    }

    @Test
    public void getChampionAsync() throws ExecutionException, InterruptedException {
        api.championMasteries.getChampionMasteryAsync(Region.NA, 69009277L, ZYRA)
                .thenAccept(result -> {
                    assertEquals(7, result.championLevel);
                    assertTrue(result.championPoints > 244_000);
                }).get();
    }

    @Test
    public void getChampions() throws ExecutionException {
        Set<Integer> topChamps = new HashSet<>(Arrays.asList(ZYRA, SORAKA, MORGANA, SONA, JANNA, EKKO, NAMI, TARIC,
                POPPY, ASHE));
        List<ChampionMastery> champData = api.championMasteries.getAllChampionMasteries(Region.NA, 69009277);
        int topChampCount = topChamps.size();
        for (int i = 0; i < topChampCount; i++)
            assertTrue("Unexpected top champ: " + champData.get(i).championId,
                topChamps.remove(champData.get(i).championId));
        assertTrue("Champions not found: " + topChamps.toString(), topChamps.isEmpty());
    }

    @Test
    public void getChampionsAsync() throws ExecutionException, InterruptedException {
        Set<Integer> topChamps = new HashSet<>(Arrays.asList(ZYRA, SORAKA, MORGANA, SONA, JANNA, EKKO, NAMI, TARIC,
                POPPY, ASHE));
        api.championMasteries.getAllChampionMasteriesAsync(Region.NA, 69009277).thenAccept(champData -> {
            int topChampCount = topChamps.size();
            for (int i = 0; i < topChampCount; i++)
                assertTrue("Unexpected top champ: " + champData.get(i).championId,
                        topChamps.remove(champData.get(i).championId));
            assertTrue("Champions not found: " + topChamps.toString(), topChamps.isEmpty());
        }).get();
    }

    @Test
    public void getScore() throws ExecutionException {
        // http://www.lolking.net/summoner/euw/20401158/0#champ-mastery
        int score = api.championMasteries.getChampionMasteryScore(Region.EUW, 20401158);
        assertTrue("" + score, 806 <= score && score < 900);
    }

    @Test
    public void getScoreAsync() throws ExecutionException, InterruptedException {
        api.championMasteries.getChampionMasteryScoreAsync(Region.EUW, 20401158)
                .thenAccept(score -> assertTrue("" + score, 806 <= score && score < 900)).get();
    }
}
