package com.nacho.crackingthecodinginterview.linkedlists;

/**
 * Chapter 2 - Linked lists
 *
 * Given 2 lists representing one number (1 digit per node), return a new list with the sum. The lists start with the LESS significant
 * value:
 *
 * Ex: <br>
 * 7 -> 1 -> 6 (617) <br>
 * 5 -> 9 -> 2 (295) <br>
 *
 * Result: 2 -> 1 -> 9 (912) <br>
 *
 * Then do the same but starting with MOST significant value <br>
 *
 * Ex: <br>
 * 6 -> 1 -> 7 (617) <br>
 * 2 -> 9 -> 5 (295) <br>
 *
 * Result: 9 -> 1 -> 2 (912)
 *
 */
public class Question2_5_SumList {

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

    final Node l1 = createList(7, 1, 6);
    final Node l2 = createList(5, 9, 2);
    print(sumLessSignificantFirst(l1, l2)); // 2 -> 1 -> 9
    System.out.println("====");
    final Node l3 = createList(6, 1, 7);
    final Node l4 = createList(2, 9, 5);
    print(sumMostSignificantFirst(l3, l4)); // 2 -> 1 -> 9
    System.out.println("====");
    final Node l5 = createList(6, 1, 7);
    final Node l6 = createList(8, 9, 5);
    print(sumMostSignificantFirst(l5, l6)); // 2 -> 1 -> 5 -> 1

  }

  private static Node sumMostSignificantFirst(final Node l3, final Node l4) {
    // if the lengths are different, we would need to pad with zero the shorter list... no different length assumed
    Node rl3 = l3;
    Node rl4 = l4;
    Node lsum = null;
    Node rsum = null;
    int carry = 0;
    boolean first = true;
    while (rl3 != null && rl4 != null) {
      final int nextSum = safeGetNextValue(rl3) + safeGetNextValue(rl4);
      int sum = rl3.value + rl4.value + (nextSum > 9 ? 1 : 0) + carry;
      if (sum > 9 && !first) {
        sum = sum % 10;
        carry = sum / 10;
      }
      if (first && sum > 9) {
        final Node newNode = new Node(sum / 10);
        final Node newNode2 = new Node(sum % 10);
        lsum = newNode2;
        lsum.next = newNode;
      } else {
        final Node newNode = new Node(sum);
        if (lsum == null) {
          lsum = newNode;
        } else {
          newNode.next = rsum;
          lsum = newNode;
        }
      }
      rsum = lsum;
      first = false;
      rl3 = rl3.next;
      rl4 = rl4.next;
    }

    return lsum;
  }

  private static int safeGetNextValue(final Node n) {
    if (n.next != null) {
      return n.next.value;
    }
    return 0;
  }

  private static Node sumLessSignificantFirst(final Node l1, final Node l2) {
    Node rl1 = l1;
    Node rl2 = l2;
    Node lsum = null;
    Node rsum = null;
    int carry = 0;
    while (rl1 != null && rl2 != null) {
      int sum = rl1.value + rl2.value + carry;
      carry = 0;
      if (sum > 9) {
        carry = 1;
        sum = sum % 10;
      }
      final Node newNode = new Node(sum);
      if (lsum == null) {
        lsum = newNode;
        rsum = lsum;
      } else {
        rsum.next = newNode;
        rsum = rsum.next;
      }
      rl1 = rl1.next;
      rl2 = rl2.next;
    }
    if (carry > 0) {
      final Node carryNode = new Node(carry);
      rsum.next = carryNode;
    }
    return lsum;
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
