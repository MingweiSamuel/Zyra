package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;

/**
 * MatchDetail - This object contains match detail information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version match-v2.2 */
public class MatchDetail {
  /**
   * Match map ID */
  public int mapId;

  /**
   * Match creation time. Designates when the team select lobby is created and/or the match is made through match making, not when the game actually starts. */
  public long matchCreation;

  /**
   * Match duration */
  public long matchDuration;

  /**
   * ID of the match */
  public long matchId;

  /**
   * Match mode (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO, SIEGE) */
  public String matchMode;

  /**
   * Match type (Legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME) */
  public String matchType;

  /**
   * Match version */
  public String matchVersion;

  /**
   * Participant identity information */
  public List<ParticipantIdentity> participantIdentities;

  /**
   * Participant information */
  public List<Participant> participants;

  /**
   * Platform ID of the match */
  public String platformId;

  /**
   * Match queue type (Legal values: CUSTOM, NORMAL_5x5_BLIND, RANKED_SOLO_5x5, RANKED_PREMADE_5x5, BOT_5x5, NORMAL_3x3, RANKED_PREMADE_3x3, NORMAL_5x5_DRAFT, ODIN_5x5_BLIND, ODIN_5x5_DRAFT, BOT_ODIN_5x5, BOT_5x5_INTRO, BOT_5x5_BEGINNER, BOT_5x5_INTERMEDIATE, RANKED_TEAM_3x3, RANKED_TEAM_5x5, BOT_TT_3x3, GROUP_FINDER_5x5, ARAM_5x5, ONEFORALL_5x5, FIRSTBLOOD_1x1, FIRSTBLOOD_2x2, SR_6x6, URF_5x5, ONEFORALL_MIRRORMODE_5x5, BOT_URF_5x5, NIGHTMARE_BOT_5x5_RANK1, NIGHTMARE_BOT_5x5_RANK2, NIGHTMARE_BOT_5x5_RANK5, ASCENSION_5x5, HEXAKILL, BILGEWATER_ARAM_5x5, KING_PORO_5x5, COUNTER_PICK, BILGEWATER_5x5, SIEGE, DEFINITELY_NOT_DOMINION_5x5, ARURF_5X5, TEAM_BUILDER_DRAFT_UNRANKED_5x5, TEAM_BUILDER_DRAFT_RANKED_5x5, TEAM_BUILDER_RANKED_SOLO, RANKED_FLEX_SR) */
  public String queueType;

  /**
   * Region where the match was played (Legal values: br, eune, euw, jp, kr, lan, las, na, oce, ru, tr) */
  public String region;

  /**
   * Season match was played (Legal values: PRESEASON3, SEASON3, PRESEASON2014, SEASON2014, PRESEASON2015, SEASON2015, PRESEASON2016, SEASON2016, PRESEASON2017, SEASON2017) */
  public String season;

  /**
   * Team information */
  public List<Team> teams;

  /**
   * Match timeline data (not included by default) */
  public Timeline timeline;
}
