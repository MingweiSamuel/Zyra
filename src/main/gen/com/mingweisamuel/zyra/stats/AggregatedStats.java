package com.mingweisamuel.zyra.stats;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * AggregatedStats - This object contains aggregated stat information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version stats-v1.3 */
public class AggregatedStats implements Serializable {
  /**
   * Dominion only. */
  public final int averageAssists;

  /**
   * Dominion only. */
  public final int averageChampionsKilled;

  /**
   * Dominion only. */
  public final int averageCombatPlayerScore;

  /**
   * Dominion only. */
  public final int averageNodeCapture;

  /**
   * Dominion only. */
  public final int averageNodeCaptureAssist;

  /**
   * Dominion only. */
  public final int averageNodeNeutralize;

  /**
   * Dominion only. */
  public final int averageNodeNeutralizeAssist;

  /**
   * Dominion only. */
  public final int averageNumDeaths;

  /**
   * Dominion only. */
  public final int averageObjectivePlayerScore;

  /**
   * Dominion only. */
  public final int averageTeamObjective;

  /**
   * Dominion only. */
  public final int averageTotalPlayerScore;

  public final int botGamesPlayed;

  public final int killingSpree;

  /**
   * Dominion only. */
  public final int maxAssists;

  public final int maxChampionsKilled;

  /**
   * Dominion only. */
  public final int maxCombatPlayerScore;

  public final int maxLargestCriticalStrike;

  public final int maxLargestKillingSpree;

  /**
   * Dominion only. */
  public final int maxNodeCapture;

  /**
   * Dominion only. */
  public final int maxNodeCaptureAssist;

  /**
   * Dominion only. */
  public final int maxNodeNeutralize;

  /**
   * Dominion only. */
  public final int maxNodeNeutralizeAssist;

  /**
   * Only returned for ranked statistics. */
  public final int maxNumDeaths;

  /**
   * Dominion only. */
  public final int maxObjectivePlayerScore;

  /**
   * Dominion only. */
  public final int maxTeamObjective;

  public final int maxTimePlayed;

  public final int maxTimeSpentLiving;

  /**
   * Dominion only. */
  public final int maxTotalPlayerScore;

  public final int mostChampionKillsPerSession;

  public final int mostSpellsCast;

  public final int normalGamesPlayed;

  public final int rankedPremadeGamesPlayed;

  public final int rankedSoloGamesPlayed;

  public final int totalAssists;

  public final int totalChampionKills;

  public final int totalDamageDealt;

  public final int totalDamageTaken;

  /**
   * Only returned for ranked statistics. */
  public final int totalDeathsPerSession;

  public final int totalDoubleKills;

  public final int totalFirstBlood;

  public final int totalGoldEarned;

  public final int totalHeal;

  public final int totalMagicDamageDealt;

  public final int totalMinionKills;

  public final int totalNeutralMinionsKilled;

  /**
   * Dominion only. */
  public final int totalNodeCapture;

  /**
   * Dominion only. */
  public final int totalNodeNeutralize;

  public final int totalPentaKills;

  public final int totalPhysicalDamageDealt;

  public final int totalQuadraKills;

  public final int totalSessionsLost;

  public final int totalSessionsPlayed;

  public final int totalSessionsWon;

  public final int totalTripleKills;

  public final int totalTurretsKilled;

  public final int totalUnrealKills;

