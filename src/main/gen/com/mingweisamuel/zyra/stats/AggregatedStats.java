package com.mingweisamuel.zyra.stats;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * AggregatedStats.<br /><br />
 *
 * This object contains aggregated stat information..<br /><br />
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#stats-v1.3/GET_getRankedStats">Riot API reference</a> on Tue Mar 21 14:58:35 PDT 2017. */
public class AggregatedStats implements Serializable {
  public final int totalPhysicalDamageDealt;

  /**
   * Dominion only. */
  public final int averageObjectivePlayerScore;

  public final int totalTurretsKilled;

  /**
   * Dominion only. */
  public final int averageNodeNeutralize;

  /**
   * Dominion only. */
  public final int averageChampionsKilled;

  public final int totalSessionsPlayed;

  public final int totalAssists;

  public final int totalDamageDealt;

  public final int totalQuadraKills;

  public final int killingSpree;

  /**
   * Dominion only. */
  public final int maxNodeNeutralize;

  public final int mostSpellsCast;

  public final int totalDoubleKills;

  /**
   * Dominion only. */
  public final int maxTeamObjective;

  /**
   * Dominion only. */
  public final int averageNodeNeutralizeAssist;

  /**
   * Dominion only. */
  public final int averageTeamObjective;

  /**
   * Dominion only. */
  public final int averageAssists;

  public final int maxChampionsKilled;

  /**
   * Dominion only. */
  public final int totalNodeCapture;

  /**
   * Only returned for ranked statistics. */
  public final int totalDeathsPerSession;

  public final int totalSessionsWon;

  /**
   * Dominion only. */
  public final int maxNodeNeutralizeAssist;

  public final int maxTimeSpentLiving;

  public final int totalPentaKills;

  public final int totalTripleKills;

  public final int totalNeutralMinionsKilled;

  /**
   * Dominion only. */
  public final int averageTotalPlayerScore;

  /**
   * Dominion only. */
  public final int maxTotalPlayerScore;

  public final int totalGoldEarned;

  public final int rankedPremadeGamesPlayed;

  public final int rankedSoloGamesPlayed;

  /**
   * Dominion only. */
  public final int maxNodeCaptureAssist;

  public final int maxLargestKillingSpree;

  public final int totalChampionKills;

  /**
   * Only returned for ranked statistics. */
  public final int maxNumDeaths;

  /**
   * Dominion only. */
  public final int averageNodeCaptureAssist;

  public final int totalDamageTaken;

  /**
   * Dominion only. */
  public final int totalNodeNeutralize;

  public final int totalMinionKills;

  /**
   * Dominion only. */
  public final int maxObjectivePlayerScore;

  /**
   * Dominion only. */
  public final int maxNodeCapture;

  /**
   * Dominion only. */
  public final int maxCombatPlayerScore;

  public final int totalMagicDamageDealt;

  public final int totalHeal;

  public final int normalGamesPlayed;

  public final int mostChampionKillsPerSession;

  /**
   * Dominion only. */
  public final int averageNumDeaths;

  public final int totalUnrealKills;

  /**
   * Dominion only. */
  public final int averageNodeCapture;

  /**
   * Dominion only. */
  public final int maxAssists;

  public final int maxTimePlayed;

  public final int maxLargestCriticalStrike;

  public final int botGamesPlayed;

  /**
   * Dominion only. */
  public final int averageCombatPlayerScore;

  public final int totalSessionsLost;

  public final int totalFirstBlood;

