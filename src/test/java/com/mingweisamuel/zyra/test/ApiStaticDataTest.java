package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.ChampionId;
import com.mingweisamuel.zyra.enums.LocaleUtil;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStaticData.Champion;
import com.mingweisamuel.zyra.lolStaticData.ChampionList;
import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import static com.mingweisamuel.zyra.test.Api.api;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LolStaticDataEndpoints}.
 */
public class ApiStaticDataTest {

    //region champion
    @Test
    public void getChampions() throws ExecutionException {
        checkGetChampions(
                api.staticData.getChampions(Region.NA, LocaleUtil.zh_CN, null, null, Arrays.asList("skins", "image")));
    }
    @Test
    public void getChampionsAsync() throws ExecutionException, InterruptedException {
        api.staticData.getChampionsAsync(Region.NA, LocaleUtil.zh_CN, null, null, Arrays.asList("skins", "image"))
                .thenAccept(this::checkGetChampions).get();
    }
    private void checkGetChampions(ChampionList result) {
        checkGetChampion(result.data.get("Zyra"));
        assertEquals("齐天大圣", result.data.get("MonkeyKing").name);
    }

    @Test
    public void getChampion() throws ExecutionException {
        checkGetChampion(api.staticData.getChampion(Region.NA, ChampionId.ZYRA, LocaleUtil.zh_CN, null,
                Arrays.asList("skins", "image")));
    }
    @Test
    public void getChampionAsync() throws ExecutionException, InterruptedException {
        api.staticData.getChampionAsync(
                Region.NA, ChampionId.ZYRA, LocaleUtil.zh_CN, null, Arrays.asList("skins", "image"))
                .thenAccept(this::checkGetChampion).get();
    }
    private void checkGetChampion(Champion result) {
        assertNull(result.allytips);
        assertNull(result.blurb);
        assertEquals("荆棘之兴", result.name);
        assertEquals("Zyra.png", result.image.full);
        assertEquals(4, result.skins.size());
        assertEquals("野火之藤 婕拉", result.skins.get(1).name);
    }
    //endregion
}
