package com.mingweisamuel.zyra.featuredGames;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Participant
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version featured-games-v1.0 */
public class Participant implements Serializable {
  /**
   * Flag indicating whether or not this participant is a bot */
  public final boolean bot;

  /**
   * The ID of the champion played by this participant */
  public final int championId;

  /**
   * The ID of the profile icon used by this participant */
  public final long profileIconId;

  /**
   * The ID of the first summoner spell used by this participant */
  public final long spell1Id;

  /**
   * The ID of the second summoner spell used by this participant */
  public final long spell2Id;

  /**
   * The summoner name of this participant */
  public final String summonerName;

  /**
   * The team ID of this participant, indicating the participant's team */
  public final long teamId;

  public Participant(final boolean bot, final int championId, final long profileIconId,
      final long spell1Id, final long spell2Id, final String summonerName, final long teamId) {
    this.bot = bot;
    this.championId = championId;
    this.profileIconId = profileIconId;
    this.spell1Id = spell1Id;
    this.spell2Id = spell2Id;
    this.summonerName = summonerName;
    this.teamId = teamId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Participant)) return false;
    final Participant other = (Participant) obj;
    return true
        && Objects.equal(bot, other.bot)
        && Objects.equal(championId, other.championId)
        && Objects.equal(profileIconId, other.profileIconId)
        && Objects.equal(spell1Id, other.spell1Id)
        && Objects.equal(spell2Id, other.spell2Id)
        && Objects.equal(summonerName, other.summonerName)
        && Objects.equal(teamId, other.teamId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        bot,
        championId,
        profileIconId,
        spell1Id,
        spell2Id,
        summonerName,
        teamId);}
}
