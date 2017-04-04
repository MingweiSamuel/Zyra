package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * BasicDataStats.<br><br>
 *
 * This object contains basic data stats..<br><br>
 *
 * This class was automatically generated from the <a href="https://developer.riotgames.com/api-methods/#lol-static-data-v1.2/GET_getItemList">Riot API reference</a> on Thu Mar 23 10:53:08 PDT 2017. */
public class BasicDataStats implements Serializable {
  public final double rPercentMagicPenetrationModPerLevel;

  public final double rFlatEnergyModPerLevel;

  public final double rFlatArmorModPerLevel;

  public final double PercentSpellBlockMod;

  public final double PercentHPRegenMod;

  public final double PercentMovementSpeedMod;

  public final double FlatSpellBlockMod;

  public final double FlatCritDamageMod;

  public final double FlatEnergyPoolMod;

  public final double rFlatDodgeMod;

  public final double PercentLifeStealMod;

  public final double rFlatMPRegenModPerLevel;

  public final double FlatMPPoolMod;

  public final double rFlatGoldPer10Mod;

  public final double FlatMovementSpeedMod;

  public final double PercentCritDamageMod;

  public final double rFlatMagicDamageModPerLevel;

  public final double rPercentCooldownModPerLevel;

  public final double PercentAttackSpeedMod;

  public final double FlatBlockMod;

  public final double PercentBlockMod;

  public final double rFlatTimeDeadModPerLevel;

  public final double FlatEnergyRegenMod;

  public final double rPercentAttackSpeedModPerLevel;

  public final double PercentSpellVampMod;

  public final double FlatMPRegenMod;

  public final double rFlatTimeDeadMod;

  public final double rFlatMPModPerLevel;

  public final double FlatAttackSpeedMod;

  public final double rFlatMagicPenetrationMod;

  public final double rFlatCritChanceModPerLevel;

  public final double PercentDodgeMod;

  public final double rFlatHPModPerLevel;

  public final double rFlatEnergyRegenModPerLevel;

  public final double rPercentMovementSpeedModPerLevel;

  public final double rFlatSpellBlockModPerLevel;

  public final double PercentMagicDamageMod;

  public final double PercentMPPoolMod;

  public final double rPercentMagicPenetrationMod;

  public final double FlatMagicDamageMod;

  public final double PercentMPRegenMod;

  public final double PercentPhysicalDamageMod;

  public final double FlatArmorMod;

  public final double rFlatPhysicalDamageModPerLevel;

  public final double rFlatDodgeModPerLevel;

  public final double FlatPhysicalDamageMod;

  public final double rPercentTimeDeadMod;

  public final double PercentHPPoolMod;

  public final double rFlatArmorPenetrationMod;

  public final double rFlatMagicPenetrationModPerLevel;

  public final double PercentArmorMod;

  public final double PercentCritChanceMod;

  public final double rFlatArmorPenetrationModPerLevel;

  public final double rFlatHPRegenModPerLevel;

  public final double PercentEXPBonus;

  public final double rPercentTimeDeadModPerLevel;

  public final double rFlatCritDamageModPerLevel;

  public final double rFlatMovementSpeedModPerLevel;

  public final double rPercentArmorPenetrationMod;

  public final double rPercentCooldownMod;

  public final double rPercentArmorPenetrationModPerLevel;

  public final double FlatEXPBonus;

  public final double FlatHPPoolMod;

  public final double FlatCritChanceMod;

  public final double FlatHPRegenMod;

