package com.mingweisamuel.zyra.game;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains player information..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#game-v1.3/GET_getRecentGames">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Player {
  /**
   * Team id associated with player. */
  public final int teamId;

  /**
   * Champion id associated with player. */
  public final int championId;

  /**
   * Summoner id associated with player. */
  public final long summonerId;

  public Player(final int teamId, final int championId, final long summonerId) {
    this.teamId = teamId;
    this.championId = championId;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Game)) return false;
    final Game other = (Game) obj;
    return true
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(championId, other.championId)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        teamId,
        championId,
        summonerId);}
}
