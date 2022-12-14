package com.sparta.maddy.controllers.util;

import com.sparta.maddy.models.interfaces.Sorter;
import com.sparta.maddy.models.RandomArrays;

import java.util.ArrayList;
import java.util.List;

public class SortTimer {

    List<Long> times;
    RandomArrays randomiser = new RandomArrays();

    public long sortTime(Sorter sorter) {
        times = new ArrayList<>();

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

    public long sortTimeCustomLength(Sorter sorter, int length) {
        times = new ArrayList<>();

        long start;
        long finish;

        int[] randomIntArray;

        int timeSum = 0;

        for (int i = 0; i < 150; i++) {
            randomIntArray = randomiser.generateRandomIntArrayLength(length);
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

    public long sortTimeInNano() {
        return System.nanoTime();
    }
}
