package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Mastery.<br><br>
 *
 * This object contains mastery data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getMasteryList">Riot API reference</a> on Tue May 23 09:10:03 PDT 2017. */
public class Mastery implements Serializable {
  public final String prereq;

  /**
   * (Legal values: Cunning, Ferocity, Resolve) */
  public final String masteryTree;

  public final String name;

  public final int ranks;

  public final Image image;

  public final List<String> sanitizedDescription;

  public final int id;

  public final List<String> description;

  public Mastery(final String prereq, final String masteryTree, final String name, final int ranks,
      final Image image, final List<String> sanitizedDescription, final int id,
      final List<String> description) {
    this.prereq = prereq;
    this.masteryTree = masteryTree;
    this.name = name;
    this.ranks = ranks;
    this.image = image;
    this.sanitizedDescription = sanitizedDescription;
    this.id = id;
    this.description = description;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Mastery)) return false;
    final Mastery other = (Mastery) obj;
    return true
        && Objects.equal(prereq, other.prereq)
        && Objects.equal(masteryTree, other.masteryTree)
        && Objects.equal(name, other.name)
        && Objects.equal(ranks, other.ranks)
        && Objects.equal(image, other.image)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(id, other.id)
        && Objects.equal(description, other.description);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        prereq,
        masteryTree,
        name,
        ranks,
        image,
        sanitizedDescription,
        id,
        description);}
}
