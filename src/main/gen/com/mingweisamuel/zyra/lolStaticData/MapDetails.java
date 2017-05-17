package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * MapDetails.<br><br>
 *
 * This object contains map details data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getMap">Riot API reference</a> on Mon May 15 17:36:46 PDT 2017. */
public class MapDetails implements Serializable {
  public final String mapName;

  public final Image image;

  public final long mapId;

  public final List<Long> unpurchasableItemList;

  public MapDetails(final String mapName, final Image image, final long mapId,
      final List<Long> unpurchasableItemList) {
    this.mapName = mapName;
    this.image = image;
    this.mapId = mapId;
    this.unpurchasableItemList = unpurchasableItemList;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MapDetails)) return false;
    final MapDetails other = (MapDetails) obj;
    return true
        && Objects.equal(mapName, other.mapName)
        && Objects.equal(image, other.image)
        && Objects.equal(mapId, other.mapId)
        && Objects.equal(unpurchasableItemList, other.unpurchasableItemList);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        mapName,
        image,
        mapId,
        unpurchasableItemList);}
}
