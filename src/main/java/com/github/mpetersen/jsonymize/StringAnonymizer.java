package com.github.mpetersen.jsonymize;

import org.apache.commons.lang3.RandomStringUtils;

public class StringAnonymizer implements Anonymizer {
  @Override
  public final boolean accepts(Object obj) {
    return obj instanceof String && acceptsString((String) obj);
  }

  protected boolean acceptsString(String str) {
    return true;
  }

  @Override
  public final Object anonymize(Object obj, Anonymizer next) {
    return anonymizeString((String) obj);
  }

  protected String anonymizeString(String str) {
    return RandomStringUtils.randomAlphanumeric(str.length());
  }
}
