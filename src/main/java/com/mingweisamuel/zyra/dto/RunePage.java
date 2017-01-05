package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * This object contains rune page information.
 */
public class RunePage {

    /** Indicates if the page is the current page. */
    public boolean current;

    /** Rune page ID. */
    public long id;

    /** Rune page name. */
    public String name;

    /** Collection of rune slots associated with the rune page. */
    public List<RuneSlot> slot;

    @Override
    public String toString() {
        return String.format("[masteryPage %s]", name);
    }
}
