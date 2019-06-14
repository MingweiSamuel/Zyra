package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStatusV3.ShardStatus;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LolStatusV3Endpoints}.
 */
public class ApiStatusV3Test extends ApiTest {

    @Test
    public void get() {
        checkGet(api.statusV3.getShardData(Region.NA));
    }
    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.statusV3.getShardDataAsync(Region.NA).thenAccept(this::checkGet).get();
    }
    private void checkGet(ShardStatus status) {
        assertEquals("na", status.slug);
        assertEquals("North America", status.name);
        assertNotNull(status.locales);
    }
}
