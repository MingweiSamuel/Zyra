package com.mingweisamuel.zyra.masteries;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.util.List;

/**
 * MasteryPages.<br><br>
 *
 * This object contains masteries information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#masteries-v3/GET_getMasteryPagesBySummonerId">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class MasteryPages implements Serializable {
  /**
   * Collection of mastery pages associated with the summoner. */
  public final List<MasteryPage> pages;

  /**
   * Summoner ID. */
  public final long summonerId;

  public MasteryPages(final List<MasteryPage> pages, final long summonerId) {
    this.pages = pages;
    this.summonerId = summonerId;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof MasteryPages)) return false;
    final MasteryPages other = (MasteryPages) obj;
    return true
        && Objects.equal(pages, other.pages)
        && Objects.equal(summonerId, other.summonerId);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        pages,
        summonerId);}
}
