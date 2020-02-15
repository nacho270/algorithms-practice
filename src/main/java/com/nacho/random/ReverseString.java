package com.nacho.random;

public class ReverseString {

  public static void main(final String[] args) {
    final String str = "nacho";
    System.out.println(reverseWithString(str));
    System.out.println(reverseWithStringBuilder(str));
    System.out.println(reverseWithArray(str));
  }

  private static String reverseWithArray(final String str) {
    final char[] revCharArray = new char[str.length()];
    int revCharIndex = str.length() - 1;
    for (int i = 0; i < str.length(); i++) {
      revCharArray[revCharIndex--] = str.charAt(i);
    }
    return new String(revCharArray);
  }

  private static String reverseWithStringBuilder(final String str) {
    final StringBuilder reverseStrSb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      reverseStrSb.insert(0, str.charAt(i));
    }
    return reverseStrSb.toString();
  }

  private static String reverseWithString(final String str) {
    String reverseStr = "";
    for (int i = 0; i < str.length(); i++) {
      reverseStr = str.charAt(i) + reverseStr;
    }
    return reverseStr;
  }
}
