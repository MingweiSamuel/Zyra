package com.mingweisamuel.zyra.leagueV4;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * LeagueEntry.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class LeagueEntry implements Serializable {
  public final boolean freshBlood;

  public final boolean hotStreak;

  public final boolean inactive;

  public final String leagueId;

  public final int leaguePoints;

  public final int losses;

  public final MiniSeries miniSeries;

  public final String queueType;

  public final String rank;

  /**
   * Player's summonerId (Encrypted) */
  public final String summonerId;

  public final String summonerName;

  public final String tier;

  public final boolean veteran;

  public final int wins;

  public LeagueEntry(final boolean freshBlood, final boolean hotStreak, final boolean inactive,
      final String leagueId, final int leaguePoints, final int losses, final MiniSeries miniSeries,
      final String queueType, final String rank, final String summonerId, final String summonerName,
      final String tier, final boolean veteran, final int wins) {
    this.freshBlood = freshBlood;
    this.hotStreak = hotStreak;
    this.inactive = inactive;
    this.leagueId = leagueId;
    this.leaguePoints = leaguePoints;
    this.losses = losses;
    this.miniSeries = miniSeries;
    this.queueType = queueType;
    this.rank = rank;
    this.summonerId = summonerId;
    this.summonerName = summonerName;
    this.tier = tier;
    this.veteran = veteran;
    this.wins = wins;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LeagueEntry)) return false;
    final LeagueEntry other = (LeagueEntry) obj;
    return true
        && Objects.equal(freshBlood, other.freshBlood)
        && Objects.equal(hotStreak, other.hotStreak)
        && Objects.equal(inactive, other.inactive)
        && Objects.equal(leagueId, other.leagueId)
        && Objects.equal(leaguePoints, other.leaguePoints)
        && Objects.equal(losses, other.losses)
        && Objects.equal(miniSeries, other.miniSeries)
        && Objects.equal(queueType, other.queueType)
        && Objects.equal(rank, other.rank)
        && Objects.equal(summonerId, other.summonerId)
        && Objects.equal(summonerName, other.summonerName)
        && Objects.equal(tier, other.tier)
        && Objects.equal(veteran, other.veteran)
        && Objects.equal(wins, other.wins);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        freshBlood,
        hotStreak,
        inactive,
        leagueId,
        leaguePoints,
        losses,
        miniSeries,
        queueType,
        rank,
        summonerId,
        summonerName,
        tier,
        veteran,
        wins);}
}
