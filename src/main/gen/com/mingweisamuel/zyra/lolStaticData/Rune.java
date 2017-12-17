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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Rune implements Serializable {
  public final String description;

  public final int id;

  public final Image image;

  public final String name;

  public final MetaData rune;

  public final String sanitizedDescription;

  public final RuneStats stats;

  public final List<String> tags;

  public Rune(final String description, final int id, final Image image, final String name,
      final MetaData rune, final String sanitizedDescription, final RuneStats stats,
      final List<String> tags) {
    this.description = description;
    this.id = id;
    this.image = image;
    this.name = name;
    this.rune = rune;
    this.sanitizedDescription = sanitizedDescription;
    this.stats = stats;
    this.tags = tags;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Rune)) return false;
    final Rune other = (Rune) obj;
    return true
        && Objects.equal(description, other.description)
        && Objects.equal(id, other.id)
        && Objects.equal(image, other.image)
        && Objects.equal(name, other.name)
        && Objects.equal(rune, other.rune)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(stats, other.stats)
        && Objects.equal(tags, other.tags);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        description,
        id,
        image,
        name,
        rune,
        sanitizedDescription,
        stats,
        tags);}
}
