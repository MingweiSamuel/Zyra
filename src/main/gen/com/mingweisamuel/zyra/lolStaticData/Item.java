package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;

/**
 * Item.<br><br>
 *
 * This object contains item data..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Item implements Serializable {
  public final String colloq;

  public final boolean consumeOnFull;

  public final boolean consumed;

  public final int depth;

  public final String description;

  public final Map<String, String> effect;

  public final List<String> from;

  public final Gold gold;

  public final String group;

  public final boolean hideFromAll;

  public final int id;

  public final Image image;

  public final boolean inStore;

  public final List<String> into;

  public final Map<Integer, Boolean> maps;

  public final String name;

  public final String plaintext;

  public final String requiredChampion;

  public final String sanitizedDescription;

  public final int specialRecipe;

  public final int stacks;

  public final InventoryDataStats stats;

  public final List<String> tags;

  public Item(final String colloq, final boolean consumeOnFull, final boolean consumed,
      final int depth, final String description, final Map<String, String> effect,
      final List<String> from, final Gold gold, final String group, final boolean hideFromAll,
      final int id, final Image image, final boolean inStore, final List<String> into,
      final Map<Integer, Boolean> maps, final String name, final String plaintext,
      final String requiredChampion, final String sanitizedDescription, final int specialRecipe,
      final int stacks, final InventoryDataStats stats, final List<String> tags) {
    this.colloq = colloq;
    this.consumeOnFull = consumeOnFull;
    this.consumed = consumed;
    this.depth = depth;
    this.description = description;
    this.effect = effect;
    this.from = from;
    this.gold = gold;
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
    this.sanitizedDescription = sanitizedDescription;
    this.specialRecipe = specialRecipe;
    this.stacks = stacks;
    this.stats = stats;
    this.tags = tags;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Item)) return false;
    final Item other = (Item) obj;
    return true
        && Objects.equal(colloq, other.colloq)
        && Objects.equal(consumeOnFull, other.consumeOnFull)
        && Objects.equal(consumed, other.consumed)
        && Objects.equal(depth, other.depth)
        && Objects.equal(description, other.description)
        && Objects.equal(effect, other.effect)
        && Objects.equal(from, other.from)
        && Objects.equal(gold, other.gold)
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
        effect,
        from,
        gold,
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
        sanitizedDescription,
        specialRecipe,
        stacks,
        stats,
        tags);}
}
