package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * Team - This object contains team information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Team {
  /**
   * If game was draft mode, contains banned champion data, otherwise null */
  public List<BannedChampion> bans;

  /**
   * Number of times the team killed baron */
  public int baronKills;

  /**
   * If game was a dominion game, specifies the points the team had at game end, otherwise null */
  public long dominionVictoryScore;

  /**
   * Number of times the team killed dragon */
  public int dragonKills;

  /**
   * Flag indicating whether or not the team got the first baron kill */
  public boolean firstBaron;

  /**
   * Flag indicating whether or not the team got first blood */
  public boolean firstBlood;

  /**
   * Flag indicating whether or not the team got the first dragon kill */
  public boolean firstDragon;

  /**
   * Flag indicating whether or not the team destroyed the first inhibitor */
  public boolean firstInhibitor;

  /**
   * Flag indicating whether or not the team got the first rift herald kill */
  public boolean firstRiftHerald;

  /**
   * Flag indicating whether or not the team destroyed the first tower */
  public boolean firstTower;

  /**
   * Number of inhibitors the team destroyed */
  public int inhibitorKills;

  /**
   * Number of times the team killed rift herald */
  public int riftHeraldKills;

  /**
   * Team ID */
  public int teamId;

  /**
   * Number of towers the team destroyed */
  public int towerKills;

  /**
   * Number of times the team killed vilemaw */
  public int vilemawKills;

  /**
   * Flag indicating whether or not the team won */
  public boolean winner;
}
