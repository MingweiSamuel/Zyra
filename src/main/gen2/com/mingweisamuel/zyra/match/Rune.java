package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains rune information.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Rune {
  /**
   * Rune ID */
  public final long runeId;

  /**
   * Rune rank */
  public final long rank;

  public Rune(final long runeId, final long rank) {
    this.runeId = runeId;
    this.rank = rank;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(runeId, other.runeId)
        && Objects.equal(rank, other.rank);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        runeId,
        rank);}
}
