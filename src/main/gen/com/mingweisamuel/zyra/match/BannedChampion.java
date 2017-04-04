package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * BannedChampion.<br><br>
 *
 * This object contains information about banned champions.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class BannedChampion implements Serializable {
  /**
   * Turn during which the champion was banned */
  public final int pickTurn;

  /**
   * Banned champion ID */
  public final int championId;

  public BannedChampion(final int pickTurn, final int championId) {
    this.pickTurn = pickTurn;
    this.championId = championId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof BannedChampion)) return false;
    final BannedChampion other = (BannedChampion) obj;
    return true
        && Objects.equal(pickTurn, other.pickTurn)
        && Objects.equal(championId, other.championId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        pickTurn,
        championId);}
}
