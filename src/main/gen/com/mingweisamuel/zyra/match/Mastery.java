package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Mastery - This object contains mastery information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Mastery implements Serializable {
  /**
   * Mastery ID */
  public final long masteryId;

  /**
   * Mastery rank */
  public final long rank;

  public Mastery(final long masteryId, final long rank) {
    this.masteryId = masteryId;
    this.rank = rank;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Mastery)) return false;
    final Mastery other = (Mastery) obj;
    return true
        && Objects.equal(masteryId, other.masteryId)
        && Objects.equal(rank, other.rank);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        masteryId,
        rank);}
}
