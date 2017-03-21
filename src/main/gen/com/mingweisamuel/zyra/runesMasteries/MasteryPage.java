package com.mingweisamuel.zyra.runesMasteries;

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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#runes-masteries-v1.4/GET_getMasteryPagesBySummonerIds">Riot API reference</a> on Tue Mar 21 15:10:48 PDT 2017. */
public class MasteryPage implements Serializable {
  /**
   * Indicates if the mastery page is the current mastery page. */
  public final boolean current;

  /**
   * Collection of masteries associated with the mastery page. */
  public final List<Mastery> masteries;

  /**
   * Mastery page ID. */
  public final long id;

  /**
   * Mastery page name. */
  public final String name;

  public MasteryPage(final boolean current, final List<Mastery> masteries, final long id,
      final String name) {
    this.current = current;
    this.masteries = masteries;
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MasteryPage)) return false;
    final MasteryPage other = (MasteryPage) obj;
    return true
        && Objects.equal(current, other.current)
        && Objects.equal(masteries, other.masteries)
        && Objects.equal(id, other.id)
        && Objects.equal(name, other.name);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        current,
        masteries,
        id,
        name);}
}
