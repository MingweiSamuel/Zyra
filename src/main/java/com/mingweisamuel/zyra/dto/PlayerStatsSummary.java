package com.mingweisamuel.zyra.dto;

/**
 * This object contains player stats summary information.
 */
public class PlayerStatsSummary {

    /** Aggregated stats. */
    public AggregatedStats aggregatedStats;

    /** Number of losses for this queue type. Returned for ranked queue types only. */
    public int losses;

    /** Date stats were last modified specified as epoch milliseconds. */
    public long modifyDate;

    /**
     * Player stats summary type. (Legal values: AramUnranked5x5, Ascension,
     * Bilgewater, CAP5x5, CoopVsAI, CoopVsAI3x3, CounterPick, FirstBlood1x1, FirstBlood2x2, Hexakill, KingPoro,
     * NightmareBot, OdinUnranked, OneForAll5x5, RankedPremade3x3, RankedPremade5x5, RankedSolo5x5, RankedTeam3x3,
     * RankedTeam5x5, SummonersRift6x6, Unranked, Unranked3x3, URF, URFBots, Siege, RankedFlexSR, RankedFlexTT).
     * TODO enum for above.
     */
    public String playerStatSummaryType;

    /** Number of wins for this queue type. */
    public int wins;

    @Override
    public String toString() {
        return String.format("[playerStatsSummaryList %s:%s]", playerStatSummaryType, aggregatedStats.toString());
    }
}
