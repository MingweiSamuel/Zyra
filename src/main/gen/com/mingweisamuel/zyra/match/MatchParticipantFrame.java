package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * MatchParticipantFrame.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatchTimeline">Riot API reference</a> on Wed May 17 21:53:10 PDT 2017. */
public class MatchParticipantFrame implements Serializable {
  public final int totalGold;

  public final int teamScore;

  public final int participantId;

  public final int level;

  public final int currentGold;

  public final int minionsKilled;

  public final int dominionScore;

  public final MatchPosition position;

  public final int xp;

  public final int jungleMinionsKilled;

  public MatchParticipantFrame(final int totalGold, final int teamScore, final int participantId,
      final int level, final int currentGold, final int minionsKilled, final int dominionScore,
      final MatchPosition position, final int xp, final int jungleMinionsKilled) {
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
    if (!(obj instanceof MatchParticipantFrame)) return false;
    final MatchParticipantFrame other = (MatchParticipantFrame) obj;
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
