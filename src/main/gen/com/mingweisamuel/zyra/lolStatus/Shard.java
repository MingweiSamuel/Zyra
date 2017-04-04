package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Shard.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-status-v1.0/GET_getShards">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class Shard implements Serializable {
  public final String region_tag;

  public final String hostname;

  public final String slug;

  public final List<String> locales;

  public final String name;

  public Shard(final String region_tag, final String hostname, final String slug,
      final List<String> locales, final String name) {
    this.region_tag = region_tag;
    this.hostname = hostname;
    this.slug = slug;
    this.locales = locales;
    this.name = name;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Shard)) return false;
    final Shard other = (Shard) obj;
    return true
        && Objects.equal(region_tag, other.region_tag)
        && Objects.equal(hostname, other.hostname)
        && Objects.equal(slug, other.slug)
        && Objects.equal(locales, other.locales)
        && Objects.equal(name, other.name);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        region_tag,
        hostname,
        slug,
        locales,
        name);}
}
