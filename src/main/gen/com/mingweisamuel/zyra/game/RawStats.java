package com.mingweisamuel.zyra.game;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * RawStats - This object contains raw stat information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version game-v1.3 */
public class RawStats implements Serializable {
  public final int assists;

  /**
   * Number of enemy inhibitors killed. */
  public final int barracksKilled;

  public final int bountyLevel;

  public final int championsKilled;

  public final int combatPlayerScore;

  public final int consumablesPurchased;

  public final int damageDealtPlayer;

  public final int doubleKills;

  public final int firstBlood;

  public final int gold;

  public final int goldEarned;

  public final int goldSpent;

  public final int item0;

  public final int item1;

  public final int item2;

  public final int item3;

  public final int item4;

  public final int item5;

  public final int item6;

  public final int itemsPurchased;

  public final int killingSprees;

  public final int largestCriticalStrike;

  public final int largestKillingSpree;

  public final int largestMultiKill;

  /**
   * Number of tier 3 items built. */
  public final int legendaryItemsCreated;

  public final int level;

  public final int magicDamageDealtPlayer;

  public final int magicDamageDealtToChampions;

  public final int magicDamageTaken;

  public final int minionsDenied;

  public final int minionsKilled;

  public final int neutralMinionsKilled;

  public final int neutralMinionsKilledEnemyJungle;

  public final int neutralMinionsKilledYourJungle;

  /**
   * Flag specifying if the summoner got the killing blow on the nexus. */
  public final boolean nexusKilled;

  public final int nodeCapture;

  public final int nodeCaptureAssist;

  public final int nodeNeutralize;

  public final int nodeNeutralizeAssist;

  public final int numDeaths;

  public final int numItemsBought;

  public final int objectivePlayerScore;

  public final int pentaKills;

  public final int physicalDamageDealtPlayer;

  public final int physicalDamageDealtToChampions;

  public final int physicalDamageTaken;

  /**
   * Player position (Legal values: TOP(1), MIDDLE(2), JUNGLE(3), BOT(4)) */
  public final int playerPosition;

  /**
   * Player role (Legal values: DUO(1), SUPPORT(2), CARRY(3), SOLO(4)) */
  public final int playerRole;

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

  public final int sightWardsBought;

  /**
   * Number of times first champion spell was cast. */
  public final int spell1Cast;

  /**
   * Number of times second champion spell was cast. */
  public final int spell2Cast;

  /**
   * Number of times third champion spell was cast. */
  public final int spell3Cast;

  /**
   * Number of times fourth champion spell was cast. */
  public final int spell4Cast;

  public final int summonSpell1Cast;

  public final int summonSpell2Cast;

  public final int superMonsterKilled;

  public final int team;

  public final int teamObjective;

  public final int timePlayed;

  public final int totalDamageDealt;

  public final int totalDamageDealtToBuildings;

  public final int totalDamageDealtToChampions;

  public final int totalDamageTaken;

  public final int totalHeal;

  public final int totalPlayerScore;

  public final int totalScoreRank;

  public final int totalTimeCrowdControlDealt;

  public final int totalUnitsHealed;

  public final int tripleKills;

  public final int trueDamageDealtPlayer;

  public final int trueDamageDealtToChampions;

  public final int trueDamageTaken;

  public final int turretsKilled;

  public final int unrealKills;

  public final int victoryPointTotal;

  public final int visionWardsBought;

  public final int wardKilled;

  public final int wardPlaced;

  /**
   * Flag specifying whether or not this game was won. */
  public final boolean win;

