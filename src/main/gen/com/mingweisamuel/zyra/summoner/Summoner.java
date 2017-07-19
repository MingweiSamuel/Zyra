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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#summoner-v3/GET_getByAccountId">Riot API reference</a>. */
public class Summoner implements Serializable {
  /**
   * ID of the summoner icon associated with the summoner. */
  public final int profileIconId;

  /**
   * Summoner name. */
  public final String name;

  /**
   * Summoner level associated with the summoner. */
  public final long summonerLevel;

  /**
   * Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: profile icon change, playing the tutorial or advanced tutorial, finishing a game, summoner name change */
  public final long revisionDate;

  /**
   * Summoner ID. */
  public final long id;

  /**
   * Account ID. */
  public final long accountId;

  public Summoner(final int profileIconId, final String name, final long summonerLevel,
      final long revisionDate, final long id, final long accountId) {
    this.profileIconId = profileIconId;
    this.name = name;
    this.summonerLevel = summonerLevel;
    this.revisionDate = revisionDate;
    this.id = id;
    this.accountId = accountId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Summoner)) return false;
    final Summoner other = (Summoner) obj;
    return true
        && Objects.equal(profileIconId, other.profileIconId)
        && Objects.equal(name, other.name)
        && Objects.equal(summonerLevel, other.summonerLevel)
        && Objects.equal(revisionDate, other.revisionDate)
        && Objects.equal(id, other.id)
        && Objects.equal(accountId, other.accountId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        profileIconId,
        name,
        summonerLevel,
        revisionDate,
        id,
        accountId);}
}
