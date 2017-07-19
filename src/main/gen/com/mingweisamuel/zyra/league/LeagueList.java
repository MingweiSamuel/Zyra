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
  public final String tier;

  public final String queue;

  public final String name;

  public final List<LeagueItem> entries;

  public LeagueList(final String tier, final String queue, final String name,
      final List<LeagueItem> entries) {
    this.tier = tier;
    this.queue = queue;
    this.name = name;
    this.entries = entries;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LeagueList)) return false;
    final LeagueList other = (LeagueList) obj;
    return true
        && Objects.equal(tier, other.tier)
        && Objects.equal(queue, other.queue)
        && Objects.equal(name, other.name)
        && Objects.equal(entries, other.entries);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        tier,
        queue,
        name,
        entries);}
}
