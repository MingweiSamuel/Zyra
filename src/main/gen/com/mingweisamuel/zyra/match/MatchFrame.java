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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Riot API reference</a> on Wed May 17 20:12:12 PDT 2017. */
public class MatchFrame implements Serializable {
  public final long timestamp;

  public final Map<Integer, MatchParticipantFrame> participantFrames;

  public final List<MatchEvent> events;

  public MatchFrame(final long timestamp,
      final Map<Integer, MatchParticipantFrame> participantFrames, final List<MatchEvent> events) {
    this.timestamp = timestamp;
    this.participantFrames = participantFrames;
    this.events = events;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchFrame)) return false;
    final MatchFrame other = (MatchFrame) obj;
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
