package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * This object contains map details data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getMap">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class MapDetails {
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
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
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
