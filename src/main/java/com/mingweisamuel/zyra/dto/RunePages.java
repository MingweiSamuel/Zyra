package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * This object contains rune pages information.
 */
public class RunePages {

    /** Collection of rune pages associated with summoner. */
    public List<RunePage> pages;

    /** Summoner ID. */
    public long id;

    @Override
    public String toString() {
        return String.format("[runePages %d:%s]", id, pages);
    }
}
