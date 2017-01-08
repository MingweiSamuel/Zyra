package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;
import java.util.Map;

/**
 * ItemList - This object contains item list data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version lol-static-data-v1.2 */
public class ItemList {
  public BasicData basic;

  public Map<String, Item> data;

  public List<Group> groups;

  public List<ItemTree> tree;

  public String type;

  public String version;
}
