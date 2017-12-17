package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Incident.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Incident implements Serializable {
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
    if (!(obj instanceof Incident)) return false;
    final Incident other = (Incident) obj;
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
