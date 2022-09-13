package com.sparta.models;

import java.util.Random;

public class RandomArrays {

    Random random = new Random();

    public int[] generateRandomIntArray() {
        int[] newInt = new int[50];
        for (int i = 0; i < newInt.length; i++) {
            newInt[i] = random.nextInt(150);
        }
        return newInt;
    }

    public int[] generateRandomIntArrayLength(int length) {
        int[] newInt = new int[length];
        for (int i = 0; i < newInt.length; i++) {
            newInt[i] = random.nextInt(150);
        }
        return newInt;
    }
}
