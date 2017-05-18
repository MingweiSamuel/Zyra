package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Info.<br><br>
 *
 * This object contains champion information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getChampionList">Riot API reference</a> on Wed May 17 19:48:11 PDT 2017. */
public class Info implements Serializable {
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
    if (!(obj instanceof Info)) return false;
    final Info other = (Info) obj;
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
