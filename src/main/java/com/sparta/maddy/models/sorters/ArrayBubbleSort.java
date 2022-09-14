package com.sparta.maddy.models.sorters;

import com.sparta.maddy.controllers.util.DuplicateRemover;
import com.sparta.maddy.models.interfaces.Sorter;

public class ArrayBubbleSort implements Sorter {

    DuplicateRemover duplicateRemover = new DuplicateRemover();

    @Override
    public int[] sortArray(int[] arrayToSort) {
        arrayToSort = duplicateRemover.removeDuplicates(arrayToSort);
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
