package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Group - This object contains item group data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class Group {
  public final String MaxGroupOwnable;

  public final String key;

  public Group(final String MaxGroupOwnable, final String key) {
    this.MaxGroupOwnable = MaxGroupOwnable;
    this.key = key;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
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
