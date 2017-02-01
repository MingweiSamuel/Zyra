package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Passive - This object contains champion passive data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
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
