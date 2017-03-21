package com.mingweisamuel.zyra.currentGame;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * CurrentGameParticipant.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#current-game-v1.0/GET_getCurrentGameInfoBySummoner">Riot API reference</a> on Tue Mar 21 15:10:48 PDT 2017. */
public class CurrentGameParticipant implements Serializable {
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
   * The runes used by this participant */
  public final List<Rune> runes;

  /**
   * Flag indicating whether or not this participant is a bot */
  public final boolean bot;

  /**
   * The masteries used by this participant */
  public final List<Mastery> masteries;

  /**
   * The ID of the second summoner spell used by this participant */
  public final long spell2Id;

  /**
   * The team ID of this participant, indicating the participant's team */
  public final long teamId;

  /**
   * The ID of the first summoner spell used by this participant */
  public final long spell1Id;

  /**
   * The summoner ID of this participant */
  public final long summonerId;

  public CurrentGameParticipant(final long profileIconId, final int championId,
      final String summonerName, final List<Rune> runes, final boolean bot,
      final List<Mastery> masteries, final long spell2Id, final long teamId, final long spell1Id,
      final long summonerId) {
    this.profileIconId = profileIconId;
    this.championId = championId;
    this.summonerName = summonerName;
    this.runes = runes;
    this.bot = bot;
    this.masteries = masteries;
    this.spell2Id = spell2Id;
    this.teamId = teamId;
    this.spell1Id = spell1Id;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof CurrentGameParticipant)) return false;
    final CurrentGameParticipant other = (CurrentGameParticipant) obj;
    return true
        && Objects.equal(profileIconId, other.profileIconId)
        && Objects.equal(championId, other.championId)
        && Objects.equal(summonerName, other.summonerName)
        && Objects.equal(runes, other.runes)
        && Objects.equal(bot, other.bot)
        && Objects.equal(masteries, other.masteries)
        && Objects.equal(spell2Id, other.spell2Id)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(spell1Id, other.spell1Id)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        profileIconId,
        championId,
        summonerName,
        runes,
        bot,
        masteries,
        spell2Id,
        teamId,
        spell1Id,
        summonerId);}
}
