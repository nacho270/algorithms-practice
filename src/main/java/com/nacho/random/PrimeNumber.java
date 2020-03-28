package com.nacho.random;

public class PrimeNumber {

  public static boolean isPrime(final int number) {
    if (number <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static int countPrimesInRange(final int lower, final int upper) {
    int total = 0;
    for (int i = lower; i <= upper; i++) {
      if (isPrime(i)) {
        System.out.println("Found prime: " + i);
        total++;
      }
    }
    return total;
  }

  public static void main(final String[] args) {
    System.out.println("countPrimesInRange(0,1000): " + countPrimesInRange(0, 1000));
  }
}
