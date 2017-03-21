package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * This object contains champion recommended data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getChampionList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Recommended {
  public final String map;

  public final List<Block> blocks;

  public final String champion;

  public final String title;

  public final boolean priority;

  public final String mode;

  public final String type;

  public Recommended(final String map, final List<Block> blocks, final String champion,
      final String title, final boolean priority, final String mode, final String type) {
    this.map = map;
    this.blocks = blocks;
    this.champion = champion;
    this.title = title;
    this.priority = priority;
    this.mode = mode;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(map, other.map)
        && Objects.equal(blocks, other.blocks)
        && Objects.equal(champion, other.champion)
        && Objects.equal(title, other.title)
        && Objects.equal(priority, other.priority)
        && Objects.equal(mode, other.mode)
        && Objects.equal(type, other.type);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        map,
        blocks,
        champion,
        title,
        priority,
        mode,
        type);}
}
