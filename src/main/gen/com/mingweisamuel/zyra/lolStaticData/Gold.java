package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;

/**
 * Gold - This object contains item gold data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class Gold {
  public final int base;

  public final boolean purchasable;

  public final int sell;

  public final int total;

  public Gold(final int base, final boolean purchasable, final int sell, final int total) {
    this.base = base;
    this.purchasable = purchasable;
    this.sell = sell;
    this.total = total;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Gold)) return false;
    final Gold other = (Gold) obj;
    return true
        && Objects.equal(base, other.base)
        && Objects.equal(purchasable, other.purchasable)
        && Objects.equal(sell, other.sell)
        && Objects.equal(total, other.total);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        base,
        purchasable,
        sell,
        total);}
}