  public AggregatedStats(final int totalPhysicalDamageDealt, final int averageObjectivePlayerScore,
      final int totalTurretsKilled, final int averageNodeNeutralize,
      final int averageChampionsKilled, final int totalSessionsPlayed, final int totalAssists,
      final int totalDamageDealt, final int totalQuadraKills, final int killingSpree,
      final int maxNodeNeutralize, final int mostSpellsCast, final int totalDoubleKills,
      final int maxTeamObjective, final int averageNodeNeutralizeAssist,
      final int averageTeamObjective, final int averageAssists, final int maxChampionsKilled,
      final int totalNodeCapture, final int totalDeathsPerSession, final int totalSessionsWon,
      final int maxNodeNeutralizeAssist, final int maxTimeSpentLiving, final int totalPentaKills,
      final int totalTripleKills, final int totalNeutralMinionsKilled,
      final int averageTotalPlayerScore, final int maxTotalPlayerScore, final int totalGoldEarned,
      final int rankedPremadeGamesPlayed, final int rankedSoloGamesPlayed,
      final int maxNodeCaptureAssist, final int maxLargestKillingSpree,
      final int totalChampionKills, final int maxNumDeaths, final int averageNodeCaptureAssist,
      final int totalDamageTaken, final int totalNodeNeutralize, final int totalMinionKills,
      final int maxObjectivePlayerScore, final int maxNodeCapture, final int maxCombatPlayerScore,
      final int totalMagicDamageDealt, final int totalHeal, final int normalGamesPlayed,
      final int mostChampionKillsPerSession, final int averageNumDeaths, final int totalUnrealKills,
      final int averageNodeCapture, final int maxAssists, final int maxTimePlayed,
      final int maxLargestCriticalStrike, final int botGamesPlayed,
      final int averageCombatPlayerScore, final int totalSessionsLost, final int totalFirstBlood) {
    this.totalPhysicalDamageDealt = totalPhysicalDamageDealt;
    this.averageObjectivePlayerScore = averageObjectivePlayerScore;
    this.totalTurretsKilled = totalTurretsKilled;
    this.averageNodeNeutralize = averageNodeNeutralize;
    this.averageChampionsKilled = averageChampionsKilled;
    this.totalSessionsPlayed = totalSessionsPlayed;
    this.totalAssists = totalAssists;
    this.totalDamageDealt = totalDamageDealt;
    this.totalQuadraKills = totalQuadraKills;
    this.killingSpree = killingSpree;
    this.maxNodeNeutralize = maxNodeNeutralize;
    this.mostSpellsCast = mostSpellsCast;
    this.totalDoubleKills = totalDoubleKills;
    this.maxTeamObjective = maxTeamObjective;
    this.averageNodeNeutralizeAssist = averageNodeNeutralizeAssist;
    this.averageTeamObjective = averageTeamObjective;
    this.averageAssists = averageAssists;
    this.maxChampionsKilled = maxChampionsKilled;
    this.totalNodeCapture = totalNodeCapture;
    this.totalDeathsPerSession = totalDeathsPerSession;
    this.totalSessionsWon = totalSessionsWon;
    this.maxNodeNeutralizeAssist = maxNodeNeutralizeAssist;
    this.maxTimeSpentLiving = maxTimeSpentLiving;
    this.totalPentaKills = totalPentaKills;
    this.totalTripleKills = totalTripleKills;
    this.totalNeutralMinionsKilled = totalNeutralMinionsKilled;
    this.averageTotalPlayerScore = averageTotalPlayerScore;
    this.maxTotalPlayerScore = maxTotalPlayerScore;
    this.totalGoldEarned = totalGoldEarned;
    this.rankedPremadeGamesPlayed = rankedPremadeGamesPlayed;
    this.rankedSoloGamesPlayed = rankedSoloGamesPlayed;
    this.maxNodeCaptureAssist = maxNodeCaptureAssist;
    this.maxLargestKillingSpree = maxLargestKillingSpree;
    this.totalChampionKills = totalChampionKills;
    this.maxNumDeaths = maxNumDeaths;
    this.averageNodeCaptureAssist = averageNodeCaptureAssist;
    this.totalDamageTaken = totalDamageTaken;
    this.totalNodeNeutralize = totalNodeNeutralize;
    this.totalMinionKills = totalMinionKills;
    this.maxObjectivePlayerScore = maxObjectivePlayerScore;
    this.maxNodeCapture = maxNodeCapture;
    this.maxCombatPlayerScore = maxCombatPlayerScore;
    this.totalMagicDamageDealt = totalMagicDamageDealt;
    this.totalHeal = totalHeal;
    this.normalGamesPlayed = normalGamesPlayed;
    this.mostChampionKillsPerSession = mostChampionKillsPerSession;
    this.averageNumDeaths = averageNumDeaths;
    this.totalUnrealKills = totalUnrealKills;
    this.averageNodeCapture = averageNodeCapture;
    this.maxAssists = maxAssists;
    this.maxTimePlayed = maxTimePlayed;
    this.maxLargestCriticalStrike = maxLargestCriticalStrike;
    this.botGamesPlayed = botGamesPlayed;
    this.averageCombatPlayerScore = averageCombatPlayerScore;
    this.totalSessionsLost = totalSessionsLost;
    this.totalFirstBlood = totalFirstBlood;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof AggregatedStats)) return false;
    final AggregatedStats other = (AggregatedStats) obj;
    return true
        && Objects.equal(totalPhysicalDamageDealt, other.totalPhysicalDamageDealt)
        && Objects.equal(averageObjectivePlayerScore, other.averageObjectivePlayerScore)
        && Objects.equal(totalTurretsKilled, other.totalTurretsKilled)
        && Objects.equal(averageNodeNeutralize, other.averageNodeNeutralize)
        && Objects.equal(averageChampionsKilled, other.averageChampionsKilled)
        && Objects.equal(totalSessionsPlayed, other.totalSessionsPlayed)
        && Objects.equal(totalAssists, other.totalAssists)
        && Objects.equal(totalDamageDealt, other.totalDamageDealt)
        && Objects.equal(totalQuadraKills, other.totalQuadraKills)
        && Objects.equal(killingSpree, other.killingSpree)
        && Objects.equal(maxNodeNeutralize, other.maxNodeNeutralize)
        && Objects.equal(mostSpellsCast, other.mostSpellsCast)
        && Objects.equal(totalDoubleKills, other.totalDoubleKills)
        && Objects.equal(maxTeamObjective, other.maxTeamObjective)
        && Objects.equal(averageNodeNeutralizeAssist, other.averageNodeNeutralizeAssist)
        && Objects.equal(averageTeamObjective, other.averageTeamObjective)
        && Objects.equal(averageAssists, other.averageAssists)
        && Objects.equal(maxChampionsKilled, other.maxChampionsKilled)
        && Objects.equal(totalNodeCapture, other.totalNodeCapture)
        && Objects.equal(totalDeathsPerSession, other.totalDeathsPerSession)
        && Objects.equal(totalSessionsWon, other.totalSessionsWon)
        && Objects.equal(maxNodeNeutralizeAssist, other.maxNodeNeutralizeAssist)
        && Objects.equal(maxTimeSpentLiving, other.maxTimeSpentLiving)
        && Objects.equal(totalPentaKills, other.totalPentaKills)
        && Objects.equal(totalTripleKills, other.totalTripleKills)
        && Objects.equal(totalNeutralMinionsKilled, other.totalNeutralMinionsKilled)
        && Objects.equal(averageTotalPlayerScore, other.averageTotalPlayerScore)
        && Objects.equal(maxTotalPlayerScore, other.maxTotalPlayerScore)
        && Objects.equal(totalGoldEarned, other.totalGoldEarned)
        && Objects.equal(rankedPremadeGamesPlayed, other.rankedPremadeGamesPlayed)
        && Objects.equal(rankedSoloGamesPlayed, other.rankedSoloGamesPlayed)
        && Objects.equal(maxNodeCaptureAssist, other.maxNodeCaptureAssist)
        && Objects.equal(maxLargestKillingSpree, other.maxLargestKillingSpree)
        && Objects.equal(totalChampionKills, other.totalChampionKills)
        && Objects.equal(maxNumDeaths, other.maxNumDeaths)
        && Objects.equal(averageNodeCaptureAssist, other.averageNodeCaptureAssist)
        && Objects.equal(totalDamageTaken, other.totalDamageTaken)
        && Objects.equal(totalNodeNeutralize, other.totalNodeNeutralize)
        && Objects.equal(totalMinionKills, other.totalMinionKills)
        && Objects.equal(maxObjectivePlayerScore, other.maxObjectivePlayerScore)
        && Objects.equal(maxNodeCapture, other.maxNodeCapture)
        && Objects.equal(maxCombatPlayerScore, other.maxCombatPlayerScore)
        && Objects.equal(totalMagicDamageDealt, other.totalMagicDamageDealt)
        && Objects.equal(totalHeal, other.totalHeal)
        && Objects.equal(normalGamesPlayed, other.normalGamesPlayed)
        && Objects.equal(mostChampionKillsPerSession, other.mostChampionKillsPerSession)
        && Objects.equal(averageNumDeaths, other.averageNumDeaths)
        && Objects.equal(totalUnrealKills, other.totalUnrealKills)
        && Objects.equal(averageNodeCapture, other.averageNodeCapture)
        && Objects.equal(maxAssists, other.maxAssists)
        && Objects.equal(maxTimePlayed, other.maxTimePlayed)
        && Objects.equal(maxLargestCriticalStrike, other.maxLargestCriticalStrike)
        && Objects.equal(botGamesPlayed, other.botGamesPlayed)
        && Objects.equal(averageCombatPlayerScore, other.averageCombatPlayerScore)
        && Objects.equal(totalSessionsLost, other.totalSessionsLost)
        && Objects.equal(totalFirstBlood, other.totalFirstBlood);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        totalPhysicalDamageDealt,
        averageObjectivePlayerScore,
        totalTurretsKilled,
        averageNodeNeutralize,
        averageChampionsKilled,
        totalSessionsPlayed,
        totalAssists,
        totalDamageDealt,
        totalQuadraKills,
        killingSpree,
        maxNodeNeutralize,
        mostSpellsCast,
        totalDoubleKills,
        maxTeamObjective,
        averageNodeNeutralizeAssist,
        averageTeamObjective,
        averageAssists,
        maxChampionsKilled,
        totalNodeCapture,
        totalDeathsPerSession,
        totalSessionsWon,
        maxNodeNeutralizeAssist,
        maxTimeSpentLiving,
        totalPentaKills,
        totalTripleKills,
        totalNeutralMinionsKilled,
        averageTotalPlayerScore,
        maxTotalPlayerScore,
        totalGoldEarned,
        rankedPremadeGamesPlayed,
        rankedSoloGamesPlayed,
        maxNodeCaptureAssist,
        maxLargestKillingSpree,
        totalChampionKills,
        maxNumDeaths,
        averageNodeCaptureAssist,
        totalDamageTaken,
        totalNodeNeutralize,
        totalMinionKills,
        maxObjectivePlayerScore,
        maxNodeCapture,
        maxCombatPlayerScore,
        totalMagicDamageDealt,
        totalHeal,
        normalGamesPlayed,
        mostChampionKillsPerSession,
        averageNumDeaths,
        totalUnrealKills,
        averageNodeCapture,
        maxAssists,
        maxTimePlayed,
        maxLargestCriticalStrike,
        botGamesPlayed,
        averageCombatPlayerScore,
        totalSessionsLost,
        totalFirstBlood);}
}
