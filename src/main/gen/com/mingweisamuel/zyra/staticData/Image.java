package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Image.<br><br>
 *
 * This object contains image data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getChampionList">Riot API reference</a> on Wed May 17 21:34:50 PDT 2017. */
public class Image implements Serializable {
  public final String full;

  public final String group;

  public final String sprite;

  public final int h;

  public final int w;

  public final int y;

  public final int x;

  public Image(final String full, final String group, final String sprite, final int h, final int w,
      final int y, final int x) {
    this.full = full;
    this.group = group;
    this.sprite = sprite;
    this.h = h;
    this.w = w;
    this.y = y;
    this.x = x;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Image)) return false;
    final Image other = (Image) obj;
    return true
        && Objects.equal(full, other.full)
        && Objects.equal(group, other.group)
        && Objects.equal(sprite, other.sprite)
        && Objects.equal(h, other.h)
        && Objects.equal(w, other.w)
        && Objects.equal(y, other.y)
        && Objects.equal(x, other.x);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        full,
        group,
        sprite,
        h,
        w,
        y,
        x);}
}
