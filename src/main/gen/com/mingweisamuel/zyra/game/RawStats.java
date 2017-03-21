package com.mingweisamuel.zyra.game;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * RawStats.<br /><br />
 *
 * This object contains raw stat information..<br /><br />
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#game-v1.3/GET_getRecentGames">Riot API reference</a> on Tue Mar 21 14:58:35 PDT 2017. */
public class RawStats implements Serializable {
  public final int gold;

  public final int magicDamageDealtToChampions;

  public final int largestMultiKill;

  public final int totalDamageDealtToBuildings;

  public final int teamObjective;

  public final int trueDamageDealtPlayer;

  public final int tripleKills;

  public final int nodeNeutralizeAssist;

  public final int playerScore9;

  public final int playerScore8;

  public final int playerScore1;

  public final int playerScore0;

  public final int playerScore3;

  public final int playerScore2;

  public final int playerScore5;

  public final int playerScore4;

  public final int playerScore7;

  public final int playerScore6;

  public final int totalScoreRank;

  public final int neutralMinionsKilled;

  /**
   * Player role (Legal values: DUO(1), SUPPORT(2), CARRY(3), SOLO(4)) */
  public final int playerRole;

  public final int physicalDamageDealtToChampions;

  public final int level;

  public final int numItemsBought;

  public final int nodeCapture;

  public final int turretsKilled;

  public final int totalUnitsHealed;

  public final int team;

  public final int totalDamageTaken;

  public final int victoryPointTotal;

  public final int visionWardsBought;

  public final int largestCriticalStrike;

  public final int firstBlood;

  public final int largestKillingSpree;

  public final int quadraKills;

  public final int magicDamageTaken;

  public final int item2;

  public final int item3;

  public final int item0;

  public final int item1;

  public final int item6;

  public final int item4;

  public final int item5;

  public final int neutralMinionsKilledYourJungle;

  public final int timePlayed;

  /**
   * Flag specifying if the summoner got the killing blow on the nexus. */
  public final boolean nexusKilled;

  public final int trueDamageTaken;

  public final int nodeNeutralize;

  public final int damageDealtPlayer;

  public final int assists;

  /**
   * Number of times first champion spell was cast. */
  public final int spell1Cast;

  public final int goldSpent;

  public final int totalTimeCrowdControlDealt;

  public final int minionsDenied;

  public final int totalDamageDealtToChampions;

  /**
   * Number of times third champion spell was cast. */
  public final int spell3Cast;

  public final int physicalDamageTaken;

  public final int totalPlayerScore;

  /**
   * Flag specifying whether or not this game was won. */
  public final boolean win;

  public final int objectivePlayerScore;

  public final int totalDamageDealt;

  /**
   * Player position (Legal values: TOP(1), MIDDLE(2), JUNGLE(3), BOT(4)) */
  public final int playerPosition;

  /**
   * Number of times fourth champion spell was cast. */
  public final int spell4Cast;

  public final int bountyLevel;

  public final int neutralMinionsKilledEnemyJungle;

  /**
   * Number of times second champion spell was cast. */
  public final int spell2Cast;

  public final int sightWardsBought;

  public final int championsKilled;

  public final int trueDamageDealtToChampions;

  public final int summonSpell1Cast;

  public final int physicalDamageDealtPlayer;

  public final int goldEarned;

  public final int superMonsterKilled;

  public final int killingSprees;

  public final int unrealKills;

  public final int wardPlaced;

  /**
   * Number of enemy inhibitors killed. */
  public final int barracksKilled;

  public final int wardKilled;

  public final int consumablesPurchased;

  /**
   * Number of tier 3 items built. */
  public final int legendaryItemsCreated;

  public final int minionsKilled;

  public final int itemsPurchased;

  public final int doubleKills;

  public final int nodeCaptureAssist;

  public final int summonSpell2Cast;

  public final int combatPlayerScore;

  public final int pentaKills;

  public final int totalHeal;

  public final int numDeaths;

  public final int magicDamageDealtPlayer;

