package com.mingweisamuel.zyra.championMastery;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * ChampionMastery - This object contains single Champion Mastery information for player and champion combination.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version championmastery */
public class ChampionMastery {
  /**
   * Champion ID for this entry. */
  public final int championId;

  /**
   * Champion level for specified player and champion combination. */
  public final int championLevel;

  /**
   * Total number of champion points for this player and champion combination - they are used to determine championLevel. */
  public final int championPoints;

  /**
   * Number of points earned since current level has been achieved. Zero if player reached maximum champion level for this champion. */
  public final long championPointsSinceLastLevel;

  /**
   * Number of points needed to achieve next level. Zero if player reached maximum champion level for this champion. */
  public final long championPointsUntilNextLevel;

  /**
   * Is chest granted for this champion or not in current season. */
  public final boolean chestGranted;

  /**
   * Last time this champion was played by this player - in Unix milliseconds time format. */
  public final long lastPlayTime;

  /**
   * Player ID for this entry. */
  public final long playerId;

  public ChampionMastery(final int championId, final int championLevel, final int championPoints,
      final long championPointsSinceLastLevel, final long championPointsUntilNextLevel,
      final boolean chestGranted, final long lastPlayTime, final long playerId) {
    this.championId = championId;
    this.championLevel = championLevel;
    this.championPoints = championPoints;
    this.championPointsSinceLastLevel = championPointsSinceLastLevel;
    this.championPointsUntilNextLevel = championPointsUntilNextLevel;
    this.chestGranted = chestGranted;
    this.lastPlayTime = lastPlayTime;
    this.playerId = playerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof ChampionMastery)) return false;
    final ChampionMastery other = (ChampionMastery) obj;
    return true
        && Objects.equal(championId, other.championId)
        && Objects.equal(championLevel, other.championLevel)
        && Objects.equal(championPoints, other.championPoints)
        && Objects.equal(championPointsSinceLastLevel, other.championPointsSinceLastLevel)
        && Objects.equal(championPointsUntilNextLevel, other.championPointsUntilNextLevel)
        && Objects.equal(chestGranted, other.chestGranted)
        && Objects.equal(lastPlayTime, other.lastPlayTime)
        && Objects.equal(playerId, other.playerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        championId,
        championLevel,
        championPoints,
        championPointsSinceLastLevel,
        championPointsUntilNextLevel,
        chestGranted,
        lastPlayTime,
        playerId);}
}
