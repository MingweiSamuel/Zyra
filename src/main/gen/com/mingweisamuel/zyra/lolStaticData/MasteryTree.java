package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * MasteryTree - This object contains mastery tree data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class MasteryTree implements Serializable {
  public final List<MasteryTreeList> Cunning;

  public final List<MasteryTreeList> Ferocity;

  public final List<MasteryTreeList> Resolve;

  public MasteryTree(final List<MasteryTreeList> Cunning, final List<MasteryTreeList> Ferocity,
      final List<MasteryTreeList> Resolve) {
    this.Cunning = Cunning;
    this.Ferocity = Ferocity;
    this.Resolve = Resolve;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MasteryTree)) return false;
    final MasteryTree other = (MasteryTree) obj;
    return true
        && Objects.equal(Cunning, other.Cunning)
        && Objects.equal(Ferocity, other.Ferocity)
        && Objects.equal(Resolve, other.Resolve);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        Cunning,
        Ferocity,
        Resolve);}
}
