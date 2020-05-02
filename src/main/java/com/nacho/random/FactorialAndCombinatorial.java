package com.nacho.random;

public class FactorialAndCombinatorial {

  static int fact(final int n) {
    int res = 1;
    for (int i = 2; i <= n; i++) {
      res = res * i;
    }
    return res;
  }

  static int combinatorial(final int n, final int k) {
    return fact(n) / (fact(k) * fact(n - k));
  }

  public static void main(final String[] args) {
    System.out.println("Factorial 5: " + fact(5));
    System.out.println("combinatorial (10, 4): " + combinatorial(10, 4));
  }

}
