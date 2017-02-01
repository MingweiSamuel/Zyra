package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Rune - This object contains rune information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Rune implements Serializable {
  /**
   * Rune rank */
  public final long rank;

  /**
   * Rune ID */
  public final long runeId;

  public Rune(final long rank, final long runeId) {
    this.rank = rank;
    this.runeId = runeId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Rune)) return false;
    final Rune other = (Rune) obj;
    return true
        && Objects.equal(rank, other.rank)
        && Objects.equal(runeId, other.runeId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        rank,
        runeId);}
}
