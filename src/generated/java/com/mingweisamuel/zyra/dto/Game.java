package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;

/**
 * Game - This object contains game information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}. */
public class Game {
  /**
   * Champion ID associated with game. */
  public int championId;

  /**
   * Date that end game data was recorded, specified as epoch milliseconds. */
  public long createDate;

  /**
   * Other players associated with the game. */
  public List<Player> fellowPlayers;

  /**
   * Game ID. */
  public long gameId;

  /**
   * Game mode. (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO, SIEGE) */
  public String gameMode;

  /**
   * Game type. (Legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME) */
  public String gameType;

  /**
   * Invalid flag. */
  public boolean invalid;

  /**
   * IP Earned. */
  public int ipEarned;

  /**
   * Level. */
  public int level;

  /**
   * Map ID. */
  public int mapId;

  /**
   * ID of first summoner spell. */
  public int spell1;

  /**
   * ID of second summoner spell. */
  public int spell2;

  /**
   * Statistics associated with the game for this summoner. */
  public RawStats stats;

  /**
   * Game sub-type. (Legal values: NONE, NORMAL, BOT, RANKED_SOLO_5x5, RANKED_PREMADE_3x3, RANKED_PREMADE_5x5, ODIN_UNRANKED, RANKED_TEAM_3x3, RANKED_TEAM_5x5, NORMAL_3x3, BOT_3x3, CAP_5x5, ARAM_UNRANKED_5x5, ONEFORALL_5x5, FIRSTBLOOD_1x1, FIRSTBLOOD_2x2, SR_6x6, URF, URF_BOT, NIGHTMARE_BOT, ASCENSION, HEXAKILL, KING_PORO, COUNTER_PICK, BILGEWATER, SIEGE, RANKED_FLEX_SR, RANKED_FLEX_TT) */
  public String subType;

  /**
   * Team ID associated with game. Team ID 100 is blue team. Team ID 200 is purple team. */
  public int teamId;
}
