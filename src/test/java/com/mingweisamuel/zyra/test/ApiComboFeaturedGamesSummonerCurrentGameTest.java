package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.currentGame.CurrentGameInfo;
import com.mingweisamuel.zyra.currentGame.CurrentGameParticipant;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.featuredGames.FeaturedGameInfo;
import com.mingweisamuel.zyra.featuredGames.FeaturedGames;
import com.mingweisamuel.zyra.featuredGames.Participant;
import com.mingweisamuel.zyra.summoner.Summoner;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Integration tests testing
 * {@link com.mingweisamuel.zyra.FeaturedGamesEndpoints},
 * {@link com.mingweisamuel.zyra.SummonerEndpoints}, and
 * {@link com.mingweisamuel.zyra.CurrentGameEndpoints}.
 */
public class ApiComboFeaturedGamesSummonerCurrentGameTest extends ApiTest {

    @Test
    public void get() throws ExecutionException {
        FeaturedGames featured = api.featuredGames.get(Region.NA);
        checkFeatured(featured);
        outer:
        for (FeaturedGameInfo gameInfo : featured.gameList) {
            Participant participant = gameInfo.participants.get(0);
            Map<String, Summoner> summonerInfos =
                    api.summoners.getByName(Region.NA, Collections.singleton(participant.summonerName));
            CurrentGameInfo currentGame =
                    api.currentGame.get(Region.NA, summonerInfos.values().iterator().next().id);
            assertEquals(gameInfo.gameId, currentGame.gameId);
            for (CurrentGameParticipant cParticipant : currentGame.participants) {
                // check the summoner is in both queries
                if (participant.summonerName.equals(cParticipant.summonerName))
                    continue outer;
            }
            fail("Failed to find matching summoner.");
        }
    }
    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.featuredGames.getAsync(Region.NA).thenCompose(featured -> {
            checkFeatured(featured);
            CompletableFuture[] result = featured.gameList.stream().map(gameInfo -> {
                final Participant participant = gameInfo.participants.get(0);
                return api.summoners.getByNameAsync(Region.NA, Collections.singleton(participant.summonerName))
                        .thenCompose(summonerInfos ->
                                api.currentGame.getAsync(Region.NA, summonerInfos.values().iterator().next().id))
                        .thenAccept(currentGame -> {
                            assertEquals(gameInfo.gameId, currentGame.gameId);
                            for (CurrentGameParticipant cParticipant : currentGame.participants) {
                                // check the summoner is in both queries
                                if (participant.summonerName.equals(cParticipant.summonerName))
                                    return;
                            }
                            fail("Failed to find matching summoner.");
                        });
            }).toArray(CompletableFuture[]::new);
            return CompletableFuture.allOf(result);
        }).get();
    }
    private void checkFeatured(FeaturedGames featured) {
        assertEquals(5, featured.gameList.size());
        for (FeaturedGameInfo gameInfo : featured.gameList) {
            assertTrue(gameInfo.participants.size() >= 6);
            for (Participant player : gameInfo.participants) {
                assertTrue(player.summonerName.length() > 0);
                assertFalse(player.bot);
            }
            assertTrue(gameInfo.gameId > 0);
            assertTrue(gameInfo.observers.encryptionKey.matches("[a-zA-Z0-9/+]{32}"));
        }
    }
}
