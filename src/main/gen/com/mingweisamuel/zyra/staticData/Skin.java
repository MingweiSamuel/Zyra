package com.mingweisamuel.zyra.staticData;

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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getChampionList">Riot API reference</a> on Tue May 16 20:00:39 PDT 2017. */
public class Skin implements Serializable {
  public final int num;

  public final String name;

  public final int id;

  public Skin(final int num, final String name, final int id) {
    this.num = num;
    this.name = name;
    this.id = id;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Skin)) return false;
    final Skin other = (Skin) obj;
    return true
        && Objects.equal(num, other.num)
        && Objects.equal(name, other.name)
        && Objects.equal(id, other.id);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        num,
        name,
        id);}
}
