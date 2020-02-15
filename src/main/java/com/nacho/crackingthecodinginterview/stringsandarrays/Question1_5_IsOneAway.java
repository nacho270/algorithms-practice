package com.nacho.crackingthecodinginterview.stringsandarrays;

/**
 * Chapter 1 - Strings & arrays
 *
 * IsOneAway: Given 2 strings, return true if there's only 1 (or zero) differences between them.
 *
 */
public class Question1_5_IsOneAway {

  private static boolean isOneWay(final String str1, final String str2) {
    if (Math.abs(str1.length() - str2.length()) > 1) {
      return false;
    }
    final String shortStr = str1.length() < str2.length() ? str1 : str2;
    final String longStr = str1.length() >= str2.length() ? str1 : str2;
    boolean foundDifference = false;
    int shortIndex = 0;
    int longIndex = 0;
    while (shortIndex < shortStr.length() && longIndex < longStr.length()) {
      final char currentShortChar = shortStr.charAt(shortIndex);
      final char currentLongChar = longStr.charAt(longIndex);
      if (currentShortChar == currentLongChar) {
        shortIndex++;
      } else {
        if (foundDifference) {
          return false;
        }
        foundDifference = true;
        if (shortStr.length() == longStr.length()) {
          shortIndex++;
        }
      }
      longIndex++;
    }
    return true;
  }

  public static void main(final String[] args) {
    System.out.println("IsOneAway(paless,pale): " + isOneWay("paless", "pale"));
    System.out.println("IsOneAway(pale,ple): " + isOneWay("pale", "ple"));
    System.out.println("IsOneAway(pales,pale): " + isOneWay("pales", "pale"));
    System.out.println("IsOneAway(pale,bale): " + isOneWay("pale", "bale"));
    System.out.println("IsOneAway(pale,bake): " + isOneWay("pale", "bake"));

  }
}
