package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStaticData.ProfileIconData;
import com.mingweisamuel.zyra.lolStaticData.ProfileIconDetails;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LolStaticDataEndpoints#getProfileIcons}.
 */
@Ignore("Disabled Static Data Tests.")
public class ApiStaticDataProfileIconTest extends ApiTest {

    @Test
    public void getProfileIcons() {
        checkGetProfileIcons(api.staticData.getProfileIcons(Region.NA));
    }
    @Test
    public void getProfileIconsAsync() throws ExecutionException, InterruptedException {
        api.staticData.getProfileIconsAsync(Region.NA).thenAccept(this::checkGetProfileIcons).get();
    }
    private void checkGetProfileIcons(ProfileIconData result) {
        assertNotNull(result);
        assertNotNull(result.data);
        assertTrue(result.data.size() + "", result.data.size() >= 1094);
        for (Map.Entry<Long, ProfileIconDetails> profileIcon : result.data.entrySet()) {
            assertEquals((long) profileIcon.getKey(), profileIcon.getValue().id);
            assertNotNull(profileIcon.getValue().image);
        }
    }
}
