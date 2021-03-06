package com.mingweisamuel.zyra.championMasteryV4;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * ChampionMastery.<br><br>
 *
 * This object contains single Champion Mastery information for player and champion combination..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ChampionMastery implements Serializable {
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
   * Number of points earned since current level has been achieved. */
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
   * Summoner ID for this entry. (Encrypted) */
  public final String summonerId;

  /**
   * The token earned for this champion to levelup. */
  public final int tokensEarned;

  public ChampionMastery(final int championId, final int championLevel, final int championPoints,
      final long championPointsSinceLastLevel, final long championPointsUntilNextLevel,
      final boolean chestGranted, final long lastPlayTime, final String summonerId,
      final int tokensEarned) {
    this.championId = championId;
    this.championLevel = championLevel;
    this.championPoints = championPoints;
    this.championPointsSinceLastLevel = championPointsSinceLastLevel;
    this.championPointsUntilNextLevel = championPointsUntilNextLevel;
    this.chestGranted = chestGranted;
    this.lastPlayTime = lastPlayTime;
    this.summonerId = summonerId;
    this.tokensEarned = tokensEarned;
  }

  @Override
  public boolean equals(final Object obj) {
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
        && Objects.equal(summonerId, other.summonerId)
        && Objects.equal(tokensEarned, other.tokensEarned);}

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
        summonerId,
        tokensEarned);}
}
