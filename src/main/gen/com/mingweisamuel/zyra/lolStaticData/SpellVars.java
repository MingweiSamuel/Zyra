package com.mingweisamuel.zyra.lolStaticData;

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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class SpellVars implements Serializable {
  public final List<Double> coeff;

  public final String dyn;

  public final String key;

  public final String link;

  public final String ranksWith;

  public SpellVars(final List<Double> coeff, final String dyn, final String key, final String link,
      final String ranksWith) {
    this.coeff = coeff;
    this.dyn = dyn;
    this.key = key;
    this.link = link;
    this.ranksWith = ranksWith;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof SpellVars)) return false;
    final SpellVars other = (SpellVars) obj;
    return true
        && Objects.equal(coeff, other.coeff)
        && Objects.equal(dyn, other.dyn)
        && Objects.equal(key, other.key)
        && Objects.equal(link, other.link)
        && Objects.equal(ranksWith, other.ranksWith);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        coeff,
        dyn,
        key,
        link,
        ranksWith);}
}
