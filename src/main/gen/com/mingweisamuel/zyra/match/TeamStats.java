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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class TeamStats implements Serializable {
  public final List<TeamBans> bans;

  public final int baronKills;

  public final int dominionVictoryScore;

  public final int dragonKills;

  public final boolean firstBaron;

  public final boolean firstBlood;

  public final boolean firstDragon;

  public final boolean firstInhibitor;

  public final boolean firstRiftHerald;

  public final boolean firstTower;

  public final int inhibitorKills;

  public final int riftHeraldKills;

  public final int teamId;

  public final int towerKills;

  public final int vilemawKills;

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
