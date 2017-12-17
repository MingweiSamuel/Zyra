package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Block.<br><br>
 *
 * This object contains champion recommended block data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Block implements Serializable {
  public final List<BlockItem> items;

  public final boolean recMath;

  public final String type;

  public Block(final List<BlockItem> items, final boolean recMath, final String type) {
    this.items = items;
    this.recMath = recMath;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Block)) return false;
    final Block other = (Block) obj;
    return true
        && Objects.equal(items, other.items)
        && Objects.equal(recMath, other.recMath)
        && Objects.equal(type, other.type);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        items,
        recMath,
        type);}
}
