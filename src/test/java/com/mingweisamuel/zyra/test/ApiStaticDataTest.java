package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.ChampionId;
import com.mingweisamuel.zyra.enums.LocaleUtil;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStaticData.Champion;
import com.mingweisamuel.zyra.lolStaticData.ChampionList;
import com.mingweisamuel.zyra.lolStaticData.Item;
import com.mingweisamuel.zyra.lolStaticData.ItemList;
import com.mingweisamuel.zyra.lolStaticData.Rune;
import com.mingweisamuel.zyra.lolStaticData.RuneList;
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

    //region items
    @Test
    public void getItems() throws ExecutionException {
        checkGetItems(
                api.staticData.getItems(Region.NA, LocaleUtil.zh_CN, null, Arrays.asList("gold", "image")));
    }
    @Test
    public void getItemsAsync() throws ExecutionException, InterruptedException {
        api.staticData.getItemsAsync(Region.NA, LocaleUtil.zh_CN, null, Arrays.asList("gold", "image"))
                .thenAccept(this::checkGetItems).get();
    }
    private void checkGetItems(ItemList result) {
        checkGetItem(result.data.get(3107));
        assertEquals("炽热香炉", result.data.get(3504).name);
    }

    @Test
    public void getItem() throws ExecutionException {
        checkGetItem(api.staticData.getItem(Region.NA, 3107, LocaleUtil.zh_CN, null,
                Arrays.asList("gold", "image")));
    }
    @Test
    public void getItemAsync() throws ExecutionException, InterruptedException {
        api.staticData.getItemAsync(
                Region.NA, 3107, LocaleUtil.zh_CN, null, Arrays.asList("gold", "image"))
                .thenAccept(this::checkGetItem).get();
    }
    private void checkGetItem(Item result) {
        assertNull(result.sanitizedDescription);
        assertEquals("救赎", result.name);
        assertEquals(2100, result.gold.total);
        assertEquals("3107.png", result.image.full);
    }
    //endregion
}
