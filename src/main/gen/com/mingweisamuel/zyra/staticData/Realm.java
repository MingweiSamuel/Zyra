package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

/**
 * Realm.<br><br>
 *
 * This object contains realm data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getRealm">Riot API reference</a> on Tue May 23 09:10:03 PDT 2017. */
public class Realm implements Serializable {
  /**
   * Legacy script mode for IE6 or older. */
  public final String lg;

  /**
   * Latest changed version of Dragon Magic. */
  public final String dd;

  /**
   * Default language for this realm. */
  public final String l;

  /**
   * Latest changed version for each data type listed. */
  public final Map<String, String> n;

  /**
   * Special behavior number identifying the largest profileicon id that can be used under 500. Any profileicon that is requested between this number and 500 should be mapped to 0. */
  public final int profileiconmax;

  /**
   * Additional api data drawn from other sources that may be related to data dragon functionality. */
  public final String store;

  /**
   * Current version of this file for this realm. */
  public final String v;

  /**
   * The base CDN url. */
  public final String cdn;

  /**
   * Latest changed version of Dragon Magic's css file. */
  public final String css;

  public Realm(final String lg, final String dd, final String l, final Map<String, String> n,
      final int profileiconmax, final String store, final String v, final String cdn,
      final String css) {
    this.lg = lg;
    this.dd = dd;
    this.l = l;
    this.n = n;
    this.profileiconmax = profileiconmax;
    this.store = store;
    this.v = v;
    this.cdn = cdn;
    this.css = css;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Realm)) return false;
    final Realm other = (Realm) obj;
    return true
        && Objects.equal(lg, other.lg)
        && Objects.equal(dd, other.dd)
        && Objects.equal(l, other.l)
        && Objects.equal(n, other.n)
        && Objects.equal(profileiconmax, other.profileiconmax)
        && Objects.equal(store, other.store)
        && Objects.equal(v, other.v)
        && Objects.equal(cdn, other.cdn)
        && Objects.equal(css, other.css);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        lg,
        dd,
        l,
        n,
        profileiconmax,
        store,
        v,
        cdn,
        css);}
}
