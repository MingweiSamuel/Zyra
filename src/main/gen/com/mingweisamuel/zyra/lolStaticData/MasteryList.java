package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * MasteryList.<br><br>
 *
 * This object contains mastery list data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getMasteryList">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class MasteryList implements Serializable {
  public final Map<Integer, Mastery> data;

  public final String version;

  public final MasteryTree tree;

  public final String type;

  public MasteryList(final Map<Integer, Mastery> data, final String version, final MasteryTree tree,
      final String type) {
    this.data = data;
    this.version = version;
    this.tree = tree;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MasteryList)) return false;
    final MasteryList other = (MasteryList) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(version, other.version)
        && Objects.equal(tree, other.tree)
        && Objects.equal(type, other.type);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        version,
        tree,
        type);}
}
