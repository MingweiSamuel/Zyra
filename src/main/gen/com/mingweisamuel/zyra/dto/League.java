package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;

/**
 * League - This object contains league information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version league-v2.5 */
public class League {
  /**
   * The requested league entries. */
  public List<LeagueEntry> entries;

  /**
   * This name is an internal place-holder name only. Display and localization of names in the game client are handled client-side. */
  public String name;

  /**
   * Specifies the relevant participant that is a member of this league (i.e., a requested summoner ID, a requested team ID, or the ID of a team to which one of the requested summoners belongs). Only present when full league is requested so that participant's entry can be identified. Not present when individual entry is requested. */
  public String participantId;

  /**
   * The league's queue type. (Legal values: RANKED_FLEX_SR, RANKED_FLEX_TT, RANKED_SOLO_5x5, RANKED_TEAM_3x3, RANKED_TEAM_5x5) */
  public String queue;

  /**
   * The league's tier. (Legal values: CHALLENGER, MASTER, DIAMOND, PLATINUM, GOLD, SILVER, BRONZE)
   *
   * The value of this variable will never be {@link com.mingweisamuel.zyra.enums.Tier#UNRANKED}.
   *
   * @see com.mingweisamuel.zyra.enums.Tier */
  public String tier;
}
