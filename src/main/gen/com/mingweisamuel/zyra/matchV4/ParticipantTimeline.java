package com.mingweisamuel.zyra.matchV4;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * ParticipantTimeline.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ParticipantTimeline implements Serializable {
  /**
   * Creeps for a specified period. */
  public final Map<String, Double> creepsPerMinDeltas;

  /**
   * Creep score difference versus the calculated lane opponent(s) for a specified period. */
  public final Map<String, Double> csDiffPerMinDeltas;

  /**
   * Damage taken difference versus the calculated lane opponent(s) for a specified period. */
  public final Map<String, Double> damageTakenDiffPerMinDeltas;

  /**
   * Damage taken for a specified period. */
  public final Map<String, Double> damageTakenPerMinDeltas;

  /**
   * Gold for a specified period. */
  public final Map<String, Double> goldPerMinDeltas;

  /**
   * Participant's calculated lane. MID and BOT are legacy values.
   *              (Legal values:  MID,  MIDDLE,  TOP,  JUNGLE,  BOT,  BOTTOM) */
  public final String lane;

  public final int participantId;

  /**
   * Participant's calculated role.
   *              (Legal values:  DUO,  NONE,  SOLO,  DUO_CARRY,  DUO_SUPPORT) */
  public final String role;

  /**
   * Experience difference versus the calculated lane opponent(s) for a specified period. */
  public final Map<String, Double> xpDiffPerMinDeltas;

  /**
   * Experience change for a specified period. */
  public final Map<String, Double> xpPerMinDeltas;

  public ParticipantTimeline(final Map<String, Double> creepsPerMinDeltas,
      final Map<String, Double> csDiffPerMinDeltas,
      final Map<String, Double> damageTakenDiffPerMinDeltas,
      final Map<String, Double> damageTakenPerMinDeltas, final Map<String, Double> goldPerMinDeltas,
      final String lane, final int participantId, final String role,
      final Map<String, Double> xpDiffPerMinDeltas, final Map<String, Double> xpPerMinDeltas) {
    this.creepsPerMinDeltas = creepsPerMinDeltas;
    this.csDiffPerMinDeltas = csDiffPerMinDeltas;
    this.damageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
    this.damageTakenPerMinDeltas = damageTakenPerMinDeltas;
    this.goldPerMinDeltas = goldPerMinDeltas;
    this.lane = lane;
    this.participantId = participantId;
    this.role = role;
    this.xpDiffPerMinDeltas = xpDiffPerMinDeltas;
    this.xpPerMinDeltas = xpPerMinDeltas;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ParticipantTimeline)) return false;
    final ParticipantTimeline other = (ParticipantTimeline) obj;
    return true
        && Objects.equal(creepsPerMinDeltas, other.creepsPerMinDeltas)
        && Objects.equal(csDiffPerMinDeltas, other.csDiffPerMinDeltas)
        && Objects.equal(damageTakenDiffPerMinDeltas, other.damageTakenDiffPerMinDeltas)
        && Objects.equal(damageTakenPerMinDeltas, other.damageTakenPerMinDeltas)
        && Objects.equal(goldPerMinDeltas, other.goldPerMinDeltas)
        && Objects.equal(lane, other.lane)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(role, other.role)
        && Objects.equal(xpDiffPerMinDeltas, other.xpDiffPerMinDeltas)
        && Objects.equal(xpPerMinDeltas, other.xpPerMinDeltas);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        creepsPerMinDeltas,
        csDiffPerMinDeltas,
        damageTakenDiffPerMinDeltas,
        damageTakenPerMinDeltas,
        goldPerMinDeltas,
        lane,
        participantId,
        role,
        xpDiffPerMinDeltas,
        xpPerMinDeltas);}
}
