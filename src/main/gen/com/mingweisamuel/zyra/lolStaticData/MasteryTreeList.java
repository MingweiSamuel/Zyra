package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * MasteryTreeList - This object contains mastery tree list data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class MasteryTreeList {
  public final List<MasteryTreeItem> masteryTreeItems;

  public MasteryTreeList(final List<MasteryTreeItem> masteryTreeItems) {
    this.masteryTreeItems = masteryTreeItems;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == null) return false;
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
