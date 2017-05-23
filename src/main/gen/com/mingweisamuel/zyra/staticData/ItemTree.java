package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * ItemTree.<br><br>
 *
 * This object contains item tree data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getItemList">Riot API reference</a> on Tue May 23 09:10:03 PDT 2017. */
public class ItemTree implements Serializable {
  public final String header;

  public final List<String> tags;

  public ItemTree(final String header, final List<String> tags) {
    this.header = header;
    this.tags = tags;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ItemTree)) return false;
    final ItemTree other = (ItemTree) obj;
    return true
        && Objects.equal(header, other.header)
        && Objects.equal(tags, other.tags);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        header,
        tags);}
}
