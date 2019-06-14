package com.mingweisamuel.zyra.matchV4;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * TeamStats.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class TeamStats implements Serializable {
  /**
   * If match queueId has a draft, contains banned champion data, otherwise empty. */
  public final List<TeamBans> bans;

  /**
   * Number of times the team killed Baron. */
  public final int baronKills;

  /**
   * For Dominion matches, specifies the points the team had at game end. */
  public final int dominionVictoryScore;

  /**
   * Number of times the team killed Dragon. */
  public final int dragonKills;

  /**
   * Flag indicating whether or not the team scored the first Baron kill. */
  public final boolean firstBaron;

  /**
   * Flag indicating whether or not the team scored the first blood. */
  public final boolean firstBlood;

  /**
   * Flag indicating whether or not the team scored the first Dragon kill. */
  public final boolean firstDragon;

  /**
   * Flag indicating whether or not the team destroyed the first inhibitor. */
  public final boolean firstInhibitor;

  /**
   * Flag indicating whether or not the team scored the first Rift Herald kill. */
  public final boolean firstRiftHerald;

  /**
   * Flag indicating whether or not the team destroyed the first tower. */
  public final boolean firstTower;

  /**
   * Number of inhibitors the team destroyed. */
  public final int inhibitorKills;

  /**
   * Number of times the team killed Rift Herald. */
  public final int riftHeraldKills;

  /**
   * 100 for blue side. 200 for red side. */
  public final int teamId;

  /**
   * Number of towers the team destroyed. */
  public final int towerKills;

  /**
   * Number of times the team killed Vilemaw. */
  public final int vilemawKills;

  /**
   * String indicating whether or not the team won. There are only two values visibile in public match history.
   *              (Legal values:  Fail,  Win) */
  public final String win;

  public TeamStats(final List<TeamBans> bans, final int baronKills, final int dominionVictoryScore,
      final int dragonKills, final boolean firstBaron, final boolean firstBlood,
      final boolean firstDragon, final boolean firstInhibitor, final boolean firstRiftHerald,
      final boolean firstTower, final int inhibitorKills, final int riftHeraldKills,
      final int teamId, final int towerKills, final int vilemawKills, final String win) {
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
    this.win = win;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof TeamStats)) return false;
    final TeamStats other = (TeamStats) obj;
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
        && Objects.equal(win, other.win);}

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
        win);}
}
