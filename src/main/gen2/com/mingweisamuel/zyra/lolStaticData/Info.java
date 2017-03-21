package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains champion information..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getChampionList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Info {
  public final int difficulty;

  public final int attack;

  public final int defense;

  public final int magic;

  public Info(final int difficulty, final int attack, final int defense, final int magic) {
    this.difficulty = difficulty;
    this.attack = attack;
    this.defense = defense;
    this.magic = magic;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(difficulty, other.difficulty)
        && Objects.equal(attack, other.attack)
        && Objects.equal(defense, other.defense)
        && Objects.equal(magic, other.magic);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        difficulty,
        attack,
        defense,
        magic);}
}
