package com.mingweisamuel.zyra.spectator;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * GameCustomizationObject.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class GameCustomizationObject implements Serializable {
  /**
   * Category identifier for Game Customization */
  public final String category;

  /**
   * Game Customization content */
  public final String content;

  public GameCustomizationObject(final String category, final String content) {
    this.category = category;
    this.content = content;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof GameCustomizationObject)) return false;
    final GameCustomizationObject other = (GameCustomizationObject) obj;
    return true
        && Objects.equal(category, other.category)
        && Objects.equal(content, other.content);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        category,
        content);}
}
