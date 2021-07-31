package com.github.mpetersen.jsonymize;

import java.security.SecureRandom;
import java.util.Random;

public class NumberAnonymizer implements Anonymizer {
  private final Random secureRandom = new SecureRandom();

  @Override
  public boolean accepts(Object obj) {
    return obj instanceof Number;
  }

  @Override
  public Object anonymize(Object obj, Anonymizer next) {
    char[] chars = obj.toString().toCharArray();
    StringBuilder sb = new StringBuilder(chars.length);
    boolean isFirstDigit = true;
    for (char ch : chars) {
      if (Character.isDigit(ch)) {
        int random;
        do {
          random = secureRandom.nextInt(10);
        } while (isFirstDigit && random == 0);
        sb.append(random);
        isFirstDigit = false;
      } else {
        sb.append(ch);
      }
    }
    String ranStr = sb.toString();

    if (obj instanceof Integer) {
      return Integer.valueOf(ranStr);
    }
    if (obj instanceof Long) {
      return Long.valueOf(ranStr);
    }
    if (obj instanceof Float) {
      return Float.valueOf(ranStr);
    }
    if (obj instanceof Double) {
      return Double.valueOf(ranStr);
    }
    return Byte.valueOf(ranStr);
  }
}
