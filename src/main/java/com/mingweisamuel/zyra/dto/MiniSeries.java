package com.mingweisamuel.zyra.dto;

/**
 * This object contains mini series information.
 *
 * Provides information on progress through a promotional series (mini series).
 */
public class MiniSeries {

    /** Number of current losses in the mini series. */
    public int losses;

    /**
     * String showing the current, sequential mini series progress where 'W' represents a
     * win, 'L' represents a loss, and 'N' represents a game that hasn't been played yet.
     */
    public String progress;

    /** Number of wins required for promotion. */
    public int target;

    /** Number of current wins in the mini series. */
    public int wins;

    @Override
    public String toString() {
        return String.format("[miniSeries %dW:%dL/%d]", wins, losses, target);
    }
}
