package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * This object contains mastery tree item data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getMasteryList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class MasteryTreeItem {
  public final int masteryId;

  public final String prereq;

  public MasteryTreeItem(final int masteryId, final String prereq) {
    this.masteryId = masteryId;
    this.prereq = prereq;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(masteryId, other.masteryId)
        && Objects.equal(prereq, other.prereq);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        masteryId,
        prereq);}
}
