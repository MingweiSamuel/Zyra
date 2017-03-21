package com.mingweisamuel.zyra.currentGame;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * .<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#current-game-v1.0/GET_getCurrentGameInfoBySummoner">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Rune {
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
    if (obj == this) return true;
    if (!(obj instanceof CurrentGame)) return false;
    final CurrentGame other = (CurrentGame) obj;
    return true
        && Objects.equal(count, other.count)
        && Objects.equal(runeId, other.runeId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        count,
        runeId);}
}
