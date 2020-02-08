package com.nacho.collections.queue;

public class MyQueueWithLinkedList<T> implements MyQueue<T> {

	private Node root;

	@Override
	public void enque(final T valueToAdd) {
		if (root == null) {
			root = new Node(valueToAdd);
			return;
		}
		final Node newNode = new Node(valueToAdd);
		newNode.next = root;
		root = newNode;
	}

	@Override
	public T poll() {
		Node temp = root;
		while (temp.next.next != null) {
			temp = temp.next;
		}

		final T value = temp.next.value;
		temp.next = null;
		return value;
	}

	@Override
	public T peek() {
		Node temp = root;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp.value;
	}

	@Override
	public void print() {
		System.out.println("=======");
		Node temp = root;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	private class Node {
		private T value;
		private Node next;

		public Node(final T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}
}
