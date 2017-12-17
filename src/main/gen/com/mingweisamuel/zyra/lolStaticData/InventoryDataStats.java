package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * InventoryDataStats.<br><br>
 *
 * This object contains stats for inventory (e.g., runes and items)..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class InventoryDataStats implements Serializable {
  public final double FlatArmorMod;

  public final double FlatAttackSpeedMod;

  public final double FlatBlockMod;

  public final double FlatCritChanceMod;

  public final double FlatCritDamageMod;

  public final double FlatEXPBonus;

  public final double FlatEnergyPoolMod;

  public final double FlatEnergyRegenMod;

  public final double FlatHPPoolMod;

  public final double FlatHPRegenMod;

  public final double FlatMPPoolMod;

  public final double FlatMPRegenMod;

  public final double FlatMagicDamageMod;

  public final double FlatMovementSpeedMod;

  public final double FlatPhysicalDamageMod;

  public final double FlatSpellBlockMod;

  public final double PercentArmorMod;

  public final double PercentAttackSpeedMod;

  public final double PercentBlockMod;

  public final double PercentCritChanceMod;

  public final double PercentCritDamageMod;

  public final double PercentDodgeMod;

  public final double PercentEXPBonus;

  public final double PercentHPPoolMod;

  public final double PercentHPRegenMod;

  public final double PercentLifeStealMod;

  public final double PercentMPPoolMod;

  public final double PercentMPRegenMod;

  public final double PercentMagicDamageMod;

  public final double PercentMovementSpeedMod;

  public final double PercentPhysicalDamageMod;

  public final double PercentSpellBlockMod;

  public final double PercentSpellVampMod;

  public InventoryDataStats(final double FlatArmorMod, final double FlatAttackSpeedMod,
      final double FlatBlockMod, final double FlatCritChanceMod, final double FlatCritDamageMod,
      final double FlatEXPBonus, final double FlatEnergyPoolMod, final double FlatEnergyRegenMod,
      final double FlatHPPoolMod, final double FlatHPRegenMod, final double FlatMPPoolMod,
      final double FlatMPRegenMod, final double FlatMagicDamageMod,
      final double FlatMovementSpeedMod, final double FlatPhysicalDamageMod,
      final double FlatSpellBlockMod, final double PercentArmorMod,
      final double PercentAttackSpeedMod, final double PercentBlockMod,
      final double PercentCritChanceMod, final double PercentCritDamageMod,
      final double PercentDodgeMod, final double PercentEXPBonus, final double PercentHPPoolMod,
      final double PercentHPRegenMod, final double PercentLifeStealMod,
      final double PercentMPPoolMod, final double PercentMPRegenMod,
      final double PercentMagicDamageMod, final double PercentMovementSpeedMod,
      final double PercentPhysicalDamageMod, final double PercentSpellBlockMod,
      final double PercentSpellVampMod) {
    this.FlatArmorMod = FlatArmorMod;
    this.FlatAttackSpeedMod = FlatAttackSpeedMod;
    this.FlatBlockMod = FlatBlockMod;
    this.FlatCritChanceMod = FlatCritChanceMod;
    this.FlatCritDamageMod = FlatCritDamageMod;
    this.FlatEXPBonus = FlatEXPBonus;
    this.FlatEnergyPoolMod = FlatEnergyPoolMod;
    this.FlatEnergyRegenMod = FlatEnergyRegenMod;
    this.FlatHPPoolMod = FlatHPPoolMod;
    this.FlatHPRegenMod = FlatHPRegenMod;
    this.FlatMPPoolMod = FlatMPPoolMod;
    this.FlatMPRegenMod = FlatMPRegenMod;
    this.FlatMagicDamageMod = FlatMagicDamageMod;
    this.FlatMovementSpeedMod = FlatMovementSpeedMod;
    this.FlatPhysicalDamageMod = FlatPhysicalDamageMod;
    this.FlatSpellBlockMod = FlatSpellBlockMod;
    this.PercentArmorMod = PercentArmorMod;
    this.PercentAttackSpeedMod = PercentAttackSpeedMod;
    this.PercentBlockMod = PercentBlockMod;
    this.PercentCritChanceMod = PercentCritChanceMod;
    this.PercentCritDamageMod = PercentCritDamageMod;
    this.PercentDodgeMod = PercentDodgeMod;
    this.PercentEXPBonus = PercentEXPBonus;
    this.PercentHPPoolMod = PercentHPPoolMod;
    this.PercentHPRegenMod = PercentHPRegenMod;
    this.PercentLifeStealMod = PercentLifeStealMod;
    this.PercentMPPoolMod = PercentMPPoolMod;
    this.PercentMPRegenMod = PercentMPRegenMod;
    this.PercentMagicDamageMod = PercentMagicDamageMod;
    this.PercentMovementSpeedMod = PercentMovementSpeedMod;
    this.PercentPhysicalDamageMod = PercentPhysicalDamageMod;
    this.PercentSpellBlockMod = PercentSpellBlockMod;
    this.PercentSpellVampMod = PercentSpellVampMod;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof InventoryDataStats)) return false;
    final InventoryDataStats other = (InventoryDataStats) obj;
    return true
        && Objects.equal(FlatArmorMod, other.FlatArmorMod)
        && Objects.equal(FlatAttackSpeedMod, other.FlatAttackSpeedMod)
        && Objects.equal(FlatBlockMod, other.FlatBlockMod)
        && Objects.equal(FlatCritChanceMod, other.FlatCritChanceMod)
        && Objects.equal(FlatCritDamageMod, other.FlatCritDamageMod)
        && Objects.equal(FlatEXPBonus, other.FlatEXPBonus)
        && Objects.equal(FlatEnergyPoolMod, other.FlatEnergyPoolMod)
        && Objects.equal(FlatEnergyRegenMod, other.FlatEnergyRegenMod)
        && Objects.equal(FlatHPPoolMod, other.FlatHPPoolMod)
        && Objects.equal(FlatHPRegenMod, other.FlatHPRegenMod)
        && Objects.equal(FlatMPPoolMod, other.FlatMPPoolMod)
        && Objects.equal(FlatMPRegenMod, other.FlatMPRegenMod)
        && Objects.equal(FlatMagicDamageMod, other.FlatMagicDamageMod)
        && Objects.equal(FlatMovementSpeedMod, other.FlatMovementSpeedMod)
        && Objects.equal(FlatPhysicalDamageMod, other.FlatPhysicalDamageMod)
        && Objects.equal(FlatSpellBlockMod, other.FlatSpellBlockMod)
        && Objects.equal(PercentArmorMod, other.PercentArmorMod)
        && Objects.equal(PercentAttackSpeedMod, other.PercentAttackSpeedMod)
        && Objects.equal(PercentBlockMod, other.PercentBlockMod)
        && Objects.equal(PercentCritChanceMod, other.PercentCritChanceMod)
        && Objects.equal(PercentCritDamageMod, other.PercentCritDamageMod)
        && Objects.equal(PercentDodgeMod, other.PercentDodgeMod)
        && Objects.equal(PercentEXPBonus, other.PercentEXPBonus)
        && Objects.equal(PercentHPPoolMod, other.PercentHPPoolMod)
        && Objects.equal(PercentHPRegenMod, other.PercentHPRegenMod)
        && Objects.equal(PercentLifeStealMod, other.PercentLifeStealMod)
        && Objects.equal(PercentMPPoolMod, other.PercentMPPoolMod)
        && Objects.equal(PercentMPRegenMod, other.PercentMPRegenMod)
        && Objects.equal(PercentMagicDamageMod, other.PercentMagicDamageMod)
        && Objects.equal(PercentMovementSpeedMod, other.PercentMovementSpeedMod)
        && Objects.equal(PercentPhysicalDamageMod, other.PercentPhysicalDamageMod)
        && Objects.equal(PercentSpellBlockMod, other.PercentSpellBlockMod)
        && Objects.equal(PercentSpellVampMod, other.PercentSpellVampMod);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        FlatArmorMod,
        FlatAttackSpeedMod,
        FlatBlockMod,
        FlatCritChanceMod,
        FlatCritDamageMod,
        FlatEXPBonus,
        FlatEnergyPoolMod,
        FlatEnergyRegenMod,
        FlatHPPoolMod,
        FlatHPRegenMod,
        FlatMPPoolMod,
        FlatMPRegenMod,
        FlatMagicDamageMod,
        FlatMovementSpeedMod,
        FlatPhysicalDamageMod,
        FlatSpellBlockMod,
        PercentArmorMod,
        PercentAttackSpeedMod,
        PercentBlockMod,
        PercentCritChanceMod,
        PercentCritDamageMod,
        PercentDodgeMod,
        PercentEXPBonus,
        PercentHPPoolMod,
        PercentHPRegenMod,
        PercentLifeStealMod,
        PercentMPPoolMod,
        PercentMPRegenMod,
        PercentMagicDamageMod,
        PercentMovementSpeedMod,
        PercentPhysicalDamageMod,
        PercentSpellBlockMod,
        PercentSpellVampMod);}
}
