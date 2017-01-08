package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;

/**
 * FeaturedGameInfo
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version featured-games-v1.0 */
public class FeaturedGameInfo {
  /**
   * Banned champion information */
  public List<BannedChampion> bannedChampions;

  /**
   * The ID of the game */
  public long gameId;

  /**
   * The amount of time in seconds that has passed since the game started */
  public long gameLength;

  /**
   * The game mode (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO) */
  public String gameMode;

  /**
   * The queue type (queue types are documented on the Game Constants page) */
  public long gameQueueConfigId;

  /**
   * The game start time represented in epoch milliseconds */
  public long gameStartTime;

  /**
   * The game type (Legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME) */
  public String gameType;

  /**
   * The ID of the map */
  public long mapId;

  /**
   * The observer information */
  public Observer observers;

  /**
   * The participant information */
  public List<Participant> participants;

  /**
   * The ID of the platform on which the game is being played */
  public String platformId;
}
