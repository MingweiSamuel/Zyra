package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * This object contains mastery tree data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getMasteryList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class MasteryTree {
  public final List<MasteryTreeList> Resolve;

  public final List<MasteryTreeList> Ferocity;

  public final List<MasteryTreeList> Cunning;

  public MasteryTree(final List<MasteryTreeList> Resolve, final List<MasteryTreeList> Ferocity,
      final List<MasteryTreeList> Cunning) {
    this.Resolve = Resolve;
    this.Ferocity = Ferocity;
    this.Cunning = Cunning;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(Resolve, other.Resolve)
        && Objects.equal(Ferocity, other.Ferocity)
        && Objects.equal(Cunning, other.Cunning);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        Resolve,
        Ferocity,
        Cunning);}
}
