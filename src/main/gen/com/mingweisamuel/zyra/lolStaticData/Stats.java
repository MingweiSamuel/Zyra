package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Stats.<br><br>
 *
 * This object contains champion stats data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Stats implements Serializable {
  public final double armor;

  public final double armorperlevel;

  public final double attackdamage;

  public final double attackdamageperlevel;

  public final double attackrange;

  public final double attackspeedoffset;

  public final double attackspeedperlevel;

  public final double crit;

  public final double critperlevel;

  public final double hp;

  public final double hpperlevel;

  public final double hpregen;

  public final double hpregenperlevel;

  public final double movespeed;

  public final double mp;

  public final double mpperlevel;

  public final double mpregen;

  public final double mpregenperlevel;

  public final double spellblock;

  public final double spellblockperlevel;

  public Stats(final double armor, final double armorperlevel, final double attackdamage,
      final double attackdamageperlevel, final double attackrange, final double attackspeedoffset,
      final double attackspeedperlevel, final double crit, final double critperlevel,
      final double hp, final double hpperlevel, final double hpregen, final double hpregenperlevel,
      final double movespeed, final double mp, final double mpperlevel, final double mpregen,
      final double mpregenperlevel, final double spellblock, final double spellblockperlevel) {
    this.armor = armor;
    this.armorperlevel = armorperlevel;
    this.attackdamage = attackdamage;
    this.attackdamageperlevel = attackdamageperlevel;
    this.attackrange = attackrange;
    this.attackspeedoffset = attackspeedoffset;
    this.attackspeedperlevel = attackspeedperlevel;
    this.crit = crit;
    this.critperlevel = critperlevel;
    this.hp = hp;
    this.hpperlevel = hpperlevel;
    this.hpregen = hpregen;
    this.hpregenperlevel = hpregenperlevel;
    this.movespeed = movespeed;
    this.mp = mp;
    this.mpperlevel = mpperlevel;
    this.mpregen = mpregen;
    this.mpregenperlevel = mpregenperlevel;
    this.spellblock = spellblock;
    this.spellblockperlevel = spellblockperlevel;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Stats)) return false;
    final Stats other = (Stats) obj;
    return true
        && Objects.equal(armor, other.armor)
        && Objects.equal(armorperlevel, other.armorperlevel)
        && Objects.equal(attackdamage, other.attackdamage)
        && Objects.equal(attackdamageperlevel, other.attackdamageperlevel)
        && Objects.equal(attackrange, other.attackrange)
        && Objects.equal(attackspeedoffset, other.attackspeedoffset)
        && Objects.equal(attackspeedperlevel, other.attackspeedperlevel)
        && Objects.equal(crit, other.crit)
        && Objects.equal(critperlevel, other.critperlevel)
        && Objects.equal(hp, other.hp)
        && Objects.equal(hpperlevel, other.hpperlevel)
        && Objects.equal(hpregen, other.hpregen)
        && Objects.equal(hpregenperlevel, other.hpregenperlevel)
        && Objects.equal(movespeed, other.movespeed)
        && Objects.equal(mp, other.mp)
        && Objects.equal(mpperlevel, other.mpperlevel)
        && Objects.equal(mpregen, other.mpregen)
        && Objects.equal(mpregenperlevel, other.mpregenperlevel)
        && Objects.equal(spellblock, other.spellblock)
        && Objects.equal(spellblockperlevel, other.spellblockperlevel);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        armor,
        armorperlevel,
        attackdamage,
        attackdamageperlevel,
        attackrange,
        attackspeedoffset,
        attackspeedperlevel,
        crit,
        critperlevel,
        hp,
        hpperlevel,
        hpregen,
        hpregenperlevel,
        movespeed,
        mp,
        mpperlevel,
        mpregen,
        mpregenperlevel,
        spellblock,
        spellblockperlevel);}
}
