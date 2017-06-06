package com.mingweisamuel.zyra.champion;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * Champion.<br><br>
 *
 * This object contains champion information..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#champion-v3/GET_getChampions">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class Champion implements Serializable {
  /**
   * Ranked play enabled flag. */
  public final boolean rankedPlayEnabled;

  /**
   * Bot enabled flag (for custom games). */
  public final boolean botEnabled;

  /**
   * Bot Match Made enabled flag (for Co-op vs. AI games). */
  public final boolean botMmEnabled;

  /**
   * Indicates if the champion is active. */
  public final boolean active;

  /**
   * Indicates if the champion is free to play. Free to play champions are rotated periodically. */
  public final boolean freeToPlay;

  /**
   * Champion ID. For static information correlating to champion IDs, please refer to the LoL Static Data API. */
  public final long id;

  public Champion(final boolean rankedPlayEnabled, final boolean botEnabled,
      final boolean botMmEnabled, final boolean active, final boolean freeToPlay, final long id) {
    this.rankedPlayEnabled = rankedPlayEnabled;
    this.botEnabled = botEnabled;
    this.botMmEnabled = botMmEnabled;
    this.active = active;
    this.freeToPlay = freeToPlay;
    this.id = id;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Champion)) return false;
    final Champion other = (Champion) obj;
    return true
        && Objects.equal(rankedPlayEnabled, other.rankedPlayEnabled)
        && Objects.equal(botEnabled, other.botEnabled)
        && Objects.equal(botMmEnabled, other.botMmEnabled)
        && Objects.equal(active, other.active)
        && Objects.equal(freeToPlay, other.freeToPlay)
        && Objects.equal(id, other.id);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        rankedPlayEnabled,
        botEnabled,
        botMmEnabled,
        active,
        freeToPlay,
        id);}
}
