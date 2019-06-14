package com.mingweisamuel.zyra.matchV4;

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

  /**
   * Primary path keystone rune. */
  public final int perk0;

  /**
   * Post game rune stats. */
  public final int perk0Var1;

  /**
   * Post game rune stats. */
  public final int perk0Var2;

  /**
   * Post game rune stats. */
  public final int perk0Var3;

  /**
   * Primary path rune. */
  public final int perk1;

  /**
   * Post game rune stats. */
  public final int perk1Var1;

  /**
   * Post game rune stats. */
  public final int perk1Var2;

  /**
   * Post game rune stats. */
  public final int perk1Var3;

  /**
   * Primary path rune. */
  public final int perk2;

  /**
   * Post game rune stats. */
  public final int perk2Var1;

  /**
   * Post game rune stats. */
  public final int perk2Var2;

  /**
   * Post game rune stats. */
  public final int perk2Var3;

  /**
   * Primary path rune. */
  public final int perk3;

  /**
   * Post game rune stats. */
  public final int perk3Var1;

  /**
   * Post game rune stats. */
  public final int perk3Var2;

  /**
   * Post game rune stats. */
  public final int perk3Var3;

  /**
   * Secondary path rune. */
  public final int perk4;

  /**
   * Post game rune stats. */
  public final int perk4Var1;

  /**
   * Post game rune stats. */
  public final int perk4Var2;

  /**
   * Post game rune stats. */
  public final int perk4Var3;

  /**
   * Secondary path rune. */
  public final int perk5;

  /**
   * Post game rune stats. */
  public final int perk5Var1;

  /**
   * Post game rune stats. */
  public final int perk5Var2;

  /**
   * Post game rune stats. */
  public final int perk5Var3;

  /**
   * Primary rune path */
  public final int perkPrimaryStyle;

  /**
   * Secondary rune path */
  public final int perkSubStyle;

  public final long physicalDamageDealt;

  public final long physicalDamageDealtToChampions;

  public final long physicalDamageTaken;

  public final int playerScore0;

  public final int playerScore1;

  public final int playerScore2;

  public final int playerScore3;

  public final int playerScore4;

  public final int playerScore5;

  public final int playerScore6;

  public final int playerScore7;

  public final int playerScore8;

  public final int playerScore9;

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
      final int pentaKills, final int perk0, final int perk0Var1, final int perk0Var2,
      final int perk0Var3, final int perk1, final int perk1Var1, final int perk1Var2,
      final int perk1Var3, final int perk2, final int perk2Var1, final int perk2Var2,
      final int perk2Var3, final int perk3, final int perk3Var1, final int perk3Var2,
      final int perk3Var3, final int perk4, final int perk4Var1, final int perk4Var2,
      final int perk4Var3, final int perk5, final int perk5Var1, final int perk5Var2,
      final int perk5Var3, final int perkPrimaryStyle, final int perkSubStyle,
      final long physicalDamageDealt, final long physicalDamageDealtToChampions,
      final long physicalDamageTaken, final int playerScore0, final int playerScore1,
      final int playerScore2, final int playerScore3, final int playerScore4,
      final int playerScore5, final int playerScore6, final int playerScore7,
      final int playerScore8, final int playerScore9, final int quadraKills,
      final int sightWardsBoughtInGame, final int teamObjective, final long timeCCingOthers,
      final long totalDamageDealt, final long totalDamageDealtToChampions,
      final long totalDamageTaken, final long totalHeal, final int totalMinionsKilled,
      final int totalPlayerScore, final int totalScoreRank, final int totalTimeCrowdControlDealt,
      final int totalUnitsHealed, final int tripleKills, final long trueDamageDealt,
      final long trueDamageDealtToChampions, final long trueDamageTaken, final int turretKills,
      final int unrealKills, final long visionScore, final int visionWardsBoughtInGame,
      final int wardsKilled, final int wardsPlaced, final boolean win) {
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
    this.perk0 = perk0;
    this.perk0Var1 = perk0Var1;
    this.perk0Var2 = perk0Var2;
    this.perk0Var3 = perk0Var3;
    this.perk1 = perk1;
    this.perk1Var1 = perk1Var1;
    this.perk1Var2 = perk1Var2;
    this.perk1Var3 = perk1Var3;
    this.perk2 = perk2;
    this.perk2Var1 = perk2Var1;
    this.perk2Var2 = perk2Var2;
    this.perk2Var3 = perk2Var3;
    this.perk3 = perk3;
    this.perk3Var1 = perk3Var1;
    this.perk3Var2 = perk3Var2;
    this.perk3Var3 = perk3Var3;
    this.perk4 = perk4;
    this.perk4Var1 = perk4Var1;
    this.perk4Var2 = perk4Var2;
    this.perk4Var3 = perk4Var3;
    this.perk5 = perk5;
    this.perk5Var1 = perk5Var1;
    this.perk5Var2 = perk5Var2;
    this.perk5Var3 = perk5Var3;
    this.perkPrimaryStyle = perkPrimaryStyle;
    this.perkSubStyle = perkSubStyle;
    this.physicalDamageDealt = physicalDamageDealt;
    this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    this.physicalDamageTaken = physicalDamageTaken;
    this.playerScore0 = playerScore0;
    this.playerScore1 = playerScore1;
    this.playerScore2 = playerScore2;
    this.playerScore3 = playerScore3;
    this.playerScore4 = playerScore4;
    this.playerScore5 = playerScore5;
    this.playerScore6 = playerScore6;
    this.playerScore7 = playerScore7;
    this.playerScore8 = playerScore8;
    this.playerScore9 = playerScore9;
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
        && Objects.equal(perk0, other.perk0)
        && Objects.equal(perk0Var1, other.perk0Var1)
        && Objects.equal(perk0Var2, other.perk0Var2)
        && Objects.equal(perk0Var3, other.perk0Var3)
        && Objects.equal(perk1, other.perk1)
        && Objects.equal(perk1Var1, other.perk1Var1)
        && Objects.equal(perk1Var2, other.perk1Var2)
        && Objects.equal(perk1Var3, other.perk1Var3)
        && Objects.equal(perk2, other.perk2)
        && Objects.equal(perk2Var1, other.perk2Var1)
        && Objects.equal(perk2Var2, other.perk2Var2)
        && Objects.equal(perk2Var3, other.perk2Var3)
        && Objects.equal(perk3, other.perk3)
        && Objects.equal(perk3Var1, other.perk3Var1)
        && Objects.equal(perk3Var2, other.perk3Var2)
        && Objects.equal(perk3Var3, other.perk3Var3)
        && Objects.equal(perk4, other.perk4)
        && Objects.equal(perk4Var1, other.perk4Var1)
        && Objects.equal(perk4Var2, other.perk4Var2)
        && Objects.equal(perk4Var3, other.perk4Var3)
        && Objects.equal(perk5, other.perk5)
        && Objects.equal(perk5Var1, other.perk5Var1)
        && Objects.equal(perk5Var2, other.perk5Var2)
        && Objects.equal(perk5Var3, other.perk5Var3)
        && Objects.equal(perkPrimaryStyle, other.perkPrimaryStyle)
        && Objects.equal(perkSubStyle, other.perkSubStyle)
        && Objects.equal(physicalDamageDealt, other.physicalDamageDealt)
        && Objects.equal(physicalDamageDealtToChampions, other.physicalDamageDealtToChampions)
        && Objects.equal(physicalDamageTaken, other.physicalDamageTaken)
        && Objects.equal(playerScore0, other.playerScore0)
        && Objects.equal(playerScore1, other.playerScore1)
        && Objects.equal(playerScore2, other.playerScore2)
        && Objects.equal(playerScore3, other.playerScore3)
        && Objects.equal(playerScore4, other.playerScore4)
        && Objects.equal(playerScore5, other.playerScore5)
        && Objects.equal(playerScore6, other.playerScore6)
        && Objects.equal(playerScore7, other.playerScore7)
        && Objects.equal(playerScore8, other.playerScore8)
        && Objects.equal(playerScore9, other.playerScore9)
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
        perk0,
        perk0Var1,
        perk0Var2,
        perk0Var3,
        perk1,
        perk1Var1,
        perk1Var2,
        perk1Var3,
        perk2,
        perk2Var1,
        perk2Var2,
        perk2Var3,
        perk3,
        perk3Var1,
        perk3Var2,
        perk3Var3,
        perk4,
        perk4Var1,
        perk4Var2,
        perk4Var3,
        perk5,
        perk5Var1,
        perk5Var2,
        perk5Var3,
        perkPrimaryStyle,
        perkSubStyle,
        physicalDamageDealt,
        physicalDamageDealtToChampions,
        physicalDamageTaken,
        playerScore0,
        playerScore1,
        playerScore2,
        playerScore3,
        playerScore4,
        playerScore5,
        playerScore6,
        playerScore7,
        playerScore8,
        playerScore9,
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
