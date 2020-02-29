package com.nacho.random;

public class PrintSpiralMatrix {

  public static void main(final String[] args) {
    final int[][] mat = new int[][] { //
        { 1, 2, 3 }, //
        { 4, 5, 6 }, //
        { 7, 8, 9 }, //
        { 10, 11, 12 } //
    };

    printSpiral(mat);
  }

  private static void printSpiral(final int[][] mat) {
    internalPrintSpiral(mat, 0, 0);
    System.out.println("=======");
    internalPrintSpiral2(mat, 0, 0, mat.length - 1, mat[0].length - 1);
  }

  private static void internalPrintSpiral(final int[][] mat, final int offsetRow, final int offsetCol) {
    final int rows = mat.length;
    final int cols = mat[0].length;

    // left -> right
    for (int col = offsetCol; col < cols - offsetCol; col++) {
      System.out.println(mat[offsetRow][col]);
    }

    // up -> down
    for (int row = offsetRow + 1; row < rows - offsetRow; row++) {
      System.out.println(mat[row][cols - offsetCol - 1]);
    }

    // right -> left
    for (int col = cols - offsetCol - 2; col >= offsetCol; col--) {
      System.out.println(mat[rows - offsetRow - 1][col]);
    }

    // down -> up
    for (int row = rows - offsetRow - 2; row > offsetRow; row--) {
      System.out.println(mat[row][offsetCol]);
    }
    if (offsetRow + 1 <= rows - 1 && offsetCol + 1 <= cols - 1) {
      internalPrintSpiral(mat, offsetRow + 1, offsetCol + 1);
    }
  }

  private static void internalPrintSpiral2(final int[][] mat, final int startRow, final int startcol, final int endRow, final int endCol) {
    if (startRow > endRow && startcol > endCol) {
      return;
    }
    // left -> right
    for (int col = startcol; col <= endCol; col++) {
      System.out.println(mat[startRow][col]);
    }

    // up -> down
    for (int row = startRow + 1; row <= endRow; row++) {
      System.out.println(mat[row][endCol]);
    }

    // right -> left
    for (int col = endCol - 1; col >= startcol; col--) {
      System.out.println(mat[endRow][col]);
    }

    // down -> up
    for (int row = endRow - 1; row > startRow; row--) {
      System.out.println(mat[row][startcol]);
    }

    internalPrintSpiral2(mat, startRow + 1, startcol + 1, endRow - 1, endCol - 1);
  }
}
