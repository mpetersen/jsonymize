package com.github.mpetersen.jsonymize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberAnonymizerTest extends AbstractAnonymizerTest {
  @Test
  public void verifyNumber() {
    int input = 1234;
    assertTrue(sut.accepts(input));
    int output = (int) sut.anonymize(input, null);
    assertTrue(output >= 1000 && output < 10000, String.valueOf(output));
  }

  @Override
  protected Anonymizer createSut() {
    return new NumberAnonymizer();
  }
}
