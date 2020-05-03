package com.nacho.hackerrank.interviewpreparationkit.dictionariesandhashmaps;

import java.util.Set;
import java.util.stream.Collectors;

public class TwoStrings {

  static String twoStrings(final String s1, final String s2) {
    final Set<Character> s1Set = s1 //
        .chars() //
        .mapToObj(c -> (char) c) //
        .collect(Collectors.toSet());
    final boolean containsAny = s2.chars() //
        .mapToObj(c -> (char) c) //
        .anyMatch(c -> s1Set.contains(c));
    if (containsAny) {
      return "YES";
    }
    return "NO";
  }

  public static void main(final String[] args) {
    System.out.println(twoStrings("hello", "world"));
    System.out.println(twoStrings("hi", "world"));
  }
}
