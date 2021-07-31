package com.github.mpetersen.jsonymize;

import java.util.ArrayList;
import java.util.List;

public class ListAnonymizer implements Anonymizer {
  @Override
  public boolean accepts(Object obj) {
    return obj instanceof List;
  }

  @Override
  public Object anonymize(Object obj, Anonymizer next) {
    List<Object> result = new ArrayList<>();
    for (Object item : (List<?>) obj) {
      if (next.accepts(item)) {
        result.add(next.anonymize(item, next));
      }
    }
    return result;
  }
}
