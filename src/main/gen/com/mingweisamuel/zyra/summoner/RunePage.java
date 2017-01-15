package com.mingweisamuel.zyra.summoner;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * RunePage - This object contains rune page information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version summoner-v1.4 */
public class RunePage {
  /**
   * Indicates if the page is the current page. */
  public final boolean current;

  /**
   * Rune page ID. */
  public final long id;

  /**
   * Rune page name. */
  public final String name;

  /**
   * Collection of rune slots associated with the rune page. */
  public final List<RuneSlot> slots;

  public RunePage(final boolean current, final long id, final String name,
      final List<RuneSlot> slots) {
    this.current = current;
    this.id = id;
    this.name = name;
    this.slots = slots;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof RunePage)) return false;
    final RunePage other = (RunePage) obj;
    return true
        && Objects.equal(current, other.current)
        && Objects.equal(id, other.id)
        && Objects.equal(name, other.name)
        && Objects.equal(slots, other.slots);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        current,
        id,
        name,
        slots);}
}
