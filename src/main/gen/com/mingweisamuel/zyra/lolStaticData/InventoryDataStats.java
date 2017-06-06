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
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v3/GET_getItemList">Riot API reference</a> on Mon Jun 05 20:58:07 PDT 2017. */
public class InventoryDataStats implements Serializable {
  public final double PercentCritDamageMod;

  public final double PercentSpellBlockMod;

  public final double PercentHPRegenMod;

  public final double PercentMovementSpeedMod;

  public final double FlatSpellBlockMod;

  public final double FlatCritDamageMod;

  public final double FlatEnergyPoolMod;

  public final double PercentLifeStealMod;

  public final double FlatMPPoolMod;

  public final double FlatMovementSpeedMod;

  public final double PercentAttackSpeedMod;

  public final double FlatBlockMod;

  public final double PercentBlockMod;

  public final double FlatEnergyRegenMod;

  public final double PercentSpellVampMod;

  public final double FlatMPRegenMod;

  public final double PercentDodgeMod;

  public final double FlatAttackSpeedMod;

  public final double FlatArmorMod;

  public final double FlatHPRegenMod;

  public final double PercentMagicDamageMod;

  public final double PercentMPPoolMod;

  public final double FlatMagicDamageMod;

  public final double PercentMPRegenMod;

  public final double PercentPhysicalDamageMod;

  public final double FlatPhysicalDamageMod;

  public final double PercentHPPoolMod;

  public final double PercentArmorMod;

  public final double PercentCritChanceMod;

  public final double PercentEXPBonus;

  public final double FlatHPPoolMod;

  public final double FlatCritChanceMod;

  public final double FlatEXPBonus;

