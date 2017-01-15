package com.mingweisamuel.zyra.summoner;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * RuneSlot - This object contains rune slot information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version summoner-v1.4 */
public class RuneSlot {
  /**
   * Rune ID associated with the rune slot. For static information correlating to rune IDs, please refer to the LoL Static Data API. */
  public final int runeId;

  /**
   * Rune slot ID. */
  public final int runeSlotId;

  public RuneSlot(final int runeId, final int runeSlotId) {
    this.runeId = runeId;
    this.runeSlotId = runeSlotId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof RuneSlot)) return false;
    final RuneSlot other = (RuneSlot) obj;
    return true
        && Objects.equal(runeId, other.runeId)
        && Objects.equal(runeSlotId, other.runeSlotId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        runeId,
        runeSlotId);}
}
