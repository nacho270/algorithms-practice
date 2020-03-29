package com.nacho.hackerrank.interviewpreparationkit.arrays;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 *
 * Given a 6 X 6 multidimensional array, calculate the maximum hourglass inside.<br>
 * An hourglass is given by this shape: <br>
 * 1 2 3 <br>
 * x 4 x <br>
 * 5 6 7 <br>
 *
 * In this case, the hourglass value is: 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28 <br>
 *
 * In the 2D array, there are many hourglasses. Return the maxium value of all.
 */
public class Arrays2D {

  static int hourglassSum(final int[][] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    int maxHourGlass = Integer.MIN_VALUE;
    final int width = arr[0].length;
    final int height = arr.length;

    for (int row = 0; row <= height - 3; row++) {
      for (int col = 0; col <= width - 3; col++) {
        final int hourGlassLength = hourGlassLength(arr, row, col);
        if (hourGlassLength > maxHourGlass) {
          maxHourGlass = hourGlassLength;
        }
      }
    }

    return maxHourGlass;
  }

  static int hourGlassLength(final int[][] arr, final int row, final int col) {
    int hourGlassSum = arr[row + 1][col + 1];
    for (int i = col; i < col + 3; i++) {
      hourGlassSum += arr[row][i] + arr[row + 2][i];
    }
    return hourGlassSum;
  }

  public static void main(final String[] args) {
    System.out.println(hourglassSum(new int[][] { //
        { 1, 1, 1, 0, 0, 0 }, //
        { 0, 1, 0, 0, 0, 0 }, //
        { 1, 1, 1, 0, 0, 0 }, //
        { 0, 0, 2, 4, 4, 0 }, //
        { 0, 0, 0, 2, 0, 0 }, //
        { 0, 0, 1, 2, 4, 0 } }));
  }
}
