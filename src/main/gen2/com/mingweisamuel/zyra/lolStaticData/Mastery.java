package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * This object contains mastery data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getMasteryList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Mastery {
  public final String prereq;

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
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
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
