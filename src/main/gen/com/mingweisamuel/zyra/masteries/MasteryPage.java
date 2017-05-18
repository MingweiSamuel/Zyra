package com.mingweisamuel.zyra.masteries;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * MasteryPage.<br><br>
 *
 * This object contains mastery page information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#masteries-v3/GET_getMasteryPagesBySummonerId">Riot API reference</a> on Wed May 17 21:34:50 PDT 2017. */
public class MasteryPage implements Serializable {
  /**
   * Indicates if the mastery page is the current mastery page. */
  public final boolean current;

  /**
   * Collection of masteries associated with the mastery page. */
  public final List<Mastery> masteries;

  /**
   * Mastery page name. */
  public final String name;

  /**
   * Mastery page ID. */
  public final long id;

  public MasteryPage(final boolean current, final List<Mastery> masteries, final String name,
      final long id) {
    this.current = current;
    this.masteries = masteries;
    this.name = name;
    this.id = id;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MasteryPage)) return false;
    final MasteryPage other = (MasteryPage) obj;
    return true
        && Objects.equal(current, other.current)
        && Objects.equal(masteries, other.masteries)
        && Objects.equal(name, other.name)
        && Objects.equal(id, other.id);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        current,
        masteries,
        name,
        id);}
}
