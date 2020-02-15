package com.nacho.crackingthecodinginterview.stringsandarrays;

/**
 * Chapter 1 - Strings & arrays
 *
 * IsPalindromePermutation: given string, determine if it's a permutation of any palindrome "word" (not necessary that it should be a real
 * word... like arrrra).
 *
 * The key point is that a palindrome word has an even letter frecuency on all its characters... or only 1 odd.
 *
 * Ex:<br>
 * akka => a->2, k->2 <br>
 * akopa => a->2, k->2, o->1 <br>
 *
 */
public class Question1_4_IsPalindromePermutation {

  private static int[] buildFrecuencyTable(final String str) {
    final int[] frecuencies = new int[26];
    for (int i = 0; i < str.length(); i++) {
      frecuencies[str.charAt(i) - 'a']++;
    }
    return frecuencies;
  }

  private static boolean isPaliindromePermutation(final String str) {
    final int[] frecuencies = buildFrecuencyTable(str);
    boolean oddFound = false;
    for (final int frecuencie : frecuencies) {
      if (frecuencie % 2 == 1) {
        if (oddFound) {
          return false;
        }
        oddFound = true;
      }
    }
    return true;
  }

  public static void main(final String[] args) {
    System.out.println("Is palindrome permutation(paaaiiijj): " + isPaliindromePermutation("paaaiiijj"));
    System.out.println("Is palindrome permutation(kkaa): " + isPaliindromePermutation("kkaa"));
    System.out.println("Is palindrome permutation(kkaoa): " + isPaliindromePermutation("kkaoa"));
    System.out.println("Is palindrome permutation(menem): " + isPaliindromePermutation("menem"));
    System.out.println("Is palindrome permutation(neuquen): " + isPaliindromePermutation("neuquen"));
    System.out.println("Is palindrome permutation(casa): " + isPaliindromePermutation("casa"));
  }

}
