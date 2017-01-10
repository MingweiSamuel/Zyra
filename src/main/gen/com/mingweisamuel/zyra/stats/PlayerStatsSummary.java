package com.mingweisamuel.zyra.stats;

import java.lang.String;

/**
 * PlayerStatsSummary - This object contains player stats summary information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version stats-v1.3 */
public class PlayerStatsSummary {
  /**
   * Aggregated stats. */
  public AggregatedStats aggregatedStats;

  /**
   * Number of losses for this queue type. Returned for ranked queue types only. */
  public int losses;

  /**
   * Date stats were last modified specified as epoch milliseconds. */
  public long modifyDate;

  /**
   * Player stats summary type. (Legal values: AramUnranked5x5, Ascension, Bilgewater, CAP5x5, CoopVsAI, CoopVsAI3x3, CounterPick, FirstBlood1x1, FirstBlood2x2, Hexakill, KingPoro, NightmareBot, OdinUnranked, OneForAll5x5, RankedPremade3x3, RankedPremade5x5, RankedSolo5x5, RankedTeam3x3, RankedTeam5x5, SummonersRift6x6, Unranked, Unranked3x3, URF, URFBots, Siege, RankedFlexSR, RankedFlexTT) */
  public String playerStatSummaryType;

  /**
   * Number of wins for this queue type. */
  public int wins;
}
