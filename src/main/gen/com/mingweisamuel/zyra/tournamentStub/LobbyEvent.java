package com.mingweisamuel.zyra.tournamentStub;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * LobbyEvent.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class LobbyEvent implements Serializable {
  /**
   * The type of event that was triggered */
  public final String eventType;

  /**
   * The summoner that triggered the event */
  public final String summonerId;

  /**
   * Timestamp from the event */
  public final String timestamp;

  public LobbyEvent(final String eventType, final String summonerId, final String timestamp) {
    this.eventType = eventType;
    this.summonerId = summonerId;
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LobbyEvent)) return false;
    final LobbyEvent other = (LobbyEvent) obj;
    return true
        && Objects.equal(eventType, other.eventType)
        && Objects.equal(summonerId, other.summonerId)
        && Objects.equal(timestamp, other.timestamp);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        eventType,
        summonerId,
        timestamp);}
}
