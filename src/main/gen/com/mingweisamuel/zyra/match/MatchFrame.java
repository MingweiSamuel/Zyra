package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.util.List;
import java.util.Map;

/**
 * MatchFrame.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class MatchFrame implements Serializable {
  public final List<MatchEvent> events;

  public final Map<Integer, MatchParticipantFrame> participantFrames;

  public final long timestamp;

  public MatchFrame(final List<MatchEvent> events,
      final Map<Integer, MatchParticipantFrame> participantFrames, final long timestamp) {
    this.events = events;
    this.participantFrames = participantFrames;
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchFrame)) return false;
    final MatchFrame other = (MatchFrame) obj;
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
