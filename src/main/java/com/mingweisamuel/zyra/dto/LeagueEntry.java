package com.mingweisamuel.zyra.dto;

/**
 * This object contains league participant information representing a summoner or team.
 *
 * Represents a rank for whatever {@link League} this instance is contained in for a single participant (either a
 * summoner or team).
 */
public class LeagueEntry {

    /** The league division of the participant. */
    public String division; //TODO - parse?

    /** Specifies if the participant is fresh blood. */
    public boolean isFreshBlood;

    /** Specifies if the participant is on a hot streak. */
    public boolean isHotStreak;

    /** Specifies if the participant is inactive. */
    public boolean isInactive;
    
    /** Specifies if the participant is a veteran. */
    public boolean isVeteran;
    
    /** The league points of the participant. */
    public int leaguePoints;
    
    /** The number of losses for the participant. */
    public int losses;
    
    /**
     * Mini series data for the participant. Only present if the participant is currently in a mini series. Otherwise
     * null.
     */
    public MiniSeries miniSeries;
    
    /** The ID of the participant (i.e., summoner or team) represented by this entry. */
    public String playerOrTeamId;
    
    /** The name of the the participant (i.e., summoner or team) represented by this entry. */
    public String playerOrTeamName;
    
    /** The playstyle of the participant. (Legal values: NONE, SOLO, SQUAD, TEAM) */
    public String playstyle;
    
    /** The number of wins for the participant. */
    public int wins;

    @Override
    public String toString() {
        return String.format("[leagueEntry %s:%s]", playerOrTeamName, division);
    }
}
