package com.mingweisamuel.zyra.matchV4;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Player.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Player implements Serializable {
  /**
   * Player's original accountId (Encrypted) */
  public final String accountId;

  /**
   * Player's current accountId (Encrypted) */
  public final String currentAccountId;

  public final String currentPlatformId;

  public final String matchHistoryUri;

  /**
   * Original platformId. */
  public final String platformId;

  public final int profileIcon;

  /**
   * Player's summonerId (Encrypted) */
  public final String summonerId;

  public final String summonerName;

  public Player(final String accountId, final String currentAccountId,
      final String currentPlatformId, final String matchHistoryUri, final String platformId,
      final int profileIcon, final String summonerId, final String summonerName) {
    this.accountId = accountId;
    this.currentAccountId = currentAccountId;
    this.currentPlatformId = currentPlatformId;
    this.matchHistoryUri = matchHistoryUri;
    this.platformId = platformId;
    this.profileIcon = profileIcon;
    this.summonerId = summonerId;
    this.summonerName = summonerName;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Player)) return false;
    final Player other = (Player) obj;
    return true
        && Objects.equal(accountId, other.accountId)
        && Objects.equal(currentAccountId, other.currentAccountId)
        && Objects.equal(currentPlatformId, other.currentPlatformId)
        && Objects.equal(matchHistoryUri, other.matchHistoryUri)
        && Objects.equal(platformId, other.platformId)
        && Objects.equal(profileIcon, other.profileIcon)
        && Objects.equal(summonerId, other.summonerId)
        && Objects.equal(summonerName, other.summonerName);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        accountId,
        currentAccountId,
        currentPlatformId,
        matchHistoryUri,
        platformId,
        profileIcon,
        summonerId,
        summonerName);}
}
