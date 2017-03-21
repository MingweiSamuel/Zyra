package com.mingweisamuel.zyra.matchList;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * This object contains match list information.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#matchlist-v2.2/GET_getMatchList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class MatchList {
  public final List<MatchReference> matches;

  public final int totalGames;

  public final int startIndex;

  public final int endIndex;

  public MatchList(final List<MatchReference> matches, final int totalGames, final int startIndex,
      final int endIndex) {
    this.matches = matches;
    this.totalGames = totalGames;
    this.startIndex = startIndex;
    this.endIndex = endIndex;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchList)) return false;
    final MatchList other = (MatchList) obj;
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
