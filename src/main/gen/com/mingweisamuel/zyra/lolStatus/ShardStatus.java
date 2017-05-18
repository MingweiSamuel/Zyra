package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * ShardStatus.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-status-v3/GET_getShardData">Riot API reference</a> on Wed May 17 21:34:50 PDT 2017. */
public class ShardStatus implements Serializable {
  public final String name;

  public final String region_tag;

  public final String hostname;

  public final List<Service> services;

  public final String slug;

  public final List<String> locales;

  public ShardStatus(final String name, final String region_tag, final String hostname,
      final List<Service> services, final String slug, final List<String> locales) {
    this.name = name;
    this.region_tag = region_tag;
    this.hostname = hostname;
    this.services = services;
    this.slug = slug;
    this.locales = locales;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ShardStatus)) return false;
    final ShardStatus other = (ShardStatus) obj;
    return true
        && Objects.equal(name, other.name)
        && Objects.equal(region_tag, other.region_tag)
        && Objects.equal(hostname, other.hostname)
        && Objects.equal(services, other.services)
        && Objects.equal(slug, other.slug)
        && Objects.equal(locales, other.locales);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        name,
        region_tag,
        hostname,
        services,
        slug,
        locales);}
}
