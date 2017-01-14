package com.mingweisamuel.zyra.matchList;

import java.lang.String;

/**
 * MatchReference - This object contains match reference information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version matchlist-v2.2 */
public class MatchReference {
  public long champion;

  /**
   * Legal values: MID, MIDDLE, TOP, JUNGLE, BOT, BOTTOM */
  public String lane;

  public long matchId;

  public String platformId;

  /**
   * Legal values: RANKED_FLEX_SR, RANKED_SOLO_5x5, RANKED_TEAM_3x3, RANKED_TEAM_5x5, TEAM_BUILDER_DRAFT_RANKED_5x5, TEAM_BUILDER_RANKED_SOLO */
  public String queue;

  /**
   * Legal values: br, eune, euw, jp, kr, lan, las, na, oce, ru, tr */
  public String region;

  /**
   * Legal values: DUO, NONE, SOLO, DUO_CARRY, DUO_SUPPORT */
  public String role;

  /**
   * Legal values: PRESEASON3, SEASON3, PRESEASON2014, SEASON2014, PRESEASON2015, SEASON2015, PRESEASON2016, SEASON2016, PRESEASON2017, SEASON2017 */
  public String season;

  public long timestamp;
}
