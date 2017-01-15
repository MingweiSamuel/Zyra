package com.mingweisamuel.zyra.stats;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
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
  public final AggregatedStats aggregatedStats;

  /**
   * Number of losses for this queue type. Returned for ranked queue types only. */
  public final int losses;

  /**
   * Date stats were last modified specified as epoch milliseconds. */
  public final long modifyDate;

  /**
   * Player stats summary type. (Legal values: AramUnranked5x5, Ascension, Bilgewater, CAP5x5, CoopVsAI, CoopVsAI3x3, CounterPick, FirstBlood1x1, FirstBlood2x2, Hexakill, KingPoro, NightmareBot, OdinUnranked, OneForAll5x5, RankedPremade3x3, RankedPremade5x5, RankedSolo5x5, RankedTeam3x3, RankedTeam5x5, SummonersRift6x6, Unranked, Unranked3x3, URF, URFBots, Siege, RankedFlexSR, RankedFlexTT) */
  public final String playerStatSummaryType;

  /**
   * Number of wins for this queue type. */
  public final int wins;

  public PlayerStatsSummary(final AggregatedStats aggregatedStats, final int losses,
      final long modifyDate, final String playerStatSummaryType, final int wins) {
    this.aggregatedStats = aggregatedStats;
    this.losses = losses;
    this.modifyDate = modifyDate;
    this.playerStatSummaryType = playerStatSummaryType;
    this.wins = wins;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof PlayerStatsSummary)) return false;
    final PlayerStatsSummary other = (PlayerStatsSummary) obj;
    return true
        && Objects.equal(aggregatedStats, other.aggregatedStats)
        && Objects.equal(losses, other.losses)
        && Objects.equal(modifyDate, other.modifyDate)
        && Objects.equal(playerStatSummaryType, other.playerStatSummaryType)
        && Objects.equal(wins, other.wins);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        aggregatedStats,
        losses,
        modifyDate,
        playerStatSummaryType,
        wins);}
}
