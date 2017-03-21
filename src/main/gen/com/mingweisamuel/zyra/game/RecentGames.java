package com.mingweisamuel.zyra.game;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * RecentGames.<br><br>
 *
 * This object contains recent games information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#game-v1.3/GET_getRecentGames">Riot API reference</a> on Tue Mar 21 15:10:48 PDT 2017. */
public class RecentGames implements Serializable {
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
