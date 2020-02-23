package com.nacho.crackingthecodinginterview.linkedlists;

/**
 * Chapter 2 - Linked lists
 *
 * Given a list of numbers and a partition number, partition the list such as all the nodes < partition are on the left and the nodes >=
 * partition are on the right
 *
 * Ex: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 <br>
 * Part: 5 <br>
 * Result: 3 -> 2 -> 1 -> 5 -> 8 -> 5 -> 10
 *
 */
public class Question2_4_Partition {

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
    final Node root = createList();
    print(partition(root, 5));
    System.out.println("=====");
    final Node root2 = createList();
    print(partitionFromBook(root2, 5));
  }

  private static Node partition(final Node root, final int partition) {
    Node lowerPartition = null;
    Node higherPartition = null;

    Node runnerLowerPartition = null;
    Node runnerHigherPartition = null;
    Node n = root;
    while (n != null) {
      final Node next = n.next;
      if (n.value < partition) {
        if (lowerPartition == null) {
          lowerPartition = n; // 3 as root of lowPartition
          runnerLowerPartition = lowerPartition; // runner low to the same node
        } else {
          // never loose the reference to the root
          runnerLowerPartition.next = n; // 3 -> 2
          runnerLowerPartition = runnerLowerPartition.next; // runner -> 2
        }
      } else {
        if (higherPartition == null) {
          higherPartition = n; // 5 as root of highPartition
          runnerHigherPartition = higherPartition; // runner node to the same node
        } else {
          // never loose the reference to the root
          runnerHigherPartition.next = n; // 5 -> 8
          runnerHigherPartition = runnerHigherPartition.next; // runner -> 8
        }
      }
      n = next;
    }
    runnerLowerPartition.next = higherPartition;
    runnerHigherPartition.next = null;
    return lowerPartition;
  }

  private static Node partitionFromBook(final Node root, final int partition) {
    Node lowerPartition = root;
    Node higherPartition = root;
    Node n = root;
    while (n != null) {
      final Node next = n.next;
      if (n.value < partition) {
        n.next = lowerPartition;
        lowerPartition = n;
      } else {
        higherPartition.next = n;
        higherPartition = n;
      }
      n = next;
    }
    higherPartition.next = null;
    return lowerPartition;
  }

  private static Node createList() {
    final Node n1 = new Node(3);
    final Node n2 = new Node(5);
    final Node n3 = new Node(8);
    final Node n4 = new Node(5);
    final Node n5 = new Node(10);
    final Node n6 = new Node(2);
    final Node n7 = new Node(1);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    n5.next = n6;
    n6.next = n7;
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
