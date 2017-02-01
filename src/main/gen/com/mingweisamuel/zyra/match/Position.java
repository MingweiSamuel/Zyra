package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Position - This object contains participant frame position information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Position implements Serializable {
  public final int x;

  public final int y;

  public Position(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Position)) return false;
    final Position other = (Position) obj;
    return true
        && Objects.equal(x, other.x)
        && Objects.equal(y, other.y);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        x,
        y);}
}
