package com.nacho.random;

import static java.util.stream.Collectors.toMap;

import java.util.function.Function;

public class CharFrequencyWithStream {

  public static void main(final String[] args) {
    final String str = "nacho";

    System.out.println(str.chars() //
        .boxed() //
        .collect(toMap( //
            k -> (char) k.intValue(), //
            v -> 1, Integer::sum)));

    System.out.println(str.chars() //
        .mapToObj(c -> (char) c) //
        .collect(toMap( //
            Function.identity(), //
            v -> 1, //
            Integer::sum)));
  }
}
