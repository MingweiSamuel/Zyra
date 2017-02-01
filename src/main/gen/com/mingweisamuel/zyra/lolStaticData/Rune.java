package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;

/**
 * Rune - This object contains rune data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class Rune implements Serializable {
  public final String colloq;

  public final boolean consumeOnFull;

  public final boolean consumed;

  public final int depth;

  public final String description;

  public final List<String> from;

  public final String group;

  public final boolean hideFromAll;

  public final int id;

  public final Image image;

  public final boolean inStore;

  public final List<String> into;

  public final Map<String, Boolean> maps;

  public final String name;

  public final String plaintext;

  public final String requiredChampion;

  public final MetaData rune;

  public final String sanitizedDescription;

  public final int specialRecipe;

  public final int stacks;

  public final BasicDataStats stats;

  public final List<String> tags;

  public Rune(final String colloq, final boolean consumeOnFull, final boolean consumed,
      final int depth, final String description, final List<String> from, final String group,
      final boolean hideFromAll, final int id, final Image image, final boolean inStore,
      final List<String> into, final Map<String, Boolean> maps, final String name,
      final String plaintext, final String requiredChampion, final MetaData rune,
      final String sanitizedDescription, final int specialRecipe, final int stacks,
      final BasicDataStats stats, final List<String> tags) {
    this.colloq = colloq;
    this.consumeOnFull = consumeOnFull;
    this.consumed = consumed;
    this.depth = depth;
    this.description = description;
    this.from = from;
    this.group = group;
    this.hideFromAll = hideFromAll;
    this.id = id;
    this.image = image;
    this.inStore = inStore;
    this.into = into;
    this.maps = maps;
    this.name = name;
    this.plaintext = plaintext;
    this.requiredChampion = requiredChampion;
    this.rune = rune;
    this.sanitizedDescription = sanitizedDescription;
    this.specialRecipe = specialRecipe;
    this.stacks = stacks;
    this.stats = stats;
    this.tags = tags;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Rune)) return false;
    final Rune other = (Rune) obj;
    return true
        && Objects.equal(colloq, other.colloq)
        && Objects.equal(consumeOnFull, other.consumeOnFull)
        && Objects.equal(consumed, other.consumed)
        && Objects.equal(depth, other.depth)
        && Objects.equal(description, other.description)
        && Objects.equal(from, other.from)
        && Objects.equal(group, other.group)
        && Objects.equal(hideFromAll, other.hideFromAll)
        && Objects.equal(id, other.id)
        && Objects.equal(image, other.image)
        && Objects.equal(inStore, other.inStore)
        && Objects.equal(into, other.into)
        && Objects.equal(maps, other.maps)
        && Objects.equal(name, other.name)
        && Objects.equal(plaintext, other.plaintext)
        && Objects.equal(requiredChampion, other.requiredChampion)
        && Objects.equal(rune, other.rune)
        && Objects.equal(sanitizedDescription, other.sanitizedDescription)
        && Objects.equal(specialRecipe, other.specialRecipe)
        && Objects.equal(stacks, other.stacks)
        && Objects.equal(stats, other.stats)
        && Objects.equal(tags, other.tags);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        colloq,
        consumeOnFull,
        consumed,
        depth,
        description,
        from,
        group,
        hideFromAll,
        id,
        image,
        inStore,
        into,
        maps,
        name,
        plaintext,
        requiredChampion,
        rune,
        sanitizedDescription,
        specialRecipe,
        stacks,
        stats,
        tags);}
}
