package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Participant.<br><br>
 *
 * This object contains match participant information.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class Participant implements Serializable {
  /**
   * Participant statistics */
  public final ParticipantStats stats;

  /**
   * Participant ID */
  public final int participantId;

  /**
   * List of rune information */
  public final List<Rune> runes;

  /**
   * Timeline data. Delta fields refer to values for the specified period (e.g., the gold per minute over the first 10 minutes of the game versus the second 20 minutes of the game. Diffs fields refer to the deltas versus the calculated lane opponent(s). */
  public final ParticipantTimeline timeline;

  /**
   * List of mastery information */
  public final List<Mastery> masteries;

  /**
   * Second summoner spell ID */
  public final int spell2Id;

  /**
   * Team ID */
  public final int teamId;

  /**
   * Highest ranked tier achieved for the previous season, if any, otherwise null. Used to display border in game loading screen. */
  public final String highestAchievedSeasonTier;

  /**
   * First summoner spell ID */
  public final int spell1Id;

  /**
   * Champion ID */
  public final int championId;

  public Participant(final ParticipantStats stats, final int participantId, final List<Rune> runes,
      final ParticipantTimeline timeline, final List<Mastery> masteries, final int spell2Id,
      final int teamId, final String highestAchievedSeasonTier, final int spell1Id,
      final int championId) {
    this.stats = stats;
    this.participantId = participantId;
    this.runes = runes;
    this.timeline = timeline;
    this.masteries = masteries;
    this.spell2Id = spell2Id;
    this.teamId = teamId;
    this.highestAchievedSeasonTier = highestAchievedSeasonTier;
    this.spell1Id = spell1Id;
    this.championId = championId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Participant)) return false;
    final Participant other = (Participant) obj;
    return true
        && Objects.equal(stats, other.stats)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(runes, other.runes)
        && Objects.equal(timeline, other.timeline)
        && Objects.equal(masteries, other.masteries)
        && Objects.equal(spell2Id, other.spell2Id)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(highestAchievedSeasonTier, other.highestAchievedSeasonTier)
        && Objects.equal(spell1Id, other.spell1Id)
        && Objects.equal(championId, other.championId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        stats,
        participantId,
        runes,
        timeline,
        masteries,
        spell2Id,
        teamId,
        highestAchievedSeasonTier,
        spell1Id,
        championId);}
}
