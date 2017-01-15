package com.mingweisamuel.zyra.test;

import com.mingweisamuel.zyra.enums.ChampionId;
import com.mingweisamuel.zyra.enums.LocaleUtil;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStaticData.Champion;
import com.mingweisamuel.zyra.lolStaticData.ChampionList;
import com.mingweisamuel.zyra.lolStaticData.Item;
import com.mingweisamuel.zyra.lolStaticData.ItemList;
import com.mingweisamuel.zyra.lolStaticData.LanguageStrings;
import com.mingweisamuel.zyra.lolStaticData.MapData;
import com.mingweisamuel.zyra.lolStaticData.Mastery;
import com.mingweisamuel.zyra.lolStaticData.MasteryList;
import com.mingweisamuel.zyra.lolStaticData.Realm;
import com.mingweisamuel.zyra.lolStaticData.Rune;
import com.mingweisamuel.zyra.lolStaticData.RuneList;
import com.mingweisamuel.zyra.lolStaticData.SummonerSpell;
import com.mingweisamuel.zyra.lolStaticData.SummonerSpellList;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link com.mingweisamuel.zyra.LolStaticDataEndpoints}.
 */
public class ApiStaticDataTest extends ApiTest {

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
        assertNotNull(result);
        checkGetChampion(result.data.get("Zyra"));
        assertEquals("\u9f50\u5929\u5927\u5723", result.data.get("MonkeyKing").name);
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
        assertEquals("\u8346\u68d8\u4e4b\u5174", result.name);
        assertEquals("Zyra.png", result.image.full);
        assertEquals(4, result.skins.size());
        assertEquals("\u91ce\u706b\u4e4b\u85e4 \u5a55\u62c9", result.skins.get(1).name);
    }
    //endregion

    //region items
    @Test
    public void getItems() throws ExecutionException {
        checkGetItems(
                api.staticData.getItems(Region.NA, LocaleUtil.zh_CN, null, Arrays.asList("gold", "image", "maps")));
    }
    @Test
    public void getItemsAsync() throws ExecutionException, InterruptedException {
        api.staticData.getItemsAsync(Region.NA, LocaleUtil.zh_CN, null, Arrays.asList("gold", "image", "maps"))
                .thenAccept(this::checkGetItems).get();
    }
    private void checkGetItems(ItemList result) {
        assertNotNull(result);
        checkGetItem(result.data.get(3107));
        // ardent censer
        assertEquals("\u70bd\u70ed\u9999\u7089", result.data.get(3504).name);
    }

    @Test
    public void getItem() throws ExecutionException {
        checkGetItem(api.staticData.getItem(Region.NA, 3107, LocaleUtil.zh_CN, null,
                Arrays.asList("gold", "image", "maps")));
    }
    @Test
    public void getItemAsync() throws ExecutionException, InterruptedException {
        api.staticData.getItemAsync(
                Region.NA, 3107, LocaleUtil.zh_CN, null, Arrays.asList("gold", "image", "maps"))
                .thenAccept(this::checkGetItem).get();
    }
    private void checkGetItem(Item result) {
        assertNull(result.sanitizedDescription);
        // Redemption
        assertEquals("\u6551\u8d4e", result.name);
        assertEquals(2100, result.gold.total);
        assertEquals("3107.png", result.image.full);
        assertTrue(result.maps.get(11));
    }
    //endregion

    //region language
    @Test
    public void getLanguageStrings() throws ExecutionException {
        checkGetLanguageStrings(api.staticData.getLanguageStrings(Region.NA, LocaleUtil.zh_CN));
    }
    @Test
    public void getLanguageStringsAsync() throws ExecutionException, InterruptedException {
        api.staticData.getLanguageStringsAsync(Region.NA, LocaleUtil.zh_CN)
                .thenAccept(this::checkGetLanguageStrings).get();
    }
    private void checkGetLanguageStrings(LanguageStrings result) {
        assertEquals("language", result.type);
        assertEquals("\u8303\u56f4", result.data.get("Range"));
        assertEquals("\u8303\u56f4\uff1a", result.data.get("Range_"));
        assertEquals("English", result.data.get("native_en"));
    }

    @Test
    public void getLanguages() throws ExecutionException {
        checkGetLanguages(api.staticData.getLanguages(Region.NA));
    }
    @Test
    public void getLanguagesAsync() throws ExecutionException, InterruptedException {
        api.staticData.getLanguagesAsync(Region.NA).thenAccept(this::checkGetLanguages).get();
    }
    private void checkGetLanguages(List<String> result) {
        assertNotNull(result);
        Set<String> expected = new HashSet<>(Arrays.asList(
                "en_US","cs_CZ","de_DE","el_GR","en_AU","en_GB","en_PH","en_PL","en_SG","es_AR","es_ES","es_MX","fr_FR",
                "hu_HU","id_ID","it_IT","ja_JP","ko_KR","ms_MY","pl_PL","pt_BR","ro_RO","ru_RU","th_TH","tr_TR","vn_VN",
                "zh_CN","zh_MY","zh_TW"));
        assertEquals(expected.size(), result.size());
        for (String lang : result)
            assertTrue(expected.remove(lang));
        assertTrue(expected.isEmpty());
    }
    //endregion

    //region maps
    @Test
    public void getMaps() throws ExecutionException {
        checkGetMaps(api.staticData.getMaps(Region.NA));
    }
    @Test
    public void getMapsAsync() throws ExecutionException, InterruptedException {
        api.staticData.getMapsAsync(Region.NA).thenAccept(this::checkGetMaps).get();
    }
    private void checkGetMaps(MapData result) {
        assertEquals("map", result.type);
        assertEquals("SummonersRiftNew", result.data.get(11L).mapName);
        assertEquals("map11.png", result.data.get(11L).image.full);
    }
    //endregion

    //region mastery
    @Test
    public void getMasteries() throws ExecutionException {
        checkGetMasteries(
                api.staticData.getMasteries(Region.NA, LocaleUtil.zh_CN, null, Arrays.asList("ranks", "image")));
    }
    @Test
    public void getMasteriesAsync() throws ExecutionException, InterruptedException {
        api.staticData.getMasteriesAsync(Region.NA, LocaleUtil.zh_CN, null, Arrays.asList("ranks", "image"))
                .thenAccept(this::checkGetMasteries).get();
    }
    private void checkGetMasteries(MasteryList result) {
        assertNotNull(result);
        checkGetMastery(result.data.get(6363));
        // Intelligence
        assertEquals("\u667a\u8c0b", result.data.get(6352).name);
        assertEquals(5, result.data.get(6352).ranks);
    }

    @Test
    public void getMastery() throws ExecutionException {
        checkGetMastery(
                api.staticData.getMastery(Region.NA, 6363, LocaleUtil.zh_CN, null, Arrays.asList("ranks", "image")));
    }
    @Test
    public void getMasteryAsync() throws ExecutionException, InterruptedException {
        api.staticData.getMasteryAsync(Region.NA, 6363, LocaleUtil.zh_CN, null, Arrays.asList("ranks", "image"))
                .thenAccept(this::checkGetMastery).get();
    }
    private void checkGetMastery(Mastery result) {
        assertNull(result.sanitizedDescription);
        assertEquals(6363, result.id);
        // Windspeaker's Blessing
        assertEquals("\u98ce\u8bed\u8005\u7684\u795d\u798f", result.name);
        assertEquals(1, result.ranks);
        assertEquals("6363.png", result.image.full);
    }
    //endregion

    //region realm
    @Test
    public void getRealm() throws ExecutionException {
        checkGetRealm(api.staticData.getRealm(Region.NA));
    }
    @Test
    public void getRealmAsync() throws ExecutionException, InterruptedException {
        api.staticData.getRealmAsync(Region.NA).thenAccept(this::checkGetRealm).get();
    }
    private void checkGetRealm(Realm result) {
        assertEquals("http://ddragon.leagueoflegends.com/cdn", result.cdn);
    }
    //endregion

    //region rune
    @Test
    public void getRunes() throws ExecutionException {
        checkGetRunes(api.staticData.getRunes(Region.NA, LocaleUtil.zh_CN, null, Collections.singleton("all")));
    }
    @Test
    public void getRunesAsync() throws ExecutionException, InterruptedException {
        api.staticData.getRunesAsync(Region.NA, LocaleUtil.zh_CN, null, Collections.singleton("all"))
                .thenAccept(this::checkGetRunes).get();
    }
    private void checkGetRunes(RuneList result) {
        checkGetRune(result.data.get(5337));
        // Lesser Mark of Alpine Attack Speed (?)
        Rune rune = result.data.get(8007);
        assertEquals("\u521d\u7ea7\u9ad8\u5c71\u653b\u51fb\u901f\u5ea6\u5370\u8bb0", rune.name);
        assertFalse(rune.inStore);
    }

    @Test
    public void getRune() throws ExecutionException {
        checkGetRune(api.staticData.getRune(Region.NA, 5337, LocaleUtil.zh_CN, null, Collections.singleton("all")));
    }
    @Test
    public void getRuneAsync() throws ExecutionException, InterruptedException {
        api.staticData.getRuneAsync(Region.NA, 5337, LocaleUtil.zh_CN, null, Collections.singleton("all"))
                .thenAccept(this::checkGetRune).get();
    }
    private void checkGetRune(Rune result) {
        assertNotNull(result);
        assertEquals(5337, result.id);
        // Greater Quintessence of Attack Speed
        assertEquals("\u9ad8\u7ea7\u653b\u51fb\u901f\u5ea6\u7cbe\u534e", result.name);
        assertEquals(0.045, result.stats.PercentAttackSpeedMod, Double.MIN_VALUE);
        assertNull(result.maps);
    }
    //endregion

    //region summoner-spells
    @Test
    public void getSummonerSpells() throws ExecutionException {
        testGetSummonerSpells(api.staticData.getSummonerSpells(
                Region.NA, LocaleUtil.zh_CN, null, true, Arrays.asList("image", "range")));
    }
    @Test
    public void getSummonerSpellsAsync() throws ExecutionException, InterruptedException {
        api.staticData.getSummonerSpellsAsync(Region.NA, LocaleUtil.zh_CN, null, true, Arrays.asList("image", "range"))
            .thenAccept(this::testGetSummonerSpells).get();
    }
    private void testGetSummonerSpells(SummonerSpellList result) {
        assertNotNull(result);
        testGetSummonerSpell(result.data.get(4));
        // ghost
        assertEquals("\u5e7d\u7075\u75be\u6b65", result.data.get(6).name);
        assertEquals("SummonerHaste.png", result.data.get(6).image.full);
    }

    @Test
    public void getSummonerSpell() throws ExecutionException {
        testGetSummonerSpell(
                api.staticData.getSummonerSpell(Region.NA, 4, LocaleUtil.zh_CN, null, Arrays.asList("image", "range")));
    }
    @Test
    public void getSummonerSpellAsync() throws ExecutionException, InterruptedException {
        api.staticData.getSummonerSpellAsync(Region.NA, 4, LocaleUtil.zh_CN, null, Arrays.asList("image", "range"))
                .thenAccept(this::testGetSummonerSpell).get();
    }
    private void testGetSummonerSpell(SummonerSpell result) {
        // Flash
        assertEquals("\u95ea\u73b0", result.name);
        assertEquals(4, result.id);
        assertEquals("SummonerFlash.png", result.image.full);
        assertEquals(8, result.summonerLevel);
        assertEquals(425, (int) result.range.get(0));
    }
    //endregion

    //region versions
    @Test
    public void getVersions() throws ExecutionException {
        checkGetVersions(api.staticData.getVersions(Region.NA));
    }
    @Test
    public void getVersionsAsync() throws ExecutionException, InterruptedException {
        api.staticData.getVersionsAsync(Region.NA).thenAccept(this::checkGetVersions).get();
    }
    private void checkGetVersions(List<String> result) {
        assertNotNull(result);
        Set<String> expected = new HashSet<>(Arrays.asList(
                "7.1.1","6.24.1","6.23.1","6.22.1","6.21.1","6.20.1","6.19.1","6.18.1","6.17.1","6.16.2","6.16.1",
                "6.15.1","6.14.2","6.14.1","6.13.1","6.12.1","6.11.1","6.10.1","6.9.1","6.8.1","6.7.1","6.6.1",
                "6.5.1","6.4.2","6.4.1","6.3.1","6.2.1","6.1.1","5.24.2","5.24.1","5.23.1","5.22.3","5.22.2",
                "5.22.1","5.21.1","5.20.1","5.19.1","5.18.1","5.17.1","5.16.1","5.15.1","5.14.1","5.13.1","5.12.1",
                "5.11.1","5.10.1","5.9.1","5.8.1","5.7.2","5.7.1","5.6.2","5.6.1","5.5.3","5.5.2","5.5.1","5.4.1",
                "5.3.1","5.2.2","5.2.1","5.1.2","5.1.1","4.21.5","4.21.4","4.21.3","4.21.1","4.20.2","4.20.1",
                "4.19.3","4.19.2","4.18.1","4.17.1","4.16.1","4.15.1","4.14.2","4.13.1","4.12.2","4.12.1","4.11.3",
                "4.10.7","4.10.2","4.9.1","4.8.3","4.8.2","4.8.1","4.7.16","4.7.9","4.7.8","4.6.3","4.5.4","4.4.3",
                "4.4.2","4.3.18","4.3.12","4.3.10","4.3.4","4.3.2","4.2.6","4.2.5","4.2.1","4.1.43","4.1.41",
                "4.1.13","4.1.9","4.1.2","3.15.5","3.15.4","3.15.2","3.14.41","3.14.23","3.14.22","3.14.20",
                "3.14.19","3.14.16","3.14.13","3.14.12","3.13.24","3.13.8","3.13.6","3.13.1","3.12.37","3.12.36",
                "3.12.34","3.12.33","3.12.26","3.12.24","3.12.2","3.11.4","3.11.2","3.10.6","3.10.3","3.10.2",
                "3.9.7","3.9.5","3.9.4","3.8.5","3.8.3","3.8.1","3.7.9","3.7.2","3.7.1","3.6.15","3.6.14","0.154.3",
                "0.154.2","0.153.2","0.152.115","0.152.108","0.152.107","0.152.55","0.151.101","0.151.2"));
        // may be more versions in the future.
        for (String version : result)
            assertTrue(expected.remove(version));
        assertTrue(expected.toString(), expected.isEmpty());
    }
    //endregion
}
