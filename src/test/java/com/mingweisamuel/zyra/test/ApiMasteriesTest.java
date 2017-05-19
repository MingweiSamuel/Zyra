package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.masteries.MasteryPage;
import com.mingweisamuel.zyra.masteries.MasteryPages;
import com.mingweisamuel.zyra.runes.RunePage;
import com.mingweisamuel.zyra.runes.RunePages;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.MasteriesEndpoints}.
 */
public class ApiMasteriesTest extends ApiTest {

    @Test
    public void getMasteries() throws ExecutionException {
        checkGetMasteries(api.masteries.getMasteryPagesBySummonerId(Region.NA, 51405));
    }
    @Test
    public void getMasteriesAsync() throws ExecutionException, InterruptedException {
        api.masteries.getMasteryPagesBySummonerIdAsync(Region.NA, 51405)
            .thenAccept(ApiMasteriesTest::checkGetMasteries).get();
    }
    public static void checkGetMasteries(MasteryPages result) {
        assertEquals(51405, result.summonerId);
        assertNotNull(result.pages);
        assertTrue("Invalid num pages: " + result.pages.size(), 2 <= result.pages.size() && result.pages.size() <= 20);
        int currentPages = 0;
        long expectedId = 34621190;
        for (MasteryPage page : result.pages) {
            assertNotNull(page.name);
            assertFalse(page.name.isEmpty());
            assertEquals(expectedId++, page.id);
            if (page.current)
                currentPages++;
        }
        assertEquals("Too many current pages: " + currentPages, 1, currentPages);
    }
}
