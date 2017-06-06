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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class ItemList implements Serializable {
  public final Map<Integer, Item> data;

  public final String version;

  public final List<ItemTree> tree;

  public final List<Group> groups;

  public final String type;

  public ItemList(final Map<Integer, Item> data, final String version, final List<ItemTree> tree,
      final List<Group> groups, final String type) {
    this.data = data;
    this.version = version;
    this.tree = tree;
    this.groups = groups;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ItemList)) return false;
    final ItemList other = (ItemList) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(version, other.version)
        && Objects.equal(tree, other.tree)
        && Objects.equal(groups, other.groups)
        && Objects.equal(type, other.type);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        version,
        tree,
        groups,
        type);}
}
