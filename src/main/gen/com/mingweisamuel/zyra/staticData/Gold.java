package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Gold.<br><br>
 *
 * This object contains item gold data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getItemList">Riot API reference</a> on Wed May 17 19:48:11 PDT 2017. */
public class Gold implements Serializable {
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
    if (!(obj instanceof Gold)) return false;
    final Gold other = (Gold) obj;
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
