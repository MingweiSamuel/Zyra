package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * LeagueList.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class LeagueList implements Serializable {
  public final List<LeaguePosition> entries;

  public final String leagueId;

  public final String name;

  public final String queue;

  public final String tier;

  public LeagueList(final List<LeaguePosition> entries, final String leagueId, final String name,
      final String queue, final String tier) {
    this.entries = entries;
    this.leagueId = leagueId;
    this.name = name;
    this.queue = queue;
    this.tier = tier;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LeagueList)) return false;
    final LeagueList other = (LeagueList) obj;
    return true
        && Objects.equal(entries, other.entries)
        && Objects.equal(leagueId, other.leagueId)
        && Objects.equal(name, other.name)
        && Objects.equal(queue, other.queue)
        && Objects.equal(tier, other.tier);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        entries,
        leagueId,
        name,
        queue,
        tier);}
}
