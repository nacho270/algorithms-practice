package com.nacho.crackingthecodinginterview.linkedlists;

/**
 * Chapter 2 - Linked lists
 *
 * find the Kth to last element in a linked list
 */
public class Question2_2_KthToLastElement {

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

  private static int findKToLast(final Node root, final int k) {
    Node p1 = root;
    Node p2 = root;

    for (int i = 0; i <= k; i++) { // move p1 K places
      if (p1 == null) {
        return -1;
      }
      p1 = p1.next;
    }
    while (p1 != null) { // move both pointers until the end of the list. p1 will start K places ahead
      p1 = p1.next;
      p2 = p2.next;
    }
    // when p1 reaches the end, p2 will be K places behind
    return p2.value;
  }

  /*
   * I thought on storing chunks of K size while i move forward on the list. When the list finishes, there would be a chunk of size K where
   * chunk[0] would be the Kth to last. It needs a collection of size K that when something new is added, the first element is dropped. It
   * could be done with an array by shifting all elemenents back 1 place on every addtion. It's too much trouble.
   *
   * This used to be by initial approach until i realized about shiffing the elements.
   *
   * final int size = k; final int[] chunk = new int[size]; Node t = root; int count = 0; while (t != null) { chunk[count % size] = t.value;
   * count++; t = t.next; } return chunk[0];
   */

  public static void main(final String[] args) {
    final Node root = createList();
    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
    System.out.println("find 1 to last: " + findKToLast(root, 1)); // 7
    System.out.println("find 2 to last: " + findKToLast(root, 2)); // 6
    System.out.println("find 3 to last: " + findKToLast(root, 3)); // 5
    System.out.println("find 4 to last: " + findKToLast(root, 4)); // 4
    System.out.println("find 5 to last: " + findKToLast(root, 5)); // 3
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

}
