package com.mingweisamuel.zyra.spectator;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Participant.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#spectator-v3/GET_getFeaturedGames">Riot API reference</a> on Wed May 17 21:34:50 PDT 2017. */
public class Participant implements Serializable {
  /**
   * The ID of the profile icon used by this participant */
  public final long profileIconId;

  /**
   * The ID of the champion played by this participant */
  public final int championId;

  /**
   * The summoner name of this participant */
  public final String summonerName;

  /**
   * Flag indicating whether or not this participant is a bot */
  public final boolean bot;

  /**
   * The ID of the second summoner spell used by this participant */
  public final long spell2Id;

  /**
   * The team ID of this participant, indicating the participant's team */
  public final long teamId;

  /**
   * The ID of the first summoner spell used by this participant */
  public final long spell1Id;

  public Participant(final long profileIconId, final int championId, final String summonerName,
      final boolean bot, final long spell2Id, final long teamId, final long spell1Id) {
    this.profileIconId = profileIconId;
    this.championId = championId;
    this.summonerName = summonerName;
    this.bot = bot;
    this.spell2Id = spell2Id;
    this.teamId = teamId;
    this.spell1Id = spell1Id;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Participant)) return false;
    final Participant other = (Participant) obj;
    return true
        && Objects.equal(profileIconId, other.profileIconId)
        && Objects.equal(championId, other.championId)
        && Objects.equal(summonerName, other.summonerName)
        && Objects.equal(bot, other.bot)
        && Objects.equal(spell2Id, other.spell2Id)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(spell1Id, other.spell1Id);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        profileIconId,
        championId,
        summonerName,
        bot,
        spell2Id,
        teamId,
        spell1Id);}
}
