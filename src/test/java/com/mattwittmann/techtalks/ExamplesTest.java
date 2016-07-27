package com.mattwittmann.techtalks;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExamplesTest {
    @Test
    public void verifyRemoveTomatoesRemovesAllTomatoes() {
        List<String> originalIngredients = asList("tomatoes", "apples", "pear", "tomato", "grape", "tomato", "tomato",
                                                  "nectarines");
        List<String> correctedIngredients = asList("apples", "pear", "grape", "nectarines");
        assertThat(Examples.removeTomatoes(originalIngredients), is(equalTo(correctedIngredients)));
    }

    @Test
    public void verifySquareThenSumSquaresThenSums() {
        long[] numbers = { 1, 8, 3, 0, 2, -20 };
        assertThat(Examples.squareThenSum(numbers), is(equalTo(478l)));
    }

    @Test
    public void verifyMultiplyAllMulipliesEveryNumberTogether() {
        long[] numbers = { 1, 8, 3, 2, -20 };
        assertThat(Examples.multiplyAll(numbers), is(equalTo(-960l)));
    }

    @Test
    public void verifyMultiplyAllReturnsZeroWhenGivenNoNumbers() {
        long[] numbers = {};
        assertThat(Examples.multiplyAll(numbers), is(equalTo(0l)));
    }
}