package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * BlockItem - This object contains champion recommended block item data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class BlockItem implements Serializable {
  public final int count;

  public final int id;

  public BlockItem(final int count, final int id) {
    this.count = count;
    this.id = id;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof BlockItem)) return false;
    final BlockItem other = (BlockItem) obj;
    return true
        && Objects.equal(count, other.count)
        && Objects.equal(id, other.id);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        count,
        id);}
}
