package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ParticipantStats.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v3/GET_getMatch">Riot API reference</a> on Sun May 21 18:03:38 PDT 2017. */
public class ParticipantStats implements Serializable {
  public final long physicalDamageDealt;

  public final int neutralMinionsKilledTeamJungle;

  public final long magicDamageDealt;

  public final int totalPlayerScore;

  public final int deaths;

  public final boolean win;

  public final int neutralMinionsKilledEnemyJungle;

  public final int altarsCaptured;

  public final int largestCriticalStrike;

  public final long totalDamageDealt;

  public final long magicDamageDealtToChampions;

  public final int visionWardsBoughtInGame;

  public final long damageDealtToObjectives;

  public final int largestKillingSpree;

  public final int item1;

  public final int quadraKills;

  public final int teamObjective;

  public final int totalTimeCrowdControlDealt;

  public final int longestTimeSpentLiving;

  public final int wardsKilled;

  public final boolean firstTowerAssist;

  public final boolean firstTowerKill;

  public final int item2;

  public final int item3;

  public final int item0;

  public final boolean firstBloodAssist;

  public final long visionScore;

  public final int wardsPlaced;

  public final int item4;

  public final int item5;

  public final int item6;

  public final int turretKills;

  public final int tripleKills;

  public final long damageSelfMitigated;

  public final int champLevel;

  public final int nodeNeutralizeAssist;

  public final boolean firstInhibitorKill;

  public final int goldEarned;

  public final long magicalDamageTaken;

  public final int kills;

  public final int doubleKills;

  public final int nodeCaptureAssist;

  public final long trueDamageTaken;

  public final int nodeNeutralize;

  public final boolean firstInhibitorAssist;

  public final int assists;

  public final int unrealKills;

  public final int neutralMinionsKilled;

  public final int objectivePlayerScore;

  public final int combatPlayerScore;

  public final long damageDealtToTurrets;

  public final int altarsNeutralized;

  public final long physicalDamageDealtToChampions;

  public final int goldSpent;

  public final long trueDamageDealt;

  public final long trueDamageDealtToChampions;

  public final int participantId;

  public final int pentaKills;

  public final long totalHeal;

  public final int totalMinionsKilled;

  public final boolean firstBloodKill;

  public final int nodeCapture;

  public final int largestMultiKill;

  public final int sightWardsBoughtInGame;

  public final long totalDamageDealtToChampions;

  public final int totalUnitsHealed;

  public final int inhibitorKills;

  public final int totalScoreRank;

  public final long totalDamageTaken;

  public final int killingSprees;

  public final long timeCCingOthers;

  public final long physicalDamageTaken;

