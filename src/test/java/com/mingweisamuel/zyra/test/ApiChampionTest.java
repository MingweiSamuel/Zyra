package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.champion.Champion;
import com.mingweisamuel.zyra.champion.ChampionList;
import com.mingweisamuel.zyra.enums.Region;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.enums.ChampionId.ZYRA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.ChampionEndpoints}.
 */
public class ApiChampionTest extends ApiTest {

    @Test
    public void getAll() {
        checkGetAll(api.champions.getChampions(Region.NA));
    }
    @Test
    public void getAllAsync() throws ExecutionException, InterruptedException {
        api.champions.getChampionsAsync(Region.NA).thenAccept(this::checkGetAll).get();
    }
    private void checkGetAll(ChampionList result) {
        int free = 0;
        for (Champion champ : result.champions) {
            if (champ.id == ZYRA)
                checkGet(champ);
            if (champ.freeToPlay)
                free++;
        }
        // We're up to 14 free champions (2017/08).
        assertTrue("" + free, 10 <= free && free <= 20);
    }

    @Test
    public void get() {
        checkGet(api.champions.getChampionsById(Region.NA, ZYRA));
    }
    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.champions.getChampionsByIdAsync(Region.NA, ZYRA).thenAccept(this::checkGet).get();
    }
    private void checkGet(Champion result) {
        assertEquals(143, result.id);
        assertTrue(result.botEnabled);
    }
}
