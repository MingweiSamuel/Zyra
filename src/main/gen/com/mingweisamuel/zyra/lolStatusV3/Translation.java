package com.mingweisamuel.zyra.lolStatusV3;

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

  public final String heading;

  public final String locale;

  public Translation(final String content, final String heading, final String locale) {
    this.content = content;
    this.heading = heading;
    this.locale = locale;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Translation)) return false;
    final Translation other = (Translation) obj;
    return true
        && Objects.equal(content, other.content)
        && Objects.equal(heading, other.heading)
        && Objects.equal(locale, other.locale);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        content,
        heading,
        locale);}
}
