package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * MasteryTreeItem.<br><br>
 *
 * This object contains mastery tree item data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
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
