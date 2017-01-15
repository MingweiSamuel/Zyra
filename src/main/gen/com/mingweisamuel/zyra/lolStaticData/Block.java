package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Block - This object contains champion recommended block data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class Block {
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
    if (obj == null) return false;
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
