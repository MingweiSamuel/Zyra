package com.mingweisamuel.zyra.matchList;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * This object contains match reference information.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#matchlist-v2.2/GET_getMatchList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class MatchReference {
  public final String lane;

  public final long champion;

  public final String platformId;

  public final long timestamp;

  public final String region;

  public final long matchId;

  public final String queue;

  public final String role;

  public final String season;

  public MatchReference(final String lane, final long champion, final String platformId,
      final long timestamp, final String region, final long matchId, final String queue,
      final String role, final String season) {
    this.lane = lane;
    this.champion = champion;
    this.platformId = platformId;
    this.timestamp = timestamp;
    this.region = region;
    this.matchId = matchId;
    this.queue = queue;
    this.role = role;
    this.season = season;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchList)) return false;
    final MatchList other = (MatchList) obj;
    return true
        && Objects.equal(lane, other.lane)
        && Objects.equal(champion, other.champion)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(timestamp, other.timestamp)
        && Objects.equal(region, other.region)
        && Objects.equal(matchId, other.matchId)
        && Objects.equal(queue, other.queue)
        && Objects.equal(role, other.role)
        && Objects.equal(season, other.season);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        lane,
        champion,
        platformId,
        timestamp,
        region,
        matchId,
        queue,
        role,
        season);}
}
