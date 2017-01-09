package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;
import java.util.Map;

/**
 * Frame - This object contains game frame information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Frame {
  /**
   * List of events for this frame. */
  public List<Event> events;

  /**
   * Map of each participant ID to the participant's information for the frame. */
  public Map<String, ParticipantFrame> participantFrames;

  /**
   * Represents how many milliseconds into the game the frame occurred. */
  public long timestamp;
}
