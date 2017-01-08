package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;

/**
 * Incident
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version lol-status-v1.0 */
public class Incident {
  public boolean active;

  public String created_at;

  public long id;

  public List<Message> updates;
}
