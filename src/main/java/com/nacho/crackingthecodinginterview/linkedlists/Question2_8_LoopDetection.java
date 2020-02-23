package com.nacho.crackingthecodinginterview.linkedlists;

import java.util.HashSet;
import java.util.Set;

/**
 * Chapter 2 - Linked lists
 *
 * Given a linked list, detect if there's a loop and return the node at the begining of that loop. <br>
 *
 * The fist solution i came up with was to have a Set to accumulate the nodes and on each step, check if the "next" is present there. If it
 * is, there's a loop and that's also the begining.
 *
 * The book proposes a more "logical" solution rather than one based on an additional data structure. Have 2 runners: slow and fast. The
 * slow would move one node at a time while the fast will move 2 nodes at a time. When they meet, there's a loop. <br>
 * In order to find the beginning of the loop: <br>
 * 1- Move the slow to the head <br>
 * 2- Move the slow and fast one node at a time. <br>
 * 3- When they meet again, that's the beginning of the loop. <br>
 *
 */
public class Question2_8_LoopDetection {

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
    final Node n1 = new Node(1);
    final Node n2 = new Node(2);
    final Node n3 = new Node(3);
    final Node n4 = new Node(4);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n2;

    final Node loopBegin = detectLoopWithSet(n1);
    System.out.println("Loop with set: " + loopBegin);

    final Node loopBegin2 = detectLoopWithRunners(n1);
    System.out.println("Loop with runners: " + loopBegin2);
  }

  private static Node detectLoopWithRunners(final Node root) {
    Node slowRunner = root;
    Node fastRunner = root;
    while (fastRunner != null && fastRunner.next != null) {
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next.next;
      if (slowRunner == fastRunner) {
        break;
      }
    }
    if (fastRunner == null || fastRunner.next == null) {
      return null;
    }
    slowRunner = root;
    while (slowRunner != fastRunner) {
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next;
    }
    return slowRunner; // any of them would do.
  }

  private static Node detectLoopWithSet(final Node root) {
    final Node runner = root;
    final Set<Node> previousNodes = new HashSet<>();
    while (runner.next != null) {
      if (previousNodes.contains(runner)) {
        return runner.next;
      }
      previousNodes.add(runner);
    }

    return null;
  }
}
