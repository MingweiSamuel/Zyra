package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import com.mingweisamuel.zyra.lolStaticData.MapDetails;
import java.io.Serializable;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * MapData.<br><br>
 *
 * This object contains map data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getMapData">Riot API reference</a> on Tue May 16 19:55:45 PDT 2017. */
public class MapData implements Serializable {
  public final Map<Long, MapDetails> data;

  public final String version;

  public final String type;

  public MapData(final Map<Long, MapDetails> data, final String version, final String type) {
    this.data = data;
    this.version = version;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MapData)) return false;
    final MapData other = (MapData) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(version, other.version)
        && Objects.equal(type, other.type);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        version,
        type);}
}
