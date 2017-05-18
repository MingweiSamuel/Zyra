package com.mingweisamuel.zyra.spectator;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Rune.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Riot API reference</a> on Wed May 17 20:12:12 PDT 2017. */
public class Rune implements Serializable {
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
