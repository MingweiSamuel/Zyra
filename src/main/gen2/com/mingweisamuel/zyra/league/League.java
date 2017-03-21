package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * This object contains league information..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#league-v2.5/GET_getChallengerLeagues">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class League {
  /**
   * The league's queue type. */
  public final String queue;

  /**
   * The league's tier. */
  public final String tier;

  /**
   * Specifies the relevant participant that is a member of this league (i.e., a requested summoner ID, a requested team ID, or the ID of a team to which one of the requested summoners belongs). Only present when full league is requested so that participant's entry can be identified. Not present when individual entry is requested. */
  public final String participantId;

  /**
   * This name is an internal place-holder name only. Display and localization of names in the game client are handled client-side. */
  public final String name;

  /**
   * The requested league entries. */
  public final List<LeagueEntry> entries;

  public League(final String queue, final String tier, final String participantId,
      final String name, final List<LeagueEntry> entries) {
    this.queue = queue;
    this.tier = tier;
    this.participantId = participantId;
    this.name = name;
    this.entries = entries;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof League)) return false;
    final League other = (League) obj;
    return true
        && Objects.equal(queue, other.queue)
        && Objects.equal(tier, other.tier)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(name, other.name)
        && Objects.equal(entries, other.entries);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        queue,
        tier,
        participantId,
        name,
        entries);}
}
