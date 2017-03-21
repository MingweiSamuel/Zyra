package com.mingweisamuel.zyra.currentGame;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * .<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#current-game-v1.0/GET_getCurrentGameInfoBySummoner">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Mastery {
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
    if (!(obj instanceof CurrentGame)) return false;
    final CurrentGame other = (CurrentGame) obj;
    return true
        && Objects.equal(masteryId, other.masteryId)
        && Objects.equal(rank, other.rank);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        masteryId,
        rank);}
}
