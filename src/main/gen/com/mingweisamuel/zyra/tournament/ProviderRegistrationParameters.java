package com.mingweisamuel.zyra.tournament;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * ProviderRegistrationParameters.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ProviderRegistrationParameters implements Serializable {
  /**
   * The region in which the provider will be running tournaments.
   *              (Legal values:  BR,  EUNE,  EUW,  JP,  LAN,  LAS,  NA,  OCE,  PBE,  RU,  TR) */
  public final String region;

  /**
   * The provider's callback URL to which tournament game results in this region should be posted. The URL must be well-formed, use the http or https protocol, and use the default port for the protocol (http URLs must use port 80, https URLs must use port 443). */
  public final String url;

  public ProviderRegistrationParameters(final String region, final String url) {
    this.region = region;
    this.url = url;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ProviderRegistrationParameters)) return false;
    final ProviderRegistrationParameters other = (ProviderRegistrationParameters) obj;
    return true
        && Objects.equal(region, other.region)
        && Objects.equal(url, other.url);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        region,
        url);}
}
