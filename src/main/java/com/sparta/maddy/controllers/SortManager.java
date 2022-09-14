package com.sparta.maddy.controllers;

import com.sparta.maddy.models.enums.SorterType;
import com.sparta.maddy.models.interfaces.Sorter;
import com.sparta.maddy.models.sorters.ArrayBinarySort;
import com.sparta.maddy.models.sorters.ArrayBubbleSort;
import com.sparta.maddy.models.sorters.ArrayMergeSort;
import com.sparta.maddy.models.RandomArrays;

public class SortManager {

    RandomArrays randomiser = new RandomArrays();

    public int[] generateRandomArray() {
        return randomiser.generateRandomIntArray();
    }

    public int[] generateRandomArrayWithLength(int length) {
        return randomiser.generateRandomIntArrayLength(length);
    }

    public SorterType sorterType(int i) {
        SorterType sorter = SorterType.getById(i);
        if (sorter != null) {
            return sorter;
        }
        return null;
    }

}
