package com.mingweisamuel.zyra.game;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Game.<br><br>
 *
 * This object contains game information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#game-v1.3/GET_getRecentGames">Riot API reference</a> on Tue Mar 21 15:10:48 PDT 2017. */
public class Game implements Serializable {
  /**
   * Game type. */
  public final String gameType;

  /**
   * Game ID. */
  public final long gameId;

  /**
   * Statistics associated with the game for this summoner. */
  public final RawStats stats;

  /**
   * Level. */
  public final int level;

  /**
   * Date that end game data was recorded, specified as epoch milliseconds. */
  public final long createDate;

  /**
   * Game mode. */
  public final String gameMode;

  /**
   * Map ID. */
  public final int mapId;

  /**
   * Invalid flag. */
  public final boolean invalid;

  /**
   * Game sub-type. */
  public final String subType;

  /**
   * Team ID associated with game. Team ID 100 is blue team. Team ID 200 is purple team. */
  public final int teamId;

  /**
   * IP Earned. */
  public final int ipEarned;

  /**
   * Other players associated with the game. */
  public final List<Player> fellowPlayers;

  /**
   * Champion ID associated with game. */
  public final int championId;

  /**
   * ID of first summoner spell. */
  public final int spell1;

  /**
   * ID of second summoner spell. */
  public final int spell2;

  public Game(final String gameType, final long gameId, final RawStats stats, final int level,
      final long createDate, final String gameMode, final int mapId, final boolean invalid,
      final String subType, final int teamId, final int ipEarned, final List<Player> fellowPlayers,
      final int championId, final int spell1, final int spell2) {
    this.gameType = gameType;
    this.gameId = gameId;
    this.stats = stats;
    this.level = level;
    this.createDate = createDate;
    this.gameMode = gameMode;
    this.mapId = mapId;
    this.invalid = invalid;
    this.subType = subType;
    this.teamId = teamId;
    this.ipEarned = ipEarned;
    this.fellowPlayers = fellowPlayers;
    this.championId = championId;
    this.spell1 = spell1;
    this.spell2 = spell2;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Game)) return false;
    final Game other = (Game) obj;
    return true
        && Objects.equal(gameType, other.gameType)
        && Objects.equal(gameId, other.gameId)
        && Objects.equal(stats, other.stats)
        && Objects.equal(level, other.level)
        && Objects.equal(createDate, other.createDate)
        && Objects.equal(gameMode, other.gameMode)
        && Objects.equal(mapId, other.mapId)
        && Objects.equal(invalid, other.invalid)
        && Objects.equal(subType, other.subType)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(ipEarned, other.ipEarned)
        && Objects.equal(fellowPlayers, other.fellowPlayers)
        && Objects.equal(championId, other.championId)
        && Objects.equal(spell1, other.spell1)
        && Objects.equal(spell2, other.spell2);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        gameType,
        gameId,
        stats,
        level,
        createDate,
        gameMode,
        mapId,
        invalid,
        subType,
        teamId,
        ipEarned,
        fellowPlayers,
        championId,
        spell1,
        spell2);}
}
