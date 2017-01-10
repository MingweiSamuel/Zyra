package com.mingweisamuel.zyra.match;

import java.lang.String;
import java.util.List;

/**
 * Participant - This object contains match participant information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Participant {
  /**
   * Champion ID */
  public int championId;

  /**
   * Highest ranked tier achieved for the previous season, if any, otherwise null. Used to display border in game loading screen. (Legal values: CHALLENGER, MASTER, DIAMOND, PLATINUM, GOLD, SILVER, BRONZE, UNRANKED) */
  public String highestAchievedSeasonTier;

  /**
   * List of mastery information */
  public List<Mastery> masteries;

  /**
   * Participant ID */
  public int participantId;

  /**
   * List of rune information */
  public List<Rune> runes;

  /**
   * First summoner spell ID */
  public int spell1Id;

  /**
   * Second summoner spell ID */
  public int spell2Id;

  /**
   * Participant statistics */
  public ParticipantStats stats;

  /**
   * Team ID */
  public int teamId;

  /**
   * Timeline data. Delta fields refer to values for the specified period (e.g., the gold per minute over the first 10 minutes of the game versus the second 20 minutes of the game. Diffs fields refer to the deltas versus the calculated lane opponent(s). */
  public ParticipantTimeline timeline;
}
