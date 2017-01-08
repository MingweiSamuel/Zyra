package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * RecentGames - This object contains recent games information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version game-v1.3 */
public class RecentGames {
  /**
   * Collection of recent games played (max 10). */
  public List<Game> games;

  /**
   * Summoner ID. */
  public long summonerId;
}
