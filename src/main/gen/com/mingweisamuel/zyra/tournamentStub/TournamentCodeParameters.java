package com.mingweisamuel.zyra.tournamentStub;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * TournamentCodeParameters.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class TournamentCodeParameters implements Serializable {
  /**
   * Optional list of participants in order to validate the players eligible to join the lobby. NOTE: We currently do not enforce participants at the team level, but rather the aggregate of teamOne and teamTwo. We may add the ability to enforce at the team level in the future. */
  public final SummonerIdParams allowedSummonerIds;

  /**
   * The map type of the game.
   *              (Legal values:  SUMMONERS_RIFT,  TWISTED_TREELINE,  HOWLING_ABYSS) */
  public final String mapType;

  /**
   * Optional string that may contain any data in any format, if specified at all. Used to denote any custom information about the game. */
  public final String metadata;

  /**
   * The pick type of the game.
   *              (Legal values:  BLIND_PICK,  DRAFT_MODE,  ALL_RANDOM,  TOURNAMENT_DRAFT) */
  public final String pickType;

  /**
   * The spectator type of the game.
   *              (Legal values:  NONE,  LOBBYONLY,  ALL) */
  public final String spectatorType;

  /**
   * The team size of the game. Valid values are 1-5. */
  public final int teamSize;

  public TournamentCodeParameters(final SummonerIdParams allowedSummonerIds, final String mapType,
      final String metadata, final String pickType, final String spectatorType,
      final int teamSize) {
    this.allowedSummonerIds = allowedSummonerIds;
    this.mapType = mapType;
    this.metadata = metadata;
    this.pickType = pickType;
    this.spectatorType = spectatorType;
    this.teamSize = teamSize;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof TournamentCodeParameters)) return false;
    final TournamentCodeParameters other = (TournamentCodeParameters) obj;
    return true
        && Objects.equal(allowedSummonerIds, other.allowedSummonerIds)
        && Objects.equal(mapType, other.mapType)
        && Objects.equal(metadata, other.metadata)
        && Objects.equal(pickType, other.pickType)
        && Objects.equal(spectatorType, other.spectatorType)
        && Objects.equal(teamSize, other.teamSize);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        allowedSummonerIds,
        mapType,
        metadata,
        pickType,
        spectatorType,
        teamSize);}
}
