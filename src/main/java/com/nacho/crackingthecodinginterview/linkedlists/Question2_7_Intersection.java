package com.nacho.crackingthecodinginterview.linkedlists;

import java.util.HashSet;
import java.util.Set;

/**
 * Chapter 2 - Linked lists
 *
 * Given 2 linked lists, determine if they intersect and return the intersection node.<br>
 * The interception is BY REFERENCE, not value. <br>
 *
 * To me this is a straightforward approach. However, the book proposes this and another solution. <br>
 * <br>
 * <br>
 * I didn't understand the problem the way the author was expecting. <br>
 * I understood this: <br>
 * ......... 5 <br>
 * ......... | <br>
 * ......... 4 <br>
 * ......... | <br>
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6<br>
 * ......... | <br>
 * ......... 2 <br>
 * ......... | <br>
 * ......... 1 <br>
 *
 * The example provided in the solutions of the book is something like this: <br>
 *
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6 <br>
 * .................. / <br>
 * ........ 12 -> 15 / <br>
 *
 * Both lists have the same ending. So basically it was a matter of determining the size and ending of both.<br>
 *
 * If they don't end with the same node, they do not intersect. <br>
 *
 * If they end with the same, traverse both from the begining until finding the shared node.<br>
 * <br>
 * Note: Their length could be different, so the idea is to have 2 runner pointers, determine which list is the shorter and move the longer
 * list runner pointer K places forward so they distance between the starting point of both and the shared node is the same. <br>
 *
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6 <br>
 * .................. / <br>
 * ........ 12 -> 15 / <br>
 *
 * In this case, move the List1 runner pointer to node 3 so then you move both pointers one node at a time. And once both runner ponters
 * match, there's the intersection.
 *
 * -3 -> 4 -> 5 -> 6 <br>
 * ......... / <br>
 * 12 -> 15 / <br>
 *
 */
public class Question2_7_Intersection {

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

  private static Node intersection(final Node root1, final Node root2) {
    Node runner1 = root1;
    final Set<Node> list1Refs = new HashSet<>();
    while (runner1 != null) {
      list1Refs.add(runner1);
      runner1 = runner1.next;
    }

    Node runner2 = root2;
    while (runner2 != null) {
      if (list1Refs.contains(runner2)) {
        return runner2;
      }
      runner2 = runner2.next;
    }

    return null;
  }

  public static void main(final String[] args) {
    final Node n11 = new Node(1);
    final Node n12 = new Node(2);
    final Node n13 = new Node(3);
    final Node n14 = new Node(4);
    n11.next = n12;
    n12.next = n13;
    n13.next = n14;

    final Node n21 = new Node(5);
    final Node n22 = new Node(4);
    n21.next = n22;
    n22.next = n13; // shared node

    final Node n31 = new Node(5);
    final Node n32 = new Node(4);
    n31.next = n32;

    final Node intersect1 = intersection(n11, n21);
    System.out.println("Intersect: " + intersect1);

    final Node intersect2 = intersection(n11, n31);
    System.out.println("Intersect: " + intersect2);
  }
}
