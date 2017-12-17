package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;

/**
 * ItemList.<br><br>
 *
 * This object contains item list data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ItemList implements Serializable {
  public final Map<Integer, Item> data;

  public final List<Group> groups;

  public final List<ItemTree> tree;

  public final String type;

  public final String version;

  public ItemList(final Map<Integer, Item> data, final List<Group> groups,
      final List<ItemTree> tree, final String type, final String version) {
    this.data = data;
    this.groups = groups;
    this.tree = tree;
    this.type = type;
    this.version = version;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ItemList)) return false;
    final ItemList other = (ItemList) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(groups, other.groups)
        && Objects.equal(tree, other.tree)
        && Objects.equal(type, other.type)
        && Objects.equal(version, other.version);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        groups,
        tree,
        type,
        version);}
}
