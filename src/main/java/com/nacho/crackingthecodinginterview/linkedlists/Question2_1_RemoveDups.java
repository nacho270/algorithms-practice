package com.nacho.crackingthecodinginterview.linkedlists;

import java.util.HashSet;
import java.util.Set;

/**
 * Chapter 2 - Linked lists
 *
 * Remove duplicates from an unsorted linked list. With and without a temporary buffer.
 *
 */
public class Question2_1_RemoveDups {

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

  private static void removeDupsNoBuffer(final Node root) {
    Node t = root;
    while (t != null) {
      removeNode(t.value, t);
      t = t.next;
    }
  }

  private static void removeNode(final int value, Node t) {
    while (t.next != null) {
      if (t.next.value == value) {
        t.next = t.next.next;
      } else {
        t = t.next;
      }
    }
  }

  private static void removeDupsWithBuffer(final Node root2) {
    final Set<Integer> buffer = new HashSet<>();
    Node t = root2;
    Node prev = null;
    while (t != null) {
      if (buffer.contains(t.value)) {
        prev.next = t.next;
      } else {
        buffer.add(t.value);
        prev = t;
      }
      t = t.next;
    }
  }

  public static void main(final String[] args) {
    final Node root = createList();
    removeDupsNoBuffer(root);
    print(root);

    System.out.println("===========");

    final Node root2 = createList();
    removeDupsWithBuffer(root2);
    print(root2);
  }

  private static void print(final Node root) {
    Node temp = root;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  private static Node createList() {
    final Node n1 = new Node(10);
    final Node n2 = new Node(1);
    final Node n3 = new Node(5);
    final Node n4 = new Node(4);
    final Node n5 = new Node(1);
    final Node n6 = new Node(5);
    final Node n7 = new Node(2);
    final Node n8 = new Node(10);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
    n7.next = n8;
    return n1;
  }

}
