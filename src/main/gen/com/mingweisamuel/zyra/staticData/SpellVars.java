package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * SpellVars.<br><br>
 *
 * This object contains spell vars data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getChampionList">Riot API reference</a> on Tue May 16 20:00:39 PDT 2017. */
public class SpellVars implements Serializable {
  public final String ranksWith;

  public final String dyn;

  public final String link;

  public final List<Double> coeff;

  public final String key;

  public SpellVars(final String ranksWith, final String dyn, final String link,
      final List<Double> coeff, final String key) {
    this.ranksWith = ranksWith;
    this.dyn = dyn;
    this.link = link;
    this.coeff = coeff;
    this.key = key;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof SpellVars)) return false;
    final SpellVars other = (SpellVars) obj;
    return true
        && Objects.equal(ranksWith, other.ranksWith)
        && Objects.equal(dyn, other.dyn)
        && Objects.equal(link, other.link)
        && Objects.equal(coeff, other.coeff)
        && Objects.equal(key, other.key);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        ranksWith,
        dyn,
        link,
        coeff,
        key);}
}
