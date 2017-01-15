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
    public void getAll() throws ExecutionException {
        checkGetAll(api.champions.getAll(Region.NA));
    }
    @Test
    public void getAllAsync() throws ExecutionException, InterruptedException {
        api.champions.getAllAsync(Region.NA).thenAccept(this::checkGetAll).get();
    }
    private void checkGetAll(ChampionList result) {
        int free = 0;
        for (Champion champ : result.champions) {
            if (champ.id == ZYRA)
                checkGet(champ);
            if (champ.freeToPlay)
                free++;
        }
        assertEquals(10, free);
    }

    @Test
    public void get() throws ExecutionException {
        checkGet(api.champions.get(Region.NA, ZYRA));
    }
    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.champions.getAsync(Region.NA, ZYRA).thenAccept(this::checkGet).get();
    }
    private void checkGet(Champion result) {
        assertEquals(143, result.id);
        assertTrue(result.botEnabled);
    }
}
