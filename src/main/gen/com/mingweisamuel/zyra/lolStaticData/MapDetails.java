package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * MapDetails - This object contains map details data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class MapDetails {
  public final Image image;

  public final long mapId;

  public final String mapName;

  public final List<Long> unpurchasableItemList;

  public MapDetails(final Image image, final long mapId, final String mapName,
      final List<Long> unpurchasableItemList) {
    this.image = image;
    this.mapId = mapId;
    this.mapName = mapName;
    this.unpurchasableItemList = unpurchasableItemList;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof MapDetails)) return false;
    final MapDetails other = (MapDetails) obj;
    return true
        && Objects.equal(image, other.image)
        && Objects.equal(mapId, other.mapId)
        && Objects.equal(mapName, other.mapName)
        && Objects.equal(unpurchasableItemList, other.unpurchasableItemList);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        image,
        mapId,
        mapName,
        unpurchasableItemList);}
}
