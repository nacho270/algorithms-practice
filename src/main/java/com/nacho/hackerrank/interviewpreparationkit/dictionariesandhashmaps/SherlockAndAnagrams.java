package com.nacho.hackerrank.interviewpreparationkit.dictionariesandhashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

  static int sherlockAndAnagrams(final String s) {
    final Map<String, Integer> anagramCount = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        final char[] charArray = s.substring(i, j + 1).toCharArray();
        Arrays.sort(charArray);
        final String sortedString = new String(charArray);
        anagramCount.compute(sortedString, (str, count) -> count == null ? 1 : count + 1);
      }
    }
    return anagramCount.values().stream() //
        .filter(v -> v > 1) //
        .mapToInt(v -> v * (v - 1) / 2) //
        .sum();
  }

  public static void main(final String[] args) {
    System.out.println(sherlockAndAnagrams("ifailuhkqq"));
    System.out.println(sherlockAndAnagrams("kkkk"));
  }
}
