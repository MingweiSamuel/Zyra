package com.mingweisamuel.zyra.leagueV4;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * LeagueItem.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class LeagueItem implements Serializable {
  public final boolean freshBlood;

  public final boolean hotStreak;

  public final boolean inactive;

  public final int leaguePoints;

  public final int losses;

  public final MiniSeries miniSeries;

  public final String rank;

  /**
   * Player's summonerId (Encrypted) */
  public final String summonerId;

  public final String summonerName;

  public final boolean veteran;

  public final int wins;

  public LeagueItem(final boolean freshBlood, final boolean hotStreak, final boolean inactive,
      final int leaguePoints, final int losses, final MiniSeries miniSeries, final String rank,
      final String summonerId, final String summonerName, final boolean veteran, final int wins) {
    this.freshBlood = freshBlood;
    this.hotStreak = hotStreak;
    this.inactive = inactive;
    this.leaguePoints = leaguePoints;
    this.losses = losses;
    this.miniSeries = miniSeries;
    this.rank = rank;
    this.summonerId = summonerId;
    this.summonerName = summonerName;
    this.veteran = veteran;
    this.wins = wins;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LeagueItem)) return false;
    final LeagueItem other = (LeagueItem) obj;
    return true
        && Objects.equal(freshBlood, other.freshBlood)
        && Objects.equal(hotStreak, other.hotStreak)
        && Objects.equal(inactive, other.inactive)
        && Objects.equal(leaguePoints, other.leaguePoints)
        && Objects.equal(losses, other.losses)
        && Objects.equal(miniSeries, other.miniSeries)
        && Objects.equal(rank, other.rank)
        && Objects.equal(summonerId, other.summonerId)
        && Objects.equal(summonerName, other.summonerName)
        && Objects.equal(veteran, other.veteran)
        && Objects.equal(wins, other.wins);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        freshBlood,
        hotStreak,
        inactive,
        leaguePoints,
        losses,
        miniSeries,
        rank,
        summonerId,
        summonerName,
        veteran,
        wins);}
}
