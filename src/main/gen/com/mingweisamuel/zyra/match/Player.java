package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Player.<br><br>
 *
 * This object contains match player information.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class Player implements Serializable {
  /**
   * Profile icon ID */
  public final int profileIcon;

  /**
   * Summoner name */
  public final String summonerName;

  /**
   * Match history URI */
  public final String matchHistoryUri;

  /**
   * Summoner ID */
  public final long summonerId;

  public Player(final int profileIcon, final String summonerName, final String matchHistoryUri,
      final long summonerId) {
    this.profileIcon = profileIcon;
    this.summonerName = summonerName;
    this.matchHistoryUri = matchHistoryUri;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Player)) return false;
    final Player other = (Player) obj;
    return true
        && Objects.equal(profileIcon, other.profileIcon)
        && Objects.equal(summonerName, other.summonerName)
        && Objects.equal(matchHistoryUri, other.matchHistoryUri)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        profileIcon,
        summonerName,
        matchHistoryUri,
        summonerId);}
}
