package com.mingweisamuel.zyra.tournament;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * TournamentRegistrationParameters.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class TournamentRegistrationParameters implements Serializable {
  /**
   * The optional name of the tournament. */
  public final String name;

  /**
   * The provider ID to specify the regional registered provider data to associate this tournament. */
  public final int providerId;

  public TournamentRegistrationParameters(final String name, final int providerId) {
    this.name = name;
    this.providerId = providerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof TournamentRegistrationParameters)) return false;
    final TournamentRegistrationParameters other = (TournamentRegistrationParameters) obj;
    return true
        && Objects.equal(name, other.name)
        && Objects.equal(providerId, other.providerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        name,
        providerId);}
}
