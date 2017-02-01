package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * BasicDataStats - This object contains basic data stats.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a>.
 *
 * @version lol-static-data-v1.2 */
public class BasicDataStats implements Serializable {
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

  public final double rFlatArmorModPerLevel;

  public final double rFlatArmorPenetrationMod;

  public final double rFlatArmorPenetrationModPerLevel;

  public final double rFlatCritChanceModPerLevel;

  public final double rFlatCritDamageModPerLevel;

  public final double rFlatDodgeMod;

  public final double rFlatDodgeModPerLevel;

  public final double rFlatEnergyModPerLevel;

  public final double rFlatEnergyRegenModPerLevel;

  public final double rFlatGoldPer10Mod;

  public final double rFlatHPModPerLevel;

  public final double rFlatHPRegenModPerLevel;

  public final double rFlatMPModPerLevel;

  public final double rFlatMPRegenModPerLevel;

  public final double rFlatMagicDamageModPerLevel;

  public final double rFlatMagicPenetrationMod;

  public final double rFlatMagicPenetrationModPerLevel;

  public final double rFlatMovementSpeedModPerLevel;

  public final double rFlatPhysicalDamageModPerLevel;

  public final double rFlatSpellBlockModPerLevel;

  public final double rFlatTimeDeadMod;

  public final double rFlatTimeDeadModPerLevel;

  public final double rPercentArmorPenetrationMod;

  public final double rPercentArmorPenetrationModPerLevel;

  public final double rPercentAttackSpeedModPerLevel;

  public final double rPercentCooldownMod;

  public final double rPercentCooldownModPerLevel;

  public final double rPercentMagicPenetrationMod;

  public final double rPercentMagicPenetrationModPerLevel;

  public final double rPercentMovementSpeedModPerLevel;

  public final double rPercentTimeDeadMod;

  public final double rPercentTimeDeadModPerLevel;

