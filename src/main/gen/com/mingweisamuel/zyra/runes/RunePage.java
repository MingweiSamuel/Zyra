package com.mingweisamuel.zyra.runes;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * RunePage.<br><br>
 *
 * This object contains rune page information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#runes-v3/GET_getRunePagesBySummonerId">Riot API reference</a> on Tue May 23 09:10:03 PDT 2017. */
public class RunePage implements Serializable {
  /**
   * Indicates if the page is the current page. */
  public final boolean current;

  /**
   * Collection of rune slots associated with the rune page. */
  public final List<RuneSlot> slots;

  /**
   * Rune page name. */
  public final String name;

  /**
   * Rune page ID. */
  public final long id;

  public RunePage(final boolean current, final List<RuneSlot> slots, final String name,
      final long id) {
    this.current = current;
    this.slots = slots;
    this.name = name;
    this.id = id;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof RunePage)) return false;
    final RunePage other = (RunePage) obj;
    return true
        && Objects.equal(current, other.current)
        && Objects.equal(slots, other.slots)
        && Objects.equal(name, other.name)
        && Objects.equal(id, other.id);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        current,
        slots,
        name,
        id);}
}
