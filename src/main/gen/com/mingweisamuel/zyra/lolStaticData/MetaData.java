package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * MetaData.<br><br>
 *
 * This object contains meta data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class MetaData implements Serializable {
  public final boolean isRune;

  public final String tier;

  public final String type;

  public MetaData(final boolean isRune, final String tier, final String type) {
    this.isRune = isRune;
    this.tier = tier;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MetaData)) return false;
    final MetaData other = (MetaData) obj;
    return true
        && Objects.equal(isRune, other.isRune)
        && Objects.equal(tier, other.tier)
        && Objects.equal(type, other.type);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        isRune,
        tier,
        type);}
}
