package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * RuneList.<br><br>
 *
 * This object contains rune list data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getRuneList">Riot API reference</a> on Wed May 17 21:53:10 PDT 2017. */
public class RuneList implements Serializable {
  public final Map<Integer, Rune> data;

  public final String version;

  public final String type;

  public final BasicData basic;

  public RuneList(final Map<Integer, Rune> data, final String version, final String type,
      final BasicData basic) {
    this.data = data;
    this.version = version;
    this.type = type;
    this.basic = basic;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof RuneList)) return false;
    final RuneList other = (RuneList) obj;
    return true
        && Objects.equal(data, other.data)
        && Objects.equal(version, other.version)
        && Objects.equal(type, other.type)
        && Objects.equal(basic, other.basic);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        data,
        version,
        type,
        basic);}
}
