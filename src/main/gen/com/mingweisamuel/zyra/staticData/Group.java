package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Group.<br><br>
 *
 * This object contains item group data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getItemList">Riot API reference</a> on Wed May 17 19:48:11 PDT 2017. */
public class Group implements Serializable {
  public final String MaxGroupOwnable;

  public final String key;

  public Group(final String MaxGroupOwnable, final String key) {
    this.MaxGroupOwnable = MaxGroupOwnable;
    this.key = key;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Group)) return false;
    final Group other = (Group) obj;
    return true
        && Objects.equal(MaxGroupOwnable, other.MaxGroupOwnable)
        && Objects.equal(key, other.key);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        MaxGroupOwnable,
        key);}
}
