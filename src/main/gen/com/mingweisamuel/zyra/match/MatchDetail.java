package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * MatchDetail - This object contains match detail information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class MatchDetail implements Serializable {
  /**
   * Match map ID */
  public final int mapId;

  /**
   * Match creation time. Designates when the team select lobby is created and/or the match is made through match making, not when the game actually starts. */
  public final long matchCreation;

  /**
   * Match duration */
  public final long matchDuration;

  /**
   * ID of the match */
  public final long matchId;

  /**
   * Match mode (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO, SIEGE) */
  public final String matchMode;

  /**
   * Match type (Legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME) */
  public final String matchType;

  /**
   * Match version */
  public final String matchVersion;

  /**
   * Participant identity information */
  public final List<ParticipantIdentity> participantIdentities;

  /**
   * Participant information */
  public final List<Participant> participants;

  /**
   * Platform ID of the match */
  public final String platformId;

  /**
   * Match queue type (Legal values: CUSTOM, NORMAL_5x5_BLIND, RANKED_SOLO_5x5, RANKED_PREMADE_5x5, BOT_5x5, NORMAL_3x3, RANKED_PREMADE_3x3, NORMAL_5x5_DRAFT, ODIN_5x5_BLIND, ODIN_5x5_DRAFT, BOT_ODIN_5x5, BOT_5x5_INTRO, BOT_5x5_BEGINNER, BOT_5x5_INTERMEDIATE, RANKED_TEAM_3x3, RANKED_TEAM_5x5, BOT_TT_3x3, GROUP_FINDER_5x5, ARAM_5x5, ONEFORALL_5x5, FIRSTBLOOD_1x1, FIRSTBLOOD_2x2, SR_6x6, URF_5x5, ONEFORALL_MIRRORMODE_5x5, BOT_URF_5x5, NIGHTMARE_BOT_5x5_RANK1, NIGHTMARE_BOT_5x5_RANK2, NIGHTMARE_BOT_5x5_RANK5, ASCENSION_5x5, HEXAKILL, BILGEWATER_ARAM_5x5, KING_PORO_5x5, COUNTER_PICK, BILGEWATER_5x5, SIEGE, DEFINITELY_NOT_DOMINION_5x5, ARURF_5X5, TEAM_BUILDER_DRAFT_UNRANKED_5x5, TEAM_BUILDER_DRAFT_RANKED_5x5, TEAM_BUILDER_RANKED_SOLO, RANKED_FLEX_SR) */
  public final String queueType;

  /**
   * Region where the match was played (Legal values: br, eune, euw, jp, kr, lan, las, na, oce, ru, tr) */
  public final String region;

  /**
   * Season match was played (Legal values: PRESEASON3, SEASON3, PRESEASON2014, SEASON2014, PRESEASON2015, SEASON2015, PRESEASON2016, SEASON2016, PRESEASON2017, SEASON2017) */
  public final String season;

  /**
   * Team information */
  public final List<Team> teams;

  /**
   * Match timeline data (not included by default) */
  public final Timeline timeline;

  public MatchDetail(final int mapId, final long matchCreation, final long matchDuration,
      final long matchId, final String matchMode, final String matchType, final String matchVersion,
      final List<ParticipantIdentity> participantIdentities, final List<Participant> participants,
      final String platformId, final String queueType, final String region, final String season,
      final List<Team> teams, final Timeline timeline) {
    this.mapId = mapId;
    this.matchCreation = matchCreation;
    this.matchDuration = matchDuration;
    this.matchId = matchId;
    this.matchMode = matchMode;
    this.matchType = matchType;
    this.matchVersion = matchVersion;
    this.participantIdentities = participantIdentities;
    this.participants = participants;
    this.platformId = platformId;
    this.queueType = queueType;
    this.region = region;
    this.season = season;
    this.teams = teams;
    this.timeline = timeline;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchDetail)) return false;
    final MatchDetail other = (MatchDetail) obj;
    return true
        && Objects.equal(mapId, other.mapId)
        && Objects.equal(matchCreation, other.matchCreation)
        && Objects.equal(matchDuration, other.matchDuration)
        && Objects.equal(matchId, other.matchId)
        && Objects.equal(matchMode, other.matchMode)
        && Objects.equal(matchType, other.matchType)
        && Objects.equal(matchVersion, other.matchVersion)
        && Objects.equal(participantIdentities, other.participantIdentities)
        && Objects.equal(participants, other.participants)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(queueType, other.queueType)
        && Objects.equal(region, other.region)
        && Objects.equal(season, other.season)
        && Objects.equal(teams, other.teams)
        && Objects.equal(timeline, other.timeline);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        mapId,
        matchCreation,
        matchDuration,
        matchId,
        matchMode,
        matchType,
        matchVersion,
        participantIdentities,
        participants,
        platformId,
        queueType,
        region,
        season,
        teams,
        timeline);}
}
