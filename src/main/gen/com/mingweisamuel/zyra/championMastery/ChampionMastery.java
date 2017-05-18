package com.mingweisamuel.zyra.championMastery;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ChampionMastery.<br><br>
 *
 * This object contains single Champion Mastery information for player and champion combination..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#champion-mastery-v3/GET_getAllChampionMasteries">Riot API reference</a> on Wed May 17 21:34:50 PDT 2017. */
public class ChampionMastery implements Serializable {
  /**
   * Is chest granted for this champion or not in current season. */
  public final boolean chestGranted;

  /**
   * Champion level for specified player and champion combination. */
  public final int championLevel;

  /**
   * Total number of champion points for this player and champion combination - they are used to determine championLevel. */
  public final int championPoints;

  /**
   * Champion ID for this entry. */
  public final int championId;

  /**
   * Player ID for this entry. */
  public final long playerId;

  /**
   * Number of points needed to achieve next level. Zero if player reached maximum champion level for this champion. */
  public final long championPointsUntilNextLevel;

  /**
   * Number of points earned since current level has been achieved. Zero if player reached maximum champion level for this champion. */
  public final long championPointsSinceLastLevel;

  /**
   * Last time this champion was played by this player - in Unix milliseconds time format. */
  public final long lastPlayTime;

  public ChampionMastery(final boolean chestGranted, final int championLevel,
      final int championPoints, final int championId, final long playerId,
      final long championPointsUntilNextLevel, final long championPointsSinceLastLevel,
      final long lastPlayTime) {
    this.chestGranted = chestGranted;
    this.championLevel = championLevel;
    this.championPoints = championPoints;
    this.championId = championId;
    this.playerId = playerId;
    this.championPointsUntilNextLevel = championPointsUntilNextLevel;
    this.championPointsSinceLastLevel = championPointsSinceLastLevel;
    this.lastPlayTime = lastPlayTime;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ChampionMastery)) return false;
    final ChampionMastery other = (ChampionMastery) obj;
    return true
        && Objects.equal(chestGranted, other.chestGranted)
        && Objects.equal(championLevel, other.championLevel)
        && Objects.equal(championPoints, other.championPoints)
        && Objects.equal(championId, other.championId)
        && Objects.equal(playerId, other.playerId)
        && Objects.equal(championPointsUntilNextLevel, other.championPointsUntilNextLevel)
        && Objects.equal(championPointsSinceLastLevel, other.championPointsSinceLastLevel)
        && Objects.equal(lastPlayTime, other.lastPlayTime);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        chestGranted,
        championLevel,
        championPoints,
        championId,
        playerId,
        championPointsUntilNextLevel,
        championPointsSinceLastLevel,
        lastPlayTime);}
}
