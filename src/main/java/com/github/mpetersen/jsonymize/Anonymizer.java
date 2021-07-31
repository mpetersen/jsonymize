package com.github.mpetersen.jsonymize;

public interface Anonymizer {
  boolean accepts(Object obj);

  Object anonymize(Object obj, Anonymizer next);
}
