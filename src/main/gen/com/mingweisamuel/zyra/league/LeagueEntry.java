package com.mingweisamuel.zyra.league;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * LeagueEntry - This object contains league participant information representing a summoner or team.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version league-v2.5 */
public class LeagueEntry implements Serializable {
  /**
   * The league division of the participant. */
  public final String division;

  /**
   * Specifies if the participant is fresh blood. */
  public final boolean isFreshBlood;

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

  /**
   * The number of losses for the participant. */
  public final int losses;

  /**
   * Mini series data for the participant. Only present if the participant is currently in a mini series. */
  public final MiniSeries miniSeries;

  /**
   * The ID of the participant (i.e., summoner or team) represented by this entry. */
  public final String playerOrTeamId;

  /**
   * The name of the the participant (i.e., summoner or team) represented by this entry. */
  public final String playerOrTeamName;

  /**
   * The playstyle of the participant. (Legal values: NONE, SOLO, SQUAD, TEAM) */
  public final String playstyle;

  /**
   * The number of wins for the participant. */
  public final int wins;

  public LeagueEntry(final String division, final boolean isFreshBlood, final boolean isHotStreak,
      final boolean isInactive, final boolean isVeteran, final int leaguePoints, final int losses,
      final MiniSeries miniSeries, final String playerOrTeamId, final String playerOrTeamName,
      final String playstyle, final int wins) {
    this.division = division;
    this.isFreshBlood = isFreshBlood;
    this.isHotStreak = isHotStreak;
    this.isInactive = isInactive;
    this.isVeteran = isVeteran;
    this.leaguePoints = leaguePoints;
    this.losses = losses;
    this.miniSeries = miniSeries;
    this.playerOrTeamId = playerOrTeamId;
    this.playerOrTeamName = playerOrTeamName;
    this.playstyle = playstyle;
    this.wins = wins;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LeagueEntry)) return false;
    final LeagueEntry other = (LeagueEntry) obj;
    return true
        && Objects.equal(division, other.division)
        && Objects.equal(isFreshBlood, other.isFreshBlood)
        && Objects.equal(isHotStreak, other.isHotStreak)
        && Objects.equal(isInactive, other.isInactive)
        && Objects.equal(isVeteran, other.isVeteran)
        && Objects.equal(leaguePoints, other.leaguePoints)
        && Objects.equal(losses, other.losses)
        && Objects.equal(miniSeries, other.miniSeries)
        && Objects.equal(playerOrTeamId, other.playerOrTeamId)
        && Objects.equal(playerOrTeamName, other.playerOrTeamName)
        && Objects.equal(playstyle, other.playstyle)
        && Objects.equal(wins, other.wins);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        division,
        isFreshBlood,
        isHotStreak,
        isInactive,
        isVeteran,
        leaguePoints,
        losses,
        miniSeries,
        playerOrTeamId,
        playerOrTeamName,
        playstyle,
        wins);}
}
