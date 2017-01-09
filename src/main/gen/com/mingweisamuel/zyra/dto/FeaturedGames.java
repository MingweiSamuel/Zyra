package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * FeaturedGames
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link RiotDtoGenerator}.
 *
 * @version featured-games-v1.0 */
public class FeaturedGames {
  /**
   * The suggested interval to wait before requesting FeaturedGames again */
  public long clientRefreshInterval;

  /**
   * The list of featured games */
  public List<FeaturedGameInfo> gameList;
}
