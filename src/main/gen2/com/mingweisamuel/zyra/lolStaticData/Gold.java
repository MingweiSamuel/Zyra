package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * This object contains item gold data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getItemList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Gold {
  public final int sell;

  public final int total;

  public final int base;

  public final boolean purchasable;

  public Gold(final int sell, final int total, final int base, final boolean purchasable) {
    this.sell = sell;
    this.total = total;
    this.base = base;
    this.purchasable = purchasable;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(sell, other.sell)
        && Objects.equal(total, other.total)
        && Objects.equal(base, other.base)
        && Objects.equal(purchasable, other.purchasable);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        sell,
        total,
        base,
        purchasable);}
}
