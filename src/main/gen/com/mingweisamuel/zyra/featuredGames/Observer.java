package com.mingweisamuel.zyra.featuredGames;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Observer
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version featured-games-v1.0 */
public class Observer implements Serializable {
  /**
   * Key used to decrypt the spectator grid game data for playback */
  public final String encryptionKey;

  public Observer(final String encryptionKey) {
    this.encryptionKey = encryptionKey;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Observer)) return false;
    final Observer other = (Observer) obj;
    return true
        && Objects.equal(encryptionKey, other.encryptionKey);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        encryptionKey);}
}
