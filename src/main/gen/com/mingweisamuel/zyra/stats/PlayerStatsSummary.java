package com.mingweisamuel.zyra.stats;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * PlayerStatsSummary.<br><br>
 *
 * This object contains player stats summary information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#stats-v1.3/GET_getPlayerStatsSummary">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class PlayerStatsSummary implements Serializable {
  /**
   * Number of wins for this queue type. */
  public final int wins;

  /**
   * Aggregated stats. */
  public final AggregatedStats aggregatedStats;

  /**
   * Date stats were last modified specified as epoch milliseconds. */
  public final long modifyDate;

  /**
   * Player stats summary type. */
  public final String playerStatSummaryType;

  /**
   * Number of losses for this queue type. Returned for ranked queue types only. */
  public final int losses;

  public PlayerStatsSummary(final int wins, final AggregatedStats aggregatedStats,
      final long modifyDate, final String playerStatSummaryType, final int losses) {
    this.wins = wins;
    this.aggregatedStats = aggregatedStats;
    this.modifyDate = modifyDate;
    this.playerStatSummaryType = playerStatSummaryType;
    this.losses = losses;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof PlayerStatsSummary)) return false;
    final PlayerStatsSummary other = (PlayerStatsSummary) obj;
    return true
        && Objects.equal(wins, other.wins)
        && Objects.equal(aggregatedStats, other.aggregatedStats)
        && Objects.equal(modifyDate, other.modifyDate)
        && Objects.equal(playerStatSummaryType, other.playerStatSummaryType)
        && Objects.equal(losses, other.losses);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        wins,
        aggregatedStats,
        modifyDate,
        playerStatSummaryType,
        losses);}
}
