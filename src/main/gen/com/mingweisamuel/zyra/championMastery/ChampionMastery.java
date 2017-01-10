package com.mingweisamuel.zyra.championMastery;

/**
 * ChampionMastery - This object contains single Champion Mastery information for player and champion combination.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version championmastery */
public class ChampionMastery {
  /**
   * Champion ID for this entry. */
  public long championId;

  /**
   * Champion level for specified player and champion combination. */
  public int championLevel;

  /**
   * Total number of champion points for this player and champion combination - they are used to determine championLevel. */
  public int championPoints;

  /**
   * Number of points earned since current level has been achieved. Zero if player reached maximum champion level for this champion. */
  public long championPointsSinceLastLevel;

  /**
   * Number of points needed to achieve next level. Zero if player reached maximum champion level for this champion. */
  public long championPointsUntilNextLevel;

  /**
   * Is chest granted for this champion or not in current season. */
  public boolean chestGranted;

  /**
   * Last time this champion was played by this player - in Unix milliseconds time format. */
  public long lastPlayTime;

  /**
   * Player ID for this entry. */
  public long playerId;
}
