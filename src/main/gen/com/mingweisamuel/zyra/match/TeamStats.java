package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * TeamStats.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Riot API reference</a> on Sun May 21 18:03:38 PDT 2017. */
public class TeamStats implements Serializable {
  public final boolean firstDragon;

  public final boolean firstInhibitor;

  public final List<TeamBans> bans;

  public final int baronKills;

  public final boolean firstRiftHerald;

  public final boolean firstBaron;

  public final int riftHeraldKills;

  public final boolean firstBlood;

  public final int teamId;

  public final boolean firstTower;

  public final int vilemawKills;

  public final int inhibitorKills;

  public final int towerKills;

  public final int dominionVictoryScore;

  public final String win;

  public final int dragonKills;

  public TeamStats(final boolean firstDragon, final boolean firstInhibitor,
      final List<TeamBans> bans, final int baronKills, final boolean firstRiftHerald,
      final boolean firstBaron, final int riftHeraldKills, final boolean firstBlood,
      final int teamId, final boolean firstTower, final int vilemawKills, final int inhibitorKills,
      final int towerKills, final int dominionVictoryScore, final String win,
      final int dragonKills) {
    this.firstDragon = firstDragon;
    this.firstInhibitor = firstInhibitor;
    this.bans = bans;
    this.baronKills = baronKills;
    this.firstRiftHerald = firstRiftHerald;
    this.firstBaron = firstBaron;
    this.riftHeraldKills = riftHeraldKills;
    this.firstBlood = firstBlood;
    this.teamId = teamId;
    this.firstTower = firstTower;
    this.vilemawKills = vilemawKills;
    this.inhibitorKills = inhibitorKills;
    this.towerKills = towerKills;
    this.dominionVictoryScore = dominionVictoryScore;
    this.win = win;
    this.dragonKills = dragonKills;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof TeamStats)) return false;
    final TeamStats other = (TeamStats) obj;
    return true
        && Objects.equal(firstDragon, other.firstDragon)
        && Objects.equal(firstInhibitor, other.firstInhibitor)
        && Objects.equal(bans, other.bans)
        && Objects.equal(baronKills, other.baronKills)
        && Objects.equal(firstRiftHerald, other.firstRiftHerald)
        && Objects.equal(firstBaron, other.firstBaron)
        && Objects.equal(riftHeraldKills, other.riftHeraldKills)
        && Objects.equal(firstBlood, other.firstBlood)
        && Objects.equal(teamId, other.teamId)
        && Objects.equal(firstTower, other.firstTower)
        && Objects.equal(vilemawKills, other.vilemawKills)
        && Objects.equal(inhibitorKills, other.inhibitorKills)
        && Objects.equal(towerKills, other.towerKills)
        && Objects.equal(dominionVictoryScore, other.dominionVictoryScore)
        && Objects.equal(win, other.win)
        && Objects.equal(dragonKills, other.dragonKills);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        firstDragon,
        firstInhibitor,
        bans,
        baronKills,
        firstRiftHerald,
        firstBaron,
        riftHeraldKills,
        firstBlood,
        teamId,
        firstTower,
        vilemawKills,
        inhibitorKills,
        towerKills,
        dominionVictoryScore,
        win,
        dragonKills);}
}
