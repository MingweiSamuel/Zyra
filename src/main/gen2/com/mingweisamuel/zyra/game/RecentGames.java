package com.mingweisamuel.zyra.game;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * This object contains recent games information..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#game-v1.3/GET_getRecentGames">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class RecentGames {
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
    if (!(obj instanceof Game)) return false;
    final Game other = (Game) obj;
    return true
        && Objects.equal(games, other.games)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        games,
        summonerId);}
}
