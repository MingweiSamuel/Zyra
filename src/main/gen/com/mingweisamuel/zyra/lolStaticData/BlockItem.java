package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * BlockItem.<br><br>
 *
 * This object contains champion recommended block item data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
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
