package com.mingweisamuel.zyra.stats;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * RankedStats - This object contains ranked stats information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version stats-v1.3 */
public class RankedStats implements Serializable {
  /**
   * Collection of aggregated stats summarized by champion. */
  public final List<ChampionStats> champions;

  /**
   * Date stats were last modified specified as epoch milliseconds. */
  public final long modifyDate;

  /**
   * Summoner ID. */
  public final long summonerId;

  public RankedStats(final List<ChampionStats> champions, final long modifyDate,
      final long summonerId) {
    this.champions = champions;
    this.modifyDate = modifyDate;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof RankedStats)) return false;
    final RankedStats other = (RankedStats) obj;
    return true
        && Objects.equal(champions, other.champions)
        && Objects.equal(modifyDate, other.modifyDate)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        champions,
        modifyDate,
        summonerId);}
}
