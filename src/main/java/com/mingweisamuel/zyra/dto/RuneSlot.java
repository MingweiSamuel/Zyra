package com.mingweisamuel.zyra.dto;

/**
 * This object contains rune slot information.
 */
public class RuneSlot {

    /** Rune ID associated with the rune slot. For static information correlating to rune IDs, please refer to the LoL
     *  Static Data API. */
    public int runeId;

    /** Rune slot ID. */
    public int runeSlotId;

    @Override
    public String toString() {
        return String.format("[runeSlot %d:%d]", runeId, runeSlotId);
    }
}
