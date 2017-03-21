package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * .<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-status-v1.0/GET_getShardStatus">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Incident {
  public final boolean active;

  public final String created_at;

  public final long id;

  public final List<Message> updates;

  public Incident(final boolean active, final String created_at, final long id,
      final List<Message> updates) {
    this.active = active;
    this.created_at = created_at;
    this.id = id;
    this.updates = updates;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStatus)) return false;
    final LolStatus other = (LolStatus) obj;
    return true
        && Objects.equal(active, other.active)
        && Objects.equal(created_at, other.created_at)
        && Objects.equal(id, other.id)
        && Objects.equal(updates, other.updates);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        active,
        created_at,
        id,
        updates);}
}
