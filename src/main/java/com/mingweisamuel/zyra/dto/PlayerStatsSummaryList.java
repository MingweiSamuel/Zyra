package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * This object contains a collection of player stats summary information.
 */
public class PlayerStatsSummaryList {

    /** Collection of player stats summaries associated with the summoner. */
    public List<PlayerStatsSummary> playerStatSummaries;

    /** Summoner ID. */
    public long summonerId;

    @Override
    public String toString() {
        return String.format("[playerStatsSummaryList %d:%s]", summonerId, playerStatSummaries.toString());
    }
}
