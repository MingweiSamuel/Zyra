package com.mingweisamuel.zyra.runesMasteries;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains rune slot information..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#runes-masteries-v1.4/GET_getRunePagesBySummonerIds">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class RuneSlot {
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
    if (!(obj instanceof RunesMasteries)) return false;
    final RunesMasteries other = (RunesMasteries) obj;
    return true
        && Objects.equal(runeId, other.runeId)
        && Objects.equal(runeSlotId, other.runeSlotId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        runeId,
        runeSlotId);}
}
