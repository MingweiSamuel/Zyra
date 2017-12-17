package com.mingweisamuel.zyra.spectator;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * FeaturedGames.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class FeaturedGames implements Serializable {
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
