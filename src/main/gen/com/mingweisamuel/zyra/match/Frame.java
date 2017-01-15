package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;

/**
 * Frame - This object contains game frame information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Frame {
  /**
   * List of events for this frame. */
  public final List<Event> events;

  /**
   * Map of each participant ID to the participant's information for the frame. */
  public final Map<String, ParticipantFrame> participantFrames;

  /**
   * Represents how many milliseconds into the game the frame occurred. */
  public final long timestamp;

  public Frame(final List<Event> events, final Map<String, ParticipantFrame> participantFrames,
      final long timestamp) {
    this.events = events;
    this.participantFrames = participantFrames;
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Frame)) return false;
    final Frame other = (Frame) obj;
    return true
        && Objects.equal(events, other.events)
        && Objects.equal(participantFrames, other.participantFrames)
        && Objects.equal(timestamp, other.timestamp);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        events,
        participantFrames,
        timestamp);}
}
