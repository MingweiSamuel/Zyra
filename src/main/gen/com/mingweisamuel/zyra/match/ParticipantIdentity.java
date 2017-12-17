package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ParticipantIdentity.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ParticipantIdentity implements Serializable {
  public final int participantId;

  public final Player player;

  public ParticipantIdentity(final int participantId, final Player player) {
    this.participantId = participantId;
    this.player = player;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ParticipantIdentity)) return false;
    final ParticipantIdentity other = (ParticipantIdentity) obj;
    return true
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(player, other.player);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        participantId,
        player);}
}
