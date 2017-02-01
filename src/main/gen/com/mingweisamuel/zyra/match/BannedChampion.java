package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * BannedChampion - This object contains information about banned champions
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class BannedChampion implements Serializable {
  /**
   * Banned champion ID */
  public final int championId;

  /**
   * Turn during which the champion was banned */
  public final int pickTurn;

  public BannedChampion(final int championId, final int pickTurn) {
    this.championId = championId;
    this.pickTurn = pickTurn;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof BannedChampion)) return false;
    final BannedChampion other = (BannedChampion) obj;
    return true
        && Objects.equal(championId, other.championId)
        && Objects.equal(pickTurn, other.pickTurn);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        championId,
        pickTurn);}
}
