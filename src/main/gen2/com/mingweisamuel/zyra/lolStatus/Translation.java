package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * .<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-status-v1.0/GET_getShardStatus">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class Translation {
  public final String content;

  public final String locale;

  public final String updated_at;

  public Translation(final String content, final String locale, final String updated_at) {
    this.content = content;
    this.locale = locale;
    this.updated_at = updated_at;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStatus)) return false;
    final LolStatus other = (LolStatus) obj;
    return true
        && Objects.equal(content, other.content)
        && Objects.equal(locale, other.locale)
        && Objects.equal(updated_at, other.updated_at);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        content,
        locale,
        updated_at);}
}
