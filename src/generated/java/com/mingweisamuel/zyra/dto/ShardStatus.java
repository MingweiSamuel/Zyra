package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;

/**
 * ShardStatus
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}. */
public class ShardStatus {
  public String hostname;

  public List<String> locales;

  public String name;

  public String region_tag;

  public List<Service> services;

  public String slug;
}
