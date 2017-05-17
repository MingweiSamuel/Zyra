package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ParticipantIdentity.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Riot API reference</a> on Tue May 16 19:55:45 PDT 2017. */
public class ParticipantIdentity implements Serializable {
  public final Player player;

  public final int participantId;

  public ParticipantIdentity(final Player player, final int participantId) {
    this.player = player;
    this.participantId = participantId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ParticipantIdentity)) return false;
    final ParticipantIdentity other = (ParticipantIdentity) obj;
    return true
        && Objects.equal(player, other.player)
        && Objects.equal(participantId, other.participantId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        player,
        participantId);}
}
