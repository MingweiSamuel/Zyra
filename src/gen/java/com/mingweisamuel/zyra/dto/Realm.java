package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.Map;

/**
 * Realm - This object contains realm data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version lol-static-data-v1.2 */
public class Realm {
  /**
   * The base CDN url. */
  public String cdn;

  /**
   * Latest changed version of Dragon Magic's css file. */
  public String css;

  /**
   * Latest changed version of Dragon Magic. */
  public String dd;

  /**
   * Default language for this realm. */
  public String l;

  /**
   * Legacy script mode for IE6 or older. */
  public String lg;

  /**
   * Latest changed version for each data type listed. */
  public Map<String, String> n;

  /**
   * Special behavior number identifying the largest profileicon id that can be used under 500. Any profileicon that is requested between this number and 500 should be mapped to 0. */
  public int profileiconmax;

  /**
   * Additional api data drawn from other sources that may be related to data dragon functionality. */
  public String store;

  /**
   * Current version of this file for this realm. */
  public String v;
}
