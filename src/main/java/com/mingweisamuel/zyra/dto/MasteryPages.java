package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * This object contains masteries information.
 */
public class MasteryPages {

    /** Collection of mastery pages associated with summoner. */
    public List<MasteryPage> pages;

    /** Summoner ID. */
    public long id;

    @Override
    public String toString() {
        return String.format("[masteryPages %d:%s]", id, pages);
    }
}
