package com.mingweisamuel.zyra.dto;

import java.util.List;

/**
 * MatchList - This object contains match list information
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}. */
public class MatchList {
  public int endIndex;

  public List<MatchReference> matches;

  public int startIndex;

  public int totalGames;
}