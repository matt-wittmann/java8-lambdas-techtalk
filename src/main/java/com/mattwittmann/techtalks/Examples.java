package com.mattwittmann.techtalks;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

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
}
