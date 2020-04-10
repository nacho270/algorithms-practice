package com.nacho.random;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

  public static void main(final String[] args) {
    System.out.println(primeFractors(21));
    System.out.println(primeFractors(55));
    System.out.println(primeFractors(2 * 2 * 3 * 3 * 5 * 7 * 11 * 11 * 13));
    System.out.println(primeFractors(6700417));
  }

  private static List<Integer> primeFractors(int n) {
    final List<Integer> factors = new ArrayList<>();
    for (int divisor = 2; Math.sqrt(n) > 1; divisor++) {
      for (; n % divisor == 0; n /= divisor) {
        factors.add(divisor);
      }
    }
    return factors;
  }
}
