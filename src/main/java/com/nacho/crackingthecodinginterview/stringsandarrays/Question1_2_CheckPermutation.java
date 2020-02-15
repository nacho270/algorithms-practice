package com.nacho.crackingthecodinginterview.stringsandarrays;

import java.util.Arrays;

/**
 * Chapter 1 - Strings & arrays
 *
 * Check permutation: Given 2 Strings, write a method to decide if one is a permutation of the other.
 *
 * (check if they are anagrams)
 *
 * 2 approaches:
 *
 * 1 - Sort each string and check for equality: O(2n log n) <br>
 * 2 - Store frequency of each letter for each string and compare: loop through each string + loop through frecuencies: O(3n) = O(n)
 */
public class Question1_2_CheckPermutation {

  private static String sortString(final String str) {
    final char[] charArray = str.toCharArray();
    Arrays.sort(charArray);
    return new String(charArray);
  }

  private static boolean checkPermutationSorting(final String str1, final String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    final String sortedStr1 = sortString(str1);
    final String sortedStr2 = sortString(str2);
    return sortedStr1.equals(sortedStr2);
  }

  private static int[] calculateCharacterFrecuency(final String str) {
    final int[] frecuencies = new int[128];
    for (int i = 0; i < str.length(); i++) {
      frecuencies[str.charAt(i) - 'a']++;
    }
    return frecuencies;
  }

  private static boolean checkPermutationFrecuencies(final String str1, final String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    final int[] frecienciesStr1 = calculateCharacterFrecuency(str1);
    final int[] frecienciesStr2 = calculateCharacterFrecuency(str2);
    for (int i = 0; i < frecienciesStr1.length; i++) {
      if (frecienciesStr1[i] != frecienciesStr2[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(final String[] args) {
    System.out.println("checkPermutationFrecuencies(nacho, ochan): " + checkPermutationFrecuencies("nacho", "ohcan"));
    System.out.println("checkPermutationFrecuencies(vamos, mosva): " + checkPermutationFrecuencies("vamos", "mosva"));
    System.out.println("checkPermutationFrecuencies(nacho, pepe): " + checkPermutationFrecuencies("nacho", "pepe"));
    System.out.println("============================================================");
    System.out.println("checkPermutationSorting(nacho, ochan): " + checkPermutationSorting("nacho", "ohcan"));
    System.out.println("checkPermutationSorting(vamos, mosva): " + checkPermutationSorting("vamos", "mosva"));
    System.out.println("checkPermutationSorting(nacho, pepe): " + checkPermutationSorting("nacho", "pepe"));
  }

}
