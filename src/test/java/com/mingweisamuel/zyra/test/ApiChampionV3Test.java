package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.championV3.ChampionInfo;
import com.mingweisamuel.zyra.enums.Region;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.ChampionV3Endpoints}.
 */
public class ApiChampionV3Test extends ApiTest {

    @Test
    public void getAll() {
        checkGetAll(api.championsV3.getChampionInfo(Region.NA));
    }
    @Test
    public void getAllAsync() throws ExecutionException, InterruptedException {
        api.championsV3.getChampionInfoAsync(Region.NA).thenAccept(this::checkGetAll).get();
    }
    private void checkGetAll(ChampionInfo result) {
        int free = result.freeChampionIds.size();
        // We're up to 14 free champions (2017/08).
        assertTrue("" + free, 10 <= free && free <= 20);
    }
}
