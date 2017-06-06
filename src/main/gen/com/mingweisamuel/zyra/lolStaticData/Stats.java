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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getChampionList">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class Stats implements Serializable {
  public final double armorperlevel;

  public final double hpperlevel;

  public final double attackdamage;

  public final double mpperlevel;

  public final double attackspeedoffset;

  public final double armor;

  public final double hp;

  public final double hpregenperlevel;

  public final double spellblock;

  public final double attackrange;

  public final double movespeed;

  public final double attackdamageperlevel;

  public final double mpregenperlevel;

  public final double mp;

  public final double spellblockperlevel;

  public final double crit;

  public final double mpregen;

  public final double attackspeedperlevel;

  public final double hpregen;

  public final double critperlevel;

  public Stats(final double armorperlevel, final double hpperlevel, final double attackdamage,
      final double mpperlevel, final double attackspeedoffset, final double armor, final double hp,
      final double hpregenperlevel, final double spellblock, final double attackrange,
      final double movespeed, final double attackdamageperlevel, final double mpregenperlevel,
      final double mp, final double spellblockperlevel, final double crit, final double mpregen,
      final double attackspeedperlevel, final double hpregen, final double critperlevel) {
    this.armorperlevel = armorperlevel;
    this.hpperlevel = hpperlevel;
    this.attackdamage = attackdamage;
    this.mpperlevel = mpperlevel;
    this.attackspeedoffset = attackspeedoffset;
    this.armor = armor;
    this.hp = hp;
    this.hpregenperlevel = hpregenperlevel;
    this.spellblock = spellblock;
    this.attackrange = attackrange;
    this.movespeed = movespeed;
    this.attackdamageperlevel = attackdamageperlevel;
    this.mpregenperlevel = mpregenperlevel;
    this.mp = mp;
    this.spellblockperlevel = spellblockperlevel;
    this.crit = crit;
    this.mpregen = mpregen;
    this.attackspeedperlevel = attackspeedperlevel;
    this.hpregen = hpregen;
    this.critperlevel = critperlevel;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Stats)) return false;
    final Stats other = (Stats) obj;
    return true
        && Objects.equal(armorperlevel, other.armorperlevel)
        && Objects.equal(hpperlevel, other.hpperlevel)
        && Objects.equal(attackdamage, other.attackdamage)
        && Objects.equal(mpperlevel, other.mpperlevel)
        && Objects.equal(attackspeedoffset, other.attackspeedoffset)
        && Objects.equal(armor, other.armor)
        && Objects.equal(hp, other.hp)
        && Objects.equal(hpregenperlevel, other.hpregenperlevel)
        && Objects.equal(spellblock, other.spellblock)
        && Objects.equal(attackrange, other.attackrange)
        && Objects.equal(movespeed, other.movespeed)
        && Objects.equal(attackdamageperlevel, other.attackdamageperlevel)
        && Objects.equal(mpregenperlevel, other.mpregenperlevel)
        && Objects.equal(mp, other.mp)
        && Objects.equal(spellblockperlevel, other.spellblockperlevel)
        && Objects.equal(crit, other.crit)
        && Objects.equal(mpregen, other.mpregen)
        && Objects.equal(attackspeedperlevel, other.attackspeedperlevel)
        && Objects.equal(hpregen, other.hpregen)
        && Objects.equal(critperlevel, other.critperlevel);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        armorperlevel,
        hpperlevel,
        attackdamage,
        mpperlevel,
        attackspeedoffset,
        armor,
        hp,
        hpregenperlevel,
        spellblock,
        attackrange,
        movespeed,
        attackdamageperlevel,
        mpregenperlevel,
        mp,
        spellblockperlevel,
        crit,
        mpregen,
        attackspeedperlevel,
        hpregen,
        critperlevel);}
}
