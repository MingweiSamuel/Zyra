package com.mingweisamuel.zyra.match;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * ParticipantStats - This object contains participant statistics information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version match-v2.2 */
public class ParticipantStats {
  /**
   * Number of assists */
  public final long assists;

  /**
   * Champion level achieved */
  public final long champLevel;

  /**
   * If game was a dominion game, player's combat score, otherwise 0 */
  public final long combatPlayerScore;

  /**
   * Number of deaths */
  public final long deaths;

  /**
   * Number of double kills */
  public final long doubleKills;

  /**
   * Flag indicating if participant got an assist on first blood */
  public final boolean firstBloodAssist;

  /**
   * Flag indicating if participant got first blood */
  public final boolean firstBloodKill;

  /**
   * Flag indicating if participant got an assist on the first inhibitor */
  public final boolean firstInhibitorAssist;

  /**
   * Flag indicating if participant destroyed the first inhibitor */
  public final boolean firstInhibitorKill;

  /**
   * Flag indicating if participant got an assist on the first tower */
  public final boolean firstTowerAssist;

  /**
   * Flag indicating if participant destroyed the first tower */
  public final boolean firstTowerKill;

  /**
   * Gold earned */
  public final long goldEarned;

  /**
   * Gold spent */
  public final long goldSpent;

  /**
   * Number of inhibitor kills */
  public final long inhibitorKills;

  /**
   * First item ID */
  public final long item0;

  /**
   * Second item ID */
  public final long item1;

  /**
   * Third item ID */
  public final long item2;

  /**
   * Fourth item ID */
  public final long item3;

  /**
   * Fifth item ID */
  public final long item4;

  /**
   * Sixth item ID */
  public final long item5;

  /**
   * Seventh item ID */
  public final long item6;

  /**
   * Number of killing sprees */
  public final long killingSprees;

  /**
   * Number of kills */
  public final long kills;

  /**
   * Largest critical strike */
  public final long largestCriticalStrike;

  /**
   * Largest killing spree */
  public final long largestKillingSpree;

  /**
   * Largest multi kill */
  public final long largestMultiKill;

  /**
   * Magical damage dealt */
  public final long magicDamageDealt;

  /**
   * Magical damage dealt to champions */
  public final long magicDamageDealtToChampions;

  /**
   * Magic damage taken */
  public final long magicDamageTaken;

  /**
   * Minions killed */
  public final long minionsKilled;

  /**
   * Neutral minions killed */
  public final long neutralMinionsKilled;

  /**
   * Neutral jungle minions killed in the enemy team's jungle */
  public final long neutralMinionsKilledEnemyJungle;

  /**
   * Neutral jungle minions killed in your team's jungle */
  public final long neutralMinionsKilledTeamJungle;

  /**
   * If game was a dominion game, number of node captures */
  public final long nodeCapture;

  /**
   * If game was a dominion game, number of node capture assists */
  public final long nodeCaptureAssist;

  /**
   * If game was a dominion game, number of node neutralizations */
  public final long nodeNeutralize;

  /**
   * If game was a dominion game, number of node neutralization assists */
  public final long nodeNeutralizeAssist;

  /**
   * If game was a dominion game, player's objectives score, otherwise 0 */
  public final long objectivePlayerScore;

  /**
   * Number of penta kills */
  public final long pentaKills;

  /**
   * Physical damage dealt */
  public final long physicalDamageDealt;

  /**
   * Physical damage dealt to champions */
  public final long physicalDamageDealtToChampions;

  /**
   * Physical damage taken */
  public final long physicalDamageTaken;

  /**
   * Number of quadra kills */
  public final long quadraKills;

  /**
   * Sight wards purchased */
  public final long sightWardsBoughtInGame;

  /**
   * If game was a dominion game, number of completed team objectives (i.e., quests) */
  public final long teamObjective;

  /**
   * Total damage dealt */
  public final long totalDamageDealt;

  /**
   * Total damage dealt to champions */
  public final long totalDamageDealtToChampions;

  /**
   * Total damage taken */
  public final long totalDamageTaken;

  /**
   * Total heal amount */
  public final long totalHeal;

  /**
   * If game was a dominion game, player's total score, otherwise 0 */
  public final long totalPlayerScore;

  /**
   * If game was a dominion game, team rank of the player's total score (e.g., 1-5) */
  public final long totalScoreRank;

