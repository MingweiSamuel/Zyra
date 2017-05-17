package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.runes.RunePages;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

/**
 * runes-v3
 * This class is automatically generated and should not be modified directly.
 */
public final class RunesEndpoints extends Endpoints {
  RunesEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#runes-v3/GET_getRunePagesBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.@param summonerId (required) Summoner ID
   */
  public RunePages getRunePagesBySummonerId(final Region region, final String summonerId) throws
      ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/platform/v3/runes/by-summoner/%1$s", summonerId);
    Type type = RunePages.class;
    return riotApi.getBasic(url, region, type);}
}
