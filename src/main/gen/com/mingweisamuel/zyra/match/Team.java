package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * Team.<br><br>
 *
 * This object contains team information.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 15:10:48 PDT 2017. */
public class Team implements Serializable {
  /**
   * Flag indicating whether or not the team got the first dragon kill */
  public final boolean firstDragon;

  /**
   * If game was draft mode, contains banned champion data, otherwise null */
  public final List<BannedChampion> bans;

  /**
   * Flag indicating whether or not the team destroyed the first inhibitor */
  public final boolean firstInhibitor;

  /**
   * Number of times the team killed baron */
  public final int baronKills;

  /**
   * Flag indicating whether or not the team got the first rift herald kill */
  public final boolean firstRiftHerald;

  /**
   * Flag indicating whether or not the team won */
  public final boolean winner;

  /**
   * Flag indicating whether or not the team got the first baron kill */
  public final boolean firstBaron;

  /**
   * Number of times the team killed rift herald */
  public final int riftHeraldKills;

  /**
   * Flag indicating whether or not the team got first blood */
  public final boolean firstBlood;

  /**
   * Team ID */
  public final int teamId;

  /**
   * Flag indicating whether or not the team destroyed the first tower */
  public final boolean firstTower;

  /**
   * Number of times the team killed vilemaw */
  public final int vilemawKills;

  /**
   * Number of inhibitors the team destroyed */
  public final int inhibitorKills;

  /**
   * Number of towers the team destroyed */
  public final int towerKills;

  /**
   * If game was a dominion game, specifies the points the team had at game end, otherwise null */
  public final long dominionVictoryScore;

  /**
   * Number of times the team killed dragon */
  public final int dragonKills;

  public Team(final boolean firstDragon, final List<BannedChampion> bans,
      final boolean firstInhibitor, final int baronKills, final boolean firstRiftHerald,
      final boolean winner, final boolean firstBaron, final int riftHeraldKills,
      final boolean firstBlood, final int teamId, final boolean firstTower, final int vilemawKills,
      final int inhibitorKills, final int towerKills, final long dominionVictoryScore,
      final int dragonKills) {
    this.firstDragon = firstDragon;
    this.bans = bans;
    this.firstInhibitor = firstInhibitor;
    this.baronKills = baronKills;
    this.firstRiftHerald = firstRiftHerald;
    this.winner = winner;
    this.firstBaron = firstBaron;
    this.riftHeraldKills = riftHeraldKills;
    this.firstBlood = firstBlood;
    this.teamId = teamId;
    this.firstTower = firstTower;
    this.vilemawKills = vilemawKills;
    this.inhibitorKills = inhibitorKills;
    this.towerKills = towerKills;
    this.dominionVictoryScore = dominionVictoryScore;
    this.dragonKills = dragonKills;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Team)) return false;
    final Team other = (Team) obj;
    return true
        && Objects.equal(firstDragon, other.firstDragon)
        && Objects.equal(bans, other.bans)
        && Objects.equal(firstInhibitor, other.firstInhibitor)
        && Objects.equal(baronKills, other.baronKills)
        && Objects.equal(firstRiftHerald, other.firstRiftHerald)
        && Objects.equal(winner, other.winner)
        && Objects.equal(firstBaron, other.firstBaron)
        && Objects.equal(riftHeraldKills, other.riftHeraldKills)
        && Objects.equal(firstBlood, other.firstBlood)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(firstTower, other.firstTower)
        && Objects.equal(vilemawKills, other.vilemawKills)
        && Objects.equal(inhibitorKills, other.inhibitorKills)
        && Objects.equal(towerKills, other.towerKills)
        && Objects.equal(dominionVictoryScore, other.dominionVictoryScore)
        && Objects.equal(dragonKills, other.dragonKills);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        firstDragon,
        bans,
        firstInhibitor,
        baronKills,
        firstRiftHerald,
        winner,
        firstBaron,
        riftHeraldKills,
        firstBlood,
        teamId,
        firstTower,
        vilemawKills,
        inhibitorKills,
        towerKills,
        dominionVictoryScore,
        dragonKills);}
}
