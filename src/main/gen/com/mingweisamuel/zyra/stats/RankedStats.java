package com.mingweisamuel.zyra.stats;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * RankedStats.<br><br>
 *
 * This object contains ranked stats information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#stats-v1.3/GET_getRankedStats">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class RankedStats implements Serializable {
  /**
   * Date stats were last modified specified as epoch milliseconds. */
  public final long modifyDate;

  /**
   * Collection of aggregated stats summarized by champion. */
  public final List<ChampionStats> champions;

  /**
   * Summoner ID. */
  public final long summonerId;

  public RankedStats(final long modifyDate, final List<ChampionStats> champions,
      final long summonerId) {
    this.modifyDate = modifyDate;
    this.champions = champions;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof RankedStats)) return false;
    final RankedStats other = (RankedStats) obj;
    return true
        && Objects.equal(modifyDate, other.modifyDate)
        && Objects.equal(champions, other.champions)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        modifyDate,
        champions,
        summonerId);}
}
