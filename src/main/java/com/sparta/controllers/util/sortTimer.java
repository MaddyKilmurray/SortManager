package com.sparta.controllers.util;

import com.sparta.controllers.interfaces.Sorter;
import com.sparta.models.RandomArrays;

import java.util.ArrayList;
import java.util.List;

public class sortTimer {

    RandomArrays randomiser = new RandomArrays();

    public long sortTime(Sorter sorter) {
        List<Long> times = new ArrayList<>();

        long start;
        long finish;

        int[] randomIntArray;

        int timeSum = 0;

        for (int i = 0; i < 150; i++) {
            randomIntArray = randomiser.generateRandomIntArray();
            start = System.nanoTime();
            randomIntArray = sorter.sortArray(randomIntArray);
            finish = System.nanoTime();
            times.add(finish - start);
        }

        for (int j = 0; j < times.size(); j++) {
            timeSum += times.get(j);
        }
        return (timeSum / times.size());
    }
}