  /**
   * Total dealt crowd control time */
  public final long totalTimeCrowdControlDealt;

  /**
   * Total units healed */
  public final long totalUnitsHealed;

  /**
   * Number of tower kills */
  public final long towerKills;

  /**
   * Number of triple kills */
  public final long tripleKills;

  /**
   * True damage dealt */
  public final long trueDamageDealt;

  /**
   * True damage dealt to champions */
  public final long trueDamageDealtToChampions;

  /**
   * True damage taken */
  public final long trueDamageTaken;

  /**
   * Number of unreal kills */
  public final long unrealKills;

  /**
   * Vision wards purchased */
  public final long visionWardsBoughtInGame;

  /**
   * Number of wards killed */
  public final long wardsKilled;

  /**
   * Number of wards placed */
  public final long wardsPlaced;

  /**
   * Flag indicating whether or not the participant won */
  public final boolean winner;

  public ParticipantStats(final long assists, final long champLevel, final long combatPlayerScore,
      final long deaths, final long doubleKills, final boolean firstBloodAssist,
      final boolean firstBloodKill, final boolean firstInhibitorAssist,
      final boolean firstInhibitorKill, final boolean firstTowerAssist,
      final boolean firstTowerKill, final long goldEarned, final long goldSpent,
      final long inhibitorKills, final long item0, final long item1, final long item2,
      final long item3, final long item4, final long item5, final long item6,
      final long killingSprees, final long kills, final long largestCriticalStrike,
      final long largestKillingSpree, final long largestMultiKill, final long magicDamageDealt,
      final long magicDamageDealtToChampions, final long magicDamageTaken, final long minionsKilled,
      final long neutralMinionsKilled, final long neutralMinionsKilledEnemyJungle,
      final long neutralMinionsKilledTeamJungle, final long nodeCapture,
      final long nodeCaptureAssist, final long nodeNeutralize, final long nodeNeutralizeAssist,
      final long objectivePlayerScore, final long pentaKills, final long physicalDamageDealt,
      final long physicalDamageDealtToChampions, final long physicalDamageTaken,
      final long quadraKills, final long sightWardsBoughtInGame, final long teamObjective,
      final long totalDamageDealt, final long totalDamageDealtToChampions,
      final long totalDamageTaken, final long totalHeal, final long totalPlayerScore,
      final long totalScoreRank, final long totalTimeCrowdControlDealt, final long totalUnitsHealed,
      final long towerKills, final long tripleKills, final long trueDamageDealt,
      final long trueDamageDealtToChampions, final long trueDamageTaken, final long unrealKills,
      final long visionWardsBoughtInGame, final long wardsKilled, final long wardsPlaced,
      final boolean winner) {
    this.assists = assists;
    this.champLevel = champLevel;
    this.combatPlayerScore = combatPlayerScore;
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
    this.magicDamageDealt = magicDamageDealt;
    this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    this.magicDamageTaken = magicDamageTaken;
    this.minionsKilled = minionsKilled;
    this.neutralMinionsKilled = neutralMinionsKilled;
    this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
    this.nodeCapture = nodeCapture;
    this.nodeCaptureAssist = nodeCaptureAssist;
    this.nodeNeutralize = nodeNeutralize;
    this.nodeNeutralizeAssist = nodeNeutralizeAssist;
    this.objectivePlayerScore = objectivePlayerScore;
    this.pentaKills = pentaKills;
    this.physicalDamageDealt = physicalDamageDealt;
    this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    this.physicalDamageTaken = physicalDamageTaken;
    this.quadraKills = quadraKills;
    this.sightWardsBoughtInGame = sightWardsBoughtInGame;
    this.teamObjective = teamObjective;
    this.totalDamageDealt = totalDamageDealt;
    this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    this.totalDamageTaken = totalDamageTaken;
    this.totalHeal = totalHeal;
    this.totalPlayerScore = totalPlayerScore;
    this.totalScoreRank = totalScoreRank;
    this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    this.totalUnitsHealed = totalUnitsHealed;
    this.towerKills = towerKills;
    this.tripleKills = tripleKills;
    this.trueDamageDealt = trueDamageDealt;
    this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    this.trueDamageTaken = trueDamageTaken;
    this.unrealKills = unrealKills;
    this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    this.wardsKilled = wardsKilled;
    this.wardsPlaced = wardsPlaced;
    this.winner = winner;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof ParticipantStats)) return false;
    final ParticipantStats other = (ParticipantStats) obj;
    return true
        && Objects.equal(assists, other.assists)
        && Objects.equal(champLevel, other.champLevel)
        && Objects.equal(combatPlayerScore, other.combatPlayerScore)
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
        && Objects.equal(magicDamageDealt, other.magicDamageDealt)
        && Objects.equal(magicDamageDealtToChampions, other.magicDamageDealtToChampions)
        && Objects.equal(magicDamageTaken, other.magicDamageTaken)
        && Objects.equal(minionsKilled, other.minionsKilled)
        && Objects.equal(neutralMinionsKilled, other.neutralMinionsKilled)
        && Objects.equal(neutralMinionsKilledEnemyJungle, other.neutralMinionsKilledEnemyJungle)
        && Objects.equal(neutralMinionsKilledTeamJungle, other.neutralMinionsKilledTeamJungle)
        && Objects.equal(nodeCapture, other.nodeCapture)
        && Objects.equal(nodeCaptureAssist, other.nodeCaptureAssist)
        && Objects.equal(nodeNeutralize, other.nodeNeutralize)
        && Objects.equal(nodeNeutralizeAssist, other.nodeNeutralizeAssist)
        && Objects.equal(objectivePlayerScore, other.objectivePlayerScore)
        && Objects.equal(pentaKills, other.pentaKills)
        && Objects.equal(physicalDamageDealt, other.physicalDamageDealt)
        && Objects.equal(physicalDamageDealtToChampions, other.physicalDamageDealtToChampions)
        && Objects.equal(physicalDamageTaken, other.physicalDamageTaken)
        && Objects.equal(quadraKills, other.quadraKills)
        && Objects.equal(sightWardsBoughtInGame, other.sightWardsBoughtInGame)
        && Objects.equal(teamObjective, other.teamObjective)
        && Objects.equal(totalDamageDealt, other.totalDamageDealt)
        && Objects.equal(totalDamageDealtToChampions, other.totalDamageDealtToChampions)
        && Objects.equal(totalDamageTaken, other.totalDamageTaken)
        && Objects.equal(totalHeal, other.totalHeal)
        && Objects.equal(totalPlayerScore, other.totalPlayerScore)
        && Objects.equal(totalScoreRank, other.totalScoreRank)
        && Objects.equal(totalTimeCrowdControlDealt, other.totalTimeCrowdControlDealt)
        && Objects.equal(totalUnitsHealed, other.totalUnitsHealed)
        && Objects.equal(towerKills, other.towerKills)
        && Objects.equal(tripleKills, other.tripleKills)
        && Objects.equal(trueDamageDealt, other.trueDamageDealt)
        && Objects.equal(trueDamageDealtToChampions, other.trueDamageDealtToChampions)
        && Objects.equal(trueDamageTaken, other.trueDamageTaken)
        && Objects.equal(unrealKills, other.unrealKills)
        && Objects.equal(visionWardsBoughtInGame, other.visionWardsBoughtInGame)
        && Objects.equal(wardsKilled, other.wardsKilled)
        && Objects.equal(wardsPlaced, other.wardsPlaced)
        && Objects.equal(winner, other.winner);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        assists,
        champLevel,
        combatPlayerScore,
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
        magicDamageDealt,
        magicDamageDealtToChampions,
        magicDamageTaken,
        minionsKilled,
        neutralMinionsKilled,
        neutralMinionsKilledEnemyJungle,
        neutralMinionsKilledTeamJungle,
        nodeCapture,
        nodeCaptureAssist,
        nodeNeutralize,
        nodeNeutralizeAssist,
        objectivePlayerScore,
        pentaKills,
        physicalDamageDealt,
        physicalDamageDealtToChampions,
        physicalDamageTaken,
        quadraKills,
        sightWardsBoughtInGame,
        teamObjective,
        totalDamageDealt,
        totalDamageDealtToChampions,
        totalDamageTaken,
        totalHeal,
        totalPlayerScore,
        totalScoreRank,
        totalTimeCrowdControlDealt,
        totalUnitsHealed,
        towerKills,
        tripleKills,
        trueDamageDealt,
        trueDamageDealtToChampions,
        trueDamageTaken,
        unrealKills,
        visionWardsBoughtInGame,
        wardsKilled,
        wardsPlaced,
        winner);}
}
