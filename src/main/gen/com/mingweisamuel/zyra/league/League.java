package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * League - This object contains league information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version league-v2.5 */
public class League {
  /**
   * The requested league entries. */
  public final List<LeagueEntry> entries;

  /**
   * This name is an internal place-holder name only. Display and localization of names in the game client are handled client-side. */
  public final String name;

  /**
   * Specifies the relevant participant that is a member of this league (i.e., a requested summoner ID, a requested team ID, or the ID of a team to which one of the requested summoners belongs). Only present when full league is requested so that participant's entry can be identified. Not present when individual entry is requested. */
  public final String participantId;

  /**
   * The league's queue type. (Legal values: RANKED_FLEX_SR, RANKED_FLEX_TT, RANKED_SOLO_5x5, RANKED_TEAM_3x3, RANKED_TEAM_5x5) */
  public final String queue;

  /**
   * The league's tier. (Legal values: CHALLENGER, MASTER, DIAMOND, PLATINUM, GOLD, SILVER, BRONZE)
   *
   * The value of this variable will never be {@link com.mingweisamuel.zyra.enums.Tier#UNRANKED}.
   *
   * @see com.mingweisamuel.zyra.enums.Tier */
  public final String tier;

  public League(final List<LeagueEntry> entries, final String name, final String participantId,
      final String queue, final String tier) {
    this.entries = entries;
    this.name = name;
    this.participantId = participantId;
    this.queue = queue;
    this.tier = tier;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof League)) return false;
    final League other = (League) obj;
    return true
        && Objects.equal(entries, other.entries)
        && Objects.equal(name, other.name)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(queue, other.queue)
        && Objects.equal(tier, other.tier);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        entries,
        name,
        participantId,
        queue,
        tier);}
}
