package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * ProfileIconData.<br><br>
 *
 * This object contains profile icon data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getProfileIcons">Riot API reference</a>. */
public class ProfileIconData implements Serializable {
  public final Map<Long, ProfileIconDetails> data;

  public final String version;

  public final String type;

  public ProfileIconData(final Map<Long, ProfileIconDetails> data, final String version,
      final String type) {
    this.data = data;
    this.version = version;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ProfileIconData)) return false;
    final ProfileIconData other = (ProfileIconData) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(version, other.version)
        && Objects.equal(type, other.type);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        version,
        type);}
}
