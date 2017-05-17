package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * MatchReference.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Riot API reference</a> on Tue May 16 20:00:39 PDT 2017. */
public class MatchReference implements Serializable {
  public final String lane;

  public final long gameId;

  public final int champion;

  public final String platformId;

  public final int season;

  public final int queue;

  public final String role;

  public final long timestamp;

  public MatchReference(final String lane, final long gameId, final int champion,
      final String platformId, final int season, final int queue, final String role,
      final long timestamp) {
    this.lane = lane;
    this.gameId = gameId;
    this.champion = champion;
    this.platformId = platformId;
    this.season = season;
    this.queue = queue;
    this.role = role;
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchReference)) return false;
    final MatchReference other = (MatchReference) obj;
    return true
        && Objects.equal(lane, other.lane)
        && Objects.equal(gameId, other.gameId)
        && Objects.equal(champion, other.champion)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(season, other.season)
        && Objects.equal(queue, other.queue)
        && Objects.equal(role, other.role)
        && Objects.equal(timestamp, other.timestamp);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        lane,
        gameId,
        champion,
        platformId,
        season,
        queue,
        role,
        timestamp);}
}
