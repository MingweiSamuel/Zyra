package com.mingweisamuel.zyra;

import com.google.gson.reflect.TypeToken;
import com.mingweisamuel.zyra.dto.Champion;
import com.mingweisamuel.zyra.dto.ChampionList;
import com.mingweisamuel.zyra.dto.Item;
import com.mingweisamuel.zyra.dto.ItemList;
import com.mingweisamuel.zyra.dto.LanguageStrings;
import com.mingweisamuel.zyra.dto.MapData;
import com.mingweisamuel.zyra.dto.Mastery;
import com.mingweisamuel.zyra.dto.MasteryList;
import com.mingweisamuel.zyra.dto.Realm;
import com.mingweisamuel.zyra.dto.Rune;
import com.mingweisamuel.zyra.dto.RuneList;
import com.mingweisamuel.zyra.dto.SummonerSpell;
import com.mingweisamuel.zyra.dto.SummonerSpellList;
import com.mingweisamuel.zyra.enums.Region;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version lol-static-data-v1.2 */
public class LolStaticDataEndpoints {
  private static final Type GET_CHAMPIONS__TYPE = ChampionList.class;

  private static final String GET_CHAMPIONS__URL = "/api/lol/static-data/%1s/v1.2/champion";

  private static final Type GET_CHAMPION__TYPE = Champion.class;

  private static final String GET_CHAMPION__URL = "/api/lol/static-data/%1s/v1.2/champion/%2s";

  private static final Type GET_ITEMS__TYPE = ItemList.class;

  private static final String GET_ITEMS__URL = "/api/lol/static-data/%1s/v1.2/item";

  private static final Type GET_ITEM__TYPE = Item.class;

  private static final String GET_ITEM__URL = "/api/lol/static-data/%1s/v1.2/item/%2s";

  private static final Type GET_LANGUAGE_STRINGS__TYPE = LanguageStrings.class;

  private static final String GET_LANGUAGE_STRINGS__URL = "/api/lol/static-data/%1s/v1.2/language-strings";

  private static final Type GET_LANGUAGES__TYPE = new TypeToken<List<String>>() {
  }.getType();

  private static final String GET_LANGUAGES__URL = "/api/lol/static-data/%1s/v1.2/languages";

  private static final Type GET_MAPS__TYPE = MapData.class;

  private static final String GET_MAPS__URL = "/api/lol/static-data/%1s/v1.2/map";

  private static final Type GET_MASTERIES__TYPE = MasteryList.class;

  private static final String GET_MASTERIES__URL = "/api/lol/static-data/%1s/v1.2/mastery";

  private static final Type GET_MASTERY__TYPE = Mastery.class;

  private static final String GET_MASTERY__URL = "/api/lol/static-data/%1s/v1.2/mastery/%2s";

  private static final Type GET_REALMS__TYPE = Realm.class;

  private static final String GET_REALMS__URL = "/api/lol/static-data/%1s/v1.2/realm";

  private static final Type GET_RUNES__TYPE = RuneList.class;

  private static final String GET_RUNES__URL = "/api/lol/static-data/%1s/v1.2/rune";

  private static final Type GET_RUNE__TYPE = Rune.class;

  private static final String GET_RUNE__URL = "/api/lol/static-data/%1s/v1.2/rune/%2s";

  private static final Type GET_SUMMONER_SPELLS__TYPE = SummonerSpellList.class;

  private static final String GET_SUMMONER_SPELLS__URL = "/api/lol/static-data/%1s/v1.2/summoner-spell";

  private static final Type GET_SUMMONER_SPELL__TYPE = SummonerSpell.class;

  private static final String GET_SUMMONER_SPELL__URL = "/api/lol/static-data/%1s/v1.2/summoner-spell/%2s";

  private static final Type GET_VERSIONS__TYPE = new TypeToken<List<String>>() {
  }.getType();

  private static final String GET_VERSIONS__URL = "/api/lol/static-data/%1s/v1.2/versions";

  private final RiotApi riotApi;

  public LolStaticDataEndpoints(final RiotApi riotApi) {
    this.riotApi = riotApi;}

  public ChampionList getChampions(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_CHAMPIONS__URL, region), region, input, null, GET_CHAMPIONS__TYPE);}

  public Champion getChampion(final Region region, final int id) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_CHAMPION__URL, region), region, input, null, GET_CHAMPION__TYPE);}

  public ItemList getItems(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_ITEMS__URL, region), region, input, null, GET_ITEMS__TYPE);}

  public Item getItem(final Region region, final int id) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_ITEM__URL, region), region, input, null, GET_ITEM__TYPE);}

  public LanguageStrings getLanguageStrings(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_LANGUAGE_STRINGS__URL, region), region, input, null, GET_LANGUAGE_STRINGS__TYPE);}

  public List<String> getLanguages(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_LANGUAGES__URL, region), region, input, null, GET_LANGUAGES__TYPE);}

  public MapData getMaps(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_MAPS__URL, region), region, input, null, GET_MAPS__TYPE);}

  public MasteryList getMasteries(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_MASTERIES__URL, region), region, input, null, GET_MASTERIES__TYPE);}

  public Mastery getMastery(final Region region, final int id) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_MASTERY__URL, region), region, input, null, GET_MASTERY__TYPE);}

  public Realm getRealms(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_REALMS__URL, region), region, input, null, GET_REALMS__TYPE);}

  public RuneList getRunes(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_RUNES__URL, region), region, input, null, GET_RUNES__TYPE);}

  public Rune getRune(final Region region, final int id) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_RUNE__URL, region), region, input, null, GET_RUNE__TYPE);}

  public SummonerSpellList getSummonerSpells(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_SUMMONER_SPELLS__URL, region), region, input, null, GET_SUMMONER_SPELLS__TYPE);}

  public SummonerSpell getSummonerSpell(final Region region, final int id) throws
      ExecutionException {
    return riotApi.getMap2(String.format(GET_SUMMONER_SPELL__URL, region), region, input, null, GET_SUMMONER_SPELL__TYPE);}

  public List<String> getVersions(final Region region) throws ExecutionException {
    return riotApi.getMap2(String.format(GET_VERSIONS__URL, region), region, input, null, GET_VERSIONS__TYPE);}
}
