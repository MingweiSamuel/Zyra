package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * TeamBans.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Riot API reference</a>. */
public class TeamBans implements Serializable {
  public final int pickTurn;

  public final int championId;

  public TeamBans(final int pickTurn, final int championId) {
    this.pickTurn = pickTurn;
    this.championId = championId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof TeamBans)) return false;
    final TeamBans other = (TeamBans) obj;
    return true
        && Objects.equal(pickTurn, other.pickTurn)
        && Objects.equal(championId, other.championId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        pickTurn,
        championId);}
}
