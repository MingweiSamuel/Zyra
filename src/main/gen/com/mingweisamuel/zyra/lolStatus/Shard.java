package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Shard
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-status-v1.0 */
public class Shard implements Serializable {
  public final String hostname;

  public final List<String> locales;

  public final String name;

  public final String region_tag;

  public final String slug;

  public Shard(final String hostname, final List<String> locales, final String name,
      final String region_tag, final String slug) {
    this.hostname = hostname;
    this.locales = locales;
    this.name = name;
    this.region_tag = region_tag;
    this.slug = slug;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Shard)) return false;
    final Shard other = (Shard) obj;
    return true
        && Objects.equal(hostname, other.hostname)
        && Objects.equal(locales, other.locales)
        && Objects.equal(name, other.name)
        && Objects.equal(region_tag, other.region_tag)
        && Objects.equal(slug, other.slug);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        hostname,
        locales,
        name,
        region_tag,
        slug);}
}
