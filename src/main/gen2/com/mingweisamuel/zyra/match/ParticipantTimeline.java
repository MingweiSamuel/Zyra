package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * This object contains all timeline information.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class ParticipantTimeline {
  /**
   * Vilemaw assists per minute timeline counts */
  public final ParticipantTimelineData vilemawAssistsPerMinCounts;

  /**
   * Gold per minute timeline data */
  public final ParticipantTimelineData goldPerMinDeltas;

  /**
   * Baron assists per minute timeline counts */
  public final ParticipantTimelineData baronAssistsPerMinCounts;

  /**
   * Ancient golem assists per minute timeline counts */
  public final ParticipantTimelineData ancientGolemAssistsPerMinCounts;

  /**
   * Elder lizard assists per minute timeline counts */
  public final ParticipantTimelineData elderLizardAssistsPerMinCounts;

  /**
   * Tower kills per minute timeline counts */
  public final ParticipantTimelineData towerKillsPerMinCounts;

  /**
   * Damage taken per minute timeline data */
  public final ParticipantTimelineData damageTakenPerMinDeltas;

  /**
   * Experience difference per minute timeline data */
  public final ParticipantTimelineData xpDiffPerMinDeltas;

  /**
   * Creeps per minute timeline data */
  public final ParticipantTimelineData creepsPerMinDeltas;

  /**
   * Participant's role */
  public final String role;

  /**
   * Damage taken difference per minute timeline data */
  public final ParticipantTimelineData damageTakenDiffPerMinDeltas;

  /**
   * Dragon kills per minute timeline counts */
  public final ParticipantTimelineData dragonKillsPerMinCounts;

  /**
   * Tower kills per minute timeline data */
  public final ParticipantTimelineData towerKillsPerMinDeltas;

  /**
   * Elder lizard kills per minute timeline counts */
  public final ParticipantTimelineData elderLizardKillsPerMinCounts;

  /**
   * Ancient golem kills per minute timeline counts */
  public final ParticipantTimelineData ancientGolemKillsPerMinCounts;

  /**
   * Creep score difference per minute timeline data */
  public final ParticipantTimelineData csDiffPerMinDeltas;

  /**
   * Baron kills per minute timeline counts */
  public final ParticipantTimelineData baronKillsPerMinCounts;

  /**
   * Assisted lane kills per minute timeline data */
  public final ParticipantTimelineData assistedLaneKillsPerMinDeltas;

  /**
   * Assisted lane deaths per minute timeline data */
  public final ParticipantTimelineData assistedLaneDeathsPerMinDeltas;

  /**
   * Participant's lane */
  public final String lane;

  /**
   * Inhibitor kills per minute timeline counts */
  public final ParticipantTimelineData inhibitorKillsPerMinCounts;

  /**
   * Tower assists per minute timeline counts */
  public final ParticipantTimelineData towerAssistsPerMinCounts;

  /**
   * Vilemaw kills per minute timeline counts */
  public final ParticipantTimelineData vilemawKillsPerMinCounts;

  /**
   * Experience per minute timeline data */
  public final ParticipantTimelineData xpPerMinDeltas;

  /**
   * Dragon assists per minute timeline counts */
  public final ParticipantTimelineData dragonAssistsPerMinCounts;

  /**
   * Inhibitor assists per minute timeline counts */
  public final ParticipantTimelineData inhibitorAssistsPerMinCounts;

  /**
   * Wards placed per minute timeline data */
  public final ParticipantTimelineData wardsPerMinDeltas;

  public ParticipantTimeline(final ParticipantTimelineData vilemawAssistsPerMinCounts,
      final ParticipantTimelineData goldPerMinDeltas,
      final ParticipantTimelineData baronAssistsPerMinCounts,
      final ParticipantTimelineData ancientGolemAssistsPerMinCounts,
      final ParticipantTimelineData elderLizardAssistsPerMinCounts,
      final ParticipantTimelineData towerKillsPerMinCounts,
      final ParticipantTimelineData damageTakenPerMinDeltas,
      final ParticipantTimelineData xpDiffPerMinDeltas,
      final ParticipantTimelineData creepsPerMinDeltas, final String role,
      final ParticipantTimelineData damageTakenDiffPerMinDeltas,
      final ParticipantTimelineData dragonKillsPerMinCounts,
      final ParticipantTimelineData towerKillsPerMinDeltas,
      final ParticipantTimelineData elderLizardKillsPerMinCounts,
      final ParticipantTimelineData ancientGolemKillsPerMinCounts,
      final ParticipantTimelineData csDiffPerMinDeltas,
      final ParticipantTimelineData baronKillsPerMinCounts,
      final ParticipantTimelineData assistedLaneKillsPerMinDeltas,
      final ParticipantTimelineData assistedLaneDeathsPerMinDeltas, final String lane,
      final ParticipantTimelineData inhibitorKillsPerMinCounts,
      final ParticipantTimelineData towerAssistsPerMinCounts,
      final ParticipantTimelineData vilemawKillsPerMinCounts,
      final ParticipantTimelineData xpPerMinDeltas,
      final ParticipantTimelineData dragonAssistsPerMinCounts,
      final ParticipantTimelineData inhibitorAssistsPerMinCounts,
      final ParticipantTimelineData wardsPerMinDeltas) {
    this.vilemawAssistsPerMinCounts = vilemawAssistsPerMinCounts;
    this.goldPerMinDeltas = goldPerMinDeltas;
    this.baronAssistsPerMinCounts = baronAssistsPerMinCounts;
    this.ancientGolemAssistsPerMinCounts = ancientGolemAssistsPerMinCounts;
    this.elderLizardAssistsPerMinCounts = elderLizardAssistsPerMinCounts;
    this.towerKillsPerMinCounts = towerKillsPerMinCounts;
    this.damageTakenPerMinDeltas = damageTakenPerMinDeltas;
    this.xpDiffPerMinDeltas = xpDiffPerMinDeltas;
    this.creepsPerMinDeltas = creepsPerMinDeltas;
    this.role = role;
    this.damageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
    this.dragonKillsPerMinCounts = dragonKillsPerMinCounts;
    this.towerKillsPerMinDeltas = towerKillsPerMinDeltas;
    this.elderLizardKillsPerMinCounts = elderLizardKillsPerMinCounts;
    this.ancientGolemKillsPerMinCounts = ancientGolemKillsPerMinCounts;
    this.csDiffPerMinDeltas = csDiffPerMinDeltas;
    this.baronKillsPerMinCounts = baronKillsPerMinCounts;
    this.assistedLaneKillsPerMinDeltas = assistedLaneKillsPerMinDeltas;
    this.assistedLaneDeathsPerMinDeltas = assistedLaneDeathsPerMinDeltas;
    this.lane = lane;
    this.inhibitorKillsPerMinCounts = inhibitorKillsPerMinCounts;
    this.towerAssistsPerMinCounts = towerAssistsPerMinCounts;
    this.vilemawKillsPerMinCounts = vilemawKillsPerMinCounts;
    this.xpPerMinDeltas = xpPerMinDeltas;
    this.dragonAssistsPerMinCounts = dragonAssistsPerMinCounts;
    this.inhibitorAssistsPerMinCounts = inhibitorAssistsPerMinCounts;
    this.wardsPerMinDeltas = wardsPerMinDeltas;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(vilemawAssistsPerMinCounts, other.vilemawAssistsPerMinCounts)
        && Objects.equal(goldPerMinDeltas, other.goldPerMinDeltas)
        && Objects.equal(baronAssistsPerMinCounts, other.baronAssistsPerMinCounts)
        && Objects.equal(ancientGolemAssistsPerMinCounts, other.ancientGolemAssistsPerMinCounts)
        && Objects.equal(elderLizardAssistsPerMinCounts, other.elderLizardAssistsPerMinCounts)
        && Objects.equal(towerKillsPerMinCounts, other.towerKillsPerMinCounts)
        && Objects.equal(damageTakenPerMinDeltas, other.damageTakenPerMinDeltas)
        && Objects.equal(xpDiffPerMinDeltas, other.xpDiffPerMinDeltas)
        && Objects.equal(creepsPerMinDeltas, other.creepsPerMinDeltas)
        && Objects.equal(role, other.role)
        && Objects.equal(damageTakenDiffPerMinDeltas, other.damageTakenDiffPerMinDeltas)
        && Objects.equal(dragonKillsPerMinCounts, other.dragonKillsPerMinCounts)
        && Objects.equal(towerKillsPerMinDeltas, other.towerKillsPerMinDeltas)
        && Objects.equal(elderLizardKillsPerMinCounts, other.elderLizardKillsPerMinCounts)
        && Objects.equal(ancientGolemKillsPerMinCounts, other.ancientGolemKillsPerMinCounts)
        && Objects.equal(csDiffPerMinDeltas, other.csDiffPerMinDeltas)
        && Objects.equal(baronKillsPerMinCounts, other.baronKillsPerMinCounts)
        && Objects.equal(assistedLaneKillsPerMinDeltas, other.assistedLaneKillsPerMinDeltas)
        && Objects.equal(assistedLaneDeathsPerMinDeltas, other.assistedLaneDeathsPerMinDeltas)
        && Objects.equal(lane, other.lane)
        && Objects.equal(inhibitorKillsPerMinCounts, other.inhibitorKillsPerMinCounts)
        && Objects.equal(towerAssistsPerMinCounts, other.towerAssistsPerMinCounts)
        && Objects.equal(vilemawKillsPerMinCounts, other.vilemawKillsPerMinCounts)
        && Objects.equal(xpPerMinDeltas, other.xpPerMinDeltas)
        && Objects.equal(dragonAssistsPerMinCounts, other.dragonAssistsPerMinCounts)
        && Objects.equal(inhibitorAssistsPerMinCounts, other.inhibitorAssistsPerMinCounts)
        && Objects.equal(wardsPerMinDeltas, other.wardsPerMinDeltas);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        vilemawAssistsPerMinCounts,
        goldPerMinDeltas,
        baronAssistsPerMinCounts,
        ancientGolemAssistsPerMinCounts,
        elderLizardAssistsPerMinCounts,
        towerKillsPerMinCounts,
        damageTakenPerMinDeltas,
        xpDiffPerMinDeltas,
        creepsPerMinDeltas,
        role,
        damageTakenDiffPerMinDeltas,
        dragonKillsPerMinCounts,
        towerKillsPerMinDeltas,
        elderLizardKillsPerMinCounts,
        ancientGolemKillsPerMinCounts,
        csDiffPerMinDeltas,
        baronKillsPerMinCounts,
        assistedLaneKillsPerMinDeltas,
        assistedLaneDeathsPerMinDeltas,
        lane,
        inhibitorKillsPerMinCounts,
        towerAssistsPerMinCounts,
        vilemawKillsPerMinCounts,
        xpPerMinDeltas,
        dragonAssistsPerMinCounts,
        inhibitorAssistsPerMinCounts,
        wardsPerMinDeltas);}
}
