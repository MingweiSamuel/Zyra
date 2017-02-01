package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Event - This object contains game event information. Note that not all legal type values documented below are valid for all games. Event data evolves over time and certain values may be relevant only for older or newer games.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Event implements Serializable {
  /**
   * The ascended type of the event. Only present if relevant. Note that CLEAR_ASCENDED refers to when a participants kills the ascended player. (Legal values: CHAMPION_ASCENDED, CLEAR_ASCENDED, MINION_ASCENDED) */
  public final String ascendedType;

  /**
   * The assisting participant IDs of the event. Only present if relevant. */
  public final List<Integer> assistingParticipantIds;

  /**
   * The building type of the event. Only present if relevant. (Legal values: INHIBITOR_BUILDING, TOWER_BUILDING) */
  public final String buildingType;

  /**
   * The creator ID of the event. Only present if relevant. */
  public final int creatorId;

  /**
   * Event type. (Legal values: ASCENDED_EVENT, BUILDING_KILL, CAPTURE_POINT, CHAMPION_KILL, ELITE_MONSTER_KILL, ITEM_DESTROYED, ITEM_PURCHASED, ITEM_SOLD, ITEM_UNDO, PORO_KING_SUMMON, SKILL_LEVEL_UP, WARD_KILL, WARD_PLACED) */
  public final String eventType;

  /**
   * The ending item ID of the event. Only present if relevant. */
  public final int itemAfter;

  /**
   * The starting item ID of the event. Only present if relevant. */
  public final int itemBefore;

  /**
   * The item ID of the event. Only present if relevant. */
  public final int itemId;

  /**
   * The killer ID of the event. Only present if relevant. Killer ID 0 indicates a minion. */
  public final int killerId;

  /**
   * The lane type of the event. Only present if relevant. (Legal values: BOT_LANE, MID_LANE, TOP_LANE) */
  public final String laneType;

  /**
   * The level up type of the event. Only present if relevant. (Legal values: EVOLVE, NORMAL) */
  public final String levelUpType;

  /**
   * The monster subtype of the event. Only present if relevant. */
  public final String monsterSubType;

  /**
   * The monster type of the event. Only present if relevant. (Legal values: BARON_NASHOR, BLUE_GOLEM, DRAGON, RED_LIZARD, RIFTHERALD, VILEMAW) */
  public final String monsterType;

  /**
   * The participant ID of the event. Only present if relevant. */
  public final int participantId;

  /**
   * The point captured in the event. Only present if relevant. (Legal values: POINT_A, POINT_B, POINT_C, POINT_D, POINT_E) */
  public final String pointCaptured;

  /**
   * The position of the event. Only present if relevant. */
  public final Position position;

  /**
   * The skill slot of the event. Only present if relevant. */
  public final int skillSlot;

  /**
   * The team ID of the event. Only present if relevant. */
  public final int teamId;

  /**
   * Represents how many milliseconds into the game the event occurred. */
  public final long timestamp;

  /**
   * The tower type of the event. Only present if relevant. (Legal values: BASE_TURRET, FOUNTAIN_TURRET, INNER_TURRET, NEXUS_TURRET, OUTER_TURRET, UNDEFINED_TURRET) */
  public final String towerType;

  /**
   * The victim ID of the event. Only present if relevant. */
  public final int victimId;

  /**
   * The ward type of the event. Only present if relevant. (Legal values: BLUE_TRINKET, SIGHT_WARD, TEEMO_MUSHROOM, UNDEFINED, VISION_WARD, YELLOW_TRINKET, YELLOW_TRINKET_UPGRADE) */
  public final String wardType;

  public Event(final String ascendedType, final List<Integer> assistingParticipantIds,
      final String buildingType, final int creatorId, final String eventType, final int itemAfter,
      final int itemBefore, final int itemId, final int killerId, final String laneType,
      final String levelUpType, final String monsterSubType, final String monsterType,
      final int participantId, final String pointCaptured, final Position position,
      final int skillSlot, final int teamId, final long timestamp, final String towerType,
      final int victimId, final String wardType) {
    this.ascendedType = ascendedType;
    this.assistingParticipantIds = assistingParticipantIds;
    this.buildingType = buildingType;
    this.creatorId = creatorId;
    this.eventType = eventType;
    this.itemAfter = itemAfter;
    this.itemBefore = itemBefore;
    this.itemId = itemId;
    this.killerId = killerId;
    this.laneType = laneType;
    this.levelUpType = levelUpType;
    this.monsterSubType = monsterSubType;
    this.monsterType = monsterType;
    this.participantId = participantId;
    this.pointCaptured = pointCaptured;
    this.position = position;
    this.skillSlot = skillSlot;
    this.teamId = teamId;
    this.timestamp = timestamp;
    this.towerType = towerType;
    this.victimId = victimId;
    this.wardType = wardType;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Event)) return false;
    final Event other = (Event) obj;
    return true
        && Objects.equal(ascendedType, other.ascendedType)
        && Objects.equal(assistingParticipantIds, other.assistingParticipantIds)
        && Objects.equal(buildingType, other.buildingType)
        && Objects.equal(creatorId, other.creatorId)
        && Objects.equal(eventType, other.eventType)
        && Objects.equal(itemAfter, other.itemAfter)
        && Objects.equal(itemBefore, other.itemBefore)
        && Objects.equal(itemId, other.itemId)
        && Objects.equal(killerId, other.killerId)
        && Objects.equal(laneType, other.laneType)
        && Objects.equal(levelUpType, other.levelUpType)
        && Objects.equal(monsterSubType, other.monsterSubType)
        && Objects.equal(monsterType, other.monsterType)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(pointCaptured, other.pointCaptured)
        && Objects.equal(position, other.position)
        && Objects.equal(skillSlot, other.skillSlot)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(timestamp, other.timestamp)
        && Objects.equal(towerType, other.towerType)
        && Objects.equal(victimId, other.victimId)
        && Objects.equal(wardType, other.wardType);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        ascendedType,
        assistingParticipantIds,
        buildingType,
        creatorId,
        eventType,
        itemAfter,
        itemBefore,
        itemId,
        killerId,
        laneType,
        levelUpType,
        monsterSubType,
        monsterType,
        participantId,
        pointCaptured,
        position,
        skillSlot,
        teamId,
        timestamp,
        towerType,
        victimId,
        wardType);}
}
