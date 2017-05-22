package com.mingweisamuel.zyra.runes;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * RuneSlot.<br><br>
 *
 * This object contains rune slot information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#runes-v3/GET_getRunePagesBySummonerId">Riot API reference</a> on Sun May 21 18:03:38 PDT 2017. */
public class RuneSlot implements Serializable {
  /**
   * Rune slot ID. */
  public final int runeSlotId;

  /**
   * Rune ID associated with the rune slot. For static information correlating to rune IDs, please refer to the LoL Static Data API. */
  public final int runeId;

  public RuneSlot(final int runeSlotId, final int runeId) {
    this.runeSlotId = runeSlotId;
    this.runeId = runeId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof RuneSlot)) return false;
    final RuneSlot other = (RuneSlot) obj;
    return true
        && Objects.equal(runeSlotId, other.runeSlotId)
        && Objects.equal(runeId, other.runeId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        runeSlotId,
        runeId);}
}
