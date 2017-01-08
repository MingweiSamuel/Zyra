package com.mingweisamuel.zyra.dto;

/**
 * ChampionStats - This object contains a collection of champion stats information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version stats-v1.3 */
public class ChampionStats {
  /**
   * Champion ID. Note that champion ID 0 represents the combined stats for all champions. For static information correlating to champion IDs, please refer to the LoL Static Data API. */
  public int id;

  /**
   * Aggregated stats associated with the champion. */
  public AggregatedStats stats;
}
