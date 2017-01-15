package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Player - This object contains match player information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Player {
  /**
   * Match history URI */
  public final String matchHistoryUri;

  /**
   * Profile icon ID */
  public final int profileIcon;

  /**
   * Summoner ID */
  public final long summonerId;

  /**
   * Summoner name */
  public final String summonerName;

  public Player(final String matchHistoryUri, final int profileIcon, final long summonerId,
      final String summonerName) {
    this.matchHistoryUri = matchHistoryUri;
    this.profileIcon = profileIcon;
    this.summonerId = summonerId;
    this.summonerName = summonerName;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Player)) return false;
    final Player other = (Player) obj;
    return true
        && Objects.equal(matchHistoryUri, other.matchHistoryUri)
        && Objects.equal(profileIcon, other.profileIcon)
        && Objects.equal(summonerId, other.summonerId)
        && Objects.equal(summonerName, other.summonerName);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        matchHistoryUri,
        profileIcon,
        summonerId,
        summonerName);}
}
