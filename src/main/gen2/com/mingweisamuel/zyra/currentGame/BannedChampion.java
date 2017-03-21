package com.mingweisamuel.zyra.currentGame;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * .<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#current-game-v1.0/GET_getCurrentGameInfoBySummoner">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class BannedChampion {
  /**
   * The turn during which the champion was banned */
  public final int pickTurn;

  /**
   * The ID of the banned champion */
  public final long championId;

  /**
   * The ID of the team that banned the champion */
  public final long teamId;

  public BannedChampion(final int pickTurn, final long championId, final long teamId) {
    this.pickTurn = pickTurn;
    this.championId = championId;
    this.teamId = teamId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof CurrentGame)) return false;
    final CurrentGame other = (CurrentGame) obj;
    return true
        && Objects.equal(pickTurn, other.pickTurn)
        && Objects.equal(championId, other.championId)
        && Objects.equal(teamId, other.teamId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        pickTurn,
        championId,
        teamId);}
}
