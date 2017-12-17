package com.mingweisamuel.zyra.tournamentStub;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * SummonerIdParams.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class SummonerIdParams implements Serializable {
  /**
   * the tournament participants */
  public final List<Long> participants;

  public SummonerIdParams(final List<Long> participants) {
    this.participants = participants;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof SummonerIdParams)) return false;
    final SummonerIdParams other = (SummonerIdParams) obj;
    return true
        && Objects.equal(participants, other.participants);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        participants);}
}
