package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Info.<br><br>
 *
 * This object contains champion information..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Info implements Serializable {
  public final int attack;

  public final int defense;

  public final int difficulty;

  public final int magic;

  public Info(final int attack, final int defense, final int difficulty, final int magic) {
    this.attack = attack;
    this.defense = defense;
    this.difficulty = difficulty;
    this.magic = magic;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Info)) return false;
    final Info other = (Info) obj;
    return true
        && Objects.equal(attack, other.attack)
        && Objects.equal(defense, other.defense)
        && Objects.equal(difficulty, other.difficulty)
        && Objects.equal(magic, other.magic);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        attack,
        defense,
        difficulty,
        magic);}
}
