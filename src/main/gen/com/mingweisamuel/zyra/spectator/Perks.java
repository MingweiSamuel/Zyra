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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Riot API reference</a>. */
public class Perks implements Serializable {
  /**
   * Primary runes path */
  public final long perkStyle;

  /**
   * IDs of the perks/runes assigned. */
  public final List<Long> perkIds;

  /**
   * Secondary runes path */
  public final long perkSubStyle;

  public Perks(final long perkStyle, final List<Long> perkIds, final long perkSubStyle) {
    this.perkStyle = perkStyle;
    this.perkIds = perkIds;
    this.perkSubStyle = perkSubStyle;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Perks)) return false;
    final Perks other = (Perks) obj;
    return true
        && Objects.equal(perkStyle, other.perkStyle)
        && Objects.equal(perkIds, other.perkIds)
        && Objects.equal(perkSubStyle, other.perkSubStyle);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        perkStyle,
        perkIds,
        perkSubStyle);}
}
