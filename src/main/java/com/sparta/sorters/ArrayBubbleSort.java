package com.sparta.sorters;

import com.sparta.interfaces.Sorter;

public class ArrayBubbleSort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        if (arrayToSort == null) {
            return new int[0];
        }
        int counter = 0;
        do {
            for (int i = 0; i < arrayToSort.length; i++) {
                counter = 0;
                for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                    if (arrayToSort[j] > arrayToSort[j + 1]) {
                        int temp = arrayToSort[j];
                        arrayToSort[j] = arrayToSort[j + 1];
                        arrayToSort[j + 1] = temp;
                        counter++;
                    }
                }
            }
        } while (counter != 0);
        return arrayToSort;
    }
}
