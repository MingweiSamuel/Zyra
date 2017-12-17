package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Translation.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Translation implements Serializable {
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
    if (!(obj instanceof Translation)) return false;
    final Translation other = (Translation) obj;
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
