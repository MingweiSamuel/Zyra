package com.mingweisamuel.zyra.runesMasteries;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * RunePages.<br /><br />
 *
 * This object contains rune pages information..<br /><br />
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#runes-masteries-v1.4/GET_getRunePagesBySummonerIds">Riot API reference</a> on Tue Mar 21 14:58:35 PDT 2017. */
public class RunePages implements Serializable {
  /**
   * Collection of rune pages associated with the summoner. */
  public final List<RunePage> pages;

  /**
   * Summoner ID. */
  public final long summonerId;

  public RunePages(final List<RunePage> pages, final long summonerId) {
    this.pages = pages;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof RunePages)) return false;
    final RunePages other = (RunePages) obj;
    return true
        && Objects.equal(pages, other.pages)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        pages,
        summonerId);}
}
