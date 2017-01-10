package com.mingweisamuel.zyra.stats;

import java.util.List;

/**
 * PlayerStatsSummaryList - This object contains a collection of player stats summary information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version stats-v1.3 */
public class PlayerStatsSummaryList {
  /**
   * Collection of player stats summaries associated with the summoner. */
  public List<PlayerStatsSummary> playerStatSummaries;

  /**
   * Summoner ID. */
  public long summonerId;
}
