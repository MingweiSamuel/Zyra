package com.mingweisamuel.zyra.dto;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;

/**
 * Item - This object contains item data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class Item {
  public String colloq;

  public boolean consumeOnFull;

  public boolean consumed;

  public int depth;

  public String description;

  public Map<String, String> effect;

  public List<String> from;

  /**
   * Data Dragon includes the gold field for basic data, which is shared by both rune and item. However, only items have a gold field on them, representing their gold cost in the store. Since runes are not sold in the store, they have no gold cost. */
  public Gold gold;

  public String group;

  public boolean hideFromAll;

  public int id;

  public Image image;

  public boolean inStore;

  public List<String> into;

  public Map<String, Boolean> maps;

  public String name;

  public String plaintext;

  public String requiredChampion;

  public MetaData rune;

  public String sanitizedDescription;

  public int specialRecipe;

  public int stacks;

  public BasicDataStats stats;

  public List<String> tags;
}
