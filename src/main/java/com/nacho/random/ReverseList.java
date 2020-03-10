package com.nacho.random;

public class ReverseList {

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

  private static Node reverse(final Node root) {
    Node prev = null;
    Node curr = root;
    while (curr != null) {
      final Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static void main(final String[] args) {
    final Node list = createList(1, 2, 3, 4, 5, 6, 7);
    System.out.println("==== BEFORE =====");
    print(list);
    final Node reversed = reverse(list);
    System.out.println("==== AFTER =====");
    print(reversed);
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

  private static void print(final Node root) {
    Node temp = root;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

}