  public BasicDataStats(final double rPercentMagicPenetrationModPerLevel,
      final double rFlatEnergyModPerLevel, final double rFlatArmorModPerLevel,
      final double PercentSpellBlockMod, final double PercentHPRegenMod,
      final double PercentMovementSpeedMod, final double FlatSpellBlockMod,
      final double FlatCritDamageMod, final double FlatEnergyPoolMod, final double rFlatDodgeMod,
      final double PercentLifeStealMod, final double rFlatMPRegenModPerLevel,
      final double FlatMPPoolMod, final double rFlatGoldPer10Mod, final double FlatMovementSpeedMod,
      final double PercentCritDamageMod, final double rFlatMagicDamageModPerLevel,
      final double rPercentCooldownModPerLevel, final double PercentAttackSpeedMod,
      final double FlatBlockMod, final double PercentBlockMod,
      final double rFlatTimeDeadModPerLevel, final double FlatEnergyRegenMod,
      final double rPercentAttackSpeedModPerLevel, final double PercentSpellVampMod,
      final double FlatMPRegenMod, final double rFlatTimeDeadMod, final double rFlatMPModPerLevel,
      final double FlatAttackSpeedMod, final double rFlatMagicPenetrationMod,
      final double rFlatCritChanceModPerLevel, final double PercentDodgeMod,
      final double rFlatHPModPerLevel, final double rFlatEnergyRegenModPerLevel,
      final double rPercentMovementSpeedModPerLevel, final double rFlatSpellBlockModPerLevel,
      final double PercentMagicDamageMod, final double PercentMPPoolMod,
      final double rPercentMagicPenetrationMod, final double FlatMagicDamageMod,
      final double PercentMPRegenMod, final double PercentPhysicalDamageMod,
      final double FlatArmorMod, final double rFlatPhysicalDamageModPerLevel,
      final double rFlatDodgeModPerLevel, final double FlatPhysicalDamageMod,
      final double rPercentTimeDeadMod, final double PercentHPPoolMod,
      final double rFlatArmorPenetrationMod, final double rFlatMagicPenetrationModPerLevel,
      final double PercentArmorMod, final double PercentCritChanceMod,
      final double rFlatArmorPenetrationModPerLevel, final double rFlatHPRegenModPerLevel,
      final double PercentEXPBonus, final double rPercentTimeDeadModPerLevel,
      final double rFlatCritDamageModPerLevel, final double rFlatMovementSpeedModPerLevel,
      final double rPercentArmorPenetrationMod, final double rPercentCooldownMod,
      final double rPercentArmorPenetrationModPerLevel, final double FlatEXPBonus,
      final double FlatHPPoolMod, final double FlatCritChanceMod, final double FlatHPRegenMod) {
    this.rPercentMagicPenetrationModPerLevel = rPercentMagicPenetrationModPerLevel;
    this.rFlatEnergyModPerLevel = rFlatEnergyModPerLevel;
    this.rFlatArmorModPerLevel = rFlatArmorModPerLevel;
    this.PercentSpellBlockMod = PercentSpellBlockMod;
    this.PercentHPRegenMod = PercentHPRegenMod;
    this.PercentMovementSpeedMod = PercentMovementSpeedMod;
    this.FlatSpellBlockMod = FlatSpellBlockMod;
    this.FlatCritDamageMod = FlatCritDamageMod;
    this.FlatEnergyPoolMod = FlatEnergyPoolMod;
    this.rFlatDodgeMod = rFlatDodgeMod;
    this.PercentLifeStealMod = PercentLifeStealMod;
    this.rFlatMPRegenModPerLevel = rFlatMPRegenModPerLevel;
    this.FlatMPPoolMod = FlatMPPoolMod;
    this.rFlatGoldPer10Mod = rFlatGoldPer10Mod;
    this.FlatMovementSpeedMod = FlatMovementSpeedMod;
    this.PercentCritDamageMod = PercentCritDamageMod;
    this.rFlatMagicDamageModPerLevel = rFlatMagicDamageModPerLevel;
    this.rPercentCooldownModPerLevel = rPercentCooldownModPerLevel;
    this.PercentAttackSpeedMod = PercentAttackSpeedMod;
    this.FlatBlockMod = FlatBlockMod;
    this.PercentBlockMod = PercentBlockMod;
    this.rFlatTimeDeadModPerLevel = rFlatTimeDeadModPerLevel;
    this.FlatEnergyRegenMod = FlatEnergyRegenMod;
    this.rPercentAttackSpeedModPerLevel = rPercentAttackSpeedModPerLevel;
    this.PercentSpellVampMod = PercentSpellVampMod;
    this.FlatMPRegenMod = FlatMPRegenMod;
    this.rFlatTimeDeadMod = rFlatTimeDeadMod;
    this.rFlatMPModPerLevel = rFlatMPModPerLevel;
    this.FlatAttackSpeedMod = FlatAttackSpeedMod;
    this.rFlatMagicPenetrationMod = rFlatMagicPenetrationMod;
    this.rFlatCritChanceModPerLevel = rFlatCritChanceModPerLevel;
    this.PercentDodgeMod = PercentDodgeMod;
    this.rFlatHPModPerLevel = rFlatHPModPerLevel;
    this.rFlatEnergyRegenModPerLevel = rFlatEnergyRegenModPerLevel;
    this.rPercentMovementSpeedModPerLevel = rPercentMovementSpeedModPerLevel;
    this.rFlatSpellBlockModPerLevel = rFlatSpellBlockModPerLevel;
    this.PercentMagicDamageMod = PercentMagicDamageMod;
    this.PercentMPPoolMod = PercentMPPoolMod;
    this.rPercentMagicPenetrationMod = rPercentMagicPenetrationMod;
    this.FlatMagicDamageMod = FlatMagicDamageMod;
    this.PercentMPRegenMod = PercentMPRegenMod;
    this.PercentPhysicalDamageMod = PercentPhysicalDamageMod;
    this.FlatArmorMod = FlatArmorMod;
    this.rFlatPhysicalDamageModPerLevel = rFlatPhysicalDamageModPerLevel;
    this.rFlatDodgeModPerLevel = rFlatDodgeModPerLevel;
    this.FlatPhysicalDamageMod = FlatPhysicalDamageMod;
    this.rPercentTimeDeadMod = rPercentTimeDeadMod;
    this.PercentHPPoolMod = PercentHPPoolMod;
    this.rFlatArmorPenetrationMod = rFlatArmorPenetrationMod;
    this.rFlatMagicPenetrationModPerLevel = rFlatMagicPenetrationModPerLevel;
    this.PercentArmorMod = PercentArmorMod;
    this.PercentCritChanceMod = PercentCritChanceMod;
    this.rFlatArmorPenetrationModPerLevel = rFlatArmorPenetrationModPerLevel;
    this.rFlatHPRegenModPerLevel = rFlatHPRegenModPerLevel;
    this.PercentEXPBonus = PercentEXPBonus;
    this.rPercentTimeDeadModPerLevel = rPercentTimeDeadModPerLevel;
    this.rFlatCritDamageModPerLevel = rFlatCritDamageModPerLevel;
    this.rFlatMovementSpeedModPerLevel = rFlatMovementSpeedModPerLevel;
    this.rPercentArmorPenetrationMod = rPercentArmorPenetrationMod;
    this.rPercentCooldownMod = rPercentCooldownMod;
    this.rPercentArmorPenetrationModPerLevel = rPercentArmorPenetrationModPerLevel;
    this.FlatEXPBonus = FlatEXPBonus;
    this.FlatHPPoolMod = FlatHPPoolMod;
    this.FlatCritChanceMod = FlatCritChanceMod;
    this.FlatHPRegenMod = FlatHPRegenMod;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof BasicDataStats)) return false;
    final BasicDataStats other = (BasicDataStats) obj;
    return true
        && Objects.equal(rPercentMagicPenetrationModPerLevel, other.rPercentMagicPenetrationModPerLevel)
        && Objects.equal(rFlatEnergyModPerLevel, other.rFlatEnergyModPerLevel)
        && Objects.equal(rFlatArmorModPerLevel, other.rFlatArmorModPerLevel)
        && Objects.equal(PercentSpellBlockMod, other.PercentSpellBlockMod)
        && Objects.equal(PercentHPRegenMod, other.PercentHPRegenMod)
        && Objects.equal(PercentMovementSpeedMod, other.PercentMovementSpeedMod)
        && Objects.equal(FlatSpellBlockMod, other.FlatSpellBlockMod)
        && Objects.equal(FlatCritDamageMod, other.FlatCritDamageMod)
        && Objects.equal(FlatEnergyPoolMod, other.FlatEnergyPoolMod)
        && Objects.equal(rFlatDodgeMod, other.rFlatDodgeMod)
        && Objects.equal(PercentLifeStealMod, other.PercentLifeStealMod)
        && Objects.equal(rFlatMPRegenModPerLevel, other.rFlatMPRegenModPerLevel)
        && Objects.equal(FlatMPPoolMod, other.FlatMPPoolMod)
        && Objects.equal(rFlatGoldPer10Mod, other.rFlatGoldPer10Mod)
        && Objects.equal(FlatMovementSpeedMod, other.FlatMovementSpeedMod)
        && Objects.equal(PercentCritDamageMod, other.PercentCritDamageMod)
        && Objects.equal(rFlatMagicDamageModPerLevel, other.rFlatMagicDamageModPerLevel)
        && Objects.equal(rPercentCooldownModPerLevel, other.rPercentCooldownModPerLevel)
        && Objects.equal(PercentAttackSpeedMod, other.PercentAttackSpeedMod)
        && Objects.equal(FlatBlockMod, other.FlatBlockMod)
        && Objects.equal(PercentBlockMod, other.PercentBlockMod)
        && Objects.equal(rFlatTimeDeadModPerLevel, other.rFlatTimeDeadModPerLevel)
        && Objects.equal(FlatEnergyRegenMod, other.FlatEnergyRegenMod)
        && Objects.equal(rPercentAttackSpeedModPerLevel, other.rPercentAttackSpeedModPerLevel)
        && Objects.equal(PercentSpellVampMod, other.PercentSpellVampMod)
        && Objects.equal(FlatMPRegenMod, other.FlatMPRegenMod)
        && Objects.equal(rFlatTimeDeadMod, other.rFlatTimeDeadMod)
        && Objects.equal(rFlatMPModPerLevel, other.rFlatMPModPerLevel)
        && Objects.equal(FlatAttackSpeedMod, other.FlatAttackSpeedMod)
        && Objects.equal(rFlatMagicPenetrationMod, other.rFlatMagicPenetrationMod)
        && Objects.equal(rFlatCritChanceModPerLevel, other.rFlatCritChanceModPerLevel)
        && Objects.equal(PercentDodgeMod, other.PercentDodgeMod)
        && Objects.equal(rFlatHPModPerLevel, other.rFlatHPModPerLevel)
        && Objects.equal(rFlatEnergyRegenModPerLevel, other.rFlatEnergyRegenModPerLevel)
        && Objects.equal(rPercentMovementSpeedModPerLevel, other.rPercentMovementSpeedModPerLevel)
        && Objects.equal(rFlatSpellBlockModPerLevel, other.rFlatSpellBlockModPerLevel)
        && Objects.equal(PercentMagicDamageMod, other.PercentMagicDamageMod)
        && Objects.equal(PercentMPPoolMod, other.PercentMPPoolMod)
        && Objects.equal(rPercentMagicPenetrationMod, other.rPercentMagicPenetrationMod)
        && Objects.equal(FlatMagicDamageMod, other.FlatMagicDamageMod)
        && Objects.equal(PercentMPRegenMod, other.PercentMPRegenMod)
        && Objects.equal(PercentPhysicalDamageMod, other.PercentPhysicalDamageMod)
        && Objects.equal(FlatArmorMod, other.FlatArmorMod)
        && Objects.equal(rFlatPhysicalDamageModPerLevel, other.rFlatPhysicalDamageModPerLevel)
        && Objects.equal(rFlatDodgeModPerLevel, other.rFlatDodgeModPerLevel)
        && Objects.equal(FlatPhysicalDamageMod, other.FlatPhysicalDamageMod)
        && Objects.equal(rPercentTimeDeadMod, other.rPercentTimeDeadMod)
        && Objects.equal(PercentHPPoolMod, other.PercentHPPoolMod)
        && Objects.equal(rFlatArmorPenetrationMod, other.rFlatArmorPenetrationMod)
        && Objects.equal(rFlatMagicPenetrationModPerLevel, other.rFlatMagicPenetrationModPerLevel)
        && Objects.equal(PercentArmorMod, other.PercentArmorMod)
        && Objects.equal(PercentCritChanceMod, other.PercentCritChanceMod)
        && Objects.equal(rFlatArmorPenetrationModPerLevel, other.rFlatArmorPenetrationModPerLevel)
        && Objects.equal(rFlatHPRegenModPerLevel, other.rFlatHPRegenModPerLevel)
        && Objects.equal(PercentEXPBonus, other.PercentEXPBonus)
        && Objects.equal(rPercentTimeDeadModPerLevel, other.rPercentTimeDeadModPerLevel)
        && Objects.equal(rFlatCritDamageModPerLevel, other.rFlatCritDamageModPerLevel)
        && Objects.equal(rFlatMovementSpeedModPerLevel, other.rFlatMovementSpeedModPerLevel)
        && Objects.equal(rPercentArmorPenetrationMod, other.rPercentArmorPenetrationMod)
        && Objects.equal(rPercentCooldownMod, other.rPercentCooldownMod)
        && Objects.equal(rPercentArmorPenetrationModPerLevel, other.rPercentArmorPenetrationModPerLevel)
        && Objects.equal(FlatEXPBonus, other.FlatEXPBonus)
        && Objects.equal(FlatHPPoolMod, other.FlatHPPoolMod)
        && Objects.equal(FlatCritChanceMod, other.FlatCritChanceMod)
        && Objects.equal(FlatHPRegenMod, other.FlatHPRegenMod);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        rPercentMagicPenetrationModPerLevel,
        rFlatEnergyModPerLevel,
        rFlatArmorModPerLevel,
        PercentSpellBlockMod,
        PercentHPRegenMod,
        PercentMovementSpeedMod,
        FlatSpellBlockMod,
        FlatCritDamageMod,
        FlatEnergyPoolMod,
        rFlatDodgeMod,
        PercentLifeStealMod,
        rFlatMPRegenModPerLevel,
        FlatMPPoolMod,
        rFlatGoldPer10Mod,
        FlatMovementSpeedMod,
        PercentCritDamageMod,
        rFlatMagicDamageModPerLevel,
        rPercentCooldownModPerLevel,
        PercentAttackSpeedMod,
        FlatBlockMod,
        PercentBlockMod,
        rFlatTimeDeadModPerLevel,
        FlatEnergyRegenMod,
        rPercentAttackSpeedModPerLevel,
        PercentSpellVampMod,
        FlatMPRegenMod,
        rFlatTimeDeadMod,
        rFlatMPModPerLevel,
        FlatAttackSpeedMod,
        rFlatMagicPenetrationMod,
        rFlatCritChanceModPerLevel,
        PercentDodgeMod,
        rFlatHPModPerLevel,
        rFlatEnergyRegenModPerLevel,
        rPercentMovementSpeedModPerLevel,
        rFlatSpellBlockModPerLevel,
        PercentMagicDamageMod,
        PercentMPPoolMod,
        rPercentMagicPenetrationMod,
        FlatMagicDamageMod,
        PercentMPRegenMod,
        PercentPhysicalDamageMod,
        FlatArmorMod,
        rFlatPhysicalDamageModPerLevel,
        rFlatDodgeModPerLevel,
        FlatPhysicalDamageMod,
        rPercentTimeDeadMod,
        PercentHPPoolMod,
        rFlatArmorPenetrationMod,
        rFlatMagicPenetrationModPerLevel,
        PercentArmorMod,
        PercentCritChanceMod,
        rFlatArmorPenetrationModPerLevel,
        rFlatHPRegenModPerLevel,
        PercentEXPBonus,
        rPercentTimeDeadModPerLevel,
        rFlatCritDamageModPerLevel,
        rFlatMovementSpeedModPerLevel,
        rPercentArmorPenetrationMod,
        rPercentCooldownMod,
        rPercentArmorPenetrationModPerLevel,
        FlatEXPBonus,
        FlatHPPoolMod,
        FlatCritChanceMod,
        FlatHPRegenMod);}
}
