package com.mingweisamuel.zyra.summoner;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * MasteryPage - This object contains mastery page information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version summoner-v1.4 */
public class MasteryPage implements Serializable {
  /**
   * Indicates if the mastery page is the current mastery page. */
  public final boolean current;

  /**
   * Mastery page ID. */
  public final long id;

  /**
   * Collection of masteries associated with the mastery page. */
  public final List<Mastery> masteries;

  /**
   * Mastery page name. */
  public final String name;

  public MasteryPage(final boolean current, final long id, final List<Mastery> masteries,
      final String name) {
    this.current = current;
    this.id = id;
    this.masteries = masteries;
    this.name = name;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MasteryPage)) return false;
    final MasteryPage other = (MasteryPage) obj;
    return true
        && Objects.equal(current, other.current)
        && Objects.equal(id, other.id)
        && Objects.equal(masteries, other.masteries)
        && Objects.equal(name, other.name);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        current,
        id,
        masteries,
        name);}
}
