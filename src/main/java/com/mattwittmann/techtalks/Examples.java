package com.mattwittmann.techtalks;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

public class Examples {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3 };

        Arrays.stream(numbers)
                .map(number -> ++number)
                .forEach(System.out::println);

        Arrays.stream(numbers)
                .map(number -> {
                    return ++number;
                })
                .forEach(System.out::println);

        Arrays.stream(numbers)
                .map(new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int number) {
                        return ++number;
                    }
                })
                .forEach(System.out::println);


        for (int number : numbers) {
            ++number;
            System.out.println(number);
        }
    }

    /**
     * Demonstrates {@link java.util.stream.Stream#filter}.
     */
    static List<String> removeTomatoes(List<String> fruits) {
        return fruits.stream()
                     .filter(fruit -> !fruit.startsWith("tomato"))
                     .collect(Collectors.toList());
    }

    /**
     * Demonstrates {@link java.util.stream.LongStream#map} and
     * {@link java.util.stream.LongStream#sum}, a kind of reduction.
     */
    static long squareThenSum(long[] numbers) {
        return Arrays.stream(numbers)
                     .map(Examples::square)
                     .sum();
    }

    private static long square(long number) {
        return number * number;
    }

    /**
     * Demonstrates {@link java.util.stream.LongStream#reduce} and supplying a
     * default value from an {@link java.util.OptionalLong}.
     */
    static long multiplyAll(long[] numbers) {
        return Arrays.stream(numbers)
                     .reduce((left, right) -> left * right)
                     .orElse(0);
    }

    /**
     * Demonstrates {@link java.util.stream.Stream#flatMap}.
     */
    static List<String> say(List<String> what, List<String> who) {
        return who.stream()
                  .flatMap(name -> what.stream()
                                       .map(sentence -> String.format(sentence, name)))
                  .collect(Collectors.toList());
    }
}
