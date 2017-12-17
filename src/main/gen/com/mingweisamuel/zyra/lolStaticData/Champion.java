package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Champion.<br><br>
 *
 * This object contains champion data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Champion implements Serializable {
  public final List<String> allytips;

  public final String blurb;

  public final List<String> enemytips;

  public final int id;

  public final Image image;

  public final Info info;

  public final String key;

  public final String lore;

  public final String name;

  public final String partype;

  public final Passive passive;

  public final List<Recommended> recommended;

  public final List<Skin> skins;

  public final List<ChampionSpell> spells;

  public final Stats stats;

  public final List<String> tags;

  public final String title;

  public Champion(final List<String> allytips, final String blurb, final List<String> enemytips,
      final int id, final Image image, final Info info, final String key, final String lore,
      final String name, final String partype, final Passive passive,
      final List<Recommended> recommended, final List<Skin> skins, final List<ChampionSpell> spells,
      final Stats stats, final List<String> tags, final String title) {
    this.allytips = allytips;
    this.blurb = blurb;
    this.enemytips = enemytips;
    this.id = id;
    this.image = image;
    this.info = info;
    this.key = key;
    this.lore = lore;
    this.name = name;
    this.partype = partype;
    this.passive = passive;
    this.recommended = recommended;
    this.skins = skins;
    this.spells = spells;
    this.stats = stats;
    this.tags = tags;
    this.title = title;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Champion)) return false;
    final Champion other = (Champion) obj;
    return true
        && Objects.equal(allytips, other.allytips)
        && Objects.equal(blurb, other.blurb)
        && Objects.equal(enemytips, other.enemytips)
        && Objects.equal(id, other.id)
        && Objects.equal(image, other.image)
        && Objects.equal(info, other.info)
        && Objects.equal(key, other.key)
        && Objects.equal(lore, other.lore)
        && Objects.equal(name, other.name)
        && Objects.equal(partype, other.partype)
        && Objects.equal(passive, other.passive)
        && Objects.equal(recommended, other.recommended)
        && Objects.equal(skins, other.skins)
        && Objects.equal(spells, other.spells)
        && Objects.equal(stats, other.stats)
        && Objects.equal(tags, other.tags)
        && Objects.equal(title, other.title);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        allytips,
        blurb,
        enemytips,
        id,
        image,
        info,
        key,
        lore,
        name,
        partype,
        passive,
        recommended,
        skins,
        spells,
        stats,
        tags,
        title);}
}
