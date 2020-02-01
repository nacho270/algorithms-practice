package com.nacho.random;

import java.util.Stack;

/**
 * Write a balancedParenthesis function that takes a string as input and returns
 * a boolean if the parentheses in the input string are "balanced", then return
 * true, else return false.
 *
 * For example, the program should print true for exp = "[()]{}{[()()]()}" and
 * false for exp = "[(])" Time complexity: O(n) where n is the length of string
 * Space complexity: O(n^2) where n is length of string
 *
 */
public class BalancedParenthesis {

	private static boolean isBalanced(final String str) {
		final Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
				stack.push(str.charAt(i));
			} else {
				final Character lastOpenElement = stack.peek();
				if (isOpposite(lastOpenElement, str.charAt(i))) {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	private static boolean isOpposite(final Character lastChar, final Character ch) {
		return lastChar.equals('(') && ch.equals(')') || //
				lastChar.equals('[') && ch.equals(']') || //
				lastChar.equals('{') && ch.equals('}');
	}

	public static void main(final String[] args) {
		System.out.println(isBalanced("[()]{}{[()()]()}"));
		System.out.println(isBalanced("[(])"));
	}
}
