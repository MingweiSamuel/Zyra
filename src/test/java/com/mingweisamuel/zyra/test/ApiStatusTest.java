package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStatus.Shard;
import com.mingweisamuel.zyra.lolStatus.ShardStatus;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.test.Api.api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LolStatusEndpoints}.
 */
public class ApiStatusTest {

    @Test
    public void get() throws ExecutionException {
        checkGet(api.status.get(Region.NA));
    }
    @Test
    public void getAsync() throws ExecutionException, InterruptedException {
        api.status.getAsync(Region.NA).thenAccept(this::checkGet).get();
    }
    private void checkGet(ShardStatus status) {
        assertEquals("na", status.slug);
        assertEquals("North America", status.name);
        assertTrue(status.locales != null);
    }

    @Test
    public void getAll() throws ExecutionException {
        checkGetAll(api.status.getAll());
    }
    @Test
    public void getAllAsync() throws ExecutionException, InterruptedException {
        api.status.getAllAsync().thenAccept(this::checkGetAll).get();
    }
    private void checkGetAll(List<Shard> shards) {
        for (Shard shard : shards) {
            switch(shard.slug) {
            case "na":
                assertEquals("North America", shard.name);
                break;
            case "lan":
                assertEquals("Latin America North", shard.name);
                break;
            case "jp":
                assertEquals("Japan", shard.name);
                break;
            }
        }
    }
}
