package com.mingweisamuel.zyra.enums;

/**
 * Helper static class for getting tier names.
 */
public class Tier {
    private Tier() {}
    private static final String CHALLENGER = "CHALLENGER";
    private static final String MASTER = "MASTER";
    private static final String DIAMOND = "DIAMOND";
    private static final String PLATINUM = "PLATINUM";
    private static final String GOLD = "GOLD";
    private static final String SILVER = "SILVER";
    private static final String BRONZE = "BRONZE";
    /** In most endpoints, tier will not be provided if related summoner is unranked. */
    private static final String UNRANKED = "UNRANKED";
}
