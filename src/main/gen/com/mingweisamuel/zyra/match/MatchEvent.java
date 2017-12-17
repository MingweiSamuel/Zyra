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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class MatchEvent implements Serializable {
  public final int afterId;

  public final String ascendedType;

  public final List<Integer> assistingParticipantIds;

  public final int beforeId;

  public final String buildingType;

  public final int creatorId;

  public final String eventType;

  public final int itemId;

  public final int killerId;

  public final String laneType;

  public final String levelUpType;

  public final String monsterSubType;

  public final String monsterType;

  public final int participantId;

  public final String pointCaptured;

  public final MatchPosition position;

  public final int skillSlot;

  public final int teamId;

  public final long timestamp;

  public final String towerType;

  /**
   * (Legal values:  CHAMPION_KILL,  WARD_PLACED,  WARD_KILL,  BUILDING_KILL,  ELITE_MONSTER_KILL,  ITEM_PURCHASED,  ITEM_SOLD,  ITEM_DESTROYED,  ITEM_UNDO,  SKILL_LEVEL_UP,  ASCENDED_EVENT,  CAPTURE_POINT,  PORO_KING_SUMMON) */
  public final String type;

  public final int victimId;

  public final String wardType;

  public MatchEvent(final int afterId, final String ascendedType,
      final List<Integer> assistingParticipantIds, final int beforeId, final String buildingType,
      final int creatorId, final String eventType, final int itemId, final int killerId,
      final String laneType, final String levelUpType, final String monsterSubType,
      final String monsterType, final int participantId, final String pointCaptured,
      final MatchPosition position, final int skillSlot, final int teamId, final long timestamp,
      final String towerType, final String type, final int victimId, final String wardType) {
    this.afterId = afterId;
    this.ascendedType = ascendedType;
    this.assistingParticipantIds = assistingParticipantIds;
    this.beforeId = beforeId;
    this.buildingType = buildingType;
    this.creatorId = creatorId;
    this.eventType = eventType;
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
    this.type = type;
    this.victimId = victimId;
    this.wardType = wardType;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MatchEvent)) return false;
    final MatchEvent other = (MatchEvent) obj;
    return true
        && Objects.equal(afterId, other.afterId)
        && Objects.equal(ascendedType, other.ascendedType)
        && Objects.equal(assistingParticipantIds, other.assistingParticipantIds)
        && Objects.equal(beforeId, other.beforeId)
        && Objects.equal(buildingType, other.buildingType)
        && Objects.equal(creatorId, other.creatorId)
        && Objects.equal(eventType, other.eventType)
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
        && Objects.equal(type, other.type)
        && Objects.equal(victimId, other.victimId)
        && Objects.equal(wardType, other.wardType);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        afterId,
        ascendedType,
        assistingParticipantIds,
        beforeId,
        buildingType,
        creatorId,
        eventType,
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
        type,
        victimId,
        wardType);}
}
