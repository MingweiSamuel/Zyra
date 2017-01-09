package com.mingweisamuel.zyra.dto;

/**
 * ParticipantStats - This object contains participant statistics information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link RiotDtoGenerator}.
 *
 * @version match-v2.2 */
public class ParticipantStats {
  /**
   * Number of assists */
  public long assists;

  /**
   * Champion level achieved */
  public long champLevel;

  /**
   * If game was a dominion game, player's combat score, otherwise 0 */
  public long combatPlayerScore;

  /**
   * Number of deaths */
  public long deaths;

  /**
   * Number of double kills */
  public long doubleKills;

  /**
   * Flag indicating if participant got an assist on first blood */
  public boolean firstBloodAssist;

  /**
   * Flag indicating if participant got first blood */
  public boolean firstBloodKill;

  /**
   * Flag indicating if participant got an assist on the first inhibitor */
  public boolean firstInhibitorAssist;

  /**
   * Flag indicating if participant destroyed the first inhibitor */
  public boolean firstInhibitorKill;

  /**
   * Flag indicating if participant got an assist on the first tower */
  public boolean firstTowerAssist;

  /**
   * Flag indicating if participant destroyed the first tower */
  public boolean firstTowerKill;

  /**
   * Gold earned */
  public long goldEarned;

  /**
   * Gold spent */
  public long goldSpent;

  /**
   * Number of inhibitor kills */
  public long inhibitorKills;

  /**
   * First item ID */
  public long item0;

  /**
   * Second item ID */
  public long item1;

  /**
   * Third item ID */
  public long item2;

  /**
   * Fourth item ID */
  public long item3;

  /**
   * Fifth item ID */
  public long item4;

  /**
   * Sixth item ID */
  public long item5;

  /**
   * Seventh item ID */
  public long item6;

  /**
   * Number of killing sprees */
  public long killingSprees;

  /**
   * Number of kills */
  public long kills;

  /**
   * Largest critical strike */
  public long largestCriticalStrike;

  /**
   * Largest killing spree */
  public long largestKillingSpree;

  /**
   * Largest multi kill */
  public long largestMultiKill;

  /**
   * Magical damage dealt */
  public long magicDamageDealt;

  /**
   * Magical damage dealt to champions */
  public long magicDamageDealtToChampions;

  /**
   * Magic damage taken */
  public long magicDamageTaken;

  /**
   * Minions killed */
  public long minionsKilled;

  /**
   * Neutral minions killed */
  public long neutralMinionsKilled;

  /**
   * Neutral jungle minions killed in the enemy team's jungle */
  public long neutralMinionsKilledEnemyJungle;

  /**
   * Neutral jungle minions killed in your team's jungle */
  public long neutralMinionsKilledTeamJungle;

  /**
   * If game was a dominion game, number of node captures */
  public long nodeCapture;

  /**
   * If game was a dominion game, number of node capture assists */
  public long nodeCaptureAssist;

  /**
   * If game was a dominion game, number of node neutralizations */
  public long nodeNeutralize;

  /**
   * If game was a dominion game, number of node neutralization assists */
  public long nodeNeutralizeAssist;

  /**
   * If game was a dominion game, player's objectives score, otherwise 0 */
  public long objectivePlayerScore;

  /**
   * Number of penta kills */
  public long pentaKills;

  /**
   * Physical damage dealt */
  public long physicalDamageDealt;

  /**
   * Physical damage dealt to champions */
  public long physicalDamageDealtToChampions;

  /**
   * Physical damage taken */
  public long physicalDamageTaken;

  /**
   * Number of quadra kills */
  public long quadraKills;

  /**
   * Sight wards purchased */
  public long sightWardsBoughtInGame;

  /**
   * If game was a dominion game, number of completed team objectives (i.e., quests) */
  public long teamObjective;

  /**
   * Total damage dealt */
  public long totalDamageDealt;

  /**
   * Total damage dealt to champions */
  public long totalDamageDealtToChampions;

  /**
   * Total damage taken */
  public long totalDamageTaken;

  /**
   * Total heal amount */
  public long totalHeal;

  /**
   * If game was a dominion game, player's total score, otherwise 0 */
  public long totalPlayerScore;

  /**
   * If game was a dominion game, team rank of the player's total score (e.g., 1-5) */
  public long totalScoreRank;

  /**
   * Total dealt crowd control time */
  public long totalTimeCrowdControlDealt;

  /**
   * Total units healed */
  public long totalUnitsHealed;

  /**
   * Number of tower kills */
  public long towerKills;

  /**
   * Number of triple kills */
  public long tripleKills;

  /**
   * True damage dealt */
  public long trueDamageDealt;

  /**
   * True damage dealt to champions */
  public long trueDamageDealtToChampions;

  /**
   * True damage taken */
  public long trueDamageTaken;

  /**
   * Number of unreal kills */
  public long unrealKills;

  /**
   * Vision wards purchased */
  public long visionWardsBoughtInGame;

  /**
   * Number of wards killed */
  public long wardsKilled;

  /**
   * Number of wards placed */
  public long wardsPlaced;

  /**
   * Flag indicating whether or not the participant won */
  public boolean winner;
}
