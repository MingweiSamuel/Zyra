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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class ProfileIconDetails implements Serializable {
  public final Image image;

  public final long id;

  public ProfileIconDetails(final Image image, final long id) {
    this.image = image;
    this.id = id;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ProfileIconDetails)) return false;
    final ProfileIconDetails other = (ProfileIconDetails) obj;
    return true
        && Objects.equal(image, other.image)
        && Objects.equal(id, other.id);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        image,
        id);}
}
