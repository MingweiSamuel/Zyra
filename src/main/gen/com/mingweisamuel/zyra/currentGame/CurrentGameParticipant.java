package com.mingweisamuel.zyra.currentGame;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * CurrentGameParticipant
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version current-game-v1.0 */
public class CurrentGameParticipant implements Serializable {
  /**
   * Flag indicating whether or not this participant is a bot */
  public final boolean bot;

  /**
   * The ID of the champion played by this participant */
  public final int championId;

  /**
   * The masteries used by this participant */
  public final List<Mastery> masteries;

  /**
   * The ID of the profile icon used by this participant */
  public final long profileIconId;

  /**
   * The runes used by this participant */
  public final List<Rune> runes;

  /**
   * The ID of the first summoner spell used by this participant */
  public final long spell1Id;

  /**
   * The ID of the second summoner spell used by this participant */
  public final long spell2Id;

  /**
   * The summoner ID of this participant */
  public final long summonerId;

  /**
   * The summoner name of this participant */
  public final String summonerName;

  /**
   * The team ID of this participant, indicating the participant's team */
  public final long teamId;

  public CurrentGameParticipant(final boolean bot, final int championId,
      final List<Mastery> masteries, final long profileIconId, final List<Rune> runes,
      final long spell1Id, final long spell2Id, final long summonerId, final String summonerName,
      final long teamId) {
    this.bot = bot;
    this.championId = championId;
    this.masteries = masteries;
    this.profileIconId = profileIconId;
    this.runes = runes;
    this.spell1Id = spell1Id;
    this.spell2Id = spell2Id;
    this.summonerId = summonerId;
    this.summonerName = summonerName;
    this.teamId = teamId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof CurrentGameParticipant)) return false;
    final CurrentGameParticipant other = (CurrentGameParticipant) obj;
    return true
        && Objects.equal(bot, other.bot)
        && Objects.equal(championId, other.championId)
        && Objects.equal(masteries, other.masteries)
        && Objects.equal(profileIconId, other.profileIconId)
        && Objects.equal(runes, other.runes)
        && Objects.equal(spell1Id, other.spell1Id)
        && Objects.equal(spell2Id, other.spell2Id)
        && Objects.equal(summonerId, other.summonerId)
        && Objects.equal(summonerName, other.summonerName)
        && Objects.equal(teamId, other.teamId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        bot,
        championId,
        masteries,
        profileIconId,
        runes,
        spell1Id,
        spell2Id,
        summonerId,
        summonerName,
        teamId);}
}
