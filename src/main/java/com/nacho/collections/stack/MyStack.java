package com.nacho.collections.stack;

public interface MyStack<T> {

	void push(final T valueToAdd);

	T pop();

	T peek();

	void print();
}
