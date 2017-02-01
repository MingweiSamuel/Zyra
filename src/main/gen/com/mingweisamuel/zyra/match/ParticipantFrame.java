package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ParticipantFrame - This object contains participant frame information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class ParticipantFrame implements Serializable {
  /**
   * Participant's current gold */
  public final int currentGold;

  /**
   * Dominion score of the participant */
  public final int dominionScore;

  /**
   * Number of jungle minions killed by participant */
  public final int jungleMinionsKilled;

  /**
   * Participant's current level */
  public final int level;

  /**
   * Number of minions killed by participant */
  public final int minionsKilled;

  /**
   * Participant ID */
  public final int participantId;

  /**
   * Participant's position */
  public final Position position;

  /**
   * Team score of the participant */
  public final int teamScore;

  /**
   * Participant's total gold */
  public final int totalGold;

  /**
   * Experience earned by participant */
  public final int xp;

  public ParticipantFrame(final int currentGold, final int dominionScore,
      final int jungleMinionsKilled, final int level, final int minionsKilled,
      final int participantId, final Position position, final int teamScore, final int totalGold,
      final int xp) {
    this.currentGold = currentGold;
    this.dominionScore = dominionScore;
    this.jungleMinionsKilled = jungleMinionsKilled;
    this.level = level;
    this.minionsKilled = minionsKilled;
    this.participantId = participantId;
    this.position = position;
    this.teamScore = teamScore;
    this.totalGold = totalGold;
    this.xp = xp;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ParticipantFrame)) return false;
    final ParticipantFrame other = (ParticipantFrame) obj;
    return true
        && Objects.equal(currentGold, other.currentGold)
        && Objects.equal(dominionScore, other.dominionScore)
        && Objects.equal(jungleMinionsKilled, other.jungleMinionsKilled)
        && Objects.equal(level, other.level)
        && Objects.equal(minionsKilled, other.minionsKilled)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(position, other.position)
        && Objects.equal(teamScore, other.teamScore)
        && Objects.equal(totalGold, other.totalGold)
        && Objects.equal(xp, other.xp);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        currentGold,
        dominionScore,
        jungleMinionsKilled,
        level,
        minionsKilled,
        participantId,
        position,
        teamScore,
        totalGold,
        xp);}
}
