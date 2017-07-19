package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * Matchlist.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchlist">Riot API reference</a>. */
public class Matchlist implements Serializable {
  public final List<MatchReference> matches;

  public final int totalGames;

  public final int startIndex;

  public final int endIndex;

  public Matchlist(final List<MatchReference> matches, final int totalGames, final int startIndex,
      final int endIndex) {
    this.matches = matches;
    this.totalGames = totalGames;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Matchlist)) return false;
    final Matchlist other = (Matchlist) obj;
    return true
        && Objects.equal(matches, other.matches)
        && Objects.equal(totalGames, other.totalGames)
        && Objects.equal(startIndex, other.startIndex)
        && Objects.equal(endIndex, other.endIndex);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        matches,
        totalGames,
        startIndex,
        endIndex);}
}