  public AggregatedStats(final int averageAssists, final int averageChampionsKilled,
      final int averageCombatPlayerScore, final int averageNodeCapture,
      final int averageNodeCaptureAssist, final int averageNodeNeutralize,
      final int averageNodeNeutralizeAssist, final int averageNumDeaths,
      final int averageObjectivePlayerScore, final int averageTeamObjective,
      final int averageTotalPlayerScore, final int botGamesPlayed, final int killingSpree,
      final int maxAssists, final int maxChampionsKilled, final int maxCombatPlayerScore,
      final int maxLargestCriticalStrike, final int maxLargestKillingSpree,
      final int maxNodeCapture, final int maxNodeCaptureAssist, final int maxNodeNeutralize,
      final int maxNodeNeutralizeAssist, final int maxNumDeaths, final int maxObjectivePlayerScore,
      final int maxTeamObjective, final int maxTimePlayed, final int maxTimeSpentLiving,
      final int maxTotalPlayerScore, final int mostChampionKillsPerSession,
      final int mostSpellsCast, final int normalGamesPlayed, final int rankedPremadeGamesPlayed,
      final int rankedSoloGamesPlayed, final int totalAssists, final int totalChampionKills,
      final int totalDamageDealt, final int totalDamageTaken, final int totalDeathsPerSession,
      final int totalDoubleKills, final int totalFirstBlood, final int totalGoldEarned,
      final int totalHeal, final int totalMagicDamageDealt, final int totalMinionKills,
      final int totalNeutralMinionsKilled, final int totalNodeCapture,
      final int totalNodeNeutralize, final int totalPentaKills, final int totalPhysicalDamageDealt,
      final int totalQuadraKills, final int totalSessionsLost, final int totalSessionsPlayed,
      final int totalSessionsWon, final int totalTripleKills, final int totalTurretsKilled,
      final int totalUnrealKills) {
    this.averageAssists = averageAssists;
    this.averageChampionsKilled = averageChampionsKilled;
    this.averageCombatPlayerScore = averageCombatPlayerScore;
    this.averageNodeCapture = averageNodeCapture;
    this.averageNodeCaptureAssist = averageNodeCaptureAssist;
    this.averageNodeNeutralize = averageNodeNeutralize;
    this.averageNodeNeutralizeAssist = averageNodeNeutralizeAssist;
    this.averageNumDeaths = averageNumDeaths;
    this.averageObjectivePlayerScore = averageObjectivePlayerScore;
    this.averageTeamObjective = averageTeamObjective;
    this.averageTotalPlayerScore = averageTotalPlayerScore;
    this.botGamesPlayed = botGamesPlayed;
    this.killingSpree = killingSpree;
    this.maxAssists = maxAssists;
    this.maxChampionsKilled = maxChampionsKilled;
    this.maxCombatPlayerScore = maxCombatPlayerScore;
    this.maxLargestCriticalStrike = maxLargestCriticalStrike;
    this.maxLargestKillingSpree = maxLargestKillingSpree;
    this.maxNodeCapture = maxNodeCapture;
    this.maxNodeCaptureAssist = maxNodeCaptureAssist;
    this.maxNodeNeutralize = maxNodeNeutralize;
    this.maxNodeNeutralizeAssist = maxNodeNeutralizeAssist;
    this.maxNumDeaths = maxNumDeaths;
    this.maxObjectivePlayerScore = maxObjectivePlayerScore;
    this.maxTeamObjective = maxTeamObjective;
    this.maxTimePlayed = maxTimePlayed;
    this.maxTimeSpentLiving = maxTimeSpentLiving;
    this.maxTotalPlayerScore = maxTotalPlayerScore;
    this.mostChampionKillsPerSession = mostChampionKillsPerSession;
    this.mostSpellsCast = mostSpellsCast;
    this.normalGamesPlayed = normalGamesPlayed;
    this.rankedPremadeGamesPlayed = rankedPremadeGamesPlayed;
    this.rankedSoloGamesPlayed = rankedSoloGamesPlayed;
    this.totalAssists = totalAssists;
    this.totalChampionKills = totalChampionKills;
    this.totalDamageDealt = totalDamageDealt;
    this.totalDamageTaken = totalDamageTaken;
    this.totalDeathsPerSession = totalDeathsPerSession;
    this.totalDoubleKills = totalDoubleKills;
    this.totalFirstBlood = totalFirstBlood;
    this.totalGoldEarned = totalGoldEarned;
    this.totalHeal = totalHeal;
    this.totalMagicDamageDealt = totalMagicDamageDealt;
    this.totalMinionKills = totalMinionKills;
    this.totalNeutralMinionsKilled = totalNeutralMinionsKilled;
    this.totalNodeCapture = totalNodeCapture;
    this.totalNodeNeutralize = totalNodeNeutralize;
    this.totalPentaKills = totalPentaKills;
    this.totalPhysicalDamageDealt = totalPhysicalDamageDealt;
    this.totalQuadraKills = totalQuadraKills;
    this.totalSessionsLost = totalSessionsLost;
    this.totalSessionsPlayed = totalSessionsPlayed;
    this.totalSessionsWon = totalSessionsWon;
    this.totalTripleKills = totalTripleKills;
    this.totalTurretsKilled = totalTurretsKilled;
    this.totalUnrealKills = totalUnrealKills;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof AggregatedStats)) return false;
    final AggregatedStats other = (AggregatedStats) obj;
    return true
        && Objects.equal(averageAssists, other.averageAssists)
        && Objects.equal(averageChampionsKilled, other.averageChampionsKilled)
        && Objects.equal(averageCombatPlayerScore, other.averageCombatPlayerScore)
        && Objects.equal(averageNodeCapture, other.averageNodeCapture)
        && Objects.equal(averageNodeCaptureAssist, other.averageNodeCaptureAssist)
        && Objects.equal(averageNodeNeutralize, other.averageNodeNeutralize)
        && Objects.equal(averageNodeNeutralizeAssist, other.averageNodeNeutralizeAssist)
        && Objects.equal(averageNumDeaths, other.averageNumDeaths)
        && Objects.equal(averageObjectivePlayerScore, other.averageObjectivePlayerScore)
        && Objects.equal(averageTeamObjective, other.averageTeamObjective)
        && Objects.equal(averageTotalPlayerScore, other.averageTotalPlayerScore)
        && Objects.equal(botGamesPlayed, other.botGamesPlayed)
        && Objects.equal(killingSpree, other.killingSpree)
        && Objects.equal(maxAssists, other.maxAssists)
        && Objects.equal(maxChampionsKilled, other.maxChampionsKilled)
        && Objects.equal(maxCombatPlayerScore, other.maxCombatPlayerScore)
        && Objects.equal(maxLargestCriticalStrike, other.maxLargestCriticalStrike)
        && Objects.equal(maxLargestKillingSpree, other.maxLargestKillingSpree)
        && Objects.equal(maxNodeCapture, other.maxNodeCapture)
        && Objects.equal(maxNodeCaptureAssist, other.maxNodeCaptureAssist)
        && Objects.equal(maxNodeNeutralize, other.maxNodeNeutralize)
        && Objects.equal(maxNodeNeutralizeAssist, other.maxNodeNeutralizeAssist)
        && Objects.equal(maxNumDeaths, other.maxNumDeaths)
        && Objects.equal(maxObjectivePlayerScore, other.maxObjectivePlayerScore)
        && Objects.equal(maxTeamObjective, other.maxTeamObjective)
        && Objects.equal(maxTimePlayed, other.maxTimePlayed)
        && Objects.equal(maxTimeSpentLiving, other.maxTimeSpentLiving)
        && Objects.equal(maxTotalPlayerScore, other.maxTotalPlayerScore)
        && Objects.equal(mostChampionKillsPerSession, other.mostChampionKillsPerSession)
        && Objects.equal(mostSpellsCast, other.mostSpellsCast)
        && Objects.equal(normalGamesPlayed, other.normalGamesPlayed)
        && Objects.equal(rankedPremadeGamesPlayed, other.rankedPremadeGamesPlayed)
        && Objects.equal(rankedSoloGamesPlayed, other.rankedSoloGamesPlayed)
        && Objects.equal(totalAssists, other.totalAssists)
        && Objects.equal(totalChampionKills, other.totalChampionKills)
        && Objects.equal(totalDamageDealt, other.totalDamageDealt)
        && Objects.equal(totalDamageTaken, other.totalDamageTaken)
        && Objects.equal(totalDeathsPerSession, other.totalDeathsPerSession)
        && Objects.equal(totalDoubleKills, other.totalDoubleKills)
        && Objects.equal(totalFirstBlood, other.totalFirstBlood)
        && Objects.equal(totalGoldEarned, other.totalGoldEarned)
        && Objects.equal(totalHeal, other.totalHeal)
        && Objects.equal(totalMagicDamageDealt, other.totalMagicDamageDealt)
        && Objects.equal(totalMinionKills, other.totalMinionKills)
        && Objects.equal(totalNeutralMinionsKilled, other.totalNeutralMinionsKilled)
        && Objects.equal(totalNodeCapture, other.totalNodeCapture)
        && Objects.equal(totalNodeNeutralize, other.totalNodeNeutralize)
        && Objects.equal(totalPentaKills, other.totalPentaKills)
        && Objects.equal(totalPhysicalDamageDealt, other.totalPhysicalDamageDealt)
        && Objects.equal(totalQuadraKills, other.totalQuadraKills)
        && Objects.equal(totalSessionsLost, other.totalSessionsLost)
        && Objects.equal(totalSessionsPlayed, other.totalSessionsPlayed)
        && Objects.equal(totalSessionsWon, other.totalSessionsWon)
        && Objects.equal(totalTripleKills, other.totalTripleKills)
        && Objects.equal(totalTurretsKilled, other.totalTurretsKilled)
        && Objects.equal(totalUnrealKills, other.totalUnrealKills);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        averageAssists,
        averageChampionsKilled,
        averageCombatPlayerScore,
        averageNodeCapture,
        averageNodeCaptureAssist,
        averageNodeNeutralize,
        averageNodeNeutralizeAssist,
        averageNumDeaths,
        averageObjectivePlayerScore,
        averageTeamObjective,
        averageTotalPlayerScore,
        botGamesPlayed,
        killingSpree,
        maxAssists,
        maxChampionsKilled,
        maxCombatPlayerScore,
        maxLargestCriticalStrike,
        maxLargestKillingSpree,
        maxNodeCapture,
        maxNodeCaptureAssist,
        maxNodeNeutralize,
        maxNodeNeutralizeAssist,
        maxNumDeaths,
        maxObjectivePlayerScore,
        maxTeamObjective,
        maxTimePlayed,
        maxTimeSpentLiving,
        maxTotalPlayerScore,
        mostChampionKillsPerSession,
        mostSpellsCast,
        normalGamesPlayed,
        rankedPremadeGamesPlayed,
        rankedSoloGamesPlayed,
        totalAssists,
        totalChampionKills,
        totalDamageDealt,
        totalDamageTaken,
        totalDeathsPerSession,
        totalDoubleKills,
        totalFirstBlood,
        totalGoldEarned,
        totalHeal,
        totalMagicDamageDealt,
        totalMinionKills,
        totalNeutralMinionsKilled,
        totalNodeCapture,
        totalNodeNeutralize,
        totalPentaKills,
        totalPhysicalDamageDealt,
        totalQuadraKills,
        totalSessionsLost,
        totalSessionsPlayed,
        totalSessionsWon,
        totalTripleKills,
        totalTurretsKilled,
        totalUnrealKills);}
}
