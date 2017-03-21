package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * This object contains mastery list data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getMasteryList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class MasteryList {
  public final MasteryTree tree;

  public final String version;

  public final Map<Integer, Mastery> data;

  public final String type;

  public MasteryList(final MasteryTree tree, final String version, final Map<Integer, Mastery> data,
      final String type) {
    this.tree = tree;
    this.version = version;
    this.data = data;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(tree, other.tree)
        && Objects.equal(version, other.version)
        && Objects.equal(data, other.data)
        && Objects.equal(type, other.type);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        tree,
        version,
        data,
        type);}
}
