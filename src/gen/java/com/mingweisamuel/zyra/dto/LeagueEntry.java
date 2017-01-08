package com.mingweisamuel.zyra.dto;

import java.lang.String;

/**
 * LeagueEntry - This object contains league participant information representing a summoner or team.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version league-v2.5 */
public class LeagueEntry {
  /**
   * The league division of the participant. */
  public String division;

  /**
   * Specifies if the participant is fresh blood. */
  public boolean isFreshBlood;

  /**
   * Specifies if the participant is on a hot streak. */
  public boolean isHotStreak;

  /**
   * Specifies if the participant is inactive. */
  public boolean isInactive;

  /**
   * Specifies if the participant is a veteran. */
  public boolean isVeteran;

  /**
   * The league points of the participant. */
  public int leaguePoints;

  /**
   * The number of losses for the participant. */
  public int losses;

  /**
   * Mini series data for the participant. Only present if the participant is currently in a mini series. */
  public MiniSeries miniSeries;

  /**
   * The ID of the participant (i.e., summoner or team) represented by this entry. */
  public String playerOrTeamId;

  /**
   * The name of the the participant (i.e., summoner or team) represented by this entry. */
  public String playerOrTeamName;

  /**
   * The playstyle of the participant. (Legal values: NONE, SOLO, SQUAD, TEAM) */
  public String playstyle;

  /**
   * The number of wins for the participant. */
  public int wins;
}
