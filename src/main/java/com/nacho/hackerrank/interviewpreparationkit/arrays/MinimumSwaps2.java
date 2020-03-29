package com.nacho.hackerrank.interviewpreparationkit.arrays;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 *
 * Given an unordered array of consecutive integers {1, 2, 3...}, find the minimum number of swaps required to make the array sorted. <br>
 * Example:<br>
 * i arr swap (indices)<br>
 *
 * 0 [7, 1, 3, 2, 4, 5, 6] swap (0,3)<br>
 * 1 [2, 1, 3, 7, 4, 5, 6] swap (0,1)<br>
 * 2 [1, 2, 3, 7, 4, 5, 6] swap (3,4)<br>
 * 3 [1, 2, 3, 4, 7, 5, 6] swap (4,5)<br>
 * 4 [1, 2, 3, 4, 5, 7, 6] swap (5,6)<br>
 * 5 [1, 2, 3, 4, 5, 6, 7]
 *
 * 5 swaps were needed.
 */
public class MinimumSwaps2 {

  static int minimumSwaps(final int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    int swaps = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == i + 1) {
        continue; // number in right place
      }
      findAndSwap(arr, i);
      swaps++;
    }
    return swaps;
  }

  private static void findAndSwap(final int[] arr, final int i) {
    for (int j = i + 1; j < arr.length; j++) {
      if (arr[j] == i + 1) {
        final int swap = arr[j];
        arr[j] = arr[i];
        arr[i] = swap;
        break;
      }
    }
  }

  public static void main(final String[] args) {
    System.out.println(minimumSwaps(new int[] { 1, 3, 5, 2, 4, 6, 7 }));
  }
}
