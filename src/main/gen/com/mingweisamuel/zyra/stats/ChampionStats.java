package com.mingweisamuel.zyra.stats;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ChampionStats.<br><br>
 *
 * This object contains a collection of champion stats information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#stats-v1.3/GET_getRankedStats">Riot API reference</a> on Tue Mar 21 15:10:48 PDT 2017. */
public class ChampionStats implements Serializable {
  /**
   * Aggregated stats associated with the champion. */
  public final AggregatedStats stats;

  /**
   * Champion ID. Note that champion ID 0 represents the combined stats for all champions. For static information correlating to champion IDs, please refer to the LoL Static Data API. */
  public final int id;

  public ChampionStats(final AggregatedStats stats, final int id) {
    this.stats = stats;
    this.id = id;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ChampionStats)) return false;
    final ChampionStats other = (ChampionStats) obj;
    return true
        && Objects.equal(stats, other.stats)
        && Objects.equal(id, other.id);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        stats,
        id);}
}
