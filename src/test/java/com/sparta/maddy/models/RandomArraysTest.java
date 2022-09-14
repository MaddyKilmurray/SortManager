package com.sparta.maddy.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomArraysTest {

    RandomArrays randomiser;

    @BeforeEach
    public void setup() {
        randomiser = new RandomArrays();
    }

    @Test
    public void generateRandomIntArrayLength_LengthZero() {
        int[] testArray = randomiser.generateRandomIntArrayLength(0);
        Assertions.assertNull(testArray);
    }

}
