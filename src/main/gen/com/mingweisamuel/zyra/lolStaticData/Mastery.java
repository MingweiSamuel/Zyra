package com.mingweisamuel.zyra.lolStaticData;

import java.lang.String;
import java.util.List;

/**
 * Mastery - This object contains mastery data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class Mastery {
  public List<String> description;

  public int id;

  public Image image;

  /**
   * Legal values: Cunning, Ferocity, Resolve */
  public String masteryTree;

  public String name;

  public String prereq;

  public int ranks;

  public List<String> sanitizedDescription;
}
