package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * MiniSeries.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getChallengerLeague">Riot API reference</a> on Sun May 21 18:03:38 PDT 2017. */
public class MiniSeries implements Serializable {
  public final int wins;

  public final int losses;

  public final int target;

  public final String progress;

  public MiniSeries(final int wins, final int losses, final int target, final String progress) {
    this.wins = wins;
    this.losses = losses;
    this.target = target;
    this.progress = progress;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MiniSeries)) return false;
    final MiniSeries other = (MiniSeries) obj;
    return true
        && Objects.equal(wins, other.wins)
        && Objects.equal(losses, other.losses)
        && Objects.equal(target, other.target)
        && Objects.equal(progress, other.progress);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        wins,
        losses,
        target,
        progress);}
}
