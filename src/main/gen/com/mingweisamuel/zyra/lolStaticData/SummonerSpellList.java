package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * SummonerSpellList.<br><br>
 *
 * This object contains summoner spell list data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getSummonerSpellList">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class SummonerSpellList implements Serializable {
  public final Map<Integer, SummonerSpell> data;

  public final String version;

  public final String type;

  public SummonerSpellList(final Map<Integer, SummonerSpell> data, final String version,
      final String type) {
    this.data = data;
    this.version = version;
    this.type = type;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof SummonerSpellList)) return false;
    final SummonerSpellList other = (SummonerSpellList) obj;
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
