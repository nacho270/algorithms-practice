package com.nacho.crackingthecodinginterview.treesandgraphs;

import java.util.LinkedList;

/**
 * Given a directed graph and 2 nodes (S, E) that belong to the graph, determin if there's a route between them.<br>
 * Start from S and to the end E. <br>
 * A BFS-like traverse where, starting from S, all children are visited and compared to E.<br>
 * Need to add the "visited" flag to each node to avoid circular dependencies<br>
 */
public class Question4_1_RouteBetweenNodes {

  static boolean routeFromAToB(final Graph graph, final Node S, final Node E) {
    if (S == E) {
      return true;
    }
    final LinkedList<Node> queue = new LinkedList<>();
    S.visited = true;
    queue.add(S);
    while (!queue.isEmpty()) {
      final Node node = queue.removeFirst();
      for (final Node c : node.children) {
        if (!c.visited) {
          if (c == E) {
            return true;
          }
          c.visited = true;
          queue.add(c);
        }
      }
    }
    return false;
  }

  class Node {
    boolean visited = false;
    String data;
    Node[] children;
  }

  class Graph {
    Node[] nodes;
  }
}
