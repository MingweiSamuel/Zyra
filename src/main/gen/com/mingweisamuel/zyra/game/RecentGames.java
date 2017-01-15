package com.mingweisamuel.zyra.game;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * RecentGames - This object contains recent games information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version game-v1.3 */
public class RecentGames {
  /**
   * Collection of recent games played (max 10). */
  public final List<Game> games;

  /**
   * Summoner ID. */
  public final long summonerId;

  public RecentGames(final List<Game> games, final long summonerId) {
    this.games = games;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof RecentGames)) return false;
    final RecentGames other = (RecentGames) obj;
    return true
        && Objects.equal(games, other.games)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        games,
        summonerId);}
}
