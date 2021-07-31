package com.github.mpetersen.jsonymize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListAnonymizerTest extends AbstractAnonymizerTest {
  @Test
  public void verifyList() {
    List<String> input = Arrays.asList("1", "2", "3");
    List<String> expected = Arrays.asList("a", "b", "c");
    //noinspection unchecked
    List<String> anonymized = (List<String>) sut.anonymize(input, new Anonymizer() {
      private int count = 0;

      @Override
      public boolean accepts(Object obj) {
        return true;
      }

      @Override
      public Object anonymize(Object obj, Anonymizer next) {
        assertEquals(input.get(count), obj);
        return expected.get(count++);
      }
    });
    assertEquals(expected, anonymized);
  }

  @Override
  protected Anonymizer createSut() {
    return new ListAnonymizer();
  }
}
