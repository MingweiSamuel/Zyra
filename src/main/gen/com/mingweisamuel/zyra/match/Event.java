package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Event.<br><br>
 *
 * This object contains game event information. Note that not all legal type values documented below are valid for all games. Event data evolves over time and certain values may be relevant only for older or newer games..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class Event implements Serializable {
  /**
   * The starting item ID of the event. Only present if relevant. */
  public final int itemBefore;

  /**
   * Event type. */
  public final String eventType;

  /**
   * The tower type of the event. Only present if relevant. */
  public final String towerType;

  /**
   * The team ID of the event. Only present if relevant. */
  public final int teamId;

  /**
   * The ending item ID of the event. Only present if relevant. */
  public final int itemAfter;

  /**
   * The ascended type of the event. Only present if relevant. Note that CLEAR_ASCENDED refers to when a participants kills the ascended player. */
  public final String ascendedType;

  /**
   * The killer ID of the event. Only present if relevant. Killer ID 0 indicates a minion. */
  public final int killerId;

  /**
   * The level up type of the event. Only present if relevant. */
  public final String levelUpType;

  /**
   * The point captured in the event. Only present if relevant. */
  public final String pointCaptured;

  /**
   * The assisting participant IDs of the event. Only present if relevant. */
  public final List<Integer> assistingParticipantIds;

  /**
   * The ward type of the event. Only present if relevant. */
  public final String wardType;

  /**
   * The monster type of the event. Only present if relevant. */
  public final String monsterType;

  /**
   * The building type of the event. Only present if relevant. */
  public final String buildingType;

  /**
   * The victim ID of the event. Only present if relevant. */
  public final int victimId;

  /**
   * Represents how many milliseconds into the game the event occurred. */
  public final long timestamp;

  /**
   * The skill slot of the event. Only present if relevant. */
  public final int skillSlot;

  /**
   * The monster subtype of the event. Only present if relevant. */
  public final String monsterSubType;

  /**
   * The lane type of the event. Only present if relevant. */
  public final String laneType;

  /**
   * The item ID of the event. Only present if relevant. */
  public final int itemId;

  /**
   * The participant ID of the event. Only present if relevant. */
  public final int participantId;

  /**
   * The creator ID of the event. Only present if relevant. */
  public final int creatorId;

  /**
   * The position of the event. Only present if relevant. */
  public final Position position;

  public Event(final int itemBefore, final String eventType, final String towerType,
      final int teamId, final int itemAfter, final String ascendedType, final int killerId,
      final String levelUpType, final String pointCaptured,
      final List<Integer> assistingParticipantIds, final String wardType, final String monsterType,
      final String buildingType, final int victimId, final long timestamp, final int skillSlot,
      final String monsterSubType, final String laneType, final int itemId, final int participantId,
      final int creatorId, final Position position) {
    this.itemBefore = itemBefore;
    this.eventType = eventType;
    this.towerType = towerType;
    this.teamId = teamId;
    this.itemAfter = itemAfter;
    this.ascendedType = ascendedType;
    this.killerId = killerId;
    this.levelUpType = levelUpType;
    this.pointCaptured = pointCaptured;
    this.assistingParticipantIds = assistingParticipantIds;
    this.wardType = wardType;
    this.monsterType = monsterType;
    this.buildingType = buildingType;
    this.victimId = victimId;
    this.timestamp = timestamp;
    this.skillSlot = skillSlot;
    this.monsterSubType = monsterSubType;
    this.laneType = laneType;
    this.itemId = itemId;
    this.participantId = participantId;
    this.creatorId = creatorId;
    this.position = position;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Event)) return false;
    final Event other = (Event) obj;
    return true
        && Objects.equal(itemBefore, other.itemBefore)
        && Objects.equal(eventType, other.eventType)
        && Objects.equal(towerType, other.towerType)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(itemAfter, other.itemAfter)
        && Objects.equal(ascendedType, other.ascendedType)
        && Objects.equal(killerId, other.killerId)
        && Objects.equal(levelUpType, other.levelUpType)
        && Objects.equal(pointCaptured, other.pointCaptured)
        && Objects.equal(assistingParticipantIds, other.assistingParticipantIds)
        && Objects.equal(wardType, other.wardType)
        && Objects.equal(monsterType, other.monsterType)
        && Objects.equal(buildingType, other.buildingType)
        && Objects.equal(victimId, other.victimId)
        && Objects.equal(timestamp, other.timestamp)
        && Objects.equal(skillSlot, other.skillSlot)
        && Objects.equal(monsterSubType, other.monsterSubType)
        && Objects.equal(laneType, other.laneType)
        && Objects.equal(itemId, other.itemId)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(creatorId, other.creatorId)
        && Objects.equal(position, other.position);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        itemBefore,
        eventType,
        towerType,
        teamId,
        itemAfter,
        ascendedType,
        killerId,
        levelUpType,
        pointCaptured,
        assistingParticipantIds,
        wardType,
        monsterType,
        buildingType,
        victimId,
        timestamp,
        skillSlot,
        monsterSubType,
        laneType,
        itemId,
        participantId,
        creatorId,
        position);}
}
