package com.github.mpetersen.jsonymize;

import java.util.HashMap;
import java.util.Map;

public class MapAnonymizer implements Anonymizer {
  @Override
  public boolean accepts(Object obj) {
    return obj instanceof Map<?, ?>;
  }

  @Override
  public Object anonymize(Object obj, Anonymizer next) {
    Map<Object, Object> result = new HashMap<>();
    for (Map.Entry<?, ?> entry : ((Map<?, ?>) obj).entrySet()) {
      Object value = entry.getValue();
      if (next.accepts(value)) {
        result.put(entry.getKey(), next.anonymize(value, next));
      }
    }
    return result;
  }
}
