package com.mingweisamuel.zyra.dto;

import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

/**
 * ChampionSpell - This object contains champion spell data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}. */
public class ChampionSpell {
  public List<Image> altimages;

  public List<Double> cooldown;

  public String cooldownBurn;

  public List<Integer> cost;

  public String costBurn;

  public String costType;

  public String description;

  /**
   * This field is a List of List of Double. */
  public List<List<Double>> effect;

  public List<String> effectBurn;

  public Image image;

  public String key;

  public LevelTip leveltip;

  public int maxrank;

  public String name;

  /**
   * This field is either a List of Integer or the String 'self' for spells that target one's own champion.
   *
   * Will be null instead of 'self'. */
  public List<Integer> range;

  public String rangeBurn;

  public String resource;

  public String sanitizedDescription;

  public String sanitizedTooltip;

  public String tooltip;

  public List<SpellVars> vars;
}
