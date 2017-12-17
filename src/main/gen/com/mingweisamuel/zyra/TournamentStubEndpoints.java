package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.tournamentStub.LobbyEventDTOWrapper;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

/**
 * tournament-stub-v3 endpoints.<br>
 * This class is automatically generated and should not be modified directly.
 */
@SuppressWarnings({"unused", "SameParameterValue", "SpellCheckingInspection"})
public final class TournamentStubEndpoints extends Endpoints {
  TournamentStubEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * Gets a mock list of lobby events by tournament code.
   *
   * <a href="https://developer.riotgames.com/api-methods/#tournament-stub-v3/GET_getLobbyEventsByCode">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param tournamentCode (required) The short code to look up lobby events for
   */
  public LobbyEventDTOWrapper getLobbyEventsByCode(final Region region,
      final String tournamentCode) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/tournament-stub/v3/lobby-events/by-code/%1$s", tournamentCode);
    Type type = LobbyEventDTOWrapper.class;
    return riotApi.getBasic("tournament-stub-v3.getLobbyEventsByCode", url, region, type, Collections.emptyList());
  }

  /**
   * Gets a mock list of lobby events by tournament code.
   *
   * <a href="https://developer.riotgames.com/api-methods/#tournament-stub-v3/GET_getLobbyEventsByCode">Link to Portal</a><br>
   * @param region Region to execute against.
   * @param tournamentCode (required) The short code to look up lobby events for
   */
  public CompletableFuture<LobbyEventDTOWrapper> getLobbyEventsByCodeAsync(final Region region,
      final String tournamentCode) {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/tournament-stub/v3/lobby-events/by-code/%1$s", tournamentCode);
    Type type = LobbyEventDTOWrapper.class;
    return riotApi.getBasicAsync("tournament-stub-v3.getLobbyEventsByCode", url, region, type, Collections.emptyList());
  }
}
