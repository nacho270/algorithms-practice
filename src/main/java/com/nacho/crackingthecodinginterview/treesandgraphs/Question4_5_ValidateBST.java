package com.nacho.crackingthecodinginterview.treesandgraphs;

/**
 * Given a node, detrmine if it's a valid BST. <br>
 * Means checking for every node if: <br>
 * - has left child and its <= root or has no left child. <br>
 * - has right child and its > root or has no right child <br>
 */
public class Question4_5_ValidateBST {

  static boolean isBST(final Node root) {
    if (root == null) {
      return true;
    }
    final boolean bstLeft = root.left != null && root.left.value <= root.value || root.left == null;
    final boolean bstRight = root.right != null && root.right.value > root.value || root.right == null;
    if (!bstLeft || !bstRight) {
      return false;
    }
    return isBST(root.left) && isBST(root.right);
  }

  static class Node {
    int value;
    Node left;
    Node right;

    public Node(final int value) {
      super();
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  public static void main(final String[] args) {
    final Node n1 = new Node(20);
    final Node n2 = new Node(10);
    final Node n3 = new Node(25);
    final Node n4 = new Node(30);

    // ..7
    // .5...10
    // 3 6 8 12
    n1.left = n2;
    n1.right = n4;
    n2.left = n4;
    n2.right = n3;

    System.out.println(isBST(n1));
  }
}
