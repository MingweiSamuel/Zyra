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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Passive implements Serializable {
  public final String description;

  public final Image image;

  public final String name;

  public final String sanitizedDescription;

  public Passive(final String description, final Image image, final String name,
      final String sanitizedDescription) {
    this.description = description;
    this.image = image;
    this.name = name;
    this.sanitizedDescription = sanitizedDescription;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Passive)) return false;
    final Passive other = (Passive) obj;
    return true
        && Objects.equal(description, other.description)
        && Objects.equal(image, other.image)
        && Objects.equal(name, other.name)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        description,
        image,
        name,
        sanitizedDescription);}
}
