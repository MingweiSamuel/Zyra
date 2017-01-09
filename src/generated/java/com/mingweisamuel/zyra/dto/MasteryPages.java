package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * MasteryPages - This object contains masteries information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link RiotDtoGenerator}.
 *
 * @version summoner-v1.4 */
public class MasteryPages {
  /**
   * Collection of mastery pages associated with the summoner. */
  public List<MasteryPage> pages;

  /**
   * Summoner ID. */
  public long summonerId;
}
