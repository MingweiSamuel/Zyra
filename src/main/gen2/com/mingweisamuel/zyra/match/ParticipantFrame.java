package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains participant frame information.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class ParticipantFrame {
  /**
   * Participant's total gold */
  public final int totalGold;

  /**
   * Team score of the participant */
  public final int teamScore;

  /**
   * Participant ID */
  public final int participantId;

  /**
   * Participant's current level */
  public final int level;

  /**
   * Participant's current gold */
  public final int currentGold;

  /**
   * Number of minions killed by participant */
  public final int minionsKilled;

  /**
   * Dominion score of the participant */
  public final int dominionScore;

  /**
   * Participant's position */
  public final Position position;

  /**
   * Experience earned by participant */
  public final int xp;

  /**
   * Number of jungle minions killed by participant */
  public final int jungleMinionsKilled;

  public ParticipantFrame(final int totalGold, final int teamScore, final int participantId,
      final int level, final int currentGold, final int minionsKilled, final int dominionScore,
      final Position position, final int xp, final int jungleMinionsKilled) {
    this.totalGold = totalGold;
    this.teamScore = teamScore;
    this.participantId = participantId;
    this.level = level;
    this.currentGold = currentGold;
    this.minionsKilled = minionsKilled;
    this.dominionScore = dominionScore;
    this.position = position;
    this.xp = xp;
    this.jungleMinionsKilled = jungleMinionsKilled;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(totalGold, other.totalGold)
        && Objects.equal(teamScore, other.teamScore)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(level, other.level)
        && Objects.equal(currentGold, other.currentGold)
        && Objects.equal(minionsKilled, other.minionsKilled)
        && Objects.equal(dominionScore, other.dominionScore)
        && Objects.equal(position, other.position)
        && Objects.equal(xp, other.xp)
        && Objects.equal(jungleMinionsKilled, other.jungleMinionsKilled);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        totalGold,
        teamScore,
        participantId,
        level,
        currentGold,
        minionsKilled,
        dominionScore,
        position,
        xp,
        jungleMinionsKilled);}
}
