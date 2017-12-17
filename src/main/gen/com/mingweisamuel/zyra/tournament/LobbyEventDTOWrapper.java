package com.mingweisamuel.zyra.tournament;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * LobbyEventDTOWrapper.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class LobbyEventDTOWrapper implements Serializable {
  public final List<LobbyEvent> eventList;

  public LobbyEventDTOWrapper(final List<LobbyEvent> eventList) {
    this.eventList = eventList;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LobbyEventDTOWrapper)) return false;
    final LobbyEventDTOWrapper other = (LobbyEventDTOWrapper) obj;
    return true
        && Objects.equal(eventList, other.eventList);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        eventList);}
}
