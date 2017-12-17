package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * MatchReference.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class MatchReference implements Serializable {
  public final int champion;

  public final long gameId;

  public final String lane;

  public final String platformId;

  public final int queue;

  public final String role;

  public final int season;

  public final long timestamp;

  public MatchReference(final int champion, final long gameId, final String lane,
      final String platformId, final int queue, final String role, final int season,
      final long timestamp) {
    this.champion = champion;
    this.gameId = gameId;
    this.lane = lane;
    this.platformId = platformId;
    this.queue = queue;
    this.role = role;
    this.season = season;
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchReference)) return false;
    final MatchReference other = (MatchReference) obj;
    return true
        && Objects.equal(champion, other.champion)
        && Objects.equal(gameId, other.gameId)
        && Objects.equal(lane, other.lane)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(queue, other.queue)
        && Objects.equal(role, other.role)
        && Objects.equal(season, other.season)
        && Objects.equal(timestamp, other.timestamp);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        champion,
        gameId,
        lane,
        platformId,
        queue,
        role,
        season,
        timestamp);}
}
