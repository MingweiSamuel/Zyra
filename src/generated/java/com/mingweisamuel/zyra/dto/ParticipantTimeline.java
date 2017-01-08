package com.mingweisamuel.zyra.dto;

import java.lang.String;

/**
 * ParticipantTimeline - This object contains all timeline information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}. */
public class ParticipantTimeline {
  /**
   * Ancient golem assists per minute timeline counts */
  public ParticipantTimelineData ancientGolemAssistsPerMinCounts;

  /**
   * Ancient golem kills per minute timeline counts */
  public ParticipantTimelineData ancientGolemKillsPerMinCounts;

  /**
   * Assisted lane deaths per minute timeline data */
  public ParticipantTimelineData assistedLaneDeathsPerMinDeltas;

  /**
   * Assisted lane kills per minute timeline data */
  public ParticipantTimelineData assistedLaneKillsPerMinDeltas;

  /**
   * Baron assists per minute timeline counts */
  public ParticipantTimelineData baronAssistsPerMinCounts;

  /**
   * Baron kills per minute timeline counts */
  public ParticipantTimelineData baronKillsPerMinCounts;

  /**
   * Creeps per minute timeline data */
  public ParticipantTimelineData creepsPerMinDeltas;

  /**
   * Creep score difference per minute timeline data */
  public ParticipantTimelineData csDiffPerMinDeltas;

  /**
   * Damage taken difference per minute timeline data */
  public ParticipantTimelineData damageTakenDiffPerMinDeltas;

  /**
   * Damage taken per minute timeline data */
  public ParticipantTimelineData damageTakenPerMinDeltas;

  /**
   * Dragon assists per minute timeline counts */
  public ParticipantTimelineData dragonAssistsPerMinCounts;

  /**
   * Dragon kills per minute timeline counts */
  public ParticipantTimelineData dragonKillsPerMinCounts;

  /**
   * Elder lizard assists per minute timeline counts */
  public ParticipantTimelineData elderLizardAssistsPerMinCounts;

  /**
   * Elder lizard kills per minute timeline counts */
  public ParticipantTimelineData elderLizardKillsPerMinCounts;

  /**
   * Gold per minute timeline data */
  public ParticipantTimelineData goldPerMinDeltas;

  /**
   * Inhibitor assists per minute timeline counts */
  public ParticipantTimelineData inhibitorAssistsPerMinCounts;

  /**
   * Inhibitor kills per minute timeline counts */
  public ParticipantTimelineData inhibitorKillsPerMinCounts;

  /**
   * Participant's lane (Legal values: MID, MIDDLE, TOP, JUNGLE, BOT, BOTTOM) */
  public String lane;

  /**
   * Participant's role (Legal values: DUO, NONE, SOLO, DUO_CARRY, DUO_SUPPORT) */
  public String role;

  /**
   * Tower assists per minute timeline counts */
  public ParticipantTimelineData towerAssistsPerMinCounts;

  /**
   * Tower kills per minute timeline counts */
  public ParticipantTimelineData towerKillsPerMinCounts;

  /**
   * Tower kills per minute timeline data */
  public ParticipantTimelineData towerKillsPerMinDeltas;

  /**
   * Vilemaw assists per minute timeline counts */
  public ParticipantTimelineData vilemawAssistsPerMinCounts;

  /**
   * Vilemaw kills per minute timeline counts */
  public ParticipantTimelineData vilemawKillsPerMinCounts;

  /**
   * Wards placed per minute timeline data */
  public ParticipantTimelineData wardsPerMinDeltas;

  /**
   * Experience difference per minute timeline data */
  public ParticipantTimelineData xpDiffPerMinDeltas;

  /**
   * Experience per minute timeline data */
  public ParticipantTimelineData xpPerMinDeltas;
}
