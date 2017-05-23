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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getCurrentGameInfoBySummoner">Riot API reference</a> on Tue May 23 09:10:03 PDT 2017. */
public class CurrentGameInfo implements Serializable {
  /**
   * The ID of the game */
  public final long gameId;

  /**
   * The game start time represented in epoch milliseconds */
  public final long gameStartTime;

  /**
   * The ID of the platform on which the game is being played */
  public final String platformId;

  /**
   * The game mode */
  public final String gameMode;

  /**
   * The ID of the map */
  public final long mapId;

  /**
   * The game type */
  public final String gameType;

  /**
   * Banned champion information */
  public final List<BannedChampion> bannedChampions;

  /**
   * The observer information */
  public final Observer observers;

  /**
   * The participant information */
  public final List<CurrentGameParticipant> participants;

  /**
   * The amount of time in seconds that has passed since the game started */
  public final long gameLength;

  /**
   * The queue type (queue types are documented on the Game Constants page) */
  public final long gameQueueConfigId;

  public CurrentGameInfo(final long gameId, final long gameStartTime, final String platformId,
      final String gameMode, final long mapId, final String gameType,
      final List<BannedChampion> bannedChampions, final Observer observers,
      final List<CurrentGameParticipant> participants, final long gameLength,
      final long gameQueueConfigId) {
    this.gameId = gameId;
    this.gameStartTime = gameStartTime;
    this.platformId = platformId;
    this.gameMode = gameMode;
    this.mapId = mapId;
    this.gameType = gameType;
    this.bannedChampions = bannedChampions;
    this.observers = observers;
    this.participants = participants;
    this.gameLength = gameLength;
    this.gameQueueConfigId = gameQueueConfigId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof CurrentGameInfo)) return false;
    final CurrentGameInfo other = (CurrentGameInfo) obj;
    return true
        && Objects.equal(gameId, other.gameId)
        && Objects.equal(gameStartTime, other.gameStartTime)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(gameMode, other.gameMode)
        && Objects.equal(mapId, other.mapId)
        && Objects.equal(gameType, other.gameType)
        && Objects.equal(bannedChampions, other.bannedChampions)
        && Objects.equal(observers, other.observers)
        && Objects.equal(participants, other.participants)
        && Objects.equal(gameLength, other.gameLength)
        && Objects.equal(gameQueueConfigId, other.gameQueueConfigId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        gameId,
        gameStartTime,
        platformId,
        gameMode,
        mapId,
        gameType,
        bannedChampions,
        observers,
        participants,
        gameLength,
        gameQueueConfigId);}
}
