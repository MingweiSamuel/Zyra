package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * MatchEvent.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Riot API reference</a>. */
public class MatchEvent implements Serializable {
  public final String eventType;

  public final String towerType;

  public final int teamId;

  public final String ascendedType;

  public final int killerId;

  public final String levelUpType;

  public final String pointCaptured;

  public final List<Integer> assistingParticipantIds;

  public final String wardType;

  public final String monsterType;

  /**
   * (Legal values: CHAMPION_KILL, WARD_PLACED, WARD_KILL, BUILDING_KILL, ELITE_MONSTER_KILL, ITEM_PURCHASED, ITEM_SOLD, ITEM_DESTROYED, ITEM_UNDO, SKILL_LEVEL_UP, ASCENDED_EVENT, CAPTURE_POINT, PORO_KING_SUMMON) */
  public final String type;

  public final int skillSlot;

  public final int victimId;

  public final long timestamp;

  public final int afterId;

  public final String monsterSubType;

  public final String laneType;

  public final int itemId;

  public final int participantId;

  public final String buildingType;

  public final int creatorId;

  public final MatchPosition position;

  public final int beforeId;

  public MatchEvent(final String eventType, final String towerType, final int teamId,
      final String ascendedType, final int killerId, final String levelUpType,
      final String pointCaptured, final List<Integer> assistingParticipantIds,
      final String wardType, final String monsterType, final String type, final int skillSlot,
      final int victimId, final long timestamp, final int afterId, final String monsterSubType,
      final String laneType, final int itemId, final int participantId, final String buildingType,
      final int creatorId, final MatchPosition position, final int beforeId) {
    this.eventType = eventType;
    this.towerType = towerType;
    this.teamId = teamId;
    this.ascendedType = ascendedType;
    this.killerId = killerId;
    this.levelUpType = levelUpType;
    this.pointCaptured = pointCaptured;
    this.assistingParticipantIds = assistingParticipantIds;
    this.wardType = wardType;
    this.monsterType = monsterType;
    this.type = type;
    this.skillSlot = skillSlot;
    this.victimId = victimId;
    this.timestamp = timestamp;
    this.afterId = afterId;
    this.monsterSubType = monsterSubType;
    this.laneType = laneType;
    this.itemId = itemId;
    this.participantId = participantId;
    this.buildingType = buildingType;
    this.creatorId = creatorId;
    this.position = position;
    this.beforeId = beforeId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchEvent)) return false;
    final MatchEvent other = (MatchEvent) obj;
    return true
        && Objects.equal(eventType, other.eventType)
        && Objects.equal(towerType, other.towerType)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(ascendedType, other.ascendedType)
        && Objects.equal(killerId, other.killerId)
        && Objects.equal(levelUpType, other.levelUpType)
        && Objects.equal(pointCaptured, other.pointCaptured)
        && Objects.equal(assistingParticipantIds, other.assistingParticipantIds)
        && Objects.equal(wardType, other.wardType)
        && Objects.equal(monsterType, other.monsterType)
        && Objects.equal(type, other.type)
        && Objects.equal(skillSlot, other.skillSlot)
        && Objects.equal(victimId, other.victimId)
        && Objects.equal(timestamp, other.timestamp)
        && Objects.equal(afterId, other.afterId)
        && Objects.equal(monsterSubType, other.monsterSubType)
        && Objects.equal(laneType, other.laneType)
        && Objects.equal(itemId, other.itemId)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(buildingType, other.buildingType)
        && Objects.equal(creatorId, other.creatorId)
        && Objects.equal(position, other.position)
        && Objects.equal(beforeId, other.beforeId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        eventType,
        towerType,
        teamId,
        ascendedType,
        killerId,
        levelUpType,
        pointCaptured,
        assistingParticipantIds,
        wardType,
        monsterType,
        type,
        skillSlot,
        victimId,
        timestamp,
        afterId,
        monsterSubType,
        laneType,
        itemId,
        participantId,
        buildingType,
        creatorId,
        position,
        beforeId);}
}
