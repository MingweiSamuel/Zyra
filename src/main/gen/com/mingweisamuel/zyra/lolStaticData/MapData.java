package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * MapData - This object contains map data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class MapData implements Serializable {
  public final Map<Long, MapDetails> data;

  public final String type;

  public final String version;

  public MapData(final Map<Long, MapDetails> data, final String type, final String version) {
    this.data = data;
    this.type = type;
    this.version = version;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MapData)) return false;
    final MapData other = (MapData) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(type, other.type)
        && Objects.equal(version, other.version);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        type,
        version);}
}