  public BasicDataStats(final double FlatArmorMod, final double FlatAttackSpeedMod,
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
      final double PercentSpellVampMod, final double rFlatArmorModPerLevel,
      final double rFlatArmorPenetrationMod, final double rFlatArmorPenetrationModPerLevel,
      final double rFlatCritChanceModPerLevel, final double rFlatCritDamageModPerLevel,
      final double rFlatDodgeMod, final double rFlatDodgeModPerLevel,
      final double rFlatEnergyModPerLevel, final double rFlatEnergyRegenModPerLevel,
      final double rFlatGoldPer10Mod, final double rFlatHPModPerLevel,
      final double rFlatHPRegenModPerLevel, final double rFlatMPModPerLevel,
      final double rFlatMPRegenModPerLevel, final double rFlatMagicDamageModPerLevel,
      final double rFlatMagicPenetrationMod, final double rFlatMagicPenetrationModPerLevel,
      final double rFlatMovementSpeedModPerLevel, final double rFlatPhysicalDamageModPerLevel,
      final double rFlatSpellBlockModPerLevel, final double rFlatTimeDeadMod,
      final double rFlatTimeDeadModPerLevel, final double rPercentArmorPenetrationMod,
      final double rPercentArmorPenetrationModPerLevel, final double rPercentAttackSpeedModPerLevel,
      final double rPercentCooldownMod, final double rPercentCooldownModPerLevel,
      final double rPercentMagicPenetrationMod, final double rPercentMagicPenetrationModPerLevel,
      final double rPercentMovementSpeedModPerLevel, final double rPercentTimeDeadMod,
      final double rPercentTimeDeadModPerLevel) {
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
    this.rFlatArmorModPerLevel = rFlatArmorModPerLevel;
    this.rFlatArmorPenetrationMod = rFlatArmorPenetrationMod;
    this.rFlatArmorPenetrationModPerLevel = rFlatArmorPenetrationModPerLevel;
    this.rFlatCritChanceModPerLevel = rFlatCritChanceModPerLevel;
    this.rFlatCritDamageModPerLevel = rFlatCritDamageModPerLevel;
    this.rFlatDodgeMod = rFlatDodgeMod;
    this.rFlatDodgeModPerLevel = rFlatDodgeModPerLevel;
    this.rFlatEnergyModPerLevel = rFlatEnergyModPerLevel;
    this.rFlatEnergyRegenModPerLevel = rFlatEnergyRegenModPerLevel;
    this.rFlatGoldPer10Mod = rFlatGoldPer10Mod;
    this.rFlatHPModPerLevel = rFlatHPModPerLevel;
    this.rFlatHPRegenModPerLevel = rFlatHPRegenModPerLevel;
    this.rFlatMPModPerLevel = rFlatMPModPerLevel;
    this.rFlatMPRegenModPerLevel = rFlatMPRegenModPerLevel;
    this.rFlatMagicDamageModPerLevel = rFlatMagicDamageModPerLevel;
    this.rFlatMagicPenetrationMod = rFlatMagicPenetrationMod;
    this.rFlatMagicPenetrationModPerLevel = rFlatMagicPenetrationModPerLevel;
    this.rFlatMovementSpeedModPerLevel = rFlatMovementSpeedModPerLevel;
    this.rFlatPhysicalDamageModPerLevel = rFlatPhysicalDamageModPerLevel;
    this.rFlatSpellBlockModPerLevel = rFlatSpellBlockModPerLevel;
    this.rFlatTimeDeadMod = rFlatTimeDeadMod;
    this.rFlatTimeDeadModPerLevel = rFlatTimeDeadModPerLevel;
    this.rPercentArmorPenetrationMod = rPercentArmorPenetrationMod;
    this.rPercentArmorPenetrationModPerLevel = rPercentArmorPenetrationModPerLevel;
    this.rPercentAttackSpeedModPerLevel = rPercentAttackSpeedModPerLevel;
    this.rPercentCooldownMod = rPercentCooldownMod;
    this.rPercentCooldownModPerLevel = rPercentCooldownModPerLevel;
    this.rPercentMagicPenetrationMod = rPercentMagicPenetrationMod;
    this.rPercentMagicPenetrationModPerLevel = rPercentMagicPenetrationModPerLevel;
    this.rPercentMovementSpeedModPerLevel = rPercentMovementSpeedModPerLevel;
    this.rPercentTimeDeadMod = rPercentTimeDeadMod;
    this.rPercentTimeDeadModPerLevel = rPercentTimeDeadModPerLevel;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof BasicDataStats)) return false;
    final BasicDataStats other = (BasicDataStats) obj;
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
        && Objects.equal(PercentSpellVampMod, other.PercentSpellVampMod)
        && Objects.equal(rFlatArmorModPerLevel, other.rFlatArmorModPerLevel)
        && Objects.equal(rFlatArmorPenetrationMod, other.rFlatArmorPenetrationMod)
        && Objects.equal(rFlatArmorPenetrationModPerLevel, other.rFlatArmorPenetrationModPerLevel)
        && Objects.equal(rFlatCritChanceModPerLevel, other.rFlatCritChanceModPerLevel)
        && Objects.equal(rFlatCritDamageModPerLevel, other.rFlatCritDamageModPerLevel)
        && Objects.equal(rFlatDodgeMod, other.rFlatDodgeMod)
        && Objects.equal(rFlatDodgeModPerLevel, other.rFlatDodgeModPerLevel)
        && Objects.equal(rFlatEnergyModPerLevel, other.rFlatEnergyModPerLevel)
        && Objects.equal(rFlatEnergyRegenModPerLevel, other.rFlatEnergyRegenModPerLevel)
        && Objects.equal(rFlatGoldPer10Mod, other.rFlatGoldPer10Mod)
        && Objects.equal(rFlatHPModPerLevel, other.rFlatHPModPerLevel)
        && Objects.equal(rFlatHPRegenModPerLevel, other.rFlatHPRegenModPerLevel)
        && Objects.equal(rFlatMPModPerLevel, other.rFlatMPModPerLevel)
        && Objects.equal(rFlatMPRegenModPerLevel, other.rFlatMPRegenModPerLevel)
        && Objects.equal(rFlatMagicDamageModPerLevel, other.rFlatMagicDamageModPerLevel)
        && Objects.equal(rFlatMagicPenetrationMod, other.rFlatMagicPenetrationMod)
        && Objects.equal(rFlatMagicPenetrationModPerLevel, other.rFlatMagicPenetrationModPerLevel)
        && Objects.equal(rFlatMovementSpeedModPerLevel, other.rFlatMovementSpeedModPerLevel)
        && Objects.equal(rFlatPhysicalDamageModPerLevel, other.rFlatPhysicalDamageModPerLevel)
        && Objects.equal(rFlatSpellBlockModPerLevel, other.rFlatSpellBlockModPerLevel)
        && Objects.equal(rFlatTimeDeadMod, other.rFlatTimeDeadMod)
        && Objects.equal(rFlatTimeDeadModPerLevel, other.rFlatTimeDeadModPerLevel)
        && Objects.equal(rPercentArmorPenetrationMod, other.rPercentArmorPenetrationMod)
        && Objects.equal(rPercentArmorPenetrationModPerLevel, other.rPercentArmorPenetrationModPerLevel)
        && Objects.equal(rPercentAttackSpeedModPerLevel, other.rPercentAttackSpeedModPerLevel)
        && Objects.equal(rPercentCooldownMod, other.rPercentCooldownMod)
        && Objects.equal(rPercentCooldownModPerLevel, other.rPercentCooldownModPerLevel)
        && Objects.equal(rPercentMagicPenetrationMod, other.rPercentMagicPenetrationMod)
        && Objects.equal(rPercentMagicPenetrationModPerLevel, other.rPercentMagicPenetrationModPerLevel)
        && Objects.equal(rPercentMovementSpeedModPerLevel, other.rPercentMovementSpeedModPerLevel)
        && Objects.equal(rPercentTimeDeadMod, other.rPercentTimeDeadMod)
        && Objects.equal(rPercentTimeDeadModPerLevel, other.rPercentTimeDeadModPerLevel);}

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
        PercentSpellVampMod,
        rFlatArmorModPerLevel,
        rFlatArmorPenetrationMod,
        rFlatArmorPenetrationModPerLevel,
        rFlatCritChanceModPerLevel,
        rFlatCritDamageModPerLevel,
        rFlatDodgeMod,
        rFlatDodgeModPerLevel,
        rFlatEnergyModPerLevel,
        rFlatEnergyRegenModPerLevel,
        rFlatGoldPer10Mod,
        rFlatHPModPerLevel,
        rFlatHPRegenModPerLevel,
        rFlatMPModPerLevel,
        rFlatMPRegenModPerLevel,
        rFlatMagicDamageModPerLevel,
        rFlatMagicPenetrationMod,
        rFlatMagicPenetrationModPerLevel,
        rFlatMovementSpeedModPerLevel,
        rFlatPhysicalDamageModPerLevel,
        rFlatSpellBlockModPerLevel,
        rFlatTimeDeadMod,
        rFlatTimeDeadModPerLevel,
        rPercentArmorPenetrationMod,
        rPercentArmorPenetrationModPerLevel,
        rPercentAttackSpeedModPerLevel,
        rPercentCooldownMod,
        rPercentCooldownModPerLevel,
        rPercentMagicPenetrationMod,
        rPercentMagicPenetrationModPerLevel,
        rPercentMovementSpeedModPerLevel,
        rPercentTimeDeadMod,
        rPercentTimeDeadModPerLevel);}
}
