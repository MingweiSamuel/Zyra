package com.mingweisamuel.zyra.dto;

/**
 * This object contains single ChampionId Mastery information for player and champion combination.
 */
public class ChampionMastery {

    /** ChampionId ID for this entry. */
    public long championId;

    /** ChampionId level for specified player and champion combination. */
    public int championLevel;

    /** Total number of champion points for this player and champion combination - they are used to determine
     * championLevel. */
    public int championPoints;

    /** Number of points earned since current level has been achieved. Equal to championPoints if if championLevel is
     * 1. */
    public long championPointsSinceLastLevel;

    /** Number of points needed to achieve next level. Zero if player reached maximum champion level for this
     * champion. */
    public long championPointsUntilNextLevel;

    /** Is chest granted for this champion or not in current season. */
    public boolean chestGranted;

    /** Last time this champion was played by this player - in Unix milliseconds time format. */
    public long lastPlayTime;

    /** Player ID for this entry (Summoner ID). */
    public long playerId;

    @Override
    public String toString() {
        return String.format("[championMastery %d:%d:%d]", playerId, championId, championPoints);
    }
}
