package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * ParticipantTimeline - This object contains all timeline information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class ParticipantTimeline implements Serializable {
  /**
   * Ancient golem assists per minute timeline counts */
  public final ParticipantTimelineData ancientGolemAssistsPerMinCounts;

  /**
   * Ancient golem kills per minute timeline counts */
  public final ParticipantTimelineData ancientGolemKillsPerMinCounts;

  /**
   * Assisted lane deaths per minute timeline data */
  public final ParticipantTimelineData assistedLaneDeathsPerMinDeltas;

  /**
   * Assisted lane kills per minute timeline data */
  public final ParticipantTimelineData assistedLaneKillsPerMinDeltas;

  /**
   * Baron assists per minute timeline counts */
  public final ParticipantTimelineData baronAssistsPerMinCounts;

  /**
   * Baron kills per minute timeline counts */
  public final ParticipantTimelineData baronKillsPerMinCounts;

  /**
   * Creeps per minute timeline data */
  public final ParticipantTimelineData creepsPerMinDeltas;

  /**
   * Creep score difference per minute timeline data */
  public final ParticipantTimelineData csDiffPerMinDeltas;

  /**
   * Damage taken difference per minute timeline data */
  public final ParticipantTimelineData damageTakenDiffPerMinDeltas;

  /**
   * Damage taken per minute timeline data */
  public final ParticipantTimelineData damageTakenPerMinDeltas;

  /**
   * Dragon assists per minute timeline counts */
  public final ParticipantTimelineData dragonAssistsPerMinCounts;

  /**
   * Dragon kills per minute timeline counts */
  public final ParticipantTimelineData dragonKillsPerMinCounts;

  /**
   * Elder lizard assists per minute timeline counts */
  public final ParticipantTimelineData elderLizardAssistsPerMinCounts;

  /**
   * Elder lizard kills per minute timeline counts */
  public final ParticipantTimelineData elderLizardKillsPerMinCounts;

  /**
   * Gold per minute timeline data */
  public final ParticipantTimelineData goldPerMinDeltas;

  /**
   * Inhibitor assists per minute timeline counts */
  public final ParticipantTimelineData inhibitorAssistsPerMinCounts;

  /**
   * Inhibitor kills per minute timeline counts */
  public final ParticipantTimelineData inhibitorKillsPerMinCounts;

  /**
   * Participant's lane (Legal values: MID, MIDDLE, TOP, JUNGLE, BOT, BOTTOM) */
  public final String lane;

  /**
   * Participant's role (Legal values: DUO, NONE, SOLO, DUO_CARRY, DUO_SUPPORT) */
  public final String role;

  /**
   * Tower assists per minute timeline counts */
  public final ParticipantTimelineData towerAssistsPerMinCounts;

  /**
   * Tower kills per minute timeline counts */
  public final ParticipantTimelineData towerKillsPerMinCounts;

  /**
   * Tower kills per minute timeline data */
  public final ParticipantTimelineData towerKillsPerMinDeltas;

  /**
   * Vilemaw assists per minute timeline counts */
  public final ParticipantTimelineData vilemawAssistsPerMinCounts;

  /**
   * Vilemaw kills per minute timeline counts */
  public final ParticipantTimelineData vilemawKillsPerMinCounts;

  /**
   * Wards placed per minute timeline data */
  public final ParticipantTimelineData wardsPerMinDeltas;

  /**
   * Experience difference per minute timeline data */
  public final ParticipantTimelineData xpDiffPerMinDeltas;

  /**
   * Experience per minute timeline data */
  public final ParticipantTimelineData xpPerMinDeltas;

  public ParticipantTimeline(final ParticipantTimelineData ancientGolemAssistsPerMinCounts,
      final ParticipantTimelineData ancientGolemKillsPerMinCounts,
      final ParticipantTimelineData assistedLaneDeathsPerMinDeltas,
      final ParticipantTimelineData assistedLaneKillsPerMinDeltas,
      final ParticipantTimelineData baronAssistsPerMinCounts,
      final ParticipantTimelineData baronKillsPerMinCounts,
      final ParticipantTimelineData creepsPerMinDeltas,
      final ParticipantTimelineData csDiffPerMinDeltas,
      final ParticipantTimelineData damageTakenDiffPerMinDeltas,
      final ParticipantTimelineData damageTakenPerMinDeltas,
      final ParticipantTimelineData dragonAssistsPerMinCounts,
      final ParticipantTimelineData dragonKillsPerMinCounts,
      final ParticipantTimelineData elderLizardAssistsPerMinCounts,
      final ParticipantTimelineData elderLizardKillsPerMinCounts,
      final ParticipantTimelineData goldPerMinDeltas,
      final ParticipantTimelineData inhibitorAssistsPerMinCounts,
      final ParticipantTimelineData inhibitorKillsPerMinCounts, final String lane,
      final String role, final ParticipantTimelineData towerAssistsPerMinCounts,
      final ParticipantTimelineData towerKillsPerMinCounts,
      final ParticipantTimelineData towerKillsPerMinDeltas,
      final ParticipantTimelineData vilemawAssistsPerMinCounts,
      final ParticipantTimelineData vilemawKillsPerMinCounts,
      final ParticipantTimelineData wardsPerMinDeltas,
      final ParticipantTimelineData xpDiffPerMinDeltas,
      final ParticipantTimelineData xpPerMinDeltas) {
    this.ancientGolemAssistsPerMinCounts = ancientGolemAssistsPerMinCounts;
    this.ancientGolemKillsPerMinCounts = ancientGolemKillsPerMinCounts;
    this.assistedLaneDeathsPerMinDeltas = assistedLaneDeathsPerMinDeltas;
    this.assistedLaneKillsPerMinDeltas = assistedLaneKillsPerMinDeltas;
    this.baronAssistsPerMinCounts = baronAssistsPerMinCounts;
    this.baronKillsPerMinCounts = baronKillsPerMinCounts;
    this.creepsPerMinDeltas = creepsPerMinDeltas;
    this.csDiffPerMinDeltas = csDiffPerMinDeltas;
    this.damageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
    this.damageTakenPerMinDeltas = damageTakenPerMinDeltas;
    this.dragonAssistsPerMinCounts = dragonAssistsPerMinCounts;
    this.dragonKillsPerMinCounts = dragonKillsPerMinCounts;
    this.elderLizardAssistsPerMinCounts = elderLizardAssistsPerMinCounts;
    this.elderLizardKillsPerMinCounts = elderLizardKillsPerMinCounts;
    this.goldPerMinDeltas = goldPerMinDeltas;
    this.inhibitorAssistsPerMinCounts = inhibitorAssistsPerMinCounts;
    this.inhibitorKillsPerMinCounts = inhibitorKillsPerMinCounts;
    this.lane = lane;
    this.role = role;
    this.towerAssistsPerMinCounts = towerAssistsPerMinCounts;
    this.towerKillsPerMinCounts = towerKillsPerMinCounts;
    this.towerKillsPerMinDeltas = towerKillsPerMinDeltas;
    this.vilemawAssistsPerMinCounts = vilemawAssistsPerMinCounts;
    this.vilemawKillsPerMinCounts = vilemawKillsPerMinCounts;
    this.wardsPerMinDeltas = wardsPerMinDeltas;
    this.xpDiffPerMinDeltas = xpDiffPerMinDeltas;
    this.xpPerMinDeltas = xpPerMinDeltas;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ParticipantTimeline)) return false;
    final ParticipantTimeline other = (ParticipantTimeline) obj;
    return true
        && Objects.equal(ancientGolemAssistsPerMinCounts, other.ancientGolemAssistsPerMinCounts)
        && Objects.equal(ancientGolemKillsPerMinCounts, other.ancientGolemKillsPerMinCounts)
        && Objects.equal(assistedLaneDeathsPerMinDeltas, other.assistedLaneDeathsPerMinDeltas)
        && Objects.equal(assistedLaneKillsPerMinDeltas, other.assistedLaneKillsPerMinDeltas)
        && Objects.equal(baronAssistsPerMinCounts, other.baronAssistsPerMinCounts)
        && Objects.equal(baronKillsPerMinCounts, other.baronKillsPerMinCounts)
        && Objects.equal(creepsPerMinDeltas, other.creepsPerMinDeltas)
        && Objects.equal(csDiffPerMinDeltas, other.csDiffPerMinDeltas)
        && Objects.equal(damageTakenDiffPerMinDeltas, other.damageTakenDiffPerMinDeltas)
        && Objects.equal(damageTakenPerMinDeltas, other.damageTakenPerMinDeltas)
        && Objects.equal(dragonAssistsPerMinCounts, other.dragonAssistsPerMinCounts)
        && Objects.equal(dragonKillsPerMinCounts, other.dragonKillsPerMinCounts)
        && Objects.equal(elderLizardAssistsPerMinCounts, other.elderLizardAssistsPerMinCounts)
        && Objects.equal(elderLizardKillsPerMinCounts, other.elderLizardKillsPerMinCounts)
        && Objects.equal(goldPerMinDeltas, other.goldPerMinDeltas)
        && Objects.equal(inhibitorAssistsPerMinCounts, other.inhibitorAssistsPerMinCounts)
        && Objects.equal(inhibitorKillsPerMinCounts, other.inhibitorKillsPerMinCounts)
        && Objects.equal(lane, other.lane)
        && Objects.equal(role, other.role)
        && Objects.equal(towerAssistsPerMinCounts, other.towerAssistsPerMinCounts)
        && Objects.equal(towerKillsPerMinCounts, other.towerKillsPerMinCounts)
        && Objects.equal(towerKillsPerMinDeltas, other.towerKillsPerMinDeltas)
        && Objects.equal(vilemawAssistsPerMinCounts, other.vilemawAssistsPerMinCounts)
        && Objects.equal(vilemawKillsPerMinCounts, other.vilemawKillsPerMinCounts)
        && Objects.equal(wardsPerMinDeltas, other.wardsPerMinDeltas)
        && Objects.equal(xpDiffPerMinDeltas, other.xpDiffPerMinDeltas)
        && Objects.equal(xpPerMinDeltas, other.xpPerMinDeltas);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        ancientGolemAssistsPerMinCounts,
        ancientGolemKillsPerMinCounts,
        assistedLaneDeathsPerMinDeltas,
        assistedLaneKillsPerMinDeltas,
        baronAssistsPerMinCounts,
        baronKillsPerMinCounts,
        creepsPerMinDeltas,
        csDiffPerMinDeltas,
        damageTakenDiffPerMinDeltas,
        damageTakenPerMinDeltas,
        dragonAssistsPerMinCounts,
        dragonKillsPerMinCounts,
        elderLizardAssistsPerMinCounts,
        elderLizardKillsPerMinCounts,
        goldPerMinDeltas,
        inhibitorAssistsPerMinCounts,
        inhibitorKillsPerMinCounts,
        lane,
        role,
        towerAssistsPerMinCounts,
        towerKillsPerMinCounts,
        towerKillsPerMinDeltas,
        vilemawAssistsPerMinCounts,
        vilemawKillsPerMinCounts,
        wardsPerMinDeltas,
        xpDiffPerMinDeltas,
        xpPerMinDeltas);}
}
