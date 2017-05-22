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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Riot API reference</a> on Sun May 21 18:03:38 PDT 2017. */
public class Participant implements Serializable {
  public final ParticipantStats stats;

  public final int participantId;

  public final List<Rune> runes;

  public final ParticipantTimeline timeline;

  public final int teamId;

  public final int spell2Id;

  public final List<Mastery> masteries;

  public final String highestAchievedSeasonTier;

  public final int spell1Id;

  public final int championId;

  public Participant(final ParticipantStats stats, final int participantId, final List<Rune> runes,
      final ParticipantTimeline timeline, final int teamId, final int spell2Id,
      final List<Mastery> masteries, final String highestAchievedSeasonTier, final int spell1Id,
      final int championId) {
    this.stats = stats;
    this.participantId = participantId;
    this.runes = runes;
    this.timeline = timeline;
    this.teamId = teamId;
    this.spell2Id = spell2Id;
    this.masteries = masteries;
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
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(spell2Id, other.spell2Id)
        && Objects.equal(masteries, other.masteries)
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
        teamId,
        spell2Id,
        masteries,
        highestAchievedSeasonTier,
        spell1Id,
        championId);}
}
