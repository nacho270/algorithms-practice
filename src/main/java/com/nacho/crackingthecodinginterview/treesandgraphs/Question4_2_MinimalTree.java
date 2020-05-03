package com.nacho.crackingthecodinginterview.treesandgraphs;

import java.util.LinkedList;

/**
 * Given a sorted array of unique elements, create a BST with minimal height. <br>
 *
 * Notes:<br>
 * Minimal height means "balanced".<br>
 * The input array is already sorted which means that it can be halved like in a binary search to create the tree.<br>
 * This will avoid having to write the balancing algorithms.
 */
public class Question4_2_MinimalTree {

  static Node createBST(final int[] numbers) {
    return internalCreateBST(numbers, 0, numbers.length - 1);
  }

  private static Node internalCreateBST(final int[] numbers, final int start, final int end) {
    if (start > end) {
      return null;
    }
    final int middle = (start + end) / 2;
    final Node root = new Node(numbers[middle]);
    root.left = internalCreateBST(numbers, start, middle - 1);
    root.right = internalCreateBST(numbers, middle + 1, end);
    return root;
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

  static void print(final Node node) {
    if (node == null) {
      return;
    }
    final LinkedList<Node> list = new LinkedList<>();
    list.add(node);
    while (!list.isEmpty()) {
      final Node current = list.removeFirst();
      System.out.println(current.value);
      if (current.left != null) {
        list.add(current.left);
      }
      if (current.right != null) {
        list.add(current.right);
      }
    }
  }

  public static void main(final String[] args) {
    final Node node = createBST(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
    print(node);
  }
}
