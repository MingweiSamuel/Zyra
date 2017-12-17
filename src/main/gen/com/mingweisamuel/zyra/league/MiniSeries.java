package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * MiniSeries.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class MiniSeries implements Serializable {
  public final int losses;

  public final String progress;

  public final int target;

  public final int wins;

  public MiniSeries(final int losses, final String progress, final int target, final int wins) {
    this.losses = losses;
    this.progress = progress;
    this.target = target;
    this.wins = wins;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MiniSeries)) return false;
    final MiniSeries other = (MiniSeries) obj;
    return true
        && Objects.equal(losses, other.losses)
        && Objects.equal(progress, other.progress)
        && Objects.equal(target, other.target)
        && Objects.equal(wins, other.wins);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        losses,
        progress,
        target,
        wins);}
}
