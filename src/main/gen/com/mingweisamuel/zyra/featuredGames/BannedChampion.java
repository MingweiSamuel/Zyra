package com.mingweisamuel.zyra.featuredGames;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * BannedChampion
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version featured-games-v1.0 */
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
