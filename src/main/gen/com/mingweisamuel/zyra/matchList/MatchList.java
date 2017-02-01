package com.mingweisamuel.zyra.matchList;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * MatchList - This object contains match list information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version matchlist-v2.2 */
public class MatchList implements Serializable {
  public final int endIndex;

  public final List<MatchReference> matches;

  public final int startIndex;

  public final int totalGames;

  public MatchList(final int endIndex, final List<MatchReference> matches, final int startIndex,
      final int totalGames) {
    this.endIndex = endIndex;
    this.matches = matches;
    this.startIndex = startIndex;
    this.totalGames = totalGames;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchList)) return false;
    final MatchList other = (MatchList) obj;
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
