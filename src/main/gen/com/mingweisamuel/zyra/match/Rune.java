package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Rune.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Riot API reference</a> on Wed May 17 21:34:50 PDT 2017. */
public class Rune implements Serializable {
  public final int runeId;

  public final int rank;

  public Rune(final int runeId, final int rank) {
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
