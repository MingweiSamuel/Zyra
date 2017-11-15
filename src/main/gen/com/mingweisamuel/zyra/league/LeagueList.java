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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getChallengerLeague">Riot API reference</a>. */
public class LeagueList implements Serializable {
  public final String leagueId;

  public final String tier;

  public final List<LeagueItem> entries;

  public final String queue;

  public final String name;

  public LeagueList(final String leagueId, final String tier, final List<LeagueItem> entries,
      final String queue, final String name) {
    this.leagueId = leagueId;
    this.tier = tier;
    this.entries = entries;
    this.queue = queue;
    this.name = name;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LeagueList)) return false;
    final LeagueList other = (LeagueList) obj;
    return true
        && Objects.equal(leagueId, other.leagueId)
        && Objects.equal(tier, other.tier)
        && Objects.equal(entries, other.entries)
        && Objects.equal(queue, other.queue)
        && Objects.equal(name, other.name);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        leagueId,
        tier,
        entries,
        queue,
        name);}
}
