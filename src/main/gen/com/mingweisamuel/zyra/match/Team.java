package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * Team - This object contains team information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class Team {
  /**
   * If game was draft mode, contains banned champion data, otherwise null */
  public final List<BannedChampion> bans;

  /**
   * Number of times the team killed baron */
  public final int baronKills;

  /**
   * If game was a dominion game, specifies the points the team had at game end, otherwise null */
  public final long dominionVictoryScore;

  /**
   * Number of times the team killed dragon */
  public final int dragonKills;

  /**
   * Flag indicating whether or not the team got the first baron kill */
  public final boolean firstBaron;

  /**
   * Flag indicating whether or not the team got first blood */
  public final boolean firstBlood;

  /**
   * Flag indicating whether or not the team got the first dragon kill */
  public final boolean firstDragon;

  /**
   * Flag indicating whether or not the team destroyed the first inhibitor */
  public final boolean firstInhibitor;

  /**
   * Flag indicating whether or not the team got the first rift herald kill */
  public final boolean firstRiftHerald;

  /**
   * Flag indicating whether or not the team destroyed the first tower */
  public final boolean firstTower;

  /**
   * Number of inhibitors the team destroyed */
  public final int inhibitorKills;

  /**
   * Number of times the team killed rift herald */
  public final int riftHeraldKills;

  /**
   * Team ID */
  public final int teamId;

  /**
   * Number of towers the team destroyed */
  public final int towerKills;

  /**
   * Number of times the team killed vilemaw */
  public final int vilemawKills;

  /**
   * Flag indicating whether or not the team won */
  public final boolean winner;

  public Team(final List<BannedChampion> bans, final int baronKills,
      final long dominionVictoryScore, final int dragonKills, final boolean firstBaron,
      final boolean firstBlood, final boolean firstDragon, final boolean firstInhibitor,
      final boolean firstRiftHerald, final boolean firstTower, final int inhibitorKills,
      final int riftHeraldKills, final int teamId, final int towerKills, final int vilemawKills,
      final boolean winner) {
    this.bans = bans;
    this.baronKills = baronKills;
    this.dominionVictoryScore = dominionVictoryScore;
    this.dragonKills = dragonKills;
    this.firstBaron = firstBaron;
    this.firstBlood = firstBlood;
    this.firstDragon = firstDragon;
    this.firstInhibitor = firstInhibitor;
    this.firstRiftHerald = firstRiftHerald;
    this.firstTower = firstTower;
    this.inhibitorKills = inhibitorKills;
    this.riftHeraldKills = riftHeraldKills;
    this.teamId = teamId;
    this.towerKills = towerKills;
    this.vilemawKills = vilemawKills;
    this.winner = winner;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Team)) return false;
    final Team other = (Team) obj;
    return true
        && Objects.equal(bans, other.bans)
        && Objects.equal(baronKills, other.baronKills)
        && Objects.equal(dominionVictoryScore, other.dominionVictoryScore)
        && Objects.equal(dragonKills, other.dragonKills)
        && Objects.equal(firstBaron, other.firstBaron)
        && Objects.equal(firstBlood, other.firstBlood)
        && Objects.equal(firstDragon, other.firstDragon)
        && Objects.equal(firstInhibitor, other.firstInhibitor)
        && Objects.equal(firstRiftHerald, other.firstRiftHerald)
        && Objects.equal(firstTower, other.firstTower)
        && Objects.equal(inhibitorKills, other.inhibitorKills)
        && Objects.equal(riftHeraldKills, other.riftHeraldKills)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(towerKills, other.towerKills)
        && Objects.equal(vilemawKills, other.vilemawKills)
        && Objects.equal(winner, other.winner);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        bans,
        baronKills,
        dominionVictoryScore,
        dragonKills,
        firstBaron,
        firstBlood,
        firstDragon,
        firstInhibitor,
        firstRiftHerald,
        firstTower,
        inhibitorKills,
        riftHeraldKills,
        teamId,
        towerKills,
        vilemawKills,
        winner);}
}
