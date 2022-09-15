package com.sparta.maddy.controllers;

import com.sparta.maddy.models.enums.SorterType;
import com.sparta.maddy.models.RandomArrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortManager {

    Logger logger = LogManager.getLogger(SortManager.class);
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

    public int[] sortArray(SorterType sorterType, int[] arrayToBeSorted) {
        return sorterType.getSortType().sortArray(arrayToBeSorted);
    }

    public long runTime(long startTimeInNano, long endTimeInNano) {
        if (endTimeInNano > startTimeInNano) {
            return endTimeInNano - startTimeInNano;
        } else {
            return -1;
        }
    }

}
