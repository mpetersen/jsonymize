package com.github.mpetersen.jsonymize;

public class Jsonymize implements Anonymizer {
  private final Anonymizer[] anonymizers = {
      new ListAnonymizer(),
      new MapAnonymizer(),
      new NumberAnonymizer(),
      // Order of these anonymizers is important:
      new UUIDAnonymizer(),
      new IPAddressAnonymizer(),
      new StringAnonymizer()
  };

  @Override
  public boolean accepts(Object obj) {
    // accept any object
    return true;
  }

  @Override
  public Object anonymize(Object obj, Anonymizer next) {
    if (obj != null) {
      for (Anonymizer anonymizer : anonymizers) {
        if (anonymizer.accepts(obj)) {
          return anonymizer.anonymize(obj, next);
        }
      }
    }
    return obj;
  }
}
