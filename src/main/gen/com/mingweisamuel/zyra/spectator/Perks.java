package com.mingweisamuel.zyra.spectator;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * Perks.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Perks implements Serializable {
  /**
   * IDs of the perks/runes assigned. */
  public final List<Long> perkIds;

  /**
   * Primary runes path */
  public final long perkStyle;

  /**
   * Secondary runes path */
  public final long perkSubStyle;

  public Perks(final List<Long> perkIds, final long perkStyle, final long perkSubStyle) {
    this.perkIds = perkIds;
    this.perkStyle = perkStyle;
    this.perkSubStyle = perkSubStyle;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Perks)) return false;
    final Perks other = (Perks) obj;
    return true
        && Objects.equal(perkIds, other.perkIds)
        && Objects.equal(perkStyle, other.perkStyle)
        && Objects.equal(perkSubStyle, other.perkSubStyle);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        perkIds,
        perkStyle,
        perkSubStyle);}
}
