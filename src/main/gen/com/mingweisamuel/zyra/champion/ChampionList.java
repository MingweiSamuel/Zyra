package com.mingweisamuel.zyra.champion;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * ChampionList - This object contains a collection of champion information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version champion-v1.2 */
public class ChampionList {
  /**
   * The collection of champion information. */
  public final List<Champion> champions;

  public ChampionList(final List<Champion> champions) {
    this.champions = champions;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
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
