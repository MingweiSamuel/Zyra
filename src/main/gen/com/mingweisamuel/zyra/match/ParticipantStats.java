package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ParticipantStats.<br /><br />
 *
 * This object contains participant statistics information.<br /><br />
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#match-v2.2/GET_getMatchByIdAndTournamentCode">Riot API reference</a> on Tue Mar 21 14:58:35 PDT 2017. */
public class ParticipantStats implements Serializable {
  /**
   * Neutral jungle minions killed in your team's jungle */
  public final long neutralMinionsKilledTeamJungle;

  /**
   * Number of wards killed */
  public final long wardsKilled;

  /**
   * Number of unreal kills */
  public final long unrealKills;

  /**
   * If game was a dominion game, player's objectives score, otherwise 0 */
  public final long objectivePlayerScore;

  /**
   * Largest critical strike */
  public final long largestCriticalStrike;

  /**
   * Total damage dealt */
  public final long totalDamageDealt;

  /**
   * Magical damage dealt to champions */
  public final long magicDamageDealtToChampions;

  /**
   * Largest multi kill */
  public final long largestMultiKill;

  /**
   * Largest killing spree */
  public final long largestKillingSpree;

  /**
   * Second item ID */
  public final long item1;

  /**
   * Number of quadra kills */
  public final long quadraKills;

  /**
   * Magic damage taken */
  public final long magicDamageTaken;

  /**
   * Number of tower kills */
  public final long towerKills;

  /**
   * Total dealt crowd control time */
  public final long totalTimeCrowdControlDealt;

  /**
   * If game was a dominion game, player's total score, otherwise 0 */
  public final long totalPlayerScore;

  /**
   * Flag indicating if participant got an assist on the first tower */
  public final boolean firstTowerAssist;

  /**
   * Flag indicating whether or not the participant won */
  public final boolean winner;

  /**
   * Gold earned */
  public final long goldEarned;

  /**
   * Third item ID */
  public final long item2;

  /**
   * Fourth item ID */
  public final long item3;

  /**
   * First item ID */
  public final long item0;

  /**
   * Flag indicating if participant got an assist on first blood */
  public final boolean firstBloodAssist;

  /**
   * Seventh item ID */
  public final long item6;

  /**
   * Number of wards placed */
  public final long wardsPlaced;

  /**
   * Fifth item ID */
  public final long item4;

  /**
   * Sixth item ID */
  public final long item5;

  /**
   * Minions killed */
  public final long minionsKilled;

  /**
   * If game was a dominion game, number of completed team objectives (i.e., quests) */
  public final long teamObjective;

  /**
   * Number of triple kills */
  public final long tripleKills;

  /**
   * Neutral jungle minions killed in the enemy team's jungle */
  public final long neutralMinionsKilledEnemyJungle;

  /**
   * If game was a dominion game, number of node neutralization assists */
  public final long nodeNeutralizeAssist;

  /**
   * If game was a dominion game, number of node capture assists */
  public final long nodeCaptureAssist;

  /**
   * Number of killing sprees */
  public final long killingSprees;

  /**
   * Magical damage dealt */
  public final long magicDamageDealt;

  /**
   * Number of kills */
  public final long kills;

  /**
   * Number of double kills */
  public final long doubleKills;

  /**
   * Flag indicating if participant destroyed the first inhibitor */
  public final boolean firstInhibitorKill;

  /**
   * True damage taken */
  public final long trueDamageTaken;

  /**
   * If game was a dominion game, number of node neutralizations */
  public final long nodeNeutralize;

  /**
   * Flag indicating if participant got first blood */
  public final boolean firstBloodKill;

  /**
   * Number of assists */
  public final long assists;

  /**
   * Number of deaths */
  public final long deaths;

  /**
   * Neutral minions killed */
  public final long neutralMinionsKilled;

  /**
   * If game was a dominion game, player's combat score, otherwise 0 */
  public final long combatPlayerScore;

  /**
   * Vision wards purchased */
  public final long visionWardsBoughtInGame;

