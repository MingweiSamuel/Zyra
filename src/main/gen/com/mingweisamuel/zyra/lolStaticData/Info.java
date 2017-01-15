package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * Info - This object contains champion information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class Info {
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
    if (obj == null) return false;
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
