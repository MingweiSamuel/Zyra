package com.mingweisamuel.zyra.dto;

import java.lang.Integer;
import java.lang.String;
import java.util.List;

/**
 * Event - This object contains game event information. Note that not all legal type values documented below are valid for all games. Event data evolves over time and certain values may be relevant only for older or newer games.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Event {
  /**
   * The ascended type of the event. Only present if relevant. Note that CLEAR_ASCENDED refers to when a participants kills the ascended player. (Legal values: CHAMPION_ASCENDED, CLEAR_ASCENDED, MINION_ASCENDED) */
  public String ascendedType;

  /**
   * The assisting participant IDs of the event. Only present if relevant. */
  public List<Integer> assistingParticipantIds;

  /**
   * The building type of the event. Only present if relevant. (Legal values: INHIBITOR_BUILDING, TOWER_BUILDING) */
  public String buildingType;

  /**
   * The creator ID of the event. Only present if relevant. */
  public int creatorId;

  /**
   * Event type. (Legal values: ASCENDED_EVENT, BUILDING_KILL, CAPTURE_POINT, CHAMPION_KILL, ELITE_MONSTER_KILL, ITEM_DESTROYED, ITEM_PURCHASED, ITEM_SOLD, ITEM_UNDO, PORO_KING_SUMMON, SKILL_LEVEL_UP, WARD_KILL, WARD_PLACED) */
  public String eventType;

  /**
   * The ending item ID of the event. Only present if relevant. */
  public int itemAfter;

  /**
   * The starting item ID of the event. Only present if relevant. */
  public int itemBefore;

  /**
   * The item ID of the event. Only present if relevant. */
  public int itemId;

  /**
   * The killer ID of the event. Only present if relevant. Killer ID 0 indicates a minion. */
  public int killerId;

  /**
   * The lane type of the event. Only present if relevant. (Legal values: BOT_LANE, MID_LANE, TOP_LANE) */
  public String laneType;

  /**
   * The level up type of the event. Only present if relevant. (Legal values: EVOLVE, NORMAL) */
  public String levelUpType;

  /**
   * The monster subtype of the event. Only present if relevant. */
  public String monsterSubType;

  /**
   * The monster type of the event. Only present if relevant. (Legal values: BARON_NASHOR, BLUE_GOLEM, DRAGON, RED_LIZARD, RIFTHERALD, VILEMAW) */
  public String monsterType;

  /**
   * The participant ID of the event. Only present if relevant. */
  public int participantId;

  /**
   * The point captured in the event. Only present if relevant. (Legal values: POINT_A, POINT_B, POINT_C, POINT_D, POINT_E) */
  public String pointCaptured;

  /**
   * The position of the event. Only present if relevant. */
  public Position position;

  /**
   * The skill slot of the event. Only present if relevant. */
  public int skillSlot;

  /**
   * The team ID of the event. Only present if relevant. */
  public int teamId;

  /**
   * Represents how many milliseconds into the game the event occurred. */
  public long timestamp;

  /**
   * The tower type of the event. Only present if relevant. (Legal values: BASE_TURRET, FOUNTAIN_TURRET, INNER_TURRET, NEXUS_TURRET, OUTER_TURRET, UNDEFINED_TURRET) */
  public String towerType;

  /**
   * The victim ID of the event. Only present if relevant. */
  public int victimId;

  /**
   * The ward type of the event. Only present if relevant. (Legal values: BLUE_TRINKET, SIGHT_WARD, TEEMO_MUSHROOM, UNDEFINED, VISION_WARD, YELLOW_TRINKET, YELLOW_TRINKET_UPGRADE) */
  public String wardType;
}