  /**
   * Physical damage dealt to champions */
  public final long physicalDamageDealtToChampions;

  /**
   * Gold spent */
  public final long goldSpent;

  /**
   * True damage dealt */
  public final long trueDamageDealt;

  /**
   * True damage dealt to champions */
  public final long trueDamageDealtToChampions;

  /**
   * Champion level achieved */
  public final long champLevel;

  /**
   * Number of penta kills */
  public final long pentaKills;

  /**
   * Flag indicating if participant got an assist on the first inhibitor */
  public final boolean firstInhibitorAssist;

  /**
   * Flag indicating if participant destroyed the first tower */
  public final boolean firstTowerKill;

  /**
   * Total heal amount */
  public final long totalHeal;

  /**
   * If game was a dominion game, number of node captures */
  public final long nodeCapture;

  /**
   * Sight wards purchased */
  public final long sightWardsBoughtInGame;

  /**
   * Total damage dealt to champions */
  public final long totalDamageDealtToChampions;

  /**
   * Total units healed */
  public final long totalUnitsHealed;

  /**
   * Number of inhibitor kills */
  public final long inhibitorKills;

  /**
   * If game was a dominion game, team rank of the player's total score (e.g., 1-5) */
  public final long totalScoreRank;

  /**
   * Total damage taken */
  public final long totalDamageTaken;

  /**
   * Physical damage dealt */
  public final long physicalDamageDealt;

  /**
   * Physical damage taken */
  public final long physicalDamageTaken;

