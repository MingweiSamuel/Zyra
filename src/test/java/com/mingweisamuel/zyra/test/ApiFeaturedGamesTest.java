package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.dto.FeaturedGameInfo;
import com.mingweisamuel.zyra.dto.FeaturedGames;
import com.mingweisamuel.zyra.dto.Participant;
import com.mingweisamuel.zyra.enums.Region;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.test.Api.api;
import static org.junit.Assert.*;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.FeaturedGamesEndpoints}.
 */
public class ApiFeaturedGamesTest {

    @Test
    public void get() throws ExecutionException {
        checkGet(api.featuredGames.get(Region.NA));
    }

    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.featuredGames.getAsync(Region.NA).thenAccept(this::checkGet).get();
    }

    private void checkGet(FeaturedGames featured) {
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
