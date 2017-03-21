package com.mingweisamuel.zyra.runesMasteries;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * This object contains mastery page information..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#runes-masteries-v1.4/GET_getMasteryPagesBySummonerIds">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class MasteryPage {
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
    if (!(obj instanceof RunesMasteries)) return false;
    final RunesMasteries other = (RunesMasteries) obj;
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
