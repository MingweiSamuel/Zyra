package com.mingweisamuel.zyra.tournamentV4;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * TournamentCodeUpdateParameters.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class TournamentCodeUpdateParameters implements Serializable {
  /**
   * Optional list of encrypted summonerIds in order to validate the players eligible to join the lobby. NOTE: We currently do not enforce participants at the team level, but rather the aggregate of teamOne and teamTwo. We may add the ability to enforce at the team level in the future. */
  public final List<String> allowedSummonerIds;

  /**
   * The map type
   *              (Legal values:  SUMMONERS_RIFT,  TWISTED_TREELINE,  HOWLING_ABYSS) */
  public final String mapType;

  /**
   * The pick type
   *              (Legal values:  BLIND_PICK,  DRAFT_MODE,  ALL_RANDOM,  TOURNAMENT_DRAFT) */
  public final String pickType;

  /**
   * The spectator type
   *              (Legal values:  NONE,  LOBBYONLY,  ALL) */
  public final String spectatorType;

  public TournamentCodeUpdateParameters(final List<String> allowedSummonerIds, final String mapType,
      final String pickType, final String spectatorType) {
    this.allowedSummonerIds = allowedSummonerIds;
    this.mapType = mapType;
    this.pickType = pickType;
    this.spectatorType = spectatorType;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof TournamentCodeUpdateParameters)) return false;
    final TournamentCodeUpdateParameters other = (TournamentCodeUpdateParameters) obj;
    return true
        && Objects.equal(allowedSummonerIds, other.allowedSummonerIds)
        && Objects.equal(mapType, other.mapType)
        && Objects.equal(pickType, other.pickType)
        && Objects.equal(spectatorType, other.spectatorType);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        allowedSummonerIds,
        mapType,
        pickType,
        spectatorType);}
}
