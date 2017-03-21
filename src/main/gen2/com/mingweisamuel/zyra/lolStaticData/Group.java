package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * This object contains item group data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getItemList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Group {
  public final String MaxGroupOwnable;

  public final String key;

  public Group(final String MaxGroupOwnable, final String key) {
    this.MaxGroupOwnable = MaxGroupOwnable;
    this.key = key;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(MaxGroupOwnable, other.MaxGroupOwnable)
        && Objects.equal(key, other.key);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        MaxGroupOwnable,
        key);}
}
