package com.mingweisamuel.zyra.enums;

/**
 * Simple static fields for red/blue team ids.
 */
public class TeamId {
    private TeamId() {}

    /** Team ID for Summoner's Rift blue side (100). */
    public static final int BLUE = 100;
    /** Team ID for Summoner's Rift red side (200). */
    public static final int RED = 200;

    /** Win string for {@link com.mingweisamuel.zyra.match.TeamStats#win}. "Win". */
    public static final String WIN = "Win";
    /** Loss string for {@link com.mingweisamuel.zyra.match.TeamStats#win}. "Fail". */
    public static final String LOSE = "Fail";
}
