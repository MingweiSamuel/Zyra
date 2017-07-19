package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * MatchTimeline.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Riot API reference</a>. */
public class MatchTimeline implements Serializable {
  public final List<MatchFrame> frames;

  public final long frameInterval;

  public MatchTimeline(final List<MatchFrame> frames, final long frameInterval) {
    this.frames = frames;
    this.frameInterval = frameInterval;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchTimeline)) return false;
    final MatchTimeline other = (MatchTimeline) obj;
    return true
        && Objects.equal(frames, other.frames)
        && Objects.equal(frameInterval, other.frameInterval);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        frames,
        frameInterval);}
}
