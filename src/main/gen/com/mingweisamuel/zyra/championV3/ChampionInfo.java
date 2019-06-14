package com.mingweisamuel.zyra.championV3;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * ChampionInfo.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ChampionInfo implements Serializable {
  public final List<Integer> freeChampionIds;

  public final List<Integer> freeChampionIdsForNewPlayers;

  public final int maxNewPlayerLevel;

  public ChampionInfo(final List<Integer> freeChampionIds,
      final List<Integer> freeChampionIdsForNewPlayers, final int maxNewPlayerLevel) {
    this.freeChampionIds = freeChampionIds;
    this.freeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
    this.maxNewPlayerLevel = maxNewPlayerLevel;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ChampionInfo)) return false;
    final ChampionInfo other = (ChampionInfo) obj;
    return true
        && Objects.equal(freeChampionIds, other.freeChampionIds)
        && Objects.equal(freeChampionIdsForNewPlayers, other.freeChampionIdsForNewPlayers)
        && Objects.equal(maxNewPlayerLevel, other.maxNewPlayerLevel);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        freeChampionIds,
        freeChampionIdsForNewPlayers,
        maxNewPlayerLevel);}
}
