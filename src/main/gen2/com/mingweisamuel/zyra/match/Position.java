package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains participant frame position information.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Position {
  public final int y;

  public final int x;

  public Position(final int y, final int x) {
    this.y = y;
    this.x = x;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(y, other.y)
        && Objects.equal(x, other.x);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        y,
        x);}
}
