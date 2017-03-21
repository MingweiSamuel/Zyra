package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * This object contains meta data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getItemList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class MetaData {
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
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
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
