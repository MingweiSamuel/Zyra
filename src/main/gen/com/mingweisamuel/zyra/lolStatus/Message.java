package com.mingweisamuel.zyra.lolStatus;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

/**
 * Message.<br><br>
 *
 * This class was automatically generated from the <a href="http://www.mingweisamuel.com/riotapi-schema/openapi-3.0.0.min.json">Riot API reference</a>. */
public class Message implements Serializable {
  public final String author;

  public final String content;

  public final String created_at;

  public final String id;

  public final String severity;

  public final List<Translation> translations;

  public final String updated_at;

  public Message(final String author, final String content, final String created_at,
      final String id, final String severity, final List<Translation> translations,
      final String updated_at) {
    this.author = author;
    this.content = content;
    this.created_at = created_at;
    this.id = id;
    this.severity = severity;
    this.translations = translations;
    this.updated_at = updated_at;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Message)) return false;
    final Message other = (Message) obj;
    return true
        && Objects.equal(author, other.author)
        && Objects.equal(content, other.content)
        && Objects.equal(created_at, other.created_at)
        && Objects.equal(id, other.id)
        && Objects.equal(severity, other.severity)
        && Objects.equal(translations, other.translations)
        && Objects.equal(updated_at, other.updated_at);}

  @Override
  public int hashCode() {
    return Objects.hashCode(0,
        author,
        content,
        created_at,
        id,
        severity,
        translations,
        updated_at);}
}
