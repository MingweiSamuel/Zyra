package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.runes.RunePage;
import com.mingweisamuel.zyra.runes.RunePages;
import com.mingweisamuel.zyra.staticData.ProfileIcon;
import com.mingweisamuel.zyra.staticData.ProfileIconData;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.RunesEndpoints}.
 */
public class ApiRunesTest extends ApiTest {

    @Test
    public void getRunes() {
        checkGetRunes(api.runes.getRunePagesBySummonerId(Region.NA, 51405));
    }
    @Test
    public void getProfileIconsAsync() throws ExecutionException, InterruptedException {
        api.runes.getRunePagesBySummonerIdAsync(Region.NA, 51405).thenAccept(ApiRunesTest::checkGetRunes).get();
    }
    public static void checkGetRunes(RunePages result) {
        Set<Long> expected = new HashSet<>(Arrays.asList(
            2706294L, 2706295L, 5526340L, 28433182L, 28433184L, 28433185L, 28433186L, 28433187L, 28433188L,
            41178176L, 55520448L, 55520449L, 55520450L, 55520451L, 55520452L, 55520453L, 55520454L, 55520455L,
            55520456L, 55520457L));
        assertEquals(51405, result.summonerId);
        assertNotNull(result.pages);
        int currentPages = 0;
        for (RunePage page : result.pages) {
            assertNotNull("page name is null: " + page.id, page.name);
            assertFalse("page name is empty: " + page.id, page.name.isEmpty());
            //assertNotNull("page slots null: " + page.id, page.slots); // page slots can be null if empty page
            assertTrue("page not expected: " + page.id, expected.remove(page.id));
            if (page.current)
                currentPages++;
        }
        assertEquals("Too many current pages: " + currentPages, 1, currentPages);
        assertTrue("Not found: " + expected.toString(), expected.isEmpty());
    }
}
