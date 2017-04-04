package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Skin.<br><br>
 *
 * This object contains champion skin data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getChampionList">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class Skin implements Serializable {
  public final int num;

  public final int id;

  public final String name;

  public Skin(final int num, final int id, final String name) {
    this.num = num;
    this.id = id;
    this.name = name;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Skin)) return false;
    final Skin other = (Skin) obj;
    return true
        && Objects.equal(num, other.num)
        && Objects.equal(id, other.id)
        && Objects.equal(name, other.name);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        num,
        id,
        name);}
}
