package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * MasteryList - This object contains mastery list data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class MasteryList {
  public final Map<Integer, Mastery> data;

  public final MasteryTree tree;

  public final String type;

  public final String version;

  public MasteryList(final Map<Integer, Mastery> data, final MasteryTree tree, final String type,
      final String version) {
    this.data = data;
    this.tree = tree;
    this.type = type;
    this.version = version;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof MasteryList)) return false;
    final MasteryList other = (MasteryList) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(tree, other.tree)
        && Objects.equal(type, other.type)
        && Objects.equal(version, other.version);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        tree,
        type,
        version);}
}
