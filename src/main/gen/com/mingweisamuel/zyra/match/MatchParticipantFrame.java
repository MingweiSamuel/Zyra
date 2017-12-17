package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * MatchParticipantFrame.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class MatchParticipantFrame implements Serializable {
  public final int currentGold;

  public final int dominionScore;

  public final int jungleMinionsKilled;

  public final int level;

  public final int minionsKilled;

  public final int participantId;

  public final MatchPosition position;

  public final int teamScore;

  public final int totalGold;

  public final int xp;

  public MatchParticipantFrame(final int currentGold, final int dominionScore,
      final int jungleMinionsKilled, final int level, final int minionsKilled,
      final int participantId, final MatchPosition position, final int teamScore,
      final int totalGold, final int xp) {
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
    if (!(obj instanceof MatchParticipantFrame)) return false;
    final MatchParticipantFrame other = (MatchParticipantFrame) obj;
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
