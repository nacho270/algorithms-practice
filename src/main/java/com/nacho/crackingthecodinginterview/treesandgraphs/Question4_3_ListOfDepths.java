package com.nacho.crackingthecodinginterview.treesandgraphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, create a linked list of the nodes at each depth.
 *
 * ......................1 <br>
 * ....................2...3<br>
 * ..................4..5...6..7<br>
 * ...............8..9..10..11..12<br>
 * <br>
 * <br>
 * ...............1 -> [1]<br>
 * ...............2 -> [2, 3]<br>
 *
 * Written required implementation and another one with Map<Level, List<Node>>
 */
public class Question4_3_ListOfDepths {

  static List<List<Node>> listOfDepths(final Node root) {
    final List<List<Node>> lists = new LinkedList<>();
    internalListOfDepths(lists, root, 0);
    return lists;
  }

  private static void internalListOfDepths(final List<List<Node>> lists, final Node root, final int level) {
    if (root == null) {
      return;
    }
    List<Node> levelList = null;
    if (lists.size() == level) {
      levelList = new LinkedList<>();
      lists.add(levelList);
    } else {
      levelList = lists.get(level);
    }
    levelList.add(root);
    internalListOfDepths(lists, root.left, level + 1);
    internalListOfDepths(lists, root.right, level + 1);
  }

  static Map<Integer, List<Node>> mapOfDepths(final Node root) {
    final Map<Integer, List<Node>> levelMap = new HashMap<>();

    final LinkedList<Node> list = new LinkedList<>();
    list.add(root);
    levelMap.put(0, list);

    internalMapOfDepths(levelMap, 0);
    return levelMap;
  }

  private static void internalMapOfDepths(final Map<Integer, List<Node>> hashMap, final int level) {
    final List<Node> nodes = hashMap.get(level);
    final List<Node> newList = new LinkedList<>();
    for (final Node n : nodes) {
      if (n.left != null) {
        newList.add(n.left);
      }
      if (n.right != null) {
        newList.add(n.right);
      }
    }
    if (!newList.isEmpty()) {
      hashMap.put(level + 1, newList);
      internalMapOfDepths(hashMap, level + 1);
    }
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

  public static void main(final String[] args) {
    final Node n1 = new Node(1);
    final Node n2 = new Node(2);
    final Node n3 = new Node(3);
    final Node n4 = new Node(4);
    final Node n5 = new Node(5);
    final Node n6 = new Node(6);
    final Node n7 = new Node(7);

    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
    n3.left = n6;
    n3.right = n7;

    System.out.println(mapOfDepths(n1));
    System.out.println(listOfDepths(n1));

  }
}
