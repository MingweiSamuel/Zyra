package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * Matchlist.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Matchlist implements Serializable {
  public final int endIndex;

  public final List<MatchReference> matches;

  public final int startIndex;

  public final int totalGames;

  public Matchlist(final int endIndex, final List<MatchReference> matches, final int startIndex,
      final int totalGames) {
    this.endIndex = endIndex;
    this.matches = matches;
    this.startIndex = startIndex;
    this.totalGames = totalGames;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Matchlist)) return false;
    final Matchlist other = (Matchlist) obj;
    return true
        && Objects.equal(endIndex, other.endIndex)
        && Objects.equal(matches, other.matches)
        && Objects.equal(startIndex, other.startIndex)
        && Objects.equal(totalGames, other.totalGames);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        endIndex,
        matches,
        startIndex,
        totalGames);}
}
