package com.mingweisamuel.zyra.dto;

import java.lang.String;
import java.util.List;

/**
 * Message
 *
 * This class is automagically generated from the <a href="https://developer.riotgames.com/api/methods">Riot API reference</a> using {@link com.mingweisamuel.zyra.build.RiotDtoGenerator}. */
public class Message {
  public String author;

  public String content;

  public String created_at;

  public String id;

  public String severity;

  public List<Translation> translations;

  public String updated_at;
}