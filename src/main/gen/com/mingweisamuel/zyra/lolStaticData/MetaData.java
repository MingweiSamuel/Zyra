package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * MetaData - This object contains meta data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class MetaData {
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
    if (obj == null) return false;
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
