package com.mingweisamuel.zyra.staticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;

/**
 * Rune.<br><br>
 *
 * This object contains rune data..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#static-data-v3/GET_getRuneList">Riot API reference</a> on Wed May 17 21:34:50 PDT 2017. */
public class Rune implements Serializable {
  public final String plaintext;

  public final boolean hideFromAll;

  public final boolean inStore;

  public final List<String> into;

  public final int id;

  public final BasicDataStats stats;

  public final String colloq;

  public final Map<String, Boolean> maps;

  public final int specialRecipe;

  public final Image image;

  public final String description;

  public final List<String> tags;

  public final String requiredChampion;

  public final List<String> from;

  public final String group;

  public final boolean consumeOnFull;

  public final String name;

  public final boolean consumed;

  public final String sanitizedDescription;

  public final int depth;

  public final MetaData rune;

  public final int stacks;

  public Rune(final String plaintext, final boolean hideFromAll, final boolean inStore,
      final List<String> into, final int id, final BasicDataStats stats, final String colloq,
      final Map<String, Boolean> maps, final int specialRecipe, final Image image,
      final String description, final List<String> tags, final String requiredChampion,
      final List<String> from, final String group, final boolean consumeOnFull, final String name,
      final boolean consumed, final String sanitizedDescription, final int depth,
      final MetaData rune, final int stacks) {
    this.plaintext = plaintext;
    this.hideFromAll = hideFromAll;
    this.inStore = inStore;
    this.into = into;
    this.id = id;
    this.stats = stats;
    this.colloq = colloq;
    this.maps = maps;
    this.specialRecipe = specialRecipe;
    this.image = image;
    this.description = description;
    this.tags = tags;
    this.requiredChampion = requiredChampion;
    this.from = from;
    this.group = group;
    this.consumeOnFull = consumeOnFull;
    this.name = name;
    this.consumed = consumed;
    this.sanitizedDescription = sanitizedDescription;
    this.depth = depth;
    this.rune = rune;
    this.stacks = stacks;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Rune)) return false;
    final Rune other = (Rune) obj;
    return true
        && Objects.equal(plaintext, other.plaintext)
        && Objects.equal(hideFromAll, other.hideFromAll)
        && Objects.equal(inStore, other.inStore)
        && Objects.equal(into, other.into)
        && Objects.equal(id, other.id)
        && Objects.equal(stats, other.stats)
        && Objects.equal(colloq, other.colloq)
        && Objects.equal(maps, other.maps)
        && Objects.equal(specialRecipe, other.specialRecipe)
        && Objects.equal(image, other.image)
        && Objects.equal(description, other.description)
        && Objects.equal(tags, other.tags)
        && Objects.equal(requiredChampion, other.requiredChampion)
        && Objects.equal(from, other.from)
        && Objects.equal(group, other.group)
        && Objects.equal(consumeOnFull, other.consumeOnFull)
        && Objects.equal(name, other.name)
        && Objects.equal(consumed, other.consumed)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(depth, other.depth)
        && Objects.equal(rune, other.rune)
        && Objects.equal(stacks, other.stacks);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        plaintext,
        hideFromAll,
        inStore,
        into,
        id,
        stats,
        colloq,
        maps,
        specialRecipe,
        image,
        description,
        tags,
        requiredChampion,
        from,
        group,
        consumeOnFull,
        name,
        consumed,
        sanitizedDescription,
        depth,
        rune,
        stacks);}
}
