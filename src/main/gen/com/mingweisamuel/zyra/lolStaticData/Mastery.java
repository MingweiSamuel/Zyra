package com.mingweisamuel.zyra.lolStaticData;

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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Mastery implements Serializable {
  public final List<String> description;

  public final int id;

  public final Image image;

  /**
   * (Legal values:  Cunning,  Ferocity,  Resolve) */
  public final String masteryTree;

  public final String name;

  public final String prereq;

  public final int ranks;

  public final List<String> sanitizedDescription;

  public Mastery(final List<String> description, final int id, final Image image,
      final String masteryTree, final String name, final String prereq, final int ranks,
      final List<String> sanitizedDescription) {
    this.description = description;
    this.id = id;
    this.image = image;
    this.masteryTree = masteryTree;
    this.name = name;
    this.prereq = prereq;
    this.ranks = ranks;
    this.sanitizedDescription = sanitizedDescription;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Mastery)) return false;
    final Mastery other = (Mastery) obj;
    return true
        && Objects.equal(description, other.description)
        && Objects.equal(id, other.id)
        && Objects.equal(image, other.image)
        && Objects.equal(masteryTree, other.masteryTree)
        && Objects.equal(name, other.name)
        && Objects.equal(prereq, other.prereq)
        && Objects.equal(ranks, other.ranks)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        description,
        id,
        image,
        masteryTree,
        name,
        prereq,
        ranks,
        sanitizedDescription);}
}
