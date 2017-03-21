package com.mingweisamuel.zyra.runesMasteries;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * RunePage.<br /><br />
 *
 * This object contains rune page information..<br /><br />
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#runes-masteries-v1.4/GET_getRunePagesBySummonerIds">Riot API reference</a> on Tue Mar 21 14:58:35 PDT 2017. */
public class RunePage implements Serializable {
  /**
   * Indicates if the page is the current page. */
  public final boolean current;

  /**
   * Collection of rune slots associated with the rune page. */
  public final List<RuneSlot> slots;

  /**
   * Rune page ID. */
  public final long id;

  /**
   * Rune page name. */
  public final String name;

  public RunePage(final boolean current, final List<RuneSlot> slots, final long id,
      final String name) {
    this.current = current;
    this.slots = slots;
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof RunePage)) return false;
    final RunePage other = (RunePage) obj;
    return true
        && Objects.equal(current, other.current)
        && Objects.equal(slots, other.slots)
        && Objects.equal(id, other.id)
        && Objects.equal(name, other.name);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        current,
        slots,
        id,
        name);}
}
