package com.mingweisamuel.zyra.dto;

/**
 * BannedChampion
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}. */
public class BannedChampion {
  /**
   * The ID of the banned champion */
  public long championId;

  /**
   * The turn during which the champion was banned */
  public int pickTurn;

  /**
   * The ID of the team that banned the champion */
  public long teamId;
}
