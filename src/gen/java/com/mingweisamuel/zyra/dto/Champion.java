package com.mingweisamuel.zyra.dto;

/**
 * Champion - This object contains champion information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version champion-v1.2 */
public class Champion {
  /**
   * Indicates if the champion is active. */
  public boolean active;

  /**
   * Bot enabled flag (for custom games). */
  public boolean botEnabled;

  /**
   * Bot Match Made enabled flag (for Co-op vs. AI games). */
  public boolean botMmEnabled;

  /**
   * Indicates if the champion is free to play. Free to play champions are rotated periodically. */
  public boolean freeToPlay;

  /**
   * Champion ID. For static information correlating to champion IDs, please refer to the LoL Static Data API. */
  public long id;

  /**
   * Ranked play enabled flag. */
  public boolean rankedPlayEnabled;
}
