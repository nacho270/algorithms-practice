package com.nacho.hackerrank.interviewpreparationkit.warmup;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem
 *
 * Given a String and a total length of a new String that's created by repeating the first one, calculate the occurrences of the letter
 * 'a'<br>
 * Example:<br>
 * S = abcac <br>
 * N = 9 <br>
 *
 * Calculate the occurrences of 'a' on a String = abcacabca. Answer = 4<br>
 *
 */
public class RepeatedString {

  static long repeatedString(final String s, final long n) {
    return findRepeteadCharInString(s, n, 'a');
  }

  static long findRepeteadCharInString(final String str, final long n, final char charToFind) {
    if (str == null || str.length() == 0) {
      return 0;
    }
    // If the given length is smaller than the String legth, use the substring.
    final String s = str.length() >= n ? str.substring(0, (int) n) : str;
    final long occurrencesInStr = s //
        .chars() //
        .mapToObj(c -> (char) c) //
        .filter(c -> c == charToFind) //
        .count();
    if (s.length() >= n) {
      return occurrencesInStr;
    }
    final long reps = n / s.length();
    long count = reps * occurrencesInStr;
    for (int i = 0; i < n % s.length(); i++) {
      if (s.charAt(i) == charToFind) {
        count++;
      }
    }
    return count;
  }

  public static void main(final String[] args) {
    System.out.println(repeatedString("ababa", 3L));
  }

}
