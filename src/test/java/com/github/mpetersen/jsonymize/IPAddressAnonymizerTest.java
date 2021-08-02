package com.github.mpetersen.jsonymize;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IPAddressAnonymizerTest {
  @Test
  void verifyAnonymization() {
    Object input = "12.34.567.8";
    Anonymizer sut = new IPAddressAnonymizer();
    assertTrue(sut.accepts(input));
    Object output = sut.anonymize(input, null);
    assertTrue(sut.accepts(output));
  }
}
