package com.mingweisamuel.zyra.champion;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * This object contains a collection of champion information..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#champion-v1.2/GET_getChampions">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class ChampionList {
  /**
   * The collection of champion information. */
  public final List<Champion> champions;

  public ChampionList(final List<Champion> champions) {
    this.champions = champions;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Champion)) return false;
    final Champion other = (Champion) obj;
    return true
        && Objects.equal(champions, other.champions);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        champions);}
}
