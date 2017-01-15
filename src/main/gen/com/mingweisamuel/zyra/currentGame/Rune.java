package com.mingweisamuel.zyra.currentGame;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * Rune
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version current-game-v1.0 */
public class Rune {
  /**
   * The count of this rune used by the participant */
  public final int count;

  /**
   * The ID of the rune */
  public final long runeId;

  public Rune(final int count, final long runeId) {
    this.count = count;
    this.runeId = runeId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Rune)) return false;
    final Rune other = (Rune) obj;
    return true
        && Objects.equal(count, other.count)
        && Objects.equal(runeId, other.runeId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        count,
        runeId);}
}
