package com.sparta.controllers;

import com.sparta.controllers.interfaces.Sorter;
import com.sparta.controllers.sorters.ArrayBinarySort;
import com.sparta.controllers.sorters.ArrayBubbleSort;
import com.sparta.controllers.sorters.ArrayMergeSort;
import com.sparta.models.RandomArrays;

public class SortManager {

    RandomArrays randomiser = new RandomArrays();
    Sorter sorter;

    public int[] generateRandomArray() {
        return randomiser.generateRandomIntArray();
    }

    public int[] generateRandomArrayWithLength(int length) {
        return randomiser.generateRandomIntArrayLength(length);
    }

    public int[] sort(int[] inputArray, Sorter sorterType) {
        sorter = sorterType;
        if (sorterType == null) {
            return null;
        }
        if (inputArray.length == 0) {
            return new int[0];
        }
        return sorter.sortArray(inputArray);
    }

    public Sorter sorterType(int i) {
        if (i > 3 || i < 1) {
            return null;
        }
        if (i == 1) {
            return new ArrayBinarySort();
        }
        if (i == 2) {
            return new ArrayBubbleSort();
        }
        if (i == 3) {
            return new ArrayMergeSort();
        }
        return null;
    }
}
