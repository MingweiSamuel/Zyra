package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * MatchTimeline.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class MatchTimeline implements Serializable {
  public final long frameInterval;

  public final List<MatchFrame> frames;

  public MatchTimeline(final long frameInterval, final List<MatchFrame> frames) {
    this.frameInterval = frameInterval;
    this.frames = frames;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchTimeline)) return false;
    final MatchTimeline other = (MatchTimeline) obj;
    return true
        && Objects.equal(frameInterval, other.frameInterval)
        && Objects.equal(frames, other.frames);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        frameInterval,
        frames);}
}
