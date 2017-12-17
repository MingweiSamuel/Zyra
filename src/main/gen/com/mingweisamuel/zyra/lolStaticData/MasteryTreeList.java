package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * MasteryTreeList.<br><br>
 *
 * This object contains mastery tree list data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class MasteryTreeList implements Serializable {
  public final List<MasteryTreeItem> masteryTreeItems;

  public MasteryTreeList(final List<MasteryTreeItem> masteryTreeItems) {
    this.masteryTreeItems = masteryTreeItems;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MasteryTreeList)) return false;
    final MasteryTreeList other = (MasteryTreeList) obj;
    return true
        && Objects.equal(masteryTreeItems, other.masteryTreeItems);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        masteryTreeItems);}
}
