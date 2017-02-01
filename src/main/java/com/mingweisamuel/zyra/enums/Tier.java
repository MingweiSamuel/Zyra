package com.mingweisamuel.zyra.enums;

import java.util.Comparator;

/**
 * Contains tier names (CHALLENGER, MASTER, etc.)
 */
public class Tier {
    private Tier() {}
    public static final String CHALLENGER = "CHALLENGER";
    public static final String MASTER = "MASTER";
    public static final String DIAMOND = "DIAMOND";
    public static final String PLATINUM = "PLATINUM";
    public static final String GOLD = "GOLD";
    public static final String SILVER = "SILVER";
    public static final String BRONZE = "BRONZE";
    /** In most endpoints, tier will not be provided if related summoner is unranked. */
    public static final String UNRANKED = "UNRANKED";
}
