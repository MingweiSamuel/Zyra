package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * This object contains match detail information.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class MatchDetail {
  /**
   * Participant identity information */
  public final List<ParticipantIdentity> participantIdentities;

  /**
   * Match version */
  public final String matchVersion;

  /**
   * Platform ID of the match */
  public final String platformId;

  /**
   * Match timeline data (not included by default) */
  public final Timeline timeline;

  /**
   * Region where the match was played */
  public final String region;

  /**
   * ID of the match */
  public final long matchId;

  /**
   * Match map ID */
  public final int mapId;

  /**
   * Match creation time. Designates when the team select lobby is created and/or the match is made through match making, not when the game actually starts. */
  public final long matchCreation;

  /**
   * Team information */
  public final List<Team> teams;

  /**
   * Participant information */
  public final List<Participant> participants;

  /**
   * Match mode */
  public final String matchMode;

  /**
   * Match duration */
  public final long matchDuration;

  /**
   * Season match was played */
  public final String season;

  /**
   * Match queue type */
  public final String queueType;

  /**
   * Match type */
  public final String matchType;

  public MatchDetail(final List<ParticipantIdentity> participantIdentities,
      final String matchVersion, final String platformId, final Timeline timeline,
      final String region, final long matchId, final int mapId, final long matchCreation,
      final List<Team> teams, final List<Participant> participants, final String matchMode,
      final long matchDuration, final String season, final String queueType,
      final String matchType) {
    this.participantIdentities = participantIdentities;
    this.matchVersion = matchVersion;
    this.platformId = platformId;
    this.timeline = timeline;
    this.region = region;
    this.matchId = matchId;
    this.mapId = mapId;
    this.matchCreation = matchCreation;
    this.teams = teams;
    this.participants = participants;
    this.matchMode = matchMode;
    this.matchDuration = matchDuration;
    this.season = season;
    this.queueType = queueType;
    this.matchType = matchType;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(participantIdentities, other.participantIdentities)
        && Objects.equal(matchVersion, other.matchVersion)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(timeline, other.timeline)
        && Objects.equal(region, other.region)
        && Objects.equal(matchId, other.matchId)
        && Objects.equal(mapId, other.mapId)
        && Objects.equal(matchCreation, other.matchCreation)
        && Objects.equal(teams, other.teams)
        && Objects.equal(participants, other.participants)
        && Objects.equal(matchMode, other.matchMode)
        && Objects.equal(matchDuration, other.matchDuration)
        && Objects.equal(season, other.season)
        && Objects.equal(queueType, other.queueType)
        && Objects.equal(matchType, other.matchType);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        participantIdentities,
        matchVersion,
        platformId,
        timeline,
        region,
        matchId,
        mapId,
        matchCreation,
        teams,
        participants,
        matchMode,
        matchDuration,
        season,
        queueType,
        matchType);}
}
