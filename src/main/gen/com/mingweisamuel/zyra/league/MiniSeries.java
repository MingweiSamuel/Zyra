package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * MiniSeries.<br><br>
 *
 * This object contains mini series information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#league-v2.5/GET_getChallengerLeagues">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class MiniSeries implements Serializable {
  /**
   * String showing the current, sequential mini series progress where 'W' represents a win, 'L' represents a loss, and 'N' represents a game that hasn't been played yet. */
  public final String progress;

  /**
   * Number of current losses in the mini series. */
  public final int losses;

  /**
   * Number of wins required for promotion. */
  public final int target;

  /**
   * Number of current wins in the mini series. */
  public final int wins;

  public MiniSeries(final String progress, final int losses, final int target, final int wins) {
    this.progress = progress;
    this.losses = losses;
    this.target = target;
    this.wins = wins;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MiniSeries)) return false;
    final MiniSeries other = (MiniSeries) obj;
    return true
        && Objects.equal(progress, other.progress)
        && Objects.equal(losses, other.losses)
        && Objects.equal(target, other.target)
        && Objects.equal(wins, other.wins);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        progress,
        losses,
        target,
        wins);}
}
