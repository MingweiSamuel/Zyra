package com.mingweisamuel.zyra.match;

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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Riot API reference</a> on Wed May 17 21:53:10 PDT 2017. */
public class ParticipantTimeline implements Serializable {
  public final String lane;

  public final int participantId;

  public final Map<String, Double> csDiffPerMinDeltas;

  public final Map<String, Double> goldPerMinDeltas;

  public final Map<String, Double> xpDiffPerMinDeltas;

  public final Map<String, Double> creepsPerMinDeltas;

  public final Map<String, Double> xpPerMinDeltas;

  public final String role;

  public final Map<String, Double> damageTakenDiffPerMinDeltas;

  public final Map<String, Double> damageTakenPerMinDeltas;

  public ParticipantTimeline(final String lane, final int participantId,
      final Map<String, Double> csDiffPerMinDeltas, final Map<String, Double> goldPerMinDeltas,
      final Map<String, Double> xpDiffPerMinDeltas, final Map<String, Double> creepsPerMinDeltas,
      final Map<String, Double> xpPerMinDeltas, final String role,
      final Map<String, Double> damageTakenDiffPerMinDeltas,
      final Map<String, Double> damageTakenPerMinDeltas) {
    this.lane = lane;
    this.participantId = participantId;
    this.csDiffPerMinDeltas = csDiffPerMinDeltas;
    this.goldPerMinDeltas = goldPerMinDeltas;
    this.xpDiffPerMinDeltas = xpDiffPerMinDeltas;
    this.creepsPerMinDeltas = creepsPerMinDeltas;
    this.xpPerMinDeltas = xpPerMinDeltas;
    this.role = role;
    this.damageTakenDiffPerMinDeltas = damageTakenDiffPerMinDeltas;
    this.damageTakenPerMinDeltas = damageTakenPerMinDeltas;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ParticipantTimeline)) return false;
    final ParticipantTimeline other = (ParticipantTimeline) obj;
    return true
        && Objects.equal(lane, other.lane)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(csDiffPerMinDeltas, other.csDiffPerMinDeltas)
        && Objects.equal(goldPerMinDeltas, other.goldPerMinDeltas)
        && Objects.equal(xpDiffPerMinDeltas, other.xpDiffPerMinDeltas)
        && Objects.equal(creepsPerMinDeltas, other.creepsPerMinDeltas)
        && Objects.equal(xpPerMinDeltas, other.xpPerMinDeltas)
        && Objects.equal(role, other.role)
        && Objects.equal(damageTakenDiffPerMinDeltas, other.damageTakenDiffPerMinDeltas)
        && Objects.equal(damageTakenPerMinDeltas, other.damageTakenPerMinDeltas);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        lane,
        participantId,
        csDiffPerMinDeltas,
        goldPerMinDeltas,
        xpDiffPerMinDeltas,
        creepsPerMinDeltas,
        xpPerMinDeltas,
        role,
        damageTakenDiffPerMinDeltas,
        damageTakenPerMinDeltas);}
}
