package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Passive.<br><br>
 *
 * This object contains champion passive data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getChampionList">Riot API reference</a> on Mon May 15 17:36:46 PDT 2017. */
public class Passive implements Serializable {
  public final Image image;

  public final String sanitizedDescription;

  public final String description;

  public final String name;

  public Passive(final Image image, final String sanitizedDescription, final String description,
      final String name) {
    this.image = image;
    this.sanitizedDescription = sanitizedDescription;
    this.description = description;
    this.name = name;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Passive)) return false;
    final Passive other = (Passive) obj;
    return true
        && Objects.equal(image, other.image)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(description, other.description)
        && Objects.equal(name, other.name);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        image,
        sanitizedDescription,
        description,
        name);}
}
