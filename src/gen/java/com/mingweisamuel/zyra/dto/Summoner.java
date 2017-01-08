package com.mingweisamuel.zyra.dto;

import java.lang.String;

/**
 * Summoner - This object contains summoner information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version summoner-v1.4 */
public class Summoner {
  /**
   * Summoner ID. */
  public long id;

  /**
   * Summoner name. */
  public String name;

  /**
   * ID of the summoner icon associated with the summoner. */
  public int profileIconId;

  /**
   * Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name change */
  public long revisionDate;

  /**
   * Summoner level associated with the summoner. */
  public long summonerLevel;
}
