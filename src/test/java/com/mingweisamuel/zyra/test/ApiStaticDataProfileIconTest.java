package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.staticData.ProfileIcon;
import com.mingweisamuel.zyra.staticData.ProfileIconData;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.StaticDataEndpoints#getProfileIcons}.
 */
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
        for (Map.Entry<Long, ProfileIcon> profileIcon : result.data.entrySet()) {
            assertEquals((long) profileIcon.getKey(), profileIcon.getValue().id);
            assertNotNull(profileIcon.getValue().image);
        }
    }
}
