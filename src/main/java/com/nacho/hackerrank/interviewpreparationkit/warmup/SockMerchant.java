package com.nacho.hackerrank.interviewpreparationkit.warmup;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 *
 * Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
 *
 * For example, there are n = 7 socks with colors ar = [1, 2, 1, 2, 1, 3, 2]. There is one pair of color 1 and one of color 2. There are
 * three odd socks left, one of each color. The number of pairs is 2.
 *
 * Constraints:<br>
 * 1 <= n <= 100 <br>
 * 1 <= ar[i] <= 100 where 0 <= i < n
 */
public class SockMerchant {

  static int sockMerchant(final int n, final int[] ar) {
    if (n < 2 || ar == null || ar.length < 2) {
      return 0;
    }

    final int[] pairs = new int[100];
    for (int i = 0; i < n; i++) {
      pairs[ar[i] - 1]++;
    }
    int pairCount = 0;
    for (int i = 0; i < 100; i++) {
      pairCount += pairs[i] / 2;
    }
    return pairCount;
  }

  public static void main(final String[] args) {
    System.out.println(sockMerchant(100,
        new int[] { 50, 49, 38, 49, 78, 36, 25, 96, 10, 67, 78, 58, 98, 8, 53, 1, 4, 7, 29, 6, 59, 93, 74, 3, 67, 47, 12, 85, 84, 40, 81,
            85, 89, 70, 33, 66, 6, 9, 13, 67, 75, 42, 24, 73, 49, 28, 25, 5, 86, 53, 10, 44, 45, 35, 47, 11, 81, 10, 47, 16, 49, 79, 52, 89,
            100, 36, 6, 57, 96, 18, 23, 71, 11, 99, 95, 12, 78, 19, 16, 64, 23, 77, 7, 19, 11, 5, 81, 43, 14, 27, 11, 63, 57, 62, 3, 56, 50,
            9, 13, 45 }));
  }
}
