package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * ParticipantTimelineData - This object contains timeline data
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class ParticipantTimelineData {
  /**
   * Value per minute from 10 min to 20 min */
  public final double tenToTwenty;

  /**
   * Value per minute from 30 min to the end of the game */
  public final double thirtyToEnd;

  /**
   * Value per minute from 20 min to 30 min */
  public final double twentyToThirty;

  /**
   * Value per minute from the beginning of the game to 10 min */
  public final double zeroToTen;

  public ParticipantTimelineData(final double tenToTwenty, final double thirtyToEnd,
      final double twentyToThirty, final double zeroToTen) {
    this.tenToTwenty = tenToTwenty;
    this.thirtyToEnd = thirtyToEnd;
    this.twentyToThirty = twentyToThirty;
    this.zeroToTen = zeroToTen;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof ParticipantTimelineData)) return false;
    final ParticipantTimelineData other = (ParticipantTimelineData) obj;
    return true
        && Objects.equal(tenToTwenty, other.tenToTwenty)
        && Objects.equal(thirtyToEnd, other.thirtyToEnd)
        && Objects.equal(twentyToThirty, other.twentyToThirty)
        && Objects.equal(zeroToTen, other.zeroToTen);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        tenToTwenty,
        thirtyToEnd,
        twentyToThirty,
        zeroToTen);}
}
