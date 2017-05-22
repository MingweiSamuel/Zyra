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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Riot API reference</a> on Sun May 21 18:03:38 PDT 2017. */
public class Match implements Serializable {
  public final int seasonId;

  public final int queueId;

  public final long gameId;

  public final List<ParticipantIdentity> participantIdentities;

  public final String gameVersion;

  public final String platformId;

  public final String gameMode;

  public final int mapId;

  public final String gameType;

  public final List<TeamStats> teams;

  public final List<Participant> participants;

  public final long gameDuration;

  public final long gameCreation;

  public Match(final int seasonId, final int queueId, final long gameId,
      final List<ParticipantIdentity> participantIdentities, final String gameVersion,
      final String platformId, final String gameMode, final int mapId, final String gameType,
      final List<TeamStats> teams, final List<Participant> participants, final long gameDuration,
      final long gameCreation) {
    this.seasonId = seasonId;
    this.queueId = queueId;
    this.gameId = gameId;
    this.participantIdentities = participantIdentities;
    this.gameVersion = gameVersion;
    this.platformId = platformId;
    this.gameMode = gameMode;
    this.mapId = mapId;
    this.gameType = gameType;
    this.teams = teams;
    this.participants = participants;
    this.gameDuration = gameDuration;
    this.gameCreation = gameCreation;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(seasonId, other.seasonId)
        && Objects.equal(queueId, other.queueId)
        && Objects.equal(gameId, other.gameId)
        && Objects.equal(participantIdentities, other.participantIdentities)
        && Objects.equal(gameVersion, other.gameVersion)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(gameMode, other.gameMode)
        && Objects.equal(mapId, other.mapId)
        && Objects.equal(gameType, other.gameType)
        && Objects.equal(teams, other.teams)
        && Objects.equal(participants, other.participants)
        && Objects.equal(gameDuration, other.gameDuration)
        && Objects.equal(gameCreation, other.gameCreation);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        seasonId,
        queueId,
        gameId,
        participantIdentities,
        gameVersion,
        platformId,
        gameMode,
        mapId,
        gameType,
        teams,
        participants,
        gameDuration,
        gameCreation);}
}
