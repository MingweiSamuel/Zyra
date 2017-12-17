package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * TeamBans.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class TeamBans implements Serializable {
  public final int championId;

  public final int pickTurn;

  public TeamBans(final int championId, final int pickTurn) {
    this.championId = championId;
    this.pickTurn = pickTurn;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof TeamBans)) return false;
    final TeamBans other = (TeamBans) obj;
    return true
        && Objects.equal(championId, other.championId)
        && Objects.equal(pickTurn, other.pickTurn);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        championId,
        pickTurn);}
}
