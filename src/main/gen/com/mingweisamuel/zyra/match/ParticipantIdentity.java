package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ParticipantIdentity - This object contains participant identity information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class ParticipantIdentity implements Serializable {
  /**
   * Participant ID */
  public final int participantId;

  /**
   * Player information */
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
