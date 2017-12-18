package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.spectator.CurrentGameInfo;
import com.mingweisamuel.zyra.spectator.CurrentGameParticipant;
import com.mingweisamuel.zyra.spectator.FeaturedGameInfo;
import com.mingweisamuel.zyra.spectator.FeaturedGames;
import com.mingweisamuel.zyra.spectator.Participant;
import com.mingweisamuel.zyra.summoner.Summoner;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Integration tests testing
 * {@link com.mingweisamuel.zyra.SpectatorEndpoints} (current game & featured game) and
 * {@link com.mingweisamuel.zyra.SummonerEndpoints}.
 */
public class ApiComboFeaturedGamesSummonerCurrentGameTest extends ApiTest {

    @Test
    public void get() {
        FeaturedGames featured = api.spectator.getFeaturedGames(Region.NA);
        checkFeatured(featured);
        outer:
        for (FeaturedGameInfo gameInfo : featured.gameList) {
            Participant participant = gameInfo.participants.get(0);
            Summoner summoner = api.summoners.getBySummonerName(Region.NA, participant.summonerName);
            CurrentGameInfo currentGame = api.spectator.getCurrentGameInfoBySummoner(Region.NA, summoner.id);
            assertNotNull(currentGame);
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
        api.spectator.getFeaturedGamesAsync(Region.NA).thenCompose(featured -> {
            checkFeatured(featured);
            CompletableFuture[] result = featured.gameList.stream().map(gameInfo -> {
                assertNotNull(gameInfo);
                assertNotNull(gameInfo.participants);
                final Participant participant = gameInfo.participants.get(0);
                return api.summoners.getBySummonerNameAsync(Region.NA, participant.summonerName)
                    .thenCompose(summoner -> {
                        assertNotNull(summoner);
                        return api.spectator.getCurrentGameInfoBySummonerAsync(Region.NA, summoner.id);
                    })
                    .thenAccept(currentGame -> {
                        assertNotNull(currentGame);
                        assertEquals(gameInfo.gameId, currentGame.gameId);
                        for (CurrentGameParticipant cParticipant : currentGame.participants) {
                            // check the summoner is in both queries
                            assertNotNull(cParticipant);
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
        assertNotNull(featured);
        assertNotNull(featured.gameList);
        assertEquals(5, featured.gameList.size());
        for (FeaturedGameInfo gameInfo : featured.gameList) {
            assertNotNull(gameInfo);
            assertNotNull(gameInfo.participants);
            assertTrue(gameInfo.participants.size() >= 6);
            for (Participant player : gameInfo.participants) {
                assertNotNull(player);
                assertNotNull(player.summonerName);
                assertTrue(player.summonerName.length() > 0);
                assertFalse(player.bot);
            }
            assertTrue(gameInfo.gameId > 0);
            assertNotNull(gameInfo.observers);
            assertNotNull(gameInfo.observers.encryptionKey);
            assertTrue(gameInfo.observers.encryptionKey.matches("[a-zA-Z0-9/+]{32}"));
        }
    }
}
