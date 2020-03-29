package com.nacho.hackerrank.interviewpreparationkit.arrays;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 *
 * Given a 2D array of operatations where:<br>
 * a[0] = index from (1-based!)<br>
 * a[1] = index to (1-based)<br>
 * a[3] = value.<br>
 *
 * Apply those operations to an empty array and return the max value obtained.<br>
 * Example: Given<br>
 *
 * a b k<br>
 * 1 5 3<br>
 * 4 8 7<br>
 * 6 9 1 <br>
 *
 * 1- Sum 3 to positions 1 to 5 in the array <br>
 * 2- Sum 7 to positions 4 to 8 in the array <br>
 * 3- Sum 1 to positions 6 to 9 in the array <br>
 *
 * 1 2 3 4 5 6 7 8 9 10 <br>
 * [0,0,0, 0, 0,0,0,0,0, 0] -> Starting array<br>
 * [3,3,3, 3, 3,0,0,0,0, 0] -> Step 1<br>
 * [3,3,3,10,10,7,7,7,0, 0] -> Step 2<br>
 * [3,3,3,10,10,8,8,8,1, 0] -> Step 3<br>
 *
 */
public class ArrayManipulation {

  static long arrayManipulation(final int n, final int[][] queries) {
    if (queries == null || queries.length == 0) {
      return 0;
    }
    final int[] result = new int[n];

    for (int operationIndex = 0; operationIndex < queries.length; operationIndex++) {
      final int[] operation = queries[operationIndex];
      final int indexFrom = operation[0] - 1; // operations is 1-index, not 0
      final int indexTo = operation[1] - 1;
      final int value = operation[2];

      // Don't need to actually calculate the value of every position in the array, it's not optimal and will be very slow with large
      // datasets
      // Just calculate for the beginning of the range
      result[indexFrom] += value;

      /**
       * 1 place AFTER the range, calculate and store the subraction: This means "how smaller this will be compared to the range"<br>
       * Example: 1 3 3 -> Sum 3 on the indexes 1, 2, 3 <br>
       * What this does: 3 0 0 -3 -> Meaning that position 4 is 3 units smaller than the range.
       */
      if (indexTo + 1 < n) {
        result[indexTo + 1] -= value;
      }
    }

    long sum = 0;
    long max = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      sum += result[i];
      if (max < sum) {
        max = sum;
      }
    }

    return max;
  }

  public static void main(final String[] args) {
    System.out.println(arrayManipulation(10, new int[][] { //
        { 2, 6, 8 }, //
        { 3, 5, 7 }, //
        { 1, 8, 1 }, //
        { 5, 9, 15 } }));

    System.out.println(arrayManipulation(10, new int[][] { //
        { 1, 5, 3 }, //
        { 4, 8, 7 }, //
        { 6, 9, 1 } }));

    System.out.println(arrayManipulation(10, new int[][] { //
        { 1, 2, 100 }, //
        { 2, 5, 100 }, //
        { 3, 4, 100 } }));

    System.out.println(arrayManipulation(10, new int[][] { //
        { 2, 3, 603 }, //
        { 1, 1, 286 }, //
        { 4, 4, 882 } }));
  }
}
