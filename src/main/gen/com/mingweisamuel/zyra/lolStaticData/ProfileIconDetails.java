package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * ProfileIconDetails.<br><br>
 *
 * This object contains profile icon details data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ProfileIconDetails implements Serializable {
  public final long id;

  public final Image image;

  public ProfileIconDetails(final long id, final Image image) {
    this.id = id;
    this.image = image;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ProfileIconDetails)) return false;
    final ProfileIconDetails other = (ProfileIconDetails) obj;
    return true
        && Objects.equal(id, other.id)
        && Objects.equal(image, other.image);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        id,
        image);}
}
