package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * LeagueItem.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#league-v3/GET_getChallengerLeague">Riot API reference</a> on Wed May 17 21:53:10 PDT 2017. */
public class LeagueItem implements Serializable {
  public final String rank;

  public final boolean hotStreak;

  public final MiniSeries miniSeries;

  public final int wins;

  public final boolean veteran;

  public final int losses;

  public final String playerOrTeamId;

  public final String playerOrTeamName;

  public final boolean inactive;

  public final boolean freshBlood;

  public final int leaguePoints;

  public LeagueItem(final String rank, final boolean hotStreak, final MiniSeries miniSeries,
      final int wins, final boolean veteran, final int losses, final String playerOrTeamId,
      final String playerOrTeamName, final boolean inactive, final boolean freshBlood,
      final int leaguePoints) {
    this.rank = rank;
    this.hotStreak = hotStreak;
    this.miniSeries = miniSeries;
    this.wins = wins;
    this.veteran = veteran;
    this.losses = losses;
    this.playerOrTeamId = playerOrTeamId;
    this.playerOrTeamName = playerOrTeamName;
    this.inactive = inactive;
    this.freshBlood = freshBlood;
    this.leaguePoints = leaguePoints;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LeagueItem)) return false;
    final LeagueItem other = (LeagueItem) obj;
    return true
        && Objects.equal(rank, other.rank)
        && Objects.equal(hotStreak, other.hotStreak)
        && Objects.equal(miniSeries, other.miniSeries)
        && Objects.equal(wins, other.wins)
        && Objects.equal(veteran, other.veteran)
        && Objects.equal(losses, other.losses)
        && Objects.equal(playerOrTeamId, other.playerOrTeamId)
        && Objects.equal(playerOrTeamName, other.playerOrTeamName)
        && Objects.equal(inactive, other.inactive)
        && Objects.equal(freshBlood, other.freshBlood)
        && Objects.equal(leaguePoints, other.leaguePoints);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        rank,
        hotStreak,
        miniSeries,
        wins,
        veteran,
        losses,
        playerOrTeamId,
        playerOrTeamName,
        inactive,
        freshBlood,
        leaguePoints);}
}
