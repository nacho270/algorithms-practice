package com.nacho.collections.stack;

public class MainMyStack {

	public static void main(final String[] args) {
		final MyStack<Integer> stack = new MyStackWithArray<>();
		stack.push(5);
		stack.push(10);
		stack.push(200);
		stack.print();
		System.out.println("peek: " + stack.peek());
		stack.print();
		System.out.println("Pop: " + stack.pop());
		stack.print();
	}
}
