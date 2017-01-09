package com.mingweisamuel.zyra.dto;

/**
 * ParticipantFrame - This object contains participant frame information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link RiotDtoGenerator}.
 *
 * @version match-v2.2 */
public class ParticipantFrame {
  /**
   * Participant's current gold */
  public int currentGold;

  /**
   * Dominion score of the participant */
  public int dominionScore;

  /**
   * Number of jungle minions killed by participant */
  public int jungleMinionsKilled;

  /**
   * Participant's current level */
  public int level;

  /**
   * Number of minions killed by participant */
  public int minionsKilled;

  /**
   * Participant ID */
  public int participantId;

  /**
   * Participant's position */
  public Position position;

  /**
   * Team score of the participant */
  public int teamScore;

  /**
   * Participant's total gold */
  public int totalGold;

  /**
   * Experience earned by participant */
  public int xp;
}
