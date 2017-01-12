package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
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
import java.lang.Boolean;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class LolStaticDataEndpoints {
  private static final Type GET_CHAMPIONS__TYPE = ChampionList.class;

  private static final String GET_CHAMPIONS__URL = "/api/lol/static-data/%1$s/v1.2/champion";

  private static final Type GET_CHAMPION__TYPE = Champion.class;

  private static final String GET_CHAMPION__URL = "/api/lol/static-data/%1$s/v1.2/champion/%2$s";

  private static final Type GET_ITEMS__TYPE = ItemList.class;

  private static final String GET_ITEMS__URL = "/api/lol/static-data/%1$s/v1.2/item";

  private static final Type GET_ITEM__TYPE = Item.class;

  private static final String GET_ITEM__URL = "/api/lol/static-data/%1$s/v1.2/item/%2$s";

  private static final Type GET_LANGUAGE_STRINGS__TYPE = LanguageStrings.class;

  private static final String GET_LANGUAGE_STRINGS__URL = "/api/lol/static-data/%1$s/v1.2/language-strings";

  private static final Type GET_LANGUAGES__TYPE = new TypeToken<List<String>>() {
  }.getType();

  private static final String GET_LANGUAGES__URL = "/api/lol/static-data/%1$s/v1.2/languages";

  private static final Type GET_MAPS__TYPE = MapData.class;

  private static final String GET_MAPS__URL = "/api/lol/static-data/%1$s/v1.2/map";

  private static final Type GET_MASTERIES__TYPE = MasteryList.class;

  private static final String GET_MASTERIES__URL = "/api/lol/static-data/%1$s/v1.2/mastery";

  private static final Type GET_MASTERY__TYPE = Mastery.class;

  private static final String GET_MASTERY__URL = "/api/lol/static-data/%1$s/v1.2/mastery/%2$s";

  private static final Type GET_REALM__TYPE = Realm.class;

  private static final String GET_REALM__URL = "/api/lol/static-data/%1$s/v1.2/realm";

  private static final Type GET_RUNES__TYPE = RuneList.class;

  private static final String GET_RUNES__URL = "/api/lol/static-data/%1$s/v1.2/rune";

  private static final Type GET_RUNE__TYPE = Rune.class;

  private static final String GET_RUNE__URL = "/api/lol/static-data/%1$s/v1.2/rune/%2$s";

  private static final Type GET_SUMMONER_SPELLS__TYPE = SummonerSpellList.class;

  private static final String GET_SUMMONER_SPELLS__URL = "/api/lol/static-data/%1$s/v1.2/summoner-spell";

  private static final Type GET_SUMMONER_SPELL__TYPE = SummonerSpell.class;

  private static final String GET_SUMMONER_SPELL__URL = "/api/lol/static-data/%1$s/v1.2/summoner-spell/%2$s";

  private static final Type GET_VERSIONS__TYPE = new TypeToken<List<String>>() {
  }.getType();

  private static final String GET_VERSIONS__URL = "/api/lol/static-data/%1$s/v1.2/versions";

  private final RiotApi riotApi;

  public LolStaticDataEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById Riot API description: If specified as true, the returned data map will use the champions' IDs as the keys. If not specified or specified as false, the returned data map will use the champions' keys instead.
   * @param champData Riot API description: Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public ChampionList getChampions(final Region region, final String locale, final String version,
      final Boolean dataById, final Collection<String> champData) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_CHAMPIONS__URL, region), region, GET_CHAMPIONS__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "dataById", dataById, "champData", champData));}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById Riot API description: If specified as true, the returned data map will use the champions' IDs as the keys. If not specified or specified as false, the returned data map will use the champions' keys instead.
   * @param champData Riot API description: Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public CompletableFuture<ChampionList> getChampionsAsync(final Region region, final String locale,
      final String version, final Boolean dataById, final Collection<String> champData) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_CHAMPIONS__URL, region), region, GET_CHAMPIONS__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "dataById", dataById, "champData", champData));}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById Riot API description: If specified as true, the returned data map will use the champions' IDs as the keys. If not specified or specified as false, the returned data map will use the champions' keys instead. */
  public ChampionList getChampions(final Region region, final String locale, final String version,
      final Boolean dataById) throws ExecutionException {
    return getChampions(region, locale, version, dataById, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById Riot API description: If specified as true, the returned data map will use the champions' IDs as the keys. If not specified or specified as false, the returned data map will use the champions' keys instead. */
  public CompletableFuture<ChampionList> getChampionsAsync(final Region region, final String locale,
      final String version, final Boolean dataById) {
    return getChampionsAsync(region, locale, version, dataById, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public ChampionList getChampions(final Region region, final String locale, final String version)
      throws ExecutionException {
    return getChampions(region, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<ChampionList> getChampionsAsync(final Region region, final String locale,
      final String version) {
    return getChampionsAsync(region, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public ChampionList getChampions(final Region region, final String locale) throws
      ExecutionException {
    return getChampions(region, locale, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<ChampionList> getChampionsAsync(final Region region,
      final String locale) {
    return getChampionsAsync(region, locale, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information. */
  public ChampionList getChampions(final Region region) throws ExecutionException {
    return getChampions(region, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information. */
  public CompletableFuture<ChampionList> getChampionsAsync(final Region region) {
    return getChampionsAsync(region, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param id Riot API description: Champion ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param champData Riot API description: Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public Champion getChampion(final Region region, final int id, final String locale,
      final String version, final Collection<String> champData) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_CHAMPION__URL, region, id), region, GET_CHAMPION__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "champData", champData));}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param id Riot API description: Champion ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param champData Riot API description: Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public CompletableFuture<Champion> getChampionAsync(final Region region, final int id,
      final String locale, final String version, final Collection<String> champData) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_CHAMPION__URL, region, id), region, GET_CHAMPION__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "champData", champData));}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param id Riot API description: Champion ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public Champion getChampion(final Region region, final int id, final String locale,
      final String version) throws ExecutionException {
    return getChampion(region, id, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param id Riot API description: Champion ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<Champion> getChampionAsync(final Region region, final int id,
      final String locale, final String version) {
    return getChampionAsync(region, id, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param id Riot API description: Champion ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public Champion getChampion(final Region region, final int id, final String locale) throws
      ExecutionException {
    return getChampion(region, id, locale, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param id Riot API description: Champion ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<Champion> getChampionAsync(final Region region, final int id,
      final String locale) {
    return getChampionAsync(region, id, locale, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param id Riot API description: Champion ID */
  public Champion getChampion(final Region region, final int id) throws ExecutionException {
    return getChampion(region, id, null);}

  /**
   * Not all data specified below is returned by default. See the champData parameter for more information.
   *
   * @param id Riot API description: Champion ID */
  public CompletableFuture<Champion> getChampionAsync(final Region region, final int id) {
    return getChampionAsync(region, id, null);}

  /**
   * Not all data specified below is returned by default. See the itemListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param itemListData Riot API description: Tags to return additional data. Only type, version, basic, data, id, name, plaintext, group, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public ItemList getItems(final Region region, final String locale, final String version,
      final Collection<String> itemListData) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_ITEMS__URL, region), region, GET_ITEMS__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "itemListData", itemListData));}

  /**
   * Not all data specified below is returned by default. See the itemListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param itemListData Riot API description: Tags to return additional data. Only type, version, basic, data, id, name, plaintext, group, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public CompletableFuture<ItemList> getItemsAsync(final Region region, final String locale,
      final String version, final Collection<String> itemListData) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_ITEMS__URL, region), region, GET_ITEMS__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "itemListData", itemListData));}

  /**
   * Not all data specified below is returned by default. See the itemListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public ItemList getItems(final Region region, final String locale, final String version) throws
      ExecutionException {
    return getItems(region, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the itemListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<ItemList> getItemsAsync(final Region region, final String locale,
      final String version) {
    return getItemsAsync(region, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the itemListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public ItemList getItems(final Region region, final String locale) throws ExecutionException {
    return getItems(region, locale, null);}

  /**
   * Not all data specified below is returned by default. See the itemListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<ItemList> getItemsAsync(final Region region, final String locale) {
    return getItemsAsync(region, locale, null);}

  /**
   * Not all data specified below is returned by default. See the itemListData parameter for more information. */
  public ItemList getItems(final Region region) throws ExecutionException {
    return getItems(region, null);}

  /**
   * Not all data specified below is returned by default. See the itemListData parameter for more information. */
  public CompletableFuture<ItemList> getItemsAsync(final Region region) {
    return getItemsAsync(region, null);}

  /**
   * Not all data specified below is returned by default. See the itemData parameter for more information.
   *
   * @param id Riot API description: Item ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param itemData Riot API description: Tags to return additional data. Only id, name, plaintext, group, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public Item getItem(final Region region, final int id, final String locale, final String version,
      final Collection<String> itemData) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_ITEM__URL, region, id), region, GET_ITEM__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "itemData", itemData));}

  /**
   * Not all data specified below is returned by default. See the itemData parameter for more information.
   *
   * @param id Riot API description: Item ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param itemData Riot API description: Tags to return additional data. Only id, name, plaintext, group, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public CompletableFuture<Item> getItemAsync(final Region region, final int id,
      final String locale, final String version, final Collection<String> itemData) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_ITEM__URL, region, id), region, GET_ITEM__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "itemData", itemData));}

  /**
   * Not all data specified below is returned by default. See the itemData parameter for more information.
   *
   * @param id Riot API description: Item ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public Item getItem(final Region region, final int id, final String locale, final String version)
      throws ExecutionException {
    return getItem(region, id, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the itemData parameter for more information.
   *
   * @param id Riot API description: Item ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<Item> getItemAsync(final Region region, final int id,
      final String locale, final String version) {
    return getItemAsync(region, id, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the itemData parameter for more information.
   *
   * @param id Riot API description: Item ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public Item getItem(final Region region, final int id, final String locale) throws
      ExecutionException {
    return getItem(region, id, locale, null);}

  /**
   * Not all data specified below is returned by default. See the itemData parameter for more information.
   *
   * @param id Riot API description: Item ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<Item> getItemAsync(final Region region, final int id,
      final String locale) {
    return getItemAsync(region, id, locale, null);}

  /**
   * Not all data specified below is returned by default. See the itemData parameter for more information.
   *
   * @param id Riot API description: Item ID */
  public Item getItem(final Region region, final int id) throws ExecutionException {
    return getItem(region, id, null);}

  /**
   * Not all data specified below is returned by default. See the itemData parameter for more information.
   *
   * @param id Riot API description: Item ID */
  public CompletableFuture<Item> getItemAsync(final Region region, final int id) {
    return getItemAsync(region, id, null);}

  /**
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public LanguageStrings getLanguageStrings(final Region region, final String locale,
      final String version) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_LANGUAGE_STRINGS__URL, region), region, GET_LANGUAGE_STRINGS__TYPE,
        riotApi.makeParams("locale", locale, "version", version));}

  /**
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<LanguageStrings> getLanguageStringsAsync(final Region region,
      final String locale, final String version) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_LANGUAGE_STRINGS__URL, region), region, GET_LANGUAGE_STRINGS__TYPE,
        riotApi.makeParams("locale", locale, "version", version));}

  /**
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public LanguageStrings getLanguageStrings(final Region region, final String locale) throws
      ExecutionException {
    return getLanguageStrings(region, locale, null);}

  /**
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<LanguageStrings> getLanguageStringsAsync(final Region region,
      final String locale) {
    return getLanguageStringsAsync(region, locale, null);}

  public LanguageStrings getLanguageStrings(final Region region) throws ExecutionException {
    return getLanguageStrings(region, null);}

  public CompletableFuture<LanguageStrings> getLanguageStringsAsync(final Region region) {
    return getLanguageStringsAsync(region, null);}

  public List<String> getLanguages(final Region region) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_LANGUAGES__URL, region), region, GET_LANGUAGES__TYPE);}

  public CompletableFuture<List<String>> getLanguagesAsync(final Region region) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_LANGUAGES__URL, region), region, GET_LANGUAGES__TYPE);}

  /**
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public MapData getMaps(final Region region, final String locale, final String version) throws
      ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_MAPS__URL, region), region, GET_MAPS__TYPE,
        riotApi.makeParams("locale", locale, "version", version));}

  /**
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<MapData> getMapsAsync(final Region region, final String locale,
      final String version) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_MAPS__URL, region), region, GET_MAPS__TYPE,
        riotApi.makeParams("locale", locale, "version", version));}

  /**
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public MapData getMaps(final Region region, final String locale) throws ExecutionException {
    return getMaps(region, locale, null);}

  /**
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<MapData> getMapsAsync(final Region region, final String locale) {
    return getMapsAsync(region, locale, null);}

  public MapData getMaps(final Region region) throws ExecutionException {
    return getMaps(region, null);}

  public CompletableFuture<MapData> getMapsAsync(final Region region) {
    return getMapsAsync(region, null);}

  /**
   * Not all data specified below is returned by default. See the masteryListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param masteryListData Riot API description: Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public MasteryList getMasteries(final Region region, final String locale, final String version,
      final Collection<String> masteryListData) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_MASTERIES__URL, region), region, GET_MASTERIES__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "masteryListData", masteryListData));}

  /**
   * Not all data specified below is returned by default. See the masteryListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param masteryListData Riot API description: Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public CompletableFuture<MasteryList> getMasteriesAsync(final Region region, final String locale,
      final String version, final Collection<String> masteryListData) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_MASTERIES__URL, region), region, GET_MASTERIES__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "masteryListData", masteryListData));}

  /**
   * Not all data specified below is returned by default. See the masteryListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public MasteryList getMasteries(final Region region, final String locale, final String version)
      throws ExecutionException {
    return getMasteries(region, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the masteryListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<MasteryList> getMasteriesAsync(final Region region, final String locale,
      final String version) {
    return getMasteriesAsync(region, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the masteryListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public MasteryList getMasteries(final Region region, final String locale) throws
      ExecutionException {
    return getMasteries(region, locale, null);}

  /**
   * Not all data specified below is returned by default. See the masteryListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<MasteryList> getMasteriesAsync(final Region region,
      final String locale) {
    return getMasteriesAsync(region, locale, null);}

  /**
   * Not all data specified below is returned by default. See the masteryListData parameter for more information. */
  public MasteryList getMasteries(final Region region) throws ExecutionException {
    return getMasteries(region, null);}

  /**
   * Not all data specified below is returned by default. See the masteryListData parameter for more information. */
  public CompletableFuture<MasteryList> getMasteriesAsync(final Region region) {
    return getMasteriesAsync(region, null);}

  /**
   * Not all data specified below is returned by default. See the masteryData parameter for more information.
   *
   * @param id Riot API description: Mastery ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param masteryData Riot API description: Tags to return additional data. Only id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public Mastery getMastery(final Region region, final int id, final String locale,
      final String version, final Collection<String> masteryData) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_MASTERY__URL, region, id), region, GET_MASTERY__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "masteryData", masteryData));}

  /**
   * Not all data specified below is returned by default. See the masteryData parameter for more information.
   *
   * @param id Riot API description: Mastery ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param masteryData Riot API description: Tags to return additional data. Only id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public CompletableFuture<Mastery> getMasteryAsync(final Region region, final int id,
      final String locale, final String version, final Collection<String> masteryData) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_MASTERY__URL, region, id), region, GET_MASTERY__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "masteryData", masteryData));}

  /**
   * Not all data specified below is returned by default. See the masteryData parameter for more information.
   *
   * @param id Riot API description: Mastery ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public Mastery getMastery(final Region region, final int id, final String locale,
      final String version) throws ExecutionException {
    return getMastery(region, id, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the masteryData parameter for more information.
   *
   * @param id Riot API description: Mastery ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<Mastery> getMasteryAsync(final Region region, final int id,
      final String locale, final String version) {
    return getMasteryAsync(region, id, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the masteryData parameter for more information.
   *
   * @param id Riot API description: Mastery ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public Mastery getMastery(final Region region, final int id, final String locale) throws
      ExecutionException {
    return getMastery(region, id, locale, null);}

  /**
   * Not all data specified below is returned by default. See the masteryData parameter for more information.
   *
   * @param id Riot API description: Mastery ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<Mastery> getMasteryAsync(final Region region, final int id,
      final String locale) {
    return getMasteryAsync(region, id, locale, null);}

  /**
   * Not all data specified below is returned by default. See the masteryData parameter for more information.
   *
   * @param id Riot API description: Mastery ID */
  public Mastery getMastery(final Region region, final int id) throws ExecutionException {
    return getMastery(region, id, null);}

  /**
   * Not all data specified below is returned by default. See the masteryData parameter for more information.
   *
   * @param id Riot API description: Mastery ID */
  public CompletableFuture<Mastery> getMasteryAsync(final Region region, final int id) {
    return getMasteryAsync(region, id, null);}

  public Realm getRealm(final Region region) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_REALM__URL, region), region, GET_REALM__TYPE);}

  public CompletableFuture<Realm> getRealmAsync(final Region region) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_REALM__URL, region), region, GET_REALM__TYPE);}

  /**
   * Not all data specified below is returned by default. See the runeListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param runeListData Riot API description: Tags to return additional data. Only type, version, data, id, name, rune, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public RuneList getRunes(final Region region, final String locale, final String version,
      final Collection<String> runeListData) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_RUNES__URL, region), region, GET_RUNES__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "runeListData", runeListData));}

  /**
   * Not all data specified below is returned by default. See the runeListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param runeListData Riot API description: Tags to return additional data. Only type, version, data, id, name, rune, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public CompletableFuture<RuneList> getRunesAsync(final Region region, final String locale,
      final String version, final Collection<String> runeListData) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_RUNES__URL, region), region, GET_RUNES__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "runeListData", runeListData));}

  /**
   * Not all data specified below is returned by default. See the runeListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public RuneList getRunes(final Region region, final String locale, final String version) throws
      ExecutionException {
    return getRunes(region, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the runeListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<RuneList> getRunesAsync(final Region region, final String locale,
      final String version) {
    return getRunesAsync(region, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the runeListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public RuneList getRunes(final Region region, final String locale) throws ExecutionException {
    return getRunes(region, locale, null);}

  /**
   * Not all data specified below is returned by default. See the runeListData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<RuneList> getRunesAsync(final Region region, final String locale) {
    return getRunesAsync(region, locale, null);}

  /**
   * Not all data specified below is returned by default. See the runeListData parameter for more information. */
  public RuneList getRunes(final Region region) throws ExecutionException {
    return getRunes(region, null);}

  /**
   * Not all data specified below is returned by default. See the runeListData parameter for more information. */
  public CompletableFuture<RuneList> getRunesAsync(final Region region) {
    return getRunesAsync(region, null);}

  /**
   * Not all data specified below is returned by default. See the runeData parameter for more information.
   *
   * @param id Riot API description: Rune ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param runeData Riot API description: Tags to return additional data. Only id, name, rune, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public Rune getRune(final Region region, final int id, final String locale, final String version,
      final Collection<String> runeData) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_RUNE__URL, region, id), region, GET_RUNE__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "runeData", runeData));}

  /**
   * Not all data specified below is returned by default. See the runeData parameter for more information.
   *
   * @param id Riot API description: Rune ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param runeData Riot API description: Tags to return additional data. Only id, name, rune, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public CompletableFuture<Rune> getRuneAsync(final Region region, final int id,
      final String locale, final String version, final Collection<String> runeData) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_RUNE__URL, region, id), region, GET_RUNE__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "runeData", runeData));}

  /**
   * Not all data specified below is returned by default. See the runeData parameter for more information.
   *
   * @param id Riot API description: Rune ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public Rune getRune(final Region region, final int id, final String locale, final String version)
      throws ExecutionException {
    return getRune(region, id, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the runeData parameter for more information.
   *
   * @param id Riot API description: Rune ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<Rune> getRuneAsync(final Region region, final int id,
      final String locale, final String version) {
    return getRuneAsync(region, id, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the runeData parameter for more information.
   *
   * @param id Riot API description: Rune ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public Rune getRune(final Region region, final int id, final String locale) throws
      ExecutionException {
    return getRune(region, id, locale, null);}

  /**
   * Not all data specified below is returned by default. See the runeData parameter for more information.
   *
   * @param id Riot API description: Rune ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<Rune> getRuneAsync(final Region region, final int id,
      final String locale) {
    return getRuneAsync(region, id, locale, null);}

  /**
   * Not all data specified below is returned by default. See the runeData parameter for more information.
   *
   * @param id Riot API description: Rune ID */
  public Rune getRune(final Region region, final int id) throws ExecutionException {
    return getRune(region, id, null);}

  /**
   * Not all data specified below is returned by default. See the runeData parameter for more information.
   *
   * @param id Riot API description: Rune ID */
  public CompletableFuture<Rune> getRuneAsync(final Region region, final int id) {
    return getRuneAsync(region, id, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById Riot API description: If specified as true, the returned data map will use the spells' IDs as the keys. If not specified or specified as false, the returned data map will use the spells' keys instead.
   * @param spellData Riot API description: Tags to return additional data. Only type, version, data, id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public SummonerSpellList getSummonerSpells(final Region region, final String locale,
      final String version, final Boolean dataById, final Collection<String> spellData) throws
      ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_SUMMONER_SPELLS__URL, region), region, GET_SUMMONER_SPELLS__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "dataById", dataById, "spellData", spellData));}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById Riot API description: If specified as true, the returned data map will use the spells' IDs as the keys. If not specified or specified as false, the returned data map will use the spells' keys instead.
   * @param spellData Riot API description: Tags to return additional data. Only type, version, data, id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public CompletableFuture<SummonerSpellList> getSummonerSpellsAsync(final Region region,
      final String locale, final String version, final Boolean dataById,
      final Collection<String> spellData) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_SUMMONER_SPELLS__URL, region), region, GET_SUMMONER_SPELLS__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "dataById", dataById, "spellData", spellData));}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById Riot API description: If specified as true, the returned data map will use the spells' IDs as the keys. If not specified or specified as false, the returned data map will use the spells' keys instead. */
  public SummonerSpellList getSummonerSpells(final Region region, final String locale,
      final String version, final Boolean dataById) throws ExecutionException {
    return getSummonerSpells(region, locale, version, dataById, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById Riot API description: If specified as true, the returned data map will use the spells' IDs as the keys. If not specified or specified as false, the returned data map will use the spells' keys instead. */
  public CompletableFuture<SummonerSpellList> getSummonerSpellsAsync(final Region region,
      final String locale, final String version, final Boolean dataById) {
    return getSummonerSpellsAsync(region, locale, version, dataById, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public SummonerSpellList getSummonerSpells(final Region region, final String locale,
      final String version) throws ExecutionException {
    return getSummonerSpells(region, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<SummonerSpellList> getSummonerSpellsAsync(final Region region,
      final String locale, final String version) {
    return getSummonerSpellsAsync(region, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public SummonerSpellList getSummonerSpells(final Region region, final String locale) throws
      ExecutionException {
    return getSummonerSpells(region, locale, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<SummonerSpellList> getSummonerSpellsAsync(final Region region,
      final String locale) {
    return getSummonerSpellsAsync(region, locale, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information. */
  public SummonerSpellList getSummonerSpells(final Region region) throws ExecutionException {
    return getSummonerSpells(region, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information. */
  public CompletableFuture<SummonerSpellList> getSummonerSpellsAsync(final Region region) {
    return getSummonerSpellsAsync(region, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param id Riot API description: Summoner spell ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param spellData Riot API description: Tags to return additional data. Only id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public SummonerSpell getSummonerSpell(final Region region, final int id, final String locale,
      final String version, final Collection<String> spellData) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_SUMMONER_SPELL__URL, region, id), region, GET_SUMMONER_SPELL__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "spellData", spellData));}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param id Riot API description: Summoner spell ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param spellData Riot API description: Tags to return additional data. Only id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'. */
  public CompletableFuture<SummonerSpell> getSummonerSpellAsync(final Region region, final int id,
      final String locale, final String version, final Collection<String> spellData) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_SUMMONER_SPELL__URL, region, id), region, GET_SUMMONER_SPELL__TYPE,
        riotApi.makeParams("locale", locale, "version", version, "spellData", spellData));}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param id Riot API description: Summoner spell ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public SummonerSpell getSummonerSpell(final Region region, final int id, final String locale,
      final String version) throws ExecutionException {
    return getSummonerSpell(region, id, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param id Riot API description: Summoner spell ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   * @param version Riot API description: Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint. */
  public CompletableFuture<SummonerSpell> getSummonerSpellAsync(final Region region, final int id,
      final String locale, final String version) {
    return getSummonerSpellAsync(region, id, locale, version, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param id Riot API description: Summoner spell ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public SummonerSpell getSummonerSpell(final Region region, final int id, final String locale)
      throws ExecutionException {
    return getSummonerSpell(region, id, locale, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param id Riot API description: Summoner spell ID
   * @param locale Riot API description: Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used. */
  public CompletableFuture<SummonerSpell> getSummonerSpellAsync(final Region region, final int id,
      final String locale) {
    return getSummonerSpellAsync(region, id, locale, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param id Riot API description: Summoner spell ID */
  public SummonerSpell getSummonerSpell(final Region region, final int id) throws
      ExecutionException {
    return getSummonerSpell(region, id, null);}

  /**
   * Not all data specified below is returned by default. See the spellData parameter for more information.
   *
   * @param id Riot API description: Summoner spell ID */
  public CompletableFuture<SummonerSpell> getSummonerSpellAsync(final Region region, final int id) {
    return getSummonerSpellAsync(region, id, null);}

  public List<String> getVersions(final Region region) throws ExecutionException {
    return riotApi.getBasicNonRateLimited(String.format(GET_VERSIONS__URL, region), region, GET_VERSIONS__TYPE);}

  public CompletableFuture<List<String>> getVersionsAsync(final Region region) {
    return riotApi.getBasicNonRateLimitedAsync(String.format(GET_VERSIONS__URL, region), region, GET_VERSIONS__TYPE);}
}
