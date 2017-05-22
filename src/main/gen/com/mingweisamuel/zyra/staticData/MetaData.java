package com.mingweisamuel.zyra.staticData;

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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getItemList">Riot API reference</a> on Sun May 21 18:03:38 PDT 2017. */
public class MetaData implements Serializable {
  public final String tier;

  public final String type;

  public final boolean isRune;

  public MetaData(final String tier, final String type, final boolean isRune) {
    this.tier = tier;
    this.type = type;
    this.isRune = isRune;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MetaData)) return false;
    final MetaData other = (MetaData) obj;
    return true
        && Objects.equal(tier, other.tier)
        && Objects.equal(type, other.type)
        && Objects.equal(isRune, other.isRune);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        tier,
        type,
        isRune);}
}
