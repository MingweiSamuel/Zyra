package com.mingweisamuel.zyra.featuredGames;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Observer.<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#featured-games-v1.0/GET_getFeaturedGames">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
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
