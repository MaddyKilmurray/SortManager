package com.sparta.sorters;

import com.sparta.interfaces.Sorter;

public class ArrayBinarySort implements Sorter {
    @Override
    public int[] sortArray(int[] arrayToSort) {
        boolean swapped = true;
        int start = 0;
        int end = arrayToSort.length;
        while (swapped == true) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
            swapped = false;
            end = end - 1;
            for (int i = end - 1; i >= start; i--) {
                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    int temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[i + 1];
                    arrayToSort[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
        return arrayToSort;
    }
}
