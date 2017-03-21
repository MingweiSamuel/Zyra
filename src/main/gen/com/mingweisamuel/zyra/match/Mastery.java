package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Mastery.<br><br>
 *
 * This object contains mastery information.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 15:10:48 PDT 2017. */
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
