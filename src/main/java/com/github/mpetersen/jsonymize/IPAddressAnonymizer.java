package com.github.mpetersen.jsonymize;

import java.security.SecureRandom;
import java.util.Random;

public class IPAddressAnonymizer extends StringAnonymizer {
  private final Random secureRandom = new SecureRandom();

  @Override
  protected boolean acceptsString(String str) {
    return str.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
  }

  @Override
  protected String anonymizeString(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      if (i > 0) {
        sb.append('.');
      }
      sb.append(secureRandom.nextInt(256));
    }
    return sb.toString();
  }
}
