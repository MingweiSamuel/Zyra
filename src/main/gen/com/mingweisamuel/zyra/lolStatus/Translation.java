package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Translation.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-status-v3/GET_getShardData">Riot API reference</a> on Tue May 23 09:10:03 PDT 2017. */
public class Translation implements Serializable {
  public final String locale;

  public final String content;

  public final String updated_at;

  public Translation(final String locale, final String content, final String updated_at) {
    this.locale = locale;
    this.content = content;
    this.updated_at = updated_at;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Translation)) return false;
    final Translation other = (Translation) obj;
    return true
        && Objects.equal(locale, other.locale)
        && Objects.equal(content, other.content)
        && Objects.equal(updated_at, other.updated_at);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        locale,
        content,
        updated_at);}
}
