package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains champion stats data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getChampionList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Stats {
  public final double armorperlevel;

  public final double hpperlevel;

  public final double attackdamage;

  public final double mpperlevel;

  public final double attackspeedoffset;

  public final double armor;

  public final double hp;

  public final double hpregenperlevel;

  public final double attackspeedperlevel;

  public final double attackrange;

  public final double movespeed;

  public final double attackdamageperlevel;

  public final double mpregenperlevel;

  public final double mp;

  public final double spellblockperlevel;

  public final double crit;

  public final double mpregen;

  public final double spellblock;

  public final double hpregen;

  public final double critperlevel;

  public Stats(final double armorperlevel, final double hpperlevel, final double attackdamage,
      final double mpperlevel, final double attackspeedoffset, final double armor, final double hp,
      final double hpregenperlevel, final double attackspeedperlevel, final double attackrange,
      final double movespeed, final double attackdamageperlevel, final double mpregenperlevel,
      final double mp, final double spellblockperlevel, final double crit, final double mpregen,
      final double spellblock, final double hpregen, final double critperlevel) {
    this.armorperlevel = armorperlevel;
    this.hpperlevel = hpperlevel;
    this.attackdamage = attackdamage;
    this.mpperlevel = mpperlevel;
    this.attackspeedoffset = attackspeedoffset;
    this.armor = armor;
    this.hp = hp;
    this.hpregenperlevel = hpregenperlevel;
    this.attackspeedperlevel = attackspeedperlevel;
    this.attackrange = attackrange;
    this.movespeed = movespeed;
    this.attackdamageperlevel = attackdamageperlevel;
    this.mpregenperlevel = mpregenperlevel;
    this.mp = mp;
    this.spellblockperlevel = spellblockperlevel;
    this.crit = crit;
    this.mpregen = mpregen;
    this.spellblock = spellblock;
    this.hpregen = hpregen;
    this.critperlevel = critperlevel;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(armorperlevel, other.armorperlevel)
        && Objects.equal(hpperlevel, other.hpperlevel)
        && Objects.equal(attackdamage, other.attackdamage)
        && Objects.equal(mpperlevel, other.mpperlevel)
        && Objects.equal(attackspeedoffset, other.attackspeedoffset)
        && Objects.equal(armor, other.armor)
        && Objects.equal(hp, other.hp)
        && Objects.equal(hpregenperlevel, other.hpregenperlevel)
        && Objects.equal(attackspeedperlevel, other.attackspeedperlevel)
        && Objects.equal(attackrange, other.attackrange)
        && Objects.equal(movespeed, other.movespeed)
        && Objects.equal(attackdamageperlevel, other.attackdamageperlevel)
        && Objects.equal(mpregenperlevel, other.mpregenperlevel)
        && Objects.equal(mp, other.mp)
        && Objects.equal(spellblockperlevel, other.spellblockperlevel)
        && Objects.equal(crit, other.crit)
        && Objects.equal(mpregen, other.mpregen)
        && Objects.equal(spellblock, other.spellblock)
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
        attackspeedperlevel,
        attackrange,
        movespeed,
        attackdamageperlevel,
        mpregenperlevel,
        mp,
        spellblockperlevel,
        crit,
        mpregen,
        spellblock,
        hpregen,
        critperlevel);}
}
