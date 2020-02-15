package com.nacho.crackingthecodinginterview.stringsandarrays;

/**
 * Chapter 1 - Strings & arrays
 *
 * String compression: Given a String, write a basic compressio algorithm by replacing the repeated chars with their count.<br>
 *
 * Example: aabcccccaaa => a2b1c5a3. If the length of the compressed string is higher than the original, return the original.
 *
 * The string can only contain A-Z, a-z chars.
 *
 * Notes: I assume that 'A' is different than 'a'. I'll create a new char[] of 2x the size of the original String so it can contain the char
 * and the count. Will fail if there's a character with count > 9.
 *
 */
public class Question1_6_StringCompression {

  private static String compress(final String str) {
    if (str.length() < 3) { // with a length of 2, there's no compression to be made. Ex: "aa" -> a2, "ab" -> a1b1.
      return str;
    }
    final char[] newStr = new char[2 * str.length()];
    char lastChar = str.charAt(0);
    int count = 1;
    int newStrIndex = 0;

    for (int i = 1; i < str.length(); i++) {
      final char currentChar = str.charAt(i);
      if (currentChar == lastChar) {
        count++;
      } else {
        newStr[newStrIndex++] = lastChar;
        newStr[newStrIndex++] = Character.forDigit(count, 10);
        lastChar = currentChar;
        count = 1;
      }
    }
    newStr[newStrIndex++] = lastChar;
    newStr[newStrIndex++] = Character.forDigit(count, 10);
    if (newStrIndex > str.length()) {
      return str;
    }
    return new String(newStr);
  }

  private static String compressWithStringBuilder(final String str) {
    if (str.length() < 3) { // with a length of 2, there's no compression to be made. Ex: "aa" -> a2, "ab" -> a1b1.
      return str;
    }
    final StringBuilder sb = new StringBuilder();
    char lastChar = str.charAt(0);
    int count = 1;

    for (int i = 1; i < str.length(); i++) {
      final char currentChar = str.charAt(i);
      if (currentChar == lastChar) {
        count++;
      } else {
        sb.append(lastChar);
        sb.append(count);
        lastChar = currentChar;
        count = 1;
      }
    }
    sb.append(lastChar);
    sb.append(count);
    if (sb.length() > str.length()) {
      return str;
    }
    return sb.toString();
  }

  private static String compressWithStringBuilderAskingForTheFollowingChar(final String str) {
    if (str.length() < 3) { // with a length of 2, there's no compression to be made. Ex: "aa" -> a2, "ab" -> a1b1.
      return str;
    }
    final StringBuilder sb = new StringBuilder();
    int count = 0;

    for (int i = 0; i < str.length(); i++) {
      count++;
      if (i + 1 >= str.length() || str.charAt(i + 1) != str.charAt(i)) {
        sb.append(str.charAt(i));
        sb.append(count);
        count = 0;
      }
    }
    if (sb.length() > str.length()) {
      return str;
    }
    return sb.toString();
  }

  public static void main(final String[] args) {
    System.out.println("compress(aabcccccaaa): " + compress("aabcccccaaa"));
    System.out.println("compressWithStringBuilder(aabcccccaaa): " + compressWithStringBuilder("aabcccccaaa"));
    System.out.println("compressWithStringBuilderAskingForTheFollowingChar(aabcccccaaa): "
        + compressWithStringBuilderAskingForTheFollowingChar("aabcccccaaa"));

  }

}
