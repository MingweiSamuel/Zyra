package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ParticipantStats.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ParticipantStats implements Serializable {
  public final int altarsCaptured;

  public final int altarsNeutralized;

  public final int assists;

  public final int champLevel;

  public final int combatPlayerScore;

  public final long damageDealtToObjectives;

  public final long damageDealtToTurrets;

  public final long damageSelfMitigated;

  public final int deaths;

  public final int doubleKills;

  public final boolean firstBloodAssist;

  public final boolean firstBloodKill;

  public final boolean firstInhibitorAssist;

  public final boolean firstInhibitorKill;

  public final boolean firstTowerAssist;

  public final boolean firstTowerKill;

  public final int goldEarned;

  public final int goldSpent;

  public final int inhibitorKills;

  public final int item0;

  public final int item1;

  public final int item2;

  public final int item3;

  public final int item4;

  public final int item5;

  public final int item6;

  public final int killingSprees;

  public final int kills;

  public final int largestCriticalStrike;

  public final int largestKillingSpree;

  public final int largestMultiKill;

  public final int longestTimeSpentLiving;

  public final long magicDamageDealt;

  public final long magicDamageDealtToChampions;

  public final long magicalDamageTaken;

  public final int neutralMinionsKilled;

  public final int neutralMinionsKilledEnemyJungle;

  public final int neutralMinionsKilledTeamJungle;

  public final int nodeCapture;

  public final int nodeCaptureAssist;

  public final int nodeNeutralize;

  public final int nodeNeutralizeAssist;

  public final int objectivePlayerScore;

  public final int participantId;

  public final int pentaKills;

  public final long physicalDamageDealt;

  public final long physicalDamageDealtToChampions;

  public final long physicalDamageTaken;

  public final int quadraKills;

  public final int sightWardsBoughtInGame;

  public final int teamObjective;

  public final long timeCCingOthers;

  public final long totalDamageDealt;

  public final long totalDamageDealtToChampions;

  public final long totalDamageTaken;

  public final long totalHeal;

  public final int totalMinionsKilled;

  public final int totalPlayerScore;

  public final int totalScoreRank;

  public final int totalTimeCrowdControlDealt;

  public final int totalUnitsHealed;

  public final int tripleKills;

  public final long trueDamageDealt;

  public final long trueDamageDealtToChampions;

  public final long trueDamageTaken;

  public final int turretKills;

  public final int unrealKills;

  public final long visionScore;

  public final int visionWardsBoughtInGame;

  public final int wardsKilled;

  public final int wardsPlaced;

  public final boolean win;

  public ParticipantStats(final int altarsCaptured, final int altarsNeutralized, final int assists,
      final int champLevel, final int combatPlayerScore, final long damageDealtToObjectives,
      final long damageDealtToTurrets, final long damageSelfMitigated, final int deaths,
      final int doubleKills, final boolean firstBloodAssist, final boolean firstBloodKill,
      final boolean firstInhibitorAssist, final boolean firstInhibitorKill,
      final boolean firstTowerAssist, final boolean firstTowerKill, final int goldEarned,
      final int goldSpent, final int inhibitorKills, final int item0, final int item1,
      final int item2, final int item3, final int item4, final int item5, final int item6,
      final int killingSprees, final int kills, final int largestCriticalStrike,
      final int largestKillingSpree, final int largestMultiKill, final int longestTimeSpentLiving,
      final long magicDamageDealt, final long magicDamageDealtToChampions,
      final long magicalDamageTaken, final int neutralMinionsKilled,
      final int neutralMinionsKilledEnemyJungle, final int neutralMinionsKilledTeamJungle,
      final int nodeCapture, final int nodeCaptureAssist, final int nodeNeutralize,
      final int nodeNeutralizeAssist, final int objectivePlayerScore, final int participantId,
      final int pentaKills, final long physicalDamageDealt,
      final long physicalDamageDealtToChampions, final long physicalDamageTaken,
      final int quadraKills, final int sightWardsBoughtInGame, final int teamObjective,
      final long timeCCingOthers, final long totalDamageDealt,
      final long totalDamageDealtToChampions, final long totalDamageTaken, final long totalHeal,
      final int totalMinionsKilled, final int totalPlayerScore, final int totalScoreRank,
      final int totalTimeCrowdControlDealt, final int totalUnitsHealed, final int tripleKills,
      final long trueDamageDealt, final long trueDamageDealtToChampions, final long trueDamageTaken,
      final int turretKills, final int unrealKills, final long visionScore,
      final int visionWardsBoughtInGame, final int wardsKilled, final int wardsPlaced,
      final boolean win) {
    this.altarsCaptured = altarsCaptured;
    this.altarsNeutralized = altarsNeutralized;
    this.assists = assists;
    this.champLevel = champLevel;
    this.combatPlayerScore = combatPlayerScore;
    this.damageDealtToObjectives = damageDealtToObjectives;
    this.damageDealtToTurrets = damageDealtToTurrets;
    this.damageSelfMitigated = damageSelfMitigated;
    this.deaths = deaths;
    this.doubleKills = doubleKills;
    this.firstBloodAssist = firstBloodAssist;
    this.firstBloodKill = firstBloodKill;
    this.firstInhibitorAssist = firstInhibitorAssist;
    this.firstInhibitorKill = firstInhibitorKill;
    this.firstTowerAssist = firstTowerAssist;
    this.firstTowerKill = firstTowerKill;
    this.goldEarned = goldEarned;
    this.goldSpent = goldSpent;
    this.inhibitorKills = inhibitorKills;
    this.item0 = item0;
    this.item1 = item1;
    this.item2 = item2;
    this.item3 = item3;
    this.item4 = item4;
    this.item5 = item5;
    this.item6 = item6;
    this.killingSprees = killingSprees;
    this.kills = kills;
    this.largestCriticalStrike = largestCriticalStrike;
    this.largestKillingSpree = largestKillingSpree;
    this.largestMultiKill = largestMultiKill;
    this.longestTimeSpentLiving = longestTimeSpentLiving;
    this.magicDamageDealt = magicDamageDealt;
    this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    this.magicalDamageTaken = magicalDamageTaken;
    this.neutralMinionsKilled = neutralMinionsKilled;
    this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
    this.nodeCapture = nodeCapture;
    this.nodeCaptureAssist = nodeCaptureAssist;
    this.nodeNeutralize = nodeNeutralize;
    this.nodeNeutralizeAssist = nodeNeutralizeAssist;
    this.objectivePlayerScore = objectivePlayerScore;
    this.participantId = participantId;
    this.pentaKills = pentaKills;
    this.physicalDamageDealt = physicalDamageDealt;
    this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    this.physicalDamageTaken = physicalDamageTaken;
    this.quadraKills = quadraKills;
    this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    this.teamObjective = teamObjective;
    this.timeCCingOthers = timeCCingOthers;
    this.totalDamageDealt = totalDamageDealt;
    this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    this.totalDamageTaken = totalDamageTaken;
    this.totalHeal = totalHeal;
    this.totalMinionsKilled = totalMinionsKilled;
    this.totalPlayerScore = totalPlayerScore;
    this.totalScoreRank = totalScoreRank;
    this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    this.totalUnitsHealed = totalUnitsHealed;
    this.tripleKills = tripleKills;
    this.trueDamageDealt = trueDamageDealt;
    this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    this.trueDamageTaken = trueDamageTaken;
    this.turretKills = turretKills;
    this.unrealKills = unrealKills;
    this.visionScore = visionScore;
    this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    this.wardsKilled = wardsKilled;
    this.wardsPlaced = wardsPlaced;
    this.win = win;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ParticipantStats)) return false;
    final ParticipantStats other = (ParticipantStats) obj;
    return true
        && Objects.equal(altarsCaptured, other.altarsCaptured)
        && Objects.equal(altarsNeutralized, other.altarsNeutralized)
        && Objects.equal(assists, other.assists)
        && Objects.equal(champLevel, other.champLevel)
        && Objects.equal(combatPlayerScore, other.combatPlayerScore)
        && Objects.equal(damageDealtToObjectives, other.damageDealtToObjectives)
        && Objects.equal(damageDealtToTurrets, other.damageDealtToTurrets)
        && Objects.equal(damageSelfMitigated, other.damageSelfMitigated)
        && Objects.equal(deaths, other.deaths)
        && Objects.equal(doubleKills, other.doubleKills)
        && Objects.equal(firstBloodAssist, other.firstBloodAssist)
        && Objects.equal(firstBloodKill, other.firstBloodKill)
        && Objects.equal(firstInhibitorAssist, other.firstInhibitorAssist)
        && Objects.equal(firstInhibitorKill, other.firstInhibitorKill)
        && Objects.equal(firstTowerAssist, other.firstTowerAssist)
        && Objects.equal(firstTowerKill, other.firstTowerKill)
        && Objects.equal(goldEarned, other.goldEarned)
        && Objects.equal(goldSpent, other.goldSpent)
        && Objects.equal(inhibitorKills, other.inhibitorKills)
        && Objects.equal(item0, other.item0)
        && Objects.equal(item1, other.item1)
        && Objects.equal(item2, other.item2)
        && Objects.equal(item3, other.item3)
        && Objects.equal(item4, other.item4)
        && Objects.equal(item5, other.item5)
        && Objects.equal(item6, other.item6)
        && Objects.equal(killingSprees, other.killingSprees)
        && Objects.equal(kills, other.kills)
        && Objects.equal(largestCriticalStrike, other.largestCriticalStrike)
        && Objects.equal(largestKillingSpree, other.largestKillingSpree)
        && Objects.equal(largestMultiKill, other.largestMultiKill)
        && Objects.equal(longestTimeSpentLiving, other.longestTimeSpentLiving)
        && Objects.equal(magicDamageDealt, other.magicDamageDealt)
        && Objects.equal(magicDamageDealtToChampions, other.magicDamageDealtToChampions)
        && Objects.equal(magicalDamageTaken, other.magicalDamageTaken)
        && Objects.equal(neutralMinionsKilled, other.neutralMinionsKilled)
        && Objects.equal(neutralMinionsKilledEnemyJungle, other.neutralMinionsKilledEnemyJungle)
        && Objects.equal(neutralMinionsKilledTeamJungle, other.neutralMinionsKilledTeamJungle)
        && Objects.equal(nodeCapture, other.nodeCapture)
        && Objects.equal(nodeCaptureAssist, other.nodeCaptureAssist)
        && Objects.equal(nodeNeutralize, other.nodeNeutralize)
        && Objects.equal(nodeNeutralizeAssist, other.nodeNeutralizeAssist)
        && Objects.equal(objectivePlayerScore, other.objectivePlayerScore)
        && Objects.equal(participantId, other.participantId)
        && Objects.equal(pentaKills, other.pentaKills)
        && Objects.equal(physicalDamageDealt, other.physicalDamageDealt)
        && Objects.equal(physicalDamageDealtToChampions, other.physicalDamageDealtToChampions)
        && Objects.equal(physicalDamageTaken, other.physicalDamageTaken)
        && Objects.equal(quadraKills, other.quadraKills)
        && Objects.equal(sightWardsBoughtInGame, other.sightWardsBoughtInGame)
        && Objects.equal(teamObjective, other.teamObjective)
        && Objects.equal(timeCCingOthers, other.timeCCingOthers)
        && Objects.equal(totalDamageDealt, other.totalDamageDealt)
        && Objects.equal(totalDamageDealtToChampions, other.totalDamageDealtToChampions)
        && Objects.equal(totalDamageTaken, other.totalDamageTaken)
        && Objects.equal(totalHeal, other.totalHeal)
        && Objects.equal(totalMinionsKilled, other.totalMinionsKilled)
        && Objects.equal(totalPlayerScore, other.totalPlayerScore)
        && Objects.equal(totalScoreRank, other.totalScoreRank)
        && Objects.equal(totalTimeCrowdControlDealt, other.totalTimeCrowdControlDealt)
        && Objects.equal(totalUnitsHealed, other.totalUnitsHealed)
        && Objects.equal(tripleKills, other.tripleKills)
        && Objects.equal(trueDamageDealt, other.trueDamageDealt)
        && Objects.equal(trueDamageDealtToChampions, other.trueDamageDealtToChampions)
        && Objects.equal(trueDamageTaken, other.trueDamageTaken)
        && Objects.equal(turretKills, other.turretKills)
        && Objects.equal(unrealKills, other.unrealKills)
        && Objects.equal(visionScore, other.visionScore)
        && Objects.equal(visionWardsBoughtInGame, other.visionWardsBoughtInGame)
        && Objects.equal(wardsKilled, other.wardsKilled)
        && Objects.equal(wardsPlaced, other.wardsPlaced)
        && Objects.equal(win, other.win);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        altarsCaptured,
        altarsNeutralized,
        assists,
        champLevel,
        combatPlayerScore,
        damageDealtToObjectives,
        damageDealtToTurrets,
        damageSelfMitigated,
        deaths,
        doubleKills,
        firstBloodAssist,
        firstBloodKill,
        firstInhibitorAssist,
        firstInhibitorKill,
        firstTowerAssist,
        firstTowerKill,
        goldEarned,
        goldSpent,
        inhibitorKills,
        item0,
        item1,
        item2,
        item3,
        item4,
        item5,
        item6,
        killingSprees,
        kills,
        largestCriticalStrike,
        largestKillingSpree,
        largestMultiKill,
        longestTimeSpentLiving,
        magicDamageDealt,
        magicDamageDealtToChampions,
        magicalDamageTaken,
        neutralMinionsKilled,
        neutralMinionsKilledEnemyJungle,
        neutralMinionsKilledTeamJungle,
        nodeCapture,
        nodeCaptureAssist,
        nodeNeutralize,
        nodeNeutralizeAssist,
        objectivePlayerScore,
        participantId,
        pentaKills,
        physicalDamageDealt,
        physicalDamageDealtToChampions,
        physicalDamageTaken,
        quadraKills,
        sightWardsBoughtInGame,
        teamObjective,
        timeCCingOthers,
        totalDamageDealt,
        totalDamageDealtToChampions,
        totalDamageTaken,
        totalHeal,
        totalMinionsKilled,
        totalPlayerScore,
        totalScoreRank,
        totalTimeCrowdControlDealt,
        totalUnitsHealed,
        tripleKills,
        trueDamageDealt,
        trueDamageDealtToChampions,
        trueDamageTaken,
        turretKills,
        unrealKills,
        visionScore,
        visionWardsBoughtInGame,
        wardsKilled,
        wardsPlaced,
        win);}
}
