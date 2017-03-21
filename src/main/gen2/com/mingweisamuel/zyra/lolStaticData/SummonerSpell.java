package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * This object contains summoner spell data..<br />%n<br />
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getSummonerSpellList">Riot API reference</a> on Tue Mar 21 14:42:38 PDT 2017. */
class SummonerSpell {
  public final List<SpellVars> vars;

  public final Image image;

  public final String costBurn;

  public final List<Double> cooldown;

  public final List<String> effectBurn;

  public final int id;

  public final String cooldownBurn;

  public final String tooltip;

  public final int maxrank;

  public final String rangeBurn;

  public final String description;

  public final List<String> modes;

  /**
   * This field is a List of List of Double. */
  public final List<List<Double>> effect;

  public final String key;

  public final LevelTip leveltip;

  public final String resource;

  public final String name;

  public final String costType;

  public final String sanitizedDescription;

  public final String sanitizedTooltip;

  /**
   * This field is either a List of Integer or the String 'self' for spells that target one's own champion. */
  public final List<Integer> range;

  public final List<Integer> cost;

  public final int summonerLevel;

  public SummonerSpell(final List<SpellVars> vars, final Image image, final String costBurn,
      final List<Double> cooldown, final List<String> effectBurn, final int id,
      final String cooldownBurn, final String tooltip, final int maxrank, final String rangeBurn,
      final String description, final List<String> modes, final List<List<Double>> effect,
      final String key, final LevelTip leveltip, final String resource, final String name,
      final String costType, final String sanitizedDescription, final String sanitizedTooltip,
      final List<Integer> range, final List<Integer> cost, final int summonerLevel) {
    this.vars = vars;
    this.image = image;
    this.costBurn = costBurn;
    this.cooldown = cooldown;
    this.effectBurn = effectBurn;
    this.id = id;
    this.cooldownBurn = cooldownBurn;
    this.tooltip = tooltip;
    this.maxrank = maxrank;
    this.rangeBurn = rangeBurn;
    this.description = description;
    this.modes = modes;
    this.effect = effect;
    this.key = key;
    this.leveltip = leveltip;
    this.resource = resource;
    this.name = name;
    this.costType = costType;
    this.sanitizedDescription = sanitizedDescription;
    this.sanitizedTooltip = sanitizedTooltip;
    this.range = range;
    this.cost = cost;
    this.summonerLevel = summonerLevel;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof LolStaticData)) return false;
    final LolStaticData other = (LolStaticData) obj;
    return true
        && Objects.equal(vars, other.vars)
        && Objects.equal(image, other.image)
        && Objects.equal(costBurn, other.costBurn)
        && Objects.equal(cooldown, other.cooldown)
        && Objects.equal(effectBurn, other.effectBurn)
        && Objects.equal(id, other.id)
        && Objects.equal(cooldownBurn, other.cooldownBurn)
        && Objects.equal(tooltip, other.tooltip)
        && Objects.equal(maxrank, other.maxrank)
        && Objects.equal(rangeBurn, other.rangeBurn)
        && Objects.equal(description, other.description)
        && Objects.equal(modes, other.modes)
        && Objects.equal(effect, other.effect)
        && Objects.equal(key, other.key)
        && Objects.equal(leveltip, other.leveltip)
        && Objects.equal(resource, other.resource)
        && Objects.equal(name, other.name)
        && Objects.equal(costType, other.costType)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(sanitizedTooltip, other.sanitizedTooltip)
        && Objects.equal(range, other.range)
        && Objects.equal(cost, other.cost)
        && Objects.equal(summonerLevel, other.summonerLevel);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        vars,
        image,
        costBurn,
        cooldown,
        effectBurn,
        id,
        cooldownBurn,
        tooltip,
        maxrank,
        rangeBurn,
        description,
        modes,
        effect,
        key,
        leveltip,
        resource,
        name,
        costType,
        sanitizedDescription,
        sanitizedTooltip,
        range,
        cost,
        summonerLevel);}
}
