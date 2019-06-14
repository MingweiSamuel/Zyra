package com.mingweisamuel.zyra.matchV4;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Participant.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Participant implements Serializable {
  public final int championId;

  /**
   * Highest ranked tier achieved for the previous season in a specific subset of queueIds, if any, otherwise null. Used to display border in game loading screen. Please refer to the Ranked Info documentation.
   *              (Legal values:  CHALLENGER,  MASTER,  DIAMOND,  PLATINUM,  GOLD,  SILVER,  BRONZE,  UNRANKED) */
  public final String highestAchievedSeasonTier;

  /**
   * List of legacy Mastery information. Not included for matches played with Runes Reforged. */
  public final List<Mastery> masteries;

  public final int participantId;

  /**
   * List of legacy Rune information. Not included for matches played with Runes Reforged. */
  public final List<Rune> runes;

  /**
   * First Summoner Spell id. */
  public final int spell1Id;

  /**
   * Second Summoner Spell id. */
  public final int spell2Id;

  /**
   * Participant statistics. */
  public final ParticipantStats stats;

  /**
   * 100 for blue side. 200 for red side. */
  public final int teamId;

  /**
   * Participant timeline data. */
  public final ParticipantTimeline timeline;

  public Participant(final int championId, final String highestAchievedSeasonTier,
      final List<Mastery> masteries, final int participantId, final List<Rune> runes,
      final int spell1Id, final int spell2Id, final ParticipantStats stats, final int teamId,
      final ParticipantTimeline timeline) {
    this.championId = championId;
    this.highestAchievedSeasonTier = highestAchievedSeasonTier;
    this.masteries = masteries;
    this.participantId = participantId;
    this.runes = runes;
    this.spell1Id = spell1Id;
    this.spell2Id = spell2Id;
    this.stats = stats;
    this.teamId = teamId;
    this.timeline = timeline;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Participant)) return false;
    final Participant other = (Participant) obj;
    return true
        && Objects.equal(championId, other.championId)
        && Objects.equal(highestAchievedSeasonTier, other.highestAchievedSeasonTier)
        && Objects.equal(masteries, other.masteries)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(runes, other.runes)
        && Objects.equal(spell1Id, other.spell1Id)
        && Objects.equal(spell2Id, other.spell2Id)
        && Objects.equal(stats, other.stats)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(timeline, other.timeline);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        championId,
        highestAchievedSeasonTier,
        masteries,
        participantId,
        runes,
        spell1Id,
        spell2Id,
        stats,
        teamId,
        timeline);}
}
