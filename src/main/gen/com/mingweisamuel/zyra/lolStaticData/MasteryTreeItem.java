package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * MasteryTreeItem - This object contains mastery tree item data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class MasteryTreeItem implements Serializable {
  public final int masteryId;

  public final String prereq;

  public MasteryTreeItem(final int masteryId, final String prereq) {
    this.masteryId = masteryId;
    this.prereq = prereq;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MasteryTreeItem)) return false;
    final MasteryTreeItem other = (MasteryTreeItem) obj;
    return true
        && Objects.equal(masteryId, other.masteryId)
        && Objects.equal(prereq, other.prereq);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        masteryId,
        prereq);}
}
