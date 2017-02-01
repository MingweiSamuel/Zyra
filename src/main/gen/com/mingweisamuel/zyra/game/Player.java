package com.mingweisamuel.zyra.game;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Player - This object contains player information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version game-v1.3 */
public class Player implements Serializable {
  /**
   * Champion id associated with player. */
  public final int championId;

  /**
   * Summoner id associated with player. */
  public final long summonerId;

  /**
   * Team id associated with player. */
  public final int teamId;

  public Player(final int championId, final long summonerId, final int teamId) {
    this.championId = championId;
    this.summonerId = summonerId;
    this.teamId = teamId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Player)) return false;
    final Player other = (Player) obj;
    return true
        && Objects.equal(championId, other.championId)
        && Objects.equal(summonerId, other.summonerId)
        && Objects.equal(teamId, other.teamId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        championId,
        summonerId,
        teamId);}
}
