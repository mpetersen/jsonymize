package com.github.mpetersen.jsonymize;

import java.util.UUID;

public class UUIDAnonymizer extends StringAnonymizer {
  @Override
  public boolean acceptsString(String str) {
    try {
      //noinspection ResultOfMethodCallIgnored
      UUID.fromString(str);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  @Override
  protected String anonymizeString(String str) {
    return UUID.randomUUID().toString();
  }
}
