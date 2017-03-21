package com.mingweisamuel.zyra.stats;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * This object contains a collection of player stats summary information..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#stats-v1.3/GET_getPlayerStatsSummary">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class PlayerStatsSummaryList {
  /**
   * Collection of player stats summaries associated with the summoner. */
  public final List<PlayerStatsSummary> playerStatSummaries;

  /**
   * Summoner ID. */
  public final long summonerId;

  public PlayerStatsSummaryList(final List<PlayerStatsSummary> playerStatSummaries,
      final long summonerId) {
    this.playerStatSummaries = playerStatSummaries;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Stats)) return false;
    final Stats other = (Stats) obj;
    return true
        && Objects.equal(playerStatSummaries, other.playerStatSummaries)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        playerStatSummaries,
        summonerId);}
}
