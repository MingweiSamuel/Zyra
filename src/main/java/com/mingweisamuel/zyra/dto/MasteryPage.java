package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * This object contains mastery page information.
 */
public class MasteryPage {

    /** Indicates if the mastery page is the current mastery page. */
    public boolean current;

    /** Mastery page ID. */
    public long id;

    /** Collection of masteries associated with the mastery page. */
    public List<Mastery> masteries;

    /** Mastery page name. */
    public String name;

    @Override
    public String toString() {
        return String.format("[masteryPage %s]", name);
    }
}
