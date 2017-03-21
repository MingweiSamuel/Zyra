package com.mingweisamuel.zyra.runesMasteries;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains mastery information..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#runes-masteries-v1.4/GET_getMasteryPagesBySummonerIds">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Mastery {
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
    if (!(obj instanceof RunesMasteries)) return false;
    final RunesMasteries other = (RunesMasteries) obj;
    return true
        && Objects.equal(id, other.id)
        && Objects.equal(rank, other.rank);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        id,
        rank);}
}
