package com.github.mpetersen.jsonymize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class MapAnonymizerTest extends AbstractAnonymizerTest {
  @SuppressWarnings("unchecked")
  @Test
  public void verifyMap() {
    Map<String, String> input = Map.of("1", "1", "2", "2", "3", "3");
    Map<String, String> expected = Map.of("1", "a", "2", "b", "3", "c");
    Map<String, String> anonymized = (Map<String, String>) sut.anonymize(input, new Anonymizer() {
      @Override
      public boolean accepts(Object obj) {
        return true;
      }

      @SuppressWarnings("SuspiciousMethodCalls")
      @Override
      public Object anonymize(Object obj, Anonymizer next) {
        for (Map.Entry<?, ?> entry : input.entrySet()) {
          if (entry.getValue().equals(obj)) {
            return expected.get(entry.getKey());
          }
        }
        return null;
      }
    });
    assertEquals(expected, anonymized);
  }

  @Override
  protected Anonymizer createSut() {
    return new MapAnonymizer();
  }
}
