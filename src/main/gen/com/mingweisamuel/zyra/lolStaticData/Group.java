package com.mingweisamuel.zyra.lolStaticData;

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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
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
