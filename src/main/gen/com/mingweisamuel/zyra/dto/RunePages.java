package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * RunePages - This object contains rune pages information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link RiotDtoGenerator}.
 *
 * @version summoner-v1.4 */
public class RunePages {
  /**
   * Collection of rune pages associated with the summoner. */
  public List<RunePage> pages;

  /**
   * Summoner ID. */
  public long summonerId;
}