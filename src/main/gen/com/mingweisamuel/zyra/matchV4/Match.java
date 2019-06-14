package com.mingweisamuel.zyra.matchV4;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Match.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Match implements Serializable {
  /**
   * Designates the timestamp when champion select ended and the loading screen appeared, NOT when the game timer was at 0:00. */
  public final long gameCreation;

  /**
   * Match duration in seconds. */
  public final long gameDuration;

  public final long gameId;

  /**
   * Please refer to the Game Constants documentation. */
  public final String gameMode;

  /**
   * Please refer to the Game Constants documentation. */
  public final String gameType;

  /**
   * The major.minor version typically indicates the patch the match was played on. */
  public final String gameVersion;

  /**
   * Please refer to the Game Constants documentation. */
  public final int mapId;

  /**
   * Participant identity information. */
  public final List<ParticipantIdentity> participantIdentities;

  /**
   * Participant information. */
  public final List<Participant> participants;

  /**
   * Platform where the match was played. */
  public final String platformId;

  /**
   * Please refer to the Game Constants documentation. */
  public final int queueId;

  /**
   * Please refer to the Game Constants documentation. */
  public final int seasonId;

  /**
   * Team information. */
  public final List<TeamStats> teams;

  public Match(final long gameCreation, final long gameDuration, final long gameId,
      final String gameMode, final String gameType, final String gameVersion, final int mapId,
      final List<ParticipantIdentity> participantIdentities, final List<Participant> participants,
      final String platformId, final int queueId, final int seasonId, final List<TeamStats> teams) {
    this.gameCreation = gameCreation;
    this.gameDuration = gameDuration;
    this.gameId = gameId;
    this.gameMode = gameMode;
    this.gameType = gameType;
    this.gameVersion = gameVersion;
    this.mapId = mapId;
    this.participantIdentities = participantIdentities;
    this.participants = participants;
    this.platformId = platformId;
    this.queueId = queueId;
    this.seasonId = seasonId;
    this.teams = teams;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(gameCreation, other.gameCreation)
        && Objects.equal(gameDuration, other.gameDuration)
        && Objects.equal(gameId, other.gameId)
        && Objects.equal(gameMode, other.gameMode)
        && Objects.equal(gameType, other.gameType)
        && Objects.equal(gameVersion, other.gameVersion)
        && Objects.equal(mapId, other.mapId)
        && Objects.equal(participantIdentities, other.participantIdentities)
        && Objects.equal(participants, other.participants)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(queueId, other.queueId)
        && Objects.equal(seasonId, other.seasonId)
        && Objects.equal(teams, other.teams);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        gameCreation,
        gameDuration,
        gameId,
        gameMode,
        gameType,
        gameVersion,
        mapId,
        participantIdentities,
        participants,
        platformId,
        queueId,
        seasonId,
        teams);}
}
