package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * MatchDetail.<br><br>
 *
 * This object contains match detail information.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Mon May 15 17:36:46 PDT 2017. */
public class MatchDetail implements Serializable {
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
   * Match mode (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO, SIEGE) */
  public final String matchMode;

  /**
   * Match duration */
  public final long matchDuration;

  /**
   * Season match was played (Legal values: PRESEASON3, SEASON3, PRESEASON2014, SEASON2014, PRESEASON2015, SEASON2015, PRESEASON2016, SEASON2016, PRESEASON2017, SEASON2017) */
  public final String season;

  /**
   * Match queue type (Legal values: CUSTOM, NORMAL_5x5_BLIND, RANKED_SOLO_5x5, RANKED_PREMADE_5x5, BOT_5x5, NORMAL_3x3, RANKED_PREMADE_3x3, NORMAL_5x5_DRAFT, ODIN_5x5_BLIND, ODIN_5x5_DRAFT, BOT_ODIN_5x5, BOT_5x5_INTRO, BOT_5x5_BEGINNER, BOT_5x5_INTERMEDIATE, RANKED_TEAM_3x3, RANKED_TEAM_5x5, BOT_TT_3x3, GROUP_FINDER_5x5, ARAM_5x5, ONEFORALL_5x5, FIRSTBLOOD_1x1, FIRSTBLOOD_2x2, SR_6x6, URF_5x5, ONEFORALL_MIRRORMODE_5x5, BOT_URF_5x5, NIGHTMARE_BOT_5x5_RANK1, NIGHTMARE_BOT_5x5_RANK2, NIGHTMARE_BOT_5x5_RANK5, ASCENSION_5x5, HEXAKILL, BILGEWATER_ARAM_5x5, KING_PORO_5x5, COUNTER_PICK, BILGEWATER_5x5, SIEGE, DEFINITELY_NOT_DOMINION_5x5, ARURF_5X5, TEAM_BUILDER_DRAFT_UNRANKED_5x5, TEAM_BUILDER_DRAFT_RANKED_5x5, TEAM_BUILDER_RANKED_SOLO, RANKED_FLEX_SR) */
  public final String queueType;

  /**
   * Match type (Legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME) */
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
    if (!(obj instanceof MatchDetail)) return false;
    final MatchDetail other = (MatchDetail) obj;
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
