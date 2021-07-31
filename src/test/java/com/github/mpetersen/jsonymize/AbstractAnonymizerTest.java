package com.github.mpetersen.jsonymize;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractAnonymizerTest {
  protected Anonymizer sut;

  @BeforeEach
  public void setupAnonymizer() {
    sut = createSut();
  }

  protected abstract Anonymizer createSut();

  @Test
  public void verifyDoesNotAcceptString() {
    assertFalse(sut.accepts("Test"));
  }
}
