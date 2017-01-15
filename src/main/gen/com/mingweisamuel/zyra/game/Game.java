package com.mingweisamuel.zyra.game;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Game - This object contains game information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version game-v1.3 */
public class Game {
  /**
   * Champion ID associated with game. */
  public final int championId;

  /**
   * Date that end game data was recorded, specified as epoch milliseconds. */
  public final long createDate;

  /**
   * Other players associated with the game. */
  public final List<Player> fellowPlayers;

  /**
   * Game ID. */
  public final long gameId;

  /**
   * Game mode. (Legal values: CLASSIC, ODIN, ARAM, TUTORIAL, ONEFORALL, ASCENSION, FIRSTBLOOD, KINGPORO, SIEGE) */
  public final String gameMode;

  /**
   * Game type. (Legal values: CUSTOM_GAME, MATCHED_GAME, TUTORIAL_GAME) */
  public final String gameType;

  /**
   * Invalid flag. */
  public final boolean invalid;

  /**
   * IP Earned. */
  public final int ipEarned;

  /**
   * Level. */
  public final int level;

  /**
   * Map ID. */
  public final int mapId;

  /**
   * ID of first summoner spell. */
  public final int spell1;

  /**
   * ID of second summoner spell. */
  public final int spell2;

  /**
   * Statistics associated with the game for this summoner. */
  public final RawStats stats;

  /**
   * Game sub-type. (Legal values: NONE, NORMAL, BOT, RANKED_SOLO_5x5, RANKED_PREMADE_3x3, RANKED_PREMADE_5x5, ODIN_UNRANKED, RANKED_TEAM_3x3, RANKED_TEAM_5x5, NORMAL_3x3, BOT_3x3, CAP_5x5, ARAM_UNRANKED_5x5, ONEFORALL_5x5, FIRSTBLOOD_1x1, FIRSTBLOOD_2x2, SR_6x6, URF, URF_BOT, NIGHTMARE_BOT, ASCENSION, HEXAKILL, KING_PORO, COUNTER_PICK, BILGEWATER, SIEGE, RANKED_FLEX_SR, RANKED_FLEX_TT) */
  public final String subType;

  /**
   * Team ID associated with game. Team ID 100 is blue team. Team ID 200 is purple team. */
  public final int teamId;

  public Game(final int championId, final long createDate, final List<Player> fellowPlayers,
      final long gameId, final String gameMode, final String gameType, final boolean invalid,
      final int ipEarned, final int level, final int mapId, final int spell1, final int spell2,
      final RawStats stats, final String subType, final int teamId) {
    this.championId = championId;
    this.createDate = createDate;
    this.fellowPlayers = fellowPlayers;
    this.gameId = gameId;
    this.gameMode = gameMode;
    this.gameType = gameType;
    this.invalid = invalid;
    this.ipEarned = ipEarned;
    this.level = level;
    this.mapId = mapId;
    this.spell1 = spell1;
    this.spell2 = spell2;
    this.stats = stats;
    this.subType = subType;
    this.teamId = teamId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Game)) return false;
    final Game other = (Game) obj;
    return true
        && Objects.equal(championId, other.championId)
        && Objects.equal(createDate, other.createDate)
        && Objects.equal(fellowPlayers, other.fellowPlayers)
        && Objects.equal(gameId, other.gameId)
        && Objects.equal(gameMode, other.gameMode)
        && Objects.equal(gameType, other.gameType)
        && Objects.equal(invalid, other.invalid)
        && Objects.equal(ipEarned, other.ipEarned)
        && Objects.equal(level, other.level)
        && Objects.equal(mapId, other.mapId)
        && Objects.equal(spell1, other.spell1)
        && Objects.equal(spell2, other.spell2)
        && Objects.equal(stats, other.stats)
        && Objects.equal(subType, other.subType)
        && Objects.equal(teamId, other.teamId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        championId,
        createDate,
        fellowPlayers,
        gameId,
        gameMode,
        gameType,
        invalid,
        ipEarned,
        level,
        mapId,
        spell1,
        spell2,
        stats,
        subType,
        teamId);}
}
