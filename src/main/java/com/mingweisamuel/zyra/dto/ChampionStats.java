package com.mingweisamuel.zyra.dto;

/**
 * This object contains a collection of champion stats information for a summoner.
 */
public class ChampionStats {

    /**
     * Champion ID. Note that champion ID 0 ({@link com.mingweisamuel.zyra.enums.ChampionId#ALL}) represents the
     * combined stats for all champions. For static information correlating to champion IDs, please refer to the LoL
     * Static Data API (TODO LINK).
     */
    public int id;

    /** Aggregated stats associated with the champion. */
    public AggregatedStats stats;

    @Override
    public String toString() {
        return String.format("[championStats %d:%s]", id, stats.toString());
    }
}
