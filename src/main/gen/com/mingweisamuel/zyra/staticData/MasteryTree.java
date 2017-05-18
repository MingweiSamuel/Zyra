package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * MasteryTree.<br><br>
 *
 * This object contains mastery tree data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getMasteryList">Riot API reference</a> on Wed May 17 21:53:10 PDT 2017. */
public class MasteryTree implements Serializable {
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
    if (!(obj instanceof MasteryTree)) return false;
    final MasteryTree other = (MasteryTree) obj;
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
