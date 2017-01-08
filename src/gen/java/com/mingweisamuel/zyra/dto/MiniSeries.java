package com.mingweisamuel.zyra.dto;

import java.lang.String;

/**
 * MiniSeries - This object contains mini series information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version league-v2.5 */
public class MiniSeries {
  /**
   * Number of current losses in the mini series. */
  public int losses;

  /**
   * String showing the current, sequential mini series progress where 'W' represents a win, 'L' represents a loss, and 'N' represents a game that hasn't been played yet. */
  public String progress;

  /**
   * Number of wins required for promotion. */
  public int target;

  /**
   * Number of current wins in the mini series. */
  public int wins;
}
