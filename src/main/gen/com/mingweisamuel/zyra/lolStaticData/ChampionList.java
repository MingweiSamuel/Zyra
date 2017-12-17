package com.mingweisamuel.zyra.lolStaticData;

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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ChampionList implements Serializable {
  public final Map<String, Champion> data;

  public final String format;

  public final Map<String, String> keys;

  public final String type;

  public final String version;

  public ChampionList(final Map<String, Champion> data, final String format,
      final Map<String, String> keys, final String type, final String version) {
    this.data = data;
    this.format = format;
    this.keys = keys;
    this.type = type;
    this.version = version;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ChampionList)) return false;
    final ChampionList other = (ChampionList) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(format, other.format)
        && Objects.equal(keys, other.keys)
        && Objects.equal(type, other.type)
        && Objects.equal(version, other.version);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        format,
        keys,
        type,
        version);}
}
