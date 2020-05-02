package com.nacho.random;

import java.util.Stack;

public class ReverseWordsInSentence {

  public static void main(final String[] args) {
    final String sentence = "Hi! My name is (what?) My name is (who?) My name is Slim Shady";
    reverseSentence(sentence);
  }

  private static void reverseSentence(final String sentence) {
    final String[] split = sentence.split("\\s+");

    final StringBuilder sbFor = new StringBuilder();
    for (int i = split.length - 1; i >= 0; i--) {
      sbFor.append(split[i]).append(" ");
    }
    System.out.println(sbFor);

    ///////////////////////////////////////////////

    System.out.println("=".repeat(sentence.length()));

    /////////////////////////////////////////////

    final StringBuilder sbStack = new StringBuilder();
    final Stack<String> s = new Stack<>();
    for (final String w : split) {
      s.push(w);
    }
    while (!s.isEmpty()) {
      sbStack.append(s.pop()).append(" ");
    }
    System.out.println(sbStack);
  }
}
