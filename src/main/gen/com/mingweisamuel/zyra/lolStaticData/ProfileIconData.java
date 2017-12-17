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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ProfileIconData implements Serializable {
  public final Map<Long, ProfileIconDetails> data;

  public final String type;

  public final String version;

  public ProfileIconData(final Map<Long, ProfileIconDetails> data, final String type,
      final String version) {
    this.data = data;
    this.type = type;
    this.version = version;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ProfileIconData)) return false;
    final ProfileIconData other = (ProfileIconData) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(type, other.type)
        && Objects.equal(version, other.version);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        type,
        version);}
}
