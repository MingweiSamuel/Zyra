package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * LanguageStrings.<br><br>
 *
 * This object contains language strings data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getLanguageStrings">Riot API reference</a> on Wed May 17 21:53:10 PDT 2017. */
public class LanguageStrings implements Serializable {
  public final Map<String, String> data;

  public final String version;

  public final String type;

  public LanguageStrings(final Map<String, String> data, final String version, final String type) {
    this.data = data;
    this.version = version;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LanguageStrings)) return false;
    final LanguageStrings other = (LanguageStrings) obj;
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
