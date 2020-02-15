package com.nacho.crackingthecodinginterview.stringsandarrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Chapter 1 - Strings & arrays
 *
 * Is unique? Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 */
public class Question1_1_IsUnique {

  private static boolean isUniqueWithMap(final String str) {
    final Map<Character, Short> frequencies = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      final char character = str.charAt(i);
      final Short frequency = frequencies.get(character);
      if (frequency != null && frequency.equals((short) 1)) {
        return false;
      }
      frequencies.put(character, (short) (frequency == null ? 1 : frequency + 1));
    }
    return true;
  }

  private static boolean isUniqueWithArray(final String str) {
    final boolean[] frequencies = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      final boolean present = frequencies[str.charAt(i)];
      if (present) {
        return false;
      }
      frequencies[str.charAt(i)] = true;
    }
    return true;
  }

  private static boolean isUniqueWithBitMap(final String str) { // copied from the book
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      final int value = str.charAt(i) - 'a';
      if ((checker & 1 << value) > 0) {
        return false;
      }
      checker |= 1 << value;
    }
    return true;
  }

  /**
   * checker = 0 <br>
   * p = 15 = ‭0001 0101 <br>
   * 1 << 15 = 32768 = ‭0011 0010 0111 0110 1000 <br>
   * checker & 1 << 15 = 0 = 0000 0000 0000 0000 0000 <br>
   * checker | 1 << 15 = 32768 = ‭0011 0010 0111 0110 1000 <br>
   *
   * =======================================================
   *
   * checker = 32768 <br>
   * e = 4 = 0100 <br>
   * 1 << 4 = 16 = ‭0001 0110<br>
   * checker & 1 << 4 = 0 <br>
   * checker | 1 << 4 = 32784 = ‭0011 0010 0111 1000 0100
   *
   * =======================================================
   *
   * checker = 32784 <br>
   * p = 15 = ‭0001 0101 <br>
   * 1 << 15 = 32768 = ‭0011 0010 0111 0110 1000 <br>
   * checker & 1 << 15 =__ ‭0011 0010 0111 1000 0100 & <br>
   * _____________________ ‭0011 0010 0111 0110 1000‬‬
   */

  public static void main(final String[] args) {
    System.out.println("isUniqueWithMap(nacho): " + isUniqueWithMap("nacho"));
    System.out.println("isUniqueNoAdditionalDataStructures(nacho): " + isUniqueWithArray("nacho"));
    System.out.println("isUniqueWithBitMap(nacho): " + isUniqueWithBitMap("nacho"));
    System.out.println("==============================================================");
    System.out.println("isUniqueWithMap(pepe): " + isUniqueWithMap("pepe"));
    System.out.println("isUniqueNoAdditionalDataStructures(pepe): " + isUniqueWithArray("pepe"));
    System.out.println("isUniqueWithBitMap(pepe): " + isUniqueWithBitMap("pepe"));
  }
}
