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
import com.mingweisamuel.zyra.lolStaticData.ProfileIconData;
import com.mingweisamuel.zyra.lolStaticData.Realm;
import com.mingweisamuel.zyra.lolStaticData.Rune;
import com.mingweisamuel.zyra.lolStaticData.RuneList;
import com.mingweisamuel.zyra.lolStaticData.SummonerSpell;
import com.mingweisamuel.zyra.lolStaticData.SummonerSpellList;
import java.lang.Boolean;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * lol-static-data-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class LolStaticDataEndpoints extends Endpoints {
  LolStaticDataEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById (optional) If specified as true, the returned data map will use the champions' IDs as the keys. If not specified or specified as false, the returned data map will use the champions' keys instead.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public ChampionList getChampionList(final Region region, final List<String> tags,
      final String version, final Boolean dataById, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/champions";
    Type type = ChampionList.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("tags", tags, "version", version, "dataById", dataById, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById (optional) If specified as true, the returned data map will use the champions' IDs as the keys. If not specified or specified as false, the returned data map will use the champions' keys instead.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<ChampionList> getChampionListAsync(final Region region,
      final List<String> tags, final String version, final Boolean dataById, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/champions";
    Type type = ChampionList.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("tags", tags, "version", version, "dataById", dataById, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById (optional) If specified as true, the returned data map will use the champions' IDs as the keys. If not specified or specified as false, the returned data map will use the champions' keys instead.
   */
  public ChampionList getChampionList(final Region region, final List<String> tags,
      final String version, final Boolean dataById) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionList(region, tags, version, dataById, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById (optional) If specified as true, the returned data map will use the champions' IDs as the keys. If not specified or specified as false, the returned data map will use the champions' keys instead.
   */
  public CompletableFuture<ChampionList> getChampionListAsync(final Region region,
      final List<String> tags, final String version, final Boolean dataById) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionListAsync(region, tags, version, dataById, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public ChampionList getChampionList(final Region region, final List<String> tags,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionList(region, tags, version, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<ChampionList> getChampionListAsync(final Region region,
      final List<String> tags, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionListAsync(region, tags, version, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public ChampionList getChampionList(final Region region, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionList(region, tags, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public CompletableFuture<ChampionList> getChampionListAsync(final Region region,
      final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionListAsync(region, tags, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   */
  public ChampionList getChampionList(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionList(region, null, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   */
  public CompletableFuture<ChampionList> getChampionListAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionListAsync(region, null, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Champion ID
   * @param tags (optional) Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public Champion getChampionById(final Region region, final int id, final List<String> tags,
      final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/static-data/v3/champions/%1$s", id);
    Type type = Champion.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Champion ID
   * @param tags (optional) Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<Champion> getChampionByIdAsync(final Region region, final int id,
      final List<String> tags, final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/static-data/v3/champions/%1$s", id);
    Type type = Champion.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Champion ID
   * @param tags (optional) Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public Champion getChampionById(final Region region, final int id, final List<String> tags,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionById(region, id, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Champion ID
   * @param tags (optional) Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<Champion> getChampionByIdAsync(final Region region, final int id,
      final List<String> tags, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionByIdAsync(region, id, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Champion ID
   * @param tags (optional) Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public Champion getChampionById(final Region region, final int id, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionById(region, id, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Champion ID
   * @param tags (optional) Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public CompletableFuture<Champion> getChampionByIdAsync(final Region region, final int id,
      final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionByIdAsync(region, id, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Champion ID
   */
  public Champion getChampionById(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionById(region, id, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Champion ID
   */
  public CompletableFuture<Champion> getChampionByIdAsync(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    return this.getChampionByIdAsync(region, id, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public ItemList getItemList(final Region region, final List<String> tags, final String version,
      final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/items";
    Type type = ItemList.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<ItemList> getItemListAsync(final Region region, final List<String> tags,
      final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/items";
    Type type = ItemList.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public ItemList getItemList(final Region region, final List<String> tags, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemList(region, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<ItemList> getItemListAsync(final Region region, final List<String> tags,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemListAsync(region, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public ItemList getItemList(final Region region, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemList(region, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public CompletableFuture<ItemList> getItemListAsync(final Region region,
      final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemListAsync(region, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   */
  public ItemList getItemList(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemList(region, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   */
  public CompletableFuture<ItemList> getItemListAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemListAsync(region, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Item ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public Item getItemById(final Region region, final int id, final List<String> tags,
      final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/static-data/v3/items/%1$s", id);
    Type type = Item.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Item ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<Item> getItemByIdAsync(final Region region, final int id,
      final List<String> tags, final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/static-data/v3/items/%1$s", id);
    Type type = Item.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Item ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public Item getItemById(final Region region, final int id, final List<String> tags,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemById(region, id, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Item ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<Item> getItemByIdAsync(final Region region, final int id,
      final List<String> tags, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemByIdAsync(region, id, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Item ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public Item getItemById(final Region region, final int id, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemById(region, id, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Item ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, plaintext, and group are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public CompletableFuture<Item> getItemByIdAsync(final Region region, final int id,
      final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemByIdAsync(region, id, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Item ID
   */
  public Item getItemById(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemById(region, id, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Item ID
   */
  public CompletableFuture<Item> getItemByIdAsync(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    return this.getItemByIdAsync(region, id, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public LanguageStrings getLanguageStrings(final Region region, final String version,
      final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/language-strings";
    Type type = LanguageStrings.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<LanguageStrings> getLanguageStringsAsync(final Region region,
      final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/language-strings";
    Type type = LanguageStrings.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public LanguageStrings getLanguageStrings(final Region region, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getLanguageStrings(region, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<LanguageStrings> getLanguageStringsAsync(final Region region,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getLanguageStringsAsync(region, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public LanguageStrings getLanguageStrings(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getLanguageStrings(region, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguageStrings">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<LanguageStrings> getLanguageStringsAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getLanguageStringsAsync(region, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguages">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public List<String> getLanguages(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/languages";
    Type type = new TypeToken<List<String>>() {
    }.getType();
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getLanguages">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<List<String>> getLanguagesAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/languages";
    Type type = new TypeToken<List<String>>() {
    }.getType();
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMapData">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public MapData getMapData(final Region region, final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/maps";
    Type type = MapData.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMapData">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<MapData> getMapDataAsync(final Region region, final String version,
      final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/maps";
    Type type = MapData.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMapData">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public MapData getMapData(final Region region, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getMapData(region, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMapData">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<MapData> getMapDataAsync(final Region region, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getMapDataAsync(region, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMapData">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public MapData getMapData(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getMapData(region, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMapData">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<MapData> getMapDataAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getMapDataAsync(region, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public MasteryList getMasteryList(final Region region, final List<String> tags,
      final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/masteries";
    Type type = MasteryList.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<MasteryList> getMasteryListAsync(final Region region,
      final List<String> tags, final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/masteries";
    Type type = MasteryList.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public MasteryList getMasteryList(final Region region, final List<String> tags,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryList(region, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<MasteryList> getMasteryListAsync(final Region region,
      final List<String> tags, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryListAsync(region, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public MasteryList getMasteryList(final Region region, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryList(region, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public CompletableFuture<MasteryList> getMasteryListAsync(final Region region,
      final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryListAsync(region, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   */
  public MasteryList getMasteryList(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryList(region, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   */
  public CompletableFuture<MasteryList> getMasteryListAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryListAsync(region, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Mastery ID
   * @param tags (optional) Tags to return additional data. Only id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public Mastery getMasteryById(final Region region, final int id, final List<String> tags,
      final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/static-data/v3/masteries/%1$s", id);
    Type type = Mastery.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Mastery ID
   * @param tags (optional) Tags to return additional data. Only id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<Mastery> getMasteryByIdAsync(final Region region, final int id,
      final List<String> tags, final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/static-data/v3/masteries/%1$s", id);
    Type type = Mastery.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Mastery ID
   * @param tags (optional) Tags to return additional data. Only id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public Mastery getMasteryById(final Region region, final int id, final List<String> tags,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryById(region, id, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Mastery ID
   * @param tags (optional) Tags to return additional data. Only id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<Mastery> getMasteryByIdAsync(final Region region, final int id,
      final List<String> tags, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryByIdAsync(region, id, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Mastery ID
   * @param tags (optional) Tags to return additional data. Only id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public Mastery getMasteryById(final Region region, final int id, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryById(region, id, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Mastery ID
   * @param tags (optional) Tags to return additional data. Only id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public CompletableFuture<Mastery> getMasteryByIdAsync(final Region region, final int id,
      final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryByIdAsync(region, id, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Mastery ID
   */
  public Mastery getMasteryById(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryById(region, id, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Mastery ID
   */
  public CompletableFuture<Mastery> getMasteryByIdAsync(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    return this.getMasteryByIdAsync(region, id, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public ProfileIconData getProfileIcons(final Region region, final String version,
      final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/profile-icons";
    Type type = ProfileIconData.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<ProfileIconData> getProfileIconsAsync(final Region region,
      final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/profile-icons";
    Type type = ProfileIconData.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public ProfileIconData getProfileIcons(final Region region, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getProfileIcons(region, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<ProfileIconData> getProfileIconsAsync(final Region region,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getProfileIconsAsync(region, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public ProfileIconData getProfileIcons(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getProfileIcons(region, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<ProfileIconData> getProfileIconsAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getProfileIconsAsync(region, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRealm">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public Realm getRealm(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/realms";
    Type type = Realm.class;
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRealm">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<Realm> getRealmAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/realms";
    Type type = Realm.class;
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, description, and rune are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public RuneList getRuneList(final Region region, final String version, final List<String> tags,
      final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/runes";
    Type type = RuneList.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("version", version, "tags", tags, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, description, and rune are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<RuneList> getRuneListAsync(final Region region, final String version,
      final List<String> tags, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/runes";
    Type type = RuneList.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("version", version, "tags", tags, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, description, and rune are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public RuneList getRuneList(final Region region, final String version, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneList(region, version, tags, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, name, description, and rune are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public CompletableFuture<RuneList> getRuneListAsync(final Region region, final String version,
      final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneListAsync(region, version, tags, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public RuneList getRuneList(final Region region, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneList(region, version, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<RuneList> getRuneListAsync(final Region region, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneListAsync(region, version, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   */
  public RuneList getRuneList(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneList(region, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   */
  public CompletableFuture<RuneList> getRuneListAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneListAsync(region, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Rune ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, and rune are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public Rune getRuneById(final Region region, final int id, final List<String> tags,
      final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/static-data/v3/runes/%1$s", id);
    Type type = Rune.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Rune ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, and rune are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<Rune> getRuneByIdAsync(final Region region, final int id,
      final List<String> tags, final String version, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/static-data/v3/runes/%1$s", id);
    Type type = Rune.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("tags", tags, "version", version, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Rune ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, and rune are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public Rune getRuneById(final Region region, final int id, final List<String> tags,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneById(region, id, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Rune ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, and rune are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<Rune> getRuneByIdAsync(final Region region, final int id,
      final List<String> tags, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneByIdAsync(region, id, tags, version, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Rune ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, and rune are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public Rune getRuneById(final Region region, final int id, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneById(region, id, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Rune ID
   * @param tags (optional) Tags to return additional data. Only id, name, description, and rune are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public CompletableFuture<Rune> getRuneByIdAsync(final Region region, final int id,
      final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneByIdAsync(region, id, tags, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Rune ID
   */
  public Rune getRuneById(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneById(region, id, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Rune ID
   */
  public CompletableFuture<Rune> getRuneByIdAsync(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    return this.getRuneByIdAsync(region, id, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById (optional) If specified as true, the returned data map will use the spells' IDs as the keys. If not specified or specified as false, the returned data map will use the spells' keys instead.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public SummonerSpellList getSummonerSpellList(final Region region, final String version,
      final Boolean dataById, final List<String> tags, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/summoner-spells";
    Type type = SummonerSpellList.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("version", version, "dataById", dataById, "tags", tags, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById (optional) If specified as true, the returned data map will use the spells' IDs as the keys. If not specified or specified as false, the returned data map will use the spells' keys instead.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<SummonerSpellList> getSummonerSpellListAsync(final Region region,
      final String version, final Boolean dataById, final List<String> tags, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/summoner-spells";
    Type type = SummonerSpellList.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("version", version, "dataById", dataById, "tags", tags, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById (optional) If specified as true, the returned data map will use the spells' IDs as the keys. If not specified or specified as false, the returned data map will use the spells' keys instead.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public SummonerSpellList getSummonerSpellList(final Region region, final String version,
      final Boolean dataById, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellList(region, version, dataById, tags, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById (optional) If specified as true, the returned data map will use the spells' IDs as the keys. If not specified or specified as false, the returned data map will use the spells' keys instead.
   * @param tags (optional) Tags to return additional data. Only type, version, data, id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public CompletableFuture<SummonerSpellList> getSummonerSpellListAsync(final Region region,
      final String version, final Boolean dataById, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellListAsync(region, version, dataById, tags, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById (optional) If specified as true, the returned data map will use the spells' IDs as the keys. If not specified or specified as false, the returned data map will use the spells' keys instead.
   */
  public SummonerSpellList getSummonerSpellList(final Region region, final String version,
      final Boolean dataById) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellList(region, version, dataById, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param dataById (optional) If specified as true, the returned data map will use the spells' IDs as the keys. If not specified or specified as false, the returned data map will use the spells' keys instead.
   */
  public CompletableFuture<SummonerSpellList> getSummonerSpellListAsync(final Region region,
      final String version, final Boolean dataById) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellListAsync(region, version, dataById, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public SummonerSpellList getSummonerSpellList(final Region region, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellList(region, version, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<SummonerSpellList> getSummonerSpellListAsync(final Region region,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellListAsync(region, version, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   */
  public SummonerSpellList getSummonerSpellList(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellList(region, null, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellList">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   */
  public CompletableFuture<SummonerSpellList> getSummonerSpellListAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellListAsync(region, null, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Summoner spell ID
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param tags (optional) Tags to return additional data. Only id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public SummonerSpell getSummonerSpellById(final Region region, final int id, final String version,
      final List<String> tags, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/static-data/v3/summoner-spells/%1$s", id);
    Type type = SummonerSpell.class;
    return riotApi.getBasic(url, region, type, riotApi.makeParams("version", version, "tags", tags, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Summoner spell ID
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param tags (optional) Tags to return additional data. Only id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   * @param locale (optional) Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
   */
  public CompletableFuture<SummonerSpell> getSummonerSpellByIdAsync(final Region region,
      final int id, final String version, final List<String> tags, final String locale) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/static-data/v3/summoner-spells/%1$s", id);
    Type type = SummonerSpell.class;
    return riotApi.getBasicAsync(url, region, type, riotApi.makeParams("version", version, "tags", tags, "locale", locale));
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Summoner spell ID
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param tags (optional) Tags to return additional data. Only id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public SummonerSpell getSummonerSpellById(final Region region, final int id, final String version,
      final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellById(region, id, version, tags, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Summoner spell ID
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   * @param tags (optional) Tags to return additional data. Only id, key, name, description, and summonerLevel are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
   */
  public CompletableFuture<SummonerSpell> getSummonerSpellByIdAsync(final Region region,
      final int id, final String version, final List<String> tags) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellByIdAsync(region, id, version, tags, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Summoner spell ID
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public SummonerSpell getSummonerSpellById(final Region region, final int id,
      final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellById(region, id, version, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Summoner spell ID
   * @param version (optional) Data Dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
   */
  public CompletableFuture<SummonerSpell> getSummonerSpellByIdAsync(final Region region,
      final int id, final String version) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellByIdAsync(region, id, version, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Summoner spell ID
   */
  public SummonerSpell getSummonerSpellById(final Region region, final int id) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellById(region, id, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getSummonerSpellById">Link to Portal</a><br>
   * Implementation Notes:<br>
   * Not all data specified below is returned by default. See the tags parameter for more information.
   * @param region Region to execute against.
   * @param id (required) Summoner spell ID
   */
  public CompletableFuture<SummonerSpell> getSummonerSpellByIdAsync(final Region region,
      final int id) {
    // This method is automatically generated and should not be modified directly.
    return this.getSummonerSpellByIdAsync(region, id, null, null, null);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getVersions">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public List<String> getVersions(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/versions";
    Type type = new TypeToken<List<String>>() {
    }.getType();
    return riotApi.getBasic(url, region, type, Collections.emptyList());
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getVersions">Link to Portal</a><br>
   * @param region Region to execute against.
   */
  public CompletableFuture<List<String>> getVersionsAsync(final Region region) {
    // This method is automatically generated and should not be modified directly.
    String url = "/lol/static-data/v3/versions";
    Type type = new TypeToken<List<String>>() {
    }.getType();
    return riotApi.getBasicAsync(url, region, type, Collections.emptyList());
  }
}
