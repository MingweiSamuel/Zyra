package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * LeaguePosition.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getAllLeaguePositionsForSummoner">Riot API reference</a> on Wed May 17 19:48:11 PDT 2017. */
public class LeaguePosition implements Serializable {
  public final String rank;

  public final String queueType;

  public final boolean hotStreak;

  public final MiniSeries miniSeries;

  public final int wins;

  public final boolean veteran;

  public final int losses;

  public final String playerOrTeamId;

  public final String leagueName;

  public final String playerOrTeamName;

  public final boolean inactive;

  public final boolean freshBlood;

  public final String tier;

  public final int leaguePoints;

  public LeaguePosition(final String rank, final String queueType, final boolean hotStreak,
      final MiniSeries miniSeries, final int wins, final boolean veteran, final int losses,
      final String playerOrTeamId, final String leagueName, final String playerOrTeamName,
      final boolean inactive, final boolean freshBlood, final String tier, final int leaguePoints) {
    this.rank = rank;
    this.queueType = queueType;
    this.hotStreak = hotStreak;
    this.miniSeries = miniSeries;
    this.wins = wins;
    this.veteran = veteran;
    this.losses = losses;
    this.playerOrTeamId = playerOrTeamId;
    this.leagueName = leagueName;
    this.playerOrTeamName = playerOrTeamName;
    this.inactive = inactive;
    this.freshBlood = freshBlood;
    this.tier = tier;
    this.leaguePoints = leaguePoints;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LeaguePosition)) return false;
    final LeaguePosition other = (LeaguePosition) obj;
    return true
        && Objects.equal(rank, other.rank)
        && Objects.equal(queueType, other.queueType)
        && Objects.equal(hotStreak, other.hotStreak)
        && Objects.equal(miniSeries, other.miniSeries)
        && Objects.equal(wins, other.wins)
        && Objects.equal(veteran, other.veteran)
        && Objects.equal(losses, other.losses)
        && Objects.equal(playerOrTeamId, other.playerOrTeamId)
        && Objects.equal(leagueName, other.leagueName)
        && Objects.equal(playerOrTeamName, other.playerOrTeamName)
        && Objects.equal(inactive, other.inactive)
        && Objects.equal(freshBlood, other.freshBlood)
        && Objects.equal(tier, other.tier)
        && Objects.equal(leaguePoints, other.leaguePoints);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        rank,
        queueType,
        hotStreak,
        miniSeries,
        wins,
        veteran,
        losses,
        playerOrTeamId,
        leagueName,
        playerOrTeamName,
        inactive,
        freshBlood,
        tier,
        leaguePoints);}
}