  public ParticipantStats(final long neutralMinionsKilledTeamJungle, final long wardsKilled,
      final long unrealKills, final long objectivePlayerScore, final long largestCriticalStrike,
      final long totalDamageDealt, final long magicDamageDealtToChampions,
      final long largestMultiKill, final long largestKillingSpree, final long item1,
      final long quadraKills, final long magicDamageTaken, final long towerKills,
      final long totalTimeCrowdControlDealt, final long totalPlayerScore,
      final boolean firstTowerAssist, final boolean winner, final long goldEarned, final long item2,
      final long item3, final long item0, final boolean firstBloodAssist, final long item6,
      final long wardsPlaced, final long item4, final long item5, final long minionsKilled,
      final long teamObjective, final long tripleKills, final long neutralMinionsKilledEnemyJungle,
      final long nodeNeutralizeAssist, final long nodeCaptureAssist, final long killingSprees,
      final long magicDamageDealt, final long kills, final long doubleKills,
      final boolean firstInhibitorKill, final long trueDamageTaken, final long nodeNeutralize,
      final boolean firstBloodKill, final long assists, final long deaths,
      final long neutralMinionsKilled, final long combatPlayerScore,
      final long visionWardsBoughtInGame, final long physicalDamageDealtToChampions,
      final long goldSpent, final long trueDamageDealt, final long trueDamageDealtToChampions,
      final long champLevel, final long pentaKills, final boolean firstInhibitorAssist,
      final boolean firstTowerKill, final long totalHeal, final long nodeCapture,
      final long sightWardsBoughtInGame, final long totalDamageDealtToChampions,
      final long totalUnitsHealed, final long inhibitorKills, final long totalScoreRank,
      final long totalDamageTaken, final long physicalDamageDealt, final long physicalDamageTaken) {
    this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
    this.wardsKilled = wardsKilled;
    this.unrealKills = unrealKills;
    this.objectivePlayerScore = objectivePlayerScore;
    this.largestCriticalStrike = largestCriticalStrike;
    this.totalDamageDealt = totalDamageDealt;
    this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    this.largestMultiKill = largestMultiKill;
    this.largestKillingSpree = largestKillingSpree;
    this.item1 = item1;
    this.quadraKills = quadraKills;
    this.magicDamageTaken = magicDamageTaken;
    this.towerKills = towerKills;
    this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    this.totalPlayerScore = totalPlayerScore;
    this.firstTowerAssist = firstTowerAssist;
    this.winner = winner;
    this.goldEarned = goldEarned;
    this.item2 = item2;
    this.item3 = item3;
    this.item0 = item0;
    this.firstBloodAssist = firstBloodAssist;
    this.item6 = item6;
    this.wardsPlaced = wardsPlaced;
    this.item4 = item4;
    this.item5 = item5;
    this.minionsKilled = minionsKilled;
    this.teamObjective = teamObjective;
    this.tripleKills = tripleKills;
    this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    this.nodeNeutralizeAssist = nodeNeutralizeAssist;
    this.nodeCaptureAssist = nodeCaptureAssist;
    this.killingSprees = killingSprees;
    this.magicDamageDealt = magicDamageDealt;
    this.kills = kills;
    this.doubleKills = doubleKills;
    this.firstInhibitorKill = firstInhibitorKill;
    this.trueDamageTaken = trueDamageTaken;
    this.nodeNeutralize = nodeNeutralize;
    this.firstBloodKill = firstBloodKill;
    this.assists = assists;
    this.deaths = deaths;
    this.neutralMinionsKilled = neutralMinionsKilled;
    this.combatPlayerScore = combatPlayerScore;
    this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    this.goldSpent = goldSpent;
    this.trueDamageDealt = trueDamageDealt;
    this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    this.champLevel = champLevel;
    this.pentaKills = pentaKills;
    this.firstInhibitorAssist = firstInhibitorAssist;
    this.firstTowerKill = firstTowerKill;
    this.totalHeal = totalHeal;
    this.nodeCapture = nodeCapture;
    this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    this.totalUnitsHealed = totalUnitsHealed;
    this.inhibitorKills = inhibitorKills;
    this.totalScoreRank = totalScoreRank;
    this.totalDamageTaken = totalDamageTaken;
    this.physicalDamageDealt = physicalDamageDealt;
    this.physicalDamageTaken = physicalDamageTaken;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ParticipantStats)) return false;
    final ParticipantStats other = (ParticipantStats) obj;
    return true
        && Objects.equal(neutralMinionsKilledTeamJungle, other.neutralMinionsKilledTeamJungle)
        && Objects.equal(wardsKilled, other.wardsKilled)
        && Objects.equal(unrealKills, other.unrealKills)
        && Objects.equal(objectivePlayerScore, other.objectivePlayerScore)
        && Objects.equal(largestCriticalStrike, other.largestCriticalStrike)
        && Objects.equal(totalDamageDealt, other.totalDamageDealt)
        && Objects.equal(magicDamageDealtToChampions, other.magicDamageDealtToChampions)
        && Objects.equal(largestMultiKill, other.largestMultiKill)
        && Objects.equal(largestKillingSpree, other.largestKillingSpree)
        && Objects.equal(item1, other.item1)
        && Objects.equal(quadraKills, other.quadraKills)
        && Objects.equal(magicDamageTaken, other.magicDamageTaken)
        && Objects.equal(towerKills, other.towerKills)
        && Objects.equal(totalTimeCrowdControlDealt, other.totalTimeCrowdControlDealt)
        && Objects.equal(totalPlayerScore, other.totalPlayerScore)
        && Objects.equal(firstTowerAssist, other.firstTowerAssist)
        && Objects.equal(winner, other.winner)
        && Objects.equal(goldEarned, other.goldEarned)
        && Objects.equal(item2, other.item2)
        && Objects.equal(item3, other.item3)
        && Objects.equal(item0, other.item0)
        && Objects.equal(firstBloodAssist, other.firstBloodAssist)
        && Objects.equal(item6, other.item6)
        && Objects.equal(wardsPlaced, other.wardsPlaced)
        && Objects.equal(item4, other.item4)
        && Objects.equal(item5, other.item5)
        && Objects.equal(minionsKilled, other.minionsKilled)
        && Objects.equal(teamObjective, other.teamObjective)
        && Objects.equal(tripleKills, other.tripleKills)
        && Objects.equal(neutralMinionsKilledEnemyJungle, other.neutralMinionsKilledEnemyJungle)
        && Objects.equal(nodeNeutralizeAssist, other.nodeNeutralizeAssist)
        && Objects.equal(nodeCaptureAssist, other.nodeCaptureAssist)
        && Objects.equal(killingSprees, other.killingSprees)
        && Objects.equal(magicDamageDealt, other.magicDamageDealt)
        && Objects.equal(kills, other.kills)
        && Objects.equal(doubleKills, other.doubleKills)
        && Objects.equal(firstInhibitorKill, other.firstInhibitorKill)
        && Objects.equal(trueDamageTaken, other.trueDamageTaken)
        && Objects.equal(nodeNeutralize, other.nodeNeutralize)
        && Objects.equal(firstBloodKill, other.firstBloodKill)
        && Objects.equal(assists, other.assists)
        && Objects.equal(deaths, other.deaths)
        && Objects.equal(neutralMinionsKilled, other.neutralMinionsKilled)
        && Objects.equal(combatPlayerScore, other.combatPlayerScore)
        && Objects.equal(visionWardsBoughtInGame, other.visionWardsBoughtInGame)
        && Objects.equal(physicalDamageDealtToChampions, other.physicalDamageDealtToChampions)
        && Objects.equal(goldSpent, other.goldSpent)
        && Objects.equal(trueDamageDealt, other.trueDamageDealt)
        && Objects.equal(trueDamageDealtToChampions, other.trueDamageDealtToChampions)
        && Objects.equal(champLevel, other.champLevel)
        && Objects.equal(pentaKills, other.pentaKills)
        && Objects.equal(firstInhibitorAssist, other.firstInhibitorAssist)
        && Objects.equal(firstTowerKill, other.firstTowerKill)
        && Objects.equal(totalHeal, other.totalHeal)
        && Objects.equal(nodeCapture, other.nodeCapture)
        && Objects.equal(sightWardsBoughtInGame, other.sightWardsBoughtInGame)
        && Objects.equal(totalDamageDealtToChampions, other.totalDamageDealtToChampions)
        && Objects.equal(totalUnitsHealed, other.totalUnitsHealed)
        && Objects.equal(inhibitorKills, other.inhibitorKills)
        && Objects.equal(totalScoreRank, other.totalScoreRank)
        && Objects.equal(totalDamageTaken, other.totalDamageTaken)
        && Objects.equal(physicalDamageDealt, other.physicalDamageDealt)
        && Objects.equal(physicalDamageTaken, other.physicalDamageTaken);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        neutralMinionsKilledTeamJungle,
        wardsKilled,
        unrealKills,
        objectivePlayerScore,
        largestCriticalStrike,
        totalDamageDealt,
        magicDamageDealtToChampions,
        largestMultiKill,
        largestKillingSpree,
        item1,
        quadraKills,
        magicDamageTaken,
        towerKills,
        totalTimeCrowdControlDealt,
        totalPlayerScore,
        firstTowerAssist,
        winner,
        goldEarned,
        item2,
        item3,
        item0,
        firstBloodAssist,
        item6,
        wardsPlaced,
        item4,
        item5,
        minionsKilled,
        teamObjective,
        tripleKills,
        neutralMinionsKilledEnemyJungle,
        nodeNeutralizeAssist,
        nodeCaptureAssist,
        killingSprees,
        magicDamageDealt,
        kills,
        doubleKills,
        firstInhibitorKill,
        trueDamageTaken,
        nodeNeutralize,
        firstBloodKill,
        assists,
        deaths,
        neutralMinionsKilled,
        combatPlayerScore,
        visionWardsBoughtInGame,
        physicalDamageDealtToChampions,
        goldSpent,
        trueDamageDealt,
        trueDamageDealtToChampions,
        champLevel,
        pentaKills,
        firstInhibitorAssist,
        firstTowerKill,
        totalHeal,
        nodeCapture,
        sightWardsBoughtInGame,
        totalDamageDealtToChampions,
        totalUnitsHealed,
        inhibitorKills,
        totalScoreRank,
        totalDamageTaken,
        physicalDamageDealt,
        physicalDamageTaken);}
}
