package com.mingweisamuel.zyra.runesMasteries;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * RuneSlot.<br><br>
 *
 * This object contains rune slot information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#runes-masteries-v1.4/GET_getRunePagesBySummonerIds">Riot API reference</a> on Mon May 15 17:36:46 PDT 2017. */
public class RuneSlot implements Serializable {
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
