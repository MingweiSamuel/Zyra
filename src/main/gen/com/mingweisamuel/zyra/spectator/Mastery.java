package com.mingweisamuel.zyra.spectator;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Mastery.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Riot API reference</a> on Wed May 17 19:48:11 PDT 2017. */
public class Mastery implements Serializable {
  /**
   * The ID of the mastery */
  public final long masteryId;

  /**
   * The number of points put into this mastery by the user */
  public final int rank;

  public Mastery(final long masteryId, final int rank) {
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
