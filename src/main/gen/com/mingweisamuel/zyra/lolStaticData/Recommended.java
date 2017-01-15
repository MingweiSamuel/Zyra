package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Recommended - This object contains champion recommended data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class Recommended {
  public final List<Block> blocks;

  public final String champion;

  public final String map;

  public final String mode;

  public final boolean priority;

  public final String title;

  public final String type;

  public Recommended(final List<Block> blocks, final String champion, final String map,
      final String mode, final boolean priority, final String title, final String type) {
    this.blocks = blocks;
    this.champion = champion;
    this.map = map;
    this.mode = mode;
    this.priority = priority;
    this.title = title;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Recommended)) return false;
    final Recommended other = (Recommended) obj;
    return true
        && Objects.equal(blocks, other.blocks)
        && Objects.equal(champion, other.champion)
        && Objects.equal(map, other.map)
        && Objects.equal(mode, other.mode)
        && Objects.equal(priority, other.priority)
        && Objects.equal(title, other.title)
        && Objects.equal(type, other.type);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        blocks,
        champion,
        map,
        mode,
        priority,
        title,
        type);}
}
