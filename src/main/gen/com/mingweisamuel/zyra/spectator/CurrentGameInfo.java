package com.mingweisamuel.zyra.spectator;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * CurrentGameInfo.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class CurrentGameInfo implements Serializable {
  /**
   * Banned champion information */
  public final List<BannedChampion> bannedChampions;

  /**
   * The ID of the game */
  public final long gameId;

  /**
   * The amount of time in seconds that has passed since the game started */
  public final long gameLength;

  /**
   * The game mode */
  public final String gameMode;

  /**
   * The queue type (queue types are documented on the Game Constants page) */
  public final long gameQueueConfigId;

  /**
   * The game start time represented in epoch milliseconds */
  public final long gameStartTime;

  /**
   * The game type */
  public final String gameType;

  /**
   * The ID of the map */
  public final long mapId;

  /**
   * The observer information */
  public final Observer observers;

  /**
   * The participant information */
  public final List<CurrentGameParticipant> participants;

  /**
   * The ID of the platform on which the game is being played */
  public final String platformId;

  public CurrentGameInfo(final List<BannedChampion> bannedChampions, final long gameId,
      final long gameLength, final String gameMode, final long gameQueueConfigId,
      final long gameStartTime, final String gameType, final long mapId, final Observer observers,
      final List<CurrentGameParticipant> participants, final String platformId) {
    this.bannedChampions = bannedChampions;
    this.gameId = gameId;
    this.gameLength = gameLength;
    this.gameMode = gameMode;
    this.gameQueueConfigId = gameQueueConfigId;
    this.gameStartTime = gameStartTime;
    this.gameType = gameType;
    this.mapId = mapId;
    this.observers = observers;
    this.participants = participants;
    this.platformId = platformId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof CurrentGameInfo)) return false;
    final CurrentGameInfo other = (CurrentGameInfo) obj;
    return true
        && Objects.equal(bannedChampions, other.bannedChampions)
        && Objects.equal(gameId, other.gameId)
        && Objects.equal(gameLength, other.gameLength)
        && Objects.equal(gameMode, other.gameMode)
        && Objects.equal(gameQueueConfigId, other.gameQueueConfigId)
        && Objects.equal(gameStartTime, other.gameStartTime)
        && Objects.equal(gameType, other.gameType)
        && Objects.equal(mapId, other.mapId)
        && Objects.equal(observers, other.observers)
        && Objects.equal(participants, other.participants)
        && Objects.equal(platformId, other.platformId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        bannedChampions,
        gameId,
        gameLength,
        gameMode,
        gameQueueConfigId,
        gameStartTime,
        gameType,
        mapId,
        observers,
        participants,
        platformId);}
}
