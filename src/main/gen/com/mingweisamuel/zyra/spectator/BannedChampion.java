package com.mingweisamuel.zyra.spectator;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * BannedChampion.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class BannedChampion implements Serializable {
  /**
   * The ID of the banned champion */
  public final int championId;

  /**
   * The turn during which the champion was banned */
  public final int pickTurn;

  /**
   * The ID of the team that banned the champion */
  public final long teamId;

  public BannedChampion(final int championId, final int pickTurn, final long teamId) {
    this.championId = championId;
    this.pickTurn = pickTurn;
    this.teamId = teamId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof BannedChampion)) return false;
    final BannedChampion other = (BannedChampion) obj;
    return true
        && Objects.equal(championId, other.championId)
        && Objects.equal(pickTurn, other.pickTurn)
        && Objects.equal(teamId, other.teamId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        championId,
        pickTurn,
        teamId);}
}
