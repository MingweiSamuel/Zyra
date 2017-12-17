package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * LeaguePosition.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class LeaguePosition implements Serializable {
  public final boolean freshBlood;

  public final boolean hotStreak;

  public final boolean inactive;

  public final String leagueId;

  public final String leagueName;

  public final int leaguePoints;

  public final int losses;

  public final MiniSeries miniSeries;

  public final String playerOrTeamId;

  public final String playerOrTeamName;

  public final String queueType;

  public final String rank;

  public final String tier;

  public final boolean veteran;

  public final int wins;

  public LeaguePosition(final boolean freshBlood, final boolean hotStreak, final boolean inactive,
      final String leagueId, final String leagueName, final int leaguePoints, final int losses,
      final MiniSeries miniSeries, final String playerOrTeamId, final String playerOrTeamName,
      final String queueType, final String rank, final String tier, final boolean veteran,
      final int wins) {
    this.freshBlood = freshBlood;
    this.hotStreak = hotStreak;
    this.inactive = inactive;
    this.leagueId = leagueId;
    this.leagueName = leagueName;
    this.leaguePoints = leaguePoints;
    this.losses = losses;
    this.miniSeries = miniSeries;
    this.playerOrTeamId = playerOrTeamId;
    this.playerOrTeamName = playerOrTeamName;
    this.queueType = queueType;
    this.rank = rank;
    this.tier = tier;
    this.veteran = veteran;
    this.wins = wins;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LeaguePosition)) return false;
    final LeaguePosition other = (LeaguePosition) obj;
    return true
        && Objects.equal(freshBlood, other.freshBlood)
        && Objects.equal(hotStreak, other.hotStreak)
        && Objects.equal(inactive, other.inactive)
        && Objects.equal(leagueId, other.leagueId)
        && Objects.equal(leagueName, other.leagueName)
        && Objects.equal(leaguePoints, other.leaguePoints)
        && Objects.equal(losses, other.losses)
        && Objects.equal(miniSeries, other.miniSeries)
        && Objects.equal(playerOrTeamId, other.playerOrTeamId)
        && Objects.equal(playerOrTeamName, other.playerOrTeamName)
        && Objects.equal(queueType, other.queueType)
        && Objects.equal(rank, other.rank)
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
        leagueName,
        leaguePoints,
        losses,
        miniSeries,
        playerOrTeamId,
        playerOrTeamName,
        queueType,
        rank,
        tier,
        veteran,
        wins);}
}
