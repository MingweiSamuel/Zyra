package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.tournament.LobbyEventDTOWrapper;
import com.mingweisamuel.zyra.tournament.TournamentCode;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * tournament-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class TournamentEndpoints extends Endpoints {
  TournamentEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Returns the tournament code DTO associated with a tournament code string.
   *
   * <a href="https://developer.riotgames.com/api-methods/#tournament-v3/GET_getTournamentCode">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param tournamentCode (required) The tournament code string.
   */
  public TournamentCode getTournamentCode(final Region region, final String tournamentCode) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/tournament/v3/codes/%1$s", tournamentCode);
    Type type = TournamentCode.class;
    return riotApi.getBasic("tournament-v3.getTournamentCode", url, region, type, Collections.emptyList());
  }

  /**
   * Returns the tournament code DTO associated with a tournament code string.
   *
   * <a href="https://developer.riotgames.com/api-methods/#tournament-v3/GET_getTournamentCode">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param tournamentCode (required) The tournament code string.
   */
  public CompletableFuture<TournamentCode> getTournamentCodeAsync(final Region region,
      final String tournamentCode) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/tournament/v3/codes/%1$s", tournamentCode);
    Type type = TournamentCode.class;
    return riotApi.getBasicAsync("tournament-v3.getTournamentCode", url, region, type, Collections.emptyList());
  }

  /**
   * Gets a list of lobby events by tournament code.
   *
   * <a href="https://developer.riotgames.com/api-methods/#tournament-v3/GET_getLobbyEventsByCode">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param tournamentCode (required) The short code to look up lobby events for
   */
  public LobbyEventDTOWrapper getLobbyEventsByCode(final Region region,
      final String tournamentCode) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/tournament/v3/lobby-events/by-code/%1$s", tournamentCode);
    Type type = LobbyEventDTOWrapper.class;
    return riotApi.getBasic("tournament-v3.getLobbyEventsByCode", url, region, type, Collections.emptyList());
  }

  /**
   * Gets a list of lobby events by tournament code.
   *
   * <a href="https://developer.riotgames.com/api-methods/#tournament-v3/GET_getLobbyEventsByCode">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param tournamentCode (required) The short code to look up lobby events for
   */
  public CompletableFuture<LobbyEventDTOWrapper> getLobbyEventsByCodeAsync(final Region region,
      final String tournamentCode) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/tournament/v3/lobby-events/by-code/%1$s", tournamentCode);
    Type type = LobbyEventDTOWrapper.class;
    return riotApi.getBasicAsync("tournament-v3.getLobbyEventsByCode", url, region, type, Collections.emptyList());
  }
}
