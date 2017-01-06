package com.mingweisamuel.zyra;

import com.mingweisamuel.zyra.enums.Region;

import java.lang.reflect.Type;

/**
 * Riot API League Endpoint (v2.5).
 *
 * Provides access to league (rank) information on a per-summoner basis as well as listings of the challenger and
 * master tier leagues.
 */
public class LeagueEndpoint {

    /** Relative URL for the league endpoint. */
    private static final String URL_BASE = "api/lol/{region}/v2.5/";
    /** URL suffix for the challenger league endpoint. */
    private static final String URL_SUFFIX_CHALLENGER = "challenger";
    /** Type for league listing (get challenger and master). */
    private static final Type TYPE_LEAGUE = League.class;

    /** RiotApi reference. */
    private final RiotApi api;

    /**
     * Creates a LeagueEndpoint instance.
     * @param api RiotApi reference.
     */
    LeagueEndpoint(RiotApi api) {
        this.api = api;
    }

    public League getChallenger(Region region) {
        return api.getBasic(region, String.format(URL_BASE, region), TYPE_LEAGUE);
    }
}
