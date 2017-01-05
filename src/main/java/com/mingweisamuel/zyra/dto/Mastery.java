package com.mingweisamuel.zyra.dto;

/**
 * This object contains mastery information.
 */
public class Mastery {

    /** Mastery ID. For static information correlating to masteries, please refer to the LoL Static Data API. */
    public int id;

    /** Mastery rank (i.e., the number of points put into this mastery). */
    public int rank;

    @Override
    public String toString() {
        return String.format("[mastery %d:%d]", id, rank);
    }
}
