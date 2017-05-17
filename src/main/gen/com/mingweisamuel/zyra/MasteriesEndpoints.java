package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.masteries.MasteryPages;
import java.lang.String;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

/**
 * masteries-v3
 * This class is automatically generated and should not be modified directly.
 */
public final class MasteriesEndpoints extends Endpoints {
  MasteriesEndpoints(final RiotApi riotApi) {
    super(riotApi);
  }

  /**
   * <a href="https://developer.riotgames.com/api-methods/#masteries-v3/GET_getMasteryPagesBySummonerId">Link to Portal</a><br>
   * @param region Region to execute against.@param summonerId (required) Summoner ID
   */
  public MasteryPages getMasteryPagesBySummonerId(final Region region, final String summonerId)
      throws ExecutionException {
    // This method is automatically generated and should not be modified directly.
    String url = String.format("/lol/platform/v3/masteries/by-summoner/%1$s", summonerId);
    Type type = MasteryPages.class;
    return riotApi.getBasic(url, region, type);}
}
