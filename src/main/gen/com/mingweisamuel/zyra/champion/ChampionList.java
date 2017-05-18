package com.mingweisamuel.zyra.champion;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * ChampionList.<br><br>
 *
 * This object contains a collection of champion information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Riot API reference</a> on Wed May 17 21:53:10 PDT 2017. */
public class ChampionList implements Serializable {
  /**
   * The collection of champion information. */
  public final List<Champion> champions;

  public ChampionList(final List<Champion> champions) {
    this.champions = champions;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ChampionList)) return false;
    final ChampionList other = (ChampionList) obj;
    return true
        && Objects.equal(champions, other.champions);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        champions);}
}