  public InventoryDataStats(final double PercentCritDamageMod, final double PercentSpellBlockMod,
      final double PercentHPRegenMod, final double PercentMovementSpeedMod,
      final double FlatSpellBlockMod, final double FlatCritDamageMod,
      final double FlatEnergyPoolMod, final double PercentLifeStealMod, final double FlatMPPoolMod,
      final double FlatMovementSpeedMod, final double PercentAttackSpeedMod,
      final double FlatBlockMod, final double PercentBlockMod, final double FlatEnergyRegenMod,
      final double PercentSpellVampMod, final double FlatMPRegenMod, final double PercentDodgeMod,
      final double FlatAttackSpeedMod, final double FlatArmorMod, final double FlatHPRegenMod,
      final double PercentMagicDamageMod, final double PercentMPPoolMod,
      final double FlatMagicDamageMod, final double PercentMPRegenMod,
      final double PercentPhysicalDamageMod, final double FlatPhysicalDamageMod,
      final double PercentHPPoolMod, final double PercentArmorMod,
      final double PercentCritChanceMod, final double PercentEXPBonus, final double FlatHPPoolMod,
      final double FlatCritChanceMod, final double FlatEXPBonus) {
    this.PercentCritDamageMod = PercentCritDamageMod;
    this.PercentSpellBlockMod = PercentSpellBlockMod;
    this.PercentHPRegenMod = PercentHPRegenMod;
    this.PercentMovementSpeedMod = PercentMovementSpeedMod;
    this.FlatSpellBlockMod = FlatSpellBlockMod;
    this.FlatCritDamageMod = FlatCritDamageMod;
    this.FlatEnergyPoolMod = FlatEnergyPoolMod;
    this.PercentLifeStealMod = PercentLifeStealMod;
    this.FlatMPPoolMod = FlatMPPoolMod;
    this.FlatMovementSpeedMod = FlatMovementSpeedMod;
    this.PercentAttackSpeedMod = PercentAttackSpeedMod;
    this.FlatBlockMod = FlatBlockMod;
    this.PercentBlockMod = PercentBlockMod;
    this.FlatEnergyRegenMod = FlatEnergyRegenMod;
    this.PercentSpellVampMod = PercentSpellVampMod;
    this.FlatMPRegenMod = FlatMPRegenMod;
    this.PercentDodgeMod = PercentDodgeMod;
    this.FlatAttackSpeedMod = FlatAttackSpeedMod;
    this.FlatArmorMod = FlatArmorMod;
    this.FlatHPRegenMod = FlatHPRegenMod;
    this.PercentMagicDamageMod = PercentMagicDamageMod;
    this.PercentMPPoolMod = PercentMPPoolMod;
    this.FlatMagicDamageMod = FlatMagicDamageMod;
    this.PercentMPRegenMod = PercentMPRegenMod;
    this.PercentPhysicalDamageMod = PercentPhysicalDamageMod;
    this.FlatPhysicalDamageMod = FlatPhysicalDamageMod;
    this.PercentHPPoolMod = PercentHPPoolMod;
    this.PercentArmorMod = PercentArmorMod;
    this.PercentCritChanceMod = PercentCritChanceMod;
    this.PercentEXPBonus = PercentEXPBonus;
    this.FlatHPPoolMod = FlatHPPoolMod;
    this.FlatCritChanceMod = FlatCritChanceMod;
    this.FlatEXPBonus = FlatEXPBonus;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof InventoryDataStats)) return false;
    final InventoryDataStats other = (InventoryDataStats) obj;
    return true
        && Objects.equal(PercentCritDamageMod, other.PercentCritDamageMod)
        && Objects.equal(PercentSpellBlockMod, other.PercentSpellBlockMod)
        && Objects.equal(PercentHPRegenMod, other.PercentHPRegenMod)
        && Objects.equal(PercentMovementSpeedMod, other.PercentMovementSpeedMod)
        && Objects.equal(FlatSpellBlockMod, other.FlatSpellBlockMod)
        && Objects.equal(FlatCritDamageMod, other.FlatCritDamageMod)
        && Objects.equal(FlatEnergyPoolMod, other.FlatEnergyPoolMod)
        && Objects.equal(PercentLifeStealMod, other.PercentLifeStealMod)
        && Objects.equal(FlatMPPoolMod, other.FlatMPPoolMod)
        && Objects.equal(FlatMovementSpeedMod, other.FlatMovementSpeedMod)
        && Objects.equal(PercentAttackSpeedMod, other.PercentAttackSpeedMod)
        && Objects.equal(FlatBlockMod, other.FlatBlockMod)
        && Objects.equal(PercentBlockMod, other.PercentBlockMod)
        && Objects.equal(FlatEnergyRegenMod, other.FlatEnergyRegenMod)
        && Objects.equal(PercentSpellVampMod, other.PercentSpellVampMod)
        && Objects.equal(FlatMPRegenMod, other.FlatMPRegenMod)
        && Objects.equal(PercentDodgeMod, other.PercentDodgeMod)
        && Objects.equal(FlatAttackSpeedMod, other.FlatAttackSpeedMod)
        && Objects.equal(FlatArmorMod, other.FlatArmorMod)
        && Objects.equal(FlatHPRegenMod, other.FlatHPRegenMod)
        && Objects.equal(PercentMagicDamageMod, other.PercentMagicDamageMod)
        && Objects.equal(PercentMPPoolMod, other.PercentMPPoolMod)
        && Objects.equal(FlatMagicDamageMod, other.FlatMagicDamageMod)
        && Objects.equal(PercentMPRegenMod, other.PercentMPRegenMod)
        && Objects.equal(PercentPhysicalDamageMod, other.PercentPhysicalDamageMod)
        && Objects.equal(FlatPhysicalDamageMod, other.FlatPhysicalDamageMod)
        && Objects.equal(PercentHPPoolMod, other.PercentHPPoolMod)
        && Objects.equal(PercentArmorMod, other.PercentArmorMod)
        && Objects.equal(PercentCritChanceMod, other.PercentCritChanceMod)
        && Objects.equal(PercentEXPBonus, other.PercentEXPBonus)
        && Objects.equal(FlatHPPoolMod, other.FlatHPPoolMod)
        && Objects.equal(FlatCritChanceMod, other.FlatCritChanceMod)
        && Objects.equal(FlatEXPBonus, other.FlatEXPBonus);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        PercentCritDamageMod,
        PercentSpellBlockMod,
        PercentHPRegenMod,
        PercentMovementSpeedMod,
        FlatSpellBlockMod,
        FlatCritDamageMod,
        FlatEnergyPoolMod,
        PercentLifeStealMod,
        FlatMPPoolMod,
        FlatMovementSpeedMod,
        PercentAttackSpeedMod,
        FlatBlockMod,
        PercentBlockMod,
        FlatEnergyRegenMod,
        PercentSpellVampMod,
        FlatMPRegenMod,
        PercentDodgeMod,
        FlatAttackSpeedMod,
        FlatArmorMod,
        FlatHPRegenMod,
        PercentMagicDamageMod,
        PercentMPPoolMod,
        FlatMagicDamageMod,
        PercentMPRegenMod,
        PercentPhysicalDamageMod,
        FlatPhysicalDamageMod,
        PercentHPPoolMod,
        PercentArmorMod,
        PercentCritChanceMod,
        PercentEXPBonus,
        FlatHPPoolMod,
        FlatCritChanceMod,
        FlatEXPBonus);}
}
