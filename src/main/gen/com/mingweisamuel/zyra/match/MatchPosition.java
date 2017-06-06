package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * MatchPosition.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class MatchPosition implements Serializable {
  public final int y;

  public final int x;

  public MatchPosition(final int y, final int x) {
    this.y = y;
    this.x = x;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchPosition)) return false;
    final MatchPosition other = (MatchPosition) obj;
    return true
        && Objects.equal(y, other.y)
        && Objects.equal(x, other.x);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        y,
        x);}
}
