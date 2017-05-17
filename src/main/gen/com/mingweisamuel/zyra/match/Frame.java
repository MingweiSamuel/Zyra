package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;

/**
 * Frame.<br><br>
 *
 * This object contains game frame information.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Mon May 15 17:36:46 PDT 2017. */
public class Frame implements Serializable {
  /**
   * Represents how many milliseconds into the game the frame occurred. */
  public final long timestamp;

  /**
   * Map of each participant ID to the participant's information for the frame. */
  public final Map<String, ParticipantFrame> participantFrames;

  /**
   * List of events for this frame. */
  public final List<Event> events;

  public Frame(final long timestamp, final Map<String, ParticipantFrame> participantFrames,
      final List<Event> events) {
    this.timestamp = timestamp;
    this.participantFrames = participantFrames;
    this.events = events;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Frame)) return false;
    final Frame other = (Frame) obj;
    return true
        && Objects.equal(timestamp, other.timestamp)
        && Objects.equal(participantFrames, other.participantFrames)
        && Objects.equal(events, other.events);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        timestamp,
        participantFrames,
        events);}
}
