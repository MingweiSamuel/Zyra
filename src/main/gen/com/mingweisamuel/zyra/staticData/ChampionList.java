package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * ChampionList.<br><br>
 *
 * This object contains champion list data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getChampionList">Riot API reference</a> on Wed May 17 20:12:12 PDT 2017. */
public class ChampionList implements Serializable {
  public final Map<String, String> keys;

  public final Map<String, Champion> data;

  public final String version;

  public final String type;

  public final String format;

  public ChampionList(final Map<String, String> keys, final Map<String, Champion> data,
      final String version, final String type, final String format) {
    this.keys = keys;
    this.data = data;
    this.version = version;
    this.type = type;
    this.format = format;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ChampionList)) return false;
    final ChampionList other = (ChampionList) obj;
    return true
        && Objects.equal(keys, other.keys)
        && Objects.equal(data, other.data)
        && Objects.equal(version, other.version)
        && Objects.equal(type, other.type)
        && Objects.equal(format, other.format);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        keys,
        data,
        version,
        type,
        format);}
}