  public ParticipantStats(final long physicalDamageDealt, final int neutralMinionsKilledTeamJungle,
      final long magicDamageDealt, final int totalPlayerScore, final int deaths, final boolean win,
      final int neutralMinionsKilledEnemyJungle, final int altarsCaptured,
      final int largestCriticalStrike, final long totalDamageDealt,
      final long magicDamageDealtToChampions, final int visionWardsBoughtInGame,
      final long damageDealtToObjectives, final int largestKillingSpree, final int item1,
      final int quadraKills, final int teamObjective, final int totalTimeCrowdControlDealt,
      final int longestTimeSpentLiving, final int wardsKilled, final boolean firstTowerAssist,
      final boolean firstTowerKill, final int item2, final int item3, final int item0,
      final boolean firstBloodAssist, final long visionScore, final int wardsPlaced,
      final int item4, final int item5, final int item6, final int turretKills,
      final int tripleKills, final long damageSelfMitigated, final int champLevel,
      final int nodeNeutralizeAssist, final boolean firstInhibitorKill, final int goldEarned,
      final long magicalDamageTaken, final int kills, final int doubleKills,
      final int nodeCaptureAssist, final long trueDamageTaken, final int nodeNeutralize,
      final boolean firstInhibitorAssist, final int assists, final int unrealKills,
      final int neutralMinionsKilled, final int objectivePlayerScore, final int combatPlayerScore,
      final long damageDealtToTurrets, final int altarsNeutralized,
      final long physicalDamageDealtToChampions, final int goldSpent, final long trueDamageDealt,
      final long trueDamageDealtToChampions, final int participantId, final int pentaKills,
      final long totalHeal, final int totalMinionsKilled, final boolean firstBloodKill,
      final int nodeCapture, final int largestMultiKill, final int sightWardsBoughtInGame,
      final long totalDamageDealtToChampions, final int totalUnitsHealed, final int inhibitorKills,
      final int totalScoreRank, final long totalDamageTaken, final int killingSprees,
      final long timeCCingOthers, final long physicalDamageTaken) {
    this.physicalDamageDealt = physicalDamageDealt;
    this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
    this.magicDamageDealt = magicDamageDealt;
    this.totalPlayerScore = totalPlayerScore;
    this.deaths = deaths;
    this.win = win;
    this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    this.altarsCaptured = altarsCaptured;
    this.largestCriticalStrike = largestCriticalStrike;
    this.totalDamageDealt = totalDamageDealt;
    this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    this.damageDealtToObjectives = damageDealtToObjectives;
    this.largestKillingSpree = largestKillingSpree;
    this.item1 = item1;
    this.quadraKills = quadraKills;
    this.teamObjective = teamObjective;
    this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    this.longestTimeSpentLiving = longestTimeSpentLiving;
    this.wardsKilled = wardsKilled;
    this.firstTowerAssist = firstTowerAssist;
    this.firstTowerKill = firstTowerKill;
    this.item2 = item2;
    this.item3 = item3;
    this.item0 = item0;
    this.firstBloodAssist = firstBloodAssist;
    this.visionScore = visionScore;
    this.wardsPlaced = wardsPlaced;
    this.item4 = item4;
    this.item5 = item5;
    this.item6 = item6;
    this.turretKills = turretKills;
    this.tripleKills = tripleKills;
    this.damageSelfMitigated = damageSelfMitigated;
    this.champLevel = champLevel;
    this.nodeNeutralizeAssist = nodeNeutralizeAssist;
    this.firstInhibitorKill = firstInhibitorKill;
    this.goldEarned = goldEarned;
    this.magicalDamageTaken = magicalDamageTaken;
    this.kills = kills;
    this.doubleKills = doubleKills;
    this.nodeCaptureAssist = nodeCaptureAssist;
    this.trueDamageTaken = trueDamageTaken;
    this.nodeNeutralize = nodeNeutralize;
    this.firstInhibitorAssist = firstInhibitorAssist;
    this.assists = assists;
    this.unrealKills = unrealKills;
    this.neutralMinionsKilled = neutralMinionsKilled;
    this.objectivePlayerScore = objectivePlayerScore;
    this.combatPlayerScore = combatPlayerScore;
    this.damageDealtToTurrets = damageDealtToTurrets;
    this.altarsNeutralized = altarsNeutralized;
    this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    this.goldSpent = goldSpent;
    this.trueDamageDealt = trueDamageDealt;
    this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    this.participantId = participantId;
    this.pentaKills = pentaKills;
    this.totalHeal = totalHeal;
    this.totalMinionsKilled = totalMinionsKilled;
    this.firstBloodKill = firstBloodKill;
    this.nodeCapture = nodeCapture;
    this.largestMultiKill = largestMultiKill;
    this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    this.totalUnitsHealed = totalUnitsHealed;
    this.inhibitorKills = inhibitorKills;
    this.totalScoreRank = totalScoreRank;
    this.totalDamageTaken = totalDamageTaken;
    this.killingSprees = killingSprees;
    this.timeCCingOthers = timeCCingOthers;
    this.physicalDamageTaken = physicalDamageTaken;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ParticipantStats)) return false;
    final ParticipantStats other = (ParticipantStats) obj;
    return true
        && Objects.equal(physicalDamageDealt, other.physicalDamageDealt)
        && Objects.equal(neutralMinionsKilledTeamJungle, other.neutralMinionsKilledTeamJungle)
        && Objects.equal(magicDamageDealt, other.magicDamageDealt)
        && Objects.equal(totalPlayerScore, other.totalPlayerScore)
        && Objects.equal(deaths, other.deaths)
        && Objects.equal(win, other.win)
        && Objects.equal(neutralMinionsKilledEnemyJungle, other.neutralMinionsKilledEnemyJungle)
        && Objects.equal(altarsCaptured, other.altarsCaptured)
        && Objects.equal(largestCriticalStrike, other.largestCriticalStrike)
        && Objects.equal(totalDamageDealt, other.totalDamageDealt)
        && Objects.equal(magicDamageDealtToChampions, other.magicDamageDealtToChampions)
        && Objects.equal(visionWardsBoughtInGame, other.visionWardsBoughtInGame)
        && Objects.equal(damageDealtToObjectives, other.damageDealtToObjectives)
        && Objects.equal(largestKillingSpree, other.largestKillingSpree)
        && Objects.equal(item1, other.item1)
        && Objects.equal(quadraKills, other.quadraKills)
        && Objects.equal(teamObjective, other.teamObjective)
        && Objects.equal(totalTimeCrowdControlDealt, other.totalTimeCrowdControlDealt)
        && Objects.equal(longestTimeSpentLiving, other.longestTimeSpentLiving)
        && Objects.equal(wardsKilled, other.wardsKilled)
        && Objects.equal(firstTowerAssist, other.firstTowerAssist)
        && Objects.equal(firstTowerKill, other.firstTowerKill)
        && Objects.equal(item2, other.item2)
        && Objects.equal(item3, other.item3)
        && Objects.equal(item0, other.item0)
        && Objects.equal(firstBloodAssist, other.firstBloodAssist)
        && Objects.equal(visionScore, other.visionScore)
        && Objects.equal(wardsPlaced, other.wardsPlaced)
        && Objects.equal(item4, other.item4)
        && Objects.equal(item5, other.item5)
        && Objects.equal(item6, other.item6)
        && Objects.equal(turretKills, other.turretKills)
        && Objects.equal(tripleKills, other.tripleKills)
        && Objects.equal(damageSelfMitigated, other.damageSelfMitigated)
        && Objects.equal(champLevel, other.champLevel)
        && Objects.equal(nodeNeutralizeAssist, other.nodeNeutralizeAssist)
        && Objects.equal(firstInhibitorKill, other.firstInhibitorKill)
        && Objects.equal(goldEarned, other.goldEarned)
        && Objects.equal(magicalDamageTaken, other.magicalDamageTaken)
        && Objects.equal(kills, other.kills)
        && Objects.equal(doubleKills, other.doubleKills)
        && Objects.equal(nodeCaptureAssist, other.nodeCaptureAssist)
        && Objects.equal(trueDamageTaken, other.trueDamageTaken)
        && Objects.equal(nodeNeutralize, other.nodeNeutralize)
        && Objects.equal(firstInhibitorAssist, other.firstInhibitorAssist)
        && Objects.equal(assists, other.assists)
        && Objects.equal(unrealKills, other.unrealKills)
        && Objects.equal(neutralMinionsKilled, other.neutralMinionsKilled)
        && Objects.equal(objectivePlayerScore, other.objectivePlayerScore)
        && Objects.equal(combatPlayerScore, other.combatPlayerScore)
        && Objects.equal(damageDealtToTurrets, other.damageDealtToTurrets)
        && Objects.equal(altarsNeutralized, other.altarsNeutralized)
        && Objects.equal(physicalDamageDealtToChampions, other.physicalDamageDealtToChampions)
        && Objects.equal(goldSpent, other.goldSpent)
        && Objects.equal(trueDamageDealt, other.trueDamageDealt)
        && Objects.equal(trueDamageDealtToChampions, other.trueDamageDealtToChampions)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(pentaKills, other.pentaKills)
        && Objects.equal(totalHeal, other.totalHeal)
        && Objects.equal(totalMinionsKilled, other.totalMinionsKilled)
        && Objects.equal(firstBloodKill, other.firstBloodKill)
        && Objects.equal(nodeCapture, other.nodeCapture)
        && Objects.equal(largestMultiKill, other.largestMultiKill)
        && Objects.equal(sightWardsBoughtInGame, other.sightWardsBoughtInGame)
        && Objects.equal(totalDamageDealtToChampions, other.totalDamageDealtToChampions)
        && Objects.equal(totalUnitsHealed, other.totalUnitsHealed)
        && Objects.equal(inhibitorKills, other.inhibitorKills)
        && Objects.equal(totalScoreRank, other.totalScoreRank)
        && Objects.equal(totalDamageTaken, other.totalDamageTaken)
        && Objects.equal(killingSprees, other.killingSprees)
        && Objects.equal(timeCCingOthers, other.timeCCingOthers)
        && Objects.equal(physicalDamageTaken, other.physicalDamageTaken);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        physicalDamageDealt,
        neutralMinionsKilledTeamJungle,
        magicDamageDealt,
        totalPlayerScore,
        deaths,
        win,
        neutralMinionsKilledEnemyJungle,
        altarsCaptured,
        largestCriticalStrike,
        totalDamageDealt,
        magicDamageDealtToChampions,
        visionWardsBoughtInGame,
        damageDealtToObjectives,
        largestKillingSpree,
        item1,
        quadraKills,
        teamObjective,
        totalTimeCrowdControlDealt,
        longestTimeSpentLiving,
        wardsKilled,
        firstTowerAssist,
        firstTowerKill,
        item2,
        item3,
        item0,
        firstBloodAssist,
        visionScore,
        wardsPlaced,
        item4,
        item5,
        item6,
        turretKills,
        tripleKills,
        damageSelfMitigated,
        champLevel,
        nodeNeutralizeAssist,
        firstInhibitorKill,
        goldEarned,
        magicalDamageTaken,
        kills,
        doubleKills,
        nodeCaptureAssist,
        trueDamageTaken,
        nodeNeutralize,
        firstInhibitorAssist,
        assists,
        unrealKills,
        neutralMinionsKilled,
        objectivePlayerScore,
        combatPlayerScore,
        damageDealtToTurrets,
        altarsNeutralized,
        physicalDamageDealtToChampions,
        goldSpent,
        trueDamageDealt,
        trueDamageDealtToChampions,
        participantId,
        pentaKills,
        totalHeal,
        totalMinionsKilled,
        firstBloodKill,
        nodeCapture,
        largestMultiKill,
        sightWardsBoughtInGame,
        totalDamageDealtToChampions,
        totalUnitsHealed,
        inhibitorKills,
        totalScoreRank,
        totalDamageTaken,
        killingSprees,
        timeCCingOthers,
        physicalDamageTaken);}
}
