package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Participant - This object contains match participant information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Participant {
  /**
   * Champion ID */
  public final int championId;

  /**
   * Highest ranked tier achieved for the previous season, if any, otherwise null. Used to display border in game loading screen. (Legal values: CHALLENGER, MASTER, DIAMOND, PLATINUM, GOLD, SILVER, BRONZE, UNRANKED) */
  public final String highestAchievedSeasonTier;

  /**
   * List of mastery information */
  public final List<Mastery> masteries;

  /**
   * Participant ID */
  public final int participantId;

  /**
   * List of rune information */
  public final List<Rune> runes;

  /**
   * First summoner spell ID */
  public final int spell1Id;

  /**
   * Second summoner spell ID */
  public final int spell2Id;

  /**
   * Participant statistics */
  public final ParticipantStats stats;

  /**
   * Team ID */
  public final int teamId;

  /**
   * Timeline data. Delta fields refer to values for the specified period (e.g., the gold per minute over the first 10 minutes of the game versus the second 20 minutes of the game. Diffs fields refer to the deltas versus the calculated lane opponent(s). */
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
    if (obj == null) return false;
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
