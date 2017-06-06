package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Rune.<br><br>
 *
 * This object contains rune data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getRuneList">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class Rune implements Serializable {
  public final RuneStats stats;

  public final String name;

  public final List<String> tags;

  public final Image image;

  public final String sanitizedDescription;

  public final MetaData rune;

  public final int id;

  public final String description;

  public Rune(final RuneStats stats, final String name, final List<String> tags, final Image image,
      final String sanitizedDescription, final MetaData rune, final int id,
      final String description) {
    this.stats = stats;
    this.name = name;
    this.tags = tags;
    this.image = image;
    this.sanitizedDescription = sanitizedDescription;
    this.rune = rune;
    this.id = id;
    this.description = description;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Rune)) return false;
    final Rune other = (Rune) obj;
    return true
        && Objects.equal(stats, other.stats)
        && Objects.equal(name, other.name)
        && Objects.equal(tags, other.tags)
        && Objects.equal(image, other.image)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(rune, other.rune)
        && Objects.equal(id, other.id)
        && Objects.equal(description, other.description);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        stats,
        name,
        tags,
        image,
        sanitizedDescription,
        rune,
        id,
        description);}
}
