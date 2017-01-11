package com.mingweisamuel.zyra.featuredGames;

import java.lang.String;

/**
 * Participant
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version featured-games-v1.0 */
public class Participant {
  /**
   * Flag indicating whether or not this participant is a bot */
  public boolean bot;

  /**
   * The ID of the champion played by this participant */
  public int championId;

  /**
   * The ID of the profile icon used by this participant */
  public long profileIconId;

  /**
   * The ID of the first summoner spell used by this participant */
  public long spell1Id;

  /**
   * The ID of the second summoner spell used by this participant */
  public long spell2Id;

  /**
   * The summoner name of this participant */
  public String summonerName;

  /**
   * The team ID of this participant, indicating the participant's team */
  public long teamId;
}
