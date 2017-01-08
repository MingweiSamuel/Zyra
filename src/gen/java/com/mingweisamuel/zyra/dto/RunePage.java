package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;

/**
 * RunePage - This object contains rune page information.
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}.
 *
 * @version summoner-v1.4 */
public class RunePage {
  /**
   * Indicates if the page is the current page. */
  public boolean current;

  /**
   * Rune page ID. */
  public long id;

  /**
   * Rune page name. */
  public String name;

  /**
   * Collection of rune slots associated with the rune page. */
  public List<RuneSlot> slots;
}
