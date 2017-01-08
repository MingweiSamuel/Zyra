package com.mingweisamuel.zyra.dto;

/**
 * ParticipantTimelineData - This object contains timeline data
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}. */
public class ParticipantTimelineData {
  /**
   * Value per minute from 10 min to 20 min */
  public double tenToTwenty;

  /**
   * Value per minute from 30 min to the end of the game */
  public double thirtyToEnd;

  /**
   * Value per minute from 20 min to 30 min */
  public double twentyToThirty;

  /**
   * Value per minute from the beginning of the game to 10 min */
  public double zeroToTen;
}
