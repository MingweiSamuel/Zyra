package com.mingweisamuel.zyra.matchList;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * MatchReference - This object contains match reference information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version matchlist-v2.2 */
public class MatchReference {
  public final long champion;

  /**
   * Legal values: MID, MIDDLE, TOP, JUNGLE, BOT, BOTTOM */
  public final String lane;

  public final long matchId;

  public final String platformId;

  /**
   * Legal values: RANKED_FLEX_SR, RANKED_SOLO_5x5, RANKED_TEAM_3x3, RANKED_TEAM_5x5, TEAM_BUILDER_DRAFT_RANKED_5x5, TEAM_BUILDER_RANKED_SOLO */
  public final String queue;

  /**
   * Legal values: br, eune, euw, jp, kr, lan, las, na, oce, ru, tr */
  public final String region;

  /**
   * Legal values: DUO, NONE, SOLO, DUO_CARRY, DUO_SUPPORT */
  public final String role;

  /**
   * Legal values: PRESEASON3, SEASON3, PRESEASON2014, SEASON2014, PRESEASON2015, SEASON2015, PRESEASON2016, SEASON2016, PRESEASON2017, SEASON2017 */
  public final String season;

  public final long timestamp;

  public MatchReference(final long champion, final String lane, final long matchId,
      final String platformId, final String queue, final String region, final String role,
      final String season, final long timestamp) {
    this.champion = champion;
    this.lane = lane;
    this.matchId = matchId;
    this.platformId = platformId;
    this.queue = queue;
    this.region = region;
    this.role = role;
    this.season = season;
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof MatchReference)) return false;
    final MatchReference other = (MatchReference) obj;
    return true
        && Objects.equal(champion, other.champion)
        && Objects.equal(lane, other.lane)
        && Objects.equal(matchId, other.matchId)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(queue, other.queue)
        && Objects.equal(region, other.region)
        && Objects.equal(role, other.role)
        && Objects.equal(season, other.season)
        && Objects.equal(timestamp, other.timestamp);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        champion,
        lane,
        matchId,
        platformId,
        queue,
        region,
        role,
        season,
        timestamp);}
}
