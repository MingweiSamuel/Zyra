package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * MatchPosition.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class MatchPosition implements Serializable {
  public final int x;

  public final int y;

  public MatchPosition(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchPosition)) return false;
    final MatchPosition other = (MatchPosition) obj;
    return true
        && Objects.equal(x, other.x)
        && Objects.equal(y, other.y);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        x,
        y);}
}
