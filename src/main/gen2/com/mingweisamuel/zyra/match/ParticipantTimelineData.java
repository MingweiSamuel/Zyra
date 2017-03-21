package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains timeline data.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class ParticipantTimelineData {
  /**
   * Value per minute from 30 min to the end of the game */
  public final double thirtyToEnd;

  /**
   * Value per minute from 20 min to 30 min */
  public final double twentyToThirty;

  /**
   * Value per minute from the beginning of the game to 10 min */
  public final double zeroToTen;

  /**
   * Value per minute from 10 min to 20 min */
  public final double tenToTwenty;

  public ParticipantTimelineData(final double thirtyToEnd, final double twentyToThirty,
      final double zeroToTen, final double tenToTwenty) {
    this.thirtyToEnd = thirtyToEnd;
    this.twentyToThirty = twentyToThirty;
    this.zeroToTen = zeroToTen;
    this.tenToTwenty = tenToTwenty;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Match)) return false;
    final Match other = (Match) obj;
    return true
        && Objects.equal(thirtyToEnd, other.thirtyToEnd)
        && Objects.equal(twentyToThirty, other.twentyToThirty)
        && Objects.equal(zeroToTen, other.zeroToTen)
        && Objects.equal(tenToTwenty, other.tenToTwenty);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        thirtyToEnd,
        twentyToThirty,
        zeroToTen,
        tenToTwenty);}
}
