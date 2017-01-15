package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * SpellVars - This object contains spell vars data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class SpellVars {
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
    if (obj == null) return false;
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
