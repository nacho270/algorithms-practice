package com.nacho.crackingthecodinginterview.stringsandarrays;

/**
 * Chapter 1 - Strings & arrays
 *
 * Given a NxM matrix, if a 0 is found, make it's entire row and column zero.
 *
 * Cannot do this with analysing the matrix first because if a zero is found and the row/column is made zero... the next zero to be found
 * not have been there in the first place.<br>
 *
 * Ex: given <br>
 * 1 8 3 | 1 0 3 <br>
 * 4 0 5 > 0 0 0 <br>
 * 4 8 4 | 4 0 4 <br>
 *
 */
public class Question1_8_ZeroMatrix {

  private static void doZero(final int[][] mat) {
    final boolean[] rowsToBeZero = new boolean[mat.length];
    final boolean[] columnsToBeZero = new boolean[mat[0].length];
    for (int row = 0; row < mat.length; row++) {
      for (int col = 0; col < mat[0].length; col++) {
        if (mat[row][col] == 0) {
          columnsToBeZero[col] = true;
          rowsToBeZero[row] = true;
        }
      }
    }

    for (int row = 0; row < rowsToBeZero.length; row++) {
      if (rowsToBeZero[row]) {
        for (int i = 0; i < mat[0].length; i++) {
          mat[row][i] = 0;
        }
      }
    }

    for (int col = 0; col < columnsToBeZero.length; col++) {
      if (columnsToBeZero[col]) {
        for (int i = 0; i < mat.length; i++) {
          mat[i][col] = 0;
        }
      }
    }
  }

  private static void print(final int[][] mat) {
    for (final int[] element : mat) {
      for (final int element2 : element) {
        System.out.print(element2);
      }
      System.out.print("\n");
    }
  }

  public static void main(final String[] args) {
    final int[][] mat = new int[][] { //
        { 1, 8, 3 }, //
        { 4, 0, 5 }, //
        { 4, 8, 4 } };

    System.out.println("Before: ");
    print(mat);
    doZero(mat);
    System.out.println();
    System.out.println("After: ");
    print(mat);
  }
}
