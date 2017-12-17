package com.mingweisamuel.zyra.lolStaticData;

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
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Realm implements Serializable {
  /**
   * The base CDN URL. */
  public final String cdn;

  /**
   * Latest changed version of Dragon Magic's CSS file. */
  public final String css;

  /**
   * Latest changed version of Dragon Magic. */
  public final String dd;

  /**
   * Default language for this realm. */
  public final String l;

  /**
   * Legacy script mode for IE6 or older. */
  public final String lg;

  /**
   * Latest changed version for each data type listed. */
  public final Map<String, String> n;

  /**
   * Special behavior number identifying the largest profile icon ID that can be used under 500. Any profile icon that is requested between this number and 500 should be mapped to 0. */
  public final int profileiconmax;

  /**
   * Additional API data drawn from other sources that may be related to Data Dragon functionality. */
  public final String store;

  /**
   * Current version of this file for this realm. */
  public final String v;

  public Realm(final String cdn, final String css, final String dd, final String l, final String lg,
      final Map<String, String> n, final int profileiconmax, final String store, final String v) {
    this.cdn = cdn;
    this.css = css;
    this.dd = dd;
    this.l = l;
    this.lg = lg;
    this.n = n;
    this.profileiconmax = profileiconmax;
    this.store = store;
    this.v = v;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Realm)) return false;
    final Realm other = (Realm) obj;
    return true
        && Objects.equal(cdn, other.cdn)
        && Objects.equal(css, other.css)
        && Objects.equal(dd, other.dd)
        && Objects.equal(l, other.l)
        && Objects.equal(lg, other.lg)
        && Objects.equal(n, other.n)
        && Objects.equal(profileiconmax, other.profileiconmax)
        && Objects.equal(store, other.store)
        && Objects.equal(v, other.v);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        cdn,
        css,
        dd,
        l,
        lg,
        n,
        profileiconmax,
        store,
        v);}
}
