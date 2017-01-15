package com.mingweisamuel.zyra.featuredGames;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * FeaturedGames
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version featured-games-v1.0 */
public class FeaturedGames {
  /**
   * The suggested interval to wait before requesting FeaturedGames again */
  public final long clientRefreshInterval;

  /**
   * The list of featured games */
  public final List<FeaturedGameInfo> gameList;

  public FeaturedGames(final long clientRefreshInterval, final List<FeaturedGameInfo> gameList) {
    this.clientRefreshInterval = clientRefreshInterval;
    this.gameList = gameList;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof FeaturedGames)) return false;
    final FeaturedGames other = (FeaturedGames) obj;
    return true
        && Objects.equal(clientRefreshInterval, other.clientRefreshInterval)
        && Objects.equal(gameList, other.gameList);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        clientRefreshInterval,
        gameList);}
}
