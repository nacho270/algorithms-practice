package com.nacho.crackingthecodinginterview.treesandgraphs;

/**
 * Given a node, check if it's balanced. <br>
 * A balanced node means that the difference of height between the left and right branches is no more than 1.
 */
public class Question4_4_CheckBalanced {

  static boolean isBalanced(final Node root) {
    if (root == null) {
      return true;
    }
    final int diff = Math.abs(height(root.left) - height(root.right));
    if (diff > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  private static int height(final Node node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));
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
    final Node n1 = new Node(1);
    final Node n2 = new Node(2);
    final Node n3 = new Node(3);
    final Node n4 = new Node(4);
    final Node n5 = new Node(5);
    final Node n6 = new Node(6);
    final Node n7 = new Node(7);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;

    System.out.println(isBalanced(n1));
  }
}
