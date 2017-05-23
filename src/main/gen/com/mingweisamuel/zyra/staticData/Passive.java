package com.mingweisamuel.zyra.staticData;

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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getChampionList">Riot API reference</a> on Tue May 23 09:10:03 PDT 2017. */
public class Passive implements Serializable {
  public final Image image;

  public final String sanitizedDescription;

  public final String name;

  public final String description;

  public Passive(final Image image, final String sanitizedDescription, final String name,
      final String description) {
    this.image = image;
    this.sanitizedDescription = sanitizedDescription;
    this.name = name;
    this.description = description;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Passive)) return false;
    final Passive other = (Passive) obj;
    return true
        && Objects.equal(image, other.image)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(name, other.name)
        && Objects.equal(description, other.description);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        image,
        sanitizedDescription,
        name,
        description);}
}
