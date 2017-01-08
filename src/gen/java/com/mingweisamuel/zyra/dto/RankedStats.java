package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * RankedStats - This object contains ranked stats information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version stats-v1.3 */
public class RankedStats {
  /**
   * Collection of aggregated stats summarized by champion. */
  public List<ChampionStats> champions;

  /**
   * Date stats were last modified specified as epoch milliseconds. */
  public long modifyDate;

  /**
   * Summoner ID. */
  public long summonerId;
}
