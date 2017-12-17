package com.mingweisamuel.zyra.lolStaticData;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;

/**
 * RuneStats.<br><br>
 *
 * This object contains stats for runes..<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class RuneStats implements Serializable {
  public final double FlatArmorMod;

  public final double FlatArmorModPerLevel;

  public final double FlatArmorPenetrationMod;

  public final double FlatArmorPenetrationModPerLevel;

  public final double FlatAttackSpeedMod;

  public final double FlatBlockMod;

  public final double FlatCritChanceMod;

  public final double FlatCritChanceModPerLevel;

  public final double FlatCritDamageMod;

  public final double FlatCritDamageModPerLevel;

  public final double FlatDodgeMod;

  public final double FlatDodgeModPerLevel;

  public final double FlatEXPBonus;

  public final double FlatEnergyModPerLevel;

  public final double FlatEnergyPoolMod;

  public final double FlatEnergyRegenMod;

  public final double FlatEnergyRegenModPerLevel;

  public final double FlatGoldPer10Mod;

  public final double FlatHPModPerLevel;

  public final double FlatHPPoolMod;

  public final double FlatHPRegenMod;

  public final double FlatHPRegenModPerLevel;

  public final double FlatMPModPerLevel;

  public final double FlatMPPoolMod;

  public final double FlatMPRegenMod;

  public final double FlatMPRegenModPerLevel;

  public final double FlatMagicDamageMod;

  public final double FlatMagicDamageModPerLevel;

  public final double FlatMagicPenetrationMod;

  public final double FlatMagicPenetrationModPerLevel;

  public final double FlatMovementSpeedMod;

  public final double FlatMovementSpeedModPerLevel;

  public final double FlatPhysicalDamageMod;

  public final double FlatPhysicalDamageModPerLevel;

  public final double FlatSpellBlockMod;

  public final double FlatSpellBlockModPerLevel;

  public final double FlatTimeDeadMod;

  public final double FlatTimeDeadModPerLevel;

  public final double PercentArmorMod;

  public final double PercentArmorPenetrationMod;

  public final double PercentArmorPenetrationModPerLevel;

  public final double PercentAttackSpeedMod;

  public final double PercentAttackSpeedModPerLevel;

  public final double PercentBlockMod;

  public final double PercentCooldownMod;

  public final double PercentCooldownModPerLevel;

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

  public final double PercentMagicPenetrationMod;

  public final double PercentMagicPenetrationModPerLevel;

  public final double PercentMovementSpeedMod;

  public final double PercentMovementSpeedModPerLevel;

  public final double PercentPhysicalDamageMod;

  public final double PercentSpellBlockMod;

  public final double PercentSpellVampMod;

  public final double PercentTimeDeadMod;

  public final double PercentTimeDeadModPerLevel;

  public RuneStats(final double FlatArmorMod, final double FlatArmorModPerLevel,
      final double FlatArmorPenetrationMod, final double FlatArmorPenetrationModPerLevel,
      final double FlatAttackSpeedMod, final double FlatBlockMod, final double FlatCritChanceMod,
      final double FlatCritChanceModPerLevel, final double FlatCritDamageMod,
      final double FlatCritDamageModPerLevel, final double FlatDodgeMod,
      final double FlatDodgeModPerLevel, final double FlatEXPBonus,
      final double FlatEnergyModPerLevel, final double FlatEnergyPoolMod,
      final double FlatEnergyRegenMod, final double FlatEnergyRegenModPerLevel,
      final double FlatGoldPer10Mod, final double FlatHPModPerLevel, final double FlatHPPoolMod,
      final double FlatHPRegenMod, final double FlatHPRegenModPerLevel,
      final double FlatMPModPerLevel, final double FlatMPPoolMod, final double FlatMPRegenMod,
      final double FlatMPRegenModPerLevel, final double FlatMagicDamageMod,
      final double FlatMagicDamageModPerLevel, final double FlatMagicPenetrationMod,
      final double FlatMagicPenetrationModPerLevel, final double FlatMovementSpeedMod,
      final double FlatMovementSpeedModPerLevel, final double FlatPhysicalDamageMod,
      final double FlatPhysicalDamageModPerLevel, final double FlatSpellBlockMod,
      final double FlatSpellBlockModPerLevel, final double FlatTimeDeadMod,
      final double FlatTimeDeadModPerLevel, final double PercentArmorMod,
      final double PercentArmorPenetrationMod, final double PercentArmorPenetrationModPerLevel,
      final double PercentAttackSpeedMod, final double PercentAttackSpeedModPerLevel,
      final double PercentBlockMod, final double PercentCooldownMod,
      final double PercentCooldownModPerLevel, final double PercentCritChanceMod,
      final double PercentCritDamageMod, final double PercentDodgeMod, final double PercentEXPBonus,
      final double PercentHPPoolMod, final double PercentHPRegenMod,
      final double PercentLifeStealMod, final double PercentMPPoolMod,
      final double PercentMPRegenMod, final double PercentMagicDamageMod,
      final double PercentMagicPenetrationMod, final double PercentMagicPenetrationModPerLevel,
      final double PercentMovementSpeedMod, final double PercentMovementSpeedModPerLevel,
      final double PercentPhysicalDamageMod, final double PercentSpellBlockMod,
      final double PercentSpellVampMod, final double PercentTimeDeadMod,
      final double PercentTimeDeadModPerLevel) {
    this.FlatArmorMod = FlatArmorMod;
    this.FlatArmorModPerLevel = FlatArmorModPerLevel;
    this.FlatArmorPenetrationMod = FlatArmorPenetrationMod;
    this.FlatArmorPenetrationModPerLevel = FlatArmorPenetrationModPerLevel;
    this.FlatAttackSpeedMod = FlatAttackSpeedMod;
    this.FlatBlockMod = FlatBlockMod;
    this.FlatCritChanceMod = FlatCritChanceMod;
    this.FlatCritChanceModPerLevel = FlatCritChanceModPerLevel;
    this.FlatCritDamageMod = FlatCritDamageMod;
    this.FlatCritDamageModPerLevel = FlatCritDamageModPerLevel;
    this.FlatDodgeMod = FlatDodgeMod;
    this.FlatDodgeModPerLevel = FlatDodgeModPerLevel;
    this.FlatEXPBonus = FlatEXPBonus;
    this.FlatEnergyModPerLevel = FlatEnergyModPerLevel;
    this.FlatEnergyPoolMod = FlatEnergyPoolMod;
    this.FlatEnergyRegenMod = FlatEnergyRegenMod;
    this.FlatEnergyRegenModPerLevel = FlatEnergyRegenModPerLevel;
    this.FlatGoldPer10Mod = FlatGoldPer10Mod;
    this.FlatHPModPerLevel = FlatHPModPerLevel;
    this.FlatHPPoolMod = FlatHPPoolMod;
    this.FlatHPRegenMod = FlatHPRegenMod;
    this.FlatHPRegenModPerLevel = FlatHPRegenModPerLevel;
    this.FlatMPModPerLevel = FlatMPModPerLevel;
    this.FlatMPPoolMod = FlatMPPoolMod;
    this.FlatMPRegenMod = FlatMPRegenMod;
    this.FlatMPRegenModPerLevel = FlatMPRegenModPerLevel;
    this.FlatMagicDamageMod = FlatMagicDamageMod;
    this.FlatMagicDamageModPerLevel = FlatMagicDamageModPerLevel;
    this.FlatMagicPenetrationMod = FlatMagicPenetrationMod;
    this.FlatMagicPenetrationModPerLevel = FlatMagicPenetrationModPerLevel;
    this.FlatMovementSpeedMod = FlatMovementSpeedMod;
    this.FlatMovementSpeedModPerLevel = FlatMovementSpeedModPerLevel;
    this.FlatPhysicalDamageMod = FlatPhysicalDamageMod;
    this.FlatPhysicalDamageModPerLevel = FlatPhysicalDamageModPerLevel;
    this.FlatSpellBlockMod = FlatSpellBlockMod;
    this.FlatSpellBlockModPerLevel = FlatSpellBlockModPerLevel;
    this.FlatTimeDeadMod = FlatTimeDeadMod;
    this.FlatTimeDeadModPerLevel = FlatTimeDeadModPerLevel;
    this.PercentArmorMod = PercentArmorMod;
    this.PercentArmorPenetrationMod = PercentArmorPenetrationMod;
    this.PercentArmorPenetrationModPerLevel = PercentArmorPenetrationModPerLevel;
    this.PercentAttackSpeedMod = PercentAttackSpeedMod;
    this.PercentAttackSpeedModPerLevel = PercentAttackSpeedModPerLevel;
    this.PercentBlockMod = PercentBlockMod;
    this.PercentCooldownMod = PercentCooldownMod;
    this.PercentCooldownModPerLevel = PercentCooldownModPerLevel;
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
    this.PercentMagicPenetrationMod = PercentMagicPenetrationMod;
    this.PercentMagicPenetrationModPerLevel = PercentMagicPenetrationModPerLevel;
    this.PercentMovementSpeedMod = PercentMovementSpeedMod;
    this.PercentMovementSpeedModPerLevel = PercentMovementSpeedModPerLevel;
    this.PercentPhysicalDamageMod = PercentPhysicalDamageMod;
    this.PercentSpellBlockMod = PercentSpellBlockMod;
    this.PercentSpellVampMod = PercentSpellVampMod;
    this.PercentTimeDeadMod = PercentTimeDeadMod;
    this.PercentTimeDeadModPerLevel = PercentTimeDeadModPerLevel;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof RuneStats)) return false;
    final RuneStats other = (RuneStats) obj;
    return true
        && Objects.equal(FlatArmorMod, other.FlatArmorMod)
        && Objects.equal(FlatArmorModPerLevel, other.FlatArmorModPerLevel)
        && Objects.equal(FlatArmorPenetrationMod, other.FlatArmorPenetrationMod)
        && Objects.equal(FlatArmorPenetrationModPerLevel, other.FlatArmorPenetrationModPerLevel)
        && Objects.equal(FlatAttackSpeedMod, other.FlatAttackSpeedMod)
        && Objects.equal(FlatBlockMod, other.FlatBlockMod)
        && Objects.equal(FlatCritChanceMod, other.FlatCritChanceMod)
        && Objects.equal(FlatCritChanceModPerLevel, other.FlatCritChanceModPerLevel)
        && Objects.equal(FlatCritDamageMod, other.FlatCritDamageMod)
        && Objects.equal(FlatCritDamageModPerLevel, other.FlatCritDamageModPerLevel)
        && Objects.equal(FlatDodgeMod, other.FlatDodgeMod)
        && Objects.equal(FlatDodgeModPerLevel, other.FlatDodgeModPerLevel)
        && Objects.equal(FlatEXPBonus, other.FlatEXPBonus)
        && Objects.equal(FlatEnergyModPerLevel, other.FlatEnergyModPerLevel)
        && Objects.equal(FlatEnergyPoolMod, other.FlatEnergyPoolMod)
        && Objects.equal(FlatEnergyRegenMod, other.FlatEnergyRegenMod)
        && Objects.equal(FlatEnergyRegenModPerLevel, other.FlatEnergyRegenModPerLevel)
        && Objects.equal(FlatGoldPer10Mod, other.FlatGoldPer10Mod)
        && Objects.equal(FlatHPModPerLevel, other.FlatHPModPerLevel)
        && Objects.equal(FlatHPPoolMod, other.FlatHPPoolMod)
        && Objects.equal(FlatHPRegenMod, other.FlatHPRegenMod)
        && Objects.equal(FlatHPRegenModPerLevel, other.FlatHPRegenModPerLevel)
        && Objects.equal(FlatMPModPerLevel, other.FlatMPModPerLevel)
        && Objects.equal(FlatMPPoolMod, other.FlatMPPoolMod)
        && Objects.equal(FlatMPRegenMod, other.FlatMPRegenMod)
        && Objects.equal(FlatMPRegenModPerLevel, other.FlatMPRegenModPerLevel)
        && Objects.equal(FlatMagicDamageMod, other.FlatMagicDamageMod)
        && Objects.equal(FlatMagicDamageModPerLevel, other.FlatMagicDamageModPerLevel)
        && Objects.equal(FlatMagicPenetrationMod, other.FlatMagicPenetrationMod)
        && Objects.equal(FlatMagicPenetrationModPerLevel, other.FlatMagicPenetrationModPerLevel)
        && Objects.equal(FlatMovementSpeedMod, other.FlatMovementSpeedMod)
        && Objects.equal(FlatMovementSpeedModPerLevel, other.FlatMovementSpeedModPerLevel)
        && Objects.equal(FlatPhysicalDamageMod, other.FlatPhysicalDamageMod)
        && Objects.equal(FlatPhysicalDamageModPerLevel, other.FlatPhysicalDamageModPerLevel)
        && Objects.equal(FlatSpellBlockMod, other.FlatSpellBlockMod)
        && Objects.equal(FlatSpellBlockModPerLevel, other.FlatSpellBlockModPerLevel)
        && Objects.equal(FlatTimeDeadMod, other.FlatTimeDeadMod)
        && Objects.equal(FlatTimeDeadModPerLevel, other.FlatTimeDeadModPerLevel)
        && Objects.equal(PercentArmorMod, other.PercentArmorMod)
        && Objects.equal(PercentArmorPenetrationMod, other.PercentArmorPenetrationMod)
        && Objects.equal(PercentArmorPenetrationModPerLevel, other.PercentArmorPenetrationModPerLevel)
        && Objects.equal(PercentAttackSpeedMod, other.PercentAttackSpeedMod)
        && Objects.equal(PercentAttackSpeedModPerLevel, other.PercentAttackSpeedModPerLevel)
        && Objects.equal(PercentBlockMod, other.PercentBlockMod)
        && Objects.equal(PercentCooldownMod, other.PercentCooldownMod)
        && Objects.equal(PercentCooldownModPerLevel, other.PercentCooldownModPerLevel)
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
        && Objects.equal(PercentMagicPenetrationMod, other.PercentMagicPenetrationMod)
        && Objects.equal(PercentMagicPenetrationModPerLevel, other.PercentMagicPenetrationModPerLevel)
        && Objects.equal(PercentMovementSpeedMod, other.PercentMovementSpeedMod)
        && Objects.equal(PercentMovementSpeedModPerLevel, other.PercentMovementSpeedModPerLevel)
        && Objects.equal(PercentPhysicalDamageMod, other.PercentPhysicalDamageMod)
        && Objects.equal(PercentSpellBlockMod, other.PercentSpellBlockMod)
        && Objects.equal(PercentSpellVampMod, other.PercentSpellVampMod)
        && Objects.equal(PercentTimeDeadMod, other.PercentTimeDeadMod)
        && Objects.equal(PercentTimeDeadModPerLevel, other.PercentTimeDeadModPerLevel);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        FlatArmorMod,
        FlatArmorModPerLevel,
        FlatArmorPenetrationMod,
        FlatArmorPenetrationModPerLevel,
        FlatAttackSpeedMod,
        FlatBlockMod,
        FlatCritChanceMod,
        FlatCritChanceModPerLevel,
        FlatCritDamageMod,
        FlatCritDamageModPerLevel,
        FlatDodgeMod,
        FlatDodgeModPerLevel,
        FlatEXPBonus,
        FlatEnergyModPerLevel,
        FlatEnergyPoolMod,
        FlatEnergyRegenMod,
        FlatEnergyRegenModPerLevel,
        FlatGoldPer10Mod,
        FlatHPModPerLevel,
        FlatHPPoolMod,
        FlatHPRegenMod,
        FlatHPRegenModPerLevel,
        FlatMPModPerLevel,
        FlatMPPoolMod,
        FlatMPRegenMod,
        FlatMPRegenModPerLevel,
        FlatMagicDamageMod,
        FlatMagicDamageModPerLevel,
        FlatMagicPenetrationMod,
        FlatMagicPenetrationModPerLevel,
        FlatMovementSpeedMod,
        FlatMovementSpeedModPerLevel,
        FlatPhysicalDamageMod,
        FlatPhysicalDamageModPerLevel,
        FlatSpellBlockMod,
        FlatSpellBlockModPerLevel,
        FlatTimeDeadMod,
        FlatTimeDeadModPerLevel,
        PercentArmorMod,
        PercentArmorPenetrationMod,
        PercentArmorPenetrationModPerLevel,
        PercentAttackSpeedMod,
        PercentAttackSpeedModPerLevel,
        PercentBlockMod,
        PercentCooldownMod,
        PercentCooldownModPerLevel,
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
        PercentMagicPenetrationMod,
        PercentMagicPenetrationModPerLevel,
        PercentMovementSpeedMod,
        PercentMovementSpeedModPerLevel,
        PercentPhysicalDamageMod,
        PercentSpellBlockMod,
        PercentSpellVampMod,
        PercentTimeDeadMod,
        PercentTimeDeadModPerLevel);}
}
