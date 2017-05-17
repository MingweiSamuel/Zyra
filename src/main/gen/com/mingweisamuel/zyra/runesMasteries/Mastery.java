package com.mingweisamuel.zyra.runesMasteries;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Mastery.<br><br>
 *
 * This object contains mastery information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#runes-masteries-v1.4/GET_getMasteryPagesBySummonerIds">Riot API reference</a> on Mon May 15 17:36:46 PDT 2017. */
public class Mastery implements Serializable {
  /**
   * Mastery ID. For static information correlating to masteries, please refer to the LoL Static Data API. */
  public final int id;

  /**
   * Mastery rank (i.e., the number of points put into this mastery). */
  public final int rank;

  public Mastery(final int id, final int rank) {
    this.id = id;
    this.rank = rank;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Mastery)) return false;
    final Mastery other = (Mastery) obj;
    return true
        && Objects.equal(id, other.id)
        && Objects.equal(rank, other.rank);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        id,
        rank);}
}
