package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * This object contains ranked stats information.
 *
 * Contains per-champion summary statistics for a summoner.
 */
public class RankedStats {

    /** Collection of aggregated stats summarized by champion. */
    public List<ChampionStats> champions;

    /** Date stats were last modified specified as epoch milliseconds. */
    public long modifyDate;

    /** Summoner ID. */
    public long summonerId;

    @Override
    public String toString() {
        return String.format("[rankedStats %d:%s]", summonerId, champions.toString());
    }
}
