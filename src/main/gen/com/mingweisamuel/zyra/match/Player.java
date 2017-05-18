package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Player.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Riot API reference</a> on Wed May 17 21:53:10 PDT 2017. */
public class Player implements Serializable {
  public final String currentPlatformId;

  public final String summonerName;

  public final String matchHistoryUri;

  public final String platformId;

  public final long currentAccountId;

  public final int profileIcon;

  public final long summonerId;

  public final long accountId;

  public Player(final String currentPlatformId, final String summonerName,
      final String matchHistoryUri, final String platformId, final long currentAccountId,
      final int profileIcon, final long summonerId, final long accountId) {
    this.currentPlatformId = currentPlatformId;
    this.summonerName = summonerName;
    this.matchHistoryUri = matchHistoryUri;
    this.platformId = platformId;
    this.currentAccountId = currentAccountId;
    this.profileIcon = profileIcon;
    this.summonerId = summonerId;
    this.accountId = accountId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Player)) return false;
    final Player other = (Player) obj;
    return true
        && Objects.equal(currentPlatformId, other.currentPlatformId)
        && Objects.equal(summonerName, other.summonerName)
        && Objects.equal(matchHistoryUri, other.matchHistoryUri)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(currentAccountId, other.currentAccountId)
        && Objects.equal(profileIcon, other.profileIcon)
        && Objects.equal(summonerId, other.summonerId)
        && Objects.equal(accountId, other.accountId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        currentPlatformId,
        summonerName,
        matchHistoryUri,
        platformId,
        currentAccountId,
        profileIcon,
        summonerId,
        accountId);}
}
