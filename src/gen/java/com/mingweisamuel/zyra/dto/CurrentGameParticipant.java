package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;

/**
 * CurrentGameParticipant
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link RiotDtoGenerator}.
 *
 * @version current-game-v1.0 */
public class CurrentGameParticipant {
  /**
   * Flag indicating whether or not this participant is a bot */
  public boolean bot;

  /**
   * The ID of the champion played by this participant */
  public long championId;

  /**
   * The masteries used by this participant */
  public List<Mastery> masteries;

  /**
   * The ID of the profile icon used by this participant */
  public long profileIconId;

  /**
   * The runes used by this participant */
  public List<Rune> runes;

  /**
   * The ID of the first summoner spell used by this participant */
  public long spell1Id;

  /**
   * The ID of the second summoner spell used by this participant */
  public long spell2Id;

  /**
   * The summoner ID of this participant */
  public long summonerId;

  /**
   * The summoner name of this participant */
  public String summonerName;

  /**
   * The team ID of this participant, indicating the participant's team */
  public long teamId;
}