  public RawStats(final int assists, final int barracksKilled, final int bountyLevel,
      final int championsKilled, final int combatPlayerScore, final int consumablesPurchased,
      final int damageDealtPlayer, final int doubleKills, final int firstBlood, final int gold,
      final int goldEarned, final int goldSpent, final int item0, final int item1, final int item2,
      final int item3, final int item4, final int item5, final int item6, final int itemsPurchased,
      final int killingSprees, final int largestCriticalStrike, final int largestKillingSpree,
      final int largestMultiKill, final int legendaryItemsCreated, final int level,
      final int magicDamageDealtPlayer, final int magicDamageDealtToChampions,
      final int magicDamageTaken, final int minionsDenied, final int minionsKilled,
      final int neutralMinionsKilled, final int neutralMinionsKilledEnemyJungle,
      final int neutralMinionsKilledYourJungle, final boolean nexusKilled, final int nodeCapture,
      final int nodeCaptureAssist, final int nodeNeutralize, final int nodeNeutralizeAssist,
      final int numDeaths, final int numItemsBought, final int objectivePlayerScore,
      final int pentaKills, final int physicalDamageDealtPlayer,
      final int physicalDamageDealtToChampions, final int physicalDamageTaken,
      final int playerPosition, final int playerRole, final int playerScore0,
      final int playerScore1, final int playerScore2, final int playerScore3,
      final int playerScore4, final int playerScore5, final int playerScore6,
      final int playerScore7, final int playerScore8, final int playerScore9, final int quadraKills,
      final int sightWardsBought, final int spell1Cast, final int spell2Cast, final int spell3Cast,
      final int spell4Cast, final int summonSpell1Cast, final int summonSpell2Cast,
      final int superMonsterKilled, final int team, final int teamObjective, final int timePlayed,
      final int totalDamageDealt, final int totalDamageDealtToBuildings,
      final int totalDamageDealtToChampions, final int totalDamageTaken, final int totalHeal,
      final int totalPlayerScore, final int totalScoreRank, final int totalTimeCrowdControlDealt,
      final int totalUnitsHealed, final int tripleKills, final int trueDamageDealtPlayer,
      final int trueDamageDealtToChampions, final int trueDamageTaken, final int turretsKilled,
      final int unrealKills, final int victoryPointTotal, final int visionWardsBought,
      final int wardKilled, final int wardPlaced, final boolean win) {
    this.assists = assists;
    this.barracksKilled = barracksKilled;
    this.bountyLevel = bountyLevel;
    this.championsKilled = championsKilled;
    this.combatPlayerScore = combatPlayerScore;
    this.consumablesPurchased = consumablesPurchased;
    this.damageDealtPlayer = damageDealtPlayer;
    this.doubleKills = doubleKills;
    this.firstBlood = firstBlood;
    this.gold = gold;
    this.goldEarned = goldEarned;
    this.goldSpent = goldSpent;
    this.item0 = item0;
    this.item1 = item1;
    this.item2 = item2;
    this.item3 = item3;
    this.item4 = item4;
    this.item5 = item5;
    this.item6 = item6;
    this.itemsPurchased = itemsPurchased;
    this.killingSprees = killingSprees;
    this.largestCriticalStrike = largestCriticalStrike;
    this.largestKillingSpree = largestKillingSpree;
    this.largestMultiKill = largestMultiKill;
    this.legendaryItemsCreated = legendaryItemsCreated;
    this.level = level;
    this.magicDamageDealtPlayer = magicDamageDealtPlayer;
    this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    this.magicDamageTaken = magicDamageTaken;
    this.minionsDenied = minionsDenied;
    this.minionsKilled = minionsKilled;
    this.neutralMinionsKilled = neutralMinionsKilled;
    this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    this.neutralMinionsKilledYourJungle = neutralMinionsKilledYourJungle;
    this.nexusKilled = nexusKilled;
    this.nodeCapture = nodeCapture;
    this.nodeCaptureAssist = nodeCaptureAssist;
    this.nodeNeutralize = nodeNeutralize;
    this.nodeNeutralizeAssist = nodeNeutralizeAssist;
    this.numDeaths = numDeaths;
    this.numItemsBought = numItemsBought;
    this.objectivePlayerScore = objectivePlayerScore;
    this.pentaKills = pentaKills;
    this.physicalDamageDealtPlayer = physicalDamageDealtPlayer;
    this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    this.physicalDamageTaken = physicalDamageTaken;
    this.playerPosition = playerPosition;
    this.playerRole = playerRole;
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
    this.sightWardsBought = sightWardsBought;
    this.spell1Cast = spell1Cast;
    this.spell2Cast = spell2Cast;
    this.spell3Cast = spell3Cast;
    this.spell4Cast = spell4Cast;
    this.summonSpell1Cast = summonSpell1Cast;
    this.summonSpell2Cast = summonSpell2Cast;
    this.superMonsterKilled = superMonsterKilled;
    this.team = team;
    this.teamObjective = teamObjective;
    this.timePlayed = timePlayed;
    this.totalDamageDealt = totalDamageDealt;
    this.totalDamageDealtToBuildings = totalDamageDealtToBuildings;
    this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    this.totalDamageTaken = totalDamageTaken;
    this.totalHeal = totalHeal;
    this.totalPlayerScore = totalPlayerScore;
    this.totalScoreRank = totalScoreRank;
    this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    this.totalUnitsHealed = totalUnitsHealed;
    this.tripleKills = tripleKills;
    this.trueDamageDealtPlayer = trueDamageDealtPlayer;
    this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    this.trueDamageTaken = trueDamageTaken;
    this.turretsKilled = turretsKilled;
    this.unrealKills = unrealKills;
    this.victoryPointTotal = victoryPointTotal;
    this.visionWardsBought = visionWardsBought;
    this.wardKilled = wardKilled;
    this.wardPlaced = wardPlaced;
    this.win = win;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof RawStats)) return false;
    final RawStats other = (RawStats) obj;
    return true
        && Objects.equal(assists, other.assists)
        && Objects.equal(barracksKilled, other.barracksKilled)
        && Objects.equal(bountyLevel, other.bountyLevel)
        && Objects.equal(championsKilled, other.championsKilled)
        && Objects.equal(combatPlayerScore, other.combatPlayerScore)
        && Objects.equal(consumablesPurchased, other.consumablesPurchased)
        && Objects.equal(damageDealtPlayer, other.damageDealtPlayer)
        && Objects.equal(doubleKills, other.doubleKills)
        && Objects.equal(firstBlood, other.firstBlood)
        && Objects.equal(gold, other.gold)
        && Objects.equal(goldEarned, other.goldEarned)
        && Objects.equal(goldSpent, other.goldSpent)
        && Objects.equal(item0, other.item0)
        && Objects.equal(item1, other.item1)
        && Objects.equal(item2, other.item2)
        && Objects.equal(item3, other.item3)
        && Objects.equal(item4, other.item4)
        && Objects.equal(item5, other.item5)
        && Objects.equal(item6, other.item6)
        && Objects.equal(itemsPurchased, other.itemsPurchased)
        && Objects.equal(killingSprees, other.killingSprees)
        && Objects.equal(largestCriticalStrike, other.largestCriticalStrike)
        && Objects.equal(largestKillingSpree, other.largestKillingSpree)
        && Objects.equal(largestMultiKill, other.largestMultiKill)
        && Objects.equal(legendaryItemsCreated, other.legendaryItemsCreated)
        && Objects.equal(level, other.level)
        && Objects.equal(magicDamageDealtPlayer, other.magicDamageDealtPlayer)
        && Objects.equal(magicDamageDealtToChampions, other.magicDamageDealtToChampions)
        && Objects.equal(magicDamageTaken, other.magicDamageTaken)
        && Objects.equal(minionsDenied, other.minionsDenied)
        && Objects.equal(minionsKilled, other.minionsKilled)
        && Objects.equal(neutralMinionsKilled, other.neutralMinionsKilled)
        && Objects.equal(neutralMinionsKilledEnemyJungle, other.neutralMinionsKilledEnemyJungle)
        && Objects.equal(neutralMinionsKilledYourJungle, other.neutralMinionsKilledYourJungle)
        && Objects.equal(nexusKilled, other.nexusKilled)
        && Objects.equal(nodeCapture, other.nodeCapture)
        && Objects.equal(nodeCaptureAssist, other.nodeCaptureAssist)
        && Objects.equal(nodeNeutralize, other.nodeNeutralize)
        && Objects.equal(nodeNeutralizeAssist, other.nodeNeutralizeAssist)
        && Objects.equal(numDeaths, other.numDeaths)
        && Objects.equal(numItemsBought, other.numItemsBought)
        && Objects.equal(objectivePlayerScore, other.objectivePlayerScore)
        && Objects.equal(pentaKills, other.pentaKills)
        && Objects.equal(physicalDamageDealtPlayer, other.physicalDamageDealtPlayer)
        && Objects.equal(physicalDamageDealtToChampions, other.physicalDamageDealtToChampions)
        && Objects.equal(physicalDamageTaken, other.physicalDamageTaken)
        && Objects.equal(playerPosition, other.playerPosition)
        && Objects.equal(playerRole, other.playerRole)
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
        && Objects.equal(sightWardsBought, other.sightWardsBought)
        && Objects.equal(spell1Cast, other.spell1Cast)
        && Objects.equal(spell2Cast, other.spell2Cast)
        && Objects.equal(spell3Cast, other.spell3Cast)
        && Objects.equal(spell4Cast, other.spell4Cast)
        && Objects.equal(summonSpell1Cast, other.summonSpell1Cast)
        && Objects.equal(summonSpell2Cast, other.summonSpell2Cast)
        && Objects.equal(superMonsterKilled, other.superMonsterKilled)
        && Objects.equal(team, other.team)
        && Objects.equal(teamObjective, other.teamObjective)
        && Objects.equal(timePlayed, other.timePlayed)
        && Objects.equal(totalDamageDealt, other.totalDamageDealt)
        && Objects.equal(totalDamageDealtToBuildings, other.totalDamageDealtToBuildings)
        && Objects.equal(totalDamageDealtToChampions, other.totalDamageDealtToChampions)
        && Objects.equal(totalDamageTaken, other.totalDamageTaken)
        && Objects.equal(totalHeal, other.totalHeal)
        && Objects.equal(totalPlayerScore, other.totalPlayerScore)
        && Objects.equal(totalScoreRank, other.totalScoreRank)
        && Objects.equal(totalTimeCrowdControlDealt, other.totalTimeCrowdControlDealt)
        && Objects.equal(totalUnitsHealed, other.totalUnitsHealed)
        && Objects.equal(tripleKills, other.tripleKills)
        && Objects.equal(trueDamageDealtPlayer, other.trueDamageDealtPlayer)
        && Objects.equal(trueDamageDealtToChampions, other.trueDamageDealtToChampions)
        && Objects.equal(trueDamageTaken, other.trueDamageTaken)
        && Objects.equal(turretsKilled, other.turretsKilled)
        && Objects.equal(unrealKills, other.unrealKills)
        && Objects.equal(victoryPointTotal, other.victoryPointTotal)
        && Objects.equal(visionWardsBought, other.visionWardsBought)
        && Objects.equal(wardKilled, other.wardKilled)
        && Objects.equal(wardPlaced, other.wardPlaced)
        && Objects.equal(win, other.win);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        assists,
        barracksKilled,
        bountyLevel,
        championsKilled,
        combatPlayerScore,
        consumablesPurchased,
        damageDealtPlayer,
        doubleKills,
        firstBlood,
        gold,
        goldEarned,
        goldSpent,
        item0,
        item1,
        item2,
        item3,
        item4,
        item5,
        item6,
        itemsPurchased,
        killingSprees,
        largestCriticalStrike,
        largestKillingSpree,
        largestMultiKill,
        legendaryItemsCreated,
        level,
        magicDamageDealtPlayer,
        magicDamageDealtToChampions,
        magicDamageTaken,
        minionsDenied,
        minionsKilled,
        neutralMinionsKilled,
        neutralMinionsKilledEnemyJungle,
        neutralMinionsKilledYourJungle,
        nexusKilled,
        nodeCapture,
        nodeCaptureAssist,
        nodeNeutralize,
        nodeNeutralizeAssist,
        numDeaths,
        numItemsBought,
        objectivePlayerScore,
        pentaKills,
        physicalDamageDealtPlayer,
        physicalDamageDealtToChampions,
        physicalDamageTaken,
        playerPosition,
        playerRole,
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
        sightWardsBought,
        spell1Cast,
        spell2Cast,
        spell3Cast,
        spell4Cast,
        summonSpell1Cast,
        summonSpell2Cast,
        superMonsterKilled,
        team,
        teamObjective,
        timePlayed,
        totalDamageDealt,
        totalDamageDealtToBuildings,
        totalDamageDealtToChampions,
        totalDamageTaken,
        totalHeal,
        totalPlayerScore,
        totalScoreRank,
        totalTimeCrowdControlDealt,
        totalUnitsHealed,
        tripleKills,
        trueDamageDealtPlayer,
        trueDamageDealtToChampions,
        trueDamageTaken,
        turretsKilled,
        unrealKills,
        victoryPointTotal,
        visionWardsBought,
        wardKilled,
        wardPlaced,
        win);}
}
