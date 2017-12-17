package com.mingweisamuel.zyra.tournament;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * TournamentCode.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class TournamentCode implements Serializable {
  /**
   * The tournament code. */
  public final String code;

  /**
   * The tournament code's ID. */
  public final int id;

  /**
   * The lobby name for the tournament code game. */
  public final String lobbyName;

  /**
   * The game map for the tournament code game */
  public final String map;

  /**
   * The metadata for tournament code. */
  public final String metaData;

  public final List<Long> participants;

  /**
   * The password for the tournament code game. */
  public final String password;

  /**
   * The pick mode for tournament code game. */
  public final String pickType;

  /**
   * The provider's ID. */
  public final int providerId;

  /**
   * The tournament code's region.
   *              (Legal values:  BR,  EUNE,  EUW,  JP,  LAN,  LAS,  NA,  OCE,  PBE,  RU,  TR) */
  public final String region;

  /**
   * The spectator mode for the tournament code game. */
  public final String spectators;

  /**
   * The team size for the tournament code game. */
  public final int teamSize;

  /**
   * The tournament's ID. */
  public final int tournamentId;

  public TournamentCode(final String code, final int id, final String lobbyName, final String map,
      final String metaData, final List<Long> participants, final String password,
      final String pickType, final int providerId, final String region, final String spectators,
      final int teamSize, final int tournamentId) {
    this.code = code;
    this.id = id;
    this.lobbyName = lobbyName;
    this.map = map;
    this.metaData = metaData;
    this.participants = participants;
    this.password = password;
    this.pickType = pickType;
    this.providerId = providerId;
    this.region = region;
    this.spectators = spectators;
    this.teamSize = teamSize;
    this.tournamentId = tournamentId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof TournamentCode)) return false;
    final TournamentCode other = (TournamentCode) obj;
    return true
        && Objects.equal(code, other.code)
        && Objects.equal(id, other.id)
        && Objects.equal(lobbyName, other.lobbyName)
        && Objects.equal(map, other.map)
        && Objects.equal(metaData, other.metaData)
        && Objects.equal(participants, other.participants)
        && Objects.equal(password, other.password)
        && Objects.equal(pickType, other.pickType)
        && Objects.equal(providerId, other.providerId)
        && Objects.equal(region, other.region)
        && Objects.equal(spectators, other.spectators)
        && Objects.equal(teamSize, other.teamSize)
        && Objects.equal(tournamentId, other.tournamentId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        code,
        id,
        lobbyName,
        map,
        metaData,
        participants,
        password,
        pickType,
        providerId,
        region,
        spectators,
        teamSize,
        tournamentId);}
}
