package com.nacho.hackerrank.interviewpreparationkit.warmup;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 *
 * A hiker tracks the topography of his hikes. Given N steps, tracks with a D when he goes downhill and with a U when he goes uphill.<br>
 * Each step has a value of 1. <br>
 * He always starts at sea level.<br>
 * A valley is a consecutive number of steps below sea level. <br>
 * Example: UDDDUDUU
 *
 * ___/\......___<br>
 * .....\..../<br>
 * ......\/\/<br>
 * ......|...| <br>
 * ...... a valley <br>
 *
 * Count the number of valleys he took given a String of U & D
 */
public class CountingValleys {

  static int countingValleys(final int n, final String s) {
    int seaLevel = 0;
    int valleyCount = 0;
    boolean valley = false;
    for (int i = 0; i < s.length(); i++) {
      seaLevel += decode(s.charAt(i));
      if (seaLevel < 0) {
        valley = true;
      }
      if (valley == true && seaLevel >= 0) {
        valley = false;
        valleyCount++;
      }
    }
    return valleyCount;
  }

  private static int decode(final char UD) {
    return UD == 'U' ? 1 : -1;
  }

  public static void main(final String[] args) {
    System.out.println(countingValleys(8, "UDDDUDUU"));
  }
}
