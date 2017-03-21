package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * LeagueEntry.<br /><br />
 *
 * This object contains league participant information representing a summoner or team..<br /><br />
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#league-v2.5/GET_getChallengerLeagues">Riot API reference</a> on Tue Mar 21 14:58:35 PDT 2017. */
public class LeagueEntry implements Serializable {
  /**
   * Specifies if the participant is fresh blood. */
  public final boolean isFreshBlood;

  /**
   * The league division of the participant. */
  public final String division;

  /**
   * The playstyle of the participant. */
  public final String playstyle;

  /**
   * Mini series data for the participant. Only present if the participant is currently in a mini series. */
  public final MiniSeries miniSeries;

  /**
   * The number of wins for the participant. */
  public final int wins;

  /**
   * The number of losses for the participant. */
  public final int losses;

  /**
   * The ID of the participant (i.e., summoner or team) represented by this entry. */
  public final String playerOrTeamId;

  /**
   * The name of the the participant (i.e., summoner or team) represented by this entry. */
  public final String playerOrTeamName;

  /**
   * Specifies if the participant is on a hot streak. */
  public final boolean isHotStreak;

  /**
   * Specifies if the participant is inactive. */
  public final boolean isInactive;

  /**
   * Specifies if the participant is a veteran. */
  public final boolean isVeteran;

  /**
   * The league points of the participant. */
  public final int leaguePoints;

  public LeagueEntry(final boolean isFreshBlood, final String division, final String playstyle,
      final MiniSeries miniSeries, final int wins, final int losses, final String playerOrTeamId,
      final String playerOrTeamName, final boolean isHotStreak, final boolean isInactive,
      final boolean isVeteran, final int leaguePoints) {
    this.isFreshBlood = isFreshBlood;
    this.division = division;
    this.playstyle = playstyle;
    this.miniSeries = miniSeries;
    this.wins = wins;
    this.losses = losses;
    this.playerOrTeamId = playerOrTeamId;
    this.playerOrTeamName = playerOrTeamName;
    this.isHotStreak = isHotStreak;
    this.isInactive = isInactive;
    this.isVeteran = isVeteran;
    this.leaguePoints = leaguePoints;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LeagueEntry)) return false;
    final LeagueEntry other = (LeagueEntry) obj;
    return true
        && Objects.equal(isFreshBlood, other.isFreshBlood)
        && Objects.equal(division, other.division)
        && Objects.equal(playstyle, other.playstyle)
        && Objects.equal(miniSeries, other.miniSeries)
        && Objects.equal(wins, other.wins)
        && Objects.equal(losses, other.losses)
        && Objects.equal(playerOrTeamId, other.playerOrTeamId)
        && Objects.equal(playerOrTeamName, other.playerOrTeamName)
        && Objects.equal(isHotStreak, other.isHotStreak)
        && Objects.equal(isInactive, other.isInactive)
        && Objects.equal(isVeteran, other.isVeteran)
        && Objects.equal(leaguePoints, other.leaguePoints);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        isFreshBlood,
        division,
        playstyle,
        miniSeries,
        wins,
        losses,
        playerOrTeamId,
        playerOrTeamName,
        isHotStreak,
        isInactive,
        isVeteran,
        leaguePoints);}
}
