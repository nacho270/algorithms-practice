package com.nacho.crackingthecodinginterview.linkedlists;

/**
 * Chapter 2 - Linked lists
 *
 * Remove a node in the middle of a list (any node, except head or tail) given access to that node only.
 *
 * Ex: <br>
 * List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 <br>
 * Input: 3 <br>
 * Result: 1 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8 <br>
 *
 * Won't work if it's the last node
 *
 */
public class Question2_3_DeleteMiddleNode {

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

  public static void main(final String[] args) {
    final Node root = createList(); // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
    final Node n = findNode(root, 3); // 3 -> 4 -> 5 -> 6 -> 7 -> 8
    remove(n); // 1 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8
    print(root);
  }

  private static void remove(final Node n) {
    if (n.next == null) {
      return; // cannot be done with single linked list
    }
    final Node t = n;
    final Node next = n.next;
    t.value = next.value;
    t.next = next.next;
    next.next = null;
  }

  private static Node findNode(final Node root, final int i) {
    Node n = root;
    while (n != null) {
      if (n.value == i) {
        return n;
      }
      n = n.next;
    }
    return null;
  }

  private static Node createList() {
    final Node n1 = new Node(1);
    final Node n2 = new Node(2);
    final Node n3 = new Node(3);
    final Node n4 = new Node(4);
    final Node n5 = new Node(5);
    final Node n6 = new Node(6);
    final Node n7 = new Node(7);
    final Node n8 = new Node(8);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;
    return n1;
  }

  private static void print(final Node root) {
    Node temp = root;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }
}
