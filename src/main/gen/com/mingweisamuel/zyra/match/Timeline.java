package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * Timeline - This object contains game timeline information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Timeline implements Serializable {
  /**
   * Time between each returned frame in milliseconds. */
  public final long frameInterval;

  /**
   * List of timeline frames for the game. */
  public final List<Frame> frames;

  public Timeline(final long frameInterval, final List<Frame> frames) {
    this.frameInterval = frameInterval;
    this.frames = frames;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Timeline)) return false;
    final Timeline other = (Timeline) obj;
    return true
        && Objects.equal(frameInterval, other.frameInterval)
        && Objects.equal(frames, other.frames);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        frameInterval,
        frames);}
}
