package com.mingweisamuel.zyra.stats;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ChampionStats - This object contains a collection of champion stats information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version stats-v1.3 */
public class ChampionStats implements Serializable {
  /**
   * Champion ID. Note that champion ID 0 represents the combined stats for all champions. For static information correlating to champion IDs, please refer to the LoL Static Data API. */
  public final int id;

  /**
   * Aggregated stats associated with the champion. */
  public final AggregatedStats stats;

  public ChampionStats(final int id, final AggregatedStats stats) {
    this.id = id;
    this.stats = stats;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ChampionStats)) return false;
    final ChampionStats other = (ChampionStats) obj;
    return true
        && Objects.equal(id, other.id)
        && Objects.equal(stats, other.stats);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        id,
        stats);}
}
