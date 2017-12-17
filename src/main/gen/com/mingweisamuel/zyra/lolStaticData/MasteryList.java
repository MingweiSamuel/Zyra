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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class MasteryList implements Serializable {
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
