package com.nacho.crackingthecodinginterview.stringsandarrays;

/**
 * Chapter 1 - Strings & arrays
 *
 * Given there an "isSubstring" method, given 2 string determine if one is a rotation of the other using only one call to isSubstring.
 *
 * There's "no algorithm" here. They KEY is to concatenete 1 string with itself and then call "isSubstring" <br>
 *
 * Ex: nacho - onach
 *
 * onach + onach = onachonach ... nacho is substring of onachonach
 *
 */
public class Question1_9_StringRotation {

  private static boolean isSubstring(final String s1, final String s2) {
    return s2.contains(s1);
  }

  private static boolean isRotation(final String s1, final String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    return isSubstring(s2, s1 + s1);
  }

  public static void main(final String[] args) {
    System.out.println("isRotation(onach, nacho): " + isRotation("onach", "nacho"));
  }
}
