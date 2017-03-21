package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Rune.<br /><br />
 *
 * This object contains rune information.<br /><br />
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:58:35 PDT 2017. */
public class Rune implements Serializable {
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
    if (!(obj instanceof Rune)) return false;
    final Rune other = (Rune) obj;
    return true
        && Objects.equal(runeId, other.runeId)
        && Objects.equal(rank, other.rank);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        runeId,
        rank);}
}
