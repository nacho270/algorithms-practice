package com.nacho.random;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class BinaryOperatorExample {

    public static <T> BinaryOperator<T> toOnlyelement() {
        return toOnlyelementThrowing(IllegalArgumentException::new);
    }

    public static <T, E extends RuntimeException> BinaryOperator<T> toOnlyelementThrowing(final Supplier<E> exception) {
        return (element, otherElement) -> {
            throw exception.get();
        };
    }

    public static Optional<Integer> find(final List<Integer> list) {
        return list.stream().filter(i -> i == 5).reduce(toOnlyelement());
    }

    public static void main(final String[] args) {
        System.out.println(find(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
