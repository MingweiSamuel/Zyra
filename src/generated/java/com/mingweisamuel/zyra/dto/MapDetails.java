package com.mingweisamuel.zyra.dto;

import java.lang.Long;
import java.lang.String;
import java.util.List;

/**
 * MapDetails - This object contains map details data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}. */
public class MapDetails {
  public Image image;

  public long mapId;

  public String mapName;

  public List<Long> unpurchasableItemList;
}
