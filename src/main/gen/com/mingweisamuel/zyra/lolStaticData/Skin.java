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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Skin implements Serializable {
  public final int id;

  public final String name;

  public final int num;

  public Skin(final int id, final String name, final int num) {
    this.id = id;
    this.name = name;
    this.num = num;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Skin)) return false;
    final Skin other = (Skin) obj;
    return true
        && Objects.equal(id, other.id)
        && Objects.equal(name, other.name)
        && Objects.equal(num, other.num);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        id,
        name,
        num);}
}
