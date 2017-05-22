package com.mingweisamuel.zyra.staticData;

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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getMasteryList">Riot API reference</a> on Sun May 21 18:03:38 PDT 2017. */
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
