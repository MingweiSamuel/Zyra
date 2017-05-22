package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStatus.ShardStatus;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LolStatusEndpoints}.
 */
public class ApiStatusTest extends ApiTest {

    @Test
    public void get() {
        checkGet(api.status.getShardData(Region.NA));
    }
    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.status.getShardDataAsync(Region.NA).thenAccept(this::checkGet).get();
    }
    private void checkGet(ShardStatus status) {
        assertEquals("na", status.slug);
        assertEquals("North America", status.name);
        assertTrue(status.locales != null);
    }
}
