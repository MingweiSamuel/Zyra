package com.mingweisamuel.zyra.summoner;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * represents a summoner.<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#summoner-v1.4/GET_getByAccountIds">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Summoner {
  /**
   * ID of the summoner icon associated with the summoner. */
  public final int profileIconId;

  /**
   * Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name change */
  public final long revisionDate;

  /**
   * Summoner ID. */
  public final long id;

  /**
   * Summoner name. */
  public final String name;

  /**
   * Summoner level associated with the summoner. */
  public final long summonerLevel;

  public Summoner(final int profileIconId, final long revisionDate, final long id,
      final String name, final long summonerLevel) {
    this.profileIconId = profileIconId;
    this.revisionDate = revisionDate;
    this.id = id;
    this.name = name;
    this.summonerLevel = summonerLevel;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Summoner)) return false;
    final Summoner other = (Summoner) obj;
    return true
        && Objects.equal(profileIconId, other.profileIconId)
        && Objects.equal(revisionDate, other.revisionDate)
        && Objects.equal(id, other.id)
        && Objects.equal(name, other.name)
        && Objects.equal(summonerLevel, other.summonerLevel);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        profileIconId,
        revisionDate,
        id,
        name,
        summonerLevel);}
}
