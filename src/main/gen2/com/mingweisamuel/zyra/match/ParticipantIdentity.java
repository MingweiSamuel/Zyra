package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains participant identity information.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class ParticipantIdentity {
  /**
   * Player information */
  public final Player player;

  /**
   * Participant ID */
  public final int participantId;

  public ParticipantIdentity(final Player player, final int participantId) {
    this.player = player;
    this.participantId = participantId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(player, other.player)
        && Objects.equal(participantId, other.participantId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        player,
        participantId);}
}
