package com.mingweisamuel.zyra.match;

import java.util.List;

/**
 * Timeline - This object contains game timeline information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Timeline {
  /**
   * Time between each returned frame in milliseconds. */
  public long frameInterval;

  /**
   * List of timeline frames for the game. */
  public List<Frame> frames;
}
