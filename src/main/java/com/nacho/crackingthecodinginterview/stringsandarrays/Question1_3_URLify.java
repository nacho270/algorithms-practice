package com.nacho.crackingthecodinginterview.stringsandarrays;

/**
 * Chapter 1 - Strings & arrays
 *
 * URLify: replace spaces for %20. Params: char[] and trueLength of the string. Assume the input array has enough space to add the
 * additional chars.
 *
 * Find the spaces and create a new index: Each space is one char, but %20 is 3 so i should add an extra 2 spaces for each space (the ' '
 * position will be occupied by the %)
 *
 */
public class Question1_3_URLify {

  private static int charCount(final char[] str, final char charToCount) {
    int count = 0;
    for (final char element : str) {
      if (element == charToCount) {
        count++;
      }
    }
    return count;
  }

  private static void urlify(final char[] str, final int trueLength) {
    final int spaces = charCount(str, ' ');
    int newLen = trueLength - 1 + 2 * spaces;
    for (int i = trueLength - 1; i >= 0; i--) {
      if (str[i] == ' ') {
        str[newLen] = '%';
        str[newLen - 1] = '0';
        str[newLen - 2] = '2';
        newLen -= 3;
      } else {
        str[newLen--] = str[i];
      }
    }
  }

  public static void main(final String[] args) {
    final char[] arrayToUse = new char[100];
    final char[] charArray = "Mr John Smith    ".toCharArray();
    System.arraycopy(charArray, 0, arrayToUse, 0, charArray.length);
    urlify(arrayToUse, 13);
    System.out.println("urlify(Mr John Smith    ,13): " + new String(arrayToUse));
  }

}
