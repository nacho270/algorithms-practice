package com.nacho.crackingthecodinginterview.linkedlists;

/**
 * Chapter 2 - Linked lists
 *
 * Check if a linked list is palindrome.
 *
 * Will create a new list, reverse it and compare with the original. <br>
 * It's important to clone the new list to aviod infinite references.
 *
 */
public class Question2_6_Palindrome {

  private static class Node {
    int value;
    Node next;

    public Node(final int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private static boolean isPalindrome(final Node root) {
    final Node newList = cloneAndReverse(root);
    return areEqual(root, newList);
  }

  private static boolean areEqual(final Node root, final Node newList) {
    Node runner = root;
    Node newListRunner = newList;
    while (runner != null && newListRunner != null) {
      if (runner.value != newListRunner.value) {
        return false;
      }
      runner = runner.next;
      newListRunner = newListRunner.next;
    }
    return true;
  }

  private static Node cloneAndReverse(Node runner) {
    Node newList = null;
    while (runner != null) {
      final Node newNode = new Node(runner.value);
      newNode.next = newList;
      newList = newNode;
      runner = runner.next;
    }
    return newList;
  }

  public static void main(final String[] args) {
    Node list = createList(1, 2, 2, 1);
    System.out.println("Is palindrome(1,2,2,1): " + isPalindrome(list));

    list = createList(1, 2, 2);
    System.out.println("Is palindrome(1,2,2): " + isPalindrome(list));
  }

  private static Node createList(final int... values) {
    Node root = null;
    Node runner = null;
    for (final int n : values) {
      if (root == null) {
        root = new Node(n);
        runner = root;
      } else {
        runner.next = new Node(n);
        runner = runner.next;
      }
    }
    return root;
  }

}
