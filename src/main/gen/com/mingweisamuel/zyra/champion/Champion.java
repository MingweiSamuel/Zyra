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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Champion implements Serializable {
  /**
   * Indicates if the champion is active. */
  public final boolean active;

  /**
   * Bot enabled flag (for custom games). */
  public final boolean botEnabled;

  /**
   * Bot Match Made enabled flag (for Co-op vs. AI games). */
  public final boolean botMmEnabled;

  /**
   * Indicates if the champion is free to play. Free to play champions are rotated periodically. */
  public final boolean freeToPlay;

  /**
   * Champion ID. For static information correlating to champion IDs, please refer to the LoL Static Data API. */
  public final long id;

  /**
   * Ranked play enabled flag. */
  public final boolean rankedPlayEnabled;

  public Champion(final boolean active, final boolean botEnabled, final boolean botMmEnabled,
      final boolean freeToPlay, final long id, final boolean rankedPlayEnabled) {
    this.active = active;
    this.botEnabled = botEnabled;
    this.botMmEnabled = botMmEnabled;
    this.freeToPlay = freeToPlay;
    this.id = id;
    this.rankedPlayEnabled = rankedPlayEnabled;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Champion)) return false;
    final Champion other = (Champion) obj;
    return true
        && Objects.equal(active, other.active)
        && Objects.equal(botEnabled, other.botEnabled)
        && Objects.equal(botMmEnabled, other.botMmEnabled)
        && Objects.equal(freeToPlay, other.freeToPlay)
        && Objects.equal(id, other.id)
        && Objects.equal(rankedPlayEnabled, other.rankedPlayEnabled);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        active,
        botEnabled,
        botMmEnabled,
        freeToPlay,
        id,
        rankedPlayEnabled);}
}
