package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Service
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-status-v1.0 */
public class Service {
  public final List<Incident> incidents;

  public final String name;

  public final String slug;

  public final String status;

  public Service(final List<Incident> incidents, final String name, final String slug,
      final String status) {
    this.incidents = incidents;
    this.name = name;
    this.slug = slug;
    this.status = status;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Service)) return false;
    final Service other = (Service) obj;
    return true
        && Objects.equal(incidents, other.incidents)
        && Objects.equal(name, other.name)
        && Objects.equal(slug, other.slug)
        && Objects.equal(status, other.status);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        incidents,
        name,
        slug,
        status);}
}
