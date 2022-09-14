package com.sparta.maddy;

import com.sparta.maddy.models.RandomArrays;
import com.sparta.maddy.models.interfaces.Sorter;
import com.sparta.maddy.models.sorters.ArrayMergeSort;
import com.sparta.maddy.view.DisplayManager;

public class Main {
    public static void main(String[] args) {
        RandomArrays randomArrays = new RandomArrays();
        int[] testArray = randomArrays.generateRandomIntArray();
        Sorter sorter = new ArrayMergeSort();

        int[] sortedArray = sorter.sortArray(testArray);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }

//        DisplayManager displayManager = new DisplayManager();
//
//        displayManager.menu();
    }
}
