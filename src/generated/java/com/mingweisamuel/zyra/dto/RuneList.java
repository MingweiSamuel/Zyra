package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.Map;

/**
 * RuneList - This object contains rune list data.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}. */
public class RuneList {
  public BasicData basic;

  public Map<String, Rune> data;

  public String type;

  public String version;
}
