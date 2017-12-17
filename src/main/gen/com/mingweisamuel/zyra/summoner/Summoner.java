package com.mingweisamuel.zyra.summoner;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Summoner.<br><br>
 *
 * represents a summoner.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Summoner implements Serializable {
  /**
   * Account ID. */
  public final long accountId;

  /**
   * Summoner ID. */
  public final long id;

  /**
   * Summoner name. */
  public final String name;

  /**
   * ID of the summoner icon associated with the summoner. */
  public final int profileIconId;

  /**
   * Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name change */
  public final long revisionDate;

  /**
   * Summoner level associated with the summoner. */
  public final long summonerLevel;

  public Summoner(final long accountId, final long id, final String name, final int profileIconId,
      final long revisionDate, final long summonerLevel) {
    this.accountId = accountId;
    this.id = id;
    this.name = name;
    this.profileIconId = profileIconId;
    this.revisionDate = revisionDate;
    this.summonerLevel = summonerLevel;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Summoner)) return false;
    final Summoner other = (Summoner) obj;
    return true
        && Objects.equal(accountId, other.accountId)
        && Objects.equal(id, other.id)
        && Objects.equal(name, other.name)
        && Objects.equal(profileIconId, other.profileIconId)
        && Objects.equal(revisionDate, other.revisionDate)
        && Objects.equal(summonerLevel, other.summonerLevel);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        accountId,
        id,
        name,
        profileIconId,
        revisionDate,
        summonerLevel);}
}
