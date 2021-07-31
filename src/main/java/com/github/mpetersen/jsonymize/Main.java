package com.github.mpetersen.jsonymize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Paths;

public class Main {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.err.println("Usage: jsonymize <filename>");
      System.exit(-1);
    }
    String inputFile = args[0];
    ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    Object plain = mapper.readValue(Paths.get(inputFile).toFile(), Object.class);
    Jsonymize jsonymize = new Jsonymize();
    Object anonymized = jsonymize.anonymize(plain, jsonymize);

    System.out.println(mapper.writeValueAsString(anonymized));
  }
}
