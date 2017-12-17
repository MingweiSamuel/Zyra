package com.mingweisamuel.zyra.match;

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
  public final long gameCreation;

  public final long gameDuration;

  public final long gameId;

  public final String gameMode;

  public final String gameType;

  public final String gameVersion;

  public final int mapId;

  public final List<ParticipantIdentity> participantIdentities;

  public final List<Participant> participants;

  public final String platformId;

  public final int queueId;

  public final int seasonId;

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
