package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * ChampionSpell.<br><br>
 *
 * This object contains champion spell data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class ChampionSpell implements Serializable {
  public final List<Image> altimages;

  public final List<Double> cooldown;

  public final String cooldownBurn;

  public final List<Integer> cost;

  public final String costBurn;

  public final String costType;

  public final String description;

  /**
   * This field is a List of List of Double. */
  public final List<List<Double>> effect;

  public final List<String> effectBurn;

  public final Image image;

  public final String key;

  public final LevelTip leveltip;

  public final int maxrank;

  public final String name;

  /**
   * This field is either a List of Integer or the String 'self' for spells that target one's own champion. */
  public final List<Integer> range;

  public final String rangeBurn;

  public final String resource;

  public final String sanitizedDescription;

  public final String sanitizedTooltip;

  public final String tooltip;

  public final List<SpellVars> vars;

  public ChampionSpell(final List<Image> altimages, final List<Double> cooldown,
      final String cooldownBurn, final List<Integer> cost, final String costBurn,
      final String costType, final String description, final List<List<Double>> effect,
      final List<String> effectBurn, final Image image, final String key, final LevelTip leveltip,
      final int maxrank, final String name, final List<Integer> range, final String rangeBurn,
      final String resource, final String sanitizedDescription, final String sanitizedTooltip,
      final String tooltip, final List<SpellVars> vars) {
    this.altimages = altimages;
    this.cooldown = cooldown;
    this.cooldownBurn = cooldownBurn;
    this.cost = cost;
    this.costBurn = costBurn;
    this.costType = costType;
    this.description = description;
    this.effect = effect;
    this.effectBurn = effectBurn;
    this.image = image;
    this.key = key;
    this.leveltip = leveltip;
    this.maxrank = maxrank;
    this.name = name;
    this.range = range;
    this.rangeBurn = rangeBurn;
    this.resource = resource;
    this.sanitizedDescription = sanitizedDescription;
    this.sanitizedTooltip = sanitizedTooltip;
    this.tooltip = tooltip;
    this.vars = vars;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof ChampionSpell)) return false;
    final ChampionSpell other = (ChampionSpell) obj;
    return true
        && Objects.equal(altimages, other.altimages)
        && Objects.equal(cooldown, other.cooldown)
        && Objects.equal(cooldownBurn, other.cooldownBurn)
        && Objects.equal(cost, other.cost)
        && Objects.equal(costBurn, other.costBurn)
        && Objects.equal(costType, other.costType)
        && Objects.equal(description, other.description)
        && Objects.equal(effect, other.effect)
        && Objects.equal(effectBurn, other.effectBurn)
        && Objects.equal(image, other.image)
        && Objects.equal(key, other.key)
        && Objects.equal(leveltip, other.leveltip)
        && Objects.equal(maxrank, other.maxrank)
        && Objects.equal(name, other.name)
        && Objects.equal(range, other.range)
        && Objects.equal(rangeBurn, other.rangeBurn)
        && Objects.equal(resource, other.resource)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(sanitizedTooltip, other.sanitizedTooltip)
        && Objects.equal(tooltip, other.tooltip)
        && Objects.equal(vars, other.vars);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        altimages,
        cooldown,
        cooldownBurn,
        cost,
        costBurn,
        costType,
        description,
        effect,
        effectBurn,
        image,
        key,
        leveltip,
        maxrank,
        name,
        range,
        rangeBurn,
        resource,
        sanitizedDescription,
        sanitizedTooltip,
        tooltip,
        vars);}
}