  public RawStats(final int gold, final int magicDamageDealtToChampions, final int largestMultiKill,
      final int totalDamageDealtToBuildings, final int teamObjective,
      final int trueDamageDealtPlayer, final int tripleKills, final int nodeNeutralizeAssist,
      final int playerScore9, final int playerScore8, final int playerScore1,
      final int playerScore0, final int playerScore3, final int playerScore2,
      final int playerScore5, final int playerScore4, final int playerScore7,
      final int playerScore6, final int totalScoreRank, final int neutralMinionsKilled,
      final int playerRole, final int physicalDamageDealtToChampions, final int level,
      final int numItemsBought, final int nodeCapture, final int turretsKilled,
      final int totalUnitsHealed, final int team, final int totalDamageTaken,
      final int victoryPointTotal, final int visionWardsBought, final int largestCriticalStrike,
      final int firstBlood, final int largestKillingSpree, final int quadraKills,
      final int magicDamageTaken, final int item2, final int item3, final int item0,
      final int item1, final int item6, final int item4, final int item5,
      final int neutralMinionsKilledYourJungle, final int timePlayed, final boolean nexusKilled,
      final int trueDamageTaken, final int nodeNeutralize, final int damageDealtPlayer,
      final int assists, final int spell1Cast, final int goldSpent,
      final int totalTimeCrowdControlDealt, final int minionsDenied,
      final int totalDamageDealtToChampions, final int spell3Cast, final int physicalDamageTaken,
      final int totalPlayerScore, final boolean win, final int objectivePlayerScore,
      final int totalDamageDealt, final int playerPosition, final int spell4Cast,
      final int bountyLevel, final int neutralMinionsKilledEnemyJungle, final int spell2Cast,
      final int sightWardsBought, final int championsKilled, final int trueDamageDealtToChampions,
      final int summonSpell1Cast, final int physicalDamageDealtPlayer, final int goldEarned,
      final int superMonsterKilled, final int killingSprees, final int unrealKills,
      final int wardPlaced, final int barracksKilled, final int wardKilled,
      final int consumablesPurchased, final int legendaryItemsCreated, final int minionsKilled,
      final int itemsPurchased, final int doubleKills, final int nodeCaptureAssist,
      final int summonSpell2Cast, final int combatPlayerScore, final int pentaKills,
      final int totalHeal, final int numDeaths, final int magicDamageDealtPlayer) {
    this.gold = gold;
    this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    this.largestMultiKill = largestMultiKill;
    this.totalDamageDealtToBuildings = totalDamageDealtToBuildings;
    this.teamObjective = teamObjective;
    this.trueDamageDealtPlayer = trueDamageDealtPlayer;
    this.tripleKills = tripleKills;
    this.nodeNeutralizeAssist = nodeNeutralizeAssist;
    this.playerScore9 = playerScore9;
    this.playerScore8 = playerScore8;
    this.playerScore1 = playerScore1;
    this.playerScore0 = playerScore0;
    this.playerScore3 = playerScore3;
    this.playerScore2 = playerScore2;
    this.playerScore5 = playerScore5;
    this.playerScore4 = playerScore4;
    this.playerScore7 = playerScore7;
    this.playerScore6 = playerScore6;
    this.totalScoreRank = totalScoreRank;
    this.neutralMinionsKilled = neutralMinionsKilled;
    this.playerRole = playerRole;
    this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    this.level = level;
    this.numItemsBought = numItemsBought;
    this.nodeCapture = nodeCapture;
    this.turretsKilled = turretsKilled;
    this.totalUnitsHealed = totalUnitsHealed;
    this.team = team;
    this.totalDamageTaken = totalDamageTaken;
    this.victoryPointTotal = victoryPointTotal;
    this.visionWardsBought = visionWardsBought;
    this.largestCriticalStrike = largestCriticalStrike;
    this.firstBlood = firstBlood;
    this.largestKillingSpree = largestKillingSpree;
    this.quadraKills = quadraKills;
    this.magicDamageTaken = magicDamageTaken;
    this.item2 = item2;
    this.item3 = item3;
    this.item0 = item0;
    this.item1 = item1;
    this.item6 = item6;
    this.item4 = item4;
    this.item5 = item5;
    this.neutralMinionsKilledYourJungle = neutralMinionsKilledYourJungle;
    this.timePlayed = timePlayed;
    this.nexusKilled = nexusKilled;
    this.trueDamageTaken = trueDamageTaken;
    this.nodeNeutralize = nodeNeutralize;
    this.damageDealtPlayer = damageDealtPlayer;
    this.assists = assists;
    this.spell1Cast = spell1Cast;
    this.goldSpent = goldSpent;
    this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
    this.minionsDenied = minionsDenied;
    this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    this.spell3Cast = spell3Cast;
    this.physicalDamageTaken = physicalDamageTaken;
    this.totalPlayerScore = totalPlayerScore;
    this.win = win;
    this.objectivePlayerScore = objectivePlayerScore;
    this.totalDamageDealt = totalDamageDealt;
    this.playerPosition = playerPosition;
    this.spell4Cast = spell4Cast;
    this.bountyLevel = bountyLevel;
    this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
    this.spell2Cast = spell2Cast;
    this.sightWardsBought = sightWardsBought;
    this.championsKilled = championsKilled;
    this.trueDamageDealtToChampions = trueDamageDealtToChampions;
    this.summonSpell1Cast = summonSpell1Cast;
    this.physicalDamageDealtPlayer = physicalDamageDealtPlayer;
    this.goldEarned = goldEarned;
    this.superMonsterKilled = superMonsterKilled;
    this.killingSprees = killingSprees;
    this.unrealKills = unrealKills;
    this.wardPlaced = wardPlaced;
    this.barracksKilled = barracksKilled;
    this.wardKilled = wardKilled;
    this.consumablesPurchased = consumablesPurchased;
    this.legendaryItemsCreated = legendaryItemsCreated;
    this.minionsKilled = minionsKilled;
    this.itemsPurchased = itemsPurchased;
    this.doubleKills = doubleKills;
    this.nodeCaptureAssist = nodeCaptureAssist;
    this.summonSpell2Cast = summonSpell2Cast;
    this.combatPlayerScore = combatPlayerScore;
    this.pentaKills = pentaKills;
    this.totalHeal = totalHeal;
    this.numDeaths = numDeaths;
    this.magicDamageDealtPlayer = magicDamageDealtPlayer;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof RawStats)) return false;
    final RawStats other = (RawStats) obj;
    return true
        && Objects.equal(gold, other.gold)
        && Objects.equal(magicDamageDealtToChampions, other.magicDamageDealtToChampions)
        && Objects.equal(largestMultiKill, other.largestMultiKill)
        && Objects.equal(totalDamageDealtToBuildings, other.totalDamageDealtToBuildings)
        && Objects.equal(teamObjective, other.teamObjective)
        && Objects.equal(trueDamageDealtPlayer, other.trueDamageDealtPlayer)
        && Objects.equal(tripleKills, other.tripleKills)
        && Objects.equal(nodeNeutralizeAssist, other.nodeNeutralizeAssist)
        && Objects.equal(playerScore9, other.playerScore9)
        && Objects.equal(playerScore8, other.playerScore8)
        && Objects.equal(playerScore1, other.playerScore1)
        && Objects.equal(playerScore0, other.playerScore0)
        && Objects.equal(playerScore3, other.playerScore3)
        && Objects.equal(playerScore2, other.playerScore2)
        && Objects.equal(playerScore5, other.playerScore5)
        && Objects.equal(playerScore4, other.playerScore4)
        && Objects.equal(playerScore7, other.playerScore7)
        && Objects.equal(playerScore6, other.playerScore6)
        && Objects.equal(totalScoreRank, other.totalScoreRank)
        && Objects.equal(neutralMinionsKilled, other.neutralMinionsKilled)
        && Objects.equal(playerRole, other.playerRole)
        && Objects.equal(physicalDamageDealtToChampions, other.physicalDamageDealtToChampions)
        && Objects.equal(level, other.level)
        && Objects.equal(numItemsBought, other.numItemsBought)
        && Objects.equal(nodeCapture, other.nodeCapture)
        && Objects.equal(turretsKilled, other.turretsKilled)
        && Objects.equal(totalUnitsHealed, other.totalUnitsHealed)
        && Objects.equal(team, other.team)
        && Objects.equal(totalDamageTaken, other.totalDamageTaken)
        && Objects.equal(victoryPointTotal, other.victoryPointTotal)
        && Objects.equal(visionWardsBought, other.visionWardsBought)
        && Objects.equal(largestCriticalStrike, other.largestCriticalStrike)
        && Objects.equal(firstBlood, other.firstBlood)
        && Objects.equal(largestKillingSpree, other.largestKillingSpree)
        && Objects.equal(quadraKills, other.quadraKills)
        && Objects.equal(magicDamageTaken, other.magicDamageTaken)
        && Objects.equal(item2, other.item2)
        && Objects.equal(item3, other.item3)
        && Objects.equal(item0, other.item0)
        && Objects.equal(item1, other.item1)
        && Objects.equal(item6, other.item6)
        && Objects.equal(item4, other.item4)
        && Objects.equal(item5, other.item5)
        && Objects.equal(neutralMinionsKilledYourJungle, other.neutralMinionsKilledYourJungle)
        && Objects.equal(timePlayed, other.timePlayed)
        && Objects.equal(nexusKilled, other.nexusKilled)
        && Objects.equal(trueDamageTaken, other.trueDamageTaken)
        && Objects.equal(nodeNeutralize, other.nodeNeutralize)
        && Objects.equal(damageDealtPlayer, other.damageDealtPlayer)
        && Objects.equal(assists, other.assists)
        && Objects.equal(spell1Cast, other.spell1Cast)
        && Objects.equal(goldSpent, other.goldSpent)
        && Objects.equal(totalTimeCrowdControlDealt, other.totalTimeCrowdControlDealt)
        && Objects.equal(minionsDenied, other.minionsDenied)
        && Objects.equal(totalDamageDealtToChampions, other.totalDamageDealtToChampions)
        && Objects.equal(spell3Cast, other.spell3Cast)
        && Objects.equal(physicalDamageTaken, other.physicalDamageTaken)
        && Objects.equal(totalPlayerScore, other.totalPlayerScore)
        && Objects.equal(win, other.win)
        && Objects.equal(objectivePlayerScore, other.objectivePlayerScore)
        && Objects.equal(totalDamageDealt, other.totalDamageDealt)
        && Objects.equal(playerPosition, other.playerPosition)
        && Objects.equal(spell4Cast, other.spell4Cast)
        && Objects.equal(bountyLevel, other.bountyLevel)
        && Objects.equal(neutralMinionsKilledEnemyJungle, other.neutralMinionsKilledEnemyJungle)
        && Objects.equal(spell2Cast, other.spell2Cast)
        && Objects.equal(sightWardsBought, other.sightWardsBought)
        && Objects.equal(championsKilled, other.championsKilled)
        && Objects.equal(trueDamageDealtToChampions, other.trueDamageDealtToChampions)
        && Objects.equal(summonSpell1Cast, other.summonSpell1Cast)
        && Objects.equal(physicalDamageDealtPlayer, other.physicalDamageDealtPlayer)
        && Objects.equal(goldEarned, other.goldEarned)
        && Objects.equal(superMonsterKilled, other.superMonsterKilled)
        && Objects.equal(killingSprees, other.killingSprees)
        && Objects.equal(unrealKills, other.unrealKills)
        && Objects.equal(wardPlaced, other.wardPlaced)
        && Objects.equal(barracksKilled, other.barracksKilled)
        && Objects.equal(wardKilled, other.wardKilled)
        && Objects.equal(consumablesPurchased, other.consumablesPurchased)
        && Objects.equal(legendaryItemsCreated, other.legendaryItemsCreated)
        && Objects.equal(minionsKilled, other.minionsKilled)
        && Objects.equal(itemsPurchased, other.itemsPurchased)
        && Objects.equal(doubleKills, other.doubleKills)
        && Objects.equal(nodeCaptureAssist, other.nodeCaptureAssist)
        && Objects.equal(summonSpell2Cast, other.summonSpell2Cast)
        && Objects.equal(combatPlayerScore, other.combatPlayerScore)
        && Objects.equal(pentaKills, other.pentaKills)
        && Objects.equal(totalHeal, other.totalHeal)
        && Objects.equal(numDeaths, other.numDeaths)
        && Objects.equal(magicDamageDealtPlayer, other.magicDamageDealtPlayer);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        gold,
        magicDamageDealtToChampions,
        largestMultiKill,
        totalDamageDealtToBuildings,
        teamObjective,
        trueDamageDealtPlayer,
        tripleKills,
        nodeNeutralizeAssist,
        playerScore9,
        playerScore8,
        playerScore1,
        playerScore0,
        playerScore3,
        playerScore2,
        playerScore5,
        playerScore4,
        playerScore7,
        playerScore6,
        totalScoreRank,
        neutralMinionsKilled,
        playerRole,
        physicalDamageDealtToChampions,
        level,
        numItemsBought,
        nodeCapture,
        turretsKilled,
        totalUnitsHealed,
        team,
        totalDamageTaken,
        victoryPointTotal,
        visionWardsBought,
        largestCriticalStrike,
        firstBlood,
        largestKillingSpree,
        quadraKills,
        magicDamageTaken,
        item2,
        item3,
        item0,
        item1,
        item6,
        item4,
        item5,
        neutralMinionsKilledYourJungle,
        timePlayed,
        nexusKilled,
        trueDamageTaken,
        nodeNeutralize,
        damageDealtPlayer,
        assists,
        spell1Cast,
        goldSpent,
        totalTimeCrowdControlDealt,
        minionsDenied,
        totalDamageDealtToChampions,
        spell3Cast,
        physicalDamageTaken,
        totalPlayerScore,
        win,
        objectivePlayerScore,
        totalDamageDealt,
        playerPosition,
        spell4Cast,
        bountyLevel,
        neutralMinionsKilledEnemyJungle,
        spell2Cast,
        sightWardsBought,
        championsKilled,
        trueDamageDealtToChampions,
        summonSpell1Cast,
        physicalDamageDealtPlayer,
        goldEarned,
        superMonsterKilled,
        killingSprees,
        unrealKills,
        wardPlaced,
        barracksKilled,
        wardKilled,
        consumablesPurchased,
        legendaryItemsCreated,
        minionsKilled,
        itemsPurchased,
        doubleKills,
        nodeCaptureAssist,
        summonSpell2Cast,
        combatPlayerScore,
        pentaKills,
        totalHeal,
        numDeaths,
        magicDamageDealtPlayer);}
}
